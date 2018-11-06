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

public class Practice6DrawLineView extends View {
    private Paint paint;
    private float centerX;
    private float centerY;

    public Practice6DrawLineView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        paint = new Paint();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);

        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = Utils.getScreenHeightPx();
        int actionBarPx = Utils.getActionBarSize(context);
        int statusBarHeight = Utils.getStatuBarHeight();
        float tabHeight = getResources().getDimension(R.dimen.tab_bar_height);
        centerX = widthPixels / 2;
        centerY = (heightPixels - statusBarHeight - actionBarPx - tabHeight) / 4;
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线
//        canvas.drawLine(100,100,500,500,paint);
        canvas.drawLine(centerX / 3, centerY / 3, centerX / 2 * 3, centerY / 2 * 3, paint);
    }
}
