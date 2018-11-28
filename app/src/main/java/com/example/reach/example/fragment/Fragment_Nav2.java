package com.example.reach.example.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.reach.example.R;
import com.example.reach.example.base.BaseFragment;
import com.example.reach.example.utils.mLog;


/**
 * Created by ZX on 2018/11/26
 */
public class Fragment_Nav2 extends BaseFragment {

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

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void lazyLoadData() {
        mLog.e("Fragment_Nav2","-->lazyLoadData()");
    }
}
