package com.hypq.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.hypq.springbootmybatis.dao.NewsDetailMapper;
import com.hypq.springbootmybatis.domain.NewsDetail;
import com.hypq.springbootmybatis.domain.NewsDetailExample;
import com.hypq.springbootmybatis.domain.User;
import com.hypq.springbootmybatis.service.UserService;
import com.hypq.springbootmybatis.utils.CreateHtmlUtils;
import com.hypq.springbootmybatis.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Resource
    private UserService userService;
    @Autowired
    RedisUtils ru;
    @Resource
    NewsDetailMapper mapper;


    @RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public void getUser(String callback, HttpServletResponse response) {
        PageHelper.startPage(0, 1);
        List<User> list = userService.getAll();
        String s = JSON.toJSONString(list);
        try {
            // response.getWriter().write(callback + "(" + s + ")");
            response.getWriter().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/test33", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUser2(String callback, HttpServletResponse response) {
        // PageHelper.startPage(0, 1);
        List<User> list = userService.getAll();
        System.out.println("hehe");
        return list;

    }

    @RequestMapping(value = "/test4")
    public String a(String callback, HttpServletResponse response) {

        return "/index.html";

    }


    @RequestMapping("/test2")
    @ResponseBody
    public List<NewsDetail>  test(int pagenum,int pagesize) {
        System.out.println(pagenum);
        System.out.println(pagesize);
        PageHelper.startPage(pagenum,pagesize);//pagenum 0 和 1 代表的都是的第一页
        NewsDetailExample example = new NewsDetailExample();
        List<NewsDetail> newsTables = mapper.selectByExample(example);
        return newsTables;
    }

    @RequestMapping("/freemarker")
    public String freemarker(Map<String, Object> map, HttpServletRequest request) {
        map.put("name", "Joe");
        map.put("sex", 1);    //sex:性别，1：男；0：女；

        // 模拟数据
        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "333");
        friend.put("age", 22);
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "July");
        friend.put("age", 22);
        friends.add(friend);
        map.put("friends", friends);
        CreateHtmlUtils.createHtmlFromModel(map, request);
        return "freemarker";
    }

}
