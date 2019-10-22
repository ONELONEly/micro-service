package com.yhm.microservicecommon.constant;

import java.util.concurrent.TimeUnit;

public final class SecurityConstants {

    private SecurityConstants() {
    }

    /**
     * client缓存有效时间
     */
    public static final long CLIENT_CACHE_TIMEOUT = 30;

    /**
     * client缓存有效时间单位
     */
    public static final TimeUnit CLIENT_CACHE_TIMEOUT_UNIT = TimeUnit.MINUTES;

    /**
     * 前缀
     */
    public static final String SERVICE_PREFIX = "yhm_";
    /**
     * 用户信息头
     */
    public static final String USER_HEADER = "x-user-header";

    /**
     * 角色信息头
     */
    public static final String ROLE_HEADER = "x-role-header";
    /**
     * 项目的license
     */
    public static final String SERVICE_LICENSE = "made by gree";

    /**
     * 缓存client的redis key，这里是hash结构存储
     */
    public static final String CACHE_CLIENT_KEY = "oauth_client_details";

    /**
     * 基础角色
     */
    public static final String BASE_ROLE = "ROLE_USER";
    /**
     * 授权码模式
     */
    public static final String AUTHORIZATION_CODE = "authorization_code";
    /**
     * 密码模式
     */
    public static final String PASSWORD = "password";
    /**
     * 刷新token
     */
    public static final String REFRESH_TOKEN = "refresh_token";

    /**
     * oauth token
     */
    public static final String OAUTH_TOKEN_URL = "/oauth/token";

    /**
     * 手机登录URL
     */
    public static final String MOBILE_TOKEN_URL = "/mobile/token";

    /**
     * 默认的处理验证码的url前缀
     */
    public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * 手机号的处理验证码的url前缀
     */
    public static final String MOBILE_VALIDATE_CODE_URL_PREFIX = "/smsCode";

    /**
     * 默认生成图形验证码宽度
     */
    public static final String DEFAULT_IMAGE_WIDTH = "100";

    /**
     * 默认生成图像验证码高度
     */
    public static final String DEFAULT_IMAGE_HEIGHT = "40";

    /**
     * 默认生成图形验证码长度
     */
    public static final String DEFAULT_IMAGE_LENGTH = "4";

    /**
     * 默认生成图形验证码过期时间
     */
    int DEFAULT_IMAGE_EXPIRE = 60;
    /**
     * 边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue.
     */
    public static final String DEFAULT_COLOR_FONT = "black";

    /**
     * 图片边框
     */
    public static final String DEFAULT_IMAGE_BORDER = "no";
    /**
     * 默认图片间隔
     */
    public static final String DEFAULT_CHAR_SPACE = "5";

    /**
     * 默认保存code的前缀
     */
    public static final String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY";
    /**
     * 验证码文字大小
     */
    public static final String DEFAULT_IMAGE_FONT_SIZE = "30";

    /**
     * token-uservo
     */
    public static final String TOKEN_USER_DETAIL = "token-user-detail";

    /**
     * 默认的social的登录地址
     */
    public static final String DEFAULT_SOCIAL_PROCESS_URL = "/social";
    /**
     * 默认的social的注册地址
     */
    public static final String DEFAULT_SOCIAL_SIGNUP_URL = "/social/signup";

    /**
     * sys_oauth_client_details 表的字段，不包括client_id、client_secret
     */
    public static final String CLIENT_FIELDS = "client_id, client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    /**
     *JdbcClientDetailsService 查询语句
     */
    public static final String BASE_FIND_STATEMENT = "select " + CLIENT_FIELDS
            + " from sys_oauth_client_details";

    /**
     * 默认的查询语句
     */
    public static final String DEFAULT_FIND_STATEMENT = BASE_FIND_STATEMENT + " order by client_id";

    /**
     * 按条件client_id 查询
     */
    public static final String DEFAULT_SELECT_STATEMENT = BASE_FIND_STATEMENT + " where client_id = ?";

}
