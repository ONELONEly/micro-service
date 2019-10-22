package com.yhm.microservicegateway.config.authentication.extractor.impl;

import com.yhm.microservicecommon.constant.AuthConstants;
import com.yhm.microservicegateway.config.authentication.extractor.HttpTokenExtractor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@Slf4j
public class DefaultHttpTokenExtractor implements HttpTokenExtractor {

    protected String extractToken(ServerHttpRequest request) {
        // first check the header...
        String token = extractHeaderToken(request);

        // bearer type allows a request parameter as well
        if (token == null) {
            log.debug("Token not found in headers. Trying request parameters.");
            List<String> token_params = request.getQueryParams().get(AuthConstants.TOKEN_PARAM);
            if(!CollectionUtils.isEmpty(token_params)){
                token = token_params.get(0);
            }else{
                log.debug("Token not found in request parameters.  Not an OAuth2 request.");
            }
        }

        return token;
    }

    /**
     * Extract the OAuth bearer token from a header.
     *
     * @param request The request.
     * @return The token, or null if no OAuth authorization header was supplied.
     */
    protected String extractHeaderToken(ServerHttpRequest request) {
        List<String> token_headers = request.getHeaders().get(AuthConstants.TOKEN_HEADER);
        if(!CollectionUtils.isEmpty(token_headers)){
            return  token_headers.get(0);
        }
        return null;
    }

    @Override
    public String extract(ServerHttpRequest request) {
        return extractToken(request);
    }
}
