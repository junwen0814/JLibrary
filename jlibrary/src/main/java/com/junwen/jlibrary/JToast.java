package com.junwen.jlibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * 描述:Toast统一管理类
 * 作者:卜俊文
 * 邮箱:344176791@qq.com
 * 创建时间: 2016/8/11 16:16
 */
public class JToast {

    private static Context context;

    private JToast() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 描述:初始化Toast
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:16
     */
    public static void init(Context context) {
        JToast.context = context;
    }

    public static boolean isShow = true;

    /**
     * 描述:短时间显示Toast
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:16
     */
    public static void showShort(CharSequence message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 描述:短时间显示Toast
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:16
     */
    public static void showShort(int message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 描述:长时间显示Toast
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:16
     */
    public static void showLong(CharSequence message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /**
     * 描述:长时间显示Toast
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:16
     */
    public static void showLong(int message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /**
     * 描述:自定义显示Toast时间
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:16
     */
    public static void show(CharSequence message, int duration) {
        if (isShow)
            Toast.makeText(context, message, duration).show();
    }

    /**
     * 描述:自定义显示Toast时间
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:16
     */
    public static void show(int message, int duration) {
        if (isShow)
            Toast.makeText(context, message, duration).show();
    }

}