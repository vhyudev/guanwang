package com.hypq.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.hypq.springbootmybatis.dao.NewsTableMapper;
import com.hypq.springbootmybatis.domain.NewsTable;
import com.hypq.springbootmybatis.domain.User;
import com.hypq.springbootmybatis.service.UserService;
import com.hypq.springbootmybatis.utils.CreateHtmlUtils;
import com.hypq.springbootmybatis.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    NewsTableMapper mapper;

    @RequestMapping(value = "/test",produces = MediaType.APPLICATION_JSON_VALUE)
    public void getUser(String callback, HttpServletResponse response) {
        PageHelper.startPage(0, 1);
        List<User> list = userService.getAll();
        String s = JSON.toJSONString(list);
        System.out.println(s);

        try {
           // response.getWriter().write(callback + "(" + s + ")");
            response.getWriter().write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/test33",produces = MediaType.APPLICATION_JSON_VALUE)
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
    public NewsTable test() {
        NewsTable nt=mapper.selectByPrimaryKey("1");

        return nt;
    }
    @RequestMapping("/freemarker")
    public String freemarker(Map<String, Object> map, HttpServletRequest request){
        map.put("name", "Joe");
        map.put("sex", 1);    //sex:性别，1：男；0：女；

        // 模拟数据
        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "xbq");
        friend.put("age", 22);
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "July");
        friend.put("age", 18);
        friends.add(friend);
        map.put("friends", friends);
        CreateHtmlUtils.createHtmlFromModel(map,request);
        return "freemarker";
    }

}
