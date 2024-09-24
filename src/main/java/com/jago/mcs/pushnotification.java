package com.jago.mcs;

import android.app.Application;

import com.onesignal.OneSignal;

/*
 * Website (https://mcsdeveloper.org/).
 * Developed by MCS Developer
 * 14/8/2021
 */

public class pushnotification extends Application {

    private static final String ONESIGNAL_APP_ID = "cb31ae61-b659-4085-9fef-9890f238435c";

    @Override
    public void onCreate() {
        super.onCreate();

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }
}
