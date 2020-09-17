package com.luongthuan.testapi.data;

import android.util.Base64;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.luongthuan.testapi.data.Config;

import java.io.UnsupportedEncodingException;

public class BindingUtils {

    @BindingAdapter("setAdapter")
    public static void RecyclerViewAdapter(RecyclerView recyclerView,RecyclerView.Adapter<?> adapter){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }
    public static String convertObjectToBase64(Object o) {
        Gson gson = new Gson();
        String json = gson.toJson(o);
        byte[] data = new byte[0];
        try {
            data = json.getBytes(Config.CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String base64 = Base64.encodeToString(data, Base64.DEFAULT);
        return base64.replaceAll("\n", "");
    }

}
