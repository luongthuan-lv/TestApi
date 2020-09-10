package com.luongthuan.testapi.adpter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luongthuan.testapi.R;
import com.luongthuan.testapi.model.Example;
import com.luongthuan.testapi.view.MainActivity2;
import com.luongthuan.testapi.view.MainActivity3;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterDistrict extends RecyclerView.Adapter<MyAdapterDistrict.CityHolder> {
    public List<Example.ListArea> listAreaList;
    Context context;

    public MyAdapterDistrict(Context context) {
        listAreaList = new ArrayList<>();
        this.context = context;
    }

    public void setItems(List<Example.ListArea> items) {
        listAreaList.clear();
        listAreaList = items;
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
        holder.tvAreaName.setText(listAreaList.get(position).getAreaName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, MainActivity3.class);
                Bundle bundle = new Bundle();
                bundle.putString("areaCode", listAreaList.get(position).getAreaCode());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listAreaList.size();
    }

    public class CityHolder extends RecyclerView.ViewHolder {
        TextView tvAreaName;

        public CityHolder(@NonNull View itemView) {
            super(itemView);
            tvAreaName = itemView.findViewById(R.id.tvAreaName);
        }
    }
}
