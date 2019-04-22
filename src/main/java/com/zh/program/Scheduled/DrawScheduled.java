package com.zh.program.Scheduled;

import com.zh.program.Common.Constants;
import com.zh.program.Common.enums.SysparamKeys;
import com.zh.program.Common.utils.DateUtils;
import com.zh.program.Common.utils.DrawUtils;
import com.zh.program.Entrty.Invoice;
import com.zh.program.Entrty.Prize;
import com.zh.program.Entrty.Selection;
import com.zh.program.Service.InvoiceService;
import com.zh.program.Service.SelectionService;
import com.zh.program.Service.SysparamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 定时抽奖
 */
@Slf4j
@Component
public class DrawScheduled {
    @Autowired
    private SysparamService sysparamService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private SelectionService selectionService;

    @Scheduled(cron = "0 0 10 * * ?")
    public void scheduled(){
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
        List<Integer> selectList = new LinkedList<>();
        for(Invoice invoice : list){
            selectList.add(invoice.getId());
        }
        Integer start = list.get(list.size() - 1).getId();
        //打乱list中元素顺序
        Collections.shuffle(list);
        //中奖名单id
        Set<Integer> set = DrawUtils.draw(Constants.DRAW_PERSON_NUMBER, selectList);
        map = new HashMap<>();
        Integer selectCount = selectionService.selectCount(map);
        Selection selection = selectionService.selectByPrimaryKey(selectCount);
        int number;
        if(selection == null){
            number = 1;
        }else{
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
        }
        for(int i = start; i < list.size() + start; i++){
            //更改发票状态
            Invoice invoice = invoiceService.selectByPrimaryKey(i);
            invoice.setState(Constants.STATE_OFF);
            invoiceService.updateByPrimaryKeySelective(invoice);
        }

    }
}
