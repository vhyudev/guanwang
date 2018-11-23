package com.hypq.springbootmybatis.vo;

import com.hypq.springbootmybatis.domain.NewsDetail;

import java.util.Date;

public class NewsDtailVO {
    private NewsDetail nd ;
    private String nextTitle;
    private Date nextPublishDate;
    private String nextId;
    private  String nextUrl;
    private String beforeTitle;
    private Date beforePublishDate;
    private String beforeId;
    private String beforeUrl;

    public void setNd(NewsDetail nd) {
        this.nd = nd;
    }

    public void setNextTitle(String nextTitle) {
        this.nextTitle = nextTitle;
    }

    public void setNextPublishDate(Date nextPublishDate) {
        this.nextPublishDate = nextPublishDate;
    }

    public void setNextId(String nextId) {
        this.nextId = nextId;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public void setBeforeTitle(String beforeTitle) {
        this.beforeTitle = beforeTitle;
    }

    public void setBeforePublishDate(Date beforePublishDate) {
        this.beforePublishDate = beforePublishDate;
    }

    public void setBeforeId(String beforeId) {
        this.beforeId = beforeId;
    }

    public void setBeforeUrl(String beforeUrl) {
        this.beforeUrl = beforeUrl;
    }

    public NewsDetail getNd() {
        return nd;
    }

    public String getNextTitle() {
        return nextTitle;
    }

    public Date getNextPublishDate() {
        return nextPublishDate;
    }

    public String getNextId() {
        return nextId;
    }

    public String getNextUrl() {
        return nextUrl;
    }

    public String getBeforeTitle() {
        return beforeTitle;
    }

    public Date getBeforePublishDate() {
        return beforePublishDate;
    }

    public String getBeforeId() {
        return beforeId;
    }

    public String getBeforeUrl() {
        return beforeUrl;
    }
}
