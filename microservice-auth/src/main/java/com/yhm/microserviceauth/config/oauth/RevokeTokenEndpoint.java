package com.yhm.microserviceauth.config.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@FrameworkEndpoint
public class RevokeTokenEndpoint {
    @Autowired
    @Qualifier("consumerTokenServices")
    ConsumerTokenServices consumerTokenServices;

    @RequestMapping(method = {RequestMethod.POST}, value = "/oauth/revoke_token")
    @ResponseBody
    public Object revokeToken(String token) {
        Map<String,Object> result = new HashMap<>();
        if (consumerTokenServices.revokeToken(token)){
            result.put("success",true);
            result.put("message","注销成功！");
        }else{
            result.put("success",false);
            result.put("message","注销失败！");
        }
        return result;
    }
}
