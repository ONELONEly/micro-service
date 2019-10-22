package com.yhm.microserviceauth.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yhm.microserviceauth.api.AuthTokenApi;
import com.yhm.microserviceauth.entity.Do.SysMenu;
import com.yhm.microserviceauth.entity.Do.SysUser;
import com.yhm.microserviceauth.entity.dto.RouterConfigDto;
import com.yhm.microserviceauth.entity.dto.UserDTO;
import com.yhm.microserviceauth.service.ISysMenuService;
import com.yhm.microserviceauth.service.ISysResourceService;
import com.yhm.microserviceauth.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.endpoint.CheckTokenEndpoint;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class AuthTokenController implements AuthTokenApi {

    @Autowired
    CheckTokenEndpoint checkTokenEndpoint;

    @Autowired
    ISysResourceService resourceService;

    @Autowired
    ISysUserService sysUserService;

    @Autowired
    ISysMenuService sysMenuService;

    @Override
    public Map<String, Object> checkToken(@RequestParam("token") String value,@RequestParam("path") String path) {
        Map<String, Object> authentication = (Map<String, Object>) checkTokenEndpoint.checkToken(value);
        List<String> role_id_list = (List<String>) authentication.get("authorities");
        if(!resourceService.checkPermission(role_id_list,path)){
            throw new InvalidTokenException("no permission access!");
        }
        return authentication;
    }

    @Override
    public UserDTO getTokenInfo(@RequestParam("token") String value) {
        UserDTO result = new UserDTO();
        Map<String, Object> authentication = (Map<String, Object>) checkTokenEndpoint.checkToken(value);
        if(authentication.get("user_name")!=null){
            String user_name = (String) authentication.get("user_name");
            SysUser sysUser = sysUserService.getOne(new QueryWrapper<SysUser>().eq("USER_NAME", user_name));
            if(sysUser==null){
                throw  new InvalidTokenException("invalid user info!");
            }
            result.setAvatar(sysUser.getAvatar());
            result.setIntroduction(sysUser.getIntroduction());
            result.setName(sysUser.getChineseName());
            result.setUser(sysUser.getUserName());
            result.setStatus(sysUser.getIsEnable().intValue());
            result.setCilentId((String)authentication.get("client_id"));
            result.setRoles((List<String>) authentication.get("authorities"));
        }

        return result;
    }

    @Override
    public List<RouterConfigDto> getMenuInfo(@RequestParam("user_name") String userName, @RequestParam("client_id") String clientId) {
        List<SysMenu> menus = sysMenuService.getMenuByUsernameAndClientId(userName,clientId);
        return menus.stream().map(x -> new RouterConfigDto(x)).collect(Collectors.toList());
    }

    @ExceptionHandler({InvalidTokenException.class})
    public ResponseEntity<OAuth2Exception> handleInvalidTokenException(Exception e) throws Exception {
        return checkTokenEndpoint.handleException(e);
    }


}
