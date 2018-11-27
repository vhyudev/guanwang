package com.hypq.springbootmybatis.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.hypq.springbootmybatis.dao.NewsDetailMapper;
import com.hypq.springbootmybatis.domain.NewsDetail;
import com.hypq.springbootmybatis.domain.ResponseData;
import com.hypq.springbootmybatis.service.NewsService;
import com.hypq.springbootmybatis.utils.Picupload;
import com.hypq.springbootmybatis.vo.NewsDtailVO;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.awt.geom.AreaOp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NewsController {
    @Resource
    NewsService nservice;
    @Resource
    NewsDetailMapper ndm;

    @RequestMapping("/newsTest")
    @ResponseBody
    public List<NewsDetail> test(){
        List<NewsDetail> list = new ArrayList<NewsDetail>();
        try{
            NewsDetail nd =ndm.getLatestNews();
            list.add(nd);
        }catch (Exception e ){
            e.printStackTrace();
        }




        return list;
    }
    @RequestMapping("/getnews")
    @ResponseBody
    public List<NewsDetail> getNewsByPage(int pnum,int psize,String type){
        PageHelper.startPage(pnum,psize);
        List<NewsDetail> list ;
        if(type == null || "".equals(type)){
            list=nservice.getall();
        }else{
            list = nservice.getByType(type);
        }


        return list;
    }
    @RequestMapping("/getnewsCount")
    @ResponseBody
    public Map<String,Object> getNewsCount(int psize,String type){
        int count;
        if(type == null || "".equals(type)){
            count = nservice.getNewsCount();
        }else{
             count = nservice.getNewsCount(type);
        }

        int pagenum=count%psize==0?count/psize:count/psize+1;
        Map<String,Object> map = new HashMap<>();
        map.put("pagecount",pagenum);
        map.put("count",count);
        return map;
    }
    @RequestMapping("/leftNewsquery")
    @ResponseBody
    public ResponseData queryLeftNews(String type){
        PageHelper.startPage(1,6);
        ResponseData rq = new ResponseData();
        try {
            List<NewsDetail> list = nservice.getByType(type);
            rq.setData(list);
            rq.setResponseCode("0h");
            rq.setResponseMsg("success");
            if(list == null || list.size() == 0){
                rq.setResponseCode("1");
                rq.setResponseMsg("没查到数据");
            }
        }catch (Exception e){
            e.printStackTrace();
            rq.setData(null);
            rq.setResponseCode("1");
            rq.setResponseMsg("error");
        }


        return rq;
    }

    @RequestMapping("/addNews")
    @ResponseBody
    public ResponseData addNews(NewsDetail st){
        ResponseData rq = new ResponseData();
        try {
            nservice.addNews(st);
            rq.setResponseCode("0");
            rq.setResponseMsg("保存成功");
        }catch (Exception e){
            e.printStackTrace();
            rq.setData(null);
            rq.setResponseCode("1");
            rq.setResponseMsg("error");
        }
        return rq;
    }
    @RequestMapping("/getNewsItems")
    @ResponseBody
    public Map<String,Object> getNewsItems(String page,String limit){
        if (StringUtils.isEmpty(page)) {
            page = "1";
        }
        if (StringUtils.isEmpty(limit)) {
            limit = "10";
        }
        Map<String,Object> map = new HashMap<String,Object>();
        PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(limit));
        int count = 0;
        try {
            List<NewsDetail> list = nservice.getall();
            count = nservice.getNewsCount();
            map.put("code", 0);
            map.put("msg", "拉取成功");
            map.put("count", count);
            map.put("data", list);
        }catch(Exception e ){
            e.printStackTrace();
            map.put("code", 1);
            map.put("msg", "拉取失败");
            map.put("count", count);
            map.put("data", null);
        }

        return map;
    }
    @RequestMapping("/deleteNews")
    @ResponseBody
    public ResponseData deleteNews(String id){
        ResponseData rd = new ResponseData();

        try {
            nservice.deleteById(id);
            rd.setResponseCode("0");
            rd.setResponseMsg("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            rd.setResponseCode("1");
            rd.setResponseMsg("删除失败");
            rd.setData(null);

        }
        return rd;

    }
    @RequestMapping("/uploadNewsPic")
    @ResponseBody
    public Map<String,Object> uploadPic(MultipartFile file, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        try {
            String name= file.getOriginalFilename();
            Picupload.upload(file,request,"D:\\pic\\");
            String url="/pic/"+name;
            map.put("error",0);
            map.put("url",url);
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("message","上传错误");
            return map ;
        }


    }
    @RequestMapping("/getArticle")
    @ResponseBody
    public ResponseData getArticle(String id){
        ResponseData rd = new ResponseData();
        NewsDtailVO ndVo = new NewsDtailVO();

        NewsDetail nd = null;//当前文章
        NewsDetail nextNd = null;//下一篇
        NewsDetail beforeNd = null;//上一篇
        try {
            nd = nservice.getNewsById(id);
            String nextId = nd.getNextArticle();
            String beforeId = nd.getBeforeArticle();
            if(nd == null){
                rd.setData(null);
                rd.setResponseCode("1");
                rd.setResponseMsg("查询失败");
                return rd;
            }
            nd.setClickcount(nd.getClickcount()+1);
            nservice.updateNews(nd);//增加点击量
            ndVo.setNd(nd);
            if(nextId != null && !"".equals(nextId)){
                nextNd = nservice.getNewsById(nextId);
            }
            if(beforeId != null && !"".equals(beforeId)){
                beforeNd = nservice.getNewsById(beforeId);
            }
            if(nextNd != null){
                ndVo.setNextId(nextId);
                ndVo.setNextPublishDate(nextNd.getPublishDate());
                ndVo.setNextTitle(nextNd.getTitle());
                ndVo.setNextUrl("newsDetail.html?id="+nextId);
            }
            if(beforeNd != null ){
                ndVo.setBeforeId(beforeId);
                ndVo.setBeforePublishDate(beforeNd.getPublishDate());
                ndVo.setBeforeTitle(beforeNd.getTitle());
                ndVo.setBeforeUrl("newsDetail.html?id="+beforeId);
            }
            rd.setData(ndVo);
            rd.setResponseMsg("ok");
            rd.setResponseCode("0");
        }catch (Exception e){
            e.printStackTrace();
            rd.setData(null);
            rd.setResponseCode("1");
            rd.setResponseMsg(e.getMessage());
        }
        return rd;
    }

    public static void main(String[] args) {
        Integer a = 0;
        int b = a+1;
        System.out.println(b);
    }
}
