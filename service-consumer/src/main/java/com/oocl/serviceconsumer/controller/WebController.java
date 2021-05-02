package com.oocl.serviceconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/web/hello")
    public String sayHello() {
        return "consumer:" + restTemplate.getForEntity("http://SERVICE-PROVIDER-01/service/hello",String.class).getBody();
    }
}
