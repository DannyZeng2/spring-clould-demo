package com.oocl.serviceconsumerfeign.service;

import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import com.oocl.serviceconsumerfeign.fallback.MyFallback;
import com.oocl.serviceconsumerfeign.fallback.MyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @version: 1.0.0
 * @Author: Danny Zeng
 * @Date: 2021/5/3 17:05
 * @LastEditors: Danny Zeng
 * @LastEditTime: 2021/5/3 17:05
 */
@FeignClient(name = "SERVICE-PROVIDER",fallback = MyFallback.class, fallbackFactory = MyFallbackFactory.class)
public interface HelloService {

    @GetMapping("/service/hello")
    String sayHello();
}
