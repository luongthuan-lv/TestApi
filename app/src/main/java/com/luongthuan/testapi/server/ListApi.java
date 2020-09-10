package com.luongthuan.testapi.server;

import com.luongthuan.testapi.response.ResponseBase64;
import com.luongthuan.testapi.request.RequestBase64;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ListApi {
    @POST("lifecard-app/area/req")
    Call<ResponseBase64> getAreaCity(@Body RequestBase64 requestBase64);
}
