package com.android.base.model;

/**
 * Created by Dhunter on 2020/6/2.
 */
public interface IPagingModelListener<T> extends IBaseModelListener {
    /**
     * 数据加载完成
     *
     * @param model model
     * @param data 数据
     * @param isEmpty 数据是否为空
     * @param isFirstPage 是否是第一页
     */
    void onLoadFinish(BasePagingModel model, T data, boolean isEmpty, boolean isFirstPage);

    /**
     * 数据加载失败
     *
     * @param model model
     * @param prompt 错误
     * @param isFirstPage 是否是第一页
     */
    void onLoadFail(BasePagingModel model, String prompt, boolean isFirstPage);
}