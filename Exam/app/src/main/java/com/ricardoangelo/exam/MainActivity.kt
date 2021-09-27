package com.ricardoangelo.exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnConfig = findViewById<Button>(R.id.button4)
        btnConfig.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if(p0?.id == R.id.btnCredits){
             val intent = Intent(this, CreditsPage::class.java)
            startActivity(intent)
        }else if(p0?.id == R.id.button4){
            val intent = Intent(this, ConfigPage::class.java)
            startActivity(intent)
        }
    }
}