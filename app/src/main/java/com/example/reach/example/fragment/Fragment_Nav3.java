package com.example.reach.example.fragment;

import android.support.v4.widget.SwipeRefreshLayout;

import com.example.reach.example.R;
import com.example.reach.example.base.BaseFragment;

/**
 * Created by ZX on 2018/11/26
 */
public class Fragment_Nav3 extends BaseFragment {

    private SwipeRefreshLayout refreshLayout;

    @Override
    protected int setFragmentView() {
        return R.layout.fragment_nav3;
    }

    @Override
    protected void initView() {
        /*Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.banner1);
        iv=findViewById(R.id.fragment3_iv);
        iv2=findViewById(R.id.fragment_iv2);
        iv.setImageBitmap(bitmap);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@NonNull Palette palette) {
                Palette.Swatch swatch=palette.getDarkVibrantSwatch();
                int color=swatch.getRgb();
                iv2.setBackgroundColor(color);
            }
        });
        int width=bitmap.getWidth();
        int height=bitmap.getHeight();*/
        refreshLayout=findViewById(R.id.fragment3_refresh);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);

            }
        });


    }

    @Override
    protected void lazyLoadData() {

    }
}
