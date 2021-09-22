package com.example.second_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceActivity
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.Toast

class ConfigActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)
        var rbMale:RadioButton;var rbFemale:RadioButton;
        rbMale = findViewById(R.id.radioMale) as RadioButton
        rbFemale = findViewById(R.id.radioFemale) as RadioButton
        rbMale.setOnCheckedChangeListener(this)
        rbFemale.setOnCheckedChangeListener(this)

        //Getpreferences
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
      if(p0?.id==R.id.radioMale && p1){
          Toast.makeText(this,"Masculino", Toast.LENGTH_SHORT).show()
      }else{
          Toast.makeText(this,"Feminino", Toast.LENGTH_SHORT).show()
      }
    }
}