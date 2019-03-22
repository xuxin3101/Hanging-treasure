package guajibao.xuxin.com.guajibao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import Users.SystemData;
import okhttp3.MediaType;

public class RegisterActivity extends AppCompatActivity {
    private EditText ed_idacrd;
    private EditText ed_alipay;
    private EditText ed_name;
    private EditText ed_username;
    private EditText ed_password;
    private Button btn_register;
    private EditText ed_bankplace;
    private EditText ed_bank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }
    private void init(){
        ed_idacrd=findViewById(R.id.edit_register_mineidcard);
        ed_alipay=findViewById(R.id.edit_register_alipay);
        ed_name=findViewById(R.id.edit_register_name);
        ed_username=findViewById(R.id.edit_register_username);
        ed_password=findViewById(R.id.edit_register_password);
        ed_bankplace=findViewById(R.id.edit_register_bankplace);
        ed_bank=findViewById(R.id.edit_register_bank);
        btn_register=findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idcard=ed_idacrd.getText().toString();
                if(idcard==null||idcard.equals("")){
                    Toast.makeText(getApplicationContext(),"身份证号不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                String alipay=ed_alipay.getText().toString();
                if(alipay==null||alipay.equals("")){
                    Toast.makeText(getApplicationContext(),"支付宝不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                String name=ed_name.getText().toString();
                if(name==null||name.equals("")){
                    Toast.makeText(getApplicationContext(),"姓名不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                String username=ed_username.getText().toString();
                if(username==null||username.equals("")){
                    Toast.makeText(getApplicationContext(),"手机号不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                String password=ed_password.getText().toString();
                if(password==null||password.equals("")){
                    Toast.makeText(getApplicationContext(),"密码不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                String bank=ed_bank.getText().toString();
                if(bank==null|| bank.equals("")){
                    Toast.makeText(getApplicationContext(),"银行账号不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                String bankplace=ed_bankplace.getText().toString();
                if(bankplace==null||bankplace.equals("")){
                    Toast.makeText(getApplicationContext(),"开户行不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                String data="username="+username+"&alipay="+alipay+"&idcard="+idcard+"&password="+password+"&name="+name+"&bankaccount="+bank+"&bankplace="+bankplace;
                OkGo.<String>post(SystemData.BASEURL+"/api/register").upString(data,MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if(response.body().trim().equals("1")){//注册成功
                            Toast.makeText(getApplicationContext(),"恭喜您，注册成功",Toast.LENGTH_LONG).show();
                            RegisterActivity.this.finish();

                        }else{//注册失败
                            Toast.makeText(getApplicationContext(),"注册失败，身份证号和姓名必须匹配",Toast.LENGTH_LONG).show();

                        }

                    }
                });

            }
        });


    }
}
