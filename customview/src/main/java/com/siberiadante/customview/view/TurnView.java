package com.siberiadante.customview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;


import com.siberiadante.customview.R;

import java.util.List;

/**
 * Created by chenzipeng on 2018/7/27.
 * function:
 */
public class TurnView extends FrameLayout {

    private List<TurnItemModel> desc;

    //扇形颜色
    private Integer[] sectorColor = new Integer[]{
            Color.parseColor("#988dff"), Color.parseColor("#c388ff")
            , Color.parseColor("#ff85bd"), Color.parseColor("#ff714e")
            , Color.parseColor("#ffcf1a"), Color.parseColor("#a9c82a")
            , Color.parseColor("#25c2ff")};

    private int mCount = sectorColor.length;
    private Paint mArcPaint;//绘制扇形
    private Paint mTextPaint;//绘制文字
    private int mRadius;

    private RectF sectorRectF;
    private float startAngle;
    private float sweepAngle;

    public TurnView(Context context) {
        this(context, null);
    }

    public TurnView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TurnView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTypeface(Typeface.DEFAULT);
        mTextPaint.setLetterSpacing(0.3f);
//        mTextPaint.setTextSize(ResUtil.getDimen(R.dimen.sp_13));
        mTextPaint.setTextSize(13);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int width = getDefaultSize(getSuggestedMinimumWidth(),
                widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        int padding = getPaddingLeft();
        mRadius = width / 2 - padding;
        sectorRectF = new RectF(padding, padding, width - padding, width - padding);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        sweepAngle = 360.0f / mCount;
        startAngle = -89;
        for (int i = 0; i < mCount; i++) {
            mArcPaint.setColor(sectorColor[i]);
            canvas.drawArc(sectorRectF, startAngle, sweepAngle, true, mArcPaint);
            startAngle += sweepAngle;
        }

        if (desc != null && !desc.isEmpty()) {
            startAngle = -89;
            for (int i = 0; i < mCount; i++) {
                drawTexts(canvas, desc.get(i));
                startAngle += sweepAngle;
            }
        }
    }


    private void drawTexts(Canvas canvas, TurnItemModel itemModel) {
        Path path = new Path();
        //添加一个圆弧的路径
        path.addArc(sectorRectF, startAngle, sweepAngle);
        int lipoCoin = itemModel.getLipoCoin();
        String startText;
        String endText;

        startText = itemModel.getTitle().substring(0, 4);
        endText = "人民币" + lipoCoin;
        int startOffset = (int) (mRadius * 2 * Math.PI / mCount / 2 - mTextPaint.measureText(startText) / 2);
        canvas.drawTextOnPath(startText, path, startOffset, dp2px(22), mTextPaint);

        int endOffset = (int) (mRadius * 2 * Math.PI / mCount / 2 - mTextPaint.measureText(endText) / 2);
        canvas.drawTextOnPath(endText, path, endOffset, dp2px(36), mTextPaint);


//
//        if (lipoCoin > 0) {
//            startText = "钻石";
//            endText = "X" + lipoCoin;
//
//            int startOffset = (int) (mRadius * 2 * Math.PI / mCount / 2 - mTextPaint.measureText(startText) / 2);
//            canvas.drawTextOnPath(startText, path, startOffset, dp2px(22), mTextPaint);
//
//            int endOffset = (int) (mRadius * 2 * Math.PI / mCount / 2 - mTextPaint.measureText(endText) / 2);
//            canvas.drawTextOnPath(endText, path, endOffset, dp2px(36), mTextPaint);
//
//        } else {
//            int length = itemModel.getTitle().length();
//            if (length > 4) {
//                startText = itemModel.getTitle().substring(0, 4);
//                endText = itemModel.getTitle().substring(4, length);
//
//                int startOffset = (int) (mRadius * 2 * Math.PI / mCount / 2 - mTextPaint.measureText(startText) / 2);
//                canvas.drawTextOnPath(startText, path, startOffset, dp2px(22), mTextPaint);
//
//                int endOffset = (int) (mRadius * 2 * Math.PI / mCount / 2 - mTextPaint.measureText(endText) / 2);
//                canvas.drawTextOnPath(endText, path, endOffset, dp2px(36), mTextPaint);
//            } else {
//                startText = itemModel.getTitle();
//
//                int startOffset = (int) (mRadius * 2 * Math.PI / mCount / 2 - mTextPaint.measureText(startText) / 2);
//                canvas.drawTextOnPath(startText, path, startOffset, dp2px(30), mTextPaint);
//            }
//        }

    }

    public void setDesc(List<TurnItemModel> desc) {
        this.desc = desc;
        postInvalidate();
    }

    public int dp2px(final float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public int getCount() {
        return mCount;
    }

    public float getScale() {
        TextView textView = new TextView(getContext());
        textView.setTextSize(1);
        return textView.getTextSize();
    }
}
