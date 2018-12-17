package com.hypq.springbootmybatis.domain;

public class ZiyuanTableWithBLOBs extends ZiyuanTable {
    private String remark;

    private String remark1;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }
}