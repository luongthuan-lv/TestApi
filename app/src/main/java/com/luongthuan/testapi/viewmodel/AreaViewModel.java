package com.luongthuan.testapi.viewmodel;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.luongthuan.testapi.BR;
import com.luongthuan.testapi.adpter.MyAdapterCity;
import com.luongthuan.testapi.data.BindingUtils;
import com.luongthuan.testapi.model.AreaRequest;
import com.luongthuan.testapi.model.Example;
import com.luongthuan.testapi.request.ReqApiUtils;
import com.luongthuan.testapi.request.RequestBase64;
import com.luongthuan.testapi.response.Repository;
import com.luongthuan.testapi.response.ResponseBase64;
import com.luongthuan.testapi.view.MainActivity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AreaViewModel extends BaseObservable {
    private Context mContext;
    @Bindable
    private MyAdapterCity myAdapterCity;
    private String areaType, parentCode;
    @Bindable
    private List<Example.ListArea> listAreaList;

    public AreaViewModel(Context mContext, String areaType, String parentCode) {
        this.mContext = mContext;
        this.areaType = areaType;
        this.parentCode = parentCode;
        getRetrofit(areaType, parentCode);
    }

    public List<Example.ListArea> getListAreaList() {
        return listAreaList;
    }

    public void setListAreaList(List<Example.ListArea> listAreaList) {
        this.listAreaList = listAreaList;
        notifyPropertyChanged(BR.listAreaList);
    }

    public MyAdapterCity getMyAdapterCity() {
        return myAdapterCity;
    }

    public void setMyAdapterCity(MyAdapterCity myAdapterCity) {
        this.myAdapterCity = myAdapterCity;
        notifyPropertyChanged(BR.myAdapterCity);
    }

    public void getRetrofit(String areaType, String parentCode) {

        String body = BindingUtils.convertObjectToBase64(new AreaRequest(areaType, parentCode));
        Log.e("BODY", body);
        RequestBase64 requestBase64 = ReqApiUtils.createRequest(body, mContext);
        Repository.getInstance().getAreaCity(requestBase64).enqueue(new Callback<ResponseBase64>() {
            @Override
            public void onResponse(Call<ResponseBase64> call, Response<ResponseBase64> response) {
                // convert decode sang endcode
                String decode = response.body().getBody();
                String endcode = new String(Base64.decode(decode, Base64.DEFAULT));
                Example example = new Gson().fromJson(endcode, Example.class);
                //  Log.e("DATA_NAY", example.getListArea().size() + "");
                //  Log.e("ENDCODE", endcode);
//                if (example != null && example.getListArea() != null) {
//                    myAdapterCity.setItems(example.getListArea());
//                    rvListCity.setAdapter(myAdapterCity);
//                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
//                    rvListCity.setLayoutManager(linearLayoutManager);
//                } else {
//                    Toast.makeText(mContext, "Lỗi Data", Toast.LENGTH_SHORT).show();
//                }

                listAreaList=new ArrayList<>();
                listAreaList.addAll(example.getListArea());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    listAreaList.sort(Comparator.comparing(Example.ListArea::getFullName));
                }
                setListAreaList(listAreaList);
                MyAdapterCity adapterCity=new MyAdapterCity(mContext,listAreaList);
                setMyAdapterCity(adapterCity);
            }

            @Override
            public void onFailure(Call<ResponseBase64> call, Throwable t) {
                Log.e("EROR", t.getMessage());
                Toast.makeText(mContext, "Lỗi mẹ rồi còn gì", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
