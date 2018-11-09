package com.hypq.springbootmybatis.dao;


import com.hypq.springbootmybatis.domain.newsEntity;

public interface NewsDao {
    public newsEntity queryById(String id);
}
