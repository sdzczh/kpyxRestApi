package com.zh.program.Scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DrawScheduled {
    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled(){
        log.info("===========>>>定时任务<<<===========" + System.currentTimeMillis());
    }
}
