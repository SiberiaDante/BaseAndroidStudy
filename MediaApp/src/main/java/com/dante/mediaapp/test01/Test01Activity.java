package com.dante.mediaapp.test01;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dante.mediaapp.R;
import com.dante.mediaapp.util.GlideEngine;
import com.luck.picture.lib.PictureSelectionModel;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class Test01Activity extends AppCompatActivity {

    public static final String TAG = Test01Activity.class.getSimpleName();
    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test01);

        iv1 = findViewById(R.id.iv1);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestAlbumPermissions();
            }
        });
    }

    private void requestAlbumPermissions() {
        final RxPermissions rxPermissions = new RxPermissions(this);
        Disposable subscribe = rxPermissions
                .request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean granted) throws Exception {
                        if (granted) {
                            iv1.post(new Runnable() {
                                @Override
                                public void run() {
                                    openAlbum();
                                }
                            });
                        }
                    }
                });
    }

    //相册选择
    private void openAlbum() {
        PictureSelector pictureSelector = PictureSelector.create(this);
        PictureSelectionModel gallery = pictureSelector.openGallery(PictureMimeType.ofImage());
        gallery.selectionMode(PictureConfig.SINGLE);
        PictureWindowAnimationStyle windowAnimationStyle = new PictureWindowAnimationStyle();
        windowAnimationStyle.ofAllAnimation(R.anim.picture_anim_up_in, R.anim.picture_anim_down_out);

        gallery.loadImageEngine(GlideEngine.createGlideEngine())// 外部传入图片加载引擎，必传项
                .setPictureWindowAnimationStyle(windowAnimationStyle)
                .compress(true)// 是否压缩
                .enableCrop(false)// 是否裁剪。
                .previewImage(true)// 是否可预览图片
                .forResult(0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (RESULT_OK == resultCode) {
            if (0 == requestCode) {
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                String path = selectList.get(0).getRealPath();
                Log.d(TAG, "onActivityResult: path=" + path);
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                ImageView iv1 = findViewById(R.id.iv1);
                iv1.setImageBitmap(bitmap);
            }
        }
    }
}
