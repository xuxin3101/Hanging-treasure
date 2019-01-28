package guajibao.xuxin.com.guajibao;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import Users.SystemData;
import bean.UserInfo;
import de.hdodenhof.circleimageview.CircleImageView;


public class MineFragment extends Fragment {
    private List<MineItem> list=new ArrayList<MineItem>();
    private TextView myname;
    private TextView myphone;
    private  UserInfo userInfo;
    private Button btn_logout;
    private String qq;
    private CircleImageView mine_touxiang;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mine, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intiitem();
        MineAdapter adapter = new MineAdapter(getActivity(), R.layout.mineitem, list);
        ListView listView = (ListView) getView().findViewById(R.id.list_mine);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position=0我的信息，position=在线客服，position=3关于我们
                switch(position){
                    case 0:
                        if(userInfo!=null){
                            startActivity(new Intent(getActivity(),MineInfActivity.class));
                        }else
                        startActivity(new Intent(getActivity(),LoginActivity.class));
                        return;

                    case 1:
                        ClipboardManager clipboardManager= (ClipboardManager)getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData myClip;
                        String str = qq;
                        myClip=ClipData.newPlainText("text",str);
                        clipboardManager.setPrimaryClip(myClip);
                        Toast.makeText(getContext(),"客服QQ:"+str+"已复制到剪切板",Toast.LENGTH_LONG).show();
                            return;
                    case 2://虚拟定位
                        startActivity(new Intent(getActivity(),MapActivity.class));
                        return;
                    case 3:
                        //展示
                        Intent intent=new Intent(getActivity(),AboutUsActivity.class);
                        startActivity(intent);
                        return;

                }

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        WorkService.check();
    }

    public void onStart() {
        super.onStart();
        userInfo=SystemData.getIntstent().getUserInfo();
        if(userInfo==null){
            myname.setText("未登录");
            myphone.setText("");
        }else{
            myname.setText(userInfo.getAlipayname());
            myphone.setText(userInfo.getUsername());
        }
    }
    private  void intiitem(){
        MineItem mineItem=new MineItem("我的信息",R.drawable.ic_person_black_24dp);
        list.add(mineItem);
        MineItem mineItem1=new MineItem("在线客服",R.drawable.ic_headset_black_24dp);
        list.add(mineItem1);
        MineItem mineItem3=new MineItem("虚拟定位",R.drawable.ic_location_on_black_24dp);
        list.add(mineItem3);
        MineItem mineItem2=new MineItem("关于我们",android.R.drawable.ic_dialog_info);
        list.add(mineItem2);
        myname=getView().findViewById(R.id.textView3);
        myphone=getView().findViewById(R.id.textView4);
        btn_logout=getView().findViewById(R.id.btn_logout);
        mine_touxiang=getView().findViewById(R.id.mine_touxiang);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getActivity().getSharedPreferences("userinfo",Context.MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
                SystemData.getIntstent().setUserInfo(null);
                Toast.makeText(getContext(),"退出成功",Toast.LENGTH_LONG).show();
                onStart();
                startActivity(new Intent(getActivity(),LoginActivity.class));

            }
        });
        OkGo.<String>get(SystemData.BASEURL+"/api/getqq.php").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                qq=response.body();
            }
        });
        OkGo.<Bitmap>get("http://rr.xmys.org/shiwanbao/logo.png").execute(new BitmapCallback() {
            @Override
            public void onSuccess(Response<Bitmap> response) {
                Bitmap bitmap=response.body();
                if(bitmap!=null){
                    mine_touxiang.setImageBitmap(bitmap);
                }
            }
        });


    }
}