package com.android.common.services;

/**
 * 类描述: 与app设置相关
 * Created by Dhunter on 2020/6/4.
 */
public interface ISettingService {

    String SETTINGS_SERVICE_NAME = "settings_service";

    /**
     * 语言
     **/
    public static final int CODE_LANGUAGE = 1;

    /**
     * 主题
     */
    public static final int CODE_THEME = 2;

    /**
     * 字体
     */
    public static final int CODE_FONT_SCHEME = 3;

    /***
     * 获取主题
     * @return 0:暗色  1.亮色  2.纯黑
     */
    public int getThemeValue();

    public void setThemeValue(String theme);
}
