package com.yy.user.service.impl;

import com.yy.user.dto.UserInfoDTO;
import com.yy.user.entity.TestUser;
import com.yy.user.service.TestUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TestUserServiceImplTest {
    @Resource
    private TestUserService testUserService;
    @Test
    void testSave(){
        TestUser testUser = new TestUser();
        testUser.setUserId(2);
        testUser.setUserInfo(null);
        testUserService.save(testUser);
    }

    @Test
    void testGetById(){
        TestUser testUser = testUserService.getById("28d2b70f2a0c0a2c0d5ac0c1e4382cb2");
        System.out.println(testUser);
    }

}