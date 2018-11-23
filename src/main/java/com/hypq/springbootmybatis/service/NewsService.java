package com.hypq.springbootmybatis.service;

import com.hypq.springbootmybatis.domain.NewsDetail;

import java.util.List;

public interface NewsService {
    List<NewsDetail> getall();
    List<NewsDetail> getByType(String type);
    int getNewsCount(String type);
    int getNewsCount();
    void addNews(NewsDetail nd);
    int deleteById(String id);
    NewsDetail getNewsById(String id);
    int updateNews(NewsDetail nd);

}
