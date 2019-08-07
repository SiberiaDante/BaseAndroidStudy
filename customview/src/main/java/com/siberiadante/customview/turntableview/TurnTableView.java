package com.siberiadante.customview.turntableview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.siberiadante.customview.R;
import com.siberiadante.customview.util.TransitionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * create date: 2018/8/31
 */
public class TurnTableView extends View {
    private int[] colors = {Color.RED, Color.BLUE, Color.BLACK, Color.GREEN, Color.GRAY, Color.DKGRAY};
    private String[] titles = {"一等奖", "二等奖", "三等奖", "四等奖", "五等奖", "六等奖"};
    private int[] imgs = {R.drawable.iphone, R.drawable.iphone, R.drawable.iphone, R.drawable.iphone, R.drawable.iphone, R.drawable.iphone};
    private List<Bitmap> bitmapList;
    private Paint mTextPaint;//文字
    private Paint mPaint;//扇形
    private Paint mOuterPaint;//圆环
    private int count = 6;
    private int outerRadius = 0;
    private int innerRadius = 0;
    private int centerX;
    private int centerY;
    private float singleAngle;
    private RectF rectF = new RectF();//扇形
    private RectF textRectF = new RectF();//扇形
    private Rect imgRec = new Rect();
    private Rect bitmapRect = new Rect();//外层圆环
    private Path textPath = new Path();//文字

    private int radiusSpace;//外层圆环高度
    private int mWidth, mHeight;
    private float startAngle;//开始绘制的度数
    private Bitmap circleBitmap;

    public TurnTableView(Context context) {
        super(context);
        init();
    }

    private void init() {
        singleAngle = 360 / count;
        startAngle = -90 - singleAngle / 2;
        radiusSpace = (int) TransitionUtil.dip2px(getContext(), 20);

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        mTextPaint = new Paint();
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setDither(true);
        mTextPaint.setTextSize(TransitionUtil.dpToPixel(16));

        mOuterPaint = new Paint();
        mOuterPaint.setColor(Color.RED);
        mOuterPaint.setStyle(Paint.Style.STROKE);
        mOuterPaint.setStrokeWidth(radiusSpace);
        mOuterPaint.setAntiAlias(true);

        circleBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_circle);
        bitmapList = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs[i]);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            imgRec.left = 0;
            imgRec.top = 0;
            imgRec.right = 0;
            imgRec.bottom = 0;
            Matrix matrix = new Matrix();
            matrix.postRotate(singleAngle * i);
            matrix.postScale(1f, 1f);
            Bitmap bitmapCreate = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            bitmapList.add(bitmapCreate);
        }
    }

    public TurnTableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TurnTableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TurnTableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < count; i++) {
            drawShanXin(i, canvas);
            drawText(i, canvas);
            drawImg(i, canvas);
            startAngle = startAngle + singleAngle;
        }
        bitmapRect.left = centerX - outerRadius;
        bitmapRect.top = centerY - outerRadius;
        bitmapRect.right = centerX + outerRadius;
        bitmapRect.bottom = centerY + outerRadius;
        //画外层圆环
        canvas.drawBitmap(circleBitmap, null, bitmapRect, mOuterPaint);
    }

    private void drawShanXin(int i, Canvas canvas) {
        rectF.left = centerX - innerRadius;
        rectF.top = centerY - innerRadius;
        rectF.right = centerX + innerRadius;
        rectF.bottom = centerY + innerRadius;
        mPaint.setColor(colors[i]);
        //画圆盘扇形
        canvas.drawArc(rectF, startAngle, singleAngle, true, mPaint);
    }

    private void drawText(int i, Canvas canvas) {
        textRectF.left = centerX - innerRadius;
        textRectF.top = centerY - innerRadius;
        textRectF.right = centerX + innerRadius;
        textRectF.bottom = centerY + innerRadius;
        textPath.addArc(textRectF, startAngle, singleAngle);
        textPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        float textWidth = mTextPaint.measureText(titles[i]);
        float hOffset = (float) (Math.sin(singleAngle * Math.PI / 360) * innerRadius) - textWidth / 2;
        //画文字
        canvas.drawTextOnPath(titles[i], textPath, hOffset, innerRadius / 4, mTextPaint);
        textPath.reset();
    }

    private void drawImg(int i, Canvas canvas) {
        int imgWidth = innerRadius / 3;
        //计算实际宽高
        int w = ( int ) (Math.abs(Math.cos(Math.toRadians(Math.abs(180 - singleAngle * i)))) *
                imgWidth + imgWidth * Math.abs(Math.sin(Math.toRadians(Math.abs(180 - singleAngle * i)))));
        int h = ( int ) (Math.abs(Math.sin(Math.toRadians(Math.abs(180 - singleAngle * i)))) *
                imgWidth + imgWidth * Math.abs(Math.cos(Math.toRadians(Math.abs(180 - singleAngle * i)))));

        float angle = ( float ) Math.toRadians(startAngle + singleAngle / 2);

        //确定图片在圆弧中 中心点的位置
        float x = ( float ) (mWidth / 2 + (innerRadius / 2 + innerRadius / 12) * Math.cos(angle));
        float y = ( float ) (mHeight / 2 + (innerRadius / 2 + innerRadius / 12) * Math.sin(angle));
        // 确定绘制图片的位置
        RectF rect1 = new RectF(x - w / 2, y - h / 2, x + w / 2, y + h / 2);
        canvas.drawBitmap(bitmapList.get(i), null, rect1, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getWidth() - getPaddingLeft() - getPaddingRight();
        mHeight = getHeight() - getPaddingTop() - getPaddingBottom();
        centerX = mWidth / 2;
        centerY = mHeight / 2;

        outerRadius = Math.min(mWidth / 2, mHeight / 2);
        innerRadius = outerRadius - radiusSpace;

    }
}
