package guajibao.xuxin.com.guajibao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.fastjson.JSON;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import Users.SystemData;
import bean.Announcement;
import bean.Noincometime;
import bean.PlatformInfo;
import bean.UserInfo;
import bean.WithdrawQRcode;

public class StartAcyivity extends AppCompatActivity {
    private List<Appsitem> appsitemList=new ArrayList<Appsitem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_acyivity);
        OkGo.getInstance().init(getApplication());
        OkGo.<String>get(SystemData.BASEURL+"/api/getannouncement.php").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Announcement announcement=JSON.parseObject(response.body(),Announcement.class);
                SystemData.getIntstent().setAnnouncement(announcement.getContent());
            }
        });
        OkGo.<String>get(SystemData.BASEURL+"/api/getnoincometime.php").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Noincometime noincometime=JSON.parseObject(response.body(),Noincometime.class);
                SystemData.getIntstent().setNoincometime(noincometime);
            }
        });
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //先判断是否激活，没激活跳转激活页面。
                SharedPreferences tsp=getSharedPreferences("isactivation",MODE_PRIVATE);

                if( tsp.getBoolean("isactivation",false)){
                    //已激活
                    startActivity(new Intent(StartAcyivity.this,MainActivity.class));
                }else{
                    //未激活
                    startActivity(new Intent(StartAcyivity.this,ActivationActivity.class));
                }


StartAcyivity.this.finish();   }
        },2000);
        OkGo.<String>get(SystemData.BASEURL+"/api/getplatforms.php").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                List<PlatformInfo> l = JSON.parseArray(response.body(),PlatformInfo.class);
                for(PlatformInfo a:l){
                    appsitemList.add(new Appsitem(a.getTitle(),a.getContent(),a.getImg()));
                }
                SystemData.getIntstent().setAppsitemList(appsitemList);

            }
        });
        /*
        appsitemList.add(new Appsitem("爱盈利","iMoney为你提供超多好玩的应用，试玩应用还能领取丰厚的现金红包，赶快加入吧~","https://static.eimoney.com/idx/img/web_logo_bottoms.png"));
        appsitemList.add(new Appsitem("小鱼赚钱","动动手指，试玩应用的赚钱软件","http://www.xy599.com/img/pc/imgs/newLogo.png"));
        appsitemList.add(new Appsitem("钱咖","一个有 “价值” 的互动娱乐社区","https://assets.qkcdn.com/images/2ec1a3478526c7a6d73232e0efc94764.png"));
        appsitemList.add(new Appsitem("PP红包","轻松试玩，痛快赚钱","https://cdn.qimai.cn/task/201712/5231d584918aaaebc39f8d9ed7c79278.jpeg"));
        appsitemList.add(new Appsitem("应用试客","人人都喜爱的应用社区发现有趣好玩的App","http://static.appshike.com/images/media/shikelogo.png"));
        appsitemList.add(new Appsitem("钱大师","动动手指就玩的抓钱软件","http://resource.moneyds.com/mds2/img/ico02.png"));
        appsitemList.add(new Appsitem("头号试玩","iOS应用体验平台","http://www.touhaoshiwan.com/v1/images/pc/play_guy.png"));
        appsitemList.add(new Appsitem("熊猫赚钱","大家都在玩的赚钱app 试玩应用赚取超高现金奖励","http://shiwan123.com/images/avatar.png"));
        appsitemList.add(new Appsitem("掉钱眼儿","一款可以赚钱的APP","http://www.diaoqianyaner.com/dist/logo@2xcbe034f1.png"));
        appsitemList.add(new Appsitem("天天钱庄","下课玩，吃饭玩，躺着玩随时随地，赚够每月零花钱","https://qz-cdn.saasv.com/img/pic2_01.png"));
        appsitemList.add(new Appsitem("狐狸赚","一个可以装进口袋的零钱提款机","http://14255031.s21i.faiusr.com/4/ABUIABAEGAAg2aWj2gUovLqeyQQwngI4ngI!60x60.png"));
        appsitemList.add(new Appsitem("海豚试玩","发现有趣好玩的App","http://htsw.youdongren.com/pc2/resdir/shikelogo.png"));
        appsitemList.add(new Appsitem("火箭试玩","试玩APP,就能赚现金","http://www.huojianshiwan.com/img/logo.png"));
        appsitemList.add(new Appsitem("蜜蜂试玩","轻轻松松试玩有趣应用的软件","http://www.beeplay.com.cn/img/logo2.png"));
        appsitemList.add(new Appsitem("麦子赚","大家都在玩的赚钱APP","https://www.maizizhuan.com/index/img/nav_logo.png"));
        appsitemList.add(new Appsitem("红包试客","新手首次登陆即有3元，更有1-10元的新手任务！","http://rr.xmys.org/shiwanbao/image/hbsk.jpg"));
        appsitemList.add(new Appsitem("葫芦赚","葫芦赚是一款安卓手机兼职赚钱App，200多个任务等你来赚，每天上新任务","http://rr.xmys.org/shiwanbao/image/hlz.png"));
        appsitemList.add(new Appsitem("每日赚点","每日赚点，一款能赚钱的APP，一款让你越来越有钱的APP","http://rr.xmys.org/shiwanbao/image/mrzd.jpg"));
        appsitemList.add(new Appsitem("小啄赚钱","用户随时都能线上接到任务，完成任务即可赚到钱","http://rr.xmys.org/shiwanbao/image/xzzq.jpg"));
        appsitemList.add(new Appsitem("左玩右玩","左玩右玩是一款玩游戏赚钱的软件，手机兼职赚钱软件就选左玩右玩","http://rr.xmys.org/shiwanbao/image/zwyw.png"));
        */
        SharedPreferences sp =getSharedPreferences("userinfo",MODE_PRIVATE);
        UserInfo userInfo=new UserInfo();
        userInfo.setAlipayaccount(sp.getString("alipayaccount",""));
        userInfo.setAlipayname(sp.getString("name",""));
        userInfo.setIdcard(sp.getString("idcard",""));
        userInfo.setPassword(sp.getString("password",""));
        userInfo.setUsername((sp.getString("username","")));
        userInfo.setBankaccount(sp.getString("bankaccount",""));
        userInfo.setBankplace(sp.getString("bankplace",""));
        userInfo.setToken(sp.getString("token",""));
        if(userInfo.getUsername().equals(""))
            userInfo=null;
        SystemData.getIntstent().setUserInfo(userInfo);
        WithdrawQRcode withdrawQRcode=new WithdrawQRcode();
        withdrawQRcode.setWecheatqrcode(sp.getString("wechatqrcode",""));
        withdrawQRcode.setAlipayqrcode(sp.getString("alipayqrcode",""));
        SystemData.getIntstent().setWithdrawQRcode(withdrawQRcode);
    }
    public void onBackPressed(){
    }
}
