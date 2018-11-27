package com.example.reach.example.fragment;

import com.example.reach.example.R;
import com.example.reach.example.base.BaseFragment;
import com.example.reach.example.utils.mLog;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ZX on 2018/11/26
 */
public class Fragment_Nav2 extends BaseFragment {

    @Override
    protected int setFragmentView() {
        return R.layout.fragment_nav2;
    }

    @Override
    protected void initView() {
        mLog.e("Fragment_Nav2","-->2View");
    }

    @Override
    protected void initData() {
        Observable<Boolean> observable=Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                emitter.onNext(true);
                emitter.onNext(true);
                emitter.onNext(false);
                emitter.onComplete();
                emitter.onNext(true);
                emitter.onNext(true);
            }
        });
        Observer<Boolean> observer=new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {
                mLog.e("Observer","-->onSubscribe()");
            }

            @Override
            public void onNext(Boolean aBoolean) {
                mLog.e("Observer","-->Boolean()"+aBoolean);
            }

            @Override
            public void onError(Throwable e) {
                mLog.e("Observer","-->onError()");
            }

            @Override
            public void onComplete() {
                mLog.e("Observer","-->onComplete()");
            }
        };
        observable.subscribe(observer);
    }

    @Override
    protected void lazyLoadData() {
        mLog.e("Fragment_Nav2","-->2");
    }
}
