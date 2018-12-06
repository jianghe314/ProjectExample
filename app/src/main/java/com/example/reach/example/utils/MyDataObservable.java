package com.example.reach.example.utils;

/**
 * Created by ZX on 2018/12/4
 */
public class MyDataObservable extends Observalbe<Observer> {

    public void notifyChanged(){
        synchronized (mObserver){
            for (int i = mObserver.size()-1; i >=0 ; i--) {
                mObserver.get(i).onChanged();
            }
        }
    }

    public void notifyInvalidated(){
        synchronized (mObserver){
            for (int i = mObserver.size()-1; i >= 0 ; i--) {
                mObserver.get(i).onInvalidated();
            }
        }
    }

}
