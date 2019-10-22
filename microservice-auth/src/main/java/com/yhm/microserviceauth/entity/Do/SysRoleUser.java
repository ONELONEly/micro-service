package com.yhm.microserviceauth.entity.Do;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("SYS_ROLE_USER")
public class SysRoleUser extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    @TableField("USER_ID")
    private Double userId;

    @TableField("ROLE_ID")
    private Double roleId;


}
