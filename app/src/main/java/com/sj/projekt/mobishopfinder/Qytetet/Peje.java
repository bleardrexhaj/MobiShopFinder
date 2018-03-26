package com.sj.projekt.mobishopfinder.Qytetet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sj.projekt.mobishopfinder.MapsActivity;
import com.sj.projekt.mobishopfinder.R;

public class Peje extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peje);

        list = findViewById(R.id.lista);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String selected = list.getItemAtPosition(i).toString();
                        double Latitude=0,Longitude=0;

                        String name = selected;
                        if(selected.equals("MobileShop Labi")) {
                            Latitude = 42.662150;
                            Longitude = 20.296829;
                        }else if(selected.equals("MobileShop Naki")){
                            Latitude = 42.662127;
                            Longitude = 20.296616;
                        }else if(selected.equals("MobileShop AppleShop")){
                            Latitude = 42.662819;
                            Longitude = 20.297199;
                        }

                        if(name != "" || Longitude != 0 || Latitude != 0) {
                            Intent intent = new Intent(Peje.this, MapsActivity.class);
                            intent.putExtra("emri", name);
                            intent.putExtra("Latitude", Latitude);
                            intent.putExtra("Longitude", Longitude);
                            startActivity(intent);
                        }
                    }
                });
    }
}
