package com.example.first_exam

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        var attempts = sharedPreferences!!.getInt("attempts", 0)
        var delay = 5000
        if(attempts>=3){
            delay = 0 
            //System.exit(0)
            //Toast.makeText(this, "SE ESTIVER VENDO ISSO, LEMBRAR DE DESCOMENTAR O EXIT", Toast.LENGTH_LONG).show()
        }
        
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, delay.toLong()) 
    }
}