package com.example.testprovider.controller;

import com.example.testprovider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author wenkr
 * @version V1.0
 * @Package com.example.testprovider.controller
 * @date 2022/12/27 14:18
 * @Copyright ©
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/getRequest")
    public String getRequest(){
        return providerService.getRequest();
    }

    @PostMapping("/postRequest")
    public String postRequest(@RequestBody Map<String,Object> map) throws TimeoutException {
        String a = (String) map.get("id");
        if ("1".equals(a)){
            throw new TimeoutException();
        }
        return providerService.postRequest();
    }

    @PutMapping("/putRequest")
    public void putRequest(@RequestBody Map<String,Object> map){
        System.out.println(map);
        System.out.println(providerService.putRequest());
    }
}
