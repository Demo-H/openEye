package com.android.base.activity;

/**
 * 应用模块: activity
 * <p>
 * 类描述: 界面UI显示切换
 * <p>
 * * Created by Dhunter on 2020/6/2.
 */
public interface IBaseView {
    /**
     * 显示内容
     */
    void showContent();

    /**
     * 显示加载提示
     */
    void showLoading();

    /**
     * 显示空页面
     */
    void showEmpty();

    /**
     * 刷新失败
     */
    void showFailure(String message);
}
