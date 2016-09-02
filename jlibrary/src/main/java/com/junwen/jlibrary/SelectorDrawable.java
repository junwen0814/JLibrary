package com.junwen.jlibrary;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;

/**
 * 作者：Select选择器
 * <p/>
 * 示例：
 * new SelectorDrawable(this).lrCornerRadii(16, 32, 16, 32).backgroundColor("#E3E3E3","#FF5722").bindView(findViewById(R.id.tv_1));
 * new SelectorDrawable(this).btCornerRadii(16, 32,16, 32).backgroundColor("#E3E3E3","#B3B3B3").bindView(findViewById(R.id.tv_2));
 * new SelectorDrawable(this).cornerRadii(16, 16).backgroundColor("#E3E3E3","#009688").bindView(findViewById(R.id.tv_3));
 * new SelectorDrawable(this).cornerRadii(32, 32).backgroundColor("#E3E3E3","#B3B3B3").bindView(findViewById(R.id.tv_4));
 * 时间：2016年08月08日    22:26
 * 博客：http://www.jianshu.com/users/c3c4ea133871/subscriptions
 */
public class SelectorDrawable extends StateListDrawable {
    private Context context;
    private StateListDrawable stateListDrawable;
    private GradientDrawable normalGradientDrawable;
    private GradientDrawable selectedGradientDrawable;
    private int normalColor;
    private int selectedColor;
    private float normalTopLeftRadius;
    private float normalTopRightRadius;
    private float normalBottomLeftRadius;
    private float normalBottomRightRadius;
    private float selectedTopLeftRadius;
    private float selectedTopRightRadius;
    private float selectedBottomLeftRadius;
    private float selectedBottomRightRadius;
    /**
     * GradientDrawable.RECTANGLE
     */
    private int shape;
    private int startColor;
    private int endColor;
    private GradientDrawable.Orientation orientation;

    public SelectorDrawable(Context context) {
        this(context, GradientDrawable.RECTANGLE);
        initHelper();
    }

    /**
     * @param shape GradientDrawable.RECTANGLE
     */
    public SelectorDrawable(Context context, int shape) {
        this.context = context;
        this.shape = shape;
        initHelper();
    }

    public SelectorDrawable(Context context, boolean selected, GradientDrawable.Orientation orientation, int startColor, int endColor) {
        this.context = context;
        this.orientation = orientation;
        this.startColor = startColor;
        this.endColor = endColor;
        initHelperWithColor(selected);
    }

    public SelectorDrawable(Context context, GradientDrawable.Orientation orientation, int normalStartColor, int normalEndColor, int selectedStartColor, int selectedEndColor) {
        this.context = context;
        this.orientation = orientation;
        this.startColor = startColor;
        this.endColor = endColor;
        initHelperWithColor(false);
        initHelperWithColor(true);
    }

    private void initHelperWithColor(boolean selected) {
        stateListDrawable = (stateListDrawable == null) ? new StateListDrawable() : stateListDrawable;
        final int colors[] = {this.startColor, this.endColor};
        final GradientDrawable.Orientation validOrientation = this.orientation == null ? GradientDrawable.Orientation.TOP_BOTTOM : this.orientation;
        if (selected) {
            selectedGradientDrawable = (selectedGradientDrawable == null) ? new GradientDrawable(validOrientation, colors) : selectedGradientDrawable;
        } else {
            normalGradientDrawable = (normalGradientDrawable == null) ? new GradientDrawable(validOrientation, colors) : normalGradientDrawable;
        }
    }

    private void initHelper() {
        normalGradientDrawable = new GradientDrawable();
        selectedGradientDrawable = new GradientDrawable();
        stateListDrawable = new StateListDrawable();
        if (shape != -1) {
            normalGradientDrawable.setShape(shape);
            selectedGradientDrawable.setShape(shape);
        }
    }

    public SelectorDrawable backgroundColor(String normalBackgroundColor, String selectedBackgroundColor) {
        normalBackgroundColor(Color.parseColor(normalBackgroundColor));
        selectedBackgroundColor(Color.parseColor(selectedBackgroundColor));
        return this;
    }

    public SelectorDrawable backgroundColor(int normalBackgroundColor, int selectedBackgroundColor) {
        normalBackgroundColor(normalBackgroundColor);
        selectedBackgroundColor(selectedBackgroundColor);
        return this;
    }

