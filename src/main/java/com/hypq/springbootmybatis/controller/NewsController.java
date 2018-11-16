package com.hypq.springbootmybatis.controller;

import com.github.pagehelper.PageHelper;
import com.hypq.springbootmybatis.domain.NewsTable;
import com.hypq.springbootmybatis.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NewsController {
    @Resource
    NewsService nservice;

    @RequestMapping("/getnews")
    @ResponseBody
    public List<NewsTable> getNewsByPage(int pnum,int psize,String type){
        PageHelper.startPage(pnum,psize);
        List<NewsTable> list ;
        if(type == null || "".equals(type)){
            list=nservice.getall();
        }else{
            list = nservice.getByType(type);
        }


        return list;
    }
    @RequestMapping("/getnewsCount")
    @ResponseBody
    public Map<String,Object> getNewsCount(int psize,String type){
        int count;
        if(type == null || "".equals(type)){
            count = nservice.getNewsCount();
        }else{
             count = nservice.getNewsCount(type);
        }

        int pagenum=count%psize==0?count/psize:count/psize+1;
        Map<String,Object> map = new HashMap<>();
        map.put("pagecount",pagenum);
        map.put("count",count);
        return map;
    }
}
