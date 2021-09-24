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
        if(attempts>=3){
            /////////// SUBSTITUIR ISSO POR FECHAR A APLICAÇÃO E LEMBRAR DE USAR STRING
            Toast.makeText(this, "NÃO FOI POSSIVEL RODAR", Toast.LENGTH_LONG).show()
        }
        
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000) 
    }
}