package com.android.user;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.android.common.router.RouterActivityPath;

/**
 * Created by Dhunter on 2020/6/4.
 */
@Route(path = RouterActivityPath.User.PAGER_ATTENTION)
public class AttentionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_attention);
    }
}
