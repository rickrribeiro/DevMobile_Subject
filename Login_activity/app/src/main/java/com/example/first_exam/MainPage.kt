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
        var btnExit = findViewById(R.id.btnExit) as Button
        btnExit.setOnClickListener(this)
        var btnCredits = findViewById(R.id.btnCredits) as Button
        btnCredits.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if(R.id.btnExit == p0?.id){
            ///android.os.Process.killProcess(android.os.Process.myPid())
            var intent: Intent = Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            System.exit(1);
        }else if(p0?.id == R.id.btnCredits){
             val intent = Intent(this, CreditsPage::class.java)
            startActivity(intent)
        }else{

            val intent = Intent(this, ConfigMapPage::class.java)
            startActivity(intent)
        }
    }
}