package com.ricardoangelo.exam;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class GNSSActivityJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gnssjava);
        Button btnGNSSLocation = (Button)findViewById(R.id.btnGNSSLocation);
        btnGNSSLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(view.getId() == R.id.btnGNSSLocation) {

            Intent intent = new Intent(view.getContext() ,GNSSLocationActivity.class);
            startActivity(intent);
        }
            }
        });
    }
}

