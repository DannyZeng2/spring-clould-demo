package com.oocl.zuulapigateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GateWayController {

    @RequestMapping("/api/local")
    public String hello() {
        System.out.println("在此处执行业务逻辑...");
        return "exec the api gateway.";
    }

}