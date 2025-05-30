package com.yy.order;

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
//@EnableDiscoveryClient  // 开启服务注册与发现（不加该注释也能注册到nacos）
//从Spring Cloud Edgware版本开始，即使不加@EnableDiscoveryClient注解，只要配置好注册中心的相关配置，服务也能自动注册到Nacos
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
