package com.example.wildlifespotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);
    }
    public void returnToPinLocation(View v){
        Intent i = new Intent(this, PinLocationMenu.class);
        startActivity(i);
    }
}