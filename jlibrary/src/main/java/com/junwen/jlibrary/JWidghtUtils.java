package com.junwen.jlibrary;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.widget.TextView;

/**
*描述:View工具类
*作者:卜俊文
*邮箱:344176791@qq.com
*创建时间: 2016/8/11 16:27
*/
public class JWidghtUtils {
    /**
     * 描述:在TextView中插入图片
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:17
     */
    public void textViewInImag(final Context context, TextView tv, int rid,
                               final int size) {

        String imgStr = "<img src=\"" + rid + "\"/>";
        Html.ImageGetter imageGetter = new Html.ImageGetter() {
            public Drawable getDrawable(String arg0) {

                int id = Integer.parseInt(arg0);
                Drawable draw = context.getResources().getDrawable(id);
                draw.setBounds(0, 0, size, size);
                return draw;
            }
        };
        tv.append(Html.fromHtml(imgStr, imageGetter, null));
    }
}
