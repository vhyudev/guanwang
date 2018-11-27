package com.hypq.springbootmybatis.controller;


import com.hypq.springbootmybatis.domain.UserTable;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/backmanagement/*", filterName = "authFilter")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("进入拦截器");
        String uri = request.getRequestURI();
        System.out.println(uri);
        if(uri.contains("login")) {
            filterChain.doFilter(request,response);
        }else {
            //查询当前用户是否已经登录
            HttpSession session = request.getSession();
            Object userinfo = session.getAttribute("userinfo");

            if(userinfo!=null){
                System.out.println((UserTable)userinfo);
                filterChain.doFilter(request,response);

            }else {
                response.sendRedirect(request.getContextPath()+"/backmanagement/login.html");
            }

        }

    }

    @Override
    public void destroy() {

    }
}

