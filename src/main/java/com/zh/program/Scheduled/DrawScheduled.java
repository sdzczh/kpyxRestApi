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

    @Scheduled(cron = "0 0 10 * * ?")
    public void scheduled() {
        drawService.job();
    }
}
