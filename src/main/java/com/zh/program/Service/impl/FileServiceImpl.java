package com.zh.program.Service.impl;

import com.zh.program.Common.utils.GetServerRealPathUnit;
import com.zh.program.Dao.BannerMapper;
import com.zh.program.Entrty.Banner;
import com.zh.program.Service.BannerService;
import com.zh.program.Service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:37:14
 **/ 
@Service("fileService")
public class FileServiceImpl implements FileService {
    //注入配置文件application.yml中设置的图片存放子目录名
    private String GOODS_IMG_PATH = "/home/installPackage/imgs/";

    @Override
    public void IoReadImage(String imgUrl, HttpServletResponse response) throws IOException {
        ServletOutputStream out = null;
        FileInputStream ips = null;
        String upload = null;

        try {
            //获取图片存放路径
            String imgPath = GOODS_IMG_PATH + "/" + imgUrl;
            ips = new FileInputStream(new File(imgPath));
            String type = imgUrl.substring(imgUrl.indexOf(".")+1);
            if (type.equals("png")){
                response.setContentType("image/png");
            }
            if (type.equals("jpeg")){
                response.setContentType("image/jpeg");
            }
            out = response.getOutputStream();
            //读取文件流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = ips.read(buffer)) != -1){
                out.write(buffer,0,len);
            }
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
            ips.close();
        }
    }
}