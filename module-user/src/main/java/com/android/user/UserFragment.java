package com.android.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.android.base.fragment.MvvmBaseFragment;
import com.android.base.viewmodel.IMvvmBaseViewModel;
import com.android.common.router.RouterFragmentPath;
import com.android.user.adapter.UserAdapter;
import com.android.user.databinding.UserFragmentLayoutBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhunter on 2020/6/4.
 */
@Route(path = RouterFragmentPath.User.PAGER_USER)
public class UserFragment extends MvvmBaseFragment<UserFragmentLayoutBinding, IMvvmBaseViewModel> {

    private UserAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.user_fragment_layout;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        Glide.with(getContext()).load(getContext().getDrawable(R.mipmap.avatar))
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(mViewDataBinding.ivAvatar);
        mViewDataBinding.rvRecycler.setHasFixedSize(true);
        mViewDataBinding.rvRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new UserAdapter();
        mAdapter.setFooterView(getFooterView());
        mViewDataBinding.rvRecycler.setAdapter(mAdapter);
        mViewDataBinding.ivMore.setOnClickListener(v -> {startLogin(getContext());});
        mViewDataBinding.tvLike.setOnClickListener(v -> {startLogin(getContext());});
        mViewDataBinding.tvReply.setOnClickListener(v -> {startLogin(getContext());});
    }

    private void initData() {
        List<String> items = new ArrayList<>();
        items.add("我的关注");
        items.add("我的收藏");
        items.add("视频功能声明");
        items.add("用户协议");
        items.add("版权声明");
        items.add("关于作者");
        mAdapter.setNewData(items);
    }

    private View getFooterView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.user_item_footer_view, mViewDataBinding.rvRecycler,false);
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    protected IMvvmBaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected void onRetryBtnClick() {

    }

    private void startLogin(Context context){
        startActivity(new Intent(context,LoginActivity.class));
    }
}
