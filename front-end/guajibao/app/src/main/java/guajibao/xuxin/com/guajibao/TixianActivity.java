package guajibao.xuxin.com.guajibao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import Users.SystemData;
import bean.IndexInfo;
import bean.MinWithDraw;
import okhttp3.MediaType;

public class TixianActivity extends AppCompatActivity {
    private TextView tv_minwithdraw;
    private Button btn_tixian;
    private EditText et_txamount;
    private TextView tv_keyongyue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tixian);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        WorkService.check();
        if(SystemData.getIntstent().getUserInfo()!=null){
            String data="username="+SystemData.getIntstent().getUserInfo().getUsername();
            OkGo.<String>post(SystemData.BASEURL+"/api/getindexinfo.php").upString(data,MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    IndexInfo i=JSON.parseObject(response.body(),IndexInfo.class);
                    tv_keyongyue.setText("￥"+i.getBalance());
                }
            });
        }
    }

    private void init(){
        tv_minwithdraw=findViewById(R.id.ev_minwithdraw);
        OkGo.<String >get(SystemData.BASEURL+"/api/getminwithdraw.php").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                MinWithDraw minWithDraw=JSON.parseObject(response.body(),MinWithDraw.class);
                tv_minwithdraw.setText(minWithDraw.getMinwithwraw());
            }
        });
      tv_keyongyue=findViewById(R.id.tv_yue);
        btn_tixian=findViewById(R.id.button2);
        et_txamount=findViewById(R.id.tixianamount);
        btn_tixian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount=et_txamount.getText().toString();
                if(amount==null || amount.equals("")){
                    Toast.makeText(getApplicationContext(),"提现金额不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                String username=SystemData.getIntstent().getUserInfo().getUsername();
                String alipay=SystemData.getIntstent().getUserInfo().getAlipayaccount();
                String name=SystemData.getIntstent().getUserInfo().getAlipayname();
                String bankplace=SystemData.getIntstent().getUserInfo().getBankplace();
                String bankaccount=SystemData.getIntstent().getUserInfo().getBankaccount();
                String alipayqrcode=SystemData.getIntstent().getWithdrawQRcode().getAlipayqrcode();
                String wechatqrcode=SystemData.getIntstent().getWithdrawQRcode().getWecheatqrcode();
                String data="username="+username+"&amount="+amount+"&alipay="+alipay+"&name="+name+"&bankplace="+bankplace
                        +"&bankaccount="+bankaccount
                        +"&alipayqrcode="+alipayqrcode
                        +"&wechatqrcode="+wechatqrcode;
                OkGo.<String>post(SystemData.BASEURL+"/api/addwithdrawrecord.php").upString(data,MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if(response.body().trim().equals("1")){//申请提现成功
                            Toast.makeText(getApplicationContext(),"提现申请成功,等待人工审核",Toast.LENGTH_LONG).show();
                            TixianActivity.this.finish();

                        }else{
                            Toast.makeText(getApplicationContext(),"提现申请失败",Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }
        });


    }
}
