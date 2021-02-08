package com.cloudwell.paywell.appController;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.multidex.BuildConfig;
import androidx.multidex.MultiDex;

import com.cloudwell.paywell.app.AppHandler;
import com.cloudwell.paywell.base.AppSignatureHelper;
import com.cloudwell.paywell.base.RecentUsedStackSet;
import com.cloudwell.paywell.constant.IconConstant;
import com.cloudwell.paywell.data.preferences.AppStorageBox;
import com.cloudwell.paywell.database.DatabaseClient;
import com.cloudwell.paywell.database.FavoriteMenuDab;
import com.cloudwell.paywell.services.activity.myFavorite.helper.MyFavoriteHelper;
import com.cloudwell.paywell.services.recentList.model.RecentUsedMenu;
import com.cloudwell.paywell.utils.AppVersionUtility;
import com.cloudwell.paywell.utils.MyHttpClient;
import com.cloudwell.paywell.utils.StringConstant;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.RefWatcher;

import org.apache.http.client.HttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Android on 12/1/2015.
 */
@SuppressWarnings("ALL")
public class AppController2 extends Application {

    private static final String APONA_LOHIT = "fonts/AponaLohit.ttf";
    private static final String OXYGEN_LIGHT = "fonts/Oxygen-Light.ttf";
    private static AppController2 mInstance;
    private static SharedPreferences preference;
    public static HttpClient client;
    private static SharedPreferences sPref;
    private static AppController2 mContext;

    AppHandler mAppHandler;

    private RefWatcher refWatcher;

    private FirebaseAnalytics mFirebaseAnalytics;


