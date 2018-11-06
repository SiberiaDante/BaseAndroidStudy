package com.siberiadante.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.siberiadante.customview.hencoder.HenCoderActivity;
import com.siberiadante.customview.hencoder.Practice1Activity;
import com.siberiadante.customview.hencoder.Practice2Activity;
import com.siberiadante.customview.hencoder.Practice3Activity;
import com.siberiadante.customview.hencoder.Practice4Activity;
import com.siberiadante.customview.hencoder.Practice5Activity;
import com.siberiadante.customview.hencoder.Practice6Activity;
import com.siberiadante.customview.hencoder.Practice7Activity;
import com.siberiadante.customview.hencoder.layout1.LayoutSquarImageViewActivity;
import com.siberiadante.customview.radarview.RadarViewActivity;
import com.siberiadante.customview.view.TurnTableActivity;
import com.siberiadante.customview.widget.foldtext.FoldTextViewActivity;

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
        }

    }
}
