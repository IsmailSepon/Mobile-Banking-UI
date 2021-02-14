package com.cloudwell.paywell.base;

import android.app.Application;

/**
 * Created by Sepon on 4/1/2020.
 */
public class ApplockManager {
    private static ApplockManager instance;
    private DefaultApplock currentAppLocker;

    public static ApplockManager getInstance() {
        if (instance == null) {
            instance = new ApplockManager();
        }
        return instance;
    }

    public void enableDefaultAppLockIfAvailable(Application currentApp) {

        currentAppLocker = new DefaultApplock(currentApp);

    }

    public void updateTouch(){
//        currentAppLocker.updateTouch();
    }
}
