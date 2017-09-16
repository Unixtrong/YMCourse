package com.huangshan.demo.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import java.io.Closeable;
import java.io.IOException;

/**
 * Author(s): danyun
 * Date: 2017/3/20
 */
public class Tools {
    public static void debug(String msg) {
        Log.d("YM", msg);
    }

    public static void warn(String msg, Throwable tr) {
        Log.w("YM", msg, tr);
    }

    public static void closeStream(Closeable stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int toInteger(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void toast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static float dipToPixel(float dip) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dip * metrics.density;
    }
}
