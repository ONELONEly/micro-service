package com.yhm.microservicegateway.config;

import com.yhm.microservicegateway.config.authentication.extractor.HttpTokenExtractor;
import com.yhm.microservicegateway.config.authentication.extractor.impl.DefaultHttpTokenExtractor;
import com.yhm.microservicegateway.config.authentication.manager.HttpAuthenticationManager;
import com.yhm.microservicegateway.config.authentication.manager.impl.DefaultHttpAuthenticationManager;
import com.yhm.microservicegateway.config.oauth.properties.SecurityProperties;
import com.yhm.microservicegateway.feign.AuthTokenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import(SecurityProperties.class)
public class HttpAuthenticationManagerConfigurer {

    @Autowired
    SecurityProperties securityProperties;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    AuthTokenApi authTokenApi;


    @Bean
    HttpTokenExtractor httpTokenExtractor(){
        return new DefaultHttpTokenExtractor();
    }


    @Bean
    public HttpAuthenticationManager httpAuthenticationManager(){
        return  new DefaultHttpAuthenticationManager(securityProperties,httpTokenExtractor(),authTokenApi);
    }


}
