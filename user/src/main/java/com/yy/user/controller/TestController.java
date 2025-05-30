package com.yy.user.controller;

import com.yy.user.entity.TestJsonb;
import com.yy.user.service.TestJsonbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: TestController
 ** @author: yangfeng
 ** @date: 2025/4/21 11:01
 ** @version: 1.0.0
 *********************************************************/
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Resource
    private TestJsonbService testJsonbService;
    @GetMapping("/getById/{uuid}")
    public TestJsonb getById(@PathVariable String uuid) {
        return testJsonbService.getById(uuid);
    }
    @PostMapping("/add")
    public Boolean add(@RequestBody TestJsonb testJsonb) {
        log.info("add testJsonb:{}", testJsonb);
        return testJsonbService.save(testJsonb);
    }


}
