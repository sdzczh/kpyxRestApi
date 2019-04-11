package com.zh.program.Controller;

import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Article;
import com.zh.program.Entrty.Banner;
import com.zh.program.Service.ArticleService;
import com.zh.program.Service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    /**
     * 获取banner列表
     * type Banner类型 0顶部 1中部
     * @return
     */
    @ResponseBody
    @RequestMapping("/{type}")
    public String getAll(@PathVariable Integer type){

        Map<Object, Object> map = new HashMap<>();
        map.put("type", type);
        List<Banner> list = bannerService.selectAll(map);
        List<Banner> resultList = new LinkedList<>();
        for(Banner banner : list){
            Banner ban = new Banner();
            ban.setId(banner.getId());
            ban.setHref(banner.getHref());
            ban.setImgUrl(banner.getImgUrl());
            resultList.add(ban);
        }
        return Result.toResult(ResultCode.SUCCESS, resultList);
    }
}
