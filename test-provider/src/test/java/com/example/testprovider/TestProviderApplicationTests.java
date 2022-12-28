package com.example.testprovider;

import com.example.testprovider.controller.ProviderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class TestProviderApplicationTests {
    @Autowired
    ProviderController providerController;

    @Test
    void getRequest() {
        System.out.println(providerController.getRequest());
    }

    @Test
    void postRequest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", "2");
        map.put("age", 2);
        try {
            System.out.println(providerController.postRequest(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
