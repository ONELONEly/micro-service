package com.yhm.microserviceauth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhm.microserviceauth.entity.Do.SysResource;
import com.yhm.microserviceauth.mapper.SysResourceMapper;
import com.yhm.microserviceauth.service.ISysResourceService;
import com.yhm.microservicecommon.constant.AuthConstants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements ISysResourceService {

    @Override
    public boolean checkPermission(List<String> roles, String path) {
        //判断参数是否为空
        if(CollectionUtils.isEmpty(roles)|| StringUtils.isBlank(path)){
            return false;
        }
        //判断是否存在超级管理员角色
        if(roles.contains(AuthConstants.SUPER_ROLE_ID)){
            return true;
        }
        //检查是否有权限
        return baseMapper.selectResourceCountByRoleAndPath(roles,path)>0?true:false;
    }
}
