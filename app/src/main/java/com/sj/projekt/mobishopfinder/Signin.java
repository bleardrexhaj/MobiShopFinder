package com.sj.projekt.mobishopfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Signin extends AppCompatActivity implements View.OnClickListener{

    private TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        register = findViewById(R.id.register_text);

        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this,becomereseller.class);
        startActivity(intent);

    }
}
