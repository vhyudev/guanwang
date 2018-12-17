package com.hypq.springbootmybatis.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.hypq.springbootmybatis.domain.ZiyuanTableWithBLOBs;
import com.hypq.springbootmybatis.service.ZiyuanService;
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
public class ZiyuanController {
    @Autowired
    ZiyuanService service;

    @RequestMapping("/getZiyuan")
    @ResponseBody
    public List<ZiyuanTableWithBLOBs> getByPage(int pnum, int psize) {
        PageHelper.startPage(pnum, psize);
        List<ZiyuanTableWithBLOBs> list = service.getAll();
        return list;
    }

    @RequestMapping("/getziyuanpagecount")
    @ResponseBody
    public Map<String, Integer> getPageCount(int psize) {
        int count = service.getCount();
        int pagenum = count % psize == 0 ? count / psize : count / psize + 1;
        Map<String, Integer> map = new HashMap<>();
        map.put("pagecount", pagenum);
        map.put("count", count);
        return map;
    }

    @RequestMapping("/addZiyuancase")
    @ResponseBody
    public Map<String, String> addLunbotu(ZiyuanTableWithBLOBs st) {
        Map<String, String> map = new HashMap<>();
        try {
            service.addZiyuan(st);

            map.put("msg", "ok");
            return map;
        } catch (Exception e) {
            map.put("msg", "fail");
            return map;
        }


    }

    @RequestMapping("/getZiyuanItems")
    @ResponseBody
    public Map<String, Object> getItems(String page, String limit) {
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        if (StringUtils.isEmpty(limit)) {
            limit = "10";
        }
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
        List<ZiyuanTableWithBLOBs> list = service.getZiyuanItems();
        int count = service.getCount();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", null);
        map.put("count", count);
        map.put("data", list);
        return map;
    }

    @RequestMapping("/deleteZiyuanCase")
    @ResponseBody
    public Map<String, String> deleteZiyuanCase(String id) {
        Map<String, String> map = new HashMap<>();
        try {
            service.deleteZiyuanCase(id);

            map.put("msg", "ok");
            return map;
        } catch (Exception e) {
            map.put("msg", "fail");
            return map;
        }


    }

    @RequestMapping("/getZiyuanById")
    @ResponseBody
    public ZiyuanTableWithBLOBs getZiyuanById(Integer id) {
        return service.getZiyuanById(id);
    }

    @RequestMapping("/ZUpandDown")
    @ResponseBody
    public Map<String,ZiyuanTableWithBLOBs> UpandDown(Integer id) {
        return service.getUpandDown(id);
    }

}

