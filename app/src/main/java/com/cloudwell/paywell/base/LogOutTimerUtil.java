package com.cloudwell.paywell.base;

import android.app.ActivityManager;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

/**
 * Created by Sepon on 4/1/2020.
 */
public class LogOutTimerUtil {

    public interface LogOutListener {
        void doLogout();
    }
    static Timer longTimer;
    static final int LOGOUT_TIME = 600000; // delay in milliseconds i.e. 5 min = 300000 ms or use timeout argument

    public static synchronized void startLogoutTimer(final Context context, final LogOutListener logOutListener) {
        if (longTimer != null) {
            longTimer.cancel();
            longTimer = null;
        }
        if (longTimer == null) {

            longTimer = new Timer();
            Log.e("Timer", "timer Start....>");

            longTimer.schedule(new TimerTask() {

                public void run() {

                    cancel();

                    longTimer = null;

                    try {
                        boolean foreGround = new ForegroundCheckTask().execute(context).get();

                        if (foreGround) {
                            logOutListener.doLogout();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                }
            }, LOGOUT_TIME);
        }
    }

    public static synchronized void stopLogoutTimer() {
        if (longTimer != null) {
            longTimer.cancel();
            longTimer = null;
            Log.e("Timer", "timer Stop.....!");
        }
    }

    static class ForegroundCheckTask extends AsyncTask< Context, Void, Boolean > {

        @Override
        protected Boolean doInBackground(Context...params) {
            final Context context = params[0].getApplicationContext();
            return isAppOnForeground(context);
        }

        private boolean isAppOnForeground(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            List< ActivityManager.RunningAppProcessInfo > appProcesses = activityManager.getRunningAppProcesses();
            if (appProcesses == null) {
                return false;
            }
            final String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo appProcess: appProcesses) {
                if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName.equals(packageName)) {
                    return true;
                }
            }
            return false;
        }
    }

}
