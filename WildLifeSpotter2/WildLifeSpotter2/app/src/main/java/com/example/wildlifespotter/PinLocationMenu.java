package com.example.wildlifespotter;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public  class PinLocationMenu extends AppCompatActivity {
    Spinner spinner;
    Button button;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_location_menu);
        spinner = findViewById(R.id.spinner);
        List<String> category_array = new ArrayList<>();
        category_array.add(0, "Set Category");
        category_array.add("None");
        category_array.add("Animals");
        category_array.add("Plants");


        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, category_array);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Set Catergory")){


                }
                else{

                    if(parent.getItemAtPosition(position).equals("Animals"))
                    {
                        findViewById(R.id.DivaKoza).setVisibility(View.VISIBLE);
                        findViewById(R.id.Vulk).setVisibility(View.VISIBLE);
                        findViewById(R.id.Laluger).setVisibility(View.VISIBLE);
                        findViewById(R.id.MalukQstreb).setVisibility(View.VISIBLE);
                        findViewById(R.id.Vidra).setVisibility(View.VISIBLE);
                        findViewById(R.id.Hvoina).setVisibility(View.INVISIBLE);
                        findViewById(R.id.Metlichina).setVisibility(View.INVISIBLE);
                        findViewById(R.id.Smurch).setVisibility(View.INVISIBLE);
                        findViewById(R.id.Purchovka).setVisibility(View.INVISIBLE);
                        findViewById(R.id.Tociq).setVisibility(View.INVISIBLE);

                    }
                    else if(parent.getItemAtPosition(position).equals("Plants"))

                    {
                        findViewById(R.id.Hvoina).setVisibility(View.VISIBLE);
                        findViewById(R.id.Metlichina).setVisibility(View.VISIBLE);
                        findViewById(R.id.Smurch).setVisibility(View.VISIBLE);
                        findViewById(R.id.Purchovka).setVisibility(View.VISIBLE);
                        findViewById(R.id.Tociq).setVisibility(View.VISIBLE);
                        findViewById(R.id.Vidra).setVisibility(View.INVISIBLE);
                        findViewById(R.id.MalukQstreb).setVisibility(View.INVISIBLE);
                        findViewById(R.id.Laluger).setVisibility(View.INVISIBLE);
                        findViewById(R.id.Vulk).setVisibility(View.INVISIBLE);
                        findViewById(R.id.DivaKoza).setVisibility(View.INVISIBLE);

                    }
                    else if(parent.getItemAtPosition(position).equals("None"))
                    {
                        findViewById(R.id.Hvoina).setVisibility(View.VISIBLE);
                        findViewById(R.id.Metlichina).setVisibility(View.VISIBLE);
                        findViewById(R.id.Smurch).setVisibility(View.VISIBLE);
                        findViewById(R.id.Purchovka).setVisibility(View.VISIBLE);
                        findViewById(R.id.Tociq).setVisibility(View.VISIBLE);
                        findViewById(R.id.DivaKoza).setVisibility(View.VISIBLE);
                        findViewById(R.id.Vulk).setVisibility(View.VISIBLE);
                        findViewById(R.id.Laluger).setVisibility(View.VISIBLE);
                        findViewById(R.id.MalukQstreb).setVisibility(View.VISIBLE);
                        findViewById(R.id.Vidra).setVisibility(View.VISIBLE);
                    }





                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
    public void returnToMain(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}