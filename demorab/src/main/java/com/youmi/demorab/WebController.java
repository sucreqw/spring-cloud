package com.youmi.demorab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: webcontroller
 * @Package
 * @Description:
 * @date 2019-03-26 16:05
 */
@RestController
public class WebController {
    @Autowired
    MsgProducer msgProducer;

    @GetMapping("/testmq")
    public String testmq(String name){
         msgProducer.send(name);
        return "yes";
    }
}
