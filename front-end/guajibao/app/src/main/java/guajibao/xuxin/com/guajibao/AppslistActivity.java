package guajibao.xuxin.com.guajibao;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.greenrobot.eventbus.EventBus;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Users.SystemData;
import bean.App;
import bean.Noincometime;
import bean.RealApp;
import es.dmoral.toasty.Toasty;
import okhttp3.MediaType;

public class AppslistActivity extends AppCompatActivity {
    private int currentitem=0;
    private int maxitemcount;
    private ListView listView;
    public static Thread workthread;
    private boolean isonly=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appslist);
       // updataappslist();
        init();
        if(workthread==null){
            workthread= new Thread(new Runnable() {
                @Override
                public void run() {
                   //原写法
                    //updataappslist();
                    /*
                    修改
                     */
                    while(SystemData.WORK_STATUE){
                        updataappslist();
                        try {
                            int tmp = 60;
                            if (SystemData.getIntstent().getCricletime() != null) {
                                tmp = Integer.parseInt(SystemData.getIntstent().getCricletime().getCricletime());
                            }
                            tmp = (tmp+1) * 60000;
                            Thread.sleep(tmp);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            workthread.start();
        }else{
            isonly=false;
            updataappslist();
        }


    }

    private void init() {

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Toasty.Config.getInstance().setSuccessColor(Color.parseColor("#FF9551")).setTextSize(30).apply();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    private void work() {
        //判断是不是在工作区间
        WorkService.check();
        String format = "HH:mm:ss";
        boolean isintime = false;

        try {
            boolean isinfirstday = false;
            boolean isinsecond = false;
            Date nowTime = new Date();
            nowTime = new SimpleDateFormat(format).parse(new SimpleDateFormat(format).format(nowTime));
            Date startTime = new SimpleDateFormat(format).parse(SystemData.getIntstent().getNoincometime().getStarttime());
            Date endTime = new SimpleDateFormat(format).parse("23:59:59");
            isinfirstday = isEffectiveDate(nowTime, startTime, endTime);
            startTime = new SimpleDateFormat(format).parse("00:00:00");
            endTime = new SimpleDateFormat(format).parse(SystemData.getIntstent().getNoincometime().getEndtime());
            isinsecond = isEffectiveDate(nowTime, startTime, endTime);
            if (isinfirstday || isinsecond) {
                isintime = true;
            } else {
                isintime = false;
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
        if (isintime == true) {//如果在无收益时间。显示等待发放，不执行
            EventBus.getDefault().post("等待发放");
            /* 原写法
            TimerTask task=new TimerTask() {
                @Override
                public void run() {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            updataappslist();
                        }
                    }).start();
                }
            };
            Timer timer=new Timer();
            timer.schedule(task,60000);
            */
            return;
        }
        //正常操作

        //抢单（获得app）
        if(SystemData.WORK_STATUE && isintime==false){
        String data = "username=" + SystemData.getIntstent().getUserInfo().getUsername();
        OkGo.<String>post(SystemData.BASEURL + "/api/getapprand.php").upString(data, MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if(isJSONValid(response.body())) {//抢单成功
                    final RealApp realApp = JSON.parseObject(response.body(), RealApp.class);
                    showmytoast("任务已领取成功");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(SystemData.WORK_STATUE){
                           // Toast.makeText(AppslistActivity.this, "云服务器安装中", Toast.LENGTH_LONG).show();
                                showmytoast("云服务器安装中");
                            }
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if(SystemData.WORK_STATUE){
                                      showmytoast("安装完毕，试玩等待中");
                                    }
                                    //Toast.makeText(AppslistActivity.this, "安装完毕，试玩等待中", Toast.LENGTH_LONG).show();
                                    OkGo.<Bitmap>get(realApp.getImg()).execute(new BitmapCallback() {
                                        @Override
                                        public void onSuccess(Response<Bitmap> response) {
                                            Bitmap bitmap = response.body();
                                            byte[] result;
                                            ByteArrayOutputStream output = new ByteArrayOutputStream();//初始化一个流对象
                                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);//把bitmap100%高质量压缩 到 output对象里
                                            result = output.toByteArray();//转换成功了  result就是一个bit的资源数组
                                            final Intent intent = new Intent(AppslistActivity.this, DisplayappActivity.class);
                                            intent.putExtra("img", result);
                                            new Handler().postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    if (SystemData.WORK_STATUE){
                                                        startActivity(intent);
                                                    addmoeny(SystemData.getIntstent().getUserInfo().getUsername(), realApp.getAppname(), realApp.getPrice());
                                                    isonly=true;
                                                    listView.setSelection(currentitem);
                                                    if(currentitem==maxitemcount-1){
                                                            currentitem=0; }
                                                    if(currentitem<maxitemcount-1){
                                                        currentitem++;
                                                    }
                                                    /*
                                                    int tmp = 60;
                                                    if (SystemData.getIntstent().getCricletime() != null) {
                                                        tmp = Integer.parseInt(SystemData.getIntstent().getCricletime().getCricletime());
                                                    }
                                                    tmp = tmp * 60000;
                                                    new Handler().postDelayed(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            new Thread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    updataappslist();
                                                                }
                                                            }).start();
                                                            return;

                                                        }
                                                    }, tmp);
                                                    return;
                                                    */
                                                }

                                                return ;}
                                            }, 2000);
                                            return;


                                        }
                                    });
                                }
                            }, 10000);
                            return;
                        }
                    }, 5000);
                    return;


                }else{
                    Toast.makeText(AppslistActivity.this,"任务等待中",Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    updataappslist();
                                }
                            }).start();
                            return;
                        }
                    },60000);
                    return;

                }

            }
        });
        }
        return;


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

    private boolean isJSONValid(String str) {
        try {
            JSON.parseObject(str);
        } catch (JSONException ex) {
            try{JSON.parseArray(str);
            return true;
            }
            catch (JSONException e) {
                return false;
            }

        }
        return true;
    }

    private void addmoeny(String username, String appname, String price) {
        String data = "username=" + username + "&appname=" + appname + "&price=" + price;
        OkGo.<String>post(SystemData.BASEURL + "/api/addcommissionrecord.php").upString(data, MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {

            }
        });

    }
    private void showmytoast(String text){
        /*
        Toast t=Toast.makeText(AppslistActivity.this, text, Toast.LENGTH_LONG);
        t.setGravity(Gravity.CENTER,0,0);
        LinearLayout layout = (LinearLayout) t.getView();
        layout.setBackgroundColor(Color.parseColor("#FFD700"));
        layout.setPadding(30,2,30,2);
        TextView textView=(TextView) layout.getChildAt(0);
        textView.setTextSize(30);
        textView.setTextColor(Color.parseColor("#ff0000"));
        t.show();
        */
       Toast t= Toasty.success(AppslistActivity.this,text,Toast.LENGTH_LONG,true);
       t.setGravity(Gravity.CENTER,0,0);
       t.show();
    }
    private  void updataappslist(){
        OkGo.<String>get(SystemData.BASEURL+"/api/getapps.php").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if(isJSONValid(response.body())){//获取apps列表成功
                    List<RealApp> apps=JSON.parseArray(response.body(),RealApp.class);
                    List<Appsitem> appsitemList=new ArrayList<Appsitem>();
                    for(RealApp t:apps){
                        Appsitem appsitem=new Appsitem(t.getAppname(),t.getContent(),t.getLogo());
                        appsitemList.add(appsitem);
                    }
                    SystemData.getIntstent().setRealapplistList(appsitemList);
                    listView = findViewById(R.id.realapplistview);
                    AppsAdapter appsAdapter = new AppsAdapter(AppslistActivity.this, R.layout.appsitem, SystemData.getIntstent().getRealapplistList());
                    maxitemcount=appsAdapter.getCount();
                    listView.setAdapter(appsAdapter);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            listView.setSelection(maxitemcount-1);
                        }
                    }, 1000);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            listView.setSelection(currentitem);
                        }
                    }, 2000);
                    if(isonly)
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            work();
                        }
                    }).start();


                }

            }
        });
        OkGo.<String>get(SystemData.BASEURL+"/api/getnoincometime.php").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Noincometime noincometime=JSON.parseObject(response.body(),Noincometime.class);
                SystemData.getIntstent().setNoincometime(noincometime);
            }
        });
    }


}