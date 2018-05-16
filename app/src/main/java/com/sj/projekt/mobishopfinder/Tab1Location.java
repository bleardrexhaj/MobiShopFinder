package com.sj.projekt.mobishopfinder;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Asus on 4/30/2018.
 */

public class Tab1Location extends Fragment {

    private String Emri;
    private Double Latitude;
    private Double Longitude;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.tab1location, container, false);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

            Bundle getargs = this.getArguments();
            if(getargs != null) {
                Emri = getargs.getString("Emri");
                Longitude = getargs.getDouble("Longitude");
                Latitude = getargs.getDouble("Latitude");
            }


        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapTab);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                // Add a marker in Sydney and move the camera
                LatLng MobileShop = new LatLng(Latitude, Longitude);
                MarkerOptions marker = new MarkerOptions()
                        .title(Emri)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.markerfinal))
                        .position(MobileShop);

                googleMap.addMarker(marker);
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(MobileShop));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(MobileShop,10));

            }
        });
    }
}
