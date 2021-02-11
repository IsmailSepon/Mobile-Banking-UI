package com.cloudwell.paywell.analytics;

import android.os.Bundle;
import android.util.Log;

import com.cloudwell.paywell.appController.AppController2;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 9/12/18.
 */
public class AnalyticsManager {
    private final static String TAG = "AnalyticsManager";

    /**
     * Sends a screen view with the string resource loaded as its label.
     */


    /**
     * Sends a screen vie for a screen label.
     */
    public static void sendScreenView(String screenName) {


        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(AppController2.getContext());
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.CONTENT, screenName);
        instance.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        Log.d(TAG, "Screen View recorded: " + screenName);

    }


}

