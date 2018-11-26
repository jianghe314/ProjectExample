package com.example.reach.example.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by ZX on 2018/11/19
 * 正在加载UI
 */
public class Loading extends View {

    private Paint mpaint;
    private Context context;
    private boolean isRecycler=true;
    private int height=40;
    private int  XPos=-40;
    private MyThread myThread;


    public Loading(@NonNull Context context) {
        this(context,null);
    }

    public Loading(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Loading(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initPaint();
    }

    private void initPaint() {
        mpaint=new Paint();
        mpaint.setColor(Color.GREEN);
        mpaint.setStrokeWidth(10.0f);
        mpaint.setStyle(Paint.Style.FILL);


    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.translate(getWidth()/2,getHeight()/2);

        canvas.drawLine(-40,-30,-40,30,mpaint);
        canvas.drawLine(-20,-30,-20,30,mpaint);
        canvas.drawLine(0,-30,0,30,mpaint);
        canvas.drawLine(20,-30,20,30,mpaint);
        canvas.drawLine(40,-30,40,30,mpaint);



        myThread=new MyThread().getInstance();
        myThread.run();

        canvas.drawLine(XPos,-height,XPos,height,mpaint);

    }



    private  class MyThread extends Thread{
        public MyThread() {
        }

        public MyThread getInstance(){
            if(myThread==null){
                synchronized (MyThread.class){
                    if(myThread==null){
                        myThread=new MyThread();
                    }
                }
            }
            return myThread;
        }

        @Override
        public void run() {
            if(XPos >= -40 && XPos < 60){
                XPos=XPos+20;
            }
            if(XPos == 60){
                try {
                    Thread.sleep(200);
                    postInvalidate();
                    XPos=-40;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(200);
                postInvalidate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }



    public void onDestory(){
        if(null!=myThread){
            myThread=null;
        }

    }
}
