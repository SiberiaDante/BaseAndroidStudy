package com.siberiadante.designpattern.prototype.simple;

import android.util.Log;

import java.util.ArrayList;

/**
 * create date: 2018/8/3
 */
public class WordDocument implements Cloneable {
    public static final String TAG = WordDocument.class.getSimpleName();

    private String mText;
    private ArrayList<String> mImages = new ArrayList<>();

    public WordDocument() {
        Log.e(TAG, "--------WordDocument---------");
    }

    @Override
    public WordDocument clone() throws CloneNotSupportedException {
        try {
            WordDocument doc = (WordDocument) super.clone();
            doc.mText = this.mText;
            doc.mImages = (ArrayList<String>) this.mImages.clone();
            return doc;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showDoc() {
        Log.e(TAG, "--------mText---------" + mText);

        for (String img : mImages) {
            System.out.print("---------------:" + img);
            Log.e(TAG, "--------img---------" + img);

        }
    }

    public String getmText() {
        return mText == null ? "" : mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public ArrayList<String> getmImages() {
        if (mImages == null) {
            return new ArrayList<>();
        }
        return mImages;
    }

    public void setmImages(ArrayList<String> mImages) {
        this.mImages = mImages;
    }

    public void addImgName(String name) {
        this.mImages.add(name);
    }
}
