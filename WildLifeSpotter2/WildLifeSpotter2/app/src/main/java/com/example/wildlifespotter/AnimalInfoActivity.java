package com.example.wildlifespotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AnimalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_info);
        TextView animal_name = (TextView)findViewById(R.id.Animal);
        String animal_name_value = getIntent().getExtras().getString("animal_name_value");
        animal_name.setText(animal_name_value);
        TextView animal_info = (TextView)findViewById(R.id.Animal_info);
        String animal_info_value = getIntent().getExtras().getString("animal_info_value");
        animal_info.setText(animal_info_value);


    }
    public void goBackToPinMenu(View v){
        Intent i = new Intent(this, PinLocationMenu.class);
        startActivity(i);

    }
}