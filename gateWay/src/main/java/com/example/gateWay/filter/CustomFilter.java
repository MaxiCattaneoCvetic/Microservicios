package com.example.gateWay.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Configuration // ya que es un archivo de configuracion de filtros custom
public class CustomFilter implements GlobalFilter {

    Logger logger = LoggerFactory.getLogger(CustomFilter.class);


// con el objeto exchange podemos acceder a informacion de la request

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Request to: " + exchange.getRequest().getPath()); // aca le decimos hacia donde se esta enviando la request
        //lo que hacemos en el return es permitir que la request siga su camino
        return chain.filter(exchange);
    }
}
