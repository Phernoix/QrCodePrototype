package com.sp.qrcodeprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.color.DynamicColors;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        DynamicColors.applyToActivitiesIfAvailable(getApplication());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button manualBtn = (Button)findViewById(R.id.manualForm);
        Button jsonBtn = (Button)findViewById(R.id.jsonTest);
        Button qrBtn = (Button)findViewById(R.id.qrScan);

        qrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, QRScannerActivity.class));
            }
        });

        manualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormActivity.class));
            }
        });
        jsonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, JsonTestActivity.class));
            }
        });


    }


}