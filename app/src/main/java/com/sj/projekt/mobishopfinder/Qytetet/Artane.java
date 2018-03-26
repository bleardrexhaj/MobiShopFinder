package com.sj.projekt.mobishopfinder.Qytetet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sj.projekt.mobishopfinder.MapsActivity;
import com.sj.projekt.mobishopfinder.R;

public class Artane extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artane);

        list = findViewById(R.id.lista);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String selected = list.getItemAtPosition(i).toString();
                        double Latitude=0,Longitude=0;

                        String name = selected;
                        if(selected.equals("MobileShop Besi")) {
                            Latitude = 42.608073;
                            Longitude = 21.438771;
                        }else if(selected.equals("MobileShop Niti")){
                            Latitude = 42.609190;
                            Longitude = 21.440086;
                        }else if(selected.equals("MobileShop Beka")){
                            Latitude = 42.607104;
                            Longitude = 21.441545;
                        }

                        if(name != null || Longitude != 0 || Latitude != 0) {
                            Intent intent = new Intent(Artane.this, MapsActivity.class);
                            intent.putExtra("emri", name);
                            intent.putExtra("Latitude", Latitude);
                            intent.putExtra("Longitude", Longitude);
                            startActivity(intent);
                        }
                    }
                });


    }
}
