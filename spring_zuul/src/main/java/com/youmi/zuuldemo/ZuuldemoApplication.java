package com.youmi.zuuldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@ComponentScan(basePackages = {"com.youmi.zuuldemo.filter"})
public class ZuuldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuuldemoApplication.class, args);
	}

}
