package com.ricardoangelo.exam

import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.ricardoangelo.exam.databinding.ActivityMapsBinding
import java.net.MalformedURLException
import java.net.URL

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    var sharedPreferences: SharedPreferences? = null;private set;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        
        val unifacs = LatLng(-12.961289, -38.432138)
        mMap.addMarker(MarkerOptions()
            .position(unifacs)
            .title("Tô aq!")
            .snippet("EA")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_icon)))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(unifacs))
        // ajuste pro mapa dar reload
        val tileProvider = object: UrlTileProvider(256, 256) {
      override fun getTileUrl(x:Int,y:Int,zoom:Int): URL {

        val s = String.format("http://my.image.server/images/%d/%d/%d.png",
            zoom, x, y)

        if (!checkTileExists(x, y, zoom)) {
          return URL(null)
        }

        try {
          return URL(s)
        } catch (e: MalformedURLException) {
            throw AssertionError(e)
        }
      }

      
      private fun checkTileExists(x:Int,y:Int,zoom:Int):Boolean {
        val minZoom = 12
        val maxZoom = 16

        if ((zoom < minZoom || zoom > maxZoom)) {
          return false
        }

        return true
      }
    }

    val tileOverlay = mMap!!.addTileOverlay(TileOverlayOptions()
        .tileProvider(tileProvider))
        mMap.setOnMapClickListener(object : GoogleMap.OnMapClickListener {
        override fun onMapClick(p0: LatLng?) {

        }
    })
        //definindo tipo do mapa
        val mapType = sharedPreferences!!.getInt("radio4",0)
        if(mapType == R.id.radio42){
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            mMap.isBuildingsEnabled=true
           
        }else{
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
        // definindo trafego
        val traffic = sharedPreferences!!.getBoolean("ligado",false)
        if(traffic){
            Toast.makeText(this,"VALOR: ", Toast.LENGTH_LONG).show()
            googleMap.setTrafficEnabled(true);
        }else{
            googleMap.setTrafficEnabled(false);
        }
        //map orientation
    //     if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
    //         ActivityCompat.requestPermissions(
    //     this,
    //     new String [] { android.Manifest.permission.ACCESS_COARSE_LOCATION },

    // );
       // }
        //mMap.isMyLocationEnabled=true
        mMap.uiSettings.isMyLocationButtonEnabled=true
        mMap.uiSettings.isCompassEnabled=true
        mMap.uiSettings.isZoomControlsEnabled = true
        val mapOrientation = sharedPreferences!!.getInt("radio3",0)
        if(mapOrientation == R.id.radio32){
         mMap.uiSettings.isRotateGesturesEnabled=false
        }else if(mapOrientation == R.id.radio33){
         mMap.uiSettings.isRotateGesturesEnabled=false
        }else{
            mMap.uiSettings.isRotateGesturesEnabled=true //shift control
        }
    }
}