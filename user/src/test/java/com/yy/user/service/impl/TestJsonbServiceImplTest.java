package com.yy.user.service.impl;

import com.yy.user.dto.UserInfoDTO;
import com.yy.user.entity.TestJsonb;
import com.yy.user.service.TestJsonbService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TestJsonbServiceImplTest {
    @Resource
    private TestJsonbService testJsonbService;
    @Test
    void testSave(){
        TestJsonb testJsonb = new TestJsonb();
        testJsonb.setUserId(5);
        testJsonb.setUserInfo(null);
        testJsonbService.save(testJsonb);
    }

}