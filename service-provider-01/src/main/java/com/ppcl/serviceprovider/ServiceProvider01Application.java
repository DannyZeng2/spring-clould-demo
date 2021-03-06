package com.ppcl.serviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceProvider01Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider01Application.class, args);
    }

}
