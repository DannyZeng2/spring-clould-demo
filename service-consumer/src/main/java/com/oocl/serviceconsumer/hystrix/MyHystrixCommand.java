package com.oocl.serviceconsumer.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

/**
 * @version: 1.0.0
 * @Author: Danny Zeng
 * @Date: 2021/5/2 22:55
 * @LastEditors: Danny Zeng
 * @LastEditTime: 2021/5/2 22:55
 * 自定义HystrixCommand
 */
public class MyHystrixCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    public MyHystrixCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        return "hystrix consumer:" + restTemplate.getForEntity("http://SERVICE-PROVIDER/service/hello",String.class).getBody();
    }

    @Override
    protected String getFallback() {
        return "error";
    }
}
