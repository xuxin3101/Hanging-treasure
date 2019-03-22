package guajibao.xuxin.com.guajibao;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import Users.Jilu;
import Users.SystemData;
import adapters.TixianAdapter;
import bean.Commissionrecord;
import bean.Commissionrecord1;
import bean.Commissionrecord2;
import bean.IndexInfo;
import bean.UserInfo;
import bean.UserInfo1;
import bean.WithdrawRecord;
import bean.WithdrawRecord1;
import okhttp3.MediaType;

public class WalletFragment extends Fragment {
    private Button btn_tixian;
    private ExpandableListView tixianlitview;
    private TixianAdapter tixianAdapter;
    private List<String> groupsource;
    private List<List<Jilu>> jilu;
    private TextView tv_keyongyue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_wallet, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
    }

    @Override
    public void onResume() {
        //WorkService.check();
        super.onResume();
        if(SystemData.getIntstent().getUserInfo()!=null){
            String data="username="+SystemData.getIntstent().getUserInfo().getUsername();
            OkGo.<String>post(SystemData.BASEURL+"/api/user").upString(data,MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
                @Override
                public void onSuccess(Response<String> response) {
                    UserInfo1 i=JSON.parseObject(response.body(), UserInfo1.class);
                    UserInfo userInfo=i.getData();
                    tv_keyongyue.setText("￥"+userInfo.getBalance());
                }
            });
        }
        initmydata();
    }

    public void init(){
        btn_tixian=getView().findViewById(R.id.buttontixian);
        tv_keyongyue=getView().findViewById(R.id.tv_wallet_yue);
        btn_tixian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),TixianActivity.class));
            }
        });
        tixianlitview=getView().findViewById(R.id.tixianjilu);
    }
    private  void addData(String group,Jilu[] jilus){
        groupsource.add(group);
        List<Jilu> childitem = new ArrayList<>();
        for (int i = 0; i < jilus.length; i++) {
            childitem.add(new Jilu(jilus[i].getTime(),jilus[i].getPrice()));
        }
        jilu.add(childitem);

    }
    private void  initmydata(){
        groupsource=new ArrayList<String>();
        jilu=new ArrayList<List<Jilu>>();
        if(SystemData.getIntstent().getUserInfo()!=null){


        String data="username="+SystemData.getIntstent().getUserInfo().getUsername();
        OkGo.<String>post(SystemData.BASEURL+"/api/getwithdrawrecord").upString(data,MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String str=response.body();
                if(isJSONValid(str))
                {
                    WithdrawRecord1 withdrawRecord1=JSON.parseObject(str,WithdrawRecord1.class);
                    List<WithdrawRecord> wr=withdrawRecord1.getData();
                    Jilu[] wjl=new Jilu[wr.size()];
                    for(int i=0;i<wr.size();i++){
                        wjl[i]=new Jilu(wr.get(i).getTime()+"",wr.get(i).getAmount());
                    }
                    addData("提现记录",wjl);
                }
                else{ addData("提现记录",new Jilu[]{});
                }
                tixianlitview.setAdapter(new TixianAdapter(getActivity(),groupsource,jilu));

            }
        });
        OkGo.<String>post(SystemData.BASEURL+"/api/getcommissionrecord").upString(data,MediaType.parse("application/x-www-form-urlencoded")).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String str=response.body();
                if(isJSONValid(str))
                {   Commissionrecord1 commissionrecord1=JSON.parseObject(str,Commissionrecord1.class);
                    List<Commissionrecord> wr=commissionrecord1.getData().getRows();
                    Jilu[] cjl=new Jilu[wr.size()];
                    for(int i=0;i<wr.size();i++){
                        cjl[i]=new Jilu(wr.get(i).getTime()+"",wr.get(i).getPrice());
                    }
                    addData("佣金记录",cjl);
                }
                else{ addData("佣金记录",new Jilu[]{});
                }
                tixianlitview.setAdapter(new TixianAdapter(getActivity(),groupsource,jilu));

            }
        });
        }

    }
    private boolean isJSONValid(String str ){
        try{
            JSON.parseArray(str);
        }catch (JSONException ex){
            try{
                JSON.parseObject(str);
            }catch (JSONException e){
                return false;
            }
        }
        return true;
    }
}