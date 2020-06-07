package com.android.base.loadsir;

import android.content.Context;
import android.view.View;

import com.android.base.R;
import com.android.base.loadsir.callback.Callback;

/**
 * <p>
 * 类描述: 占位布局
 * <p>
 * Created by Dhunter on 2020/6/2.
 */
public class PlaceCallback extends Callback
{
    @Override
    protected int onCreateView()
    {
        return R.layout.base_layout_placeholder;
    }

    @Override
    protected boolean onReloadEvent(Context context, View view)
    {
        return true;
    }
}