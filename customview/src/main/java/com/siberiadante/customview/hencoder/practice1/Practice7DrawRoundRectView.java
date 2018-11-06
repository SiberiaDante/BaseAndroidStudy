package com.siberiadante.customview.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.siberiadante.customview.R;
import com.siberiadante.customview.util.Utils;

public class Practice7DrawRoundRectView extends View {
    private Paint paint;
    private float centerX;
    private float centerY;
    private RectF rectF;

    public Practice7DrawRoundRectView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        rectF = new RectF();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);

        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = Utils.getScreenHeightPx();
        int actionBarPx = Utils.getActionBarSize(context);
        int statusBarHeight = Utils.getStatuBarHeight();
        float tabHeight = getResources().getDimension(R.dimen.tab_bar_height);
        centerX = widthPixels / 2;
        centerY = (heightPixels - statusBarHeight - actionBarPx - tabHeight) / 4;
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
        rectF.left = centerX / 2;
        rectF.top = centerY / 2;
        rectF.right = centerX / 2 * 3;
        rectF.bottom = centerY / 2 * 3;
        canvas.drawRoundRect(rectF, 50, 50, paint);
//        canvas.drawRoundRect(centerX / 2, centerY / 2, centerX / 2 * 3, centerY / 2 * 3, 20, 20, paint);
    }
}
