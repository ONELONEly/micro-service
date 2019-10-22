package com.yhm.microserviceauth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yhm.microserviceauth.entity.Do.SysMenu;
import com.yhm.microserviceauth.mapper.SysMenuMapper;
import com.yhm.microserviceauth.service.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yhm
 * @since 2019-03-23
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<SysMenu> getMenuByUsernameAndClientId(String userName, String clientId) {
        return baseMapper.getMenuByUsernameAndClientId(userName,clientId);
    }
}
