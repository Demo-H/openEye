package com.android.common.services;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 *
 * 类描述: app相关信息
 * Created by Dhunter on 2020/6/4.
 */
public interface IAppInfoService extends IProvider {

    String APP_INFO_SERVICE_NAME = "app_info_service";

    String getApplicationName();

    String getApplicationVersionName();

    String getApplicationVersionCode();

    boolean getApplicationDebug();
}
