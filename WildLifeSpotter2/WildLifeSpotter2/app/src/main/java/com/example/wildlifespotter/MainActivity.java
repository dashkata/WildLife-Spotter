package com.example.wildlifespotter;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void launchPinLocation(View v){
        Intent i = new Intent(this, PinLocationMenu.class);
        startActivity(i);
    }
    public void launchMapMenu(View v){
        Intent i = new Intent(this, BrowseMapMenu.class);
        startActivity(i);
    }

}