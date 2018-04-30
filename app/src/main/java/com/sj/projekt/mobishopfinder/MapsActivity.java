package com.sj.projekt.mobishopfinder;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        MapsInitializer.initialize(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        double longitude,latitude;
        String name;
        Intent getIntent = this.getIntent();
        longitude = getIntent.getDoubleExtra("Latitude",0);
        latitude = getIntent.getDoubleExtra("Longitude",0);
        name = getIntent.getStringExtra("emri");

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng MobileShop = new LatLng(longitude, latitude);
        MarkerOptions marker = new MarkerOptions()
                .title(name)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.markerfinal))
                .position(MobileShop);

        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MobileShop));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(MobileShop,20));
    }
}
