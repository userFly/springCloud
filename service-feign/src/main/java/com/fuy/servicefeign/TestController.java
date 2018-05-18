package com.fuy.servicefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by userFly on 2018/5/18.
 */
@RestController
public class TestController {
    @Autowired
    FeignInterface feignInterface;
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(String name) {
        return feignInterface.test(name);
    }
}
