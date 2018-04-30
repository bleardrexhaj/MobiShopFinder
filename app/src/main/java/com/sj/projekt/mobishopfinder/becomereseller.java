package com.sj.projekt.mobishopfinder;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class becomereseller extends AppCompatActivity  implements View.OnClickListener{

    private TextView login_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_becomereseller);


        getWindow().setBackgroundDrawableResource(R.drawable.iph);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN); //mos mu hap keyboardi(automatic)


        login_text = (TextView) findViewById(R.id.login_text);

        login_text.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {



        Intent intent = new Intent(this,Signin.class);
        startActivity(intent);

    }
}
