package com.yhm.microserviceauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhm.microserviceauth.entity.Do.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yhm
 * @since 2019-03-23
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    //@Select("select e.* from SYS_USER a, SYS_ROLE_USER b, SYS_ROLE_MENU c, SYS_CLIENT_MENU d,SYS_MENU e, oauth_client_details f where a.user_id = b.user_id and b.role_id = c.role_id and c.menu_id = d.menu_id and d.menu_id = e.menu_id and d.client_id = f.id and f.client_id = #{client_id} and a.user_name =#{user_name}")
    List<SysMenu> getMenuByUsernameAndClientId(@Param("user_name") String userName, @Param("client_id") String clientId);

}
