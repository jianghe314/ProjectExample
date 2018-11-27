package com.example.reach.example.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.example.reach.example.R;


/**
 * Created by zx on 2018/11/21.
 */

public class WaitDialog extends Dialog {

    private TextView tv;
    private LoadingDialog loading;
    public WaitDialog(@NonNull Context context) {
        super(context, R.style.MyDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.wait_dialog_layout);
        initView();
    }

    private void initView() {
        tv=findViewById(R.id.wait_dialog_tv);
        loading=findViewById(R.id.wait_dialog_progress);
    }

    public void setWatiContent(String msg){
        //tv的内容默认为正在加载
        tv.setText(msg);
    }

    public void onDestory(){
        if(loading!=null){
            loading.onDestory();
        }
    }




}
