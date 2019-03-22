package guajibao.xuxin.com.guajibao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Users.SystemData;

public class SettingFragment extends Fragment {

    private List<Appsitem> appsitemList=new ArrayList<Appsitem>();
    private CheckBox checkBox1;
    private  CheckBox checkBox2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_setting, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initres();
        AppsAdapter appsAdapter=new AppsAdapter(getActivity(),R.layout.appsitem,SystemData.getIntstent().getAppsitemList());
        ListView listView=getView().findViewById(R.id.listview_apps);
        listView.setAdapter(appsAdapter);

    }
    private void initres(){
        checkBox1=getView().findViewById(R.id.checkBox2);
        SystemData.setCheckBox1(checkBox1);
        checkBox1.setText(R.string.check1);
        checkBox2=getView().findViewById(R.id.checkBox3);
        checkBox2.setText(R.string.check2);
        SystemData.setCheckBox2(checkBox2);
    }

    @Override
    public void onResume() {
        super.onResume();
        //WorkService.check();
    }
}
