package com.thirdgoddess.tnt.view;

import android.content.Context;

/**
 * dip和px值相互转换工具类
 * Dip and px value conversion tools
 *
 * @author ThirdGoddess
 * @email ofmyhub@gmail.cogit reset HEAD + 文件名m
 * @Github https://github.com/ThirdGoddess
 * @date :2019-11-22 18:43
 */
public class DipPx {

    /**
     * 将dip转换为px
     * Convert dip to px
     *
     * @param context 上下文
     * @param dpValue 要转的dp值
     * @return int:px
     */
    public static int dipGoPx(Context context, float dpValue) {
        final float density = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5f);
    }

    /**
     * 将px转换为dip
     * Convert px to dip
     *
     * @param context 上下文
     * @param pxValue 要转的px值
     * @return int:dip
     */
    public static int pxGoDip(Context context, float pxValue) {
        final float density = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / density + 0.5f);
    }
}
