package com.sp.qrcodeprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TestForJson extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TextView jsonTest = findViewById(R.id.textView2);
        String jsonData= "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_for_json);
        jsonData= getIntent().getStringExtra("Json_Data");
        Log.d(null,jsonData);
        //jsonTest.setText(jsonData);

    }

}