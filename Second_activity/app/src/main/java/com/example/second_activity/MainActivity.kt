package com.example.second_activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity(), View.OnClickListener {
    var numberOfRuns:Int = 0;private set;
    var sharedPreferences: SharedPreferences? = null;private set;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn1 = findViewById(R.id.button1) as Button
        var btnAbout = findViewById(R.id.button_about) as Button
        var btnExit =  findViewById(R.id.button_about) as Button
        btn1.setOnClickListener(this)
        btnAbout.setOnClickListener(this)
        btnExit.setOnClickListener(this)
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        numberOfRuns = sharedPreferences!!.getInt("NumberOfRuns", 0)
        Toast.makeText(this, "Está é a "+(numberOfRuns+1)+" Vez que a aplicação roda!",Toast.LENGTH_LONG).show()
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

    override fun onPause() {
        super.onPause()
        var sharedPreferencesEditor = sharedPreferences?.edit() as SharedPreferences.Editor
        if(sharedPreferencesEditor != null){
            sharedPreferencesEditor.putInt("NumberOfRuns", numberOfRuns+1)
            sharedPreferencesEditor.commit()
        }

    }
}