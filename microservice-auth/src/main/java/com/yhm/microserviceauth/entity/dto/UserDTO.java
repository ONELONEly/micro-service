package com.yhm.microserviceauth.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    /**
     * 用户id
     */
    String user;
    /**
     * 状态
     */
    Integer status;
    /**
     * 第三方校验code
     */
    String code;
    /**
     * 用户名称
     */
    String name;
    /**
     * 头像
     */
    String avatar;
    /**
     * 简介
     */
    String introduction;
    /**
     * 角色
     */
    List<String> roles;
    /**
     * 客户端
     */
    String cilentId;
}
