package com.android.common;

import com.android.base.app.BaseApplication;

/**
 * <p>
 * 类描述: 动态配置组件Application,有需要初始化的组件实现该接口,统一在宿主app 的Application进行初始化
 * <p>
 * Created by Dhunter on 2020/6/3.
 */
public interface IModuleInit {
    /** 需要优先初始化的 */
    boolean onInitAhead(BaseApplication application);

    /** 冷启动可以后初始化的 */
    boolean onInitLow(BaseApplication application);
}
