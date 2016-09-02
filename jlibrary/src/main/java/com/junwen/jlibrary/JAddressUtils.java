package com.junwen.jlibrary;

import java.util.StringTokenizer;

/**
 * 描述：IP工具类
 * 作者：卜俊文
 * 创建：2016/8/19 17:18
 * 邮箱：344176791@qq.com
 */
public class JAddressUtils {
    /**
     * 描述:ip转16进制
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 17:19
     */
    public static String ipToHex(String ips) {
        StringBuffer result = new StringBuffer();
        if (ips != null) {
            StringTokenizer st = new StringTokenizer(ips, ".");
            while (st.hasMoreTokens()) {
                String token = Integer.toHexString(Integer.parseInt(st.nextToken()));
                if (token.length() == 1)
                    token = "0" + token;
                result.append(token);

            }

        }
        return result.toString();

    }


    /**
     * 描述:16进制转ip
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 17:19
     */
    public static String texToIp(String ips) {
        try {
            StringBuffer result = new StringBuffer();
            if (ips != null && ips.length() == 8) {
                for (int i = 0; i < 8; i += 2) {
                    if (i != 0)
                        result.append('.');
                    result.append(Integer.parseInt(ips.substring(i, i + 2), 16));

                }

            }
            return result.toString();

        } catch (NumberFormatException ex) {
        }
        return "";

    }
}
