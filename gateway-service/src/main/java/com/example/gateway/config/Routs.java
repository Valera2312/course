package com.example.gateway.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routs {
@Autowired
CustomFilter customFilter;
    @Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("book-service", r -> r.path("/api/book-service/**")
                        .filters(f -> f.rewritePath("/api/book-service/(?<segment>.*)", "/${segment}")
                        .filter(customFilter)
                        .removeRequestHeader("spring-cloud-course"))
                        .uri("lb://book-service/"))
                .route("client-service", r -> r.path("/api/client/**")
                        .uri("lb://client-service"))
                .route("client-update", r -> r.path("api/update/**")
                        .uri("lb://client-update"))
                .build();
    }

}
