package com.junwen.jlibrary;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述:手机信息工具类
 * 作者:卜俊文
 * 邮箱:344176791@qq.com
 * 创建时间: 2016/8/11 15:59
 */
public class JPhoneUtils {

    /**
     * 描述:获取当前的手机号
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:59
     */
    public String getPhoneNumberForself(Context context) {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getLine1Number();
    }

    private static Context context;
    private static JPhoneUtils util;

    public static JPhoneUtils getInstance(Context activity) {
        if (util == null) {
            util = new JPhoneUtils();
            context = activity.getApplicationContext();
        }
        return util;

    }

    private JPhoneUtils() {
        super();
    }

    /**
     * 描述:生产商家
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:59
     */
    public String getManufacturer() {
        return android.os.Build.MANUFACTURER;
    }

    /**
     * 描述:获得固件版本
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:59
     */
    public String getRelease() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 描述:获得手机型号
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:59
     */
    public String getModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 描述:获得手机品牌
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:59
     */
    public String getBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 描述:获取手机运营商
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:59
     */
    public String getSimOperatorName() {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);

        return tm.getSimOperatorName();
    }

    /**
     * 描述:得到本机手机号码,未安装SIM卡或者SIM卡中未写入手机号，都会获取不到
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:59
     */
    public String getThisPhoneNumber() {
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String number = tm.getLine1Number();

        return number;
    }

    /**
     * 描述:是否是电话号码
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:59
     */
    public boolean isPhoneNumber(String phonenumber) {
        Pattern pa = Pattern.compile("^[1][3,4,5,8,7][0-9]{9}$");
        Matcher ma = pa.matcher(phonenumber);
        return ma.matches();
    }

    /**
     * 描述:打电话
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:59
     */
    public void doPhone(String phone) {
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
                + phone));
        context.startActivity(phoneIntent);
    }

    /**
     * 描述:发短信
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:59
     */
    public void doSMS(String phone, String content) {
        Uri uri = null;
        if (!TextUtils.isEmpty(phone))
            uri = Uri.parse("smsto:" + phone);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", content);
        context.startActivity(intent);
    }

    /**
     * 描述: 得到屏幕信息 getScreenDisplayMetrics().heightPixels 屏幕高
     * getScreenDisplayMetrics().widthPixels 屏幕宽
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:00
     */
    public DisplayMetrics getScreenDisplayMetrics() {
        WindowManager manager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display display = manager.getDefaultDisplay();
        display.getMetrics(displayMetrics);

        return displayMetrics;

    }

    /**
     * 描述:屏幕分辨率
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:00
     */
    public float getDip() {

        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1,
                context.getResources().getDisplayMetrics());
    }

    /**
     * 描述:安装apk
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:00
     */
    public void instance(File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 描述:是否有外存卡
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:01
     */
    public boolean isExistExternalStore() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 描述: 开始震动
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:03
     */
    @SuppressLint("NewApi")
    public synchronized void doVibrate(Context context, int repeat,
                                       long... pattern) {

        if (pattern == null) {
            pattern = new long[]{1000, 1000, 1000};
        }
        Vibrator mVibrator = (Vibrator) context
                .getSystemService(Context.VIBRATOR_SERVICE);
        if (mVibrator.hasVibrator()) {
            mVibrator.vibrate(pattern, repeat);
        }
    }

    /**
     * final Activity activity  ：调用该方法的Activity实例
     * long milliseconds ：震动的时长，单位是毫秒
     * long[] pattern  ：自定义震动模式 。数组中数字的含义依次是[静止时长，震动时长，静止时长，震动时长。。。]时长的单位是毫秒
     * boolean isRepeat ： 是否反复震动，如果是true，反复震动，如果是false，只震动一次
     */

    public static void Vibrate(final Activity activity, long milliseconds) {
        Vibrator vib = (Vibrator) activity.getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(milliseconds);
    }

    public static void Vibrate(final Activity activity, long[] pattern, boolean isRepeat) {
        Vibrator vib = (Vibrator) activity.getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(pattern, isRepeat ? 1 : -1);
    }
}
