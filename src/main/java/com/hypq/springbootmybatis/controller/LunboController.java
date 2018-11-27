package com.hypq.springbootmybatis.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.hypq.springbootmybatis.domain.LunbotuTable;
import com.hypq.springbootmybatis.service.LunboService;
import com.hypq.springbootmybatis.utils.Picupload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LunboController {
    @Autowired
    LunboService service;

    @RequestMapping("/getItems")
    @ResponseBody
    public Map<String, Object> getItems(String page, String limit) {
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        if (StringUtils.isEmpty(limit)) {
            limit = "10";
        }
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<LunbotuTable> list = service.getItems();
        int count = service.getCount();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", null);
        map.put("count", count);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, String> fileUpload_2(MultipartFile file, HttpServletRequest request) throws IOException {
        Picupload.upload(file, request, "D:\\pic\\");
        Map<String, String> map = new HashMap<>();
        map.put("src", "url(pic/" + file.getOriginalFilename() + ")");
        map.put("status", "ok");
        return map;
    }

    @RequestMapping("/addLunbotu")
    @ResponseBody
    public Map<String, String> addLunbotu(LunbotuTable lunbotu) {
        Map<String, String> map = new HashMap<>();
        try {
            service.addLunbotu(lunbotu);
            System.out.println(lunbotu.toString());
            map.put("msg", "ok");
            return map;
        } catch (Exception e) {
            map.put("msg", "fail");
            return map;
        }


    }

    @RequestMapping("/deleteLunbotu")
    @ResponseBody
    public Map<String, String> deleteLunbotu(String id) {
        Map<String, String> map = new HashMap<>();
        try {
            service.deleteLunbotu(id);

            map.put("msg", "ok");
            return map;
        } catch (Exception e) {
            map.put("msg", "fail");
            return map;
        }


    }
}
