package com.dante.bas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void jumpActivity(Class cls) {
        startActivity(new Intent(this, cls));
    }

}