    public SelectorDrawable normalBackgroundColor(String color) {
        this.normalGradientDrawable.setColor(Color.parseColor(color));
        return this;
    }

    public SelectorDrawable normalBackgroundColor(int color) {
        this.normalGradientDrawable.setColor(color);
        this.normalColor = color;
        return this;
    }

    public SelectorDrawable selectedBackgroundColor(int color) {
        this.selectedGradientDrawable.setColor(color);
        this.selectedColor = color;
        return this;
    }

    public SelectorDrawable stroke(int normalWidth, int normalColor, int selectedWidth, int selectedColor) {
        normalStroke(normalWidth, normalColor);
        selectedStroke(selectedWidth, selectedColor);
        return this;
    }

    public SelectorDrawable normalStroke(int width, int color) {
        normalGradientDrawable.setStroke((int) dp2Px(width), color);
        return this;
    }

    public SelectorDrawable selectedStroke(int width, int color) {
        selectedGradientDrawable.setStroke((int) dp2Px(width), color);
        return this;
    }

    public SelectorDrawable cornerRadii(float normalRadii[], float selectedRadii[]) {
        normalCornerRadii(normalRadii);
        selectedCornerRadii(selectedRadii);
        return this;
    }

    public SelectorDrawable normalCornerRadii(float radii[]) {
        normalGradientDrawable.setCornerRadii(radii);
        return this;
    }

    public SelectorDrawable selectedCornerRadii(float radii[]) {
        selectedGradientDrawable.setCornerRadii(radii);
        return this;
    }

    public SelectorDrawable cornerRadii(float normalRadius, float selectedRadius) {
        normalCornerRadii(normalRadius);
        selectedCornerRadii(selectedRadius);
        return this;
    }

    public SelectorDrawable normalCornerRadii(float radius) {
        normalCornerRadii(radius, radius, radius, radius);
        return this;
    }

    public SelectorDrawable selectedCornerRadii(float radius) {
        selectedCornerRadii(radius, radius, radius, radius);
        return this;
    }

    public SelectorDrawable lrCornerRadii(float normalRadius, float selectedRadius) {
        normalLRCornerRadii(normalRadius);
        selectedLRCornerRadii(selectedRadius);
        return this;
    }

    public SelectorDrawable lrCornerRadii(float normalLeftRadius, float normalRightRadius, float selectedLeftRadius, float selectedRightRadius) {
        normalLRCornerRadii(normalLeftRadius, normalRightRadius);
        selectedLRCornerRadii(selectedLeftRadius, selectedRightRadius);
        return this;
    }

    /**
     * @param radius 左半   圆角化   单位  dp
     */
    public SelectorDrawable normalLRCornerRadii(float radius) {
        return normalCornerRadii(radius, radius, radius, radius);
    }

    /**
     * @param radius 左半   圆角化   单位  dp
     */
    public SelectorDrawable selectedLRCornerRadii(float radius) {
        return selectedCornerRadii(radius, radius, radius, radius);
    }

    /**
     * @param leftRadius  左半   圆角化   单位  dp
     * @param rightRadius 右半   圆角化   单位  dp
     */
    public SelectorDrawable normalLRCornerRadii(float leftRadius, float rightRadius) {
        return normalCornerRadii(leftRadius, rightRadius, rightRadius, leftRadius);
    }

    /**
     * @param leftRadius  左半   圆角化   单位  dp
     * @param rightRadius 右半   圆角化   单位  dp
     */
    public SelectorDrawable selectedLRCornerRadii(float leftRadius, float rightRadius) {
        return selectedCornerRadii(leftRadius, rightRadius, rightRadius, leftRadius);
    }

    /**
     * @param radius 圆角化  半径  单位  dp
     */
    public SelectorDrawable btCornerRadii(float radius) {
        normalBTCornerRadii(radius);
        selectedBTCornerRadii(radius);
        return this;
    }

    /**
     * @param normalRadius   左上角 - 右上角 :   圆角化
     * @param selectedRadius 左上角 - 右下角 :   圆角化
     */
    public SelectorDrawable btCornerRadii(float normalRadius, float selectedRadius) {
        normalBTCornerRadii(normalRadius, normalRadius);
        selectedBTCornerRadii(selectedRadius, selectedRadius);
        return this;
    }

