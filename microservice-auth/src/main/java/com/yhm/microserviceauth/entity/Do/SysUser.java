package com.yhm.microserviceauth.entity.Do;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


/**
 * <p>
 *
 * </p>
 *
 * @author yhm
 * @since 2019-03-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("SYS_USER")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId("USER_ID")
    private Double userId;

    /**
     * 用户名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 用户中文名称
     */
    @TableField("CHINESE_NAME")
    private String chineseName;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 登录IP
     */
    @TableField("LOGIN_IP")
    private String loginIp;

    /**
     * 部门ID
     */
    @TableField("DEP_ID")
    private String depId;

    /**
     * 部门名称
     */
    @TableField("DEP_NAME")
    private String depName;

    /**
     * 是否可用,0=否;1=是
     */
    @TableField("IS_ENABLE")
    private Double isEnable;

    /**
     * 是否过期,0=否;1=是
     */
    @TableField("ACCOUNT_NON_EXPIRED")
    private Double accountNonExpired;

    /**
     * 是否锁定,0=否;1=是
     */
    @TableField("ACCOUNT_NON_LOCKED")
    private Double accountNonLocked;

    /**
     * 证书是否可用,0=否;1=是
     */
    @TableField("CREDENTIALS_NON_EXPIRED")
    private Double credentialsNonExpired;

    /**
     * 邮箱
     */
    @TableField("MAIL")
    private String mail;

    /**
     * 头像路径
     */
    @TableField("AVATAR")
    private String avatar;

    /**
     * 创建时间
     */
    @TableField("CREATE_DT")
    private LocalDateTime createDt;

    /**
     * 最后登录时间
     */
    @TableField("LAST_LOGIN_DT")
    private LocalDateTime lastLoginDt;

    /**
     * 失效时期
     */
    @TableField("DEADLINE_DT")
    private LocalDateTime deadlineDt;

    /**
     * 更新时间
     */
    @TableField("UPDATE_DT")
    private LocalDateTime updateDt;

    /**
     * 简介
     */
    @TableField("INTRODUCTION")
    private String introduction;

}
