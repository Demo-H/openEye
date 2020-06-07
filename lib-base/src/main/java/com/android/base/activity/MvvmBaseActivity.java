package com.android.base.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.android.base.loadsir.EmptyCallback;
import com.android.base.loadsir.ErrorCallback;
import com.android.base.loadsir.LoadingCallback;
import com.android.base.loadsir.callback.Callback;
import com.android.base.loadsir.core.LoadService;
import com.android.base.loadsir.core.LoadSir;
import com.android.base.utils.ToastUtil;
import com.android.base.viewmodel.IMvvmBaseViewModel;

/**
 * <p>
 * 类描述: activity抽象基类
 * <p>
 *
 * Created by Dhunter on 2020/6/3.
 */
public abstract class MvvmBaseActivity<V extends ViewDataBinding, VM extends IMvvmBaseViewModel>
        extends AppCompatActivity implements IBaseView {
    protected V mViewDataBinding;
    protected VM mViewModel;
    protected LoadService mLoadService;
    private boolean isShowedContent = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
        performDataBinding();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mViewModel && mViewModel.isUiAttach()) {
            mViewModel.detachUi();
        }
    }

    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        if (getBindingVariable() > 0) {
            mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        }
        mViewDataBinding.executePendingBindings();
    }

    private void initViewModel() {
        mViewModel = getViewModel();
        if (null != mViewModel) {
            mViewModel.attachUi(this);
        }
    }

    /**
     * 注册LoadSir
     *
     * @param view 替换视图
     */
    public void setLoadSir(View view) {
        if (mLoadService == null){
            mLoadService = LoadSir.getDefault()
                    .register(view, (Callback.OnReloadListener) v -> onRetryBtnClick());
        }
    }

    @Override
    public void showContent() {
        if (null != mLoadService) {
            isShowedContent = true;
            mLoadService.showSuccess();
        }
    }
    @Override
    public void showLoading() {
        if (null != mLoadService) {
            mLoadService.showCallback(LoadingCallback.class);
        }
    }

    @Override
    public void showEmpty() {
        if (null != mLoadService) {
            mLoadService.showCallback(EmptyCallback.class);
        }
    }

    @Override
    public void showFailure(String message) {
        if (null != mLoadService) {
            if (!isShowedContent) {
                mLoadService.showCallback(ErrorCallback.class);
            } else {
                ToastUtil.show(this, message);
            }
        }
    }

    /**
     * 获取viewModel
     */
    protected abstract VM getViewModel();

    /**
     * 获取参数Variable
     */
    protected abstract int getBindingVariable();

    @LayoutRes
    protected abstract int getLayoutId();

    /**
     * 失败重试,重新加载事件
     */
    protected abstract void onRetryBtnClick();
}
