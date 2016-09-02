package com.junwen.jlibrary;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.IOException;

/**
 * 描述：语音操作类
 * 作者：卜俊文
 * 创建：2016/8/19 16:46
 * 邮箱：344176791@qq.com
 */
public class JAudioUtils {

    private MediaPlayer mediaPlayer;

    private static JAudioUtils audioUtils;

    public JAudioUtils() {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
        }
    }

    /**
     * 描述:单例
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 16:49
     */
    public static JAudioUtils getInstance() {
        if (audioUtils == null) {
            synchronized (JAudioUtils.class) {
                if (audioUtils == null) {
                    audioUtils = new JAudioUtils();
                }
            }
            return audioUtils;
        }
        return audioUtils;
    }

    /**
     * 描述:根据Assets里面的文件名，进行播放
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 16:49
     */
    public void speak(Context context, String name) {
        if (!TextUtils.isEmpty(name)) {
            //重置
            mediaPlayer.reset();
            AssetManager assets = context.getAssets();
            try {
                //根据文件名读取音频设置属性开始播放
                final AssetFileDescriptor fileDescriptor = assets.openFd(name);
                mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(), fileDescriptor.getStartOffset(), fileDescriptor.getLength());
                mediaPlayer.prepare();
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        stop();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(context, "文件不存在", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 描述:停止
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 16:49
     */
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}