    /**
     * @param normalBottomRadius   下半   圆角化  半径  单位  dp
     * @param selectedBottomRadius 下半   圆角化  半径  单位  dp
     * @param normalTopRadius      上半   圆角化  半径  单位  dp
     * @param selectedTopRadius    上半   圆角化  半径  单位  dp
     */
    public SelectorDrawable btCornerRadii(float normalBottomRadius, float normalTopRadius, float selectedBottomRadius, float selectedTopRadius) {
        normalBTCornerRadii(normalBottomRadius, normalTopRadius);
        selectedBTCornerRadii(selectedBottomRadius, selectedTopRadius);
        return this;
    }

    /**
     * @param radius 圆角化  半径  单位  dp
     */
    public SelectorDrawable normalBTCornerRadii(float radius) {
        return normalCornerRadii(radius, radius, radius, radius);
    }

    /**
     * @param radius 圆角化  半径  单位  dp
     */
    public SelectorDrawable selectedBTCornerRadii(float radius) {
        return selectedCornerRadii(radius, radius, radius, radius);
    }

    /**
     * @param bottomRadius 下半   圆角化  半径  单位  dp
     * @param topRadius    上半   圆角化  半径  单位  dp
     */
    public SelectorDrawable normalBTCornerRadii(float bottomRadius, float topRadius) {
        return normalCornerRadii(topRadius, topRadius, bottomRadius, bottomRadius);
    }

    /**
     * @param bottomRadius 下半   圆角化  半径  单位  dp
     * @param topRadius    上半   圆角化  半径  单位  dp
     */
    public SelectorDrawable selectedBTCornerRadii(float bottomRadius, float topRadius) {
        return selectedCornerRadii(topRadius, topRadius, bottomRadius, bottomRadius);
    }

    /**
     * 圆角化  单位  dp
     *
     * @param topLeftRadius     左上角的 半径
     * @param topRightRadius    右上角的 半径
     * @param bottomLeftRadius  左下角的 半径
     * @param bottomRightRadius 右下角的 半径
     */
    public SelectorDrawable cornerRadii(float topLeftRadius, float topRightRadius, float bottomRightRadius, float bottomLeftRadius) {
        normalCornerRadii(topLeftRadius, topRightRadius, bottomRightRadius, bottomLeftRadius);
        selectedCornerRadii(topLeftRadius, topRightRadius, bottomRightRadius, bottomLeftRadius);
        return this;
    }

    /**
     * 圆角化  单位  dp
     *
     * @param topLeftRadius     左上角的 半径
     * @param topRightRadius    右上角的 半径
     * @param bottomLeftRadius  左下角的 半径
     * @param bottomRightRadius 右下角的 半径
     */
    public SelectorDrawable normalCornerRadii(float topLeftRadius, float topRightRadius, float bottomRightRadius, float bottomLeftRadius) {
        cornerRadii(normalGradientDrawable, topLeftRadius, topRightRadius, bottomRightRadius, bottomLeftRadius);
        this.normalTopLeftRadius = topLeftRadius;
        this.normalTopRightRadius = topRightRadius;
        this.normalBottomRightRadius = bottomRightRadius;
        this.normalBottomLeftRadius = bottomLeftRadius;
        return this;
    }

    /**
     * @param topLeftRadius     左上角的 半径
     * @param topRightRadius    右上角的 半径
     * @param bottomLeftRadius  左下角的 半径
     * @param bottomRightRadius 右下角的 半径
     */
    public SelectorDrawable selectedCornerRadii(float topLeftRadius, float topRightRadius, float bottomRightRadius, float bottomLeftRadius) {
        cornerRadii(selectedGradientDrawable, topLeftRadius, topRightRadius, bottomRightRadius, bottomLeftRadius);
        this.selectedTopLeftRadius = topLeftRadius;
        this.selectedTopRightRadius = topRightRadius;
        this.selectedBottomRightRadius = bottomRightRadius;
        this.selectedBottomLeftRadius = bottomLeftRadius;
        return this;
    }

