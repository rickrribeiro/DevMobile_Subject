package com.example.first_exam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var username:String = "";private set;
    var password:String = "";private set;
    var attempts:Int = 0;private set;
    var sharedPreferences: SharedPreferences? = null;private set;
    ////// fazer uma com updateAttempts
    private fun updateUsernameAndPassword(username:String, password: String){
        var sharedPreferencesEditor = sharedPreferences?.edit() as SharedPreferences.Editor
        if(sharedPreferencesEditor != null){
            sharedPreferencesEditor.putString("username", username)
            sharedPreferencesEditor.putString("password", password)
            sharedPreferencesEditor.commit()
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        var attempts = sharedPreferences!!.getInt("attempts", 0)
        
        if(attempts>=3){
            Toast.makeText(this, "SE ESTIVER VENDO ISSO, LEMBRAR DE DESCOMENTAR A EXCEPTION", Toast.LENGTH_LONG).show()
            //throw Exception("Custom Message");
        }
        username = sharedPreferences!!.getString("username", "").toString()
        password = sharedPreferences!!.getString("password", "").toString()
        if(username=="" || password==""){
            username="admin"
            password="admin"
            updateUsernameAndPassword(username, password)
        }
        var btnLogin =  findViewById(R.id.btnLogin) as Button
        btnLogin.setOnClickListener(this)
        
    }

    override fun onClick(p0: View?) {
        
        if (p0!!.id==R.id.btnLogin){
            var inputUsername = findViewById<EditText>(R.id.inputUsername);
            var inputPassword = findViewById(R.id.inputPassword) as EditText;
           
            if(inputUsername.text.toString()==""){
                Toast.makeText(this, getString(R.string.username_missing), Toast.LENGTH_LONG).show()
            }else if(inputPassword.text.toString()==""){
                 Toast.makeText(this, getString(R.string.password_missing), Toast.LENGTH_LONG).show()
            }else{
                if(inputUsername.text.toString() == username && inputPassword.text.toString() == password){
                    var sharedPreferencesEditor = sharedPreferences?.edit() as SharedPreferences.Editor
                    if(sharedPreferencesEditor != null){
                        sharedPreferencesEditor.putInt("attempts", 0)
                        sharedPreferencesEditor.commit()
                    }
                    var intent = Intent(this, MainPage::class.java)
                    startActivity(intent)
                }else{

                    attempts = sharedPreferences!!.getInt("attempts", 0) +1
                    var sharedPreferencesEditor = sharedPreferences?.edit() as SharedPreferences.Editor
                    if(sharedPreferencesEditor != null){
                        sharedPreferencesEditor.putInt("attempts", attempts)
                        sharedPreferencesEditor.commit()
                    }
                    inputPassword.text.clear()
                    Toast.makeText(this, getString(R.string.wrong_password_1)+(3-attempts)+getString(R.string.wrong_password_2), Toast.LENGTH_LONG).show()    
                    if(attempts>=3){
                        Toast.makeText(this, "Você não tem mais tentativas!", Toast.LENGTH_LONG).show()
                        System.exit(0)
                    }
                }
            }
        }
        // if xxxxxxx do_it else do_it
        // if (p0.id == R.id.button_about){
        //     var intent = Intent(this, AboutActivity::class.java)
        //     startActivity(intent)
        // }
        
    }


}