package guajibao.xuxin.com.guajibao;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import Users.SystemData;
import bean.UserInfo;
import es.dmoral.toasty.Toasty;
import okhttp3.MediaType;


public class LoginActivity extends AppCompatActivity {
    private AutoCompleteTextView edidview_username;
    private EditText editview_password;
    private Button email_sign_in_button;
    private TextView btn_goregister;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    @Override
    public void onBackPressed() {
       Toast.makeText(LoginActivity.this,"不登录无法进行其他操作",Toast.LENGTH_LONG).show();
    }

    private void  init(){
        edidview_username=findViewById(R.id.username);
        editview_password=findViewById(R.id.password);
        email_sign_in_button=findViewById(R.id.email_sign_in_button);

        email_sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=edidview_username.getText().toString();
                String password=editview_password.getText().toString();
                if(username==null || username.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"用户名不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                if(password==null || username.equals("")) {
                    Toast.makeText(getApplicationContext(), "密码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                OkGo.<String>post(SystemData.BASEURL+"/api/login.php").upString("username="+username+"&password="+password,MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if(isJSONValid(response.body())){
                            UserInfo userInfo= JSON.parseObject(response.body(),UserInfo.class);
                            Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_LONG).show();
                            SystemData.getIntstent().setUserInfo(userInfo);
                            SharedPreferences.Editor editor=getSharedPreferences("userinfo",MODE_PRIVATE).edit();
                            editor.putString("username",userInfo.getUsername());
                            editor.putString("password",userInfo.getPassword());
                            editor.putString("idcard",userInfo.getIdcard());
                            editor.putString("alipayaccount",userInfo.getAlipayaccount());
                            editor.putString("name",userInfo.getAlipayname());
                            editor.putString("bankplace",userInfo.getBankplace());
                            editor.putString("bankaccount",userInfo.getBankaccount());
                            editor.putString("token",userInfo.getToken());
                            editor.commit();
                            MainActivity.isdisplaylogin=false;
                            LoginActivity.this.finish();;
                        }
                        else if(response.body().trim().equals("2")){//被冻结
                            Toast.makeText(getApplicationContext(),"该账号存在违规行为永久冻结",Toast.LENGTH_LONG).show();
                        }
                        else{
                           //登录失败
                           Toast.makeText(getApplicationContext(),"账号或密码错误",Toast.LENGTH_LONG).show();
                       }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        Toasty.Config.reset();
                        Toasty.error(LoginActivity.this,"连接服务器失败，请检查网络设置",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btn_goregister=findViewById(R.id.btn_goregister);
        btn_goregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });



    }
    private boolean isJSONValid(String str ){
        try{
            JSON.parseObject(str);
        }catch (JSONException ex){
            return false;
        }
            return true;
    }
}

