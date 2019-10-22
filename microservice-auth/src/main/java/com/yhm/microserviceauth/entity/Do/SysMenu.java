package com.yhm.microserviceauth.entity.Do;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2019-03-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SYS_MENU")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    @TableId("MENU_ID")
    private Double menuId;

    /**
     * 菜单名称
     */
    @TableField("MENU_NAME")
    private String menuName;

    /**
     * 菜单路径
     */
    @TableField("MENU_PATH")
    private String menuPath;

    /**
     * 组件
     */
    @TableField("COMPONENT")
    private String component;

    /**
     * 是否隐藏
     */
    @TableField("ISHIDDEN")
    private Double ishidden;

    /**
     * 重定向路径
     */
    @TableField("REDIRECT")
    private String redirect;

    /**
     * 总是显示，即使没有子路由也显示根菜单
     */
    @TableField("ALWAYSSHOW")
    private Double alwaysshow;

    /**
     * 名称
     */
    @TableField("TITLE")
    private String title;

    /**
     * 图标
     */
    @TableField("ICON")
    private String icon;

    /**
     * 是否缓存
     */
    @TableField("ISNOCACHE")
    private Double isnocache;

    /**
     * 是否显示面包屑导航栏
     */
    @TableField("BREADCRUMB")
    private Double breadcrumb;

    /**
     * 父菜单
     */
    @TableField("FATHER")
    private String father;


    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }

}
