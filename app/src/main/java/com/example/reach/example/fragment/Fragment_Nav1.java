package com.example.reach.example.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.reach.example.R;
import com.example.reach.example.base.BaseFragment;
import com.example.reach.example.bean.DaggerInfoComponent;
import com.example.reach.example.bean.Info;
import com.example.reach.example.bean.InfoComponent;
import com.example.reach.example.utils.mLog;

import javax.inject.Inject;

/**
 * Created by ZX on 2018/11/26
 */
public class Fragment_Nav1 extends BaseFragment {

    @Inject
    Info info;

    private TextView tv;

    @Override
    protected int setFragmentView() {

        return R.layout.fragment_nav1;
    }

    @Override
    protected void initView() {
        tv=findViewById(R.id.nav_txt1);
        DaggerInfoComponent.create().inject(this);


        mLog.e("Fragment_Nav1","-->1View");
    }

    @Override
    protected void lazyLoadData() {

        mLog.e("Fragment_Nav1","-->1");
    }
}
