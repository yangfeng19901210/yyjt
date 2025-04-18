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
        testUser.setUserInfo(new UserInfoDTO("11","11","rrrr"));
        testUser.setPhones(new String[]{"11","11","rrrr"});
        testUser.setFriendIds(new Integer[]{1,2,3});
        testUserService.save(testUser);
    }

    @Test
    void testGetById(){
        TestUser testUser = testUserService.getById("c629df20c67048b5b0f063b18cec7b7c");
        System.out.println(testUser);
    }

}