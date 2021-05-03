package com.oocl.serviceconsumer.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.oocl.serviceconsumer.hystrix.MyHystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 设置超时时间2s，默认1s
     * 忽略异常，不进入fallbackMethod方法：ignoreExceptions = Exception.class
     */
    @RequestMapping("/web/hello")
    @HystrixCommand(fallbackMethod = "getErrorMsg", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000" )})
    public String sayHello() {
        // int a = 10/0;
        return "consumer:" + restTemplate.getForEntity("http://SERVICE-PROVIDER/service/hello",String.class).getBody();
    }

    @RequestMapping("/web/user")
    public String getUser() {
        return "consumer:" + restTemplate.getForEntity("http://SERVICE-PROVIDER/service/user",String.class).getBody();
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance instance = this.loadBalancerClient.choose("SERVICE-PROVIDER");
        System.out.println("111: " + instance.getServiceId() + ": " + instance.getHost() + ": " + instance.getPort());
        return instance.toString();

    }

    private String getErrorMsg(Throwable throwable) {
        // 远程调用失败后处理逻辑
        System.out.println(throwable.getMessage());
        return "error...";
    }

    @RequestMapping("/web/hystrix")
    public String testHystrixCommand() throws ExecutionException, InterruptedException {
        MyHystrixCommand command = new MyHystrixCommand(
                com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),
                restTemplate);
        // 同步调用（等待结果返回,才继续往下执行）
        // String syncResult = command.execute();

        // 异步调用
        Future<String> future = command.queue();
        String noSyncResult = future.get();

        // 其他业务逻辑
        System.out.println("other logic....");
        return noSyncResult;

    }


}
