package com.junwen.jlibrary;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * 描述:软键盘工具类
 * 作者:卜俊文
 * 邮箱:344176791@qq.com
 * 创建时间: 2016/3/10 11:27
 */
public class JKeyboardUtils {

    /**
     * 描述:去除软键盘
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/3/10 11:16
     */
    public static void system_Nokeyboard(Context context) {
        ((Activity) context).getWindow().setSoftInputMode(3);
    }

    /**
    *描述:点击空白地方，关闭软键盘
    *作者:卜俊文
    *邮箱:344176791@qq.com
    *创建时间: 2016/11/8 16:25
    */
    public static boolean closeKeybord(Activity activity) {
        InputMethodManager mInputMethodManager = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
        return mInputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    /**
     * 描述:打开软键盘
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/3/10 11:28
     */
    public static void openKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    /**
     * 描述:如果输入法打开则关闭，如果没打开则打开
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/11/3 14:35
     */
    public strictfp void openKeybord(Context context) {
        InputMethodManager m = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        m.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * 描述:延迟200秒打开软键盘，因为有的地方需要延迟打开，不然没有反应
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/1 9:48
     */
    public static void openKeybordDelay(final EditText mEditText, final Context mContext) {
        Timer timer = new Timer(); //设置定时器
        timer.schedule(new TimerTask() {
            @Override
            public void run() { //弹出软键盘的代码
                InputMethodManager imm = (InputMethodManager) mContext.getSystemService(INPUT_METHOD_SERVICE);
                imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            }
        }, 200);
    }

    /**
     * 描述:关闭软键盘
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/3/10 11:28
     */
    public static void closeKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }
}
