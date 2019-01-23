package guajibao.xuxin.com.guajibao;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.model.Response;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Appsitem {
    private String title;
    private String content;
    private  String img;
    private Bitmap bitmap = null;
public Appsitem(String title, String content, final String img){
    this.title=title;
    this.content=content;
    this.img=img;
    OkGo.<Bitmap>get(img).execute(new BitmapCallback() {

        @Override
        public void onSuccess(Response<Bitmap> response) {
            if(response.body()!=null)
            bitmap=response.body();
        }
    });



}
    public String getContent() {
        return content;
    }

    public Bitmap getImg() {
        return bitmap;
    }

    public String getTitle() {
        return title;
    }
}
