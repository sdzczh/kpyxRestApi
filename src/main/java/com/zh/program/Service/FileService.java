package com.zh.program.Service;

import com.zh.program.Entrty.Banner;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:37:14
 **/ 
public interface FileService {

    void IoReadImage(String imgUrl, HttpServletResponse response) throws IOException;
}