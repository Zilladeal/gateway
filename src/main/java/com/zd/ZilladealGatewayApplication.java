package com.zd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ZilladealGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZilladealGatewayApplication.class, args);
    }
//http://localhost:8558/jewellery/gold/rate
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("r1", r -> r
                        .path("/jewellery/**")
                        .uri("http://localhost:9800/jewellery/gold/rate"))
                .build();
    }
}
