package com.example.reach.example;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshInitializer;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.yanzhenjie.nohttp.InitializationConfig;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.cache.DBCacheStore;

/**
 * Created by ZX on 2018/11/26
 */
public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        initNoHttp();
    }

    //设置刷新全局样式
    static {
        SmartRefreshLayout.setDefaultRefreshInitializer(new DefaultRefreshInitializer() {
            @Override
            public void initialize(@NonNull Context context, @NonNull RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
            }
        });
    }

    public static Context getMyApplicationContext(){
        return context;
    }

    private void initNoHttp() {
        //配置nohttp链接超时和缓存到数据库
        InitializationConfig.Builder builder=InitializationConfig.newBuilder(this);
        builder.connectionTimeout(10*1000)
                .readTimeout(10*1000)
                .cacheStore(new DBCacheStore(this).setEnable(true)).build();
        InitializationConfig config= builder.build();
        NoHttp.initialize(config);
    }


}
