package com.hypq.springbootmybatis.controller;


import com.hypq.springbootmybatis.domain.UserTable;

import com.hypq.springbootmybatis.service.UserService;
import com.hypq.springbootmybatis.utils.RedisUtils;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping("/login")
   public void userLogin(UserTable userTable , HttpServletRequest request, HttpServletResponse response) {

        UserTable user = service.getByUsername(userTable.getUsername());
        if (user == null) {
            try {
                response.getWriter().write("faile");

            } catch (Exception e) {

            }
        } else {
            if (user.getPassword().equals(userTable.getPassword())) {
                //登录成功

                HttpSession session=request.getSession();
                String sessionid=session.getId();
                Cookie cookie=new Cookie("JSESSIONID",sessionid);
                cookie.setMaxAge(30*60);
                response.addCookie(cookie);
                session.setMaxInactiveInterval(30*60);
                session.setAttribute("userinfo", user);

            } else {

                try {
                    response.getWriter().write("faile");

                } catch (Exception e) {

                }
            }
        }

    }
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public UserTable getUserInfo(HttpServletRequest request){
        UserTable user = (UserTable)request.getSession().getAttribute("userinfo");
        return user;

    }

    @RequestMapping("/logOut")
    @ResponseBody
    public String logOut(HttpServletRequest request){
       request.getSession().invalidate();
        return "ok";

    }
}
