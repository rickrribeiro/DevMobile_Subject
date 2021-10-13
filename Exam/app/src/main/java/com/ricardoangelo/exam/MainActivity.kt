package com.ricardoangelo.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val permissions = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)
        ActivityCompat.requestPermissions(this, permissions,0)
        val permissionsCoarse = arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION)
        ActivityCompat.requestPermissions(this, permissionsCoarse,0)
        supportActionBar?.hide()
        var btnConfig = findViewById<Button>(R.id.btnConfig)
        btnConfig.setOnClickListener(this)
        var btnNavigation = findViewById<Button>(R.id.btnNavigation)
        btnNavigation.setOnClickListener(this)
        var btnCredits = findViewById<Button>(R.id.btnCredits)
        btnCredits.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if(p0?.id == R.id.btnCredits){
            
            val intent = Intent(this, CreditsPage::class.java)
            startActivity(intent)
        }else if(p0?.id == R.id.btnNavigation){
            
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
            
        }else if(p0?.id == R.id.btnConfig){
            val intent = Intent(this, ConfigPage::class.java)
            startActivity(intent)
            
        }
    }
}