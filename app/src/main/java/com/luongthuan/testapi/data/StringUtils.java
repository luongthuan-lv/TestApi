package com.luongthuan.testapi.data;

import android.util.Base64;

import com.google.gson.Gson;
import com.luongthuan.testapi.data.Config;

import java.io.UnsupportedEncodingException;

public class StringUtils {
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
