package com.junwen.jlibrary;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
*描述:动画类
*作者:卜俊文
*邮箱:344176791@qq.com
*创建时间: 2016/8/11 15:44
*/
public class JAnimationUtils {
	/**
	*描述:抖动动画，左右抖动
	*作者:卜俊文
	*邮箱:344176791@qq.com
	*创建时间: 2016/8/11 15:44
	*/
	public static void shake(Context context, View v) {
		Animation shake = new TranslateAnimation(0, 10, 0, 0);// 移动方向
		shake.setDuration(1000);// 执行总时间
		shake.setInterpolator(new CycleInterpolator(7));// 循环次数
		v.startAnimation(shake);
	}

	/**
	*描述:缩放动画，按下时缩放，抬起时恢复
	*作者:卜俊文
	*邮箱:344176791@qq.com
	*创建时间: 2016/8/11 15:45
	*/
	public static boolean setClickAnim(View v, MotionEvent event,
			View.OnClickListener listener) {
		float start = 1.0f;
		float end = 0.95f;
		Animation scaleAnimation = new ScaleAnimation(start, end, start, end,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		Animation endAnimation = new ScaleAnimation(end, start, end, start,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		scaleAnimation.setDuration(200);
		scaleAnimation.setFillAfter(true);
		endAnimation.setDuration(200);
		endAnimation.setFillAfter(true);
		switch (event.getAction()) {
		// 按下时调用
		case MotionEvent.ACTION_DOWN:
			v.startAnimation(scaleAnimation);
			v.invalidate();
			break;
		// 抬起时调用
		case MotionEvent.ACTION_UP:
			v.startAnimation(endAnimation);
			v.invalidate();
			if (listener != null) {
				listener.onClick(v);
			}
			break;
		// 滑动出去不会调用action_up,调用action_cancel
		case MotionEvent.ACTION_CANCEL:
			v.startAnimation(endAnimation);
			v.invalidate();
			break;
		}
		// 不返回true，Action_up就响应不了
		return true;
	}

}
