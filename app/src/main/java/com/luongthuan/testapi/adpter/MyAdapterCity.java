package com.luongthuan.testapi.adpter;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.luongthuan.testapi.R;
import com.luongthuan.testapi.data.BindingUtils;
import com.luongthuan.testapi.databinding.RowBinding;
import com.luongthuan.testapi.model.AreaRequest;
import com.luongthuan.testapi.model.Example;
import com.luongthuan.testapi.request.ReqApiUtils;
import com.luongthuan.testapi.request.RequestBase64;
import com.luongthuan.testapi.response.Repository;
import com.luongthuan.testapi.response.ResponseBase64;
import com.luongthuan.testapi.server.AdapterListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.katso.livebutton.LiveButton;

public class MyAdapterCity extends RecyclerView.Adapter<MyAdapterCity.CityHolder> {
    public List<Example.ListArea> listAreaList;
    Context context;
    public LayoutInflater layoutInflater;


    public MyAdapterCity(Context context, List<Example.ListArea> listAreaList) {
        this.listAreaList = listAreaList;
        this.context = context;
    }

    public void setItems(List<Example.ListArea> items) {

            listAreaList.clear();
            listAreaList.addAll(items);
            notifyDataSetChanged();

    }

    @NonNull
    @Override
    public CityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        RowBinding rowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.row, parent, false);
        return new CityHolder(rowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CityHolder holder, int position) {
        holder.rowBinding.setListarea(listAreaList.get(position));
        holder.rowBinding.btnLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listAreaList.get(position).getAreaType().equals("P")) {
                    getRetrofit("D", listAreaList.get(position).getAreaCode());
                } else if (listAreaList.get(position).getAreaType().equals("D")) {
                    getRetrofit("C", listAreaList.get(position).getAreaCode());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listAreaList == null) {
            return 0;
        } else
            return listAreaList.size();
    }

    public void getRetrofit(String areaType, String parentCode) {

        String body = BindingUtils.convertObjectToBase64(new AreaRequest(areaType, parentCode));
        Log.e("BODY", body);
        RequestBase64 requestBase64 = ReqApiUtils.createRequest(body, context);
        Repository.getInstance().getAreaCity(requestBase64).enqueue(new Callback<ResponseBase64>() {
            @Override
            public void onResponse(Call<ResponseBase64> call, Response<ResponseBase64> response) {
                // convert decode sang endcode
                String decode = response.body().getBody();
                String endcode = new String(Base64.decode(decode, Base64.DEFAULT));
                Example example = new Gson().fromJson(endcode, Example.class);
                Log.e("DATA_NAY", example.getListArea().size() + "");
                Log.e("ENDCODE", endcode);

                    ArrayList<Example.ListArea> arrayList = new ArrayList<>();
                    arrayList.addAll(example.getListArea());
                    setItems(arrayList);
            }

            @Override
            public void onFailure(Call<ResponseBase64> call, Throwable t) {
                Log.e("EROR", t.getMessage());
                Toast.makeText(context, "Lại lỗi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class CityHolder extends RecyclerView.ViewHolder {
        public final RowBinding rowBinding;

        public CityHolder(@NonNull RowBinding itemView) {
            super(itemView.getRoot());
            this.rowBinding = itemView;
        }
    }
}
