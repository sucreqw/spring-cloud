package com.youmi.demorab;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: MsgProducer
 * @Package
 * @Description:
 * @date 2019-03-26 15:48
 */
@Component
public class MsgProducer implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate template;
    //private RabbitTemplate rabbitTemplate;

    @Autowired
    public MsgProducer(RabbitTemplate rabbitTemplate) {
        this.template = rabbitTemplate;
        this.template.setConfirmCallback(this);
    }
    public void send(String name) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        template.convertAndSend("exchange",name,"hello,rabbit~",correlationData);
        System.out.println("msg send");
        Map<String,String> set=new Hashtable<>();

    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("confirm: " + correlationData.getId() + ",cause=" + cause + ",ack:" + ack);
    }
}