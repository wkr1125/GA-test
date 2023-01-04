package com.example.testprovider;

import com.example.testprovider.controller.ProviderController;
import com.example.testprovider.service.ProviderService;
import com.example.testprovider.service.impl.ProviderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashMap;

@SpringBootTest
class TestProviderApplicationTests {

//    @MockBean
    @Autowired
    ProviderController providerController;

//    @MockBean
//    ProviderServiceImpl providerService;

    @Test
    void getRequest() {
        System.out.println(providerController.getRequest());
    }

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void postRequest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", "2");
        map.put("age", 2);
        try {
//            Mockito.when(providerController.postRequest(map)).thenCallRealMethod();
            System.out.println(providerController.postRequest(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
