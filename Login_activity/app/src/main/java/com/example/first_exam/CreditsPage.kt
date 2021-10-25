package com.example.first_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CreditsPage : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits_page)
        //btnBack
        var btnBack = findViewById(R.id.btnBack) as Button
        btnBack.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        System.exit(0)
    }
}