package com.sj.projekt.mobishopfinder;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.sj.projekt.mobishopfinder.Permissions.PermissionUtils;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback {

    private GoogleMap mMap;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;


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

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }
    }

    private void setMyLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        Location location = locationManager.getLastKnownLocation(locationManager
                .getBestProvider(criteria, false));
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();

        LatLng cordinates = new LatLng(latitude,longitude);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cordinates));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cordinates, 20));
    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {


        final Intent getIntent = this.getIntent();

        mMap = googleMap;
        enableMyLocation();

        boolean b = getIntent.getBooleanExtra("MerrLokacionin",false);
        if (b) {
            // TODO: CHECK FOR INTERNET CONNECTION --> BLEARD
            //setMyLocation();
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

                @Override
                public void onMapClick(LatLng point) {

                    MarkerOptions marker = new MarkerOptions().position(
                            new LatLng(point.latitude, point.longitude)).title("New Marker");

                    mMap.addMarker(marker);
                    Intent i = new Intent();
                    i.putExtra("latitude", point.latitude);
                    i.putExtra("longitude", point.longitude);

                    setResult(RESULT_OK,i);

                    finish();



                }
            });

        }else {
            double longitude, latitude;
            String name;
            longitude = getIntent.getDoubleExtra("Latitude", 0);
            latitude = getIntent.getDoubleExtra("Longitude", 0);
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
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(MobileShop, 20));





        }
    }

    public GoogleMap getMap() {
        return mMap;
    }
}
