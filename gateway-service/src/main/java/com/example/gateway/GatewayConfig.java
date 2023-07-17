package com.example.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {


    CustomFilter customFilter = new CustomFilter();

    @Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

        return (RouteLocator) builder.routes()
                .route("book-service", r -> r.path("/api/book-service/**")

                        .filters(f -> f.rewritePath("/api/book-service/(?.*)","/${remains}")
                                       .filter((GatewayFilter) customFilter)
                                       .removeRequestHeader("spring-cloud-course"))

                        .uri("lb://book-service/"));
    }
}
