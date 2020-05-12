package com.dante.customview.hencoder.practice6.practice;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.dante.customview.R;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;
    private MineHandler mineHandler;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    boolean animated;

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mineHandler = new MineHandler();
        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，同时对多个属性做动画
                mineHandler.removeCallbacksAndMessages(null);
                Message msg = new Message();
                msg.what = 0;
                mineHandler.sendMessage(msg);
            }
        });
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mineHandler = null;
    }

    public class MineHandler extends Handler {

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    doAnim();
                    Message msg1 = new Message();
                    msg1.what = 0;
                    sendMessageDelayed(msg1, 1000);
                    break;
            }
        }
    }

    private void doAnim() {
        if (!animated) {
            imageView.animate()
//                    .translationX(Utils.dpToPixel(200))
                    .rotation(360)
                    .scaleX(1)
                    .scaleY(1)
                    .alpha(1);
        } else {
            imageView.animate()
//                    .translationX(0)
                    .rotation(0)
                    .scaleX(0)
                    .scaleY(0)
                    .alpha(0);
        }
        animated = !animated;
    }
}
