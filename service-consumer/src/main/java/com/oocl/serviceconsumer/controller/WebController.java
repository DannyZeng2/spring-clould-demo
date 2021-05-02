package com.oocl.serviceconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
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
public class WebController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/web/hello")
    public String sayHello() {
        return "consumer:" + restTemplate.getForEntity("http://SERVICE-PROVIDER/service/hello",String.class).getBody();
    }

    @RequestMapping("/web/user")
    public String getUser() {
        return "consumer:" + restTemplate.getForEntity("http://SERVICE-PROVIDER/service/user",String.class).getBody();
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance instance = this.loadBalancerClient.choose("SERVICE-PROVIDER");
        System.out.println("111: " + instance.getServiceId() + ": " + instance.getHost() + ": " + instance.getPort());
        return instance.toString();

    }
}
