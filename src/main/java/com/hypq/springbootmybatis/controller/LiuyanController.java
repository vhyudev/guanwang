package com.hypq.springbootmybatis.controller;


import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.hypq.springbootmybatis.domain.LiuyanTable;
import com.hypq.springbootmybatis.domain.LunbotuTable;
import com.hypq.springbootmybatis.domain.UserTable;
import com.hypq.springbootmybatis.service.LiuyanService;
import com.hypq.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LiuyanController {
    @Resource
    LiuyanService service;



    @RequestMapping("/addLiuyan")
    @ResponseBody
    public String logOut(LiuyanTable liuyan){
        service.addliuyan(liuyan);
        return "ok";

    }

    @RequestMapping("/getliuyan")
    @ResponseBody
    public Map<String, Object> getItems(String page, String limit) {
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        if (StringUtils.isEmpty(limit)) {
            limit = "10";
        }
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<LiuyanTable> list = service.getItems();
        int count = service.getCount();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", null);
        map.put("count", count);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/deleteLiuyan")
    @ResponseBody
    public Map<String, String> deleteLunbotu(String id) {
        Map<String, String> map = new HashMap<>();
        try {
            service.deleteLiuyan(id);

            map.put("msg", "ok");
            return map;
        } catch (Exception e) {
            map.put("msg", "fail");
            return map;
        }


    }

}
