package com.example.reach.example.utils;

import java.util.ArrayList;

/**
 * Created by ZX on 2018/12/4
 */
public abstract class Observalbe<T> {

    protected final ArrayList<T> mObserver=new ArrayList<>();

    //注册
    public void registObserver(T observer){
        if(observer == null){
            throw new IllegalArgumentException("oberver is null");
        }
        synchronized (mObserver){
            if(mObserver.contains(observer)){
                throw new IllegalArgumentException("the oberver is registed");
            }
            mObserver.add(observer);
        }
    }

    //注销
    public void unregistObserver(T observer){
        if(observer == null){
            throw new IllegalArgumentException("oberver is null");
        }
        synchronized (mObserver){
            int index=mObserver.indexOf(observer);
            if(index == -1){
                throw new IllegalArgumentException("the observer is not registed");
            }
            mObserver.remove(index);
        }

    }

    //注销所有
    public void unregistAll(){
        mObserver.clear();
    }



}
