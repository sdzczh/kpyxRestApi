package com.zh.program.Service.impl;

import com.zh.program.Common.Constants;
import com.zh.program.Common.enums.SysparamKeys;
import com.zh.program.Common.utils.DateUtils;
import com.zh.program.Common.utils.DrawUtils;
import com.zh.program.Common.utils.Num2CN;
import com.zh.program.Dao.BannerMapper;
import com.zh.program.Entrty.*;
import com.zh.program.Service.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * 
 * @author: autogeneration
 * @date: 2019-04-11 15:37:14
 **/
@Slf4j
@Transactional
@Service("drawService")
public class DrawServiceImpl implements DrawService {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private SysparamService sysparamService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private SelectionService selectionService;

    @Override
    public void job(){
        String key = SysparamKeys.DRAW_ON_OFF;
        String state = sysparamService.queryByKey(key);
        if(state == null){
            log.info("<<<<<<<<<<<<<<<<<<定时抽奖开关状态获取失败>>>>>>>>>>>>>>>>>");
            return;
        }
        if("0".equals(state)){
            log.info("<<<<<<<<<<<<<<<<<<定时抽奖开关状态已关闭>>>>>>>>>>>>>>>>>");
            return;
        }
        Map<Object, Object> map = new HashMap<>();
        map.put("state", Constants.STATE_ON);
        map.put("createTime", DateUtils.getSomeDay(-30));
        List<Invoice> list = invoiceService.selectAll(map);
        if(list.size() == 0){
            return;
        }

        //获取抽奖列表
        List<Integer> selectList = new LinkedList<>();
        for(Invoice invoice : list){
            selectList.add(invoice.getId());
        }
        //打乱list中元素顺序
        Collections.shuffle(list);
        key = SysparamKeys.DRAW_AMOUNT;
        String drawAmount = sysparamService.queryByKey(key);
        //中奖名单id
        Set<Integer> set = DrawUtils.draw(Integer.valueOf(drawAmount), selectList);
        map = new HashMap<>();
        List<Selection> selectionList = selectionService.selectAll(map);
        Selection selection;
        int number;
        if(selectionList.size() == 0){
            number = 1;
        }else{
            selection = selectionList.get(0);
            number = selection.getNumber() + 1;
        }
        for(Integer index : set){
            //插入选中表
            selection = new Selection();
            selection.setInvoiceId(index);
            selection.setNumber(number);
            selection.setState(Constants.STATE_ON);
            selectionService.insertSelective(selection);
            log.info("插入选中发票信息 ID:" + index);

            //修改状态
            Invoice invoice = invoiceService.selectByPrimaryKey(index);
            invoice.setState(Constants.STATE_OFF);
            invoiceService.updateByPrimaryKeySelective(invoice);
        }
        //修改本期状态
        /*for(int i = start; i < list.size() + start; i++){
            //更改发票状态
            Invoice invoice = invoiceService.selectByPrimaryKey(i);
            invoice.setState(Constants.STATE_OFF);
            invoiceService.updateByPrimaryKeySelective(invoice);
        }*/
        //修改上一期状态 根据起始id
/*        Invoice invoiceStart = list.get(list.size() - 1);
        if(number != 1) {
            invoiceService.updateByNumber(invoiceStart.getId());
        }*/
        //新建公告
        String title = sysparamService.queryByKey(SysparamKeys.ARTICLE_TITLE);
        title = String.format(title, Num2CN.cvt(number, true), set.size());
        Article article = new Article();
        article.setClinkNum(0);
        article.setNumber(number);
        article.setTitle(title);
        article.setAuthor("admin");
        article.setContent(" ");
        article.setType(Constants.ARTICLE_RWMD);
        articleService.insertSelective(article);

        //修改期数
        String drawNumber = sysparamService.queryByKey(SysparamKeys.DRAW_NUMBER);
        int num = Integer.valueOf(drawNumber) + 1;
        sysparamService.updateByKey(SysparamKeys.DRAW_NUMBER, Integer.toString(num));
    }
}