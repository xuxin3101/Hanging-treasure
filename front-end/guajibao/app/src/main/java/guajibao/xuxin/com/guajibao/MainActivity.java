package guajibao.xuxin.com.guajibao;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.vector.update_app.HttpManager;
import com.vector.update_app.UpdateAppBean;
import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.UpdateCallback;
import com.vector.update_app.service.DownloadService;

import org.apache.commons.text.StringEscapeUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.Map;

import Users.SystemData;
import bean.Cricletime;
import bean.UpdateInfo;
import es.dmoral.toasty.Toasty;
import tools.CProgressDialogUtils;
import tools.HProgressDialogUtils;
import tools.Installuninstall;
import tools.UpdateAppManagerUtil;


public class MainActivity extends AppCompatActivity {

    private WalletFragment walletFragment;
    private SettingFragment settingFragment;
    private MineFragment mineFragment;
    private IndexFragment indexFragment;
    private Fragment[] fragments;
    private BottomNavigationView navigation;
    private int lastfragment;
    public static boolean isdisplaylogin = false;
    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    item.setIcon(R.drawable.home_checked);
                    if (lastfragment != 0) {
                        switchFragment(lastfragment, 0);
                        lastfragment = 0;

                    }
                    return true;
                case R.id.navigation_wallet:
                    if (lastfragment != 1) {
                        switchFragment(lastfragment, 1);
                        lastfragment = 1;

                    }
                    return true;
                case R.id.navigation_setting:
                    if (lastfragment != 2) {
                        switchFragment(lastfragment, 2);
                        lastfragment = 2;

                    }
                    return true;
                case R.id.navigation_mine:
                    if (lastfragment != 3) {
                        switchFragment(lastfragment, 3);
                        lastfragment = 3;

                    }
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFragment();
        EventBus.getDefault().register(this);
        OkGo.<String>get(SystemData.BASEURL + "/api/getcricletime.php").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Cricletime c = JSON.parseObject(response.body(), Cricletime.class);
                SystemData.getIntstent().setCricletime(c);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        //检车更新
  new UpdateAppManager.Builder().setActivity(MainActivity.this).setUpdateUrl(SystemData.BASEURL+"/api/checkupdate.php")
                .setHttpManager(new HttpManager() {
                    @Override
                    public void asyncGet(@NonNull String url, @NonNull Map<String, String> params, @NonNull final Callback callBack) {
                        if(!params.isEmpty()){
                            url=url+"?";
                        }
                        for(String tmp:params.keySet()){
                            url=url+params.get(tmp).toString()+"&";
                        }
                        OkGo.<String>get(url).execute(new StringCallback() {
                            @Override
                            public void onSuccess(Response<String> response) {
                                // String s=unicodeToString(response.body());
                                String s=StringEscapeUtils.unescapeJava(response.body());
                               // Log.i("aaa",s);
                                callBack.onResponse(s);
                            }

                            @Override
                            public void onError(Response<String> response) {
                                super.onError(response);
                            }
                        });
                    }

                    @Override
                    public void asyncPost(@NonNull String url, @NonNull Map<String, String> params, @NonNull Callback callBack) {

                    }

                    @Override
                    public void download(@NonNull String url, @NonNull String path, @NonNull String fileName, @NonNull final FileCallback callback) {
                        OkGo.<File>get(url).execute(new com.lzy.okgo.callback.FileCallback() {
                            @Override
                            public void onSuccess(Response<File> response) {
                                callback.onResponse(response.body());
                            }

                            @Override
                            public void downloadProgress(Progress progress) {
                                super.downloadProgress(progress);
                                callback.onProgress(progress.fraction*100,progress.totalSize);
                            }

                            @Override
                            public void onStart(Request<File, ? extends Request> request) {
                                super.onStart(request);
                                callback.onBefore();
                            }
                        });


                    }
                }).build()
            .checkNewApp(new UpdateCallback(){
                /**
                 * 解析json,自定义协议
                 *
                 * @param json 服务器返回的json
                 * @return UpdateAppBean
                 */
                @Override
                protected UpdateAppBean parseJson(String json) {
                    UpdateAppBean updateAppBean = new UpdateAppBean();

                    try {

                        UpdateInfo updateInfo =  JSON.parseObject(json,UpdateInfo.class);
                        updateAppBean
                                //（必须）是否更新Yes,No
                                .setUpdate("Yes")
                                //（必须）新版本号，
                                .setNewVersion(updateInfo.getVersionName())
                                //（必须）下载地址
                                .setApkFileUrl(updateInfo.getDownloadUrl())
                                //（必须）更新内容
                                .setUpdateLog(updateInfo.getModifyContent())
                                //大小，不设置不显示大小，可以不设置
                                .setTargetSize(updateInfo.getApkSize())
                                //是否强制更新，可以不设置
                                .setConstraint(true);
                                //设置md5，可以不设置
                        if(BuildConfig.VERSION_NAME.equals(updateInfo.getVersionName())){
                            updateAppBean.setUpdate("No");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return updateAppBean;
                }

                /**
                 * 网络请求之前
                 */
                @Override
                public void onBefore() {
                    CProgressDialogUtils.showProgressDialog(MainActivity.this);
                }

                /**
                 * 网路请求之后
                 */
                @Override
                public void onAfter() {
                    CProgressDialogUtils.cancelProgressDialog(MainActivity.this);
                }

                /**
                 * 没有新版本
                 */

                public void noNewApp() {
                    Toast.makeText(MainActivity.this, "没有新版本", Toast.LENGTH_SHORT).show();
                }
            });

       /* XUpdate.get().debug(true).isWifiOnly(false).isGet(true).isAutoMode(false).param("version", UpdateUtils.getVersionName(this))
                .setOnUpdateFailureListener(new OnUpdateFailureListener() {
                    @Override
                    public void onFailure(UpdateError error) {

                    }
                })
                .setIUpdateHttpService(new UpdateAppManagerUtil())
                .init(getApplication());


        XUpdate.newBuild(this).updateUrl(SystemData.BASEURL + "/api/checkupdate.php").update();

            */
                        //登录判断，不登录进入登录界面

        if (SystemData.getIntstent().getUserInfo() == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));

        } else {
            WorkService.check();
        }

    }

    public void onBackPressed() {
        moveTaskToBack(isFinishing());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initFragment() {
        walletFragment = new WalletFragment();
        settingFragment = new SettingFragment();
        mineFragment = new MineFragment();
        indexFragment = new IndexFragment();
        fragments = new Fragment[]{indexFragment, walletFragment, settingFragment, mineFragment};
        getSupportFragmentManager().beginTransaction().replace(R.id.container, indexFragment).show(indexFragment).commit();
        lastfragment = 0;
    }

    private void switchFragment(int lastfragment, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if (fragments[index].isAdded() == false) {
            transaction.add(R.id.container, fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void qiehuantab(String s) {
        if (s.equals("2")) {
            navigation.setSelectedItemId(R.id.navigation_setting);
        } else if (s.indexOf("打开app") != -1) {
            //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            //先获取packagename ，为卸载做准备
            // String row=s.split(":")[1].split(";")[0];
            // final String filepath="/sdcard/"+row.split("/")[4]+"/"+row.split("/")[5];
            String packagename = s.split(":")[1];
            Toast.makeText(MainActivity.this, packagename, Toast.LENGTH_LONG).show();
            Installuninstall.openapp(MainActivity.this, packagename);


        } else if (s.indexOf("设置") != -1) {
            Toast.makeText(MainActivity.this, "没有勾选秘钥调用和协议调用", Toast.LENGTH_LONG).show();
            navigation.setSelectedItemId(R.id.navigation_setting);
        } else if (s.equals("3")) {
            navigation.setSelectedItemId(R.id.navigation_mine);
        } else if (s.equals("踢下线")) {
            if (isdisplaylogin == false) {
                isdisplaylogin = true;
                Toast.makeText(MainActivity.this, "您的账号在其他设备登录", Toast.LENGTH_LONG).show();
                SystemData.WORK_STATUE = false;
                SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
                SystemData.getIntstent().setUserInfo(null);
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        } else if (s.equals("冻结")) {
            if (isdisplaylogin == false) {
                isdisplaylogin = true;
                Toast.makeText(MainActivity.this, "该账号存在违规行为永久冻结", Toast.LENGTH_LONG).show();
                SystemData.WORK_STATUE = false;
                SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
                SystemData.getIntstent().setUserInfo(null);
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        } else if (s.equals("等待发放")) {
            // Toast.makeText(MainActivity.this,"任务等待发放中",Toast.LENGTH_LONG).show();
            Toast t = Toasty.warning(MainActivity.this, "任务等待发放中", Toast.LENGTH_LONG);
            t.setGravity(Gravity.CENTER, 0, 0);
            t.show();
        } else {
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }

    }


}
