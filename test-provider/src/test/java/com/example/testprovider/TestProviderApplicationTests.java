package com.example.testprovider;

import com.example.testprovider.bean.User;
import com.example.testprovider.controller.ProviderController;
import com.example.testprovider.mapper.JpaUserRepository;
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
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class TestProviderApplicationTests {

    //    @MockBean
    @Autowired
    ProviderController providerController;

    @Autowired
    JpaUserRepository jpaUserRepository;
//    @MockBean
//    ProviderServiceImpl providerService;

    @Test
    void getRequest() {
        System.out.println(providerController.getRequest());
    }

    @BeforeEach
    void setUp() {
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

    @Test
    void userSave() {
//        jpaUserRepository.save(new User(0,"3","2"));
        List<User> users = new ArrayList<>();
        users.add(new User(5,"5","5"));
        users.add(new User(6,"6","6"));
        users.add(new User(7,"7","7"));
        users.add(new User(8,"8","8"));
        jpaUserRepository.saveAll(users);
    }

    @Test
    void userUpdate() {
        jpaUserRepository.save(new User(4, "3", "update"));
//        jpaUserRepository.save(new User(0,"3","2"));
    }

    @Test
    void userDelete() {
        jpaUserRepository.deleteAll();
//        jpaUserRepository.save(new User(0,"3","2"));
    }

    @Test
    void userOrder() {
        List<User> users = jpaUserRepository.findAll(Sort.by("name"));
//        for (User user : users) {
//            System.out.println(user);
//        }
        users.stream().forEach(x -> System.out.println(x));
//        System.out.println(users.stream().iterator().toString());
//        jpaUserRepository.save(new User(1,"1","1"));

//        List<User> users = jpaUserRepository.findByName("3");
//        users.stream().forEach(x -> System.out.println(x));
    }

    @Test
    void userQuery() {
        System.out.println(jpaUserRepository.findByName("5"));
//        jpaUserRepository.save(new User(0,"3","2"));
    }
    @Test
    void userQueryUserName() {
        System.out.println(jpaUserRepository.findByUserName("5"));
//        jpaUserRepository.save(new User(0,"3","2"));
    }
}
