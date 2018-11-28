package com.example.reach.example.utils;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.reach.example.R;

import java.util.List;

/**
 * Created by ZX on 2018/11/28
 */
public class Banner extends FrameLayout {

    private  int placeholderImage;
    private  int errorImage;
    private BannerAdapter bannerAdapter;

    public Banner(@NonNull Context context) {
        this(context,null);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        RecyclerView recyclerView=new RecyclerView(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        bannerAdapter=new BannerAdapter();
        recyclerView.setAdapter(bannerAdapter);
        addView(recyclerView);
    }

    public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.bannerHolder>{

        private List<String> imageUrl;
        private Context context;
        private int[] resId;

        public BannerAdapter(Context context,List<String> imageUrl) {
            this.imageUrl = imageUrl;
            this.context=context;
        }

        public BannerAdapter(Context context,int...resId){
            this.context=context;
            this.resId=resId;
        }

        @NonNull
        @Override
        public bannerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull bannerHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return imageUrl==null?resId.length:imageUrl.size();
        }

        class bannerHolder extends RecyclerView.ViewHolder{

            ImageView iv;

            public bannerHolder(View itemView) {
                super(itemView);
                iv=itemView.findViewById(R.id.banner_iv);
            }

            public void bindImage(String imageUrl){
                RequestOptions requestOptions=new RequestOptions().skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(placeholderImage).error(errorImage);
                Glide.with(context).load(imageUrl).apply(requestOptions).into(iv);
            }
        }
    }
}
