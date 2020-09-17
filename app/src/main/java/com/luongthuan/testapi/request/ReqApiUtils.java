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
        return requestBase64;
    }
}
