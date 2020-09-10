package com.luongthuan.testapi.data;

import com.luongthuan.testapi.request.RequestHeader;

public class Config {
    public static final String CHARSET_NAME = "UTF-8";
    public static final int CONNECT_TIMEOUT = 30 * 1000;
    public static class Header{
        static RequestHeader requestHeader;
        static String channelCode;
        static Long channelId;
        static String clientAddress;
        static String clientRequestId;
        static String clientSessionId;
        static String deviceId;
        static String exchangeIV;
        static String language;
        static String partnerCode;
        static String platform;
        static String platformVersion;
        static String sdkId;
        static String secretKey;
        static String signature;
        static String systemCode;
        static String token;

        static void setHeader() {
            if (requestHeader == null) {
                requestHeader = new RequestHeader();
            }
            requestHeader.setChannelCode("VIVIET_APP");
            requestHeader.setClientAddress("127.0.0.1");
            requestHeader.setClientRequestId("1234567");
            requestHeader.setClientSessionId("");
            requestHeader.setDeviceId("abc-123-def-456");
            requestHeader.setExchangeIV("");
            requestHeader.setLanguage("vi");
            requestHeader.setPlatform("android");
            requestHeader.setPlatformVersion("");
            requestHeader.setSdkId("123");
            requestHeader.setSecretKey("");
            requestHeader.setSignature("");
            requestHeader.setSystemCode("VIVIET");

        }
        public static void setClientRequestId(String clientRequestId) {
            Header.clientRequestId = clientRequestId;
            setHeader();
        }

        public static RequestHeader getHeader() {
            return requestHeader;
        }
    }
}
