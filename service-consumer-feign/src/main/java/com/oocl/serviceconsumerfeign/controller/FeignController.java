package com.oocl.serviceconsumerfeign.controller;

import com.oocl.serviceconsumerfeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @version: 1.0.0
 * @Author: Danny Zeng
 * @Date: 2021/5/1 20:35
 * @LastEditors: Danny Zeng
 * @LastEditTime: 2021/5/1 20:35
 */
@RestController
public class FeignController {

    @Qualifier("com.oocl.serviceconsumerfeign.service.HelloService")
    @Autowired
    private HelloService helloService;


    @RequestMapping("web/hello")
    public String sayHello() {
        return "consumer:" + helloService.sayHello();
    }

    @RequestMapping("web/user")
    public String getUser() {
        return "consumer:" + helloService.getUser();
    }

}
