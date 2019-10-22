package com.yhm.microservicegateway.config.authentication.manager.impl;

import com.yhm.microservicecommon.constant.AuthConstants;
import com.yhm.microservicegateway.config.authentication.extractor.HttpTokenExtractor;
import com.yhm.microservicegateway.config.authentication.manager.HttpAuthenticationManager;
import com.yhm.microservicegateway.config.oauth.properties.PermitProperties;
import com.yhm.microservicegateway.config.oauth.properties.SecurityProperties;
import com.yhm.microservicegateway.execption.TokenExpiredExecption;
import com.yhm.microservicegateway.feign.AuthTokenApi;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Data
public class DefaultHttpAuthenticationManager implements HttpAuthenticationManager {

    private SecurityProperties securityProperties;

    private HttpTokenExtractor extractor;

    private PathMatcher matcher = new AntPathMatcher();

    private AuthTokenApi authTokenApi;

    public DefaultHttpAuthenticationManager(SecurityProperties securityProperties, HttpTokenExtractor extractor, AuthTokenApi authTokenApi) {
        this.securityProperties = securityProperties;
        this.extractor = extractor;
        this.authTokenApi = authTokenApi;
    }

    @Override
    public Map<String, Object> authenticate(ServerHttpRequest request) throws Exception {
        URI uri = request.getURI();
        //判断是否为不过滤访问路径
        if(IsIgnoreUrl(uri.getPath())){
            HashMap<String, Object> result = new HashMap<>();
            return result;
        }
        //提取token
        String token = extractor.extract(request);
        if(StringUtils.isBlank(token)){
            throw new TokenExpiredExecption("can not extract token!");
        }
        //超级token判断
        if(AuthConstants.SUPER_TOKEN.equals(token)){
            HashMap<String, Object> result = new HashMap<>();
            return result;
        }
        //提交到认证服务器校验
        Map<String, Object> objectMap = null;
        try {
            objectMap = authTokenApi.checkToken(token,uri.getPath());
        } catch (InvalidTokenException e) {
           if(e.getMessage().contains("Token has expired")){
               throw new TokenExpiredExecption("Token has expired");
           }else{
               throw e;
           }
        }
        return objectMap;
    }

    public boolean IsIgnoreUrl(String path) {
        PermitProperties ignore = securityProperties.getIgnore();

        for (String ignoreUrlPattern : ignore.getUrls()){
            if(matcher.match(ignoreUrlPattern,path)){
                return true;
            }
        }
        return false;
    }


}
