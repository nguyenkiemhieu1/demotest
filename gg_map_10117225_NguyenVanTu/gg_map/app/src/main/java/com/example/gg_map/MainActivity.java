package com.example.gg_map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks
        , GoogleApiClient.OnConnectionFailedListener
        , LocationListener {
    private static final int REQUEST_USER_LOCATION_CODE = 99;
        public GoogleMap map;
    public GoogleApiClient googleApiClient;
    LocationRequest locationRequest;
    Spinner spinner;
    String[] country = {"MAP_TYPE_NORMAL", "MAP_TYPE_SATELLITE", "MAP_TYPE_TERRAIN", "MAP_TYPE_HYBRID"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.Spn_chon);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        map.stopAnimation();
                        break;
                    case 1:
                        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                        map.stopAnimation();
                        break;
                    case 2:
                        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                        map.stopAnimation();
                        break;
                    case 3:
                        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        map.stopAnimation();
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
    }

    private boolean checkUserLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_USER_LOCATION_CODE);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_USER_LOCATION_CODE);
            }
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng nha = new LatLng(20.840686, 105.967583);
        LatLng troban = new LatLng(20.941177, 106.067842);
        LatLng cs1 = new LatLng(20.8590086,105.9996825);
        LatLng cs2 = new LatLng(20.9450817,106.0391655);
        LatLng cs3 = new LatLng(20.9364662, 106.31045);
        CircleOptions circleoptions = new CircleOptions().strokeWidth(10).strokeColor(Color.BLACK).fillColor(Color.parseColor("#500084d3"));
        Circle circle = map.addCircle(circleoptions.center(nha).radius(2000));
        map.addMarker(new MarkerOptions().position(nha).title("Nhà  "));
        map.addMarker(new MarkerOptions().position(troban).title("Trọ bạn  "));
        map.addMarker(new MarkerOptions().position(cs1).title("Mỹ Hào"));
        map.addMarker(new MarkerOptions().position(cs2).title("Khoái Châu"));
        map.addMarker(new MarkerOptions().position(cs3).title("Hải Dương"));
        map.moveCamera(CameraUpdateFactory.newLatLng(cs2));
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        Polyline polyline= map.addPolyline(new PolylineOptions().add(troban,cs1,cs2,cs3));
        polyline.setColor(Color.RED);
        polyline.setWidth(5);
        Polygon polygon = map.addPolygon(new PolygonOptions().add(nha,cs2));
        polygon.setStrokeColor(Color.BLUE);
        polygon.setFillColor(Color.YELLOW);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED) {
            return;
        }
        map.setMyLocationEnabled(true);
    }
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }
}
