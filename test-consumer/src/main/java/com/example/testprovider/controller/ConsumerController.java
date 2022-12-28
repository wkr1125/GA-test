package com.example.testprovider.controller;

import com.example.testprovider.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenkr
 * @version V1.0
 * @Package com.example.testprovider.controller
 * @date 2022/12/27 14:18
 * @Copyright ©
 */
@RestController
@RequestMapping("/provider")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getRequest")
    public String getRequest(){
        return "ConsumerController : " + restTemplate.getForObject("http://localhost:8081/provider/getRequest", String.class);
    }

    @PostMapping("/postRequest")
    public String postRequest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("age", 2);
        return "ConsumerController : " + restTemplate.postForObject("http://localhost:8081/provider/postRequest", map, String.class);
    }

    @PutMapping("/putRequest")
    public String putRequest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("age", 3);
        restTemplate.put("http://localhost:8081/provider/putRequest", map, String.class);
        return "putRequest";
    }


}
