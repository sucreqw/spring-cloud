package com.youmi.demo.controller;

import com.youmi.demo.domain.OpenFeign;
import com.youmi.demo.entity.User;

import com.youmi.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("/demo")
    public String feign() {
        return "通过demo调用demo1:" + openFeign.test();
    }

    @GetMapping("/zuul")
    public String testZuul() {

        return "8084";
    }

    @GetMapping(value = "/getuser", produces = {"application/json;charset=UTF-8"})
    public User testSQL(int id) {
        User user = userService.getByUserId(id);

        return user;
    }

    @GetMapping(value = "/searchuser", produces = {"application/json;charset=UTF-8"})
    public User search(String nick) {

        List<User> user = new ArrayList<>();
        user = userService.search(nick);

        return user.get(0);
    }

    @GetMapping("/setredis")
    public String setredis(String data) {
        // 最后参数设置时间单位，第三个设置的是时间。（2天后过期）
        redisTemplate.opsForValue().set("test", data, 2, TimeUnit.DAYS);
        return "redis set:" + data;
    }

    @GetMapping("/getredis")
    public String getredis() {
        // 最后参数设置时间单位，第三个设置的是时间。（2天后过期）

        return redisTemplate.opsForValue().get("test").toString();
    }
}
