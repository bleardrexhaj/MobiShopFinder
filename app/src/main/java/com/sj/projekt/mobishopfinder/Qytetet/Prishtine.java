package com.sj.projekt.mobishopfinder.Qytetet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.sj.projekt.mobishopfinder.MapsActivity;
import com.sj.projekt.mobishopfinder.R;

public class Prishtine extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prishtine);
        list = findViewById(R.id.lista_prishtine);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String selected = list.getItemAtPosition(i).toString();
                        double Latitude=0,Longitude=0;

                        String name = selected;
                        if(selected.equals("MobileShop Qendra")) {
                             Latitude = 42.648717;
                             Longitude = 21.157619;
                        }else if(selected.equals("MobileShop Erlisi")){
                             Latitude = 42.6547710;
                             Longitude = 21.1595704;
                        }else if(selected.equals("MobileShop Toni")){
                             Latitude = 42.6549076;
                             Longitude = 21.1596354;
                        }

                        if(name != null || Longitude != 0 || Latitude != 0) {
                            Intent intent = new Intent(Prishtine.this, MapsActivity.class);
                            intent.putExtra("emri", name);
                            intent.putExtra("Latitude", Latitude);
                            intent.putExtra("Longitude", Longitude);
                            startActivity(intent);
                        }
                    }
                });
    }
}
