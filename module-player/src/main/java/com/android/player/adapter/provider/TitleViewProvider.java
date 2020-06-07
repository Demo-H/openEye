package com.android.player.adapter.provider;

import androidx.databinding.DataBindingUtil;

import com.android.common.entity.BaseCustomViewModel;
import com.android.player.R;
import com.android.player.bean.viewmodel.VideoTextViewModel;
import com.android.player.databinding.PlayerItemTitleWhiteViewBinding;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Dhunter on 2020/6/5.
 */
public class TitleViewProvider  extends BaseItemProvider<BaseCustomViewModel> {
    @Override
    public int getItemViewType()
    {
        return IVideoItemType.TITLE_VIEW;
    }

    @Override
    public int getLayoutId()
    {
        return R.layout.player_item_title_white_view;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder,
                        @Nullable BaseCustomViewModel baseCustomViewModel) {
        if (baseCustomViewModel == null) {
            return;
        }
        PlayerItemTitleWhiteViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setViewModel((VideoTextViewModel)baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}