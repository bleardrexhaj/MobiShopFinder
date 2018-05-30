package com.sj.projekt.mobishopfinder;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sj.projekt.mobishopfinder.Qytetet.Artane;
import com.sj.projekt.mobishopfinder.Qytetet.Besiane;
import com.sj.projekt.mobishopfinder.Qytetet.Decan;
import com.sj.projekt.mobishopfinder.Qytetet.Ferizaj;
import com.sj.projekt.mobishopfinder.Qytetet.Fushe_Kosove;
import com.sj.projekt.mobishopfinder.Qytetet.Gjakove;
import com.sj.projekt.mobishopfinder.Qytetet.Gjilan;
import com.sj.projekt.mobishopfinder.Qytetet.Kline;
import com.sj.projekt.mobishopfinder.Qytetet.Malisheve;
import com.sj.projekt.mobishopfinder.Qytetet.Mitrovice;
import com.sj.projekt.mobishopfinder.Qytetet.Peje;
import com.sj.projekt.mobishopfinder.Qytetet.Prishtine;
import com.sj.projekt.mobishopfinder.Qytetet.Prizren;
import com.sj.projekt.mobishopfinder.Qytetet.Rahovec;
import com.sj.projekt.mobishopfinder.Qytetet.Shtime;
import com.sj.projekt.mobishopfinder.Qytetet.Skenderaj;
import com.sj.projekt.mobishopfinder.Qytetet.Therande;
import com.sj.projekt.mobishopfinder.Qytetet.Viti;
import com.sj.projekt.mobishopfinder.Qytetet.Vushtrri;

public class Cities extends AppCompatActivity implements View.OnClickListener {
    TextView artane,besiane,decan,ferizaj,fushekosove,gjakove,gjilan,kline,malisheve,mitrovice,peje,prishtine,prizren,rahovec,skenderaj,shtime,therand,viti,vushtrri;
    private static DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);
        db = DBHandler.getInstance(getApplicationContext());


        final Spinner mySpinner = findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Cities.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.cities));
        myAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                String selection = (String) mySpinner.getSelectedItem();
                final Intent intent;
                if(selection.equals("Artane"))
                {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Artane.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Besiane")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Besiane.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }

                }
                else if(selection.equals("Decan")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Decan.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Ferizaj")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Ferizaj.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Fushe_Kosove")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Fushe_Kosove.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Gjakove")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Gjakove.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Gjilan")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Gjilan.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Kline")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Kline.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Malisheve")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Malisheve.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Mitrovice")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Mitrovice.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Peje")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Peje.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Prishtine")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Prishtine.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Prizren")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Prizren.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Rahovec")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Rahovec.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Skenderaj")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Skenderaj.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Shtime")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Shtime.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Therande")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Therande.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Viti")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Viti.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }
                else if(selection.equals("Vushtrri")) {
                    


                    Cursor data = db.getMobileShopData();
                    int mobileshopat = 0;
                    if (data.moveToFirst()) {
                        for (int i = 0; i < data.getCount(); i++) {
                            if(data.getString(2).equals(selection)) {
                                mobileshopat++;
                            }
                            data.moveToNext();
                        }
                    }
                    if(mobileshopat > 0) {
                        intent = new Intent(Cities.this, Vushtrri.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"Nuk ka mobileshopa ne databaze per qytetin: "+selection,Toast.LENGTH_LONG).show();
                    }
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        }

    @Override
    public void onClick(View view) {

    }
}
