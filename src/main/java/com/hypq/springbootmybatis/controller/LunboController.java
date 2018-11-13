package com.hypq.springbootmybatis.controller;

import com.github.pagehelper.PageHelper;
import com.hypq.springbootmybatis.domain.LunbotuTable;
import com.hypq.springbootmybatis.service.LunboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LunboController {
    @Autowired
    LunboService service;
    @RequestMapping("/getItems")
    @ResponseBody
    public Map<String,Object> getItems(int page,int limit){
        PageHelper.startPage(page,limit);
      List<LunbotuTable> list= service.getItems();
      int count = service.getCount();
      Map<String,Object> map = new HashMap<String,Object>();
      map.put("code",0);
      map.put("msg",null);
      map.put("count",count);
      map.put("data",list);
      return map;
    }
}
