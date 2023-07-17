package com.example.gateway;

import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CustomFilter implements GlobalFilter, OrderedFilter {

    private static final String HEADER_NAME = "spring-cloud-course";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (!exchange.getRequest().getHeaders().containsKey(HEADER_NAME)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        // Устанавливаем порядок выполнения фильтра
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
