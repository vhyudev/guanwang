package com.hypq.springbootmybatis.utils;

import freemarker.core.ParseException;
import freemarker.template.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.net.URL;
import java.util.Map;

public class CreateHtmlUtils {

    public static void createHtmlFromModel(Map<String,Object> data,HttpServletRequest request) {
        FileWriter out = null;
        try {
            // 通过FreeMarker的Confuguration读取相应的模板文件
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
            // 设置模板路径
            configuration.setClassForTemplateLoading(CreateHtmlUtils.class, "/templates");
            // 设置默认字体
            configuration.setDefaultEncoding("utf-8");

            // 获取模板
            Template template = configuration.getTemplate("freemarker.ftl");
            CreateHtmlUtils s = new CreateHtmlUtils();
            String url = request.getSession().getServletContext().getRealPath("/");
            System.out.println(url);
            //设置输出文件
            File file = new File(url+"\\WEB-INF\\classes\\static\\html\\result.html");
            System.out.println(file.toString());
            if(!file.exists()) {
                file.createNewFile();
            }
            //设置输出流
            out = new FileWriter(file);
            //模板输出静态文件
            template.process(data, out);
            //输出到项目工程，防止tomcat重启丢失
            template.process(data,new FileWriter(new File("D:\\guanwang\\guanwang\\src\\main\\resources\\static\\html\\result.html")));
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            if(null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
