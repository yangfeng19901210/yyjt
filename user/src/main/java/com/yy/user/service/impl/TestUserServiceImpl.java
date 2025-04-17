package com.yy.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.user.entity.TestUser;
import com.yy.user.service.TestUserService;
import com.yy.user.mapper.TestUserMapper;
import org.springframework.stereotype.Service;

/**
* @author yangfeng
* @description 针对表【test_user】的数据库操作Service实现
* @createDate 2025-04-16 16:28:04
*/
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser>
    implements TestUserService{

}




