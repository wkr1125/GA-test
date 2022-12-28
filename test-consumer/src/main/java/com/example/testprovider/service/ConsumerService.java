package com.example.testprovider.service;

import org.springframework.stereotype.Service;

/**
 * @author wenkr
 * @version V1.0
 * @Package com.example.testprovider.controller.service
 * @date 2022/12/27 14:22
 * @Copyright ©
 */
public interface ConsumerService {

    String getRequest();

    String postRequest();

    String putRequest();

}
