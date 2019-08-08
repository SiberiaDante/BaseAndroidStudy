package com.dante.customview.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.dante.customview.R;
import com.dante.customview.util.Utils;

public class Practice3DrawRectView extends View {

    public static final String TAG = Practice3DrawRectView.class.getSimpleName();
    private int widthPixels;
    private int heightPixels;
    private int actionBarPx;
    private int statusBarHeight;
    private float tabHeight;
    private Paint mPaint;

    public Practice3DrawRectView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        widthPixels = getResources().getDisplayMetrics().widthPixels;
        Log.d(TAG, "init: ---:" + widthPixels);
        heightPixels = Utils.getScreenHeightPx();
        actionBarPx = Utils.getActionBarSize(context);
        statusBarHeight = Utils.getStatuBarHeight();
        tabHeight = getResources().getDimension(R.dimen.tab_bar_height);
        mPaint.setStyle(Paint.Style.FILL);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        widthPixels = getMeasuredWidth();
//        Log.d(TAG, "onMeasure: ---:" + widthPixels);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float radius = widthPixels / 4f;
        float centerX = widthPixels / 2f;
        float centerY = (heightPixels - statusBarHeight - actionBarPx - tabHeight) / 4;
        float left = centerX - radius;
        float top = centerY - radius;
        float right = centerX + radius;
        float bottom = centerY + radius;

//        练习内容：使用 canvas.drawRect() 方法画矩形
        /*
         * left:x
         * top:y
         * right:x
         * bottom:y
         */
        canvas.drawRect(left, top, right, bottom, mPaint);
    }
}
