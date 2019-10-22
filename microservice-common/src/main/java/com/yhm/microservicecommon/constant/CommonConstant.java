package com.yhm.microservicecommon.constant;

public class CommonConstant {
    private CommonConstant() {
    }


    /**
     * token分割符
     */
    public static final String TOKEN_SPLIT = "Bearer ";

    /**
     * jwt签名
     */
    public static final String SIGN_KEY = "yhm";
    /**
     * 删除
     */
    public static final String STATUS_DEL = "1";
    /**
     * 正常
     */
    public static final String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    public static final String STATUS_LOCK = "9";

    /**
     * 菜单
     */
    public static final String MENU = "0";

    /**
     * 按钮
     */
    public static final String BUTTON = "1";

    /**
     * 删除标记
     */
    public static final String DEL_FLAG = "del_flag";

    /**
     * 编码
     */
    public static final String UTF8 = "UTF-8";

    /**
     * JSON 资源
     */
    public static final String CONTENT_TYPE = "application/json; charset=utf-8";

    /**
     * 阿里大鱼
     */
    public static final String ALIYUN_SMS = "aliyun_sms";

    /**
     * 路由信息Redis保存的key
     */
    public static final String ROUTE_KEY = "_ROUTE_KEY";



}
