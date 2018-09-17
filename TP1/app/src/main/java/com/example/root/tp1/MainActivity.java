package com.example.root.tp1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppBar bar = findViewById(R.id.appbar);
        bar.img_cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
        bar.img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ouverture de la liste des categories
                Intent next = new Intent(MainActivity.this, CategoriesActivity.class);
                startActivity(next);
            }
        });

        final FrameLayout like = findViewById(R.id.frame_like);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = findViewById(R.id.txt_like);
                ImageView iv = findViewById(R.id.img_like);
                int color;
                boolean isLiked = (tv.getCurrentTextColor() ==
                        getResources().getColor(R.color.txt_active));
                if(!isLiked) {
                    like.setBackground(getResources().getDrawable(R.drawable.layout_btn_active));
                    color = getResources().getColor(R.color.txt_active);
                } else {
                    like.setBackground(getResources().getDrawable(R.drawable.layout_btn));
                    color = getResources().getColor(R.color.txt_inactive);
                }
                tv.setTextColor(color);
                iv.setColorFilter(color);
            }
        });

        findViewById(R.id.frame_comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.edit_comment);
                editText.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        findViewById(R.id.img_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = ((EditText)findViewById(R.id.edit_comment)).getText().toString();
                System.out.println(comment);
                LinearLayout coms = findViewById(R.id.lay_com);
                if(!comment.equals("")) {
                    if(!(findViewById(R.id.txt_com_fill) == null)) {
                        coms.removeView(findViewById(R.id.txt_com_fill));
                    }
                    TextView com = new TextView(v.getContext());
                    com.setText(comment);
                    com.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    coms.addView(com);
                    ((EditText)findViewById(R.id.edit_comment)).setText("");
                }
            }
        });
    }
}
