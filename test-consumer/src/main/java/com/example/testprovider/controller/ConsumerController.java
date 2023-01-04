package com.example.testprovider.controller;

import com.example.testprovider.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author wenkr
 * @version V1.0
 * @Package com.example.testprovider.controller
 * @date 2022/12/27 14:18
 * @Copyright ©
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private static final String UPLOAD_PATH = "C:/Temp/";

    @Autowired
    ConsumerService consumerService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getRequest")
    public String getRequest() {
        return "ConsumerController : " + restTemplate.getForObject("http://localhost:8081/provider/getRequest", String.class);
    }

    @PostMapping("/postRequest")
    public String postRequest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", "2");
        map.put("age", 2);
        return "ConsumerController : " + restTemplate.postForObject("http://localhost:8081/provider/postRequest", map, String.class);
    }

    @PutMapping("/putRequest")
    public String putRequest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", "2");
        map.put("age", 3);
        restTemplate.put("http://localhost:8081/provider/putRequest", map, String.class);
        return "putRequest";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        //不可以上传空文件
        if (file.isEmpty()) {
            return "文件为空，请选择文件后再上传";
        }

        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        if (!".jpg".equals(suffix)) {
            return "上传失败，文件类型非jpg";
        }

        filename = UPLOAD_PATH + filename;
        File dest = new File(filename);

        //若文件已存在则不执行保存操作
        try {
            if (!dest.exists()) {
                file.transferTo(dest);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }

        return "上传成功";

    }


}
