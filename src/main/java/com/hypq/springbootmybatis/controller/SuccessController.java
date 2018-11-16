package com.hypq.springbootmybatis.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.hypq.springbootmybatis.domain.LunbotuTable;
import com.hypq.springbootmybatis.domain.SuccessTable;
import com.hypq.springbootmybatis.service.SuccessService;
import com.hypq.springbootmybatis.utils.Picupload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping("/uploadPic")
    @ResponseBody
    public Map<String,Object> uploadPic(MultipartFile file, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        try {
            Picupload.upload(file,request,"D:\\pic\\");
           String name= file.getOriginalFilename();
           String url="/pic/"+name;

            map.put("error",0);
            map.put("url",url);
           return map;
        }catch (Exception e){
            map.put("message","上传错误");
            return map ;
        }


    }

    @RequestMapping("/addSuccesscase")
    @ResponseBody
    public Map<String, String> addLunbotu(SuccessTable st) {
        Map<String, String> map = new HashMap<>();
        try {
            service.addSuccess(st);

            map.put("msg", "ok");
            return map;
        } catch (Exception e) {
            map.put("msg", "fail");
            return map;
        }


    }
    @RequestMapping("/getSuccessItems")
    @ResponseBody
    public Map<String, Object> getItems(String page, String limit) {
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        if (StringUtils.isEmpty(limit)) {
            limit = "10";
        }
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(limit));
        List<SuccessTable> list = service.getSuccessItems();
        int count = service.getCount();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", null);
        map.put("count", count);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/deleteSuccessCase")
    @ResponseBody
    public Map<String, String> deleteSuccessCase(String id) {
        Map<String, String> map = new HashMap<>();
        try {
            service.deleteSuccessCase(id);

            map.put("msg", "ok");
            return map;
        } catch (Exception e) {
            map.put("msg", "fail");
            return map;
        }


    }

    @RequestMapping("/getSuccessById")
    @ResponseBody
    public SuccessTable getSuccessById(Integer id){
       return service.getSuccessById(id);
    }
}
