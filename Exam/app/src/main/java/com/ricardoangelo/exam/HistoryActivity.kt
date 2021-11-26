package com.ricardoangelo.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HistoryActivity : AppCompatActivity(), View.OnClickListener {
    var database = Firebase.database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        var btnHistoryMap = findViewById<Button>(R.id.btnHistoryMap)
        btnHistoryMap.setOnClickListener(this)
        var btnHistoryTable = findViewById<Button>(R.id.btnHistoryTable)
        btnHistoryTable.setOnClickListener(this)
        var btnHistoryClear = findViewById<Button>(R.id.btnHistoryClear)
        btnHistoryClear.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if(p0?.id == R.id.btnHistoryMap){
           
        }
        if(p0?.id == R.id.btnHistoryTable){
           
        }
        if(p0?.id == R.id.btnHistoryClear){
           val myRef = database.getReference("location_history")
           myRef.setValue("")
        }
    }
}