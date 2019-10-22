package com.yhm.microserviceauth.entity.dto;

import com.yhm.microserviceauth.entity.Do.SysMenu;
import lombok.Data;

@Data
public class RouterMetaDto {

    /**
     * 名称
     */
    private String title;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否缓存
     */
    private Boolean noCache;

    /**
     * 是否显示面包屑导航栏
     */
    private Boolean breadcrumb;

    public RouterMetaDto(SysMenu menu) {
        title = menu.getTitle();
        icon = menu.getIcon();
        noCache = menu.getIsnocache()!=null?menu.getIsnocache()>0d?true:false:null;
        breadcrumb = menu.getBreadcrumb()!=null?menu.getBreadcrumb()>0d?true:false:null;
    }
}
