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

    public void filterButton(View v){

    }

    public void getDataOfAnimal(View v){

        String id=String.valueOf(v.getTag());
        Connection conn = null;
        try {

            String url = "jdbc:mariadb://78.90.62.227:3306/regions_database";
            conn = DriverManager.getConnection(url,"user","1234");

            Statement stmt = null;
            String animal_query = "select animals, animals_info from animals where ID="+id;


            try{
                stmt = conn.createStatement();

                ResultSet rs =  stmt.executeQuery(animal_query);

                rs.next();
                String animal = rs.getString("animals");
                String animal_info = rs.getString("animals_info");
                Intent i = new Intent(this, AnimalInfoActivity.class);

                i.putExtra("animal_name_value", animal);
                i.putExtra("animal_info_value", animal_info);
                startActivity(i);
                finish();


//






            }catch (SQLException e ) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }





        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }








;
    }
    public void getDataOfPlant(View v){
        String id=String.valueOf(v.getTag());

        Connection conn = null;


        try {

            String url = "jdbc:mariadb://78.90.62.227:3306/regions_database";
            conn = DriverManager.getConnection(url,"user","1234");

            Statement stmt = null;
            String plants_query = "select plants, plants_info from plants where ID="+id;

            try{
                stmt = conn.createStatement();

                ResultSet rs =  stmt.executeQuery(plants_query);

                rs.next();
                String plant = rs.getString("plants");
                String plant_info = rs.getString("plants_info");
                Intent i = new Intent(this, PlantInfoActivity.class);

                i.putExtra("plant_name_value", plant);
                i.putExtra("plant_info_value", plant_info);
                startActivity(i);
                finish();



            }catch (SQLException e ) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }





        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }


    }
}