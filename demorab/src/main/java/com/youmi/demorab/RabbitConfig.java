package com.youmi.demorab;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: RabbitConfig
 * @Package
 * @Description:
 * @date 2019-03-26 15:44
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue() {
        return new Queue("queue");
    }

    @Bean(name="message")
    public Queue queueMessage() {
        return new Queue("topic.message");
    }

    @Bean(name="messages")
    public Queue queueMessages() {
        return new Queue("topic.messages");
    }
    @Bean(name="test")
    public Queue queuetest() {
        return new Queue("topic.test");
    }
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//*表示一个词,#表示零个或多个词
    }

}
