package guajibao.xuxin.com.guajibao;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import Users.SystemData;
import okhttp3.MediaType;

public class ActivationActivity extends AppCompatActivity {
    private EditText ev_activation;
    private Button btn_activation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation);
        init();
    }
    private void init(){
        ev_activation=findViewById(R.id.et_activation);
        btn_activation=findViewById(R.id.btn_activation);
        btn_activation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code =ev_activation.getText().toString();
                String data="code="+code;
                OkGo.<String>post(SystemData.BASEURL+"/api/activation.php").upString(data,MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String str=response.body().trim();
                        if(str.equals("1")){//成功{
                            SharedPreferences.Editor editor=getSharedPreferences("isactivation",MODE_PRIVATE).edit();
                            editor.putBoolean("isactivation",true);
                            editor.commit();
                            Toast.makeText(ActivationActivity.this,"激活成功，请关闭app，重启启动",Toast.LENGTH_LONG).show();

                        }else{
                            Toast.makeText(ActivationActivity.this,"激活码不存在请联系上级经销商",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
