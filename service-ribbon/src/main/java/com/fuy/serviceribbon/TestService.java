package com.fuy.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by userFly on 2018/5/17.
 */
@Service
public class TestService {
    @Autowired
    RestTemplate restTemplate;


    // 服务停止之后，使用 @HystrixCommand 注释，使用其他的服务，或则直接给停止掉
    @HystrixCommand(fallbackMethod = "testError")
    public String test(String name) {
        return restTemplate.getForObject("http://service1/hi?name=" + name, String.class);
    }

    public String testError(String name) {
        return "ERROR";
    }

}
