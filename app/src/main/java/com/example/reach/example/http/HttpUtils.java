package com.example.reach.example.http;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;

/**
 * Created by ZX on 2018/11/26
 */
public class HttpUtils {

    private RequestQueue requestQueue;
    private static HttpUtils instance;

    private HttpUtils() {
        this.requestQueue=NoHttp.newRequestQueue(4);
    }

    public static HttpUtils getInstance(){
        if(instance == null){
            synchronized (HttpUtils.class){
                if(instance == null){
                    instance=new HttpUtils();
                }
            }
        }
        return instance;
    }

    public <T> void addRequest(int what, Request<T> request, OnResponseListener listener){
        requestQueue.add(what,request,listener);
    }


    //取消请求
    public void cancelBySign(Object sign){
        requestQueue.cancelBySign(sign);
    }

    //取消所有请求
    public void cancelAll(){
        requestQueue.cancelAll();
    }



}
