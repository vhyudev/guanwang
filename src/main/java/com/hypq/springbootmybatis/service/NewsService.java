package com.hypq.springbootmybatis.service;

import com.hypq.springbootmybatis.domain.NewsTable;

import java.util.List;

public interface NewsService {
    List<NewsTable> getall();
    List<NewsTable> getByType(String type);
    int getNewsCount(String type);
    int getNewsCount();

}
