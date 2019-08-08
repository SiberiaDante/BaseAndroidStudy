package com.dante.customview.turntableview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.dante.customview.R;
import com.dante.customview.turntableview.model.TurnItemModel;

import java.util.List;


public class TurnAwardView extends FrameLayout {

    private TurnView turnView;
    private LightView lightView;

    private boolean isRunning = false;

    private int width = dp2px(264);
    private int padding = dp2px(56);


    private int toPosition;

    public TurnAwardView(Context context) {
        this(context, null);
    }

    public TurnAwardView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TurnAwardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        lightView = new LightView(getContext());
        lightView.setBackgroundResource(R.mipmap.bg_turn_view_ring);
        LayoutParams lightViewLayoutParams = new LayoutParams(width, width);
        lightViewLayoutParams.gravity = Gravity.CENTER;
        addView(lightView, lightViewLayoutParams);

        turnView = new TurnView(getContext());
        turnView.setBackgroundColor(Color.TRANSPARENT);
        LayoutParams pieViewLayoutParams = new LayoutParams(width - padding, width - padding);
        pieViewLayoutParams.gravity = Gravity.CENTER;
        addView(turnView, pieViewLayoutParams);

        ImageView startImg = new ImageView(getContext());
        startImg.setImageResource(R.mipmap.icon_turn_start);
        LayoutParams layoutParams = new LayoutParams(dp2px(108), dp2px(108));
        layoutParams.gravity = Gravity.CENTER;
        addView(startImg, layoutParams);

        startImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.start();
                }
            }
        });
    }

    public void startRotate() {
        if (isRunning) {
            return;
        }
        isRunning = true;
        float sweepDegree = 360.0f / turnView.getCount();
        float toDegree = 360f * 5 + (sweepDegree * (turnView.getCount() - toPosition)) - sweepDegree / 2;
        ObjectAnimator animator = ObjectAnimator.ofFloat(turnView, "rotation", 0, toDegree);
        animator.setDuration(3000);
        animator.setRepeatCount(0);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setAutoCancel(true);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            float lastAnimatedFraction;

            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (animatedFraction - lastAnimatedFraction > 0.02) {
                    lightView.postInvalidate();
                    lastAnimatedFraction = animatedFraction;
                }
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isRunning = false;
                if (listener != null) {
                    listener.end();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                isRunning = false;
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                isRunning = false;
            }
        });
    }


    public void updateTurnAwardView(List<TurnItemModel> desc) {
        turnView.setDesc(desc);
    }

    public void updateTurnAwardView(int toPosition) {
        this.toPosition = toPosition;
    }

    private TurnAwardListener listener;

    public void setListener(TurnAwardListener listener) {
        this.listener = listener;
    }

    public interface TurnAwardListener {
        void start();

        void end();
    }


    public int dp2px(final float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
