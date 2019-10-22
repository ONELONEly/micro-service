package com.yhm.microserviceswagger.config.swagger;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;
import reactor.core.publisher.Mono;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Configuration
public class SwaggerHeaderGlobalFilter {
    private static final String HEADER_NAME = "X-Forwarded-Prefix";

    private static final Logger log = LogManager.getLogger(SwaggerHeaderGlobalFilter.class);


    /**
     * 添加X-Forwarded-Prefix:服务名，使页面测试功能生效不会丢失服务名
     * @return
     */
    @Bean
    @Order(1)
    public GlobalFilter tokenAuth(SwaggerResourcesProvider swaggerResources
    ) {
        return (exchange, chain) -> {

            ServerHttpRequest request=null;
            try{
                ServerWebExchangeDecorator serverWebExchangeDecorator =  (ServerWebExchangeDecorator) exchange;
                request = serverWebExchangeDecorator.getDelegate().getRequest();
            }catch (Exception e){
                request = exchange.getRequest();
            }

            String path = request.getURI().getPath();
            if (!StringUtils.endsWithIgnoreCase(path, SwaggerProvider.API_URI)) {
                return chain.filter(exchange);
            }

            String basePath = path.substring(0, path.lastIndexOf(SwaggerProvider.API_URI));

            ServerWebExchange build = exchange.mutate().request(builder -> {builder.header(HEADER_NAME,basePath);}).build();
            return chain.filter(build).then(Mono.fromRunnable(() -> {}));

            //return exchange.getResponse().setComplete();

        };
    }


    /**
     * 校验Token方法
     * @return
     */
   /* @Bean
    @Order(-1)
    public  GlobalFilter(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            if (!StringUtils.endsWithIgnoreCase(path, SwaggerProvider.API_URI)) {
                return chain.filter(exchange);
            }

            String basePath = path.substring(0, path.lastIndexOf(SwaggerProvider.API_URI));


            ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
            return chain.filter(newExchange);
        };
    }*/
}
