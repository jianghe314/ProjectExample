package com.example.reach.example.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by ZX on 2018/12/3
 */
public class MyBaseFragment extends Fragment {

    //View是否已经被初始化
    private boolean isInit=false;
    private Bundle savedInstanceState;
    private boolean isLazyLoad=true;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
