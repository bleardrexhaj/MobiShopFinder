package com.sj.projekt.mobishopfinder.Qytetet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sj.projekt.mobishopfinder.MapsActivity;
import com.sj.projekt.mobishopfinder.R;

public class Gjakove extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gjakove);

        list = findViewById(R.id.lista);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String selected = list.getItemAtPosition(i).toString();
                        double Latitude=0,Longitude=0;

                        String name = selected;
                        if(selected.equals("MobileShop Gjakovë1")) {
                            Latitude = 42.383675;
                            Longitude = 20.429485;
                        }else if(selected.equals("MobileShop Gjakovë2")){
                            Latitude = 42.386821;
                            Longitude = 20.432725;
                        }else if(selected.equals("MobileShop Gjakovë3")){
                            Latitude = 42.384428;
                            Longitude = 20.437714;
                        }

                        if(name != "" || Longitude != 0 || Latitude != 0) {
                            Intent intent = new Intent(Gjakove.this, MapsActivity.class);
                            intent.putExtra("emri", name);
                            intent.putExtra("Latitude", Latitude);
                            intent.putExtra("Longitude", Longitude);
                            startActivity(intent);
                        }
                    }
                });
    }
}
