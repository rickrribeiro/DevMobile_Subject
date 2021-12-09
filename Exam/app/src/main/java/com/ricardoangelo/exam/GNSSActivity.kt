package com.ricardoangelo.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class GNSSActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gnssactivity)
         var btnGNSSLocation = findViewById<Button>(R.id.btnGNSSLocation)
        btnGNSSLocation.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if(p0?.id == R.id.btnGNSSLocation) {
            
            val intent = Intent(this, GNSSLocationActivity::class.java)
            startActivity(intent)
        }
    }
}