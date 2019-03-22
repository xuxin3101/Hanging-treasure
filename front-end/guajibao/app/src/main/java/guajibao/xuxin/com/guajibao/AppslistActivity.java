package guajibao.xuxin.com.guajibao;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
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
import bean.RealApp1;
import bean.RealApp1Single;
import es.dmoral.toasty.Toasty;
import okhttp3.MediaType;
import tools.ToastUtils;

public class AppslistActivity extends AppCompatActivity {
    private int currentitem=0;
    private int maxitemcount;
    private ListView listView;
    public static Thread workthread;
    private boolean isonly=true;
    static boolean isfirst=false;
    boolean isintime;
    private View view ;
    boolean isarrvemax=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appslist);
       // updataappslist();
        LayoutInflater inflater = getLayoutInflater();
        view=inflater.inflate(R.layout.mytoast, null);
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
                        try {
                            Thread.sleep(3000);
                            updataappslist();
                            //getlistbastract();
                            int tmp = 60;
                            if (SystemData.getIntstent().getCricletime() != null) {
                                tmp = Integer.parseInt(SystemData.getIntstent().getCricletime().getCricletime());
                            }
                            tmp = (tmp+1) * 60000;
                            Thread.sleep(tmp);
                            updataappslist();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            workthread.start();
        }else{
            isonly=false;
            getlistbastract();
        }


    }

    private void init() {

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Toasty.Config.getInstance().setSuccessColor(Color.parseColor("#FF9551")).setTextSize(20).apply();
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
        //WorkService.check();
        String format = "HH:mm:ss";
        isintime = false;
        try {
            boolean isinfirstday = false;
            boolean isinsecond = false;
            Date nowTime = new Date();
            nowTime = new SimpleDateFormat(format).parse(new SimpleDateFormat(format).format(nowTime));
            Date startTime = new SimpleDateFormat(format).parse(SystemData.getIntstent().getNoincometime().getStarttime());
            Date endTime = new SimpleDateFormat(format).parse("23:59:59");
            isinfirstday = isEffectiveDate(nowTime, startTime, endTime);
            startTime = new SimpleDateFormat(format).parse("00:00:01");
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
        if (isintime == true || isarrvemax==true) {//如果在无收益时间。显示等待发放，不执行
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
        if(SystemData.WORK_STATUE && isintime==false && isarrvemax==false){
        String data = "username=" + SystemData.getIntstent().getUserInfo().getUsername()+"&token="+
                SystemData.getIntstent().getUserInfo().getToken();
        OkGo.<String>post(SystemData.BASEURL + "/api/getapprand").upString(data, MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if(isJSONValid(response.body())) {//抢单成功
                    RealApp1Single realApp1 = JSON.parseObject(response.body(), RealApp1Single.class);
                    if(realApp1.getSuccess().indexOf("5")!=-1)
                        WorkService.offline();
                    final RealApp realApp=realApp1.getData();
                    showmytoast("抢到任务啦！","恭喜你已抢到任务，开始加载软件。继续前进吧！WALKUP!");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(SystemData.WORK_STATUE){
                           // Toast.makeText(AppslistActivity.this, "云服务器安装中", Toast.LENGTH_LONG).show();
                                showmytoast("安装等待中！","应用已下载成功，服务器安装中");
                            }
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if(SystemData.WORK_STATUE){
                                      showmytoast("应用安装完毕！","应用已安装完毕，试玩等待中，官方已验证");
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
        String data = "username=" + username + "&appname=" + appname + "&price=" + price+
                "&token="+SystemData.getIntstent().getUserInfo().getToken();
        OkGo.<String>post(SystemData.BASEURL + "/api/addmoeny").upString(data, MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Log.i("加钱结果",response.body());

            }
        });

    }
    private void showmytoast(String title,String text){
       //调用Activity的getLayoutInflater()
         //加載layout下的布局
        ((TextView)view.findViewById(R.id.textView17)).setText(title);
        ((TextView)view.findViewById(R.id.textView18)).setText(text);
        ToastUtils toastUtils=new ToastUtils(AppslistActivity.this,view,Toast.LENGTH_LONG);
        Toast t=toastUtils.getToast();
        t.setGravity(Gravity.CENTER,0,0);
        t.show();
        /*
        Toast t= Toasty.warning(AppslistActivity.this,text,Toast.LENGTH_LONG,true);
        t.setGravity(Gravity.CENTER,0,0);
       t.show();
       */
    }
    private  void updataappslist(){
        OkGo.<String>get(SystemData.BASEURL+"/api/getapps").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if(isJSONValid(response.body())){//获取apps列表成功
                    RealApp1 realApp1= JSON.parseObject(response.body(),RealApp1.class);
                    List<RealApp> apps=realApp1.getData();
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
       /* OkGo.<String>get(SystemData.BASEURL+"/api/getnoincometime.php").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Noincometime noincometime=JSON.parseObject(response.body(),Noincometime.class);
                SystemData.getIntstent().setNoincometime(noincometime);
            }
        });*/
        String data="username="+SystemData.getIntstent().getUserInfo().getUsername()+"&token="
                +SystemData.getIntstent().getUserInfo().getToken();
        OkGo.<String>post(SystemData.BASEURL+"/api/Isarrivemax").upString(data, MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Log.i("是否到达最大",response.body());
                if(response.body().indexOf("2")==-1){
                    isarrvemax=true;
                }else if(response.body().indexOf("5")!=-1){
                    WorkService.offline();
                }else{
                    isarrvemax=false;
                }
            }
        });

    }
    private void getlistbastract(){
        if(isfirst==true){
            return;
        }
        isfirst=true;
        OkGo.<String>get(SystemData.BASEURL+"/api/getapps").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if(isJSONValid(response.body())){//获取apps列表成功
                   RealApp1 realApp1= JSON.parseObject(response.body(),RealApp1.class);
                    List<RealApp> apps=realApp1.getData();
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
                }

            }
        });
    }


}
