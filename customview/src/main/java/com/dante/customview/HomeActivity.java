package com.dante.customview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.dante.customview.drawtest.eventdispatch.EventDispatchActivity;
import com.dante.customview.hencoder.HenCoderActivity;
import com.dante.customview.hencoder.layout1.LayoutSquarImageViewActivity;
import com.dante.customview.radarview.RadarViewActivity;
import com.dante.customview.turntableview.TurnTableActivity;
import com.dante.customview.widget.foldtext.FoldTextViewActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.btn_hencoder).setOnClickListener(this);
        findViewById(R.id.btn_radar).setOnClickListener(this);

        findViewById(R.id.btn_fold_text).setOnClickListener(this);
        findViewById(R.id.btn_wheel_view).setOnClickListener(this);
        findViewById(R.id.btn_layout1).setOnClickListener(this);
        findViewById(R.id.btnEventDispatch).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hencoder:
                startActivity(new Intent(this, HenCoderActivity.class));
                break;
            case R.id.btn_radar:
                startActivity(new Intent(this, RadarViewActivity.class));
                break;
            case R.id.btn_fold_text:
                startActivity(new Intent(this, FoldTextViewActivity.class));
                break;
            case R.id.btn_wheel_view:
                startActivity(new Intent(this, TurnTableActivity.class));
                break;
            case R.id.btn_layout1:
                startActivity(new Intent(this, LayoutSquarImageViewActivity.class));
                break;
            case R.id.btnEventDispatch:
                startActivity(new Intent(this, EventDispatchActivity.class));
                break;
        }

    }
}
