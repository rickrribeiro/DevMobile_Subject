package com.ricardoangelo.exam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public final class MainActivityJava extends AppCompatActivity implements OnClickListener {
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        String[] permissions = new String[]{"android.permission.ACCESS_FINE_LOCATION"};
        ActivityCompat.requestPermissions((Activity)this, permissions, 0);
        String[] permissionsCoarse = new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
        ActivityCompat.requestPermissions((Activity)this, permissionsCoarse, 0);
        ActionBar var10000 = this.getSupportActionBar();
        if (var10000 != null) {
            var10000.hide();
        }

        Button btnConfig = (Button)this.findViewById(R.id.btnConfig);
        btnConfig.setOnClickListener((OnClickListener)this);
        Button btnNavigation = (Button)this.findViewById(R.id.btnNavigation);
        btnNavigation.setOnClickListener((OnClickListener)this);
        Button btnCredits = (Button)this.findViewById(R.id.btnNavigation);
        btnCredits.setOnClickListener((OnClickListener)this);
        Button btnHistory = (Button)this.findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener((OnClickListener)this);
        Button btnGNSS = (Button)this.findViewById(R.id.btnGNSS);
        btnGNSS.setOnClickListener((OnClickListener)this);
    }

    public void onClick( View p0) {
        Intent intent;
        if (p0 != null) {
            if (p0.getId() == R.id.btnCredits) {
                intent = new Intent((Context)this, CreditsPage.class);
                this.startActivity(intent);
                return;
            }
        }

        if (p0 != null) {
            if (p0.getId() == R.id.btnNavigation) {
                intent = new Intent((Context)this, MapsActivity.class);
                this.startActivity(intent);
                return;
            }
        }

        if (p0 != null) {
            if (p0.getId() == R.id.btnConfig) {
                intent = new Intent((Context)this, ConfigPage.class);
                this.startActivity(intent);
                return;
            }
        }

        if (p0 != null) {
            if (p0.getId() == R.id.btnHistory) {
                intent = new Intent((Context)this, HistoryActivity.class);
                this.startActivity(intent);
                return;
            }
        }

        if (p0 != null) {
            if (p0.getId() == 1000209) {
                intent = new Intent((Context)this, GNSSActivity.class);
                this.startActivity(intent);
            }
        }

    }
}
