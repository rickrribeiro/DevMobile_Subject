package com.ricardoangelo.exam

import android.location.GnssStatus
import android.location.GnssStatus.Builder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi

class GNSSLocationActivity : AppCompatActivity() {
        @RequiresApi(Build.VERSION_CODES.R)
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gnsslocation)
        val mGnssStatusBuild = GnssStatus.Builder().build()

        val sateliteCount = mGnssStatusBuild.satelliteCount

        val tvSateliteCount = findViewById<TextView>(R.id.tvSateliteCount)
        tvSateliteCount.text ="Quantidade de satélites: "+sateliteCount.toString()
    }
}