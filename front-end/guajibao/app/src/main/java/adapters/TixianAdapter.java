package adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import Users.Jilu;
import guajibao.xuxin.com.guajibao.R;

public class TixianAdapter extends BaseExpandableListAdapter {
    private List<String> groupList;//外层的数据源
    private List<List<Jilu>> childList;//里层的数据源
    private Context context;
    public TixianAdapter(Context context, List<String> groupList,List<List<Jilu>> childList ){
            this.context = context;
            this.groupList = groupList;
            this.childList = childList;
        }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.tixian_group_item, null);
        //分组名字
        TextView textView = (TextView) convertView.findViewById(R.id.group_textview);
        textView.setText(groupList.get(groupPosition));
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.tixian_item, null);
        TextView textView_date = (TextView) convertView.findViewById(R.id.tixian_item_date);
        //外层的分组名字
        TextView textView_price=(TextView) convertView.findViewById(R.id.tixian_item_jine);
        textView_date.setText(childList.get(groupPosition).get(childPosition).getTime());
        textView_price.setText(childList.get(groupPosition).get(childPosition).getPrice());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
