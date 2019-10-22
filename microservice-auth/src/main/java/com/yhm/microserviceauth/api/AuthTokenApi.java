package com.yhm.microserviceauth.api;

import com.yhm.microserviceauth.entity.dto.RouterConfigDto;
import com.yhm.microserviceauth.entity.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/authToken")
public interface AuthTokenApi {

    /**
     * 校验token方法
     * @param value
     * @return
     */
    @RequestMapping(value = "/oauth/check_token")
    @ResponseBody
    Map<String, Object> checkToken(@RequestParam("token") String value,@RequestParam("path") String path);

    /**
     * 获取token信息
     * @param value
     * @return
     */
    @RequestMapping(value = "/oauth/getTokenInfo")
    @ResponseBody
    UserDTO getTokenInfo(@RequestParam("token") String value);

    /**
     * 获取菜单信息
     * @param userName
     * @param clientId
     * @return
     */
    @RequestMapping(value = "/oauth/getMenuInfo")
    @ResponseBody
    List<RouterConfigDto> getMenuInfo(@RequestParam("user_name") String userName, @RequestParam("client_id") String clientId);
}