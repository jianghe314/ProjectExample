package com.example.reach.example;

import android.app.Application;
import android.content.Context;

/**
 * Created by ZX on 2018/11/26
 */
public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }

    public static Context getMyApplicationContext(){
        return context;
    }
}
