package com.youmi.gatewaydemo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: Controller
 * @Package
 * @Description:
 * @date 2019-03-19 14:40
 */
@RestController

public class Controller {


        @GetMapping("/timeout")
        public String timeout(){

            return "time out while connecting server.";
        }

}
