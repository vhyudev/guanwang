package com.hypq.springbootmybatis.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.hypq.springbootmybatis.domain.User;
import com.hypq.springbootmybatis.service.UserService;
import com.hypq.springbootmybatis.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@RestController
public class UserController {

    @Resource
    private UserService userService;
    @Autowired
    RedisUtils ru;

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

        return "/hello.html";

    }


    @RequestMapping("/test2")
    public String test() {
        Object cccc = ru.get("cccc");
        return cccc.toString();
    }
}
