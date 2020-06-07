package com.android.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.android.base.activity.IBaseView;
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
 * 类描述: 基类fragment
 * <p>
 * Created by Dhunter on 2020/6/2.
 */
public abstract class MvvmBaseFragment<V extends ViewDataBinding, VM extends IMvvmBaseViewModel>
        extends Fragment implements IBaseView {
    protected V mViewDataBinding;
    protected VM mViewModel;

    protected String mFragmentTag = this.getClass().getSimpleName();
    private LoadService mLoadService; //loadsir 界面管理
    private boolean isShowedContent = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParameters();
        Log.d(mFragmentTag,"onCreate");
    }

    /**
     * 初始化参数
     */
    protected void initParameters() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding =
                DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        Log.d(mFragmentTag, " : onCreateView");
        return mViewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = getViewModel();
        if (null != mViewModel) {
            mViewModel.attachUi(this);
        }
        if (getBindingVariable() > 0) {
            mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
            mViewDataBinding.executePendingBindings();
        }
        Log.d(mFragmentTag, " : onViewCreated");
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(mFragmentTag, " : onAttach");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(mFragmentTag, " : onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(mFragmentTag, " : onPause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(mFragmentTag, " : onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mViewModel && mViewModel.isUiAttach()) {
            mViewModel.detachUi();
        }
        Log.d(mFragmentTag, " : onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (null != mViewModel && mViewModel.isUiAttach()) {
            mViewModel.detachUi();
        }
        Log.d(mFragmentTag, " : onDetach");
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
                ToastUtil.show(getContext(), message);
            }
        }
    }

    public void setLoadSir(View view) {
        mLoadService = LoadSir.getDefault()
                .register(view, (Callback.OnReloadListener) v -> onRetryBtnClick());
    }

    @LayoutRes
    public abstract int getLayoutId();

    /**
     * 获取参数
     */
    public abstract int getBindingVariable();

    /**
     * 获取ViewModel
     */
    protected abstract VM getViewModel();

    /**
     * 失败重试,加载事件
     */
    protected abstract void onRetryBtnClick();
}
