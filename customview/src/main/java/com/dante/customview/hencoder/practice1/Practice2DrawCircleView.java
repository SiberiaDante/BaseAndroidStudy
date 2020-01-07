package com.dante.customview.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.dante.customview.R;
import com.dante.customview.util.Utils;

public class Practice2DrawCircleView extends View {
    public static final String TAG = Practice2DrawCircleView.class.getSimpleName();
    private Paint paint1 = new Paint();
    private Paint paint2 = new Paint();
    private Paint paint3 = new Paint();
    private Paint paint4 = new Paint();
    private int widthPixels;
    private int heightPixels;
    private int actionBarPx;
    private int statusBarHeight;
    private float tabHeight;

    public Practice2DrawCircleView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        paint1.setColor(Color.BLACK);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setAntiAlias(true);

        paint2.setColor(Color.BLACK);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(2);
        paint2.setAntiAlias(true);

        paint3.setColor(Color.BLUE);
        paint3.setAntiAlias(true);

        paint4.setStyle(Paint.Style.STROKE);
        paint4.setColor(Color.BLACK);
        paint4.setStrokeWidth(20);
        paint4.setAntiAlias(true);

        widthPixels = getResources().getDisplayMetrics().widthPixels;
        heightPixels = Utils.getScreenHeightPx();
        actionBarPx = Utils.getActionBarSize(context);
        statusBarHeight = Utils.getStatuBarHeight();
        tabHeight = getResources().getDimension(R.dimen.tab_bar_height);
        Log.d(TAG, "---------------------:" + widthPixels);
        Log.d(TAG, "---------------------:" + heightPixels);
        Log.d(TAG, "---------------------:" + actionBarPx);
        Log.d(TAG, "---------------------:" + statusBarHeight);
        Log.d(TAG, "---------------------:" + tabHeight);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float radius = widthPixels / 4f / 2f;
        float leftCenterX = widthPixels / 4f;
        float rightCenterX = widthPixels / 4f * 3f;
        float topCenterY = (heightPixels - statusBarHeight - actionBarPx - tabHeight) / 4f / 2f;
        float bottomCenterY = (heightPixels - statusBarHeight - actionBarPx - tabHeight) / 4f / 2f * 3f;
        Log.d(TAG, "onDraw: radius=" + radius);
        Log.d(TAG, "onDraw: leftCenterX=" + leftCenterX);
        Log.d(TAG, "onDraw: rightCenterX=" + rightCenterX);
        Log.d(TAG, "onDraw: topCenterY=" + topCenterY);
        Log.d(TAG, "onDraw: bottomCenterY=" + bottomCenterY);
//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        canvas.drawCircle(leftCenterX, topCenterY, radius, paint1);
        canvas.drawCircle(rightCenterX, topCenterY, radius, paint2);
        canvas.drawCircle(leftCenterX, bottomCenterY, radius, paint3);
        canvas.drawCircle(rightCenterX, bottomCenterY, radius, paint4);


    }
}
