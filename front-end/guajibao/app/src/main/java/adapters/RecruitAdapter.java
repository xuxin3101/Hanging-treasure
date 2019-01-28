package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import Users.Jilu;
import guajibao.xuxin.com.guajibao.R;

public class RecruitAdapter extends ArrayAdapter {
    private int resourceId;
    public RecruitAdapter(Context context, int resource, List<Jilu> obj) {
        super(context, resource,obj);
        resourceId=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Jilu jilu=(Jilu)getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView textView1=view.findViewById(R.id.recruit_item_username);
        textView1.setText(jilu.getTime());
        TextView textView2=view.findViewById(R.id.recruit_item_money);
        textView2.setText("￥"+jilu.getPrice());
        return view;

    }
}
