package com.ricardoangelo.exam;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ktx.DatabaseKt;
import com.google.firebase.ktx.Firebase;

import java.util.Iterator;

import kotlin.jvm.internal.Intrinsics;

public final class TableHistoryActivityJava extends AppCompatActivity {
    private FirebaseDatabase database;

    public final FirebaseDatabase getDatabase() {
        return this.database;
    }

    public final void setDatabase(FirebaseDatabase var1) {
        Intrinsics.checkNotNullParameter(var1, "<set-?>");
        this.database = var1;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_table_history);
        this.setUpTableData();
    }

    private final void setUpTableData() {
        DatabaseReference var10000 = this.database.getReference("location_history");
        Intrinsics.checkNotNullExpressionValue(var10000, "database.getReference(\"location_history\")");
        DatabaseReference myRef = var10000;
        Intrinsics.checkNotNullExpressionValue(myRef.get().addOnSuccessListener((OnSuccessListener)(new OnSuccessListener() {
            // $FF: synthetic method
            // $FF: bridge method
            public void onSuccess(Object var1) {
                this.onSuccess((DataSnapshot)var1);
            }

            public final void onSuccess(DataSnapshot it) {
                TextView tvLatitude = (TextView)TableHistoryActivityJava.this.findViewById(R.id.tvLatitude);
                TextView tvLongitude = (TextView)TableHistoryActivityJava.this.findViewById(R.id.tvLatitude);
                TextView tvDate = (TextView)TableHistoryActivityJava.this.findViewById(R.id.tvDate);
                Intrinsics.checkNotNullExpressionValue(tvLatitude, "tvLatitude");
                tvLatitude.setText((CharSequence)"");
                Intrinsics.checkNotNullExpressionValue(tvLongitude, "tvLongitude");
                tvLongitude.setText((CharSequence)"");
                Intrinsics.checkNotNullExpressionValue(tvDate, "tvDate");
                tvDate.setText((CharSequence)"");
                Intrinsics.checkNotNull(it);
                Iterable var10000 = it.getChildren();
                Intrinsics.checkNotNullExpressionValue(var10000, "it!!.children");
                Iterable $this$forEach$iv = var10000;
                int $i$f$forEach = 0;
                Iterator var7 = $this$forEach$iv.iterator();

                while(var7.hasNext()) {
                    Object element$iv = var7.next();
                    DataSnapshot itx = (DataSnapshot)element$iv;
                    int var10 = 0;
                    StringBuilder var10001 = new StringBuilder();
                    CharSequence var10002 = tvLatitude.getText();
                    if (var10002 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }

                    var10001 = var10001.append((String)var10002);
                    DataSnapshot var11 = itx.child("latitude");
                    Intrinsics.checkNotNullExpressionValue(var11, "it.child(\"latitude\")");
                    tvLatitude.setText((CharSequence)var10001.append(String.valueOf(var11.getValue())).append("\n").toString());
                    var10001 = new StringBuilder();
                    var10002 = tvLongitude.getText();
                    if (var10002 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }

                    var10001 = var10001.append((String)var10002);
                    var11 = itx.child("longitude");
                    Intrinsics.checkNotNullExpressionValue(var11, "it.child(\"longitude\")");
                    tvLongitude.setText((CharSequence)var10001.append(String.valueOf(var11.getValue())).append("\n").toString());
                    var10001 = new StringBuilder();
                    var10002 = tvDate.getText();
                    if (var10002 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }

                    var10001 = var10001.append((String)var10002);
                    var11 = itx.child("date");
                    Intrinsics.checkNotNullExpressionValue(var11, "it.child(\"date\")");
                    tvDate.setText((CharSequence)var10001.append(String.valueOf(var11.getValue())).append("\n").toString());
                }

            }
        })), "myRef.get().addOnSuccess…  }\n            \n       }");
    }

    public TableHistoryActivityJava() {
        this.database = DatabaseKt.getDatabase(Firebase.INSTANCE);
    }
}
