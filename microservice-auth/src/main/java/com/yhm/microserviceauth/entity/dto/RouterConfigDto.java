package com.yhm.microserviceauth.entity.dto;

import com.yhm.microserviceauth.entity.Do.SysMenu;
import lombok.Data;

@Data
public class RouterConfigDto {

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 名称
     */
    private String name;

    /**
     * 是否隐藏
     */
    private Boolean hidden;

    /**
     * 重定向路径
     */
    private String redirect;

    /**
     * 总是显示，即使没有子路由也显示根菜单
     */
    private Boolean alwaysShow;

    /**
     * 配置项
     */
    private RouterMetaDto meta;

    public RouterConfigDto(SysMenu menu) {
        path = menu.getMenuPath();
        name = menu.getMenuName();
        redirect = menu.getRedirect();
        hidden = menu.getIshidden()!=null?menu.getIshidden()>0d?true:false:null;
        alwaysShow = menu.getAlwaysshow()!=null?menu.getAlwaysshow()>0d?true:false:null;
        meta = new RouterMetaDto(menu);
    }
}
