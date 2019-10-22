package com.yhm.microserviceauth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yhm.microserviceauth.entity.Do.SysResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yhm
 * @since 2019-03-18
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {

    int selectResourceCountByRoleAndPath(@Param("roleIds") List<String> roleIds, @Param("path") String path);


}
