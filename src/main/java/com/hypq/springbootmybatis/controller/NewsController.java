package com.hypq.springbootmybatis.controller;

import com.github.pagehelper.PageHelper;
import com.hypq.springbootmybatis.domain.NewsTable;
import com.hypq.springbootmybatis.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class NewsController {
    @Resource
    NewsService nservice;

    @RequestMapping("/getnews")
    @ResponseBody
    public List<NewsTable> getNewsByPage(int pnum,int psize){
        PageHelper.startPage(pnum,psize);
        List<NewsTable> list=nservice.getall();
        return list;
    }
}
