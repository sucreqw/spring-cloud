package com.youmi.demorab;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: MsgProducer
 * @Package
 * @Description:
 * @date 2019-03-26 15:48
 */
@Component
public class MsgProducer  {

    @Autowired
    private AmqpTemplate template;

    public void send(String name) {
        template.convertAndSend("exchange",name,"hello,rabbit~");
        System.out.println("msg send");

    }
}