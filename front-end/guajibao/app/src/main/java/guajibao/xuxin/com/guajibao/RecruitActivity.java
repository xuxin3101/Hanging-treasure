package guajibao.xuxin.com.guajibao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import Users.SystemData;
import okhttp3.MediaType;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

public class RecruitActivity extends AppCompatActivity {
    private TextView textView;
    private ImageButton btn_recruitdetail;
    private ImageView btn_actionbar_back;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruit);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
           // actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setCustomView(R.layout.myactionbar);
            btn_actionbar_back=findViewById(R.id.btn_actionbar_back);
            btn_actionbar_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RecruitActivity.this.onBackPressed();
                }
            });
        }
        init();
    }

    private void init() {
        String data = "subordinate=" + SystemData.getIntstent().getUserInfo().getUsername();
        OkGo.<String>post(SystemData.BASEURL + "/api/checksuperior").upString(data, MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                if (response.body().trim().indexOf("2")!=-1) {//有上级

                } else {//没有上级
                    RecruitActivity.this.startActivity(new Intent(RecruitActivity.this, InviteActivity.class));
                }
            }
        });
        textView = findViewById(R.id.textView9);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hanzhenguangbiao.ttf"));
        textView = findViewById(R.id.textView10);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/hanzhenguangbiao.ttf"));
        btn_recruitdetail=findViewById(R.id.imageButton);
        btn_recruitdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecruitActivity.this,RecruitDetailActivity.class));
            }
        });
    }

    ;

}
