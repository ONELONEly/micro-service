package com.yhm.microservicecommon.constant;

    public class AuthConstants {

    /**
     *  超级管理员token编码后值
     */
    public static final String SUPER_AUTH= "{bcrypt}$2a$10$gXwNUZnXZe2d4eQP3YuIEeCiTbzHeMQc92DbQZMeGluMdT9wyllNy";

    /**
     * 超级管理员token
     */
    public static final String SUPER_TOKEN= "e5df21d27f0b407d87a13788e7e673d9";

    /**
     * 超级管理员角色ID
     */
    public static final String SUPER_ROLE_ID= "1";

    /**
     * 定制化token添加参数名
     */
    public static final String TOKEN_ENHANCER_PARAM= "custom";

    /**
     * 请求token地址
     */
    public static final String ACCESS_TOKEN_URI = "/oauth/token";

    /**
     * 刷新token地址
     */
    public static final String REFRESH_TOKEN_URI = "/oauth/refresh_token";

    /**
     * 检查token地址
     */
    public static final String CHECK_TOKEN_URI = "/oauth/check_token";

    /**
     * token请求头名称
     */
    public static final String TOKEN_HEADER = "x-authorization";

    /**
     * token请求参数名称
     */
    public static final String TOKEN_PARAM = "access_token";

    /**
     * token解码后请求头名称
     */
    public static final String AUTH_HEADER = "x-authorization-decode";

    /**
     * authService名称
     */
    public static final String AUTH_SERVICE = "microServiceAuth";


        /**
     * 不过滤文件
     */
    public static final String[] EXCEPTION_TPYE  = new String[]{"html"};



}
