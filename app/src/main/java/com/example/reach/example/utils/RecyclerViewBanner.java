package com.example.reach.example.utils;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
public class RecyclerViewBanner extends FrameLayout {

    private  int placeholderImage;
    private  int errorImage;
    private BannerAdapter bannerAdapter;
    private List<String> imageUrl;
    private int[] imageUrls;
    private RecyclerView recyclerView;
    private Context context;

    public RecyclerViewBanner(@NonNull Context context) {
        this(context,null);
    }

    public RecyclerViewBanner(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public RecyclerViewBanner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        recyclerView=new RecyclerView(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        SnapHelper snapHelper=new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        addView(recyclerView);
    }

    public void setImageUrl(List<String> imageUrl){
        this.imageUrl = imageUrl;
    }

    public void setImageUrl(int...imageUrls){
        this.imageUrls=imageUrls;
    }

    public void show(){
        bannerAdapter=new BannerAdapter(context,imageUrls);
        recyclerView.setAdapter(bannerAdapter);
        bannerAdapter.notifyDataSetChanged();
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
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_layout,parent,false);
            return new bannerHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final bannerHolder holder, int position) {
            if(imageUrl==null){
                int drawableRes=imageUrls[position];
                holder.bindImage(drawableRes);
            }else {
                String url=imageUrl.get(position);
                holder.bindImage(url);
            }
            holder.itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //抬高Z轴
                    ViewCompat.animate(holder.itemView).scaleX(1.10f).scaleY(1.10f).translationZ(1).start();
                }
            });
            /*if(holder.itemView.isFocusable()){

            }else {
                ViewCompat.animate(holder.itemView).scaleX(1.0f).scaleY(1.0f).translationZ(0).start();
            }
            */


        }

        @Override
        public int getItemCount() {
            return resId.length;
        }

        class bannerHolder extends RecyclerView.ViewHolder{

            ImageView iv;

            public bannerHolder(View itemView) {
                super(itemView);
                iv=itemView.findViewById(R.id.banner_iv);
                iv.setPadding(20,0,20,0);

            }

            public void bindImage(String imageUrl){
                RequestOptions requestOptions=new RequestOptions().skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(placeholderImage).error(errorImage);
                Glide.with(context).load(imageUrl).apply(requestOptions).into(iv);
            }

            public void bindImage(@DrawableRes int imageUrl){
                RequestOptions requestOptions=new RequestOptions().skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(placeholderImage).error(errorImage);
                Glide.with(context).load(imageUrl).apply(requestOptions).into(iv);
            }
        }
    }
}
