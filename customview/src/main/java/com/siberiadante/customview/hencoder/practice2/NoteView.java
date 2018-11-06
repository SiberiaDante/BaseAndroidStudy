package com.siberiadante.customview.hencoder.practice2;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @CreateTime: 2018/7/13
 * @UpDateTime:2018/7/13
 * @CreateBy:SiberiaDante
 * @Email:2654828081@qq.com
 * @Github:https://github.com/SiberiaDante
 * @Blog:http://www.cnblogs.com/shen-hua/
 * @Describe:
 */
public class NoteView extends View {
    public NoteView(Context context) {
        super(context);
    }

    public NoteView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NoteView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /*
        LinearGradient RadialGradient SweepGradient BitmapShader ComposeShader
         */
    }
}
