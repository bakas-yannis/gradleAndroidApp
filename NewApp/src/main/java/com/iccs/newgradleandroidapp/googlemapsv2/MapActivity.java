package com.iccs.newgradleandroidapp.googlemapsv2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.*;
import com.iccs.newgradleandroidapp.newapp.R;

import java.net.MalformedURLException;
import java.net.URL;

public class MapActivity extends ActionBarActivity implements GoogleMap.OnMapLongClickListener {

    static final LatLng TRIKALA = new LatLng(39.556223, 21.767839);
    static final String TAG = "MapActivity";

    // Google Map
    private GoogleMap map;
    private Marker markerStart, markerEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        initilizeMap();

        map.setOnMapLongClickListener(this);
        map.getUiSettings().setZoomControlsEnabled(false);
        map.setMyLocationEnabled(true);
        map.setOnMarkerDragListener(onMarkerDragListener);

    }

    /**
     * Function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {

        if (map == null) {
            map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            String mUrl = "http://otile1.mqcdn.com/tiles/1.0.0/map/{z}/{x}/{y}.png";

            MyUrlTileProvider mTileProvider = new MyUrlTileProvider(256, 256, mUrl);

            map.addTileOverlay(new TileOverlayOptions().tileProvider(mTileProvider).zIndex(-1));

            markerStart = map.addMarker(new MarkerOptions().position(TRIKALA)
                    .title("Trikala").snippet("I love 3Kala").draggable(true));

            // Move the camera instantly to Trikala with a zoom of 15.
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(TRIKALA, 15));

            // Zoom in, animating the camera.
            map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

            // check if map is created successfully or not
            if (map == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapLongClick(LatLng latLng) {

        Log.d(TAG, "onMapLongClick");

        Toast.makeText(getApplicationContext(), latLng.toString(), Toast.LENGTH_SHORT).show();

        if(markerEnd == null)
            markerEnd = map.addMarker(new MarkerOptions().position(latLng)
                .title("Trikala").snippet("I love 3Kala end").draggable(true));
        else {
            markerEnd.remove();
            markerEnd = map.addMarker(new MarkerOptions().position(latLng)
                    .title("Trikala").snippet(latLng.toString()).draggable(true));
        }
    }

    public class MyUrlTileProvider extends UrlTileProvider {

        private String baseUrl;

        public MyUrlTileProvider(int width, int height, String url) {
            super(width, height);
            this.baseUrl = url;
        }

        @Override
        public URL getTileUrl(int x, int y, int zoom) {
            try {
                return new URL(baseUrl.replace("{z}", ""+zoom).replace("{x}",""+x).replace("{y}",""+y));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    GoogleMap.OnMarkerDragListener onMarkerDragListener = new GoogleMap.OnMarkerDragListener() {

        @Override
        public void onMarkerDragStart(Marker marker) {

        }

        @Override
        public void onMarkerDrag(Marker marker) {

        }

        @Override
        public void onMarkerDragEnd(Marker marker) {


            marker.setTitle(marker.getPosition().toString());



        }
    };
}
