package com.android.base.activity;

/**
 * Created by Dhunter on 2020/6/2.
 */
public interface IBasePagingView extends IBaseView {
    /**
     * 加载更多失败
     * */
    void onLoadMoreFailure(String message);

    /**
     * 没有更多了
     * */
    void onLoadMoreEmpty();
}
