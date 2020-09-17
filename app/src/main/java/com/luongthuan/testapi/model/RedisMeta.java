
package com.luongthuan.testapi.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RedisMeta extends BaseObservable {

    @SerializedName("timeMark")
    @Expose
    private Integer timeMark;

    @Bindable
    public Integer getTimeMark() {
        return timeMark;
    }

    public void setTimeMark(Integer timeMark) {
        this.timeMark = timeMark;
    }

}
