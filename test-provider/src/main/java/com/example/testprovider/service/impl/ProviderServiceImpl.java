package com.example.testprovider.service.impl;

import com.example.testprovider.mapper.JpaUserRepository;
import com.example.testprovider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wenkr
 * @version V1.0
 * @Package com.example.testprovider.controller.service
 * @date 2022/12/27 14:22
 * @Copyright ©
 */
@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Override
    public String getRequest() {
        return "ProviderServiceImpl getRequest";
    }

    @Override
    public String postRequest() {
        return "ProviderServiceImpl postRequest";
    }

    @Override
    public String putRequest() {
        return "ProviderServiceImpl putRequest";
    }
}
