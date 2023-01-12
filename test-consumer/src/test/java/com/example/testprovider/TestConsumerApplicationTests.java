package com.example.testprovider;

import com.example.testprovider.controller.ConsumerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
class TestConsumerApplicationTests {
    @Autowired
    ConsumerController consumerController;


    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    void getRequest() {
        System.out.println(consumerController.getRequest());
    }

    @Test
    void postRequest() {
        System.out.println(consumerController.postRequest());
    }

    @Test
    void putRequest() {
        System.out.println(consumerController.putRequest());
    }

    @Test
    void completableFuture() {

//        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程" + Thread.currentThread().getName());
            return "123";
        }, threadPoolTaskExecutor).thenApplyAsync(value -> {
            System.out.println("thenApply子线程" + Thread.currentThread().getName());
            threadPoolTaskExecutor.shutdown();
            return value + "thenApply";
        }, threadPoolTaskExecutor);
        String s = null;
        try {
            s = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(s + "主线程结束" + Thread.currentThread().getName());
    }


}
