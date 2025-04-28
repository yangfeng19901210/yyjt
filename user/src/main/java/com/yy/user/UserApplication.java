package com.yy.user;

import com.yy.user.config.ThirdPartyClassSelector;
import me.chanjar.weixin.mp.bean.card.UserCard;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

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
@Import(ThirdPartyClassSelector.class)
public class UserApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserApplication.class, args);
        UserCard userCard = context.getBean(UserCard.class);
        System.out.println(userCard);
    }
}
