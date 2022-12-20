package com.sp.qrcodeprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonTestActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> name=new ArrayList<>();
    ArrayList<String> email=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_json_test);

            recyclerView=findViewById(R.id.recyclerView);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager);

        try {
            JSONObject jsonObject=new JSONObject(JsonDataFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("users");
            for(int i=0; i<jsonArray.length(); i++){
                JSONObject userData=jsonArray.getJSONObject(i);
                name.add(userData.getString("name"));
                email.add(userData.getString("email"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HelperAdapter helperAdapter= new HelperAdapter(name,email,JsonTestActivity.this);
        recyclerView.setAdapter(helperAdapter);
    }

    private String JsonDataFromAsset() {
        String json=null;
        try {
            InputStream inputStream = getAssets().open("users.json");
            int sizeOfFile = inputStream.available();
            byte[] bufferData = new byte[sizeOfFile];
            inputStream.read(bufferData);
            inputStream.close();
            json=new String(bufferData,"UTF-8");

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
}