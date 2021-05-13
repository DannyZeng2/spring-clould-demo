package com.ppcl.serviceprovider.controller;

import com.ppcl.serviceprovider.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @GetMapping("/service/hello")
     public String sayHello() {
        // int a = 10/0;
        return "hello service provider 01...";
     }

    @GetMapping("/service/user")
    public User getUser() {
        return new User("danny",23);
    }

}