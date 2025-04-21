package com.yy.user.service.impl;

import com.yy.user.dto.UserInfoDTO;
import com.yy.user.entity.TestJsonb;
import com.yy.user.service.TestJsonbService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TestJsonbServiceImplTest {
    @Resource
    private TestJsonbService testJsonbService;
    @Test
    void testSave(){
        TestJsonb testJsonb = new TestJsonb();
        testJsonb.setUserId(9);
        testJsonb.setUserInfo(new UserInfoDTO("张花草", "13353426687", "12345678901"));
        testJsonb.setCrtTime(LocalDateTime.now());
        testJsonb.setUptTime(LocalDateTime.now());
        testJsonbService.save(testJsonb);
    }

    @Test
    void testGetById(){
        TestJsonb testJsonb = testJsonbService.getById("e81fae22dd4a39738e73092907539408");
        System.out.println(testJsonb);
    }

}