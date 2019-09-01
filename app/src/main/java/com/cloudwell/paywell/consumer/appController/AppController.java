package com.cloudwell.paywell.consumer.appController;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by Android on 12/1/2015.
 */
@SuppressWarnings("ALL")
public class AppController extends Application {

    private static final String APONA_LOHIT = "fonts/AponaLohit.ttf";
    private static final String OXYGEN_LIGHT = "fonts/Oxygen-Light.ttf";
    private static AppController mInstance;
    private static SharedPreferences preference;

    private static SharedPreferences sPref;
    private static AppController mContext;



    public static synchronized AppController getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mContext = this;

    }

    public static AppController getContext() {
        return mContext;
    }


}
