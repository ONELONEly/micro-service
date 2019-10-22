package com.yhm.microservicegateway.feign;

import com.yhm.microservicecommon.constant.AuthConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("/authToken")
@FeignClient(AuthConstants.AUTH_SERVICE)
@Component
public interface AuthTokenApi {

    /**
     * 校验token方法
     * @param value
     * @return
     */
    @RequestMapping(value = "/oauth/check_token")
    @ResponseBody
    Map<String, Object> checkToken(@RequestParam("token") String value,@RequestParam("path") String path);

}