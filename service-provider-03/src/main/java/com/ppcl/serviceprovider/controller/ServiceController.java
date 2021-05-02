package com.ppcl.serviceprovider.controller;

import com.ppcl.serviceprovider.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @GetMapping("/service/hello")
     public String sayHello() {
         return "hello service provider 03...";
     }

    @GetMapping("/service/user")
    public User getUser() {
        return new User("matthew",25);
    }

}