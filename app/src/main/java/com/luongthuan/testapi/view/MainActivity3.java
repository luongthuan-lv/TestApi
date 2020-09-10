package com.luongthuan.testapi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.luongthuan.testapi.R;
import com.luongthuan.testapi.adpter.MyAdapterCommune;
import com.luongthuan.testapi.data.StringUtils;
import com.luongthuan.testapi.model.AreaRequest;
import com.luongthuan.testapi.model.Example;
import com.luongthuan.testapi.request.ReqApiUtils;
import com.luongthuan.testapi.request.RequestBase64;
import com.luongthuan.testapi.response.Repository;
import com.luongthuan.testapi.response.ResponseBase64;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity3 extends AppCompatActivity {
    Bundle bundle;
    RecyclerView rvListCommune;
    MyAdapterCommune myAdapterCommune;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        rvListCommune = findViewById(R.id.rvListCommune);
        Intent intent = getIntent();
        bundle = intent.getExtras();
        myAdapterCommune = new MyAdapterCommune(MainActivity3.this);
        String areaCode = bundle.getString("areaCode");
        getRetrofit("C", areaCode);
    }

    public void getRetrofit(String areaType, String parentCode) {

        String body = StringUtils.convertObjectToBase64(new AreaRequest(areaType, parentCode));
        Log.e("BODY", body);
        RequestBase64 requestBase64 = ReqApiUtils.createRequest(body, MainActivity3.this);
        Repository.getInstance().getAreaCity(requestBase64).enqueue(new Callback<ResponseBase64>() {
            @Override
            public void onResponse(Call<ResponseBase64> call, Response<ResponseBase64> response) {
                // convert decode sang endcode
                String decode = response.body().getBody();
                String endcode = new String(Base64.decode(decode, Base64.DEFAULT));
                Example example = new Gson().fromJson(endcode, Example.class);
                Log.e("DATA_NAY", example.getListArea().size() + "");
                Log.e("ENDCODE", endcode);


                myAdapterCommune.setItems(example.getListArea());
                rvListCommune.setAdapter(myAdapterCommune);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity3.this, RecyclerView.VERTICAL, false);
                rvListCommune.setLayoutManager(linearLayoutManager);


            }

            @Override
            public void onFailure(Call<ResponseBase64> call, Throwable t) {
                Log.e("EROR", t.getMessage());
                Toast.makeText(MainActivity3.this, "Lỗi mẹ rồi còn gì", Toast.LENGTH_SHORT).show();
            }
        });
    }
}