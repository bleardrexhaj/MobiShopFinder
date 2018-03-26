package com.sj.projekt.mobishopfinder.Qytetet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sj.projekt.mobishopfinder.MapsActivity;
import com.sj.projekt.mobishopfinder.R;

public class Prizren extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prizren);

        list = findViewById(R.id.lista);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String selected = list.getItemAtPosition(i).toString();
                        double Latitude=0,Longitude=0;

                        String name = selected;
                        if(selected.equals("MobileShop Prizren1")) {
                            Latitude = 42.206266;
                            Longitude = 20.725252;
                        }else if(selected.equals("MobileShop Prizren2")){
                            Latitude = 42.209958;
                            Longitude = 20.737874;
                        }else if(selected.equals("MobileShop Prizren3")){
                            Latitude = 42.213476;
                            Longitude = 20.731155;
                        }

                        if(name != "" || Longitude != 0 || Latitude != 0) {
                            Intent intent = new Intent(Prizren.this, MapsActivity.class);
                            intent.putExtra("emri", name);
                            intent.putExtra("Latitude", Latitude);
                            intent.putExtra("Longitude", Longitude);
                            startActivity(intent);
                        }
                    }
                });
    }
}
