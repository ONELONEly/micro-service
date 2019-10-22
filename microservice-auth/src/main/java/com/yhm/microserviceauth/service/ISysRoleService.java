package com.yhm.microserviceauth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yhm.microserviceauth.entity.Do.SysRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yhm
 * @since 2019-03-18
 */
public interface ISysRoleService extends IService<SysRole> {

    List<SysRole> getRolesByUserId(Integer userId);

}
