package com.siberiadante.bas;

import android.os.Bundle;
import android.view.View;

import com.siberiadante.activity.GifPlayActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListener();
    }

    private void initListener() {
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpActivity(GifPlayActivity.class);
            }
        });
    }


}
