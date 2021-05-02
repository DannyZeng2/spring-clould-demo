package com.ppcl.serviceprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @RequestMapping("/service/hello")
     public String sayHello() {
         return "hello service provider 03...";
     }

}