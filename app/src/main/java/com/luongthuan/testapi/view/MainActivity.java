package com.luongthuan.testapi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.luongthuan.testapi.R;
import com.luongthuan.testapi.adpter.MyAdapterCity;
import com.luongthuan.testapi.data.Config;
import com.luongthuan.testapi.data.StringUtils;
import com.luongthuan.testapi.model.AreaRequest;
import com.luongthuan.testapi.model.Example;
import com.luongthuan.testapi.model.ListArea;
import com.luongthuan.testapi.request.ReqApiUtils;
import com.luongthuan.testapi.request.RequestBase64;
import com.luongthuan.testapi.response.Repository;
import com.luongthuan.testapi.response.ResponseBase64;

import java.io.UnsupportedEncodingException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    MyAdapterCity myAdapterCity;
    RecyclerView rvListCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvListCity=findViewById(R.id.rvListCity);
        rvListCity.setHasFixedSize(true);
        myAdapterCity=new MyAdapterCity(MainActivity.this);
        getRetrofit("P","");
    }

    public void getRetrofit(String areaType,String parentCode) {

        String body = StringUtils.convertObjectToBase64(new AreaRequest(areaType, parentCode));
        Log.e("BODY",body);
        RequestBase64 requestBase64 = ReqApiUtils.createRequest(body, MainActivity.this);
        Repository.getInstance().getAreaCity(requestBase64).enqueue(new Callback<ResponseBase64>() {
            @Override
            public void onResponse(Call<ResponseBase64> call, Response<ResponseBase64> response) {
               // convert decode sang endcode
                String decode = response.body().getBody();
                String endcode = new String(Base64.decode(decode, Base64.DEFAULT));
                Example example=new Gson().fromJson(endcode,Example.class);
                Log.e("DATA_NAY",example.getListArea().size()+"");
                Log.e("ENDCODE", endcode);


                myAdapterCity.setItems(example.getListArea());
                rvListCity.setAdapter(myAdapterCity);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
                rvListCity.setLayoutManager(linearLayoutManager);


            }

            @Override
            public void onFailure(Call<ResponseBase64> call, Throwable t) {
                Log.e("EROR", t.getMessage());
                Toast.makeText(MainActivity.this, "Lỗi mẹ rồi còn gì", Toast.LENGTH_SHORT).show();
            }
        });
    }
}