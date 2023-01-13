package com.example.ApiGateWayService.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGateWayConfig {
//    @Bean
//    public RouteLocator getRoutes(RouteLocatorBuilder builder){
//        return builder.routes().route(p->p.path("/api/authservice/**").
//                uri("http://localhost:9091")).
//                route(p->p.path("/api/productservice/**").
//                uri("http://localhost:9092")).build();
//    }
    @Bean
    public RouteLocator getRoutes(RouteLocatorBuilder builder){
        return builder.routes().route(p->p.path("/api/authservice/**").
                        uri("lb://Auth-service")).
                route(p->p.path("/api/productservice/**").
                        uri("lb://Customer-service")).build();
    }
}
