package com.youmi.demo.controller;

import com.youmi.demo.domain.OpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: Controller
 * @Package
 * @Description:
 * @date 2019-03-14 10:59
 */
@RestController
public class Controller {



    @Autowired
     OpenFeign openFeign;

    @GetMapping("/demo")
    public String feign(){
        return "通过demo调用demo1:" + openFeign.test();
    }


}
