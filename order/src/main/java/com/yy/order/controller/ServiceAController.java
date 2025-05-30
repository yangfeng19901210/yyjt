package com.yy.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceAController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call-service-b")
    public String callServiceB() {
        // 服务B的URL（需注册到服务发现）
        return restTemplate.getForObject("http://user-service/api/data", String.class);
    }
}