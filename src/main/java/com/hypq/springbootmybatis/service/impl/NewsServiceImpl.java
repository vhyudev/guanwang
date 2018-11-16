package com.hypq.springbootmybatis.service.impl;

import com.hypq.springbootmybatis.dao.NewsTableMapper;
import com.hypq.springbootmybatis.domain.NewsTable;
import com.hypq.springbootmybatis.domain.NewsTableExample;
import com.hypq.springbootmybatis.service.NewsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
    @Resource
    NewsTableMapper mapper;

    @Override
    public List<NewsTable> getall() {
        NewsTableExample e = new NewsTableExample();
        List<NewsTable> newsTables = mapper.selectByExample(e);
        return newsTables;
    }

    @Override
    public List<NewsTable> getByType(String type) {
        List<NewsTable> newsTables = mapper.getByType(type);
        return newsTables;
    }

    @Override
    public int getNewsCount(String type) {
        int count = mapper.getNewsCount(type);
        return count;
    }

    @Override
    public int getNewsCount() {
        NewsTableExample e = new NewsTableExample();
        int count = mapper.countByExample(e);
        return count;
    }

}
