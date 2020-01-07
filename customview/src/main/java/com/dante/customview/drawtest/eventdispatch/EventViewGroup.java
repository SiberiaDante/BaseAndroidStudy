package com.dante.customview.drawtest.eventdispatch;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class EventViewGroup extends LinearLayout {
    public static final String TAG = EventViewGroup.class.getSimpleName();

    public EventViewGroup(Context context) {
        super(context);
    }

    public EventViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EventViewGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent: ");
        return super.dispatchTouchEvent(ev);
//        return true;//ViewGroup消费事件
//        return false;//Activity执行onTouchEvent
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onInterceptTouchEvent: ");
        return super.onInterceptTouchEvent(ev);//向下分发
//        return false;//向下分发
//        return true;//拦截分发，ViewGroup执行onTouchEvent事件
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: ");
        return super.onTouchEvent(event);
//        return true;//消费
//        return false;//Activity 执行onTouchEvent
    }
}
