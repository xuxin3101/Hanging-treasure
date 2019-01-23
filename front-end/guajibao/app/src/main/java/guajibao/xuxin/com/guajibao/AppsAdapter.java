package guajibao.xuxin.com.guajibao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AppsAdapter extends ArrayAdapter {
private int resourceId;
    public AppsAdapter(Context context, int textViewResourceId, List<Appsitem> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Appsitem appsitem=(Appsitem) getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(resourceId,null);
        ImageView image=(ImageView)view.findViewById(R.id.appsimg);
        image.setImageBitmap(appsitem.getImg());
        TextView title=(TextView)view.findViewById(R.id.appstitle);
        title.setText(appsitem.getTitle());
        TextView content=(TextView)view.findViewById(R.id.appscontent);
        content.setText(appsitem.getContent());
        return view;
    }
}
