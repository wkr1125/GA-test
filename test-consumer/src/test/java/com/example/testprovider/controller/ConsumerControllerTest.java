package com.example.testprovider.controller;

import com.example.testprovider.service.ConsumerService;
import com.example.testprovider.service.impl.ConsumerServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wenkr
 * @version V1.0
 * @Package com.example.testprovider.controller
 * @date 2023/1/3 10:45
 * @Copyright ©
 */
class ConsumerControllerTest {

    @Mock
    ConsumerServiceImpl service;

    @BeforeEach
    void setUp(){
        System.out.println("----BeforeEach----");
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void after(){
        System.out.println("----AfterEach----");
    }

    @Test
    void getRequest() {
        //test @Mock
//        MockitoAnnotations.openMocks(this);
        Mockito.when(service.getRequest()).thenReturn("Mockito.getRequest");
//        Mockito.when(service.getRequest()).thenCallRealMethod();
//        Mockito.when(service.getRequest()).thenThrow(new TimeoutException());
//        Assertions.assertEquals("1",service.getRequest());
        Assertions.assertEquals("Mockito.getRequest",service.getRequest());
    }

    @Test
    void postRequest() {
    }

    @Test
    void putRequest() {
    }
}