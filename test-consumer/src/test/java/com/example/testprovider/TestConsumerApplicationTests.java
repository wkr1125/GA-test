package com.example.testprovider;

import com.example.testprovider.controller.ConsumerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestConsumerApplicationTests {
    @Autowired
    ConsumerController consumerController;

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

}
