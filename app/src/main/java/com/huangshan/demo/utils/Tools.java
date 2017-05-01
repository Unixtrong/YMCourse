package com.huangshan.demo.utils;

import android.util.Log;

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
}
