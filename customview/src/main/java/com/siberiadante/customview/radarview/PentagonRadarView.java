package com.siberiadante.customview.radarview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * create date: 2018/8/30
 * 五边形雷达
 */
public class PentagonRadarView extends View {
    private int count = 5;
    private Paint pentagonPaint;

    public PentagonRadarView(Context context) {
        super(context);
        init();
    }

    private void init() {
        pentagonPaint = new Paint();
        pentagonPaint.setColor(Color.BLACK);
        pentagonPaint.setStrokeWidth(2);
        pentagonPaint.setAntiAlias(true);
        pentagonPaint.setStyle(Paint.Style.STROKE);
    }

    public PentagonRadarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PentagonRadarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PentagonRadarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
//        refrigerator
    }
}
