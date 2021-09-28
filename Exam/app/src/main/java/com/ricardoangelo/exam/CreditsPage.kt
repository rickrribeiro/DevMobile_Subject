package com.ricardoangelo.exam

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.method.ScrollingMovementMethod
import android.view.animation.AnimationUtils
import android.widget.ScrollView
import android.widget.TextView

class CreditsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits_page)
        var text = findViewById<TextView>(R.id.textCredits)
        text.movementMethod = ScrollingMovementMethod.getInstance()
        text.isSelected = true
        text.ellipsize = TextUtils.TruncateAt.MARQUEE
        text.text="Feito Por: Ricardo Ribeiro e Angelo Neves!"
    }
}