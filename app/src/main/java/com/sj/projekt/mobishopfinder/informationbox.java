package com.sj.projekt.mobishopfinder;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class informationbox extends AppCompatActivity {
    Button FeedBack;
    final Context c = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informationbox);
        FeedBack = findViewById(R.id.FeedBack);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

            int width = dm.widthPixels;
            int height = dm.heightPixels;


        getWindow().setLayout((int)(width*.8),(int)(height*.6));
        FeedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               FeedBack fb = new FeedBack();
               fb.DialogBox(c);
            }
        });
    }
}
