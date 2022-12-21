package com.sp.qrcodeprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String jsonData= "";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        jsonData= getIntent().getStringExtra("Json_Data");
        Log.d(null,jsonData);
    }
    //@Override
    //public void
}