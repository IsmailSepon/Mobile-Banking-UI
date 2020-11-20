package com.cloudwell.paywell.base;

import android.content.Context;
import android.content.SharedPreferences;

public class Preference {

    private static Preference yourPreference;
    private final SharedPreferences sharedPreferences;

    public static Preference getInstance(Context context) {
        if (yourPreference == null) {
            yourPreference = new Preference(context);
        }
        return yourPreference;
    }

    private Preference(Context context) {
        sharedPreferences = context.getSharedPreferences("YourCustomNamedPreference", Context.MODE_PRIVATE);
    }

    public void saveData(String key,String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor .putString(key, value);
        prefsEditor.commit();
    }

    public String getData(String key) {
        if (sharedPreferences!= null) {
            return sharedPreferences.getString(key, "");
        }
        return "";
    }
}
