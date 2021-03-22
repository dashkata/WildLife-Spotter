package com.example.wildlifespotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlantInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_info);
        TextView plant_name = (TextView)findViewById(R.id.plant_Name);
        String plant_name_value = getIntent().getExtras().getString("plant_name_value");
        plant_name.setText(plant_name_value);
        TextView plant_info = (TextView)findViewById(R.id.plant_info);
        String plant_info_value = getIntent().getExtras().getString("plant_info_value");
        plant_info.setText(plant_info_value);
    }
    public void goBackToPinMenu(View v){
        Intent i = new Intent(this, PinLocationMenu.class);
        startActivity(i);

    }
}