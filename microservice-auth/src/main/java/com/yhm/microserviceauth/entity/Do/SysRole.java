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
@TableName("SYS_ROLE")
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId("ROLE_ID")
    private Double roleId;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
     * 插入时间
     */
    @TableField("CREATE_DT")
    private LocalDateTime createDt;

    /**
     * 更新时间
     */
    @TableField("UPDATE_DT")
    private LocalDateTime updateDt;

    /**
     * 角色等级
     */
    @TableField("ROLE_LEVEL")
    private Double roleLevel;

    /**
     * 角色等级序号
     */
    @TableField("LEVEL_NUM")
    private Double levelNum;

    /**
     * 角色等级代码
     */
    @TableField("LEVEL_CODE")
    private String levelCode;

    /**
     * 是否可用
     */
    @TableField("IS_ENABLE")
    private Double isEnable;
}

