package com.luongthuan.testapi.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestHeader {
    @SerializedName("channelCode")
    @Expose
    public String channelCode;
    @SerializedName("clientAddress")
    @Expose
    public String clientAddress;
    @SerializedName("clientRequestId")
    @Expose
    public String clientRequestId;
    @SerializedName("clientSessionId")
    @Expose
    public String clientSessionId;
    @SerializedName("deviceId")
    @Expose
    public String deviceId;
    @SerializedName("exchangeIV")
    @Expose
    public String exchangeIV;
    @SerializedName("language")
    @Expose
    public String language;
    @SerializedName("platform")
    @Expose
    public String platform;
    @SerializedName("platformVersion")
    @Expose
    public String platformVersion;
    @SerializedName("sdkId")
    @Expose
    public String sdkId;
    @SerializedName("secretKey")
    @Expose
    public String secretKey;
    @SerializedName("signature")
    @Expose
    public String signature;
    @SerializedName("systemCode")
    @Expose
    public String systemCode;

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

    public String getClientSessionId() {
        return clientSessionId;
    }

    public void setClientSessionId(String clientSessionId) {
        this.clientSessionId = clientSessionId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getExchangeIV() {
        return exchangeIV;
    }

    public void setExchangeIV(String exchangeIV) {
        this.exchangeIV = exchangeIV;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getSdkId() {
        return sdkId;
    }

    public void setSdkId(String sdkId) {
        this.sdkId = sdkId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }


    @Override
    public String toString() {
        return "RequestHeader{" +
                "channelCode='" + channelCode + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientRequestId='" + clientRequestId + '\'' +
                ", clientSessionId='" + clientSessionId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", exchangeIV='" + exchangeIV + '\'' +
                ", language='" + language + '\'' +
                ", platform='" + platform + '\'' +
                ", platformVersion='" + platformVersion + '\'' +
                ", sdkId='" + sdkId + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", signature='" + signature + '\'' +
                ", systemCode='" + systemCode + '\'' +
                '}';
    }
}
