package com.example.reach.example.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.reach.example.R;
import com.example.reach.example.base.BaseFragment;
import com.example.reach.example.utils.mLog;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by ZX on 2018/11/26
 */
public class Fragment_Nav3 extends BaseFragment {

    private SwipeRefreshLayout refreshLayout;
    private ImageView iv,iv2;
    private SeekBar seekBar;

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
        iv=findViewById(R.id.fragment3_iv1);
        iv2=findViewById(R.id.fragment_vi2);
        seekBar=findViewById(R.id.fragment_seekBar);
        seekBar.setMax(255);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(false);

            }
        });
        Bitmap res=BitmapFactory.decodeResource(getResources(),R.drawable.beatui);
        iv.setImageBitmap(blur(res,25f));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                iv2.setImageAlpha(255-progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




    }

    private Bitmap blur(Bitmap bitmap, float radius) {
        Bitmap output = Bitmap.createBitmap(bitmap); // 创建输出图片
        RenderScript rs = RenderScript.create(getActivity()); // 构建一个RenderScript对象
        ScriptIntrinsicBlur gaussianBlue = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs)); //
        // 创建高斯模糊脚本
        Allocation allIn = Allocation.createFromBitmap(rs, bitmap); // 开辟输入内存
        Allocation allOut = Allocation.createFromBitmap(rs, output); // 开辟输出内存
        gaussianBlue.setRadius(radius); // 设置模糊半径，范围0f<radius<=25f
        gaussianBlue.setInput(allIn); // 设置输入内存
        gaussianBlue.forEach(allOut); // 模糊编码，并将内存填入输出内存
        allOut.copyTo(output); // 将输出内存编码为Bitmap，图片大小必须注意
        rs.destroy(); // 关闭RenderScript对象，API>=23则使用rs.releaseAllContexts()
        return output;
    }


    private Class<?> analysisClassInfo(Object object){
        Type genType=object.getClass().getGenericSuperclass();
        Type[] params=((ParameterizedType)genType).getActualTypeArguments();
        for (Type types:params) {
            mLog.e("Type","-->"+types);
        }
        return (Class<?>)params[0];
    }

    @Override
    protected void lazyLoadData() {

    }
}
