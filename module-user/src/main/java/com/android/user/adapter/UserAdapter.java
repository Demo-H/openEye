package com.android.user.adapter;

import com.android.user.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Dhunter on 2020/6/5.
 */
public class UserAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public UserAdapter() {
        super(R.layout.user_item_view_layout);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, @Nullable String s) {
        baseViewHolder.setText(R.id.tv_item,s);
    }
}
