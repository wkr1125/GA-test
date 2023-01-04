package com.example.testprovider.controller;

import com.example.testprovider.service.impl.ProviderServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wenkr
 * @version V1.0
 * @Package com.example.testprovider.controller
 * @date 2023/1/4 11:55
 * @Copyright ©
 */
class ProviderControllerTest {

    @Spy
    ProviderController providerController;

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
    void postRequest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", "2");
        map.put("age", 2);
        String postRequestResult = "";
        try {
            postRequestResult = providerController.postRequest(map);
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof TimeoutException);
        }
        Assertions.assertEquals("ok",postRequestResult);
    }

}