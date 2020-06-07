package com.android.player.adapter.provider;

import com.android.common.entity.BaseCustomViewModel;
import com.android.player.R;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Dhunter on 2020/6/5.
 */
public class NominateViewProvider extends BaseItemProvider<BaseCustomViewModel> {
    @Override
    public int getItemViewType() {
        return IVideoItemType.NOMINATE_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.player_item_video_card_white_view;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, @Nullable BaseCustomViewModel baseCustomViewModel) {

    }
}
