package com.youmi.gatewaydemo;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sucre chen 906509023@qq.com
 * @Title: GatewayConfig
 * @Package
 * @Description:
 * @date 2019-03-18 16:53
 */
@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                //basic proxy
                .route(r -> r.path("/test/**")
                        .uri("http://localhost:8083")
                ).build();
    }
}
