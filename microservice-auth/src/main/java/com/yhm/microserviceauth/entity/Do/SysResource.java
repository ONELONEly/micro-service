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
 * @since 2019-03-18
 */
@Data
    @EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SYS_RESOURCE")
public class SysResource extends Model<SysResource> {

private static final long serialVersionUID = 1L;

        /**
         * 资源ID
         */
                    @TableId("RESOURCE_ID")
                private Double resourceId;

        /**
         * 资源路径
         */
    @TableField("RESOURCE_PATH")
        private String resourcePath;

        /**
         * 资源所属服务
         */
    @TableField("RESOURCE_SERVICE")
        private String resourceService;

        /**
         * 资源描述
         */
    @TableField("RESOURCE_DESC")
        private String resourceDesc;

        /**
         * 是否可用,0=否;1=是
         */
    @TableField("IS_ENABLE")
        private Double isEnable;


@Override
protected Serializable pkVal() {
            return this.resourceId;
        }

        }
