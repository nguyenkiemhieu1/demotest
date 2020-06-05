package com.example.ggmap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public abstract class MapsActivity extends FragmentActivity implements OnMapReadyCallback , GoogleApiClient.ConnectionCallbacks
        , GoogleApiClient.OnConnectionFailedListener
        , LocationListener {
    private final String TAG = MapsActivity.class.getSimpleName();
    private Spinner map_type;
    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private static final LatLng cs1 = new LatLng(20.84461915105067, 106.00878160446881);
    private static final LatLng cs2 = new LatLng(20.942226047050294, 106.0600020736456);
    private static final LatLng cs3 = new LatLng(20.936468134530656, 106.31264872848988);
    private static final LatLng myHouse = new LatLng(20.836749, 105.966047);
    private static final LatLng myMotel = new LatLng(20.941163, 106.067825);

    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Location mlocation;
    private Marker currentUserLocationMaker;
    private Circle circle;
    private static final int REQUEST_USER_LOCATION_CODE = 99;
    private FloatingActionButton fabLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkUserLocationPermission();
        }
        init();
        setMapType();

        fabLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location loc = mMap.getMyLocation();
                if (loc != null) {
                    LatLng latLng = new LatLng(loc.getLatitude(), loc.getLongitude());
                    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 17);
                    mMap.animateCamera(cameraUpdate);
                }
            }
        });
    }

    //check permission fine location
    private boolean checkUserLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_USER_LOCATION_CODE);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_USER_LOCATION_CODE);
            }
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_USER_LOCATION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        if (googleApiClient == null) {
                            buildGoogleMapClient();
                        }
                        mMap.setBuildingsEnabled(true);
                    }
                } else {
                    Toast.makeText(this, "Quyền bị từ chối", Toast.LENGTH_SHORT).show();
                }

        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.addMarker(new MarkerOptions().position(cs1).title("Cơ sở 1")).setSnippet("Trường Đại học Sư Phạm Kỹ thuật Hưng Yên");
        mMap.addMarker(new MarkerOptions().position(cs2).title("Cơ sở 2")).setSnippet("Trường Đại học Sư Phạm Kỹ thuật Hưng Yên");
        mMap.addMarker(new MarkerOptions().position(cs3).title("Cơ sở 3")).setSnippet("Trường Đại học Sư Phạm Kỹ thuật Hưng Yên");
        mMap.addMarker(new MarkerOptions().position(myMotel).title("My Motel"));
        mMap.addMarker(new MarkerOptions().position(myHouse).title("My House"));

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            buildGoogleMapClient();
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(false);
        }

        //đường thẳng từ điểm A đến điểm B
        mMap.addPolyline(new PolylineOptions().add(myHouse, cs2)).setColor(Color.GREEN);
        mMap.addPolyline(new PolylineOptions().add(myMotel, cs2)).setColor(Color.BLUE);
        mMap.addPolyline(new PolylineOptions().add(cs1, cs2, cs3, cs1)).setColor(Color.YELLOW);
    }

    //map type
    private void setMapType() {
        map_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        mMap.stopAnimation();
                        break;
                    case 1:
                        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                        mMap.stopAnimation();
                        break;
                    case 2:
                        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        mMap.stopAnimation();
                        break;
                    case 3:
                        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                        mMap.stopAnimation();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
    }

    //initialize google play service
    protected synchronized void buildGoogleMapClient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        googleApiClient.connect();
    }


    @Override
    public void onLocationChanged(Location location) {
        mlocation = location;
        Log.d(TAG, "LocationChanged");
        if (currentUserLocationMaker != null) {
            currentUserLocationMaker.remove();
        }
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("My location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        currentUserLocationMaker = mMap.addMarker(markerOptions);
        CircleOptions circleoptions = new CircleOptions().strokeWidth(2).strokeColor(Color.BLUE).fillColor(Color.parseColor("#500084d3"));
        Circle circle = mMap.addCircle(circleoptions.center(latLng).radius(2000));
        //di chuyển camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(circleoptions.getCenter(), Utils.getZoomLevel(circle)));
        //mMap.animateCamera(CameraUpdateFactory.zoomBy(12));
        if (googleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, (com.google.android.gms.location.LocationListener) this);
        }

        float[] results = new float[1];
        Location.distanceBetween(location.getLatitude(), location.getLongitude(), cs2.latitude, cs2.longitude, results);
        Toast.makeText(this, "Khoảng cách từ vị trí của bạn đến CS2 là: " + Utils.convertMeterToKilometer((int) results[0]) + " km", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, (com.google.android.gms.location.LocationListener) this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void init() {
        fabLocation = findViewById(R.id.fabLocation);
        map_type = findViewById(R.id.map_type);
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    //vị trí khi click trên bản đồ
    private void setLocationMaker(final GoogleMap mMap) {
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                // Creating a marker
                MarkerOptions markerOptions = new MarkerOptions();

                // Setting the position for the marker (Đặt vị trí cho điểm đánh dấu)
                markerOptions.position(latLng);

                Log.e("location", latLng.latitude + " : " + latLng.longitude);
                // Setting the title for the marker. (Đặt tiêu đề cho điểm đánh dấu.)
                // This will be displayed on taping the marker (Điều này sẽ được hiển thị khi ghi điểm đánh dấu)
                markerOptions.title(latLng.latitude + " : " + latLng.longitude);

                // Clears the previously touched position(Xóa vị trí đã chạm trước đó)
                mMap.clear();

                // Animating to the touched position (Hoạt hình đến vị trí chạm)
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

                //Đặt điểm đánh dấu vào vị trí chạm
                mMap.addMarker(markerOptions);
            }
        });
    }
}
