package com.example.testprovider;

import com.example.testprovider.exception.CustomErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;


@SpringBootApplication
@EnableScheduling
public class TestConsumerApplication {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        //设置restTemplate的默认异常处理器为自定义的处理器
        restTemplate.setErrorHandler(new CustomErrorHandler());
        //修改restTemplate默认编码格式为UTF-8
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        for (int i = 0; i < messageConverters.size(); i++) {
            HttpMessageConverter<?> messageConverter = messageConverters.get(i);
            if (messageConverter.getClass().equals(StringHttpMessageConverter.class)) {
                messageConverters.set(i, new StringHttpMessageConverter(StandardCharsets.UTF_8));
            }
        }
        return restTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestConsumerApplication.class, args);
    }

}
