package com.dante.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.dante.bas.R;

public class GifPlayActivity extends AppCompatActivity {

    private String gifUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1562575752773&di=9afab789d6355e04e43d4d8f1d4d0fbb&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201411%2F20%2F20141120173952_KcQWz.thumb.224_0.gif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_play);

    }

    private void loadNormal() {
        ImageView ivNormal = findViewById(R.id.ivNormal);
        Glide.with(this).asGif().load(gifUrl).into(ivNormal);
    }
    private void loadReverse(){
        ImageView ivReverse = findViewById(R.id.ivReverse);

    }


}
