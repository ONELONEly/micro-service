package com.yhm.microservicegateway.config.authentication.manager;


import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;

import java.util.Map;

public interface HttpAuthenticationManager  {

    Map<String, Object> authenticate(ServerHttpRequest request) throws Exception;

}
