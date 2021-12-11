package com.ricardoangelo.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.content.SharedPreferences.Editor;

public class ConfigPageJavaOld extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_page_java);
        Integer valor = 0;
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        RadioGroup radio1 = findViewById(R.id.radio1);
        radio1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

            }
        }
        );     
        valor = sharedPreferences.getInt("radio1",0);
        //Toast.makeText(this,"VALOR: "+valor.toString(), Toast.LENGTH_LONG).show()
        if(valor != 0){
            radio1.check(valor);
        }
        RadioGroup radio2 = findViewById(R.id.radio2);
        radio2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

            }
        }
        );     
        valor = sharedPreferences.getInt("radio2",0);
        if(valor != 0){
            radio2.check(valor);
        }
        RadioGroup radio3 = findViewById(R.id.radio3);
        radio3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

            }
        }
        );     
        valor = sharedPreferences.getInt("radio3",0);
        if(valor != 0){
            radio3.check(valor);
        }
        RadioGroup radio4 = findViewById(R.id.radio4);
        radio4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

            }
        }
        );     
        valor = sharedPreferences.getInt("radio4",0);
        if(valor != 0){
            radio4.check(valor);
        }
        CheckBox ligado = findViewById(R.id.ligado);
        ligado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Editor sharedPreferencesEditor = sharedPreferences.edit();
        //Toast.makeText(this, "changed", Toast.LENGTH_LONG).show()
     
            if(sharedPreferencesEditor != null){
                sharedPreferencesEditor.putBoolean("ligado",ligado.isChecked());
                sharedPreferencesEditor.commit();
            }
        
        
            }
        });
        ligado.setChecked(sharedPreferences.getBoolean("ligado",false));
    }
}