package com.siberiadante.customview.hencoder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.siberiadante.customview.R;

public class HenCoderActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hen_coder);

        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_seven).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                startActivity(new Intent(this, Practice1Activity.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(this, Practice2Activity.class));
                break;
            case R.id.btn_three:
                startActivity(new Intent(this, Practice3Activity.class));
                break;
            case R.id.btn_four:
                startActivity(new Intent(this, Practice4Activity.class));
                break;
            case R.id.btn_five:
                startActivity(new Intent(this, Practice5Activity.class));
                break;
            case R.id.btn_six:
                startActivity(new Intent(this, Practice6Activity.class));
                break;
            case R.id.btn_seven:
                startActivity(new Intent(this, Practice7Activity.class));
                break;
        }

    }
}
