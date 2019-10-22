package com.yhm.microserviceauth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yhm
 * @since 2019-03-27
 */
@Data
    @EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SYS_ROLE_MENU")
public class SysRoleMenu extends Model<SysRoleMenu> {

private static final long serialVersionUID = 1L;

    @TableField("MENU_ID")
        private Double menuId;

    @TableField("ROLE_ID")
        private Double roleId;


@Override
protected Serializable pkVal() {
            return null;
        }

        }
