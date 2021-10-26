package com.ricardoangelo.exam

import android.app.Activity
import android.content.Context
import android.content.IntentSender

import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Half.toFloat
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.ricardoangelo.exam.databinding.ActivityMapsBinding
import java.lang.Error
import java.lang.Exception
import java.lang.Math.sqrt
import java.net.MalformedURLException
import java.net.URL
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var locationRequest: LocationRequest
    private lateinit var fusedLocation: FusedLocationProviderClient
    private var locationUpdateState = false
    private lateinit var locationCallback: LocationCallback
    private lateinit var lastLocation: Location
    private lateinit var initPosition: LatLng
    private lateinit var marker: Marker
    private lateinit var circle: Circle
    var sharedPreferences: SharedPreferences? = null;private set;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        // val permissions = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
        // ActivityCompat.requestPermissions(this, permissions,0)
        // permissions = arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION)
        // ActivityCompat.requestPermissions(this, permissions,0)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(p0: LocationResult) {
                super.onLocationResult(p0)
                var bearing = 0.toFloat()
                try{

                bearing = lastLocation.bearingTo(p0.lastLocation).toFloat()
                }catch(err: Exception){
                    Log.e("erro", "erro")
                   Log.e(err?.toString(), err?.toString())
                }
                //if(lastLocation!=null){

              // }
                lastLocation = p0.lastLocation
                placeMarkerOnMap(LatLng(lastLocation.latitude, lastLocation.longitude), bearing)//mudar p pegar o marcador
            }
        }
       createLocationRequest()// pegar a posição atual do usuário
    }

    private fun setLastLocation(location: Location?){
        if(location?.latitude !=null && location?.longitude!=null){
            initPosition = LatLng(location.latitude, location.longitude)
        }else{
            initPosition = LatLng(-12.961289, -38.432138)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        
        fusedLocation = LocationServices.getFusedLocationProviderClient(this)
        
        //esse if define a localização caso o createLocationRequest não pegue a loc atual
        //if(fusedLocation.lastLocation != null){ //descomentar esse if e remover o de 1==2
        if(1==2){
            try{

                fusedLocation.lastLocation.addOnSuccessListener {
                        location: Location? -> setLastLocation(location)
                }
            }catch(err: Exception){
                Toast.makeText(this,err.toString(), Toast.LENGTH_SHORT).show()
            }
            //Toast.makeText(this,fusedLocation.lastLocation.result.toString(), Toast.LENGTH_SHORT).show()
            
        }else{
            initPosition = LatLng(-12.961289, -38.432138)
        }
        

         val marOptions= MarkerOptions()
            .position(initPosition)
            .title("Tô aq!")
            .snippet("EA")
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_icon))
        marker = mMap.addMarker(marOptions)

        //aduiciona o circulo
        val co = CircleOptions()
            .center(marker.position)
            .radius(150.0) //colocar dinamico
            .fillColor(Color.CYAN)
            .strokeColor(Color.RED)
            .strokeWidth(4.0f)
         circle = mMap.addCircle(co);


        mMap.moveCamera(CameraUpdateFactory.newLatLng(initPosition))
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
           // Toast.makeText(this,"VALOR: ", Toast.LENGTH_LONG).show()
            googleMap.setTrafficEnabled(true);
        }else{
            googleMap.setTrafficEnabled(false);
        }
        
        
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            mMap.isMyLocationEnabled=true
        }else{
            val permissions = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
            ActivityCompat.requestPermissions(this, permissions,0)// Depois ver se precisa usar o REQUEST_LAST_LOCATION
            val permissionsCoarse = arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION)
            ActivityCompat.requestPermissions(this, permissionsCoarse,0)

        }
        
        mMap.uiSettings.isMyLocationButtonEnabled=true
        mMap.uiSettings.isCompassEnabled=true
        mMap.uiSettings.isZoomControlsEnabled = true
        //map orientation
        val mapOrientation = sharedPreferences!!.getInt("radio3",0)
        if(mapOrientation == R.id.radio32){
         mMap.uiSettings.isRotateGesturesEnabled=false
        }else if(mapOrientation == R.id.radio33){
         mMap.uiSettings.isRotateGesturesEnabled=false
        }else{
            mMap.uiSettings.isRotateGesturesEnabled=true //shift control
        }

        //textViewInfo
    }
    
    private fun createLocationRequest() {
        locationRequest = LocationRequest()
        locationRequest.interval = 100
        locationRequest.fastestInterval = 100
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        val builder = LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest)
        val client = LocationServices.getSettingsClient(this)
        val task = client.checkLocationSettings(builder.build())
        
        task.addOnSuccessListener {
            locationUpdateState = true
            startLocationUpdates()
        }
    }

    private fun startLocationUpdates() {
    if (ActivityCompat.checkSelfPermission(this,
            android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                1)
        return
    }
        fusedLocation.requestLocationUpdates(locationRequest, locationCallback, null /* Looper */)

    }

    private fun placeMarkerOnMap(location: LatLng, bearing: Float) {

        //ajustar calculo velocidade
        var speed = (sqrt((location.latitude - marker.position.latitude)*(location.latitude - marker.position.latitude) + (location.longitude - marker.position.longitude)*(location.longitude - marker.position.longitude))) / (10)
        marker.position = location
        circle.center = location
        val textInfo = findViewById<TextView>(R.id.textViewInfo);
        textInfo.text= "Latitude: "+location.latitude.toString()+"\nLongitude"+location.longitude.toString()+"\nSpeed:"+speed
        val mapOrientation = sharedPreferences!!.getInt("radio3",0);
        if(mapOrientation == R.id.radio33){
            marker.rotation = bearing
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition(location, mMap.cameraPosition.zoom, mMap.cameraPosition.tilt, bearing)))
        }
        
        
    }
}