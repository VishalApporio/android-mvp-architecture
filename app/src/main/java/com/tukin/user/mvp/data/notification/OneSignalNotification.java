package com.tukin.user.mvp.data.notification;

import android.util.Log;

import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationReceivedResult;

/**
 * Created by lenovo on 5/7/2018.
 */

public class OneSignalNotification extends NotificationExtenderService {

    private static String TAG = ""+OneSignalNotification.class.getSimpleName();


    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult notification) {
        Log.d(""+TAG  , "Notification Response, ADDITIONAL DATA -->  "+notification.payload.additionalData);
        return false;
    }

}
