package com.siberiadante.customview.hencoder.layout1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.siberiadante.customview.R;

public class LayoutSquarImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_squar_image_view);
        AppCompatSeekBar seekBarwidth = findViewById(R.id.seek_bar_width);
        AppCompatSeekBar seekBarHeight = findViewById(R.id.seek_bar_height);
        final LinearLayout llContent = findViewById(R.id.ll_content);
        final ViewGroup.LayoutParams contentLayoutParams = llContent.getLayoutParams();
        int width = 0;
        int height = 0;
        seekBarwidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                contentLayoutParams.width = progress * 10 + 80;
                llContent.setLayoutParams(contentLayoutParams);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                contentLayoutParams.height = progress * 20 + 80;
                llContent.setLayoutParams(contentLayoutParams);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        llContent.post(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG", "-----run-----llContent.getX():" + llContent.getX());
            }
        });
    }
}
