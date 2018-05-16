package com.sj.projekt.mobishopfinder.Qytetet;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sj.projekt.mobishopfinder.DBHandler;
import com.sj.projekt.mobishopfinder.MapsActivity;
import com.sj.projekt.mobishopfinder.R;
import com.sj.projekt.mobishopfinder.tabbed;

public class Skenderaj extends AppCompatActivity {
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skenderaj);

        //adapter
        final ArrayAdapter<String> items = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1);
        //db
        final DBHandler db = DBHandler.getInstance(this);


        Cursor data = db.getMobileShopData();
        if (data.moveToFirst()) {
            for (int i = 0; i < data.getCount(); i++) {
                if(data.getString(2).equals(getClass().getSimpleName())) {
                    items.add(data.getString(1));
                }
                data.moveToNext();
            }
        }


        list = findViewById(R.id.lista);

        list.setAdapter(items);
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                        String selected = list.getItemAtPosition(i).toString();
                        double Latitude=0,Longitude=0;

                        Cursor rez = db.getMobileshopLocation(selected);
                        rez.moveToFirst();
                        Latitude = Double.parseDouble(rez.getString(0));
                        Longitude = Double.parseDouble(rez.getString(1));

                        if(selected != "" || Longitude != 0 || Latitude != 0) {

                            Intent intent = new Intent(Skenderaj.this, tabbed.class);
                            intent.putExtra("Emri", selected);
                            intent.putExtra("Latitude", Latitude);
                            intent.putExtra("Longitude", Longitude);

                            startActivity(intent);
                        }
                    }
                });
    }
}
