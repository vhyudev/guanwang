package com.hypq.springbootmybatis.service;

import com.hypq.springbootmybatis.domain.LiuyanTable;
import com.hypq.springbootmybatis.domain.LunbotuTable;

import java.util.List;

public interface LiuyanService {
    public void addliuyan(LiuyanTable liuyan);

    List<LiuyanTable> getItems();

    int getCount();

    void deleteLiuyan(String id);
}
