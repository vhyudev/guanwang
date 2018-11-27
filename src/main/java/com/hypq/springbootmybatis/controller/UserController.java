package com.hypq.springbootmybatis.controller;


import com.hypq.springbootmybatis.domain.UserTable;

import com.hypq.springbootmybatis.service.UserService;
import com.hypq.springbootmybatis.utils.RedisUtils;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping("/login")
   public void userLogin(UserTable userTable , HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserTable user = service.getByUsername(userTable.getUsername());
        if (user == null) {
            try {
                response.getWriter().write("faile");

            } catch (Exception e) {

            }
        } else {
            if (user.getPassword().equals(userTable.getPassword())) {
                //登录成功
                session.setAttribute("userinfo", user);

            } else {

                try {
                    response.getWriter().write("faile");

                } catch (Exception e) {

                }
            }
        }

    }
}
