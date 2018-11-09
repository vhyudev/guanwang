package com.hypq.springbootmybatis.controller;



import com.hypq.springbootmybatis.dao.NewsDao;
import com.hypq.springbootmybatis.domain.ResponseData;
import com.hypq.springbootmybatis.domain.newsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class NewsController {
    @Resource
    NewsDao newsDao;
    @RequestMapping(value = "/loadNews")
    public ResponseData loadNews(){
        ResponseData rdata = new ResponseData();
        newsEntity ne = newsDao.queryById("1");
        System.out.println(ne.getDate());
        return rdata;
    }
}
