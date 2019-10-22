package com.yhm.microserviceauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhm.microserviceauth.entity.Do.SysRole;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yhm
 * @since 2019-03-18
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> getRolesByUserId(Integer userId);

}
