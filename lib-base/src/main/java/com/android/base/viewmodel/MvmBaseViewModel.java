package com.android.base.viewmodel;

import androidx.lifecycle.ViewModel;

import com.android.base.model.SuperBaseModel;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * 应用模块: viewModel
 * <p>
 * 类描述: 管理 v M
 * <p>
 * Created by Dhunter on 2020/6/2.
 */
public abstract class MvmBaseViewModel<V, M extends SuperBaseModel> extends ViewModel implements IMvvmBaseViewModel<V> {

    private Reference<V> mUiRef;
    protected M model;

    @Override
    public void attachUi(V view) {
        mUiRef = new WeakReference<>(view);
    }

    @Override
    public V getPageView() {
        if(null != mUiRef) {
            return mUiRef.get();
        }
        return null;
    }

    @Override
    public boolean isUiAttach() {
        return null != mUiRef && null != mUiRef.get();
    }

    @Override
    public void detachUi() {
        if(null != mUiRef) {
            mUiRef.clear();
            mUiRef = null;
        }
        if(null != model) {
            model.cancel();
        }
    }

    protected void loadData(){}

    protected abstract void initModel();
}
