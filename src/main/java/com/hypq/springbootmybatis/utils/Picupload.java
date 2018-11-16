package com.hypq.springbootmybatis.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class Picupload {
    public static void  upload(MultipartFile file, HttpServletRequest request ,String path2) throws IOException {
        System.out.println("fileName:" + file.getOriginalFilename());
        String realPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println(realPath);
        String path = path2 + file.getOriginalFilename();

        File newFile = new File(path);
        //通过CommonsMultipartFile 的方法直接写文件
        file.transferTo(newFile);
    }
}
