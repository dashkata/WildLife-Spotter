package com.example.wildlifespotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BrowseMapMenu extends AppCompatActivity{
//    private Spinner spinner;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_browse_map_menu);
//
//        spinner = findViewById(R.id.spinner);
//
//        List<String> categories = new ArrayList<>();
//        categories.add(0, "Изберете регион");
//        categories.add("Дунавска равнина");
//        categories.add("Старопланинска област");
//        categories.add("Краищенско - средногорска зона");
//        categories.add("Тракийско - странджанска зона");
//        categories.add("Рило - родопска зона");
//        categories.add("Черноморска зона");
//
//        ArrayAdapter<String> dataAdapter;
//        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
//
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        spinner.setAdapter(dataAdapter);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (parent.getItemAtPosition(position).equals("Изберете регион")) {
//                    //do nothing
//                }
//                else
//                    {
//                    //on selecting a spinner item
//                    String item = parent.getItemAtPosition(position).toString();
//
//                    //show selected spinner item
//                    Toast.makeText(parent.getContext(), "Избрахте: " + item, Toast.LENGTH_SHORT).show();
//
//                    if(parent.getItemAtPosition(position).equals("Дунавска равнина")){
//                        ImageView img= (ImageView) findViewById(R.id.imageView4);
//                        img.setImageResource(R.drawable.map_dunavska);
//                    }
//                    if(parent.getItemAtPosition(position).equals("Старопланинска област")){
//                        ImageView img= (ImageView) findViewById(R.id.imageView4);
//                        img.setImageResource(R.drawable.map_stara_planina);
//                    }
//                    if(parent.getItemAtPosition(position).equals("Краищенско - средногорска зона")){
//                        ImageView img= (ImageView) findViewById(R.id.imageView4);
//                        img.setImageResource(R.drawable.map_sredna_gora);
//                    }
//                    if(parent.getItemAtPosition(position).equals("Тракийско - странджанска зона")){
//                        ImageView img= (ImageView) findViewById(R.id.imageView4);
//                        img.setImageResource(R.drawable.map_strandja);
//                    }
//                    if(parent.getItemAtPosition(position).equals("Рило - родопска зона")){
//                        ImageView img= (ImageView) findViewById(R.id.imageView4);
//                        img.setImageResource(R.drawable.map_rila_rodopi);
//                    }
//                    if(parent.getItemAtPosition(position).equals("Черноморска зона")){
//                        ImageView img= (ImageView) findViewById(R.id.imageView4);
//                        img.setImageResource(R.drawable.map_cherno_more);
//                    }
//                }
//            }
//
//
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//    }
//
//    public void returnToMain(View v){
//        Intent i = new Intent(this, MainActivity.class);
//        startActivity(i);
//    }
private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_map_menu);

        spinner = findViewById(R.id.spinner2);

        List<String> categories = new ArrayList<>();
        categories.add(0, "Изберете регион");
        categories.add("Дунавска равнина");
        categories.add("Старопланинска област");
        categories.add("Краищенско - средногорска зона");
        categories.add("Тракийско - странджанска зона");
        categories.add("Рило - родопска зона");
        categories.add("Черноморска зона");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Изберете регион")) {
                    //do nothing
                }
                else
                {
                    //on selecting a spinner item
                    String item = parent.getItemAtPosition(position).toString();

                    //show selected spinner item
                    Toast.makeText(parent.getContext(), "Избрахте: " + item, Toast.LENGTH_SHORT).show();

                    if(parent.getItemAtPosition(position).equals("Дунавска равнина")){
                        ImageView img= (ImageView) findViewById(R.id.imageView3);
                        img.setImageResource(R.drawable.map_dunavska);
                    }
                    if(parent.getItemAtPosition(position).equals("Старопланинска област")){
                        ImageView img= (ImageView) findViewById(R.id.imageView3);
                        img.setImageResource(R.drawable.map_stara_planina);
                    }
                    if(parent.getItemAtPosition(position).equals("Краищенско - средногорска зона")){
                        ImageView img= (ImageView) findViewById(R.id.imageView3);
                        img.setImageResource(R.drawable.map_sredna_gora);
                    }
                    if(parent.getItemAtPosition(position).equals("Тракийско - странджанска зона")){
                        ImageView img= (ImageView) findViewById(R.id.imageView3);
                        img.setImageResource(R.drawable.map_strandja);
                    }
                    if(parent.getItemAtPosition(position).equals("Рило - родопска зона")){
                        ImageView img= (ImageView) findViewById(R.id.imageView3);
                        img.setImageResource(R.drawable.map_rila_rodopi);
                    }
                    if(parent.getItemAtPosition(position).equals("Черноморска зона")){
                        ImageView img= (ImageView) findViewById(R.id.imageView3);
                        img.setImageResource(R.drawable.map_cherno_more);
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
