package com.example.testprovider.service.impl;

import com.example.testprovider.service.ConsumerService;
import org.springframework.stereotype.Service;

/**
 * @author wenkr
 * @version V1.0
 * @Package com.example.testprovider.controller.service
 * @date 2022/12/27 14:22
 * @Copyright ©
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    public String getRequest() {
        return "getRequest";
    }

    @Override
    public String postRequest() {
        return "postRequest";
    }

    @Override
    public String putRequest() {
        return "putRequest";
    }
}
