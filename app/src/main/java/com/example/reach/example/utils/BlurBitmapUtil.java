package com.example.reach.example.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/**
 * Created by ZX on 2018/12/6
 * 高斯模糊工具
 */
public class BlurBitmapUtil {
    private final float BlurDegree=0.4f;

    public static Bitmap BlurBitmapUtil(Context context,Bitmap bitmap,float blurDegree) {


       /* Bitmap output = Bitmap.createBitmap(bitmap); // 创建输出图片
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
        */

        Bitmap output=Bitmap.createBitmap(bitmap);
        //创建RenderScript内核对象
        RenderScript renderScript=RenderScript.create(context);
        //创建模糊效果的RenderScript的工具对象
        ScriptIntrinsicBlur intrinsicBlur=ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));

        //由于RenderScript并没有使用VM来分配内存,所以需要使用Allocation类来创建和分配内存空间
        //创建Allocation对象的时候其实内存是空的,需要使用copyTo()将数据填充进去
        Allocation allIn=Allocation.createFromBitmap(renderScript,bitmap);  //开辟输入内存
        Allocation allOut=Allocation.createFromBitmap(renderScript,output); //开辟输出内存

        intrinsicBlur.setRadius(blurDegree);
        intrinsicBlur.setInput(allIn);
        intrinsicBlur.forEach(allIn);
        allOut.copyTo(output);

        renderScript.destroy();
        return output;

    }
}
