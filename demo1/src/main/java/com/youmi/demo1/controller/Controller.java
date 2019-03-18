package com.youmi.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: Controller
 * @Package
 * @Description:
 * @date 2019-03-13 17:48
 */
@RestController
public class Controller {

    @GetMapping("/test")
    public String hello(){

        return "hello spring cloud! ";
    }

    @GetMapping("/zuul")
    public String testZuul(){

        return "8083";
    }
}
