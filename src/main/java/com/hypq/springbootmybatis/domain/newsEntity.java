package com.hypq.springbootmybatis.domain;

public class newsEntity {
    private String id ;
    private String title;
    private String url;
    private String remark;
    private String remark1;
    private String date;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getRemark() {
        return remark;
    }

    public String getRemark1() {
        return remark1;
    }

    public String getDate() {
        return date;
    }
}
