package com.yhm.microserviceauth.config.oauth.store;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;

/**
 * 认证服务器使用Redis存取令牌
 * 注意: 需要配置redis参数
 *
 * @author zlt
 * @date 2018/7/25 9:36
 */
public class AuthRedisTokenStore {
    @Resource
    private RedisTemplate<String, Object> redisTemplate ;

    @Bean
    public TokenStore tokenStore() {
        RedisTemplateTokenStore redisTemplateStore = new RedisTemplateTokenStore()  ;
        redisTemplateStore.setRedisTemplate(redisTemplate);
        return redisTemplateStore;
    }
}
