package com.example.testprovider.task;

import com.example.testprovider.redislock.RedisLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

    @Resource
    RedisLock redisLock;
    public static final String LOCK_NAME = "name";
    public static final String CLIENT_A = "a";
    public static final String CLIENT_B = "b";
    public static final int EXPIRE_TIME = 30;

//    private static final Lock lock=new ReentrantLock();

    @Scheduled(fixedRate = 5000)
    @Async("threadPoolTaskExecutor")
    public void reportCurrentTime() {
//        this.lock.lock();
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("The time is now {}", dateFormat.format(new Date()));
//        this.lock.unlock();
    }

    @Scheduled(cron = "*/5 * * * * ?")
    @Async("threadPoolTaskExecutor")
    public void reportCurrentTime2() {

        //客户端a
        boolean lockResultA = redisLock.tryLock(LOCK_NAME, CLIENT_A, EXPIRE_TIME, TimeUnit.SECONDS);

        if (lockResultA) {
            try {
                //模拟客户端a的操作耗时
                Thread.sleep(5 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                redisLock.unLock(LOCK_NAME, CLIENT_A);
            }
//        this.lock.lock();
            log.info("The time is reportCurrentTime2 {}", dateFormat.format(new Date()));
//        this.lock.unlock();
        }
    }

    @Scheduled(cron = "*/5 * * * * ?")
    @Async("threadPoolTaskExecutor")
    public void reportCurrentTimeLock() {
//        this.lock.lock();
        //客户端b
        boolean lockResultB = redisLock.tryLock(LOCK_NAME, CLIENT_B, EXPIRE_TIME, TimeUnit.SECONDS);
        if (lockResultB) {
            try {
                //模拟客户端b的操作耗时
                Thread.sleep(5 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                redisLock.unLock(LOCK_NAME, CLIENT_B);
            }
            log.info("The time is reportCurrentTimeLock {}", dateFormat.format(new Date()));
//        this.lock.unlock();
        }
    }

//    @Scheduled(cron = "15,30,45 * * * * ?")
//    public void reportSpecificTime() {
//        log.info("The reportSpecificTime is now {}", dateFormat.format(new Date()));
//    }
}