package com.android.user;

import com.android.base.app.BaseApplication;
import com.android.common.IModuleInit;

/**
 * Created by Dhunter on 2020/6/4.
 */
public class UserModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(BaseApplication application) {
        return false;
    }

    @Override
    public boolean onInitLow(BaseApplication application) {
        return false;
    }
}
