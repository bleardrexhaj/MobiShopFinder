package com.sj.projekt.mobishopfinder.Qytetet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.sj.projekt.mobishopfinder.R;
import com.sj.projekt.mobishopfinder.tabbed;

public class Prizren extends AppCompatActivity implements View.OnClickListener {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Button prizren1, prizren2, prizren3;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prizren);


        prizren1 = findViewById(R.id.prizren1);
        prizren2 = findViewById(R.id.prizren2);
        prizren3 = findViewById(R.id.prizren3);


        prizren3.setOnClickListener(this);
        prizren2.setOnClickListener(this);
        prizren1.setOnClickListener(this);

    }


    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {

            case R.id.prizren1:
                i = new Intent(this, tabbed.class);
                startActivity(i);
                break;
            case R.id.prizren2:
                i = new Intent(this, tabbed.class);
                startActivity(i);
                break;
            case R.id.prizren3:
                i = new Intent(this, tabbed.class);
                startActivity(i);
                break;


        }
    }
}
