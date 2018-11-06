package com.siberiadante.customview.hencoder.practice2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.siberiadante.customview.R;


public class Practice06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    /*
    R' = R * mul.R/0xff + add.R
    G' = G * mul.G/0xff + add.G
    B' = B * mul.B/0xff + add.B
    good time ;i wake up at tonight,it's always good time ,we don't even have to try,
   */
    private ColorFilter colorFilter = new LightingColorFilter(0x00ffff, 0x000000);
    private ColorFilter colorFilter1 = new LightingColorFilter(0xffffff, 0x003000);
    private ColorFilter colorFilter2 = new PorterDuffColorFilter(0x003000, PorterDuff.Mode.DARKEN);

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }

    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        // 第一个 LightingColorFilter：去掉红色部分
        paint.setColorFilter(colorFilter);
        canvas.drawBitmap(bitmap, 0, 0, paint);
//about where we begain,see you again ,when you
        // 第二个 LightingColorFilter：增强绿色部分
        paint.setColorFilter(colorFilter1);
//        paint.setColorFilter(colorFilter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
}
