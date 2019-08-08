package com.dante.customview.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.dante.customview.R;
import com.dante.customview.util.Utils;

public class Practice5DrawOvalView extends View {
    private Paint paint;
    private RectF rect;
    private float centerX;
    private float centerY;

    public Practice5DrawOvalView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        rect = new RectF();
        paint = new Paint();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);

        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = getResources().getDisplayMetrics().heightPixels;
        int actionBarPx = Utils.getActionBarSize(context);
        int statusBarHeight = Utils.getStatuBarHeight();
        float tabHeight = getResources().getDimension(R.dimen.tab_bar_height);
        centerX = widthPixels / 2f;
        centerY = (heightPixels - statusBarHeight - actionBarPx - tabHeight) / 4;
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawOval() 方法画椭圆
        float left = centerX / 2;
        float top = centerY / 2;
        float right = centerX / 2 * 3;
        float bottom = centerY / 2 * 3;
        rect.left = left;
        rect.top = top;
        rect.right = right;
        rect.bottom = bottom;
        canvas.drawOval(rect, paint);
//        canvas.drawOval(left, top, right, bottom, paint);
    }
}
