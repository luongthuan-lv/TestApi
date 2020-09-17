package com.luongthuan.testapi.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AreaRequest extends BaseObservable {
    @SerializedName("areaType")
    @Expose
    private String areaType;
    @SerializedName("parentCode")
    @Expose
    private String parentCode;

    public AreaRequest(String areaType, String parentCode) {
        this.areaType = areaType;
        this.parentCode = parentCode;
    }

    @Bindable
    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    @Bindable
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
