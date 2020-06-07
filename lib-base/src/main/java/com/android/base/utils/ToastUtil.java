package com.android.base.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Dhunter on 2020/6/2.
 */
public class ToastUtil {
    private static Toast mToast;

    public static void show(Context context, String msg) {
        try {
            if(null != context && !TextUtils.isEmpty(msg)) {
                if(null != mToast) {
                    mToast.cancel();
                }
                mToast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
                mToast.setText(msg);
                mToast.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
