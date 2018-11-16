package com.hypq.springbootmybatis.service;

import com.hypq.springbootmybatis.domain.SuccessTable;

import java.util.List;

public interface SuccessService {
    int getCount();
    List<SuccessTable> getAll();
}
