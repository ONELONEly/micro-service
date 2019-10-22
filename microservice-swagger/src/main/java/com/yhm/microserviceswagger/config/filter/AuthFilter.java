package com.yhm.microserviceswagger.config.filter;

import com.yhm.microservicecommon.constant.AuthConstants;
import com.yhm.microservicecommon.constant.ServiceConstants;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

//@configuration
public class AuthFilter {

    private static final Logger log = LogManager.getLogger(AuthFilter.class);

    @Autowired
    RestTemplate restTemplate;


    /**
     * 校验Token方法
     * @return
             */
    @Bean
    @Order(-1)
    public GlobalFilter tokenAuth() {
        return (exchange, chain) -> {

            ServerHttpRequest request = exchange.getRequest();
            ServerWebExchange build = exchange.mutate().request(builder -> {}).build();
            return chain.filter(build).then(Mono.fromRunnable(() -> {}));
        };
    }

    //执行顺序abcd
    //@Bean
    @Order(0)
    public GlobalFilter b() {
        return (exchange, chain) -> {

            log.info("a");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("d");
            }));
        };
    }

    //@Bean
    @Order(1)
    public GlobalFilter c() {
        return (exchange, chain) -> {
            log.info("b");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("c");
            }));
        };
    }
}
