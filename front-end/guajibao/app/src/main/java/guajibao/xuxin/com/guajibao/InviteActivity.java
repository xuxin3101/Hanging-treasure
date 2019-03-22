package guajibao.xuxin.com.guajibao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import Users.SystemData;
import es.dmoral.toasty.Toasty;
import okhttp3.MediaType;

public class InviteActivity extends AppCompatActivity {
    private EditText et_invite;
    private ImageButton btn_invite_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);
        init();
    }
    private void init(){
        et_invite=findViewById(R.id.editText);
        btn_invite_confirm=findViewById(R.id.btn_invite_confirm);
        btn_invite_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String invitecode=et_invite.getText().toString();
                if (invitecode==null || invitecode.equals("")){
                    Toast.makeText(InviteActivity.this,"邀请码不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                String data="superior="+invitecode+"&subordinate="+SystemData.getIntstent().getUserInfo().getUsername()+"&password="+SystemData.getIntstent().getUserInfo().getPassword();
                OkGo.<String>post(SystemData.BASEURL+"/api/addrelationship").upString(data,MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Toasty.Config.reset();
                        if(response.body().trim().indexOf("2")!=-1){//绑定成功
                            Toasty.success(InviteActivity.this,"绑定成功",Toast.LENGTH_LONG).show();
                            InviteActivity.this.finish();

                        }else{//绑定失败
                            Toasty.error(InviteActivity.this,"绑定失败，不能绑定自己或者填写上级不存在",Toast.LENGTH_LONG).show();

                        }

                    }
                });
            }
        });

    }
}
