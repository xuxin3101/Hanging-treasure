package guajibao.xuxin.com.guajibao;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import Users.SystemData;
import bean.Announcement;
import bean.IndexInfo;
import bean.RealApp;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;

public class IndexFragment extends Fragment {
    private ImageView iv_tasksetting;
    private TextView tv_announcement;
    private ImageView iv_hightask;
    private ImageView iv_map;
    private ImageView iv_help;
    private CircleImageView btn_pow;
    private Intent workservice;
    private TextView tv_zongshouyi;
    private TextView tv_yitixian;
    private TextView tv_tuijianyongjin;
    private TextView tv_keyongyue;
    private CircleImageView btn_min_touxiang;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_index, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inti();

    }

    @Override
    public void onResume() {
        super.onResume();

        if(SystemData.getIntstent().getUserInfo()!=null){
            WorkService.check();
        String data="username="+SystemData.getIntstent().getUserInfo().getUsername();
        OkGo.<String>post(SystemData.BASEURL+"/api/getindexinfo.php").upString(data,MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                IndexInfo i=JSON.parseObject(response.body(),IndexInfo.class);
                tv_zongshouyi.setText(i.getAmount());
                tv_tuijianyongjin.setText(i.getTuijian());
                tv_keyongyue.setText(i.getBalance());
                tv_yitixian.setText(i.getWithdrawed());
            }
        });
        }
        OkGo.<String>get(SystemData.BASEURL+"/api/getannouncement.php").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Announcement announcement=JSON.parseObject(response.body(),Announcement.class);
                SystemData.getIntstent().setAnnouncement(announcement.getContent());
                inti();
            }
        });



    }

    private void inti(){
        iv_tasksetting=getView().findViewById(R.id.niceImageView);
        iv_tasksetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post("2");


            }
        });
        tv_announcement=getView().findViewById(R.id.tv_announcement);
        tv_announcement.setText(SystemData.getIntstent().getAnnouncement());
        tv_announcement.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tv_announcement.setSingleLine(true);
        tv_announcement.setSelected(true);
        tv_announcement.setFocusable(true);
        tv_announcement.setFocusableInTouchMode(true);
        iv_hightask=getView().findViewById(R.id.niceImageView3);
        iv_hightask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),"开发测试中。。。",Toast.LENGTH_LONG).show();
                getActivity().startActivity(new Intent(getActivity(),RecruitActivity.class));
            }
        });
        iv_map=getView().findViewById(R.id.niceImageView4);
        iv_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MapActivity.class));



            }
        });
        btn_pow=getView().findViewById(R.id.btn_power);
        btn_pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SystemData.WORK_STATUE){
                    btn_pow.setImageResource(R.drawable.power );
                    SystemData.WORK_STATUE=false;

                   // getActivity().stopService(workservice);
                }else{
                    if(SystemData.getCheckBox1()==null || SystemData.getCheckBox2()==null ||SystemData.getCheckBox1().isChecked()==false || SystemData.getCheckBox2().isChecked()==false){
                        EventBus.getDefault().post("设置");
                        return ;
                    }
                  btn_pow.setImageResource(R.drawable.power_on );
                    SystemData.WORK_STATUE=true;
                   // getActivity().startService(workservice);
                    /*更新版本1.1，跳转activity/
                     */
                    startActivity(new Intent(getActivity(),AppslistActivity.class));

                }

            }
        });
        workservice=new Intent(getActivity(),WorkService.class);
        tv_zongshouyi=getView().findViewById(R.id.textview_zongsouyi);
        tv_yitixian=getView().findViewById(R.id.textview_yitixian);
        tv_tuijianyongjin=getView().findViewById(R.id.textview_tuijianyongjin);
        tv_keyongyue=getView().findViewById(R.id.textview_keyongyue);
        btn_min_touxiang=getView().findViewById(R.id.btn_min_touxiag);
        btn_min_touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post("3");
            }
        });
        iv_help=getView().findViewById(R.id.niceImageView2);
        iv_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),HelpActivity.class));
            }
        });


    }

    private boolean isJSONValid(String str ){
        try{
            JSON.parseArray(str);
        }catch (JSONException ex){
            return false;
        }
        return true;
    }

}