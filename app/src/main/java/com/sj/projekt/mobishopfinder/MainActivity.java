package com.sj.projekt.mobishopfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private CardView zgjidh_qytetin, topten, lowHighPrice, becomeReseller, infoBox;
    SupportMapFragment mDummyMapInitializer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDummyMapInitializer = new SupportMapFragment();
        mDummyMapInitializer.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

            }
        });

        zgjidh_qytetin = findViewById(R.id.zgjidh_qytetin);
        topten = findViewById(R.id.topten);
        lowHighPrice = findViewById(R.id.lowHighPrice);
        becomeReseller = findViewById(R.id.becomeReseller);
        infoBox = findViewById(R.id.infoBox);


        zgjidh_qytetin.setOnClickListener(this);
        topten.setOnClickListener(this);
        lowHighPrice.setOnClickListener(this);
        becomeReseller.setOnClickListener(this);





        infoBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,informationbox.class));
            }
        });



    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {

            case R.id.zgjidh_qytetin : i = new Intent(this, Cities.class);startActivity(i); break;
            case R.id.topten : i = new Intent(this, topten.class);startActivity(i); break;
            case R.id.lowHighPrice : i = new Intent(this, lowhigh.class);startActivity(i); break;
            case R.id.becomeReseller : i = new Intent(this, becomereseller.class);startActivity(i); break;

            default: break;



        }

    }
}
