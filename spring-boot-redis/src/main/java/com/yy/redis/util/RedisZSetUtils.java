package com.yy.redis.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: RedisZSetUtils
 ** @author: yangfeng
 ** @date: 2025/5/7 14:05
 ** @version: 1.0.0
 *********************************************************/
@Component
public class RedisZSetUtils {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    public Boolean add(String key, Object value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    public Set<Object> rangeByScore(String key, double minScore, double maxScore) {
        return redisTemplate.opsForZSet().rangeByScore(key, minScore, maxScore);
    }


    public Long remove(String key, Object... values) {
        return redisTemplate.opsForZSet().remove(key, values);
    }


    public Long reverseRank(String key, Object value) {
        return redisTemplate.opsForZSet().reverseRank(key, value);
    }

    public Long removeRangeByRank(String key, long start, long end) {
        return redisTemplate.opsForZSet().removeRange(key, start, end);
    }
}
