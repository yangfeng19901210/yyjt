package com.yy.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: UserApplication
 ** @author: yangfeng
 ** @date: 2025/4/14 15:13
 ** @version: 1.0.0
 *********************************************************/
@SpringBootApplication
@MapperScan("com.yy.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
