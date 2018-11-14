package com.hypq.springbootmybatis.service;

import com.hypq.springbootmybatis.domain.LunbotuTable;

import java.util.List;

public interface LunboService {
    List<LunbotuTable> getItems();

    int getCount();

    void addLunbotu(LunbotuTable lunbotu);

    void deleteLunbotu(String id);
}
