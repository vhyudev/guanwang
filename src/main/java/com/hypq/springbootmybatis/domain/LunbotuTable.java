package com.hypq.springbootmybatis.domain;

public class LunbotuTable {
    private String id;

    private String picdesc;

    private String picname;

    private String src;

    private String url;

    private String bgcolor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPicdesc() {
        return picdesc;
    }

    public void setPicdesc(String picdesc) {
        this.picdesc = picdesc == null ? null : picdesc.trim();
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname == null ? null : picname.trim();
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor == null ? null : bgcolor.trim();
    }

    @Override
    public String toString() {
        return "LunbotuTable{" +
                "id='" + id + '\'' +
                ", picdesc='" + picdesc + '\'' +
                ", picname='" + picname + '\'' +
                ", src='" + src + '\'' +
                ", url='" + url + '\'' +
                ", bgcolor='" + bgcolor + '\'' +
                '}';
    }
}