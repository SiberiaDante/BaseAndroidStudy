package com.dante.customview.hencoder.practice2.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.dante.customview.R;


public class Sample06LightingColorFilterView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    /*
    R' = R * mul.R/0xff + add.R
    G' = G * mul.G/0xff + add.G
    B' = B * mul.B/0xff + add.B
     */
    ColorFilter colorFilter1 = new LightingColorFilter(0x00ffff, 0x000000);
    ColorFilter colorFilter2 = new LightingColorFilter(0xffffff, 0x003000);

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }

    public Sample06LightingColorFilterView(Context context) {
        super(context);
    }

    public Sample06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColorFilter(colorFilter1);
        canvas.drawBitmap(bitmap, 0, 0, paint);
/*
ffffff
RGB:255,255,255
 */
        paint.setColorFilter(colorFilter2);
        canvas.drawBitmap(bitmap, bitmap.getWidth() + 100, 0, paint);
    }
}
