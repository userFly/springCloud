package com.fuy.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by userFly on 2018/5/17.
 */
@RestController
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping(value = "test")
    public String test(String name) {
        return testService.test(name);
    }
}
