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

public class Practice8DrawArcView extends View {
    private Paint paint;
    private Paint paint1;
    private Paint paint2;
    private float centerX;
    private float centerY;
    private RectF rectF;

    public Practice8DrawArcView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint1 = new Paint();
        paint2 = new Paint();
        rectF = new RectF();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);

        paint1.setStyle(Paint.Style.STROKE);
        paint1.setColor(Color.BLACK);
        paint1.setAntiAlias(true);

        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.RED);
        paint2.setAntiAlias(true);

        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = Utils.getScreenHeightPx();
        int actionBarPx = Utils.getActionBarSize(context);
        int statusBarHeight = Utils.getStatuBarHeight();
        float tabHeight = getResources().getDimension(R.dimen.tab_bar_height);
        centerX = widthPixels / 2;
        centerY = (heightPixels - statusBarHeight - actionBarPx - tabHeight) / 4;
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        rectF.left = centerX / 2;
        rectF.top = centerY / 2;
        rectF.right = centerX / 2 * 3;
        rectF.bottom = centerY / 2 * 3;
        canvas.drawArc(rectF, 0, -120, true, paint);
        canvas.drawArc(rectF, -120, -60, false, paint1);
        canvas.drawArc(rectF, 0, 180, false, paint2);
//        canvas.drawArc(centerX / 2, centerY / 2, centerX / 2 * 3, centerY, 0, 90, true, paint);
    }
}
