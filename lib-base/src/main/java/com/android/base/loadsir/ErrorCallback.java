package com.android.base.loadsir;

import com.android.base.R;
import com.android.base.loadsir.callback.Callback;

/**
 * <p>
 * 类描述: 错误页面
 * <p>
 * Created by Dhunter on 2020/6/2.
 */
public class ErrorCallback extends Callback {
    @Override
    protected int onCreateView()
    {
        return R.layout.base_layout_error;
    }
}