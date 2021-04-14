package com.example.wildlifespotter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class PinLocationMenu extends AppCompatActivity {
    Button btLocation;
    TextView regionText, countryText, tekst, tekst2;
    FusedLocationProviderClient fusedLocationProviderClient;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference Regions = db.collection("Regions");
    private Spinner spinner;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_location_menu);

        btLocation = findViewById(R.id.bt_location);
        regionText = findViewById(R.id.regionText);
        countryText = findViewById(R.id.countryText);
        spinner = findViewById(R.id.spinner2);
        tekst = findViewById(R.id.textView);
        tekst2 = findViewById(R.id.textView3);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        btLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(PinLocationMenu.this
                        , Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(PinLocationMenu.this
                            , new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }

            }
        });

        List<String> categories = new ArrayList<>();
        categories.add(0, "Изберете регион");
        categories.add("Благоевград");
        categories.add("Бургас");
        categories.add("Враца");
        categories.add("Варна");
        categories.add("Видин");
        categories.add("Велико Търново");
        categories.add("Габрово");
        categories.add("Добрич");
        categories.add("Кърджали");
        categories.add("Кюстендил");
        categories.add("Ловеч");
        categories.add("Монтана");
        categories.add("Пазадржик");
        categories.add("Перник");
        categories.add("Плевен");
        categories.add("Пловдив");
        categories.add("Разград");
        categories.add("Русе");
        categories.add("Силистра");
        categories.add("Сливен");
        categories.add("Смолян");
        categories.add("София");
        categories.add("Стара Загора");
        categories.add("Търговище");
        categories.add("Хасково");
        categories.add("Шумен");
        categories.add("Ямбол");


        ImageView img_voden_paqk = (ImageView) findViewById(R.id.imageView4);
        ImageView img_alpiisko_sekirche = (ImageView) findViewById(R.id.imageView5);

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Изберете регион")) {
                    //do nothing
                } else {
                    //on selecting a spinner item
                    String item = parent.getItemAtPosition(position).toString();

                    //show selected spinner item
                    Toast.makeText(parent.getContext(), "Избрахте: " + item, Toast.LENGTH_SHORT).show();

                    if (parent.getItemAtPosition(position).equals("София")) {
                        //ocvetqva mapa

                        img_voden_paqk.setImageResource(R.drawable.voden_paqk_icon);
                        img_alpiisko_sekirche.setImageResource(R.drawable.alpiisko_sekirche_icon);

                        img_voden_paqk.setVisibility(View.VISIBLE);
                        img_alpiisko_sekirche.setVisibility(View.VISIBLE);
                        tekst.setVisibility(View.VISIBLE);
                        tekst2.setVisibility(View.VISIBLE);

                        DocumentReference docRef = db.collection("Regions").document("Voden_paqk");
                        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document = task.getResult();
                                    if (document.exists()) {
                                        Log.d("слави трифонов", "DocumentSnapshot data: " + document.getData());

                                        tekst.setMovementMethod(new ScrollingMovementMethod());
                                        tekst.setText("" + document.getData());

                                    } else {
                                        Log.d("слави трифонов", "No such document");
                                    }
                                } else {
                                    Log.d("слави трифонов", "get failed with ", task.getException());
                                }
                            }
                        });

                        DocumentReference docRef2 = db.collection("Regions").document("Alpiisko_sekirche");
                        docRef2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    DocumentSnapshot document2 = task.getResult();
                                    if (document2.exists()) {
                                        Log.d("слави трифонов", "DocumentSnapshot data: " + document2.getData());

                                        tekst2.setMovementMethod(new ScrollingMovementMethod());
                                        tekst2.setText("" + document2.getData());

                                    } else {
                                        Log.d("слави трифонов", "No such document");
                                    }
                                } else {
                                    Log.d("слави трифонов", "get failed with ", task.getException());
                                }
                            }
                        });
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    try {
                        Geocoder geocoder = new Geocoder(PinLocationMenu.this,
                                Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1
                        );
                        countryText.setText(Html.fromHtml(
                                addresses.get(0).getCountryName()
                        ));
                        regionText.setText(Html.fromHtml(
                                addresses.get(0).getLocality() +
                                        "<font color='#000000'>,</font>"
                        ));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void returnToMain(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}