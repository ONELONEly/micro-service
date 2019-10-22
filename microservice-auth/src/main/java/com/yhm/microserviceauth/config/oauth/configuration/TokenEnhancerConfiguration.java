package com.yhm.microserviceauth.config.oauth.configuration;

import com.yhm.microservicecommon.constant.SecurityConstants;
import com.yhm.microserviceauth.config.oauth.converter.AccessTokenConverter;
import com.yhm.microservicecommon.constant.CommonConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * token增强配置(废弃)
 * @deprecated
 */
public class TokenEnhancerConfiguration {

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        AccessTokenConverter jwtAccessTokenConverter = new AccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(CommonConstant.SIGN_KEY);
        return jwtAccessTokenConverter;
    }
    /**
     * jwt 生成token 定制化处理
     *
     * @return TokenEnhancer
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            final Map<String, Object> additionalInfo = new HashMap<>(2);
            additionalInfo.put("license", SecurityConstants.SERVICE_LICENSE);
            /*UserDetailsImpl user = (UserDetailsImpl) authentication.getUserAuthentication().getPrincipal();
            if (user != null) {
                additionalInfo.put("userId", user.getUserId());
            }*/
            //additionalInfo.put("userId","180260");
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }

}
