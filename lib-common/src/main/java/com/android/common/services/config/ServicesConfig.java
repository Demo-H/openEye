package com.android.common.services.config;

/**
 * 类描述: 各个组件需要暴露给外部的service名称 配置
 * Created by Dhunter on 2020/6/4.
 */
public class ServicesConfig {
    private static final String SERVICE = "/service";

    /** 用户模块 */
    public static class User {
        /** 用户登录状态 */
        public static final String LONGING_SERVICE = SERVICE + "/login";
    }
}
