package com.dante.customview.util;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;


public class Utils {

    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";


    public static int getScreenWidthPx() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeightPx() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getStatuBarHeight() {
        int result = 0;
        final Resources resources = Resources.getSystem();
        int resourceId = resources.getIdentifier(STATUS_BAR_HEIGHT_RES_NAME, "dimen", "android");
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getActionBarSize(Context context) {
        int[] attrs = {android.R.attr.actionBarSize};
        TypedArray values = context.getTheme().obtainStyledAttributes(attrs);
        return values.getDimensionPixelSize(0, 0);
        //第一个参数数组索引,第二个参数 默认值 } finally { values.recycle(); } } }
    }

    public static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
    }
}


