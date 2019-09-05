package com.cloudwell.paywell.consumer.data.preferences;

import android.content.Context;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-05.
 */
public class StorageBox {

    public enum Key {
        /* Recommended naming convention:
         * ints, floats, doubles, longs:
         * SAMPLE_NUM or SAMPLE_COUNT or SAMPLE_INT, SAMPLE_LONG etc.
         *
         * boolean: IS_SAMPLE, HAS_SAMPLE, CONTAINS_SAMPLE
         *
         * String: SAMPLE_KEY, SAMPLE_STR or just SAMPLE
         */
        KEY_USERNAME, KEY_PASSWORD, KEY_USER
    }

    public static void put(Context context, Key key, Object value) {
        Hawk.init(context)
                .setEncryption(HawkBuilder.EncryptionMethod.MEDIUM)
                .build();
    }

    public static Object get(Context context, Key key) {
        Hawk.init(context).build();
        Object data = Hawk.get(key.name());
        Hawk.destroy();
        return data;
    }

    public static void delete(Context context, Key key) {
        Hawk.init(context).build();
        Hawk.delete(key.name());
        Hawk.destroy();
    }

    public static boolean check(Context context, Key key) {
        Hawk.init(context).build();
        return Hawk.contains(key.name());
    }
}

