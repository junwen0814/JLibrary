package com.junwen.jlibrary;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 描述:share工具类
 * 作者:卜俊文
 * 邮箱:344176791@qq.com
 * 创建时间: 2016/8/11 16:14
 */
public class JShareUtils {
    public JShareUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 描述:保存在手机里面的文件名
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:15
     */
    public static String FILE_NAME = "share_data";


    /**
     * 描述:存sharedPreferences文件
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:15
     */
    public static void saveShare(Context context, String fileName, int mode, Map<String, Object> map) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, mode);
        Editor edit = sharedPreferences.edit();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                edit.putString(key, value.toString());
            } else if (value instanceof Integer) {
                edit.putInt(key, (Integer) value);
            } else if (value instanceof Boolean) {
                edit.putBoolean(key, (Boolean) value);
            } else if (value instanceof Float) {
                edit.putFloat(key, (Float) value);
            } else if (value instanceof Long) {
                edit.putLong(key, (Long) value);
            }
        }
        edit.commit();
    }

    /**
     * 描述:取出xml文件
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:15
     */
    public static Object getShare(Context context, String fileName, int mode, String key) {
        Object object = null;
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, mode);
        if (sharedPreferences != null) {
            Map<String, ?> map = sharedPreferences.getAll();
            if (map.size() > 0) {
                for (int i = 0; i < map.size(); i++) {
                    Object value = map.get(key);
                    if (value instanceof String) {
                        object = sharedPreferences.getString(key, "");
                    } else if (value instanceof Boolean) {
                        object = sharedPreferences.getBoolean(key, false);
                    } else if (value instanceof Float) {
                        object = sharedPreferences.getFloat(key, 0);
                    } else if (value instanceof Long) {
                        object = sharedPreferences.getLong(key, 0);
                    } else if (value instanceof Integer) {
                        object = sharedPreferences.getInt(key, 0);
                    }
                }
            }
        }
        return object;
    }

    public static void put(Context context, String key, Object object) {

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        Editor editor = sp.edit();

        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }

        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 描述:得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:15
     */
    public static Object get(Context context, String key, Object defaultObject) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);

        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }

    /**
     * 描述:移除某个key值已经对应的值
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:15
     */
    public static void remove(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 描述:清除所有数据
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:15
     */
    public static void clear(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * 描述:查询某个key是否已经存在
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:15
     */
    public static boolean contains(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    /**
     * 描述:返回所有的键值对
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:15
     */
    public static Map<String, ?> getAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
        return sp.getAll();
    }

    /**
     * 描述:创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:15
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 描述:反射查找apply的方法
         * 作者:卜俊文
         * 邮箱:344176791@qq.com
         * 创建时间: 2016/8/11 16:15
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }

            return null;
        }

        /**
         * 描述:如果找到则使用apply执行，否则使用commit
         * 作者:卜俊文
         * 邮箱:344176791@qq.com
         * 创建时间: 2016/8/11 16:15
         */
        public static void apply(Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
            editor.commit();
        }

        /**
         * 描述:多进程Preferences数据共享,存储，相关文章：http://zengrong.net/post/1687.htm
         * 作者:卜俊文
         * 邮箱:344176791@qq.com
         * 创建时间: 2016/8/19 17:10
         */
        public static void putStringProcess(Context ctx, String key, String value) {
            SharedPreferences sharedPreferences = ctx.getSharedPreferences("preference_mu", Context.MODE_MULTI_PROCESS);
            Editor editor = sharedPreferences.edit();
            editor.putString(key, value);
            editor.commit();
        }

        /**
         * 描述:多进程Preferences数据共享,提取
         * 作者:卜俊文
         * 邮箱:344176791@qq.com
         * 创建时间: 2016/8/19 17:10
         */
        public static String getStringProcess(Context ctx, String key, String defValue) {
            SharedPreferences sharedPreferences = ctx.getSharedPreferences("preference_mu", Context.MODE_MULTI_PROCESS);
            return sharedPreferences.getString(key, defValue);
        }
    }
}