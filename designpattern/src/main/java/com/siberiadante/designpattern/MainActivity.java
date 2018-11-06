package com.siberiadante.designpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.siberiadante.designpattern.prototype.simple.WordDocument;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TestBuilder testBuilder = new TestBuilder();
//        new MacBookBuilder().setDisplay("sssssssssss").setKeyboard("xxxxxxxxxxxxxxxx").setOs().create();


        WordDocument wordDocument = new WordDocument();
        wordDocument.setmText("哈哈哈哈哈");
        wordDocument.addImgName("图片1");
        wordDocument.addImgName("图片2");
        wordDocument.addImgName("图片3");
        wordDocument.addImgName("图片4");
        wordDocument.showDoc();
        WordDocument clone = null;
        try {
            clone = wordDocument.clone();
            clone.setmText("呵呵呵呵呵");
            clone.showDoc();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        wordDocument.showDoc();

        assert clone != null;
        clone.addImgName("图片&");
        clone.showDoc();
        wordDocument.showDoc();

    }
}
