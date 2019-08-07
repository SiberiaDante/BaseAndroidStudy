package com.siberiadante.customview.turntableview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;


public class LightView extends FrameLayout {

    //扇形颜色
    private Integer[] lightColor1 = new Integer[]{
            Color.parseColor("#ffffff"),
            Color.parseColor("#ff40a0"),
            Color.parseColor("#feec2a")};

    private Integer[] lightColor2 = new Integer[]{
            Color.parseColor("#ff40a0"),
            Color.parseColor("#feec2a"),
            Color.parseColor("#ffffff")};

    private Integer[] lightColor3 = new Integer[]{
            Color.parseColor("#feec2a"),
            Color.parseColor("#ffffff"),
            Color.parseColor("#ff40a0")};

    private int mCount = 12;
    private Paint mLightPaint;//绘制扇形
    private int mRadius;

    public int lightDrawCount = 1;

    public LightView(Context context) {
        this(context, null);
    }

    public LightView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LightView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mLightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int width = getDefaultSize(getSuggestedMinimumWidth(),
                widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        mRadius = width / 2;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float sweepAngle = 360.0f / mCount;
        float startAngle = 0;
        Integer[] lightColor;
        if (lightDrawCount % 3 == 0) {
            lightColor = lightColor1;
        } else if (lightDrawCount % 3 == 1) {
            lightColor = lightColor2;
        } else {
            lightColor = lightColor3;
        }
        lightDrawCount++;
        for (int i = 0; i < mCount; i++) {
            mLightPaint.setColor(lightColor[i % 3]);
            canvas.save();
            canvas.rotate(startAngle, mRadius, mRadius);
            canvas.drawCircle(dp2px(14), mRadius, dp2px(6), mLightPaint);
            canvas.restore();
            startAngle += sweepAngle;
        }
    }

    public int dp2px(final float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
