package com.ricardoangelo.exam;

import android.location.GnssStatus;
import android.location.GnssStatus.Builder;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import kotlin.jvm.internal.Intrinsics;

public final class GNSSLocationActivityJava extends AppCompatActivity {
    @RequiresApi(30)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_gnsslocation);
        GnssStatus var10001 = (new Builder()).build();
        Intrinsics.checkNotNullExpressionValue(var10001, "GnssStatus.Builder().build()");
        this.onSatelliteStatusChanged(var10001);
    }

    @RequiresApi(24)
    public final void onSatelliteStatusChanged(GnssStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        TextView tvSateliteCount = (TextView)this.findViewById(R.id.tvSateliteCount);
        Intrinsics.checkNotNullExpressionValue(tvSateliteCount, "tvSateliteCount");
        tvSateliteCount.setText((CharSequence)("Quantidade de satélites = " + status + "\n" + status.getSatelliteCount()));
    }
}
