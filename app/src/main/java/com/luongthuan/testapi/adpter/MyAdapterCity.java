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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.luongthuan.testapi.R;
import com.luongthuan.testapi.data.StringUtils;
import com.luongthuan.testapi.model.AreaRequest;
import com.luongthuan.testapi.model.Example;
import com.luongthuan.testapi.request.ReqApiUtils;
import com.luongthuan.testapi.request.RequestBase64;
import com.luongthuan.testapi.response.Repository;
import com.luongthuan.testapi.response.ResponseBase64;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.katso.livebutton.LiveButton;

public class MyAdapterCity extends RecyclerView.Adapter<MyAdapterCity.CityHolder> implements Filterable {
    public List<Example.ListArea> listAreaList;
   public ArrayList<Example.ListArea> arrayListOne;

    Context context;

    public MyAdapterCity(Context context, List<Example.ListArea> listAreaList) {
        this.listAreaList = listAreaList;

        this.context = context;
    }

    public void setItems(List<Example.ListArea> items) {
        listAreaList.clear();
        listAreaList.addAll(items);
        this.arrayListOne = new ArrayList<>(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new CityHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityHolder holder, int position) {
        holder.btnLive.setText(listAreaList.get(position).getAreaName());
        holder.btnLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        return listAreaList.size();
    }

    public void getRetrofit(String areaType, String parentCode) {

        String body = StringUtils.convertObjectToBase64(new AreaRequest(areaType, parentCode));
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
                Toast.makeText(context, "Lỗi mẹ rồi còn gì", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<Example.ListArea> arrayListTwo = new ArrayList<>();
            if (charSequence.length() == 0) {
                Toast.makeText(context, arrayListOne.size()+"", Toast.LENGTH_SHORT).show();
                arrayListTwo.addAll(arrayListOne);
            } else {

                for (int i = 0; i < arrayListOne.size(); i++) {
                    if (arrayListOne.get(i).getAreaName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        arrayListTwo.add(arrayListOne.get(i));
                    }
                }
                // setItems(arrayList);

            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = arrayListTwo;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            listAreaList.clear();
            listAreaList.addAll((Collection<? extends Example.ListArea>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class CityHolder extends RecyclerView.ViewHolder {
        LiveButton btnLive;

        public CityHolder(@NonNull View itemView) {
            super(itemView);
            btnLive = itemView.findViewById(R.id.btnLive);
        }
    }
}
