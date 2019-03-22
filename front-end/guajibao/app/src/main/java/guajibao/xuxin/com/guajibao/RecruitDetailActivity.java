package guajibao.xuxin.com.guajibao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import Users.Jilu;
import Users.SystemData;
import adapters.RecruitAdapter;
import bean.RecruitCommission;
import okhttp3.MediaType;

public class RecruitDetailActivity extends AppCompatActivity {
    private List<Jilu> list=new ArrayList<Jilu>();
    private ImageView btn_withdraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruit_detail);
        init();
    }
    private void init(){
        final ListView listView=findViewById(R.id.listview_recruit);
        btn_withdraw=findViewById(R.id.imageView5);
        btn_withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecruitDetailActivity.this,TixianActivity.class));
            }
        });


        OkGo.<String>post(SystemData.BASEURL+"/api/getrecruotmission").upString("username="+SystemData.getIntstent().getUserInfo().getUsername(),MediaType.parse("application/x-www-form-urlencoded"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.i("徒弟",response.body());
                       List<RecruitCommission> l= JSON.parseArray(response.body(),RecruitCommission.class);
                       for(RecruitCommission r: l){
                           list.add(new Jilu(r.getSubordinate(),r.getAmount()));
                       }
                       if(l.size()!=0){
                           ((TextView)findViewById(R.id.textView16)).setVisibility(View.INVISIBLE);
                       }
                        RecruitAdapter recruitAdapter=new RecruitAdapter(RecruitDetailActivity.this,R.layout.recruititem,list);
                        listView.setAdapter(recruitAdapter);


                    }
                });



    }
}
