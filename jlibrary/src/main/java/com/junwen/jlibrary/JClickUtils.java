package com.junwen.jlibrary;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by junwen on 2016/12/13.
 */

public class JClickUtils {

    /**
     * 描述:模拟点击事件
     * view ： 需要点击的控件
     * x : 不清楚,随便填写
     * y : 不清楚，随便填写
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/12/13 11:10
     */
    public static void setSimulateClick(View view, float x, float y) {
        long downTime = SystemClock.uptimeMillis();
        final MotionEvent downEvent = MotionEvent.obtain(downTime, downTime,
                MotionEvent.ACTION_DOWN, x, y, 0);
        downTime += 1000;
        final MotionEvent upEvent = MotionEvent.obtain(downTime, downTime,
                MotionEvent.ACTION_UP, x, y, 0);
        view.onTouchEvent(downEvent);
        view.onTouchEvent(upEvent);
        downEvent.recycle();
        upEvent.recycle();
    }
}
