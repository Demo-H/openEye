package com.android.base.loadsir;

import com.android.base.R;
import com.android.base.loadsir.callback.Callback;
/**
 * <p>
 * 类描述: 空页面
 * <p>
 * Created by Dhunter on 2020/6/2.
 */
public class EmptyCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.base_layout_empty;
    }
}
