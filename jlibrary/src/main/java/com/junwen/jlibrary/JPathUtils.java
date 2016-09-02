package com.junwen.jlibrary;

import android.os.Environment;

/**
 * 描述:路径工具类
 * 作者:卜俊文
 * 邮箱:344176791@qq.com
 * 创建时间: 2016/3/10 11:20
 */
public class JPathUtils {


    /**
     * 描述:获取SD卡的路径
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/3/10 11:20
     */
    public static String getSdcardDirectory() {
        return Environment.getExternalStorageDirectory().getAbsoluteFile().toString();
    }

}
