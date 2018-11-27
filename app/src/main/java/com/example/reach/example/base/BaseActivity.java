package com.example.reach.example.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.reach.example.utils.ErrorDialog;
import com.example.reach.example.utils.LoadingDialog;
import com.example.reach.example.utils.WaitDialog;

/**
 * Created by ZX on 2018/11/26
 */
public class BaseActivity extends AppCompatActivity {

    protected ErrorDialog errorDialog;
    protected WaitDialog waitDialog;
    protected LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    protected void initView() {
        errorDialog=new ErrorDialog(this);
        waitDialog=new WaitDialog(this);
        loadingDialog=new LoadingDialog(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        loadingDialog.onDestory();
    }
}
