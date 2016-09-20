package cw89.cwutil;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.Toast;

/**
 * Created by chang-wan on 2016. 9. 20..
 */
public class Utils {


    private static final String TAG = Utils.class.getSimpleName();
    private static final double defaultDeviceWidth = 1080.0f;
    private static final double defaultDeviceHeight = 1920.0f;

    public static void showToast(Context context, String msg) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);

        toast.show();
    }

    public static int convertDpPixel(Context context, int dp) {
        final Resources r = context.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                r.getDisplayMetrics());
        return (int) px;
    }

    public static int getStatusBarHeight(Context context) {
        int height = context.getResources().getDimensionPixelSize(
                R.dimen.cw_status_bar_height);

        return height;
    }

    public static int getNabigationBarHeight(Context context) {

        int height = 0;
        boolean hasMenuKey = ViewConfiguration.get(context)
                .hasPermanentMenuKey();
        boolean hasBackKey = KeyCharacterMap
                .deviceHasKey(KeyEvent.KEYCODE_BACK);
        if (!hasMenuKey && !hasBackKey) {

            height = context.getResources().getDimensionPixelSize(
                    R.dimen.cw_navigation_bar_height);

        } else {

        }

        return height;
    }

    public static double getDeviceWidth(Activity activity) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay()
                .getMetrics(displayMetrics);
        double width = displayMetrics.widthPixels;
        return width;

    }

    public static double getDeviceHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay()
                .getMetrics(displayMetrics);
        double height = displayMetrics.heightPixels;

        return height;
    }


    public static double getProportionWidth(Activity activity) {

        double pro = defaultDeviceWidth / getDeviceWidth(activity);

        return pro;

    }

    public static double getProportionHeight(Activity activity) {

        double pro = defaultDeviceHeight / getDeviceHeight(activity);

        return pro;
    }

    public static int resizeWidth(Activity activity, int prevSize) {

        int result = 0;
        result = (int) (prevSize / getProportionWidth(activity));
        return result;
    }

    public static int resizeHeight(Activity activity, int prevSize) {

        int result = 0;
        result = (int) (prevSize / getProportionHeight(activity));
        return result;
    }
}
