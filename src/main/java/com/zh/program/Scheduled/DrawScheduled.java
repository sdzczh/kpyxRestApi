package com.zh.program.Scheduled;

import com.zh.program.Common.Constants;
import com.zh.program.Common.enums.SysparamKeys;
import com.zh.program.Common.utils.DrawUtils;
import com.zh.program.Entrty.Invoice;
import com.zh.program.Entrty.Prize;
import com.zh.program.Service.InvoiceService;
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
    @Scheduled(cron = "0/5 * * * * *")
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
        List<Invoice> list = invoiceService.selectAll(map);
        //打乱list中元素顺序
        Collections.shuffle(list);
        //中奖名单id
        Set<Integer> set = DrawUtils.draw(Constants.DRAW_PERSON_NUMBER, list.size());
        for(Integer index : set){
            Invoice invoice = new Invoice();
            invoice = list.get(index);
            Prize prize = new Prize();
            prize.setInvoiceId(index);
        }

    }
}
