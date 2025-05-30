package com.yy.redis;

import com.yy.redis.util.RedisZSetUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: RedisTest
 ** @author: yangfeng
 ** @date: 2025/5/7 14:12
 ** @version: 1.0.0
 *********************************************************/
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisZSetUtils redisZSetUtils;
    @Test
    void addTest(){
        redisZSetUtils.add("111", 1169, 2);
    }
    @Test
    void deleteTest(){
        redisZSetUtils.remove("111", 1169);
    }
}
