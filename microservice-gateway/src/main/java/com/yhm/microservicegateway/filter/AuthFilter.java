package com.yhm.microservicegateway.filter;

import com.alibaba.fastjson.JSON;
import com.yhm.microservicecommon.constant.AuthConstants;
import com.yhm.microservicecommon.constant.ServiceConstants;
import com.yhm.microservicegateway.config.HttpAuthenticationManagerConfigurer;
import com.yhm.microservicegateway.config.authentication.manager.HttpAuthenticationManager;
import com.yhm.microservicegateway.config.oauth.properties.SecurityProperties;
import com.yhm.microservicegateway.execption.TokenExpiredExecption;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Configuration
@Import({HttpAuthenticationManagerConfigurer.class})
@Slf4j
public class AuthFilter {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpAuthenticationManager httpAuthenticationManager;
    /**
     * 校验Token方法
     * @return
     */
    @Bean
    @Order(-1)
    public GlobalFilter tokenAuth_new() {
        return (exchange, chain) -> {
            String serviceApplicationName=null;
            ServerHttpRequest request = null;
            if(exchange instanceof ServerWebExchangeDecorator){
                request = ((ServerWebExchangeDecorator) exchange).getDelegate().getRequest();
            }else{
                request = exchange.getRequest();
            }
            try {
                Map<String, Object> authenticate = httpAuthenticationManager.authenticate(request);
                ServerWebExchange build = exchange.mutate().request(builder -> builder.header(AuthConstants.AUTH_HEADER, JSON.toJSONString(authenticate))).build();
                return chain.filter(build).then(Mono.fromRunnable(() -> {}));
            }catch (TokenExpiredExecption e){
                exchange.getResponse().setStatusCode(HttpStatus.PROXY_AUTHENTICATION_REQUIRED);
            }catch (Exception e) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            }
            return exchange.getResponse().setComplete();

        };
    }
    /**
     * 校验Token方法
     * @deprecated
     * @return
     */
    //@Bean
    //@Order(-1)
    public GlobalFilter tokenAuth() {
        return (exchange, chain) -> {
            String serviceApplicationName=null;
            ServerHttpRequest request = null;
            if(exchange instanceof ServerWebExchangeDecorator){
                request = ((ServerWebExchangeDecorator) exchange).getDelegate().getRequest();
            }else{
                request = exchange.getRequest();
            }

            //申请token或刷新token请求不限制
            if(request.getURI().toString().endsWith(AuthConstants.ACCESS_TOKEN_URI)
                    ||request.getURI().toString().endsWith(AuthConstants.REFRESH_TOKEN_URI)
                    ||request.getURI().toString().endsWith(AuthConstants.CHECK_TOKEN_URI)
                    || StringUtils.endsWithAny(request.getURI().toString(),AuthConstants.EXCEPTION_TPYE)
                    ){
                ServerWebExchange build = exchange.mutate().request(builder -> {}).build();
                return chain.filter(build).then(Mono.fromRunnable(() -> {}));
            }
            HttpHeaders headers = request.getHeaders();
            List<String> authorization_list = headers.get(AuthConstants.TOKEN_HEADER);
            if(CollectionUtils.isEmpty(authorization_list)){
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            }else{
                try {
                    //PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
                    //if(delegatingPasswordEncoder.matches(authorization_list.get(0),CommonConstant.SUPER_AUTH)){
                    //管理员token校验
                    if(AuthConstants.SUPER_TOKEN.equals(authorization_list.get(0))){
                        ServerWebExchange build = exchange.mutate().request(builder -> builder.header(AuthConstants.AUTH_HEADER, "{    \"userId\": \"admin\"}")).build();
                        return chain.filter(build).then(Mono.fromRunnable(() -> {}));
                    }

                    //auth服务token校验
                    ResponseEntity<String> forEntity = restTemplate.getForEntity("http://"+ ServiceConstants.AUTH+"/oauth/check_token?token={1}", String.class, authorization_list.get(0));
                    ServerWebExchange build = exchange.mutate().request(builder -> builder.header(AuthConstants.AUTH_HEADER, forEntity.getBody())).build();
                    return chain.filter(build).then(Mono.fromRunnable(() -> {}));

                }catch (HttpClientErrorException e){
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                }

            }
            return exchange.getResponse().setComplete();

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
