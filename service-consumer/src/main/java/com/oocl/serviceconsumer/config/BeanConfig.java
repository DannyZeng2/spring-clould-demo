package com.oocl.serviceconsumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @version: 1.0.0
 * @Author: Danny Zeng
 * @Date: 2021/5/1 20:36
 * @LastEditors: Danny Zeng
 * @LastEditTime: 2021/5/1 20:36
 */

@Configuration
public class BeanConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
