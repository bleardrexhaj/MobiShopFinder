package com.sj.projekt.mobishopfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sj.projekt.mobishopfinder.Phones.Google_pixel;
import com.sj.projekt.mobishopfinder.Phones.Iphone8;
import com.sj.projekt.mobishopfinder.Phones.IphoneX;
import com.sj.projekt.mobishopfinder.Phones.SamsungNote8;
import com.sj.projekt.mobishopfinder.Phones.Samsungs9;
import com.sj.projekt.mobishopfinder.Phones.Temporary_phones;

public class Topten_content extends AppCompatActivity implements View.OnClickListener{

    private Button samsungs9,iphonex,samsungnote,google,iphone8,huawei,oneplus,sony_xperia,lg_v,blackberry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topten_content);



        samsungs9 = (Button) findViewById(R.id.samsungs9);
        iphonex = (Button) findViewById(R.id.iphonex);
        samsungnote = (Button) findViewById(R.id.samsungnote);
        google = (Button) findViewById(R.id.google);
        iphone8 = (Button) findViewById(R.id.iphone8);
        huawei = (Button) findViewById(R.id.huawei);
        oneplus = (Button) findViewById(R.id.oneplus);
        sony_xperia = (Button) findViewById(R.id.sony_xperia);
        lg_v = (Button) findViewById(R.id.lg_v);
        blackberry = (Button) findViewById(R.id.blackberry);


        samsungs9.setOnClickListener(this);
        iphonex.setOnClickListener(this);
        samsungnote.setOnClickListener(this);
        google.setOnClickListener(this);
        iphone8.setOnClickListener(this);
        huawei.setOnClickListener(this);
        oneplus.setOnClickListener(this);
        sony_xperia.setOnClickListener(this);
        lg_v.setOnClickListener(this);
        blackberry.setOnClickListener(this);






    }







    @Override
    public void onClick(View v) {


        Intent i ;

        switch (v.getId()){

            case R.id.samsungs9 : i = new Intent(this,Samsungs9.class);startActivity(i);
                break;
            case R.id.iphonex : i = new Intent(this,IphoneX.class);startActivity(i);
                break;
            case R.id.samsungnote : i = new Intent(this,SamsungNote8.class);startActivity(i);
                break;
            case R.id.google : i = new Intent(this,Google_pixel.class);startActivity(i);
                break;
            case R.id.iphone8 : i = new Intent(this,Iphone8.class);startActivity(i);
                break;
            case R.id.huawei : i = new Intent(this,Temporary_phones.class);startActivity(i);
                break;
            case R.id.oneplus : i = new Intent(this,Temporary_phones.class);startActivity(i);
                break;
            case R.id.sony_xperia : i = new Intent(this,Temporary_phones.class);startActivity(i);
                break;
            case R.id.lg_v : i = new Intent(this,Temporary_phones.class);startActivity(i);
                break;
            case R.id.blackberry : i = new Intent(this,Temporary_phones.class);startActivity(i);
                break;


            default:break;

        }










    }
}
