package com.youmi.rabrev;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: HelloReceive
 * @Package
 * @Description:
 * @date 2019-03-26 16:36
 */
@Component
public class HelloReceive {

    @RabbitListener(queues="queue")    //监听器监听指定的Queue
    public void processC(String str) {
        System.out.println("Receive:"+str);
    }

    @RabbitListener(queues="topic.message")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("message:"+str);
    }
    @RabbitListener(queues="topic.test")    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("test:"+str);
    }
    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
    public void message(String str) {
        System.out.println("messages:"+str);
    }
}
