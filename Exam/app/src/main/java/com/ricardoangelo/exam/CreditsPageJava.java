package com.ricardoangelo.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class CreditsPageJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits_page_java);
        TextView text = (TextView) findViewById(R.id.textCredits);
        text.setMovementMethod(ScrollingMovementMethod.getInstance());
        text.setSelected(true);
        text.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        text.setText("Feito Por: Ricardo Ribeiro, Angelo Neves, Demas, Amanda e Atila!");
    }
}