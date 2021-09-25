package com.example.first_exam

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast

class ConfigMapPage : AppCompatActivity(), View.OnClickListener,
    RadioGroup.OnCheckedChangeListener {

    var sharedPreferences: SharedPreferences? = null;private set;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config_map_page)
        var valor = 0
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        var radio1 = findViewById(R.id.radio1) as RadioGroup
        radio1.setOnCheckedChangeListener(this)
        valor = sharedPreferences!!.getInt("radio1",0)
        if(valor != 0){
            radio1.check(valor)
        }
        var radio2 = findViewById(R.id.radio1) as RadioGroup
        radio2.setOnCheckedChangeListener(this)

        valor = sharedPreferences!!.getInt("radio2",0)
        if(valor != 0){
            radio1.check(valor)
        }
        var radio3 = findViewById(R.id.radio1) as RadioGroup
        radio3.setOnCheckedChangeListener(this)
        valor = sharedPreferences!!.getInt("radio3",0)
        if(valor != 0){
            radio1.check(valor)
        }
        var radio4 = findViewById(R.id.radio1) as RadioGroup
        radio4.setOnCheckedChangeListener(this)
        valor = sharedPreferences!!.getInt("radio4",0)
        if(valor != 0){
            radio1.check(valor)
        }
        var ligado = findViewById<CheckBox>(R.id.ligado)
        ligado.setOnClickListener(this)
        ligado.isChecked = sharedPreferences!!.getBoolean("ligado",false)
    }

    override fun onClick(p0: View?) {
        var sharedPreferencesEditor = sharedPreferences?.edit() as SharedPreferences.Editor
         
        if(p0?.id == R.id.ligado){
            if(sharedPreferencesEditor != null){
            sharedPreferencesEditor.putBoolean("ligado",(p0 as CheckBox)?.isChecked )
            sharedPreferencesEditor.commit()
            }
        }
    }

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
         var sharedPreferencesEditor = sharedPreferences?.edit() as SharedPreferences.Editor
         Toast.makeText(this, (p0 as RadioGroup)?.checkedRadioButtonId.toString(), Toast.LENGTH_LONG).show()
        if(R.id.radio1 == p0?.id){
            print( (p0 as RadioGroup)?.checkedRadioButtonId)
            if(sharedPreferencesEditor != null){
            sharedPreferencesEditor.putInt("radio1", (p0 as RadioGroup)?.checkedRadioButtonId)
            sharedPreferencesEditor.commit()
            }
        }
        
        if(p0?.id == R.id.radio2){
            print( (p0 as RadioGroup)?.checkedRadioButtonId)
            if(sharedPreferencesEditor != null){
            sharedPreferencesEditor.putInt("radio2",(p0 as RadioGroup)?.checkedRadioButtonId )
            sharedPreferencesEditor.commit()
            }
        }
        if(p0?.id == R.id.radio3){
            print( (p0 as RadioGroup)?.checkedRadioButtonId)
             if(sharedPreferencesEditor != null){
            sharedPreferencesEditor.putInt("radio3",(p0 as RadioGroup)?.checkedRadioButtonId )
            sharedPreferencesEditor.commit()
            }
        }
        if(p0?.id == R.id.radio4){

            print( (p0 as RadioGroup)?.checkedRadioButtonId)
             if(sharedPreferencesEditor != null){
            sharedPreferencesEditor.putInt("radio4",(p0 as RadioGroup)?.checkedRadioButtonId )
            sharedPreferencesEditor.commit()
            }
        }
    }
}