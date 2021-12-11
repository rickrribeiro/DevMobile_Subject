package com.ricardoangelo.exam;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.location.LocationSettingsRequest.Builder;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.UrlTileProvider;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ktx.DatabaseKt;
import com.google.firebase.ktx.Firebase;
import com.ricardoangelo.exam.databinding.ActivityMapsBinding;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 5, 1},
   k = 1,
   d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0002J(\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020&H\u0002J\u0012\u0010+\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u001bH\u0016J\u0018\u00100\u001a\u00020$2\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u000203H\u0002J\u0012\u00104\u001a\u00020$2\b\u00101\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u00105\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\"\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00066"},
   d2 = {"Lcom/ricardoangelo/exam/MapsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "binding", "Lcom/ricardoangelo/exam/databinding/ActivityMapsBinding;", "circle", "Lcom/google/android/gms/maps/model/Circle;", "database", "Lcom/google/firebase/database/FirebaseDatabase;", "getDatabase", "()Lcom/google/firebase/database/FirebaseDatabase;", "setDatabase", "(Lcom/google/firebase/database/FirebaseDatabase;)V", "fusedLocation", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "initPosition", "Lcom/google/android/gms/maps/model/LatLng;", "lastLocation", "Landroid/location/Location;", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "locationUpdateState", "", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "marker", "Lcom/google/android/gms/maps/model/Marker;", "<set-?>", "Landroid/content/SharedPreferences;", "sharedPreferences", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "createLocationRequest", "", "distance_on_geoid", "", "lat11", "lon11", "lat22", "lon22", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "googleMap", "placeMarkerOnMap", "location", "bearing", "", "setLastLocation", "startLocationUpdates", "app_debug"}
)
public final class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
   private GoogleMap mMap;
   private ActivityMapsBinding binding;
   private LocationRequest locationRequest;
   private FusedLocationProviderClient fusedLocation;
   private boolean locationUpdateState;
   private LocationCallback locationCallback;
   private Location lastLocation;
   private LatLng initPosition;
   private Marker marker;
   private Circle circle;
   @NotNull
   private FirebaseDatabase database;
   @Nullable
   private SharedPreferences sharedPreferences;

   @NotNull
   public final FirebaseDatabase getDatabase() {
      return this.database;
   }

   public final void setDatabase(@NotNull FirebaseDatabase var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.database = var1;
   }

   @Nullable
   public final SharedPreferences getSharedPreferences() {
      return this.sharedPreferences;
   }

   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      ActionBar var10000 = this.getSupportActionBar();
      if (var10000 != null) {
         var10000.hide();
      }

      ActivityMapsBinding var10001 = ActivityMapsBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var10001, "ActivityMapsBinding.inflate(layoutInflater)");
      this.binding = var10001;
      var10001 = this.binding;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
      }

      this.setContentView((View)var10001.getRoot());
      Fragment var3 = this.getSupportFragmentManager().findFragmentById(R.id.map);
      if (var3 == null) {
         throw new NullPointerException("null cannot be cast to non-null type com.google.android.gms.maps.SupportMapFragment");
      } else {
         SupportMapFragment mapFragment = (SupportMapFragment)var3;
         mapFragment.getMapAsync((OnMapReadyCallback)this);
         this.locationCallback = (LocationCallback)(new LocationCallback() {
            public void onLocationResult(@NotNull LocationResult p0) {
               Intrinsics.checkNotNullParameter(p0, "p0");
               super.onLocationResult(p0);
               float bearing = (float)0;

               try {
                  bearing = MapsActivity.access$getLastLocation$p(MapsActivity.this).bearingTo(p0.getLastLocation());
               } catch (Exception var4) {
                  Log.e("erro", "erro");
                  Log.e(var4 != null ? var4.toString() : null, var4 != null ? var4.toString() : null);
               }

               MapsActivity var10000 = MapsActivity.this;
               Location var10001 = p0.getLastLocation();
               Intrinsics.checkNotNullExpressionValue(var10001, "p0.lastLocation");
               var10000.lastLocation = var10001;
               MapsActivity.this.placeMarkerOnMap(new LatLng(MapsActivity.access$getLastLocation$p(MapsActivity.this).getLatitude(), MapsActivity.access$getLastLocation$p(MapsActivity.this).getLongitude()), bearing);
            }
         });
         this.createLocationRequest();
      }
   }

   private final void setLastLocation(Location location) {
      if ((location != null ? location.getLatitude() : null) != null && (location != null ? location.getLongitude() : null) != null) {
         this.initPosition = new LatLng(location.getLatitude(), location.getLongitude());
      } else {
         this.initPosition = new LatLng(-12.961289D, -38.432138D);
      }

   }

   public void onMapReady(@NotNull GoogleMap googleMap) {
      Intrinsics.checkNotNullParameter(googleMap, "googleMap");
      this.mMap = googleMap;
      this.sharedPreferences = this.getSharedPreferences("MyPreferences", 0);
      FusedLocationProviderClient var10001 = LocationServices.getFusedLocationProviderClient((Activity)this);
      Intrinsics.checkNotNullExpressionValue(var10001, "LocationServices.getFuse…ationProviderClient(this)");
      this.fusedLocation = var10001;
      this.initPosition = new LatLng(-12.961289D, -38.432138D);
      MarkerOptions var10000 = new MarkerOptions();
      LatLng var13 = this.initPosition;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("initPosition");
      }

      MarkerOptions marOptions = var10000.position(var13).title("Tô aq!").snippet("EA").icon(BitmapDescriptorFactory.fromResource(700129));
      GoogleMap var14 = this.mMap;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mMap");
      }

      Marker var16 = var14.addMarker(marOptions);
      Intrinsics.checkNotNullExpressionValue(var16, "mMap.addMarker(marOptions)");
      this.marker = var16;
      CircleOptions var11 = new CircleOptions();
      var16 = this.marker;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("marker");
      }

      CircleOptions co = var11.center(var16.getPosition()).radius(150.0D).fillColor(-16711681).strokeColor(-65536).strokeWidth(4.0F);
      var14 = this.mMap;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mMap");
      }

      Circle var17 = var14.addCircle(co);
      Intrinsics.checkNotNullExpressionValue(var17, "mMap.addCircle(co)");
      this.circle = var17;
      GoogleMap var12 = this.mMap;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mMap");
      }

      var13 = this.initPosition;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("initPosition");
      }

      var12.moveCamera(CameraUpdateFactory.newLatLng(var13));
      UrlTileProvider tileProvider = new UrlTileProvider(256, 256) {
         @NotNull
         public URL getTileUrl(int x, int y, int zoom) {
            
            String var6 = "http://my.image.server/images/%d/%d/%d.png";
            Object[] var7 = new Object[]{zoom, x, y};
            boolean var8 = false;
            String var10000 = String.format(var6, Arrays.copyOf(var7, var7.length));
            Intrinsics.checkNotNullExpressionValue(var10000, "java.lang.String.format(format, *args)");
            String s = var10000;
            if (!this.checkTileExists(x, y, zoom)) {
               try {
                  return new URL((String)null);
               } catch (MalformedURLException e) {
                  e.printStackTrace();
               }
            } else {
               try {
                  return new URL(s);
               } catch (MalformedURLException var9) {
                  try {
                     throw (Throwable)(new AssertionError(var9));
                  } catch (Throwable throwable) {
                     throwable.printStackTrace();
                  }
               }
            }
         }

         private final boolean checkTileExists(int x, int y, int zoom) {
            int minZoom = 12;
            int maxZoom = 16;
            return zoom >= minZoom && zoom <= maxZoom;
         }
      };
      var12 = this.mMap;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mMap");
      }

      Intrinsics.checkNotNull(var12);
      var12.addTileOverlay((new TileOverlayOptions()).tileProvider((TileProvider)tileProvider));
      var12 = this.mMap;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mMap");
      }

      var12.setOnMapClickListener((OnMapClickListener)(new OnMapClickListener() {
         public void onMapClick(@Nullable LatLng p0) {
         }
      }));
      SharedPreferences var15 = this.sharedPreferences;
      Intrinsics.checkNotNull(var15);
      int mapType = var15.getInt("radio4", 0);
      if (mapType == 1000244) {
         var12 = this.mMap;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
         }

         var12.setMapType(2);
         var12 = this.mMap;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
         }

         var12.setBuildingsEnabled(true);
      } else {
         var12 = this.mMap;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
         }

         var12.setMapType(1);
      }

      var15 = this.sharedPreferences;
      Intrinsics.checkNotNull(var15);
      boolean traffic = var15.getBoolean("ligado", false);
      if (traffic) {
         googleMap.setTrafficEnabled(true);
      } else {
         googleMap.setTrafficEnabled(false);
      }

      if (ActivityCompat.checkSelfPermission((Context)this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
         var12 = this.mMap;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
         }

         var12.setMyLocationEnabled(true);
      } else {
         String[] permissions = new String[]{"android.permission.ACCESS_FINE_LOCATION"};
         ActivityCompat.requestPermissions((Activity)this, permissions, 0);
         String[] permissionsCoarse = new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
         ActivityCompat.requestPermissions((Activity)this, permissionsCoarse, 0);
      }

      var12 = this.mMap;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mMap");
      }

      UiSettings var18 = var12.getUiSettings();
      Intrinsics.checkNotNullExpressionValue(var18, "mMap.uiSettings");
      var18.setMyLocationButtonEnabled(true);
      var12 = this.mMap;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mMap");
      }

      var18 = var12.getUiSettings();
      Intrinsics.checkNotNullExpressionValue(var18, "mMap.uiSettings");
      var18.setCompassEnabled(true);
      var12 = this.mMap;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("mMap");
      }

      var18 = var12.getUiSettings();
      Intrinsics.checkNotNullExpressionValue(var18, "mMap.uiSettings");
      var18.setZoomControlsEnabled(true);
      var15 = this.sharedPreferences;
      Intrinsics.checkNotNull(var15);
      int mapOrientation = var15.getInt("radio3", 0);
      if (mapOrientation == 1000251) {
         var12 = this.mMap;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
         }

         var18 = var12.getUiSettings();
         Intrinsics.checkNotNullExpressionValue(var18, "mMap.uiSettings");
         var18.setRotateGesturesEnabled(false);
      } else if (mapOrientation == 1000250) {
         var12 = this.mMap;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
         }

         var18 = var12.getUiSettings();
         Intrinsics.checkNotNullExpressionValue(var18, "mMap.uiSettings");
         var18.setRotateGesturesEnabled(false);
      } else {
         var12 = this.mMap;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
         }

         var18 = var12.getUiSettings();
         Intrinsics.checkNotNullExpressionValue(var18, "mMap.uiSettings");
         var18.setRotateGesturesEnabled(true);
      }

   }

   private final void createLocationRequest() {
      this.locationRequest = new LocationRequest();
      LocationRequest var10000 = this.locationRequest;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationRequest");
      }

      var10000.setInterval(100L);
      var10000 = this.locationRequest;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationRequest");
      }

      var10000.setFastestInterval(100L);
      var10000 = this.locationRequest;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationRequest");
      }

      var10000.setPriority(100);
      Builder var4 = new Builder();
      LocationRequest var10001 = this.locationRequest;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationRequest");
      }

      Builder builder = var4.addLocationRequest(var10001);
      SettingsClient client = LocationServices.getSettingsClient((Activity)this);
      Task task = client.checkLocationSettings(builder.build());
      task.addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
         // $FF: synthetic method
         // $FF: bridge method
         public void onSuccess(Object var1) {
            this.onSuccess((LocationSettingsResponse)var1);
         }

         public final void onSuccess(LocationSettingsResponse it) {
            MapsActivity.this.locationUpdateState = true;
            MapsActivity.this.startLocationUpdates();
         }
      }));
   }

   private final void startLocationUpdates() {
      if (ActivityCompat.checkSelfPermission((Context)this, "android.permission.ACCESS_FINE_LOCATION") != 0) {
         ActivityCompat.requestPermissions((Activity)this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
      } else {
         FusedLocationProviderClient var10000 = this.fusedLocation;
         if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fusedLocation");
         }

         LocationRequest var10001 = this.locationRequest;
         if (var10001 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationRequest");
         }

         LocationCallback var10002 = this.locationCallback;
         if (var10002 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationCallback");
         }

         var10000.requestLocationUpdates(var10001, var10002, (Looper)null);
      }
   }

   private final void placeMarkerOnMap(LatLng location, float bearing) {
      Marker var10001 = this.marker;
      if (var10001 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("marker");
      }

      double var24 = var10001.getPosition().latitude;
      Marker var10002 = this.marker;
      if (var10002 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("marker");
      }

      double dist = this.distance_on_geoid(var24, var10002.getPosition().longitude, location.latitude, location.longitude);
      int time_s = 1;
      Marker var10000 = this.marker;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("marker");
      }

      var10000.setPosition(location);
      Circle var21 = this.circle;
      if (var21 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("circle");
      }

      var21.setCenter(location);
      TextView textInfo = (TextView)this.findViewById(R.id.textViewInfo);
      SharedPreferences var22 = this.sharedPreferences;
      Intrinsics.checkNotNull(var22);
      int presentationUnit = var22.getInt("radio2", 0);
      String speedText = "";
      double speed = dist / (double)time_s * 3600.0D / 1000.0D;
      
      String var12;
      Object[] var13;
      boolean var14;
      String var23;
      if (presentationUnit == 1000317) {
         speed /= 1.60934421012D;
        
         var12 = "%.2f MPH";
         var13 = new Object[]{speed};
         var14 = false;
         var23 = String.format(var12, Arrays.copyOf(var13, var13.length));
         Intrinsics.checkNotNullExpressionValue(var23, "java.lang.String.format(format, *args)");
         speedText = var23;
      } else {
        
         var12 = "%.2f KMH";
         var13 = new Object[]{speed};
         var14 = false;
         var23 = String.format(var12, Arrays.copyOf(var13, var13.length));
         Intrinsics.checkNotNullExpressionValue(var23, "java.lang.String.format(format, *args)");
         speedText = var23;
      }

      double latitude = location.latitude;
      double longitude = location.longitude;
      DatabaseReference var25 = this.database.getReference("location_history");
      Intrinsics.checkNotNullExpressionValue(var25, "database.getReference(\"location_history\")");
      DatabaseReference myRef = var25;
      UUID var27 = UUID.randomUUID();
      Intrinsics.checkNotNullExpressionValue(var27, "UUID.randomUUID()");
      UUID uuid = var27;
      myRef.child(uuid.toString()).child("latitude").setValue(latitude);
      myRef.child(uuid.toString()).child("longitude").setValue(longitude);
      var25 = myRef.child(uuid.toString()).child("date");
      StringBuilder var26 = new StringBuilder();
      Calendar var28 = Calendar.getInstance();
      Intrinsics.checkNotNullExpressionValue(var28, "java.util.Calendar.getInstance()");
      Date var30 = var28.getTime();
      Intrinsics.checkNotNullExpressionValue(var30, "java.util.Calendar.getInstance().time");
      var26 = var26.append(String.valueOf(var30.getDate())).append("/");
      var28 = Calendar.getInstance();
      Intrinsics.checkNotNullExpressionValue(var28, "java.util.Calendar.getInstance()");
      var30 = var28.getTime();
      Intrinsics.checkNotNullExpressionValue(var30, "java.util.Calendar.getInstance().time");
      var25.setValue(var26.append(var30.getMonth() + 1).toString());
      var22 = this.sharedPreferences;
      Intrinsics.checkNotNull(var22);
      int presentationFormat = var22.getInt("radio1", 0);
      if (presentationFormat != 1000329 && presentationFormat != 1000327 && presentationFormat == 1000326) {
      }

      Intrinsics.checkNotNullExpressionValue(textInfo, "textInfo");
      textInfo.setText((CharSequence)("Latitude: " + String.valueOf(latitude) + "\nLongitude" + longitude + "\nSpeed:" + speedText));
      var22 = this.sharedPreferences;
      Intrinsics.checkNotNull(var22);
      int mapOrientation = var22.getInt("radio3", 0);
      if (mapOrientation == 1000250) {
         var10000 = this.marker;
         if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("marker");
         }

         var10000.setRotation(bearing);
         GoogleMap var31 = this.mMap;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
         }

         CameraPosition var29 = new CameraPosition;
         GoogleMap var10004 = this.mMap;
         if (var10004 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
         }

         float var32 = var10004.getCameraPosition().zoom;
         GoogleMap var10005 = this.mMap;
         if (var10005 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMap");
         }

         var29.moveCamera(location, var32, var10005.getCameraPosition().tilt, bearing);
         var31.moveCamera(CameraUpdateFactory.newCameraPosition(var29));
      }

   }

   private final double distance_on_geoid(double lat11, double lon11, double lat22, double lon22) {
      double lat1 = lat11 * 3.141592653589793D / 180.0D;
      double lon1 = lon11 * 3.141592653589793D / 180.0D;
      double lat2 = lat22 * 3.141592653589793D / 180.0D;
      double lon2 = lon22 * 3.141592653589793D / 180.0D;
      double r = (double)6378100;
      double rho1 = r * Math.cos(lat1);
      double z1 = r * Math.sin(lat1);
      double x1 = rho1 * Math.cos(lon1);
      double y1 = rho1 * Math.sin(lon1);
      double rho2 = r * Math.cos(lat2);
      double z2 = r * Math.sin(lat2);
      double x2 = rho2 * Math.cos(lon2);
      double y2 = rho2 * Math.sin(lon2);
      double dot = x1 * x2 + y1 * y2 + z1 * z2;
      double cos_theta = dot / (r * r);
      double theta = Math.acos(cos_theta);
      return r * theta;
   }

   public MapsActivity() {
      this.database = DatabaseKt.getDatabase(Firebase.INSTANCE);
   }

   // $FF: synthetic method
   public static final Location access$getLastLocation$p(MapsActivity $this) {
      Location var10000 = $this.lastLocation;
      if (var10000 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("lastLocation");
      }

      return var10000;
   }

   // $FF: synthetic method
   public static final boolean access$getLocationUpdateState$p(MapsActivity $this) {
      return $this.locationUpdateState;
   }
}
