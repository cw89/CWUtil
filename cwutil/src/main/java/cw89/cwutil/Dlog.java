package cw89.cwutil;

import android.util.Log;

/**
 * Created by chang-wan on 2016. 9. 20..
 */


public class Dlog {

    private static final String TAG = Dlog.class.getSimpleName();


    private static boolean DEBUG = false;
    public static void isDebug()
    {
        DEBUG = true;
    }
    public static final void e(String message) {
        if (DEBUG) Log.e(TAG, showMessage(message));
    }

    public static final void d(String message) {
        if (DEBUG) Log.d(TAG, showMessage(message));
    }

    public static final void i(String message) {
        if (DEBUG) Log.i(TAG, showMessage(message));
    }

    public static final void w(String message) {
        if (DEBUG) Log.w(TAG, showMessage(message));
    }

    public static final void v(String message) {
        if (DEBUG) Log.v(TAG, showMessage(message));
    }


    public static String showMessage(String message) {

        StackTraceElement ste = Thread.currentThread().getStackTrace()[4];

        StringBuilder output = new StringBuilder();
        output.append(" | ");
        output.append(ste.getFileName().replace(".java",""));
        output.append(" :: ");
        output.append(ste.getMethodName()+"()");
        output.append(" | ");
        output.append(message);

        return output.toString();

    }
}