package com.junwen.jlibrary;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

/**
 * 描述：Notification工具类
 * 作者：卜俊文
 * 创建：2016/8/11 16:04
 * 邮箱：344176791@qq.com
 */
public class JNotificationUtils {

    private static JNotificationUtils jNotificationUtils;

    private JNotificationUtils(Context context) {
        this.context = context;
    }

    public static JNotificationUtils getInstance(Context context) {
        if (jNotificationUtils == null) {
            synchronized (JNotificationUtils.class) {
                if (jNotificationUtils == null) {
                    jNotificationUtils = new JNotificationUtils(context);
                }
            }
        }
        return jNotificationUtils;
    }

    private Context context;


    /**
     * 描述:建立一个NotificationCompat.Builder，并返回
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:03
     */
    public NotificationCompat.Builder getNotifyBuilder(String contentTitle, String contentText,
                                                       String contentInfo, Bitmap largeIcon, int smallIcon,
                                                       Class contentclass) {
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                new Intent(), 0);
        if (contentclass != null) {
            pendingIntent = PendingIntent.getActivity(context, 0, new Intent(
                    context, contentclass), 0);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setLargeIcon(largeIcon).setSmallIcon(smallIcon)
                .setContentInfo(contentInfo).setContentTitle(contentTitle)
                .setContentText(contentText).setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_ALL);
        return builder;

    }

    /**
     * 描述:建一个带有ProgressBar的NotificationCompat.Builder，并返回
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:03
     */
    public NotificationCompat.Builder getNotifyBuilderProgress(String contentTitle,
                                                               String contentText, String contentInfo, Bitmap largeIcon,
                                                               int smallIcon, Class contentclass, int max, int progress,
                                                               boolean indeterminate) {
        NotificationCompat.Builder builder = getNotifyBuilder(contentTitle, contentText,
                contentInfo, largeIcon, smallIcon, contentclass);

        builder.setProgress(max, progress, indeterminate);
        return builder;

    }

    /**
     * 描述:普通的Notification
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:04
     */
    public void showNotifyNormal(NotificationCompat.Builder builder, int notifyId) {

        Notification notification = builder.build();

        NotificationManager manager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notifyId, notification);

    }

    /**
     * 描述:大布局Notification
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:04
     */
    public void showNotifyBigView(NotificationCompat.Style style,
                                  NotificationCompat.Builder builder, int notifyId) {
        builder.setStyle(style);

        Notification notification = builder.build();

        NotificationManager manager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notifyId, notification);
    }

    /**
     * 描述:BigTextStyle风格的Notification
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:07
     */
    public void showNotifyBigText(String bigContentTitle, String summaryText,
                                  String bigText, NotificationCompat.Builder builder, int notifyId) {

        NotificationCompat.BigTextStyle textStyle = new NotificationCompat.BigTextStyle();
        textStyle.setBigContentTitle(bigContentTitle)
                .setSummaryText(summaryText).bigText(bigText);
        showNotifyBigView(textStyle, builder, notifyId);
    }

    /**
     * 描述:BigPictureStyle风格的Notification
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:07
     */
    public void showNotifyBigPic(String bigContentTitle, String summaryText,
                                 Bitmap bigPicture, NotificationCompat.Builder builder, int notifyId) {

        NotificationCompat.BigPictureStyle pictureStyle = new NotificationCompat.BigPictureStyle();
        pictureStyle.setBigContentTitle(bigContentTitle)
                .setSummaryText(summaryText).bigPicture(bigPicture);
        showNotifyBigView(pictureStyle, builder, notifyId);
    }

    /**
     * 描述:InboxStyle风格的Notification
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:07
     */
    public void showNotifyBigInbox(String bigContentTitle, String summaryText,
                                   String[] line, NotificationCompat.Builder builder, int notifyId) {

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle(bigContentTitle).setSummaryText(
                summaryText);
        for (int i = 0; i < line.length; i++) {
            inboxStyle.addLine(line[i]);
        }

        showNotifyBigView(inboxStyle, builder, notifyId);
    }

    /**
     * 描述:自定义Notification
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/11 16:07
     */
    public void showNotifyCustomView(int layoutId, Class contentclass,
                                     int smallIcon, Class clickCla, int clickId, int notifyId) {
        NotificationManager manager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                layoutId);

        if (clickCla != null) {
            Intent intent = new Intent(context, clickCla);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                    intent, 0);
            remoteViews.setOnClickPendingIntent(clickId, pendingIntent);
        }

        NotificationCompat.Builder builder = getNotifyBuilder("", "", "", null, smallIcon,
                contentclass).setContent(remoteViews);
        manager.notify(notifyId, builder.build());
    }
}
