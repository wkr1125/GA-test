package com.example.testprovider.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wenkr
 * @version V1.0
 * @Package com.example.testprovider.task
 * @date 2023/1/12 11:28
 * @Copyright ©
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    @Async("threadPoolTaskExecutor")
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "*/5 * * * * ?")
    @Async("threadPoolTaskExecutor")
    public void reportCurrentTime2() {
        log.info("The time is reportCurrentTime2 {}", dateFormat.format(new Date()));
    }

//    @Scheduled(cron = "15,30,45 * * * * ?")
//    public void reportSpecificTime() {
//        log.info("The reportSpecificTime is now {}", dateFormat.format(new Date()));
//    }
}