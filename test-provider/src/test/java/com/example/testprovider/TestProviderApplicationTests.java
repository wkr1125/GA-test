package com.example.testprovider;

import com.example.testprovider.controller.ProviderController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestProviderApplicationTests {
    @Autowired
    ProviderController providerController;

    @Test
    void getRequest() {
        System.out.println(providerController.getRequest());
    }
}
