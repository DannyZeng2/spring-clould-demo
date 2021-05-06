package com.oocl.serviceconsumerfeign.fallback;

import com.oocl.serviceconsumerfeign.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @version: 1.0.0
 * @Author: Danny Zeng
 * @Date: 2021/5/4 22:29
 * @LastEditors: Danny Zeng
 * @LastEditTime: 2021/5/4 22:29
 */

@Component
public class MyFallback implements HelloService {
    @Override
    public String sayHello() {
        return "远程服务不可用，请稍后...";
    }
}
