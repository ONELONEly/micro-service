package com.yhm.microserviceauth.config.oauth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yhm.microserviceauth.config.oauth.service.DefaultUserDetailsService;
import com.yhm.microserviceauth.entity.Do.SysRole;
import com.yhm.microserviceauth.entity.Do.SysUser;
import com.yhm.microserviceauth.service.ISysRoleService;
import com.yhm.microserviceauth.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
@Primary
public class DafaultUserDetailsServiceImpl implements DefaultUserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    ISysUserService sysUserService;

    @Autowired
    ISysRoleService sysRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = sysUserService.getOne(new QueryWrapper<SysUser>().eq("USER_NAME", username));
        if(user!=null){
            if(user.getDeadlineDt()!=null&&user.getDeadlineDt().isBefore(LocalDateTime.now())){
                throw new AccessDeniedException("用户已过期！");
            }
            if(user.getIsEnable().intValue()!=1){
                throw new AccessDeniedException("用户不可用！");
            }
            //获取角色
            List<SysRole> roles = sysRoleService.getRolesByUserId(user.getUserId().intValue());
            return new org.springframework.security.core.userdetails.User(username,user.getPassword() , getAuthorities(roles));
        }else{
            throw new UsernameNotFoundException("用户不存在!");
        }


    }

    public Collection<? extends GrantedAuthority> getAuthorities(List<SysRole> roles) {
        Collection<GrantedAuthority> collection = new HashSet<>();
        if (!CollectionUtils.isEmpty(roles)) {
            roles.parallelStream().forEach(role -> collection.add(new SimpleGrantedAuthority(String.valueOf(role.getRoleId().intValue()))));
        }
        return collection;
    }



}
