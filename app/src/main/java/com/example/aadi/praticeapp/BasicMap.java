package com.example.aadi.praticeapp;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class BasicMap extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener , LocationListener ,View.OnClickListener {

    private static final int TAG_CODE_PERMISSION_LOCATION = 10;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    FrameLayout map_frame_layout;
    private GoogleMap mMap;
    ImageButton satellite_btn, hybrid_btn, terrain_btn, current_btn ,normal_btn;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private Location mLastLocation;
    private Marker mCurrLocationMarker;
    Double latitude ;
    Double longitude ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_map);


        intilize();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        satellite_btn.setOnClickListener(this);
        hybrid_btn.setOnClickListener(this);
        terrain_btn.setOnClickListener(this);
        current_btn.setOnClickListener(this);
        normal_btn.setOnClickListener(this);


    }

    private void intilize() {
        satellite_btn = (ImageButton) findViewById(R.id.buttonsatelliteview);
        hybrid_btn = (ImageButton) findViewById(R.id.buttonhybridview);
        terrain_btn = (ImageButton) findViewById(R.id.buttonterrainView);
        normal_btn = (ImageButton)findViewById(R.id.buttonnormalView);
        current_btn = (ImageButton) findViewById(R.id.buttonCurrent);
        map_frame_layout = (FrameLayout) findViewById(R.id.map_frame_layout);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng home = new LatLng(17.385044, 78.486671);
        MarkerOptions marker = new MarkerOptions().position(sydney).title("Marker in Sydney");
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
        mCurrLocationMarker = mMap.addMarker(marker);

       // CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(17.385044, 78.486671)).zoom(2).build();
        //mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


    }


        @Override
        public void onClick(View v) {

            switch (v.getId())
            {
                case R.id.buttonsatelliteview:
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    break;

                case R.id.buttonhybridview:
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                    break;

                case R.id.buttonterrainView:
                    mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    break;

                case R.id.buttonnormalView:
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                    break;
                case R.id.buttonCurrent:
                    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ContextCompat.checkSelfPermission(this,
                                android.Manifest.permission.ACCESS_FINE_LOCATION)
                                == PackageManager.PERMISSION_GRANTED) {
                            buildGoogleApiClient();
                            mMap.setMyLocationEnabled(true);
                        }
                    }
                    else {
                        buildGoogleApiClient();
                        mMap.setMyLocationEnabled(true);
                    }
                    break;
            }
        }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

        Toast.makeText(this, "OnConnected", Toast.LENGTH_SHORT).show();
        Log.i("OnConnected Function","OnConnected");

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
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

        Toast.makeText(this, "OnLocation Changed", Toast.LENGTH_SHORT).show();
        Log.e("Location Function","OnLocation Change");
        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    protected synchronized void buildGoogleApiClient() {
        Toast.makeText(this, "BuildGoogleApi", Toast.LENGTH_SHORT).show();
        Log.i("BuildGoogleApi Function","BuildGoogleApi");
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    public boolean checkLocationPermission(){

        Toast.makeText(this, "OnLocation Changed", Toast.LENGTH_SHORT).show();
        Log.e("Location Function","OnLocation Change");
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Toast.makeText(this, "Permission Issue", Toast.LENGTH_SHORT).show();
        Log.e("Permison Issue Function","Permission Issue");
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // Permission was granted.
                    if (ContextCompat.checkSelfPermission(this,
                            android.Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            //You can add here other case statements according to your requirement.
        }
    }
}






