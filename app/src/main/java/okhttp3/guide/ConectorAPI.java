package okhttp3.guide;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class ConectorAPI {
    OkHttpClient client = new OkHttpClient();

    public Call get(String url, Callback callback) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
        //Response response = null;
        //try {
            //response = client.newCall(request).execute();
            //return response.body().string();
        //} finally {
        //    if (response != null) {
        //        response.close();
        //    }
        //}
    }
}
