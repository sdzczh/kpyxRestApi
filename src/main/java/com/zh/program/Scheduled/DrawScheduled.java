package com.zh.program.Scheduled;

import com.zh.program.Common.Constants;
import com.zh.program.Common.enums.SysparamKeys;
import com.zh.program.Common.utils.DateUtils;
import com.zh.program.Common.utils.DrawUtils;
import com.zh.program.Common.utils.Num2CN;
import com.zh.program.Entrty.Article;
import com.zh.program.Entrty.Invoice;
import com.zh.program.Entrty.Prize;
import com.zh.program.Entrty.Selection;
import com.zh.program.Service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    private DrawService drawService;

    @Scheduled(cron = "0 0 10 * * ?")
    public void scheduled() {
        drawService.job();
    }
}
