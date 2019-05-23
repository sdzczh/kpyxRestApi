package com.zh.program.Scheduled;


import com.zh.program.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时抽奖
 * @author 赵赫
 */

@Component
public class DrawScheduled {
    @Autowired
    private DrawService drawService;

    /**
    *@Description: 每月第二个星期六凌晨1点触发
    *@Param: []
    *@return: void
    *@Author: zhaohe
    *@date: 2019-05-23
    */
    @Scheduled(cron = "0 0 1 ? * SAT")
    public void scheduled() {
        drawService.job();
    }
}
