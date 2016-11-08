package com.junwen.jlibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;

/**
 * 描述：
 * 作者：卜俊文
 * 创建：2016/11/8 17:04
 * 邮箱：344176791@qq.com
 */
public class JDrawableUtils {

    GradientDrawable gradientDrawableNormal; //正常状态

    GradientDrawable gradientDrawablePress; //按下状态

    private Context context;

    private StateListDrawable stateListDrawable; //最后drawable


    public JDrawableUtils(Context context) {
        this.context = context;
        stateListDrawable = new StateListDrawable();
        gradientDrawableNormal = new GradientDrawable();
        gradientDrawablePress = new GradientDrawable();
    }

    /**
     * 描述:绑定控件，设置背景
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 18:47
     */
    public void bindView(View view) {
        gradientDrawableNormal.setShape(GradientDrawable.RECTANGLE);
        gradientDrawableNormal.setShape(GradientDrawable.RECTANGLE);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawablePress);
        stateListDrawable.addState(new int[]{}, gradientDrawableNormal);
        view.setBackgroundDrawable(stateListDrawable);
    }

    /**
     * 描述:设置所有角度的弧度
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 19:27
     */
    public JDrawableUtils setRadius(float radius) {
        cornerRadiusNormalAndPress(radius, radius, radius, radius);
        return this;
    }

    /**
     * 描述:设置指定角度的弧度
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 19:27
     */
    public JDrawableUtils setRadius(float topleft, float topright, float bottomleft, float bottomright) {
        cornerRadiusNormalAndPress(topleft, topright, bottomleft, bottomright);
        return this;
    }

    /**
     * 描述:设置正常和按下的弧度
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 19:23
     */
    private void cornerRadiusNormalAndPress(float topleft, float topright, float bottomleft, float bottomright) {
        cornerRadius(gradientDrawableNormal, topleft, topright, bottomleft, bottomright);
        cornerRadius(gradientDrawablePress, topleft, topright, bottomleft, bottomright);
    }

    /**
     * 描述:设置弧度
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 19:27
     */
    private void cornerRadius(GradientDrawable gradientDrawable, float topLeftRadius, float topRightRadius, float bottomRightRadius, float bottomLeftRadius) {
        gradientDrawable.setCornerRadii(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius});
    }

    /**
     * 描述:设置背景颜色
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 19:32
     */
    public JDrawableUtils setColor(String normalColor, String pressNormal) {
        if (!TextUtils.isEmpty(normalColor) && !TextUtils.isEmpty(pressNormal)) {
            cornerColor(Color.parseColor(normalColor), Color.parseColor(pressNormal));
        }
        return this;
    }

    /**
     * 描述:设置背景颜色
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 19:32
     */
    public JDrawableUtils setColor(int normalColor, int pressNormal) {
        cornerColor(normalColor, pressNormal);
        return this;
    }

    /**
     * 描述:设置背景颜色
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 19:32
     */
    public JDrawableUtils setColor(int color) {
        cornerColor(color);
        return this;
    }

    /**
     * 描述:设置背景颜色
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 19:32
     */
    public JDrawableUtils setColor(String color) {
        cornerColor(Color.parseColor(color));
        return this;
    }

    /**
     * 描述:设置背景颜色
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 19:32
     */
    private void cornerColor(int normalColor, int pressNormal) {
        gradientDrawableNormal.setColor(normalColor);
        gradientDrawablePress.setColor(pressNormal);
    }

    /**
     * 描述:设置默认颜色
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 20:34
     */
    private void cornerColor(int normalColor) {
        gradientDrawableNormal.setColor(normalColor);
        gradientDrawablePress.setColor(normalColor);
    }

    /**
     * 描述:设置边框和颜色
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 20:16
     */
    public JDrawableUtils setStroke(String color, int width) {
        cornerStroke(Color.parseColor(color), width);
        return this;
    }

    /**
     * 描述:设置边框和颜色
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 20:16
     */
    public JDrawableUtils setStroke(int color, int width) {
        cornerStroke(color, width);
        return this;
    }

    /**
     * 描述:设置边框和颜色
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/8 20:23
     */
    private void cornerStroke(int color, int width) {
        gradientDrawableNormal.setStroke(width, color);
        gradientDrawablePress.setStroke(width, color);
    }

}
