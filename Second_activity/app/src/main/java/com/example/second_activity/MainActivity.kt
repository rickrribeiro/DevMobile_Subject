package com.example.second_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn1 = findViewById(R.id.button1) as Button
        var btnAbout = findViewById(R.id.button_about) as Button
        var btnExit =  findViewById(R.id.button_about) as Button
        btn1.setOnClickListener(this)
        btnAbout.setOnClickListener(this)
        btnExit.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        Toast.makeText(this,"Fui pressionado "+(p0 as Button).text.toString(), Toast.LENGTH_LONG).show()
        if (p0.id==R.id.button_exit) {finish()}
        // if xxxxxxx do_it else do_it
        if (p0.id == R.id.button_about){
            var intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
        if (p0.id == R.id.button1){
            var intentConfig = Intent(this, ConfigActivity::class.java)
            startActivity(intentConfig)
        }
    }
}