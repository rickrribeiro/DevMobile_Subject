package com.ricardoangelo.exam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public final class SplashScreenJava extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_splash_screen);
        ActionBar var10000 = this.getSupportActionBar();
        if (var10000 != null) {
            var10000.hide();
        }

        this.getWindow().setFlags(1024, 1024);
        (new Handler()).postDelayed((Runnable)(new Runnable() {
            public final void run() {
                Intent intent = new Intent((Context)SplashScreenJava.this, MainActivity.class);
                SplashScreenJava.this.startActivity(intent);
                SplashScreenJava.this.finish();
            }
        }), 500L);
    }
}
