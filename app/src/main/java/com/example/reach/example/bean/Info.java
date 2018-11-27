package com.example.reach.example.bean;

import javax.inject.Inject;

import dagger.Module;

/**
 * Created by ZX on 2018/11/26
 */

public class Info {

    private String Info;

    @Inject
    public Info(String info) {
        Info = "测试222";
    }

    public String getInfo() {
        return Info;
    }

}
