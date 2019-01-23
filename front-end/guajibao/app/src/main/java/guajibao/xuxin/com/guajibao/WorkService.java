package guajibao.xuxin.com.guajibao;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Users.SystemData;
import bean.App;
import okhttp3.MediaType;
import tools.AnalysisApkUtils;
import tools.ApkController;
import top.wuhaojie.installerlibrary.AutoInstaller;

public class WorkService extends IntentService {
    App a = null;


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public WorkService() {
        super("WorkService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //耗时操作
        while (SystemData.WORK_STATUE) {
            check();
            String format = "HH:mm:ss";
            boolean isintime = false;
            try {
                boolean isinfirstday=false;
                boolean isinsecond=false;
                Date nowTime = new Date();
                nowTime = new SimpleDateFormat(format).parse(new SimpleDateFormat(format).format(nowTime));
                Date startTime = new SimpleDateFormat(format).parse(SystemData.getIntstent().getNoincometime().getStarttime());
                Date endTime=new SimpleDateFormat(format).parse("23:59:59");
                isinfirstday=isEffectiveDate(nowTime, startTime, endTime);
                startTime=new SimpleDateFormat(format).parse("00:00:00");
                endTime = new SimpleDateFormat(format).parse(SystemData.getIntstent().getNoincometime().getEndtime());
                isinsecond=isEffectiveDate(nowTime,startTime,endTime);
                if(isinfirstday || isinsecond){
                    isintime=true;
                }else{
                    isintime=false;
                }

                /*
                Calendar c = Calendar.getInstance();
                c.setTime(endTime);
                c.add(Calendar.DAY_OF_MONTH, 1);
                endTime = c.getTime();
                */

            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (isintime == true) {
                EventBus.getDefault().post("等待发放");
                try {
                    Thread.sleep(600000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

            EventBus.getDefault().post("下载开始");
            OkGo.<String>get(SystemData.BASEURL + "/api/getapprand.php").execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    a = JSON.parseObject(response.body(), App.class);
                    download(a.getLink());
                }
            });
            try {
                int tmp = 60;
                if (SystemData.getIntstent().getCricletime() != null) {
                    tmp = Integer.parseInt(SystemData.getIntstent().getCricletime().getCricletime());
                }
                tmp = tmp * 60000;
                Thread.sleep(tmp);
            } catch (InterruptedException e) {
                return;
            }

        }


    }

    private void download(String url) {
        OkGo.<File>get(url).execute(new FileCallback("test.apk") {
            @Override
            public void onSuccess(Response<File> response) {
                // EventBus.getDefault().post("下载完成:"+response.body().getAbsolutePath());

                Toast.makeText(getApplicationContext(), "下载完成", Toast.LENGTH_LONG).show();

                AutoInstaller installer = new AutoInstaller.Builder(getApplication())
                        .setMode(AutoInstaller.MODE.ROOT_ONLY)
                        .build();
                final String filepath = response.body().getAbsolutePath();
                String[] strings = AnalysisApkUtils.analysisApk(filepath);
                final String packagename = strings[1];
                installer.setOnStateChangedListener(new AutoInstaller.OnStateChangedListener() {
                    @Override
                    public void onStart() {
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(getApplicationContext(), "安装成功", Toast.LENGTH_LONG).show();
                        check();
                        addmoeny(SystemData.getIntstent().getUserInfo().getUsername(), a.getTitle(), a.getPrice());
                        EventBus.getDefault().post("打开app:" + packagename);
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            return;
                        }
                        ApkController.uninstall(packagename, getApplicationContext());
                        Intent dialogIntent = new Intent(getBaseContext(), MapActivity.class);
                        dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getApplication().startActivity(dialogIntent);
                    }

                    @Override
                    public void onNeed2OpenService() {

                    }
                });
                installer.install(filepath);

            }

            @Override
            public void downloadProgress(Progress progress) {
                super.downloadProgress(progress);
                EventBus.getDefault().post("已下载：" + progress.fraction * 100 + "%");
            }
        });


    }

    private void addmoeny(String username, String appname, String price) {
        String data = "username=" + username + "&appname=" + appname + "&price=" + price;
        OkGo.<String>post(SystemData.BASEURL + "/api/addcommissionrecord.php").upString(data, MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {

            }
        });

    }

    public static void check() {
        String data = "username=" + SystemData.getIntstent().getUserInfo().getUsername() + "&token=" + SystemData.getIntstent().getUserInfo().getToken();
        OkGo.<String>post(SystemData.BASEURL + "/api/check.php").upString(data, MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String str = response.body().trim();
                if ("2".equals(str)) {
                    EventBus.getDefault().post("冻结");
                } else if ("failed".equals(str)) {//验证不通过，踢下线
                    EventBus.getDefault().post("踢下线");
                }
            }
        });
    }

    private boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        //设置当前时间
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
//设置开始时间
        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);
//设置结束时间
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        //处于开始时间之后，和结束时间之前的判断
        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

}
