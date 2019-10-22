package com.yhm.microserviceauth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhm.microserviceauth.entity.Do.SysUser;
import com.yhm.microserviceauth.mapper.SysUserMapper;
import com.yhm.microserviceauth.service.ISysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yhm
 * @since 2019-03-18
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
