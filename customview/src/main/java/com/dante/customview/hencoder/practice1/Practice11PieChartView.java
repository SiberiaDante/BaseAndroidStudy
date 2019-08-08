package com.dante.customview.hencoder.practice1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.dante.customview.R;
import com.dante.customview.util.Utils;

import java.util.ArrayList;

public class Practice11PieChartView extends View {

    private ArrayList<DataBean> dataBeans;
    private Paint paint;
    private float centerX;
    private float centerY;
    private RectF rectF;

    public Practice11PieChartView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        dataBeans = new ArrayList<>();
        dataBeans.add(new DataBean("Kotlin", 30, Color.BLUE));
        dataBeans.add(new DataBean("PHP", 10, Color.GRAY));
        dataBeans.add(new DataBean("PHP", 60, Color.GREEN));
        dataBeans.add(new DataBean("Python", 20, Color.YELLOW));
        dataBeans.add(new DataBean("C++", 90, Color.WHITE));
        dataBeans.add(new DataBean("Java", 150, Color.RED));

        paint = new Paint();
        rectF = new RectF();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);


        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = Utils.getScreenHeightPx();
        int actionBarPx = Utils.getActionBarSize(context);
        int statusBarHeight = Utils.getStatuBarHeight();
        float tabHeight = getResources().getDimension(R.dimen.tab_bar_height);
        centerX = widthPixels / 2;
        centerY = (heightPixels - statusBarHeight - actionBarPx - tabHeight) / 4;
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        float radius = centerY / 3 * 2;
        float startSweep = -45;
        float spaceSweep = 3;
        rectF.left = centerX - radius;
        rectF.top = centerY - radius;
        rectF.right = centerX + radius;
        rectF.bottom = centerY + radius;

        for (int i = 0; i < dataBeans.size(); i++) {
            paint.setColor(dataBeans.get(i).getColor());

            //最后一个上移
            if (i == dataBeans.size() - 1) {
                canvas.save();//上移之前保存原来的数据
                canvas.translate(-5, -10);
                canvas.drawArc(rectF, startSweep, dataBeans.get(i).getPercent() - spaceSweep, true, paint);
                //上移绘制完成后回退到上一次保存的状态
                canvas.restore();
            } else
                canvas.drawArc(rectF, startSweep, dataBeans.get(i).getPercent() - spaceSweep, true, paint);
            startSweep += dataBeans.get(i).getPercent();
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
