package com.android.player.adapter.provider;

import androidx.databinding.DataBindingUtil;

import com.android.common.entity.BaseCustomViewModel;
import com.android.common.utils.DateTimeUtils;
import com.android.player.R;
import com.android.player.bean.viewmodel.ReplyViewModel;
import com.android.player.databinding.PlayerItemReplyViewBinding;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Dhunter on 2020/6/5.
 */
public class ReplyViewProvider extends BaseItemProvider<BaseCustomViewModel> {
    @Override
    public int getItemViewType()
    {
        return IVideoItemType.REPLY_VIEW;
    }

    @Override
    public int getLayoutId()
    {
        return R.layout.player_item_reply_view;
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
        PlayerItemReplyViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            ReplyViewModel reply = (ReplyViewModel) baseCustomViewModel;
            binding.tvUserReleaseTime.setText("发布于 " + DateTimeUtils.getDate(
                    String.valueOf(reply.releaseTime),
                    "HH:mm"));
            binding.setViewModel(reply);
            binding.executePendingBindings();
        }
    }
}