    /**
     * 圆角化  单位  dp
     *
     * @param topLeftRadius     左上角的 半径
     * @param topRightRadius    右上角的 半径
     * @param bottomLeftRadius  左下角的 半径
     * @param bottomRightRadius 右下角的 半径
     */
    public void cornerRadii(GradientDrawable gradientDrawable, float topLeftRadius, float topRightRadius, float bottomRightRadius, float bottomLeftRadius) {
        topLeftRadius = dp2Px(topLeftRadius);
        topRightRadius = dp2Px(topRightRadius);
        bottomLeftRadius = dp2Px(bottomLeftRadius);
        bottomRightRadius = dp2Px(bottomRightRadius);
        gradientDrawable.setCornerRadii(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius});
    }

    @SuppressWarnings("deprecation")
    public void bindView(View view) {
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, selectedGradientDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, selectedGradientDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_checkable}, selectedGradientDrawable);
        stateListDrawable.addState(new int[]{}, normalGradientDrawable);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            RippleDrawable rippleDrawable = createRippleDrawable(normalColor, selectedColor);
            view.setBackground(rippleDrawable);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(stateListDrawable);
        } else {
            view.setBackgroundDrawable(stateListDrawable);
        }
        view.setClickable(true);
    }

    private RippleDrawable createRippleDrawable(int normalColor, int rippleColor) {
        RippleDrawable rippleDrawable = null;
        GradientDrawable normalGradientDrawable = new GradientDrawable();
        normalGradientDrawable.setColor(normalColor);
        cornerRadii(normalGradientDrawable, normalTopLeftRadius, normalTopRightRadius, normalBottomRightRadius, normalBottomLeftRadius);
        GradientDrawable maskDrawable = new GradientDrawable();
        maskDrawable.setColor(Color.parseColor("#FF5722"));
        maskDrawable.setStroke(0, Color.parseColor("#00000000"));
        cornerRadii(maskDrawable, selectedTopLeftRadius, selectedTopRightRadius, selectedBottomRightRadius, selectedBottomLeftRadius);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            rippleDrawable = new RippleDrawable(ColorStateList.valueOf(rippleColor), normalGradientDrawable, maskDrawable);
        }
        return rippleDrawable;
    }

    public void bindView(View view, int normalColor, int selectedColor) {
        bindView(view, normalColor, selectedColor, 0);
        bindView(view);
    }

    public void bindView(View view, int normalColor, int selectedColor, float radius) {
        normalBackgroundColor(normalColor);
        selectedBackgroundColor(selectedColor);
        normalCornerRadii(radius);
        selectedCornerRadii(radius);
        bindView(view);
    }

    public void bindView(View view, String normalColor, String selectedColor) {
        this.normalColor = Color.parseColor(normalColor);
        this.selectedColor = Color.parseColor(selectedColor);
        bindView(view, normalColor, selectedColor, 0);
    }

    public void bindView(View view, String normalColor, String selectedColor, float radius) {
        normalBackgroundColor(Color.parseColor(normalColor));
        selectedBackgroundColor(Color.parseColor(selectedColor));
        normalCornerRadii(radius);
        selectedCornerRadii(radius);
        bindView(view);
    }

    public void bindView(ImageView imageView, int normalResId, int selectedResId) {
        Bitmap bitmapSelected = BitmapFactory.decodeResource(context.getResources(), selectedResId);
        BitmapDrawable drawableSelected = new BitmapDrawable(context.getResources(), bitmapSelected);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, drawableSelected);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, drawableSelected);
        stateListDrawable.addState(new int[]{android.R.attr.state_checkable}, drawableSelected);
        Bitmap bitmapNormal = BitmapFactory.decodeResource(context.getResources(), normalResId);
        BitmapDrawable drawableNormal = new BitmapDrawable(context.getResources(), bitmapNormal);
        stateListDrawable.addState(new int[]{}, drawableNormal);
        imageView.setImageDrawable(stateListDrawable);
    }

    public Drawable builder() {
        if (selectedGradientDrawable != null) {
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, selectedGradientDrawable);
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, selectedGradientDrawable);
            stateListDrawable.addState(new int[]{android.R.attr.state_checkable}, selectedGradientDrawable);
        }
        if (normalGradientDrawable != null) {
            stateListDrawable.addState(new int[]{}, normalGradientDrawable);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            RippleDrawable rippleDrawable = createRippleDrawable(normalColor, selectedColor);
            return rippleDrawable;
        } else {
            return stateListDrawable;
        }
    }

    /**
     * 数据转换: dp---->px
     */
    private float dp2Px(float dp) {
        if (context == null) {
            return -1;
        }
        return dp * context.getResources().getDisplayMetrics().density;
    }
}