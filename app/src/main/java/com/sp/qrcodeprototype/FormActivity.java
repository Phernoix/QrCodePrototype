package com.sp.qrcodeprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        EditText editTextCustName  = findViewById(R.id.editTextCustomerName);
        EditText editTextAddr  = findViewById(R.id.editTextAddress);
        EditText editTextLoc  = findViewById(R.id.editTextLocation);


        String jsonData= "";
        jsonData= getIntent().getStringExtra("Json_Data");
        //Log.d(null,jsonData);

        if(jsonData != null && !jsonData.trim().isEmpty()) {
            Log.d(null,jsonData);
            try {
                JSONObject mainObject = new JSONObject(jsonData);
                JSONObject infoObject = mainObject.getJSONObject("info");
                String custName = infoObject.getString("customername");
                String address = infoObject.getString("address");
                String location = infoObject.getString("location");
                editTextCustName.setText(custName);
                editTextAddr.setText(address);
                editTextLoc.setText(location);

            }catch(JSONException e){
                e.printStackTrace();
            }


        }else{
            Log.d(null,"EMPTY");
        }
    }
    //@Override
    //public void
}