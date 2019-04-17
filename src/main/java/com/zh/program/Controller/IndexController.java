package com.zh.program.Controller;

import com.zh.program.Common.Constants;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Article;
import com.zh.program.Entrty.Banner;
import com.zh.program.Entrty.FriendshipLink;
import com.zh.program.Entrty.Videos;
import com.zh.program.Service.ArticleService;
import com.zh.program.Service.BannerService;
import com.zh.program.Service.FriendshipLinkService;
import com.zh.program.Service.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 首页
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private BannerService bannerService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private VideosService videosService;
    @Autowired
    private FriendshipLinkService friendshipLinkService;

    /**
     * 获取banner列表
     * type Banner类型 0顶部 1中部
     * @return
     */
    @ResponseBody
    @RequestMapping("")
    public String getIndex(){
        Map<Object, Object> map = new HashMap<>();
        List<Banner> bannerList = bannerService.selectAll(map);
        /**
         *  Banner数据
         */
        List<Banner> bannerTopList = new ArrayList<>();
        List<Banner> bannerMidList = new ArrayList<>();
        for(Banner banner : bannerList){
            Banner banner1 = new Banner();
            if(banner.getType() == Constants.BANNER_TYPE_TOP) {
                banner1.setImgUrl(banner.getImgUrl());
                banner1.setHref(banner.getHref());
                banner1.setTitle(banner.getTitle());
                bannerTopList.add(banner1);
            }else{
                banner1.setImgUrl(banner.getImgUrl());
                banner1.setHref(banner.getHref());
                banner1.setTitle(banner.getTitle());
                bannerMidList.add(banner1);
            }
        }
        Map<Object, Object> data = new HashMap<>();
        data.put("topBanner", bannerTopList);
        data.put("midBanner", bannerMidList);
        /**
         * 文章数据
         */
        List<Article> list = articleService.selectByIndex(map);
        List<Article> kjggList = new ArrayList<>();
        List<Article> zcfgList = new ArrayList<>();
        List<Article> xwzxList = new ArrayList<>();
        List<Article> cjwtList = new ArrayList<>();
        List<Article> tzggList = new ArrayList<>();
        for(Article article : list){
            Integer type = article.getType();
            switch (type){
                case Constants.ARTICLE_KJGG : if(kjggList.size() >= 6) break; kjggList.add(article);
                case Constants.ARTICLE_ZCFG : if(zcfgList.size() >= 6) break; zcfgList.add(article);
                case Constants.ARTICLE_XWZX : if(xwzxList.size() >= 6) break; xwzxList.add(article);
                case Constants.ARTICLE_CJWT : if(cjwtList.size() >= 6) break; cjwtList.add(article);
                case Constants.ARTICLE_TZGG : if(tzggList.size() >= 6) break; tzggList.add(article);
            }
        }
        data.put("kjggList", kjggList);
        data.put("zcfgList", zcfgList);
        data.put("xwzxList", xwzxList);
        data.put("cjwtList", cjwtList);
        data.put("tzggList", tzggList);

        List<Videos> videosList = videosService.selectAll(map);
        for(Videos videos : videosList){
            data.put("videos", videos);
            break;
        }
        return Result.toResult(ResultCode.SUCCESS, data);
    }

    /**
     * 获取友情链接
     * @return
     */
    @ResponseBody
    @RequestMapping("/friendshipLink")
    public String getAll(){
        Map<Object, Object> map = new HashMap<>();
        List<FriendshipLink> list = friendshipLinkService.selectAll(map);
        FriendshipLink friendshipLink = new FriendshipLink();
        List<FriendshipLink> links = new LinkedList<>();
        for(FriendshipLink friendshipLink1 : list){
            friendshipLink.setHref(friendshipLink1.getHref());
            friendshipLink.setTitle(friendshipLink1.getTitle());
            links.add(friendshipLink);
        }
        return Result.toResult(ResultCode.SUCCESS, links);
    }
}
