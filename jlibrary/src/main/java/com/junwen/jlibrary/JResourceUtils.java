package com.junwen.jlibrary;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

/**
 * 描述：资源操作类
 * 作者：卜俊文
 * 创建：2016/8/19 17:24
 * 邮箱：344176791@qq.com
 */
public class JResourceUtils {

    /**
     * 描述:从assets 文件夹中读取图片
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 17:26
     */
    public static Drawable loadImageFromAsserts(final Context ctx, String fileName) {
        try {
            InputStream is = ctx.getResources().getAssets().open(fileName);
            return Drawable.createFromStream(is, null);
        } catch (IOException e) {
            if (e != null) {
                e.printStackTrace();
            }
        } catch (OutOfMemoryError e) {
            if (e != null) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            if (e != null) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * 描述:获取 layout 布局文件
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:54
     */
    public static int getLayoutId(Context context, String resName) {
        return context.getResources().getIdentifier(resName, "layout",
                context.getPackageName());
    }

    /**
     * 描述:获取 string 值
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:54
     */
    public static int getStringId(Context context, String resName) {
        return context.getResources().getIdentifier(resName, "string",
                context.getPackageName());
    }

    /**
     * 描述:获取 drawable
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:54
     */
    public static int getDrawableId(Context context, String resName) {
        return context.getResources().getIdentifier(resName,
                "drawable", context.getPackageName());
    }

    /**
     * 描述: 获取 mipmap
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:54
     */
    public static int getMipmapId(Context context, String resName) {
        return context.getResources().getIdentifier(resName,
                "mipmap", context.getPackageName());
    }


    /**
     * 描述:获取 style
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:54
     */
    public static int getStyleId(Context context, String resName) {
        return context.getResources().getIdentifier(resName, "style",
                context.getPackageName());
    }

    /**
     * 描述:获取 styleable
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:55
     */
    public static Object getStyleableId(Context context, String resName) {
        return context.getResources().getIdentifier(resName, "styleable",
                context.getPackageName());
    }


    /**
     * 描述:获取 anim
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:55
     */
    public static int getAnimId(Context context, String resName) {
        return context.getResources().getIdentifier(resName, "anim",
                context.getPackageName());
    }

    /**
     * 描述:获取 id
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/2 16:55
     */
    public static int getId(Context context, String resName) {
        return context.getResources().getIdentifier(resName, "id",
                context.getPackageName());
    }


    /**
     *描述:获取color
     *作者:卜俊文
     *邮箱:344176791@qq.com
     *创建时间: 2016/9/2 16:55
     */
    public static int getColorId(Context context, String resName) {
        return context.getResources().getIdentifier(resName, "color",
                context.getPackageName());
    }
}
