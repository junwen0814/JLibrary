package com.junwen.jlibrary;

/**
 * 描述:后缀判断类型
 * 作者:卜俊文
 * 邮箱:344176791@qq.com
 * 创建时间: 2016/9/1 9:53
 */
public class JExtUtils {

    /**
     * 描述:判断是否是视频
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/1 9:55
     */
    public static boolean isVideo(String filePath) {
        String ext = filePath.toLowerCase();
        return ext.endsWith(".mp4") || ext.endsWith(".avi") || ext.endsWith(".wmv") || ext.endsWith(".rmvb") || ext.endsWith(".mpg") || ext.endsWith(".mpeg") || ext.endsWith(".3gp");
    }

    /**
     * 描述:判断是否是图片
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/1 9:56
     */
    public static boolean isImage(String filePath) {
        String ext = filePath.toLowerCase();
        return ext.endsWith(".jpg") || ext.endsWith(".jpeg") || ext.endsWith(".png") || ext.endsWith(".gif") || ext.endsWith(".bmp");
    }

    /**
     * 描述:判断是否是音频
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/1 9:56
     */
    public static boolean isAudio(String filePath) {
        String ext = filePath.toLowerCase();
        return ext.endsWith(".mp3") || ext.endsWith(".wav") || ext.endsWith(".wma") || ext.endsWith(".amr") || ext.endsWith(".ogg") || ext.endsWith(".m4a");
    }

    /**
     * 描述:判断是否是PPT
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/1 9:56
     */
    public static boolean isPpt(String filePath) {
        String ext = filePath.toLowerCase();
        return ext.endsWith(".ppt") || ext.endsWith(".pptx");
    }

    /**
     * 描述:判断是否是word
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/1 9:56
     */
    public static boolean isWord(String filePath) {
        String ext = filePath.toLowerCase();
        return ext.endsWith(".doc") || ext.endsWith(".docx");
    }

    /**
     * 描述:判断是否是表格
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/9/1 9:56
     */
    public static boolean isExcel(String filePath) {
        String ext = filePath.toLowerCase();
        return ext.endsWith(".xls") || ext.endsWith(".xlsx");
    }
    /**
    *描述:判断是否是APP
    *作者:卜俊文
    *邮箱:344176791@qq.com
    *创建时间: 2016/9/1 9:56
    */
    public static boolean isApk(String filePath) {
        return filePath.toLowerCase().endsWith(".apk");
    }

    /**
    *描述:判断是否是pdf
    *作者:卜俊文
    *邮箱:344176791@qq.com
    *创建时间: 2016/9/1 9:57
    */
    public static boolean isPdf(String filePath) {
        return filePath.toLowerCase().endsWith(".pdf");
    }

    /**
    *描述:判断是否是文本文件
    *作者:卜俊文
    *邮箱:344176791@qq.com
    *创建时间: 2016/9/1 9:57
    */
    public static boolean isTxt(String filePath) {
        return filePath.toLowerCase().endsWith(".txt");
    }

    /**
    *描述:判断是否是chm文件
    *作者:卜俊文
    *邮箱:344176791@qq.com
    *创建时间: 2016/9/1 9:59
    */
    public static boolean isChm(String filePath) {
        return filePath.toLowerCase().endsWith(".chm");
    }
}

