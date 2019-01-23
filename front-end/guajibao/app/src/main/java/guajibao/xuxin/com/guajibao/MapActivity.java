package guajibao.xuxin.com.guajibao;

import android.app.Activity;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;

import java.util.Map;
import java.util.Random;

public class MapActivity extends AppCompatActivity {
    private MapView map;
    public static Activity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=this;
        Toast.makeText(MapActivity.this,"正在重新虚拟定位",Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_map);
        map=findViewById(R.id.map);
        map.onCreate(savedInstanceState);
        AMap aMap = null;
        if(aMap == null){
            aMap=map.getMap();
        }
        float max = 100,min=30;
        Double lng= new Random().nextDouble()*35+85;//从黑龙江到新疆
        Double lat=new Random().nextDouble()*15+28;//从黑龙江到广东
        LatLng latLng = new LatLng(lat,lng);
        final Marker marker = aMap.addMarker(new MarkerOptions().position(latLng).title("虚拟位置").snippet(""));
        aMap.moveCamera( CameraUpdateFactory.newLatLngZoom(latLng,5));
        Toast.makeText(MapActivity.this,"重新选取虚拟定位成功",Toast.LENGTH_LONG).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MapActivity.this.finish();

            }
        }).start();



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.onResume();
        WorkService.check();
    }

    @Override
    protected void onPause() {
        super.onPause();
        map.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        map.onSaveInstanceState(outState);
    }
}
