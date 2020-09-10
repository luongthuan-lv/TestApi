package com.luongthuan.testapi.request;

import android.content.Context;

import com.luongthuan.testapi.data.Config;

import static com.luongthuan.testapi.data.PresenterUtils.getClientRequestId;

public class ReqApiUtils {

    public static RequestBase64 createRequest(String body, Context context) {
        RequestBase64 requestBase64 = new RequestBase64();
        requestBase64.setBody(body);
        try {
            Config.Header.setClientRequestId(String.valueOf(getClientRequestId(context)));
        }catch (java.lang.Exception ignored){

        }
        requestBase64.setRequestHeader(Config.Header.getHeader());
//        Log.d("Base64", function + "-----" + requestBase64.toString());
//        Log.d("BodyEncode", function + "-----" + requestBase64.getBody());
//        try {
//            byte[] data = Base64.decode(body, Base64.DEFAULT);
//            String requestBody = new String(data, Config.CHARSET_NAME);
//            Log.d("requestBodyDecode: ", function + " *** " + requestBody);
//            Log.d("request", function + "------------------------------------\n");
//        } catch (java.lang.Exception ignored) {
//        }
        return requestBase64;
    }
}
