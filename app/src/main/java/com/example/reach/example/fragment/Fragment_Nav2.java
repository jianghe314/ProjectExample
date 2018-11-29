package com.example.reach.example.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.reach.example.R;
import com.example.reach.example.base.BaseFragment;
import com.example.reach.example.utils.RecyclerViewBanner;
import com.example.reach.example.utils.mLog;


/**
 * Created by ZX on 2018/11/26
 */
public class Fragment_Nav2 extends BaseFragment {

    private RecyclerViewBanner banner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLog.e("Fragment_Nav2","-->onCreate()");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLog.e("Fragment_Nav2","-->onViewCreated()");
    }

    @Override
    protected int setFragmentView() {
        mLog.e("Fragment_Nav2","-->onCreateView()");
        return R.layout.fragment_nav2;
    }

    @Override
    protected void initView() {
        banner=findViewById(R.id.fragment2_banner);
    }

    @Override
    protected void initData() {
        banner.setImageUrl(R.drawable.banner_error,R.drawable.banner1,R.drawable.banner1,R.drawable.banner1,R.drawable.banner_error);
        banner.show();
    }

    @Override
    protected void lazyLoadData() {
        mLog.e("Fragment_Nav2","-->lazyLoadData()");
    }
}
