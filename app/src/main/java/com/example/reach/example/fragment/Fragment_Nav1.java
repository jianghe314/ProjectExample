package com.example.reach.example.fragment;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.reach.example.MyApplication;
import com.example.reach.example.R;
import com.example.reach.example.adapter.fragment1Adapter;
import com.example.reach.example.base.BaseFragment;
import com.example.reach.example.utils.mLog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZX on 2018/11/26
 */
public class Fragment_Nav1 extends BaseFragment {

    private RecyclerView recyclerView;
    private fragment1Adapter adapter;
    private List<String> data=new LinkedList<>();
    private SmartRefreshLayout refreshLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLog.e("Fragment_Nav1","-->onCreate()");
    }

    @Override
    protected int setFragmentView() {
        mLog.e("Fragment_Nav1","-->onCreateView()");
        return R.layout.fragment_nav1;
    }

    @Override
    protected void initView() {
        mLog.e("Fragment_Nav1","-->onViewCreated()");
        recyclerView=findViewById(R.id.fragment_nav1_recyclerview);
        refreshLayout=findViewById(R.id.fragment1_smart_refresh);
        adapter=new fragment1Adapter(data,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                //数据刷新
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        data.clear();
                        initData();
                        refreshLayout.finishRefresh();
                        refreshLayout.setNoMoreData(false);
                    }
                }, 2000);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                //加载更多
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(adapter.getItemCount() > 30){
                            Toast.makeText(MyApplication.getMyApplicationContext(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
                            refreshLayout.finishLoadMoreWithNoMoreData();//将不会再次触发加载更多事件
                        }else {
                            initData();
                            refreshLayout.finishLoadMore();
                        }
                    }
                }, 2000);
            }
        });
        //触发自动刷新
        refreshLayout.autoRefresh();

    }

    @Override
    protected void initData() {

        for (int i = 0; i <=20 ; i++) {
            data.add("这是第"+i+"条数据");
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void lazyLoadData() {
        mLog.e("Fragment_Nav1","-->lazyLoadData()");
    }
}
