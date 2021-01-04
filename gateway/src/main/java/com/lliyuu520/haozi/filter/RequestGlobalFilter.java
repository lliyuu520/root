package com.lliyuu520.haozi.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import sun.security.util.SecurityConstants;

/**
 * RequestGlobalFilter
 *
 * @author lliyuu520
 * @since 2020/9/17:17:23
 */
@Configuration
public class RequestGlobalFilter implements GlobalFilter, Ordered {



    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {


        final ServerHttpRequest request = exchange.getRequest();
        final String authorization = request.getHeaders().getFirst("Authorization");

        ServerHttpRequest newRequest = request.mutate().header("Authorization", authorization).build();
        return chain.filter(exchange.mutate().request(newRequest.mutate().build()).build());
    }

    /**
     * 知道顺序
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}

