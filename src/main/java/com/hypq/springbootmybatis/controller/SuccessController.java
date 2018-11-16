package com.hypq.springbootmybatis.controller;

import com.github.pagehelper.PageHelper;
import com.hypq.springbootmybatis.domain.SuccessTable;
import com.hypq.springbootmybatis.service.SuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SuccessController {
    @Autowired
    SuccessService service;
    @RequestMapping("/getsuccess")
    @ResponseBody
    public List<SuccessTable> getByPage(int pnum,int psize){
        PageHelper.startPage(pnum,psize);
        List<SuccessTable> list=service.getAll();
        return list;
    }

    @RequestMapping("/getpagecount")
    @ResponseBody
    public Map<String,Integer> getPageCount(int psize){
        int count = service.getCount();
        int pagenum=count%psize==0?count/psize:count/psize+1;
        Map<String,Integer> map = new HashMap<>();
        map.put("pagecount",pagenum);
        map.put("count",count);
        return map;
    }
}
