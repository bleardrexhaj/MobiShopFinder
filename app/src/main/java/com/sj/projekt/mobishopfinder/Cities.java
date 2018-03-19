package com.sj.projekt.mobishopfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        artane =  findViewById(R.id.artane);
        besiane = findViewById(R.id.besiane);
        decan = findViewById(R.id.decan);
        ferizaj = findViewById(R.id.ferizaj);
        fushekosove = findViewById(R.id.fushekosove);
        gjakove = findViewById(R.id.gjakove);
        gjilan = findViewById(R.id.gjilan);
        kline = findViewById(R.id.kline);
        malisheve = findViewById(R.id.malisheve);
        mitrovice = findViewById(R.id.mitrovice);
        peje = findViewById(R.id.peje);
        prishtine = findViewById(R.id.prishtine);
        prizren = findViewById(R.id.prizren);
        rahovec = findViewById(R.id.rahovec);
        skenderaj = findViewById(R.id.skenderaj);
        shtime = findViewById(R.id.shtime);
        therand = findViewById(R.id.therande);
        viti = findViewById(R.id.viti);
        vushtrri = findViewById(R.id.vushtrri);

        artane.setOnClickListener(this);
        besiane.setOnClickListener(this);
        decan.setOnClickListener(this);
        ferizaj.setOnClickListener(this);
        fushekosove.setOnClickListener(this);
        gjakove.setOnClickListener(this);
        gjilan.setOnClickListener(this);
        kline.setOnClickListener(this);
        malisheve.setOnClickListener(this);
        mitrovice.setOnClickListener(this);
        peje.setOnClickListener(this);
        prishtine.setOnClickListener(this);
        prizren.setOnClickListener(this);
        rahovec.setOnClickListener(this);
        skenderaj.setOnClickListener(this);
        shtime.setOnClickListener(this);
        therand.setOnClickListener(this);
        viti.setOnClickListener(this);
        vushtrri.setOnClickListener(this);


        }
    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {

            case R.id.artane : i = new Intent(this, Artane.class);startActivity(i); break;
            case R.id.besiane : i = new Intent(this, Besiane.class);startActivity(i); break;
            case R.id.decan : i = new Intent(this, Decan.class);startActivity(i); break;
            case R.id.ferizaj : i = new Intent(this, Ferizaj.class);startActivity(i); break;
            case R.id.fushekosove : i = new Intent(this, Fushe_Kosove.class);startActivity(i); break;
            case R.id.gjakove : i = new Intent(this, Gjakove.class);startActivity(i); break;
            case R.id.gjilan : i = new Intent(this, Gjilan.class);startActivity(i); break;
            case R.id.kline : i = new Intent(this, Kline.class);startActivity(i); break;
            case R.id.malisheve : i = new Intent(this, Malisheve.class);startActivity(i); break;
            case R.id.mitrovice : i = new Intent(this, Mitrovice.class);startActivity(i); break;
            case R.id.peje : i = new Intent(this, Peje.class);startActivity(i); break;
            case R.id.prishtine : i = new Intent(this, Prishtine.class);startActivity(i); break;
            case R.id.prizren : i = new Intent(this, Prizren.class);startActivity(i); break;
            case R.id.rahovec : i = new Intent(this, Rahovec.class);startActivity(i); break;
            case R.id.skenderaj : i = new Intent(this, Skenderaj.class);startActivity(i); break;
            case R.id.shtime : i = new Intent(this, Shtime.class);startActivity(i); break;
            case R.id.therande : i = new Intent(this, Therande.class);startActivity(i); break;
            case R.id.viti : i = new Intent(this, Viti.class);startActivity(i); break;
            case R.id.vushtrri : i = new Intent(this, Vushtrri.class);startActivity(i); break;

            default: break;



        }
    }
}
