package alantam.com.log78.net;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class NetUtil {
    private static final NetUtil ourInstance = new NetUtil();

    public static NetUtil getInstance() {
        return ourInstance;
    }

    private NetUtil() {
    }
    public void doHttpGet(String url, final CallBackTask backTask){
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              backTask.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                backTask.onError();
            }
        });
        App.getQueue().add(request);
    }
    public interface CallBackTask{
        void onSuccess(String s);
        void onError();
    }
}
