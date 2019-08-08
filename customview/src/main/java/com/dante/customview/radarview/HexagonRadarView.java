package com.dante.customview.radarview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.dante.customview.util.TransitionUtil;
/**
 * create date: 2018/8/29
 * 六边形雷达
 * https://github.com/xurui1995/Radar/blob/master/app/src/main/java/com/example/xw/radar/MyRadar.java
 * https://www.cnblogs.com/xurui1995/p/5917218.html
 */
public class HexagonRadarView extends View {

    public static final String TAG = HexagonRadarView.class.getSimpleName();
    private float radius;//雷达最大半径
    private int centerX;//画布中心X
    private int centerY;//画布中心Y

    private int maxLineCount = 6;

    private Paint mLinePaint;//网格线
    private Paint textPaint;//绘制文字
    private Paint valuePaint;//绘制文字
    private float angle = (float) (2 * Math.PI / maxLineCount);//弧度
    private String[] titles = {"Java", "Python", "Kotlin", "PHP", "C++", "C"};
    private double[] data = {100, 50, 50, 100, 50, 50}; //默认数据
    private float maxValue = 100;
    private int mWidth = 0, mHeight = 0;

    public HexagonRadarView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mLinePaint = new Paint();
        mLinePaint.setColor(Color.BLACK);
        mLinePaint.setStrokeWidth(1);
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStyle(Paint.Style.STROKE);

        textPaint = new Paint();
        textPaint.setColor(Color.RED);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(TransitionUtil.sp2px(getContext(), 14));
        textPaint.setStyle(Paint.Style.STROKE);

        valuePaint = new Paint();
        valuePaint.setAntiAlias(true);
        valuePaint.setColor(Color.BLUE);
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public HexagonRadarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HexagonRadarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        radius = Math.min(w, h) / 2 * 0.6f;
        centerX = w / 2;
        centerY = h / 2;
        mWidth = w;
        mHeight = h;
        postInvalidate();
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawHexagon(canvas);
        drawText(canvas);
        drawRegion(canvas);
    }

    private void drawHexagon(Canvas canvas) {
        Path path = new Path();
        float r = radius / (maxLineCount - 1);
        //画雷达线
        for (int i = 0; i < maxLineCount; i++) {
            float R = r * i;
            path.reset();
            for (int j = 0; j < maxLineCount; j++) {
                if (j == 0) {
                    path.moveTo(centerX + R, centerY);
                } else {
                    float x = (float) (centerX + R * Math.cos(angle * j));
                    float y = (float) (centerY + R * Math.sin(angle * j));
                    path.lineTo(x, y);
                }
            }

            path.close();
            canvas.drawPath(path, mLinePaint);

        }
        //画连接线
        for (int i = 0; i < maxLineCount; i++) {
            path.reset();
            path.moveTo(centerX, centerY);
            float x = (float) (centerX + radius * Math.cos(angle * i));
            float y = (float) (centerY + radius * Math.sin(angle * i));
            path.lineTo(x, y);
            canvas.drawPath(path, mLinePaint);
        }

    }

    private void drawText(Canvas canvas) {

        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float fontHeight = fontMetrics.descent - fontMetrics.ascent;
        for (int i = 0; i < maxLineCount; i++) {
            float x = (float) (centerX + (radius + fontHeight / 2) * Math.cos(angle * i));
            float y = (float) (centerY + (radius + fontHeight / 2) * Math.sin(angle * i));

            if (angle * i >= 0 && angle * i <= Math.PI / 2) {//右边
                canvas.drawText(titles[i], x, y + fontHeight / 2, textPaint);
            } else if (angle * i > Math.PI / 2 && angle * i <= Math.PI) {
                float dis = textPaint.measureText(titles[i]);
                canvas.drawText(titles[i], x - dis, y + fontHeight / 2, textPaint);
            } else if (angle * i > Math.PI && angle * i < 3 * Math.PI / 2) {
                float dis = textPaint.measureText(titles[i]);
                canvas.drawText(titles[i], x - dis, y, textPaint);
            } else if (angle * i >= 3 * Math.PI / 2 && angle * i <= Math.PI * 2) {
                canvas.drawText(titles[i], x, y, textPaint);
            }
        }
    }

    private void drawRegion(Canvas canvas) {
        Path path = new Path();
        valuePaint.setAlpha(255);
        for (int i = 0; i < maxLineCount; i++) {
            double percent = data[i] / maxValue;
            float x = (float) (centerX + radius * Math.cos(angle * i) * percent);
            float y = (float) (centerY + radius * Math.sin(angle * i) * percent);
            if (i == 0) {
                path.moveTo(x, centerY);
            } else {
                path.lineTo(x, y);
            }
            canvas.drawCircle(x, y, 5, valuePaint);
        }
        path.close();
        valuePaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, valuePaint);
        //绘制填充区域
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        valuePaint.setAlpha(127);
        canvas.drawPath(path, valuePaint);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, mHeight);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, mHeight);
        }
    }

    public void setData(double[] data) {
        this.data = data;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(float maxValue) {
        this.maxValue = maxValue;
    }

    public void setTextPaintColor(int color) {
        textPaint.setColor(color);
    }

    public void setValuePaintColor(int color) {
        valuePaint.setColor(color);
    }

    public void setMainPaintColor(int color) {
        mLinePaint.setColor(color);
    }
}
