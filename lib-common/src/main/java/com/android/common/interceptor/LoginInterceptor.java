package com.android.common.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.android.common.router.RouterActivityPath;
import com.android.common.services.ILoginService;
import com.orhanobut.logger.Logger;

/**
 * 类描述: 登录状态拦截器
 * Created by Dhunter on 2020/6/4.
 */
@Interceptor(priority = 8)
public class LoginInterceptor implements IInterceptor {
    private Context mContext;
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (postcard.getPath().equals(RouterActivityPath.User.PAGER_ATTENTION)){
            ILoginService iLoginService = ARouter.getInstance().navigation(ILoginService.class);
            if (iLoginService.isLogin()){
                // 处理完成，交还控制权
                callback.onContinue(postcard);
            }else {
                ARouter.getInstance().build(RouterActivityPath.User.PAGER_LOGIN).greenChannel().navigation(mContext);
                callback.onInterrupt(null);
            }
        }else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        this.mContext = context;
        Logger.d("登录拦截器被初始化了");
    }
}
