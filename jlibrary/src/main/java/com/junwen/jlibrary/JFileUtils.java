package com.junwen.jlibrary;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 描述::文件工具类
 * 作者:卜俊文
 * 邮箱:344176791@qq.com
 * 创建时间: 2016/8/11 15:53
 */
public class JFileUtils {

    /**
     * 描述::根据文件路径，获取文件的大小（B, KB MB G）
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:54
     */
    public static String getFileSize(String filePath) {
        return getFileSize(new File(filePath));
    }

    private static String SDPATH = Environment.getExternalStorageDirectory()
            .getAbsolutePath().toString()
            + "/sdcard/";

    /**
     * 描述:写入文件
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:54
     */
    public static void saveFile(String fileName, InputStream inputStream,
                                int total, onDownProgressListener onDownProgressListener) {
        File file = new File(SDPATH);
        if (!file.exists()) {
            file.mkdir();
        }
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(file.getPath(),
                    fileName));
            int len = 0;
            int sum = 0;
            byte[] buff = new byte[2048];
            while ((len = (inputStream.read(buff))) != -1) {
                outputStream.write(buff, 0, len);
                sum += len;
                int progress = (int) (sum * 1.0f / total * 100);
                onDownProgressListener.onProgress(progress);
            }
            onDownProgressListener.onSuccess();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            onDownProgressListener.onFail(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            onDownProgressListener.onFail(e.getMessage());
        }
    }

    interface onDownProgressListener {
        void onProgress(int progress);

        void onSuccess();

        void onFail(String error);
    }

    /**
     * 描述: 根据文件对象，获取文件的大小（B, KB MB G）
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:54
     */
    public static String getFileSize(File file) {
        int fileSize = 0;
        try {
            FileInputStream is = new FileInputStream(file);
            try {
                fileSize = is.available();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileSize < 1024) {
            fileSizeString = df.format((double) fileSize) + "B";
        } else if (fileSize < 1048576) {
            fileSizeString = df.format((double) fileSize / 1024) + "KB";
        } else if (fileSize < 1073741824) {
            fileSizeString = df.format((double) fileSize / 1048576) + "MB";
        } else {
            fileSizeString = df.format((double) fileSize / 1073741824) + "G";
        }
        return fileSizeString;
    }

    /**
     * 描述:清除/data/data/com.xxx.xxx/files下的内容
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:54
     */
    public static void cleanFiles(Context context) {
        JCommand.deleteFilesByDirectory(context.getFilesDir());
    }

    /**
     * 描述:清除外部cache下的内容(/mnt/sdcard/android/data/com.xxx.xxx/cache)
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:54
     */
    public static void cleanExternalCache(Context context) {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {

            JCommand.deleteFilesByDirectory(context.getExternalCacheDir());
        }
    }

    /**
     * 描述:清除自定义路径下的文件，使用需小心，请不要误删。而且只支持目录下的文件删除
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:54
     */
    public static void cleanCustomCache(String filePath) {
        JCommand.deleteFilesByDirectory(new File(filePath));
    }

    /**
     * 描述:删除指定文件路径的文件
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 15:55
     */
    static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    /**
     * Context.getExternalFilesDir() -->
     * SDCard/Android/data/你的应用的包名/files/目录，一般放一些长时间保存的数据
     * <p/>
     * Context.getExternalCacheDir() -->
     * SDCard/Android/data/你的应用包名/cache/目录，一般存放临时缓存数据
     *
     * @param file
     * @return
     * @throws Exception 获取指定文件夹大小
     */
    public static long getFolderSize(File file) throws Exception {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                // 如果下面还有文件
                if (fileList[i].isDirectory()) {
                    size = size + getFolderSize(fileList[i]);
                } else {
                    size = size + fileList[i].length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }


    /**
     * 描述:文件夹排序（先文件夹排序，后文件排序）
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 17:16
     */
    public static void sortFiles(File[] files) {
        Arrays.sort(files, new Comparator<File>() {

            @Override
            public int compare(File lhs, File rhs) {
                //返回负数表示o1 小于o2，返回0 表示o1和o2相等，返回正数表示o1大于o2。
                boolean l1 = lhs.isDirectory();
                boolean l2 = rhs.isDirectory();
                if (l1 && !l2)
                    return -1;
                else if (!l1 && l2)
                    return 1;
                else {
                    return lhs.getName().compareTo(rhs.getName());
                }
            }
        });
    }

    /**
     * 描述:解压一个压缩文档 到指定位置
     * zipFileString 压缩包的名字
     * outPathString 指定的路径
     * 者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 17:22
     */
    public static void UnZipFolder(String zipFileString, String outPathString) throws Exception {
        java.util.zip.ZipInputStream inZip = new java.util.zip.ZipInputStream(new java.io.FileInputStream(zipFileString));
        java.util.zip.ZipEntry zipEntry;
        String szName = "";

        while ((zipEntry = inZip.getNextEntry()) != null) {
            szName = zipEntry.getName();

            if (zipEntry.isDirectory()) {

                // get the folder name of the widget
                szName = szName.substring(0, szName.length() - 1);
                java.io.File folder = new java.io.File(outPathString + java.io.File.separator + szName);
                folder.mkdirs();

            } else {

                java.io.File file = new java.io.File(outPathString + java.io.File.separator + szName);
                file.createNewFile();
                // get the output stream of the file
                java.io.FileOutputStream out = new java.io.FileOutputStream(file);
                int len;
                byte[] buffer = new byte[1024];
                // read (len) bytes into buffer
                while ((len = inZip.read(buffer)) != -1) {
                    // write (len) byte from buffer at the position 0
                    out.write(buffer, 0, len);
                    out.flush();
                }
                out.close();
            }
        }//end of while
        inZip.close();
    }//end of func

    /**
     * 根据文件路径获取文件
     *
     * @param filePath 文件路径
     * @return 文件
     */
    public static File getFileByPath(String filePath) {
        return JStringUtils.isSpace(filePath) ? null : new File(filePath);
    }
    /**
     * 判断文件是否存在
     *
     * @param filePath 文件路径
     * @return {@code true}: 存在<br>{@code false}: 不存在
     */
    public static boolean isFileExists(String filePath) {
        return isFileExists(getFileByPath(filePath));
    }

    /**
     * 判断文件是否存在
     *
     * @param file 文件
     * @return {@code true}: 存在<br>{@code false}: 不存在
     */
    public static boolean isFileExists(File file) {
        return file != null && file.exists();
    }
}
