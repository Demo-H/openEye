package com.android.base.loadsir;

import android.content.Context;
import android.view.View;

import com.android.base.R;
import com.android.base.loadsir.callback.Callback;

/**
 * <p>
 * 类描述: 等待加载
 * <p>
 * Created by Dhunter on 2020/6/2.
 */
public class LoadingCallback extends Callback {
    @Override
    protected int onCreateView()
    {
        return R.layout.base_layout_loading;
    }

    @Override
    public boolean getSuccessVisible()
    {
        return super.getSuccessVisible();
    }

    @Override
    protected boolean onReloadEvent(Context context, View view)
    {
        return true;
    }
}