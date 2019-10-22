package com.yhm.microserviceauth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhm.microserviceauth.entity.Do.SysRole;
import com.yhm.microserviceauth.mapper.SysRoleMapper;
import com.yhm.microserviceauth.service.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yhm
 * @since 2019-03-18
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public List<SysRole> getRolesByUserId(Integer userId) {
        return baseMapper.getRolesByUserId(userId);
    }
}
