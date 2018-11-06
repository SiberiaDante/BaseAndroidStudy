package com.siberiadante.customview.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.siberiadante.customview.R;
import com.siberiadante.customview.util.Utils;

import java.util.ArrayList;

public class Practice10HistogramView extends View {

    private static final String TAG = Practice10HistogramView.class.getSimpleName();
    private ArrayList<DataBean> dataBeans;
    private Paint paint;
    private Paint paintText;
    private Paint paintLine;
    private Path path;
    private float centerX;
    private float centerY;
    private RectF rectF;
    private int lineWidth = 2;
    private RectF rectF2;

    public Practice10HistogramView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        dataBeans = new ArrayList<>();
        dataBeans.add(new DataBean("Kotlin", 1, Color.BLUE));
        dataBeans.add(new DataBean("PHP", 4, Color.GRAY));
        dataBeans.add(new DataBean("PHP", 50, Color.GREEN));
        dataBeans.add(new DataBean("Python", 10, Color.YELLOW));
        dataBeans.add(new DataBean("Java", 20, Color.RED));
        dataBeans.add(new DataBean("Java", 80, Color.WHITE));

        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = Utils.getScreenHeightPx();
        int actionBarPx = Utils.getActionBarSize(context);
        int statusBarHeight = Utils.getStatuBarHeight();
        float tabHeight = getResources().getDimension(R.dimen.tab_bar_height);
        centerX = widthPixels / 2;
        centerY = (heightPixels - statusBarHeight - actionBarPx - tabHeight) / 4;

        path = new Path();
        paintLine = new Paint();
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setStrokeWidth(lineWidth);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        paintText = new Paint();
        paintText.setAntiAlias(true);
        paintText.setColor(Color.WHITE);
        paintText.setTextSize(22);
        paintText.setTextAlign(Paint.Align.CENTER);
        rectF = new RectF();

    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas|.drawXXX() 方法画直方图
        //顶点
        float realTX = centerX / 3;
        float realTY = centerY / 3;

        //坐标圆点
        float realCX = centerX / 3;
        float realCY = centerY / 3 * 5;

        //Y轴右端点
        float realRX = centerX / 3 * 5;
        float realRY = centerY / 3 * 5;

        //画X和Y轴
        path.moveTo(realTX, realTY);
        path.lineTo(realCX, realCY);
        path.lineTo(realRX, realRY);
        canvas.drawPath(path, paintLine);


        float allWidth = realRX - realCX;
        float allHeight = realCY - realTY;
        float singleWidth = 100;
        float spaceWidth = (allWidth - singleWidth * dataBeans.size()) / (dataBeans.size() + 1);

        for (DataBean dataBean : dataBeans) {
            paint.setColor(dataBean.getColor());

            rectF.left = realTX + spaceWidth;
            rectF.top = realTY + allHeight * ((100 - dataBean.getPercent()) / 100);
            rectF.right = realTX + singleWidth + spaceWidth;
            rectF.bottom = realCY - lineWidth;
            realTX = realTX + singleWidth + spaceWidth;//记录位置
            canvas.drawRect(rectF, paint);
            canvas.drawText(dataBean.getName(), rectF.left + 50, 30 + rectF.bottom + lineWidth * 2, paintText);
        }

    }

    private class DataBean {
        private String name;
        private float percent;
        private int color;

        public DataBean(String name, float percent, int color) {
            this.name = name;
            this.percent = percent;
            this.color = color;
        }

        public String getName() {
            return name == null ? "" : name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getPercent() {
            return percent;
        }

        public void setPercent(float percent) {
            this.percent = percent;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }
    }
}
