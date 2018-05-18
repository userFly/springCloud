package com.fuy.servicefeign;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by userFly on 2018/5/18.
 */
@FeignClient(value = "service1")
public interface FeignInterface {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String test(@RequestParam(value = "name") String name);
}
