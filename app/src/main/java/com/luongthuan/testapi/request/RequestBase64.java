package com.luongthuan.testapi.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.luongthuan.testapi.request.RequestHeader;

public class RequestBase64 {
    @SerializedName("restHeader")
    @Expose
    public RequestHeader requestHeader;

    @SerializedName("body")
    @Expose
    public String body;

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "RequestBase64{" +
                "restHeader=" + requestHeader +
                ", body='" + body + '\'' +
                '}';
    }
}
