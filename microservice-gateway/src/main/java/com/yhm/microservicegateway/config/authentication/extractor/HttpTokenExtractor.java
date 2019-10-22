package com.yhm.microservicegateway.config.authentication.extractor;

import org.springframework.http.server.reactive.ServerHttpRequest;

public interface HttpTokenExtractor {

    String extract(ServerHttpRequest request);
}
