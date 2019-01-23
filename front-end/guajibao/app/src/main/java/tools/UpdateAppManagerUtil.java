package tools;
public class UpdateAppManagerUtil{

}

/*
import android.support.annotation.NonNull;
import android.util.Log;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.xuexiang.xupdate.proxy.IUpdateHttpService;
import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.text.StringEscapeUtils;


public class UpdateAppManagerUtil implements IUpdateHttpService {




    @Override
    public void asyncGet(@NonNull String url, @NonNull Map<String, Object> params, @NonNull final Callback callBack) {
        if(!params.isEmpty()){
            url=url+"?";
        }
        for(Map.Entry<String,Object> entry: params.entrySet()){
            url=url+entry.getKey()+"="+entry.getValue().toString()+"&";
        }
        OkGo.<String>get(url).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
               // String s=unicodeToString(response.body());
                String s=StringEscapeUtils.unescapeJava(response.body());
                Log.i("aaa",s);
                callBack.onSuccess(s);
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
            }
        });
    }

    @Override
    public void asyncPost(@NonNull String url, @NonNull Map<String, Object> params, @NonNull Callback callBack) {

    }

    @Override
    public void download(@NonNull String url, @NonNull String path, @NonNull String fileName, @NonNull final  DownloadCallback callback) {
        OkGo.<File>get(url).execute(new com.lzy.okgo.callback.FileCallback() {
            @Override
            public void onSuccess(Response<File> response) {
                callback.onSuccess(response.body());
            }
        });
    }

    @Override
    public void cancelDownload(@NonNull String url) {

    }

    public static String unicodeToString(String str) {

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            //group 6728
            String group = matcher.group(2);
            //ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            //group1 \u6728
            String group1 = matcher.group(1);
            str = str.replace(group1, ch + "");
        }
        return str;
    }


}
*/