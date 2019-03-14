package com.youmi.demo.domain;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "demo1", fallback = HystrixClientFallback.class)
public interface OpenFeign {

    @GetMapping("/test")//这里的请求路径需要和eureka-client中的请求路径一致
    public String test();//这里的方法名需要和eureka-client中的方法名一致

}
