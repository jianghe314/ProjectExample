package com.example.reach.example.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.reach.example.base.BaseFragment;

import java.util.List;

/**
 * Created by ZX on 2018/12/4
 */
public class FragmentStatePagerAdapter extends android.support.v4.app.FragmentStatePagerAdapter {


    private List<BaseFragment> fragmentList;

    public FragmentStatePagerAdapter(List<BaseFragment> fragmentList,FragmentManager fm) {
        super(fm);
        this.fragmentList=fragmentList;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
