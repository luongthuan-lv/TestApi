
package com.luongthuan.testapi.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example extends BaseObservable {

    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("resultDesc")
    @Expose
    private String resultDesc;
    @SerializedName("listArea")
    @Expose
    private List<ListArea> listArea = null;

    @Bindable
    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Bindable
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @Bindable
    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    @Bindable
    public List<ListArea> getListArea() {
        return listArea;
    }

    public void setListArea(List<ListArea> listArea) {
        this.listArea = listArea;
    }

    public class ListArea extends BaseObservable {

        @SerializedName("redis_meta")
        @Expose
        private RedisMeta redisMeta;
        @SerializedName("redis_key")
        @Expose
        private String redisKey;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("areaType")
        @Expose
        private String areaType;
        @SerializedName("areaCode")
        @Expose
        private String areaCode;
        @SerializedName("parentCode")
        @Expose
        private String parentCode;
        @SerializedName("province")
        @Expose
        private String province;
        @SerializedName("district")
        @Expose
        private String district;
        @SerializedName("precinct")
        @Expose
        private String precinct;
        @SerializedName("areaName")
        @Expose
        private String areaName;
        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("orderNo")
        @Expose
        private String orderNo;
        @SerializedName("status")
        @Expose
        private String status;

        @Bindable
        public RedisMeta getRedisMeta() {
            return redisMeta;
        }

        public void setRedisMeta(RedisMeta redisMeta) {
            this.redisMeta = redisMeta;
        }

        @Bindable
        public String getRedisKey() {
            return redisKey;
        }

        public void setRedisKey(String redisKey) {
            this.redisKey = redisKey;
        }

        @Bindable
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Bindable
        public String getAreaType() {
            return areaType;
        }

        public void setAreaType(String areaType) {
            this.areaType = areaType;
        }

        @Bindable
        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        @Bindable
        public String getParentCode() {
            return parentCode;
        }

        public void setParentCode(String parentCode) {
            this.parentCode = parentCode;
        }

        @Bindable
        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        @Bindable
        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        @Bindable
        public String getPrecinct() {
            return precinct;
        }

        public void setPrecinct(String precinct) {
            this.precinct = precinct;
        }

        @Bindable
        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        @Bindable
        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        @Bindable
        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        @Bindable
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }

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
}
