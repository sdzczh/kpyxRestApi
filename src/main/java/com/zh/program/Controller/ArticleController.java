package com.zh.program.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zh.program.Common.authorization.annotation.Decrypt;
import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Article;
import com.zh.program.Entrty.User;
import com.zh.program.Service.ArticleService;
import com.zh.program.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 根据ID查找
     * @param articleId
     * @param model
     * @return
     */
    @RequestMapping("/{articleId}")
    public String get(@PathVariable Integer articleId, Model model){
        Map<Object, Object> map = new HashMap();
        map.put("id", articleId);
        List<Article> list = articleService.selectAll(map);
        Article article = list.get(0);
        model.addAttribute("item",article);
        return "index.jsp";
    }

    /**
     * 获取文章列表
     * type 文章类型 0:开奖公告,1:政策法规,2:新闻资讯,3:常见问题,4:通知公告
     * @return
     */
    @ResponseBody
    @RequestMapping("/type/{type}")
    public String getAll(@PathVariable Integer type){
        Map<Object, Object> map = new HashMap<>();
        map.put("type", type);
        List<Article> list = articleService.selectAll(map);
        List<Article> resultList = new LinkedList<>();
        for(Article article : list){
            Article art = new Article();
            art.setId(article.getId());
            art.setAuthor(article.getAuthor());
            art.setTitle(article.getTitle());
            art.setClinkNum(article.getClinkNum());
            art.setUpdateTime(article.getUpdateTime());
            resultList.add(art);
        }
        return Result.toResult(ResultCode.SUCCESS, resultList);
    }
}
