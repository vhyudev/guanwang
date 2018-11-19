package com.hypq.springbootmybatis.service;

import com.hypq.springbootmybatis.domain.SuccessTable;

import java.util.List;
import java.util.Map;

public interface SuccessService {
    int getCount();
    List<SuccessTable> getAll();

    void addSuccess(SuccessTable st);

    List<SuccessTable> getSuccessItems();

    void deleteSuccessCase(String id);

    SuccessTable getSuccessById(Integer id);

    Map<String,SuccessTable> getUpandDown(Integer id);
}
