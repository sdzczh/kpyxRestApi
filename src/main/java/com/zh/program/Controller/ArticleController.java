package com.zh.program.Controller;

import com.zh.program.Common.enums.ResultCode;
import com.zh.program.Dto.Result;
import com.zh.program.Entrty.Article;
import com.zh.program.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * @return
     */
    @ResponseBody
    @RequestMapping("/{articleId}")
    public String get(@PathVariable Integer articleId){
        if(articleId == null){
            return Result.toResult(ResultCode.PARAM_IS_BLANK);
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("id", articleId);
        List<Article> list = articleService.selectAll(map);
        Article article = list.get(0);
        article.setClinkNum(article.getClinkNum() + 1);
        articleService.updateByPrimaryKeySelective(article);
        return Result.toResult(ResultCode.SUCCESS, article);
    }
    /**
     * 获取文章列表
     * type 文章类型 0:开奖公告,1:政策法规,2:新闻资讯,3:常见问题,4:通知公告
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public String getAll(Integer type, Integer page, Integer rows){
        page = page == null ? 0 : page - 1;
        rows = rows == null ? 10 : rows;
        Map<Object, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("firstResult",page * rows);
        map.put("maxResult",rows);
        List<Article> list = articleService.selectPaging(map);
        Integer count = articleService.selectCount(map);
        List<Article> resultList = new LinkedList<>();
        for(Article article : list){
            Article art = new Article();
            art.setId(article.getId());
            art.setAuthor(article.getAuthor());
            art.setTitle(article.getTitle());
            art.setClinkNum(article.getClinkNum());
            art.setNumber(article.getNumber());
            art.setUpdateTime(article.getUpdateTime());
            resultList.add(art);
        }
        Map<Object, Object> data = new HashMap<>();
        data.put("data", resultList);
        data.put("count", count);
        return Result.toResult(ResultCode.SUCCESS, data);
    }

    @ResponseBody
    @RequestMapping("/recommendList")
    public String recommendList(){
        Map<Object, Object> map = new HashMap<>();
        List<Article> list = articleService.selectGroupByClink(map);
        return Result.toResult(ResultCode.SUCCESS, list);
    }
    @ResponseBody

    @RequestMapping("/drawNotice")
    public String drawNotice(Integer page, Integer rows){
        page = page == null ? 0 : page - 1;
        rows = rows == null ? 10 : rows;
        Map<Object, Object> map = new HashMap<>();
        map.put("firstResult",page * rows);
        map.put("maxResult",rows);
        List<Article> list = articleService.selectDrawNotice(map);
        Integer count = articleService.selectCountDrawNotice(map);
        Map<Object, Object> data = new HashMap<>();
        data.put("data", list);
        data.put("count", count);
        return Result.toResult(ResultCode.SUCCESS, data);
    }
}
