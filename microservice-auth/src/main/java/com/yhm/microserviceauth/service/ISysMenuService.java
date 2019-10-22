package com.yhm.microserviceauth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yhm.microserviceauth.entity.Do.SysMenu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yhm
 * @since 2019-03-23
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 根据用户名及客户端Id获取菜单
     * @param userName 用户名
     * @param clientId 客户端Id
     * @return 菜单集合
     */
    List<SysMenu> getMenuByUsernameAndClientId(String userName, String clientId);

}
