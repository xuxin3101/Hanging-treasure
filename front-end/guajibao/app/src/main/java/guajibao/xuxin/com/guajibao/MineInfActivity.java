package guajibao.xuxin.com.guajibao;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.io.File;
import java.util.List;

import Users.SystemData;
import bean.UploadResult;
import bean.WithdrawQRcode;
import es.dmoral.toasty.Toasty;
import okhttp3.MediaType;

public class MineInfActivity extends AppCompatActivity {
    private EditText ev_username;
    private EditText ev_name;
    private EditText ev_idcard;
    private EditText ev_alipay;
    private Button btn_save;
    private EditText ev_yuanmima;
    private EditText ev_xiugaimima;
    private EditText ev_bankplace;
    private EditText ev_bankaccount;
    private Button btn_upload_wechat;
    private Button btn_upload_alipay;
    private int wechatoralipay;//1代表微信，2代表支付宝

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_inf);
        init();
    }

    private void init() {
        ev_username = findViewById(R.id.edit_username);
        ev_alipay = findViewById(R.id.edit_alipay);
        ev_idcard = findViewById(R.id.edit_mineidcard);
        ev_name = findViewById(R.id.edit_name);
        btn_save = findViewById(R.id.btn_mine_inf_save);
        ev_yuanmima = findViewById(R.id.edit_yuanmima);
        ev_xiugaimima = findViewById(R.id.edit_xiugaimima);
        ev_bankaccount = findViewById(R.id.edit_bankaccount);
        ev_bankplace = findViewById(R.id.edit_bankplace);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String alipay = ev_alipay.getText().toString();
                if (alipay == null || alipay.equals("")) {
                    Toast.makeText(getApplicationContext(), "支付宝提现账号不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                final String name = ev_name.getText().toString();
                if (name == null || name.equals("")) {
                    Toast.makeText(getApplicationContext(), "实名姓名不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                final String idcard = ev_idcard.getText().toString();
                if (idcard == null || idcard.equals("")) {
                    Toast.makeText(getApplicationContext(), "身份证号不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                String yuanmima = ev_yuanmima.getText().toString();
                if (yuanmima == null || yuanmima.equals("")) {
                    Toast.makeText(getApplicationContext(), "原密码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                final String bankplace = ev_bankplace.getText().toString();
                if (bankplace == null || bankplace.equals("")) {
                    Toast.makeText(getApplicationContext(), "开户行不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                final String bankaccount = ev_bankaccount.getText().toString();
                if (bankaccount == null || bankaccount.equals("")) {
                    Toast.makeText(getApplicationContext(), "银行卡号不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                final String xiugaimima = ev_xiugaimima.getText().toString();
                String data = null;
                data = "username=" + SystemData.getIntstent().getUserInfo().getUsername() + "&alipay=" + alipay + "&idcard=" + idcard
                        + "&yuanmima=" + yuanmima + "&name=" + name + "&xiugaimima=" + xiugaimima + "&bankaccount=" + bankaccount + "&bankplace=" + bankplace;
                OkGo.<String>post(SystemData.BASEURL + "/api/updateuserinfo").upString(data, MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response.body().trim().equals("1")) {//修改成功
                            Toast.makeText(getApplicationContext(), "信息修改成功", Toast.LENGTH_LONG).show();
                            ;
                            if (xiugaimima == null || xiugaimima.equals("")) {//判断是否修改了密码
                                //没修改，直接关闭activity
                                SystemData.getIntstent().getUserInfo().setIdcard(idcard);
                                SystemData.getIntstent().getUserInfo().setAlipayname(name);
                                SystemData.getIntstent().getUserInfo().setAlipayaccount(alipay);
                                SharedPreferences.Editor editor = getSharedPreferences("userinfo", MODE_PRIVATE).edit();
                                editor.putString("icard", idcard);
                                editor.putString("name", name);
                                editor.putString("alipayaccount", alipay);
                                editor.putString("bankaccount", bankaccount);
                                editor.putString("bankplace", bankplace);
                                editor.commit();
                                MineInfActivity.this.finish();
                                ;
                            } else {//修改了密码，退出登录
                                SharedPreferences sharedPreferences = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                                sharedPreferences.edit().clear().commit();
                                SystemData.getIntstent().setUserInfo(null);
                                Toast.makeText(getApplicationContext(), "退出成功", Toast.LENGTH_LONG).show();
                                MineInfActivity.this.finish();
                                ;
                            }

                        } else {//判断是因为密码错误还是因为身份证号和姓名不匹配造成的失败
                            Toast.makeText(getApplicationContext(), "信息修改失败", Toast.LENGTH_LONG).show();
                            ;

                        }

                    }
                });
            }
        });
        ev_username.setText(SystemData.getIntstent().getUserInfo().getUsername());
        if (!ev_username.getText().toString().equals("")) {
            ev_username.setFocusable(false);
        }
        ev_alipay.setText(SystemData.getIntstent().getUserInfo().getAlipayaccount());
        if (!ev_alipay.getText().toString().equals("")) {
            ev_alipay.setFocusable(false);
        }
        ev_idcard.setText(SystemData.getIntstent().getUserInfo().getIdcard());
        if (!ev_idcard.getText().toString().equals("")) {
            ev_idcard.setFocusable(false);
        }
        ev_name.setText(SystemData.getIntstent().getUserInfo().getAlipayname());
        if (!ev_name.getText().toString().equals("")) {
            ev_name.setFocusable(false);
        }
        ev_bankplace.setText(SystemData.getIntstent().getUserInfo().getBankplace());
        if (!ev_bankplace.getText().toString().equals("")) {
            ev_bankplace.setFocusable(false);
        }
        ev_bankaccount.setText(SystemData.getIntstent().getUserInfo().getBankaccount());
        if (!ev_bankaccount.getText().toString().equals("")) {
            ev_bankaccount.setFocusable(false);
        }
        btn_upload_wechat = findViewById(R.id.btn_upload_wechat);
        btn_upload_wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemData.getIntstent().getWithdrawQRcode().getWecheatqrcode() == null || SystemData
                        .getIntstent().getWithdrawQRcode().getWecheatqrcode().equals("")) {
                    PictureSelector.create(MineInfActivity.this)
                            .openGallery(PictureMimeType.ofImage())
                            .maxSelectNum(1)
                            .compress(true)
                            .forResult(PictureConfig.CHOOSE_REQUEST);
                    wechatoralipay = 1;

                } else {
                    Toasty.error(MineInfActivity.this, "您已经上传过了，不允许再次上传").show();
                }


            }
        });
        btn_upload_alipay = findViewById(R.id.btn_upload_alipay);
        btn_upload_alipay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (SystemData.getIntstent().getWithdrawQRcode().getAlipayqrcode() == null || SystemData
                        .getIntstent().getWithdrawQRcode().getAlipayqrcode().equals("")) {
                    PictureSelector.create(MineInfActivity.this)
                            .openGallery(PictureMimeType.ofImage())
                            .maxSelectNum(1)
                            .compress(true)
                            .forResult(PictureConfig.CHOOSE_REQUEST);
                    wechatoralipay = 2;
                } else {
                    Toasty.error(MineInfActivity.this, "您已经上传过了，不允许再次上传").show();
                }

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        //WorkService.check();
    }

    private boolean isJSONValid(String str) {
        try {
            JSON.parseObject(str);
        } catch (JSONException ex) {
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    for (LocalMedia lm : selectList) {
                        String path;
                        if (lm.isCompressed()) {
                            path = lm.getCompressPath();
                        } else {
                            path = lm.getPath();
                        }
                        String url;
                        if (wechatoralipay == 1) {
                            url = SystemData.BASEURL + "/api/uploadwechatqrcode";
                        } else if (wechatoralipay == 2) {
                            url = SystemData.BASEURL + "/api/uploadalipayqrcode";
                        } else {
                            url = "";
                            Toasty.error(MineInfActivity.this, "未知错误").show();
                        }
                        OkGo.<String>post(url)
                                .params("username", SystemData.getIntstent().getUserInfo().getUsername())
                                .params("token", SystemData.getIntstent().getUserInfo().getToken())
                                .params("file", new File(path))
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(Response<String> response) {
                                        UploadResult uploadResult = JSON.parseObject(response.body(), UploadResult.class);
                                        if (uploadResult.getResult().equals("Success")) {
                                            Toasty.success(MineInfActivity.this, "上传成功").show();
                                            WithdrawQRcode withdrawQRcode = SystemData.getIntstent().getWithdrawQRcode();
                                            if (withdrawQRcode == null) {
                                                SystemData.getIntstent().setWithdrawQRcode(new WithdrawQRcode());
                                                withdrawQRcode = SystemData.getIntstent().getWithdrawQRcode();
                                            }
                                            if (wechatoralipay == 1)
                                                withdrawQRcode.setWecheatqrcode(uploadResult.getUrl());
                                            else
                                                withdrawQRcode.setAlipayqrcode(uploadResult.getUrl());
                                            SystemData.getIntstent().setWithdrawQRcode(withdrawQRcode);
                                            SharedPreferences.Editor editor = getSharedPreferences("userinfo", MODE_PRIVATE).edit();
                                            if (wechatoralipay == 1)
                                                editor.putString("wechatqrcode", withdrawQRcode.getWecheatqrcode());
                                            else
                                                editor.putString("alipayqrcode", withdrawQRcode.getWecheatqrcode());
                                            editor.commit();
                                        } else {
                                            Toasty.error(MineInfActivity.this, "上传失败,不允许二次上传").show();
                                        }
                                    }
                                });

                        break;//只允许一个图片上传,直接break
                    }

                    break;
            }

        }
    }

}
