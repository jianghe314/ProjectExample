package com.example.reach.example.utils;

import android.content.pm.ApplicationInfo;
import android.util.Log;

import com.example.reach.example.MyApplication;

/**
 * Created by ZX on 2018/11/19
 */
public class mLog {
    //此方法在debug的时候返回true,在release 版本返回false
    private static boolean isLog(){
        ApplicationInfo applicationInfo= MyApplication.getMyApplicationContext().getApplicationInfo();
        return (applicationInfo.flags & ApplicationInfo.FLAG_DEBUGGABLE)!=0;
    }
    public static void e(String tag,String msg){
        if(isLog()){
            Log.e(tag,msg);
        }
    }
}
