package com.example.root.tp1;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AppBar extends LinearLayout {

    @StyleableRes
    int index0 = 0;
    @StyleableRes
    int index1 = 1;

    TextView txt_title;
    TextView txt_backTitle;
    ImageView img_back, img_cross;

    public AppBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.app_bar, this);

        int[] sets = {R.attr.txt_backTitle, R.attr.txt_title};
        TypedArray typedArray = context.obtainStyledAttributes(attrs, sets);
        CharSequence backTitle = typedArray.getText(index0);
        CharSequence title = typedArray.getText(index1);
        typedArray.recycle();

        initComponents();

        setTitleText(title);
        setBackTitleText(backTitle);
    }

    private void initComponents() {
        txt_title = findViewById(R.id.txt_title);
        txt_backTitle = findViewById(R.id.txt_backTitle);

        img_back = findViewById(R.id.img_back);
        img_cross = findViewById(R.id.img_cross);

    }

    public CharSequence getTitleText() {
        return txt_title.getText();
    }

    public void setTitleText(CharSequence value) {
        txt_title.setText(value);
    }

    public CharSequence getBackTitleText() {
        return txt_backTitle.getText();
    }

    public void setBackTitleText(CharSequence value) {
        txt_backTitle.setText(value);
    }
}

