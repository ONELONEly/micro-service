package com.yhm.microserviceauth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yhm.microserviceauth.entity.Do.SysResource;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yhm
 * @since 2019-03-18
 */
public interface ISysResourceService extends IService<SysResource> {

    /**
     * 判断角色是否拥有传入资源权限
     * @param roles 角色id集合
     * @param path 资源路径
     * @return true=拥有权限，false=没有权限
     */
    boolean checkPermission(List<String> roles,String path);
}
