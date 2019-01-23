package guajibao.xuxin.com.guajibao;

import android.content.Context;
import android.content.SharedPreferences;
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
import bean.Cricletime;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_inf);
        init();
    }
    private void init(){
        ev_username=findViewById(R.id.edit_username);
        ev_alipay=findViewById(R.id.edit_alipay);
        ev_idcard=findViewById(R.id.edit_mineidcard);
        ev_name=findViewById(R.id.edit_name);
        btn_save=findViewById(R.id.btn_mine_inf_save);
        ev_yuanmima=findViewById(R.id.edit_yuanmima);
        ev_xiugaimima=findViewById(R.id.edit_xiugaimima);
        ev_bankaccount=findViewById(R.id.edit_bankaccount);
        ev_bankplace=findViewById(R.id.edit_bankplace);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String alipay=ev_alipay.getText().toString();
                if(alipay==null||alipay.equals("")){
                    Toast.makeText(getApplicationContext(),"支付宝提现账号不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                final String name=ev_name.getText().toString();
                if(name==null||name.equals("")){
                    Toast.makeText(getApplicationContext(),"实名姓名不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                final String idcard=ev_idcard.getText().toString();
                if(idcard==null||idcard.equals("")){
                    Toast.makeText(getApplicationContext(),"身份证号不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                String yuanmima=ev_yuanmima.getText().toString();
                if(yuanmima==null||yuanmima.equals("")){
                    Toast.makeText(getApplicationContext(),"原密码不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                final String bankplace=ev_bankplace.getText().toString();
                if(bankplace==null||bankplace.equals("")){
                    Toast.makeText(getApplicationContext(),"开户行不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                final String bankaccount=ev_bankaccount.getText().toString();
                if(bankaccount==null||bankaccount.equals("")){
                    Toast.makeText(getApplicationContext(),"银行卡号不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                final String xiugaimima=ev_xiugaimima.getText().toString();
                String data=null;
                data= "username="+SystemData.getIntstent().getUserInfo().getUsername()+"&alipay="+alipay+"&idcard="+idcard
                            +"&yuanmima="+yuanmima+"&name="+name+"&xiugaimima="+xiugaimima+"&bankaccount="+bankaccount+"&bankplace="+bankplace;
                OkGo.<String>post(SystemData.BASEURL+"/api/updateuserinfo.php").upString(data,MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if(response.body().trim().equals("1")){//修改成功
                            Toast.makeText(getApplicationContext(),"信息修改成功",Toast.LENGTH_LONG).show();;
                            if(xiugaimima==null||xiugaimima.equals("")){//判断是否修改了密码
                                //没修改，直接关闭activity
                                SystemData.getIntstent().getUserInfo().setIdcard(idcard);
                                SystemData.getIntstent().getUserInfo().setAlipayname(name);
                                SystemData.getIntstent().getUserInfo().setAlipayaccount(alipay);
                                SharedPreferences.Editor editor= getSharedPreferences("userinfo",MODE_PRIVATE).edit();
                                editor.putString("icard",idcard);
                                editor.putString("name",name);
                                editor.putString("alipayaccount",alipay);
                                editor.putString("bankaccount",bankaccount);
                                editor.putString("bankplace",bankplace);
                                editor.commit();
                                MineInfActivity.this.finish();;
                            }else{//修改了密码，退出登录
                                SharedPreferences sharedPreferences=getSharedPreferences("userinfo",Context.MODE_PRIVATE);
                                sharedPreferences.edit().clear().commit();
                                SystemData.getIntstent().setUserInfo(null);
                                Toast.makeText(getApplicationContext(),"退出成功",Toast.LENGTH_LONG).show();
                                MineInfActivity.this.finish();;
                            }

                        }else{//判断是因为密码错误还是因为身份证号和姓名不匹配造成的失败
                            Toast.makeText(getApplicationContext(),"信息修改失败",Toast.LENGTH_LONG).show();;

                        }

                    }
                });
            }
        });
        ev_username.setText(SystemData.getIntstent().getUserInfo().getUsername());
        ev_alipay.setText(SystemData.getIntstent().getUserInfo().getAlipayaccount());
        ev_idcard.setText(SystemData.getIntstent().getUserInfo().getIdcard());
        ev_name.setText(SystemData.getIntstent().getUserInfo().getAlipayname());
        ev_bankplace.setText(SystemData.getIntstent().getUserInfo().getBankplace());
        ev_bankaccount.setText(SystemData.getIntstent().getUserInfo().getBankaccount());


    }

    @Override
    protected void onResume() {
        super.onResume();
        WorkService.check();
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
