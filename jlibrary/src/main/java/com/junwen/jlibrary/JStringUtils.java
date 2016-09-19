package com.junwen.jlibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述:字符串处理工具类
 * 作者:卜俊文
 * 邮箱:344176791@qq.com
 * 创建时间: 2016/3/10 11:26
 */
public class JStringUtils {

    private final static int[] SIZE_TABLE = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999,
            Integer.MAX_VALUE};

    /**
     * 描述:检测字符串中是否包含汉字
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 16:59
     */
    public static boolean checkChinese(String sequence) {
        final String format = "[\\u4E00-\\u9FA5\\uF900-\\uFA2D]";
        boolean result = false;
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(sequence);
        result = matcher.find();
        return result;
    }

    /**
     * 描述:根据Input流，返回这个流得字符串
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:16
     */
    public static String getString(InputStream inputStream) {
        String result = "";
        String line = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            return result;
        } catch (IOException e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * calculate the size of an integer number
     *
     * @param x
     * @return
     */
    public static int sizeOfInt(int x) {
        for (int i = 0; ; i++)
            if (x <= SIZE_TABLE[i]) {
                return i + 1;
            }
    }

    /**
     * Judge whether each character of the string equals
     *
     * @param str
     * @return
     */
    public static boolean isCharEqual(String str) {
        return str.replace(str.charAt(0), ' ').trim().length() == 0;
    }

    /**
     * Determines if the string is a digit
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Judge whether the string is whitespace, empty ("") or null.
     *
     * @param str
     * @return
     */
    public static boolean equalsNull(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0 || str.equalsIgnoreCase("null")) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
}
