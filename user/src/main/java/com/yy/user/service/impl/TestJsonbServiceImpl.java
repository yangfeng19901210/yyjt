package com.yy.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.user.entity.TestJsonb;
import com.yy.user.service.TestJsonbService;
import com.yy.user.mapper.TestJsonbMapper;
import org.springframework.stereotype.Service;

/**
* @author yangfeng
* @description 针对表【test_jsonb】的数据库操作Service实现
* @createDate 2025-04-16 17:47:45
*/
@Service
public class TestJsonbServiceImpl extends ServiceImpl<TestJsonbMapper, TestJsonb>
    implements TestJsonbService{
}




