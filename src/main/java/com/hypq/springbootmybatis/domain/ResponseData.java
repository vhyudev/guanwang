package com.hypq.springbootmybatis.domain;

public class ResponseData {
    private Object data;
    private String responseMsg;
    private String responseCode;

    public Object getData() {
        return data;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
