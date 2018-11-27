package com.example.reach.example.fragment;

import com.example.reach.example.R;
import com.example.reach.example.base.BaseFragment;
import com.example.reach.example.utils.mLog;

/**
 * Created by ZX on 2018/11/26
 */
public class Fragment_Nav3 extends BaseFragment {

    @Override
    protected int setFragmentView() {
        return R.layout.fragment_nav3;
    }

    @Override
    protected void initView() {
        mLog.e("Fragment_Nav3","-->3View");
    }

    @Override
    protected void lazyLoadData() {
        mLog.e("Fragment_Nav3","-->3");
    }
}
