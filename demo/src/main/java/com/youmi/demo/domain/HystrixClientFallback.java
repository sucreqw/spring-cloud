package com.youmi.demo.domain;

import org.springframework.stereotype.Component;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: ystrixClientFallback
 * @Package
 * @Description: 隔断机制时要执行的方法。
 * @date 2019-03-14 11:33
 */
@Component
public class HystrixClientFallback implements OpenFeign {


    @Override
    public String test() {
        return "HystrixClientFallback works...";
    }
}
