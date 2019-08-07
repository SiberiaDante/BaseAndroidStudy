package com.siberiadante.customview.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.siberiadante.customview.R;
import com.siberiadante.customview.util.Utils;

public class Practice4DrawPointView extends View {
    private Paint paint1;
    private Paint paint2;
    private int widthPixels;
    private int heightPixels;
    private int actionBarPx;
    private int statusBarHeight;
    private float tabHeight;

    public Practice4DrawPointView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        paint1 = new Paint();
        paint2 = new Paint();

        paint1.setStyle(Paint.Style.FILL);
        paint1.setStrokeWidth(100);
        paint1.setColor(Color.BLACK);
        paint1.setAntiAlias(true);
        /*
        Cap.ROUND:端点圆头
        Cap.SQUARE:端点方头
        Cap.BUTT:端点平头
         */
        paint1.setStrokeCap(Paint.Cap.ROUND);


        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeWidth(100);
        paint2.setColor(Color.BLACK);
        paint2.setAntiAlias(true);
        /*
        Cap.ROUND:端点圆头
        Cap.SQUARE:端点方头
        Cap.BUTT:端点平头
         */
        paint2.setStrokeCap(Paint.Cap.SQUARE);

        widthPixels = getResources().getDisplayMetrics().widthPixels;
        heightPixels = getResources().getDisplayMetrics().heightPixels;
        actionBarPx = Utils.getActionBarSize(context);
        statusBarHeight = Utils.getStatuBarHeight();
        tabHeight = getResources().getDimension(R.dimen.tab_bar_height);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
        float centerX = widthPixels / 2;
        float centerY = (heightPixels - statusBarHeight - actionBarPx - tabHeight) / 4;
        canvas.drawPoint(centerX / 2, centerY, paint1);
        canvas.drawPoint(centerX / 2 * 3, centerY, paint2);
    }
}
