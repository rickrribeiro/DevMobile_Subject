package com.example.first_exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class MainPage : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        var btnConfig = findViewById(R.id.btnConfig) as ImageButton
        btnConfig.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, ConfigPage::class.java)
        startActivity(intent)
    }
}