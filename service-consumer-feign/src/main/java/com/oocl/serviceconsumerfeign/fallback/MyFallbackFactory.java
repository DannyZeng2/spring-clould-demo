package com.oocl.serviceconsumerfeign.fallback;

import com.oocl.serviceconsumerfeign.service.HelloService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFallbackFactory implements FallbackFactory<HelloService> {


    @Override
    public HelloService create(Throwable throwable) {
        return new HelloService() {
            @Override
            public String sayHello() {
                return throwable.getMessage();
            }
        };
    }
}