    public static synchronized AppController2 getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        mInstance = this;
        mContext = this;
        client = createTrustedHttpsClient();

        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter());
            FirebaseApp.initializeApp(this);
            String id = FirebaseInstanceId.getInstance().getToken();
            Log.e("device_token", "" + id);
            Logger.i("SMS HashKey: " + new AppSignatureHelper(getApplicationContext()).getAppSignatures().get(0));


        }

        configureCrashReporting();
        setupCrashlyticsUserInfo();

        installMenuData();

        new AppSignatureHelper(getApplicationContext()).getAppSignatures();


        setDefaultTSLVersionForBelowAndroid5Device();

    }

    private void setDefaultTSLVersionForBelowAndroid5Device() {
        int sdk = Build.VERSION.SDK_INT;
        if (sdk < Build.VERSION_CODES.LOLLIPOP) {
            try {
                ProviderInstaller.installIfNeeded(getApplicationContext());
                SSLContext sslContext;
                sslContext = SSLContext.getInstance("TLSv1.2");
                sslContext.init(null, null, null);
                sslContext.createSSLEngine();
            } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException
                    | NoSuchAlgorithmException | KeyManagementException e) {
                e.printStackTrace();
            }
        }
    }

    private void addDefaultRecentList() {

        RecentUsedStackSet.getInstance().add(new RecentUsedMenu(StringConstant.KEY_home_utility_desco, StringConstant.KEY_home_utility, IconConstant.KEY_ic_bill_pay, 4, 4));
        RecentUsedStackSet.getInstance().add(new RecentUsedMenu(StringConstant.KEY_home_utility_ivac_free_pay_favorite, StringConstant.KEY_home_utility, IconConstant.KEY_ic_bill_pay, 3, 25));
        RecentUsedStackSet.getInstance().add(new RecentUsedMenu(StringConstant.KEY_home_utility_pollibiddut_bill_pay_favorite, StringConstant.KEY_home_utility, IconConstant.KEY_ic_polli_biddut, 2, 11));
        RecentUsedStackSet.getInstance().add(new RecentUsedMenu(StringConstant.KEY_mobileOperator, StringConstant.KEY_topup, IconConstant.KEY_all_operator, 1, 1));


        ArrayList<RecentUsedMenu> all = RecentUsedStackSet.getInstance().getAll();

        ArrayList<RecentUsedMenu> update = new ArrayList<>();


        for (int i = 0; i < all.size(); i++) {
            RecentUsedMenu recentUsedMenu1 = all.get(i);
            recentUsedMenu1.setId(+i + 1);
            update.add(recentUsedMenu1);
        }

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {

                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .mFavoriteMenuDab()
                        .deletedALlRecentUsedMenu();

                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .mFavoriteMenuDab()
                        .insertRecentUsedMenu(update);

                return null;
            }
        }.execute();


    }


    private void generatedRecentUsedRecycView(List<RecentUsedMenu> favoriteMenus) {


    }

    private void installMenuData() {
        AppVersionUtility.AppStart appStart = AppVersionUtility.checkAppStart(getApplicationContext());
        switch (appStart) {
            case NORMAL:

                getRecentList();

                break;
            case FIRST_TIME:
                MyFavoriteHelper.Companion.insertData(getApplicationContext());
              //  AppStorageBox.put(getApplicationContext(), AppStorageBox.Key.USER_USED_NOTIFICAITON_FLOW, false);

                //setDefaultRecentList();

                break;
            case FIRST_TIME_VERSION:
               // AppStorageBox.put(getApplicationContext(), AppStorageBox.Key.USER_USED_NOTIFICAITON_FLOW, false);
                MyFavoriteHelper.Companion.updateData(getApplicationContext());

                // setDefaultRecentList();

                break;
        }
    }

    private void getRecentList() {


        final FavoriteMenuDab favoriteMenuDab = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().mFavoriteMenuDab();
        favoriteMenuDab.getAllRecentUsedMenu().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<RecentUsedMenu>>() {
                    @Override
                    public void accept(List<RecentUsedMenu> favoriteMenus) throws Exception {

                        if (favoriteMenus.size() == 0) {
                            addDefaultRecentList();
                        } else {
                            List<RecentUsedMenu> favoriteMenus1 = favoriteMenus;

                            RecentUsedStackSet.getInstance().addAll(favoriteMenus);
                        }
                    }
                });

    }


    private void setDefaultRecentList() {


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .mFavoriteMenuDab()
                        .deletedALlRecentUsedMenu();

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                final FavoriteMenuDab favoriteMenuDab = DatabaseClient.getInstance(getApplicationContext()).getAppDatabase().mFavoriteMenuDab();
                favoriteMenuDab.getAllRecentUsedMenu().subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<List<RecentUsedMenu>>() {
                            @Override
                            public void accept(List<RecentUsedMenu> favoriteMenus) throws Exception {

                                if (favoriteMenus.size() == 0) {
                                    addDefaultRecentList();
                                }
                            }
                        });

            }
        }.execute();


    }


    public static RefWatcher getRefWatcher(Context context) {
        AppController2 myApplication = (AppController2) context.getApplicationContext();
        return myApplication.refWatcher;
    }

    private void configureCrashReporting() {
//        CrashlyticsCore crashlyticsCore = new CrashlyticsCore.Builder()
//                .disabled(BuildConfig.DEBUG)
//                .build();
//        Fabric.with(this, new Crashlytics.Builder().core(crashlyticsCore).build(), new Crashlytics());
//
//         FirebaseAnalytics mFirebaseAnalytics;

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);


    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static AppController2 getContext() {
        return mContext;
    }

    public HttpClient getTrustedHttpClient() {
        return client;
    }

    private HttpClient createTrustedHttpsClient() {
        HttpParams httpParameters = new BasicHttpParams();
        // Set the timeout in milliseconds until a connection is
        // established.
        int timeoutConnection = 1000000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
        // Set the default socket timeout (SO_TIMEOUT)
        // in milliseconds which is the timeout for waiting for
        // data.
        int timeoutSocket = 1000000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        // Instantiate the custom HttpClient
        HttpClient client = new MyHttpClient(httpParameters, getApplicationContext());
        return client;
    }

    public String getAssestFont() {
        return OXYGEN_LIGHT;
    }

    public Typeface getAponaLohitFont() {
        return Typeface.createFromAsset(getAssets(), APONA_LOHIT);
    }

    public Typeface getOxygenLightFont() {
        return Typeface.createFromAsset(getAssets(), OXYGEN_LIGHT);
    }

    public static AppController2 getmContext() {
        return mContext;
    }

    private void setupCrashlyticsUserInfo() {
        try {
            mAppHandler = AppHandler.getmInstance(getApplicationContext());
            String appStatus = mAppHandler.getAppStatus();
            if (!appStatus.equals("unknown")) {
                String rid = mAppHandler.getRID();
                String userName = mAppHandler.getUserName();
                String mobileNumber = mAppHandler.getMobileNumber();
                mFirebaseAnalytics.getInstance(this).setUserId("UserName: " + userName + " Mobile number: " + mobileNumber);
                Logger.v("UserName: " + userName + " Mobile number: " + mobileNumber);

            }
        } catch (Exception e) {

        }
    }
}
