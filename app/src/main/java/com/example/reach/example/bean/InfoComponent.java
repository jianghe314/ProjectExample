package com.example.reach.example.bean;

import com.example.reach.example.base.BaseFragment;

import dagger.Component;

/**
 * Created by ZX on 2018/11/26
 */
@Component
public interface InfoComponent {

    void inject(BaseFragment baseFragment);
}
