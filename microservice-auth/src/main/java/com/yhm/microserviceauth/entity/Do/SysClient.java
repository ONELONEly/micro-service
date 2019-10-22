package com.yhm.microserviceauth.entity.Do;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yhm
 * @since 2019-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SYS_CLIENT")
public class SysClient extends Model<SysClient> {

    private static final long serialVersionUID = 1L;

    /**
     * 客户端id
     */
    @TableId("CLIENT_ID")
    @NotBlank(message ="参数:clientId(客户端id)不能为空!")
    @Length(max = 100,message = "参数:clientId(客户端id)长度异常,最大长度为:100!")
    private String clientId;

    /**
     * 客户端秘钥
     */
    @TableField("CLIENT_SECRET")
    @Length(max = 100,message = "参数:clientSecret(客户端秘钥)长度异常,最大长度为:100!")
    private String clientSecret;

    /**
     * 授权码模式
     */
    @TableField("AUTHORIZED_GRANT_TYPES")
    @Length(max = 100,message = "参数:authorizedGrantTypes(授权码模式)长度异常,最大长度为:100!")
    private String authorizedGrantTypes;

    /**
     * 回调地址
     */
    @TableField("REDIRECT_URI")
    @Length(max = 500,message = "参数:redirectUri(回调地址)长度异常,最大长度为:500!")
    private String redirectUri;

    /**
     * TOKEN失效时长（秒）
     */
    @TableField("ACCESS_TOKEN_VALIDITY_SECONDS")
    private Double accessTokenValiditySeconds;

    /**
     * REFRESH_TOKEN失效时长（秒）
     */
    @TableField("REFRESH_TOKEN_VALIDITY_SECONDS")
    private Double refreshTokenValiditySeconds;

    /**
     * 作用域
     */
    @TableField("SCOPES")
    private String scopes;


    @Override
    protected Serializable pkVal() {
        return this.clientId;
    }

}
