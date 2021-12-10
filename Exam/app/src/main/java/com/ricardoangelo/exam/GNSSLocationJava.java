package com.ricardoangelo.exam;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.location.GnssStatus;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class GNSSLocationJava extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gnsslocation_java);
        GnssStatus mGnssStatusBuild = new GnssStatus.Builder().build();

        Integer sateliteCount = mGnssStatusBuild.getSatelliteCount();

        TextView tvSateliteCount = (TextView)findViewById(R.id.tvSateliteCount);
        tvSateliteCount.setText("Quantidade de satélites: "+sateliteCount.toString()); 
    }
}