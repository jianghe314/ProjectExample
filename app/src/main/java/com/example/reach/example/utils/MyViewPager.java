package com.example.reach.example.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by ZX on 2018/12/6
 */
public class MyViewPager extends ViewPager {


    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean isScrollHorizontal=false;
        float oldX=ev.getX();
        float oldY=ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                float lastX=getX();
                float lastY=getY();
                if(Math.abs(lastX-oldX)-Math.abs(lastY-oldY)>0){
                    isScrollHorizontal=true;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;

        }
        return isScrollHorizontal;


        //return super.onInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }
}
