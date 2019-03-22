package com.youmi.demo.controller;

import com.youmi.demo.domain.OpenFeign;
import com.youmi.demo.entity.User;

import com.youmi.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: Controller
 * @Package
 * @Description:
 * @date 2019-03-14 10:59
 */
@RestController()

public class Controllers {


    @Autowired
    OpenFeign openFeign;
    @Autowired
    UserService userService;

    @GetMapping("/demo")
    public String feign() {
        return "通过demo调用demo1:" + openFeign.test();
    }

    @GetMapping("/zuul")
    public String testZuul() {

        return "8084";
    }

    @GetMapping(value="/getuser" ,produces = { "application/json;charset=UTF-8" })
    public User testSQL(int id) {
        User user=userService.getByUserId(id);

        return user;
    }

    @GetMapping(value="/searchuser",produces = { "application/json;charset=UTF-8" })
    public User search(String nick ) {

        List<User> user=new ArrayList<>();
        user=userService.search(nick);

        return user.get(0);
    }
}
