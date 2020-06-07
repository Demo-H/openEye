package com.android.player.adapter;


import com.android.common.entity.BaseCustomViewModel;
import com.android.player.adapter.provider.IVideoItemType;
import com.android.player.adapter.provider.NominateViewProvider;
import com.android.player.adapter.provider.ReplyViewProvider;
import com.android.player.adapter.provider.TitleViewProvider;
import com.android.player.bean.viewmodel.ReplyViewModel;
import com.android.player.bean.viewmodel.VideoCardViewModel;
import com.android.player.bean.viewmodel.VideoTextViewModel;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by Dhunter on 2020/6/5.
 */
public class ProviderVideoPagerAdapter extends BaseProviderMultiAdapter<BaseCustomViewModel> {
    public ProviderVideoPagerAdapter() {
        addItemProvider(new TitleViewProvider());
        addItemProvider(new NominateViewProvider());
        addItemProvider(new ReplyViewProvider());
    }

    @Override
    protected int getItemType(@NotNull List<? extends BaseCustomViewModel> data, int position) {

        if (data.get(position) instanceof VideoTextViewModel) {
            return IVideoItemType.TITLE_VIEW;
        } else if (data.get(position) instanceof VideoCardViewModel) {
            return IVideoItemType.NOMINATE_VIEW;
        } else if (data.get(position) instanceof ReplyViewModel) {
            return IVideoItemType.REPLY_VIEW;
        }
        return 0;
    }
}
