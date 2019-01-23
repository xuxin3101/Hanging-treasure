package guajibao.xuxin.com.guajibao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MineAdapter extends ArrayAdapter {
    private final int resourceId;

    public MineAdapter(Context context, int textViewResourceId, List<MineItem> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MineItem mineItem = (MineItem) getItem(position); // 获取当前项的Fruit实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        ImageView image = (ImageView) view.findViewById(R.id.mine_image);//获取该布局内的图片视图
        TextView name = (TextView) view.findViewById(R.id.mine_name);//获取该布局内的文本视图
        image.setImageResource(mineItem.getImgid());//为图片视图设置图片资源
        name.setText(mineItem.getName());//为文本视图设置文本内容
        return view;
    }

}
