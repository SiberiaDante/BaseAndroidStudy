package com.siberiadante.customview.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.siberiadante.customview.R;
import com.siberiadante.customview.util.Utils;

public class Practice9DrawPathView extends View {
    private Paint paint;
    private Path path;
    private float centerX;
    private float centerY;
    private RectF rectF1;
    private RectF rectF2;

    public Practice9DrawPathView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        rectF1 = new RectF();
        rectF2 = new RectF();
        path = new Path();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);

        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = Utils.getScreenHeightPx();
        int actionBarPx = Utils.getActionBarSize(context);
        int statusBarHeight = Utils.getStatuBarHeight();
        float tabHeight = getResources().getDimension(R.dimen.tab_bar_height);
        centerX = widthPixels / 2;
        centerY = (heightPixels - statusBarHeight - actionBarPx - tabHeight) / 4;
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        练习内容：使用 canvas.drawPath() 方法画心形
        rectF1.left = centerX - 200;
        rectF1.top = centerY - 200;
        rectF1.right = centerX;
        rectF1.bottom = centerY;

        rectF2.left = centerX;
        rectF2.top = centerY - 200;
        rectF2.right = centerX + 200;
        rectF2.bottom = centerY;

        path.addArc(rectF1, -225, 225);
        path.arcTo(rectF2, -180, 225);
        path.lineTo(centerX, centerY + 150);
        canvas.drawPath(path, paint);
    }
}
