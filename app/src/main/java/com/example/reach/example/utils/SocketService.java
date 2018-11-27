package com.example.reach.example.utils;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;


import com.google.gson.Gson;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;


/**
 * Created by ZX on 2018/10/25
 */
public class SocketService extends Service {

    private SingletonCreateConnect singletonCreateConnect;
    private String TAG="SocketService";
    private WebSocket mSocket;
    private Gson gson=new Gson();
    private Handler handler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }; 

    @Override
    public void onCreate() {
        super.onCreate();
        mLog.e(TAG,"-->onCreate()");
        Thread thread=new Thread(new SocketThead());
        thread.start();
    }

    private class SocketThead implements Runnable{

        @Override
        public void run() {
            if(null != mSocket){
                mLog.e(TAG,"直播线程socket-->"+mSocket.isOpen());
            }
            if(null == mSocket ||!mSocket.isOpen()){
                singletonCreateConnect=new SingletonCreateConnect();
                singletonCreateConnect.getInstance().connect();
            }
            handler.postDelayed(this,5000);
        }
    }


    private class SingletonCreateConnect{
        private SingletonCreateConnect singleCreateConnect;

        public SingletonCreateConnect() {
        }

        public SingletonCreateConnect getInstance() {
            if(null == singleCreateConnect){
                synchronized (SingletonCreateConnect.class){
                    if(null == singleCreateConnect){
                        singleCreateConnect=new SingletonCreateConnect();
                    }
                }
            }
            return singleCreateConnect;
        }

        public void  connect(){
            String url="";
            if(url.contains(":")){
                String[] str=url.split(":");
                url=str[0];
            }
            String ws="ws://"+url+":8088"+"/liveandroidsocket?type=LIVE";
            mLog.e(TAG,"ws-->"+ws);
            if(null != mSocket){
                if(mSocket.isOpen()){
                    mSocket.close();
                }
            }
            AsyncHttpClient.getDefaultInstance().websocket(ws, "8088", new AsyncHttpClient.WebSocketConnectCallback() {
                @Override
                public void onCompleted(Exception ex, WebSocket webSocket) {
                    mSocket=webSocket;
                    if(null != ex){
                        ex.printStackTrace();
                    }
                    try {
                        if(webSocket.isOpen()){
                            webSocket.setStringCallback(new WebSocket.StringCallback() {
                                @Override
                                public void onStringAvailable(String s) {
                                    mLog.e(TAG,"返回信息-->"+s);
                                    analysisData(s);
                                }
                            });
                        }
                    }catch (NullPointerException exception){
                        exception.printStackTrace();
                    }

                }
            });
        }
    }

    private void analysisData(String s) {
        if("CLOSE".equals(s)){
           // ARouter.getInstance().build("/activities/MainActivity").navigation();
        }else {
            /*SocketLiveBean socketLiveBean=gson.fromJson(s,SocketLiveBean.class);
            ARouter.getInstance().build("/activities/LiveFullScreenActivity")
                    .withString("address",socketLiveBean.getRtmpAddress()).navigation();*/
        }
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mLog.e(TAG,"-->onStartCommand()");
        if(null != singletonCreateConnect){
            singletonCreateConnect.connect();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        mLog.e(TAG,"-->onDestroy()");
        super.onDestroy();
    }
}
