package me.hhhaiai.ws.utils;

import android.text.TextUtils;
import android.util.Log;

public class Logs {
    private static final String TAG = "sanbo";

    public static void d(String tag, String msg, Throwable ex) {
        tag = preTag(tag);
        Log.d(tag, msg, ex);
    }


    public static void e(String tag, String msg, Throwable ex) {
        tag = preTag(tag);
        Log.e(tag, msg, ex);
    }

    public static void d(String tag, String msg) {
        tag = preTag(tag);
        Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        tag = preTag(tag);
        Log.i(tag, msg);
    }

    public static void e(String tag, String msg) {
        tag = preTag(tag);
        Log.e(tag, msg);
    }


    private static String preTag(String tag) {
        if (TextUtils.isEmpty(tag)) {
            return TAG;
        }
        if (!tag.startsWith(TAG)) {
            tag = TAG + "." + tag;
        }
        return tag;
    }
}
