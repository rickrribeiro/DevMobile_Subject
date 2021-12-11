package com.ricardoangelo.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ktx.DatabaseKt;
import com.google.firebase.ktx.Firebase;

public class HistoryActivityJava extends AppCompatActivity {
    FirebaseDatabase database = DatabaseKt.getDatabase(Firebase.INSTANCE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_java);
        Button btnHistoryTable = findViewById(R.id.btnHistoryTable);
        btnHistoryTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.btnGNSSLocation) {

                    Intent intent = new Intent(view.getContext() ,TableHistoryActivity.class);
                    startActivity(intent);
                }
            }
        });
        Button btnHistoryClear = findViewById(R.id.btnHistoryClear);
        btnHistoryClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference myRef = database.getReference("location_history");
                myRef.setValue("");
            }
        });
    }
}