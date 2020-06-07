package com.android.player;

import com.android.base.activity.IBaseView;
import com.android.common.entity.BaseCustomViewModel;

import java.util.ArrayList;

/**
 * Created by Dhunter on 2020/6/5.
 */
public interface IVideoPlayerView extends IBaseView {
    /**
     * 数据加载完成
     *
     * @param viewModels data
     */
    void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels);
}
