package com.example.map;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    private  GoogleMap ggmap;
    GoogleMap.OnMyLocationChangeListener myLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {

            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

            Marker marker = ggmap.addMarker(new MarkerOptions().position(latLng).title("It's me! Marker in currentlocation"));
            ggmap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,5     ));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SupportMapFragment map = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        map.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                ggmap = googleMap;
                ggmap.setMyLocationEnabled(false);
                ggmap.setOnMyLocationChangeListener(myLocationChangeListener);
//                LatLng lng = new LatLng(-34,151);
//                ggmap.addMarker(new MarkerOptions().position(lng).title("Marker in Sydney"));
//                ggmap.moveCamera(CameraUpdateFactory.newLatLng(lng));
            }
        });
    }
}
