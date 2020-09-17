package com.lliyuu520.root.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * RequestGlobalFilter
 *
 * @author lliyuu520
 * @since 2020/9/17:17:23
 */
@Configuration
public class RequestGlobalFilter implements GlobalFilter {



    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

//        ServerHttpRequest request = exchange.getRequest().mutate()
//                .headers(httpHeaders -> httpHeaders.remove(SecurityConstants.SECRET_KEY))
//                .build();
        ServerHttpRequest newRequest = exchange.getRequest().mutate().header("GATEWAY", "GATEWAY").build();
        return chain.filter(exchange.mutate().request(newRequest.mutate().build()).build());
    }


}

