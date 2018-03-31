package com.sj.projekt.mobishopfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class topten extends AppCompatActivity implements View.OnClickListener {

    private Button top_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topten);


        top_10 = (Button) findViewById(R.id.top_10);



        top_10.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,Topten_content.class);
        startActivity(intent);


    }
}
