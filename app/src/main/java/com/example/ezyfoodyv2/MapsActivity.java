package com.example.ezyfoodyv2;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng>arrayList = new ArrayList<LatLng>();
    LatLng EzyFoodyJakarta = new LatLng(-6.1952, 106.8204);
    LatLng EzyFoodyBogor = new LatLng(-6.5980, 106.7975);
    LatLng EzyFoodyDepok = new LatLng(-6.4025, 106.7942);
    LatLng EzyFoodyGS = new LatLng(-6.2411, 106.6285);
    LatLng EzyFoodyBekasi = new LatLng(-6.2260, 107.0011);
    LatLng EzyFoodyBandung = new LatLng(-6.8915, 107.6107);

    private String[] name = {"EzyFoody Jakarta", "EzyFoody Bogor", "EzyFoody Depok",
                             "EzyFoody Gading Serpong", "EzyFoody Bekasi", "EzyFoody Bandung"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(EzyFoodyJakarta);
        arrayList.add(EzyFoodyBogor);
        arrayList.add(EzyFoodyDepok);
        arrayList.add(EzyFoodyGS);
        arrayList.add(EzyFoodyBekasi);
        arrayList.add(EzyFoodyBandung);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        for (int i = 0;i<arrayList.size();i++){
            for (int j = 0;j<name.length;j++) {
                mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(name[i]));
            }
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String marker_title = marker.getTitle();
                Intent i = new Intent(MapsActivity.this, PesanActivity.class);
                i.putExtra("title", marker_title);
                startActivity(i);

                return false;
            }
        });
    }

    public void toPesan(View view){
        Intent intent = new Intent(this, PesanActivity.class);
        String title = "EzyFoody Jakarta";
        intent.putExtra("title", title);
        startActivity(intent);
    }
}