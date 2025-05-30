package com.yy.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {
    @GetMapping("/api/data")
    public String getData() {
        return "Response from Service-B";
    }
}