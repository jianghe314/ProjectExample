package com.example.reach.example.base;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reach.example.utils.mLog;

/**
 * Created by ZX on 2018/11/26
 */
public abstract class BaseFragment extends Fragment {

    //是否已经加载
    private boolean isLoad=false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setFragmentView(),container,false);
    }

    protected abstract int setFragmentView();

    //初始化控件
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
        initData();
    }

    protected  void initView(){

    };

    protected void initData(){

    }

    protected <T extends View> T findViewById(@IdRes int Id){
        return getView().findViewById(Id);
    };

    //此方法会在onCreate()方法之前调用一次，当视图切换到当前fragment时，还会调用一次
    //相应的getgetUserVisibleHint()先为false,然后为true
    //第一次加载时，先调用lazyLoadData()方法，再调用initView()方法
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser&&!isLoad){
            lazyLoadData();
        }
    }

    protected void lazyLoadData() {

    }


}
