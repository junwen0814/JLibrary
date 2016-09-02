package com.junwen.jlibrary;

import android.content.Context;
import android.text.TextPaint;
import android.util.TypedValue;

/**
 * 描述:常用单位转换的辅助类
 * 作者:卜俊文
 * 邮箱:344176791@qq.com
 * 创建时间: 2016/3/10 11:04
 */
public class JDensityUtils {
    private JDensityUtils() {
        /* cannot be instantiated */
    }

    /**
     * 描述:dp转px
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/3/10 11:02
     */
    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

    /**
     * 描述:sp转px
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/3/10 11:03
     */
    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

    /**
     * 描述:px转dp
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/3/10 11:03
     */
    public static float px2dp(Context context, float pxVal) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * 描述:px转sp
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/3/10 11:03
     */
    public static float px2sp(Context context, float pxVal) {
        return (pxVal / context.getResources().getDisplayMetrics().scaledDensity);
    }

    /**
     * 描述:计算字宽
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:58
     */
    public static float GetTextWidth(String text, float Size) {
        TextPaint FontPaint = new TextPaint();
        FontPaint.setTextSize(Size);
        return FontPaint.measureText(text);
    }
}
