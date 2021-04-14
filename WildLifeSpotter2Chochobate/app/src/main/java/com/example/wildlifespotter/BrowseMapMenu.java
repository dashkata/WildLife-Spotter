package com.example.wildlifespotter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firestore.v1.StructuredQuery;

import java.util.ArrayList;
import java.util.List;

public class BrowseMapMenu extends AppCompatActivity{
    TextView tekst;
    TextView tekst2;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference Regions = db.collection("Regions");
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_map_menu);

        spinner = findViewById(R.id.spinner2);
        tekst = findViewById(R.id.textView);
        tekst2 = findViewById(R.id.textView3);

        List<String> categories = new ArrayList<>();
        categories.add(0, "Изберете регион");
        categories.add("Дунавска равнина");
        categories.add("Старопланинска област");
        categories.add("Краищенско - средногорска зона");
        categories.add("Тракийско - странджанска зона");
        categories.add("Рило - родопска зона");
        categories.add("Черноморска зона");

        ImageView img_krotushka = (ImageView) findViewById(R.id.imageView4);
        ImageView img_ribarka = (ImageView) findViewById(R.id.imageView5);

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
                        //ocvetqva mapa
                        ImageView img = (ImageView) findViewById(R.id.imageView3);
                        img.setImageResource(R.drawable.map_dunavska);

                        img_krotushka.setImageResource(R.drawable.balkanska_krotushka_icon);
                        img_ribarka.setImageResource(R.drawable.obiknovenna_purchovka_icon);

                        img_krotushka.setVisibility(View.VISIBLE);
                        img_ribarka.setVisibility(View.VISIBLE);
                        tekst.setVisibility(View.VISIBLE);
                        tekst2.setVisibility(View.VISIBLE);

                        DocumentReference docRef = db.collection("Regions").document("Balkanska_krotushka");
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

                        DocumentReference docRef2 = db.collection("Regions").document("Obiknovenna_purchovka");
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
                    if(parent.getItemAtPosition(position).equals("Старопланинска област")){
                        //ocvetqva mapa
                        ImageView img= (ImageView) findViewById(R.id.imageView3);
                        img.setImageResource(R.drawable.map_stara_planina);

                        ImageView img_andreev = (ImageView) findViewById(R.id.imageView4);
                        img_andreev.setImageResource(R.drawable.andreev_eupolibotrus_icon);
                        ImageView img_glavoch = (ImageView) findViewById(R.id.imageView5);
                        img_glavoch.setImageResource(R.drawable.glavoch_icon);

                        DocumentReference docRef = db.collection("Regions").document("Andreev_eupolibotrus");
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

                        DocumentReference docRef2 = db.collection("Regions").document("Glavoch");
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
                    if(parent.getItemAtPosition(position).equals("Краищенско - средногорска зона")){
                        //ocvetqva mapa
                        ImageView img = (ImageView) findViewById(R.id.imageView3);
                        img.setImageResource(R.drawable.map_dunavska);

                        ImageView img_voden_paqk = (ImageView) findViewById(R.id.imageView4);
                        img_voden_paqk.setImageResource(R.drawable.voden_paqk_icon);
                        ImageView img_stepen_blatar = (ImageView) findViewById(R.id.imageView5);
                        img_stepen_blatar.setImageResource(R.drawable.stepen_blatar_icon);

                        img_krotushka.setVisibility(View.VISIBLE);
                        img_ribarka.setVisibility(View.VISIBLE);
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

                        DocumentReference docRef2 = db.collection("Regions").document("Stepen_blatar");
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
                    if(parent.getItemAtPosition(position).equals("Тракийско - странджанска зона")){
                        ImageView img = (ImageView) findViewById(R.id.imageView3);
                        img.setImageResource(R.drawable.map_dunavska);

                        ImageView img_golqm_kresliv_orel = (ImageView) findViewById(R.id.imageView4);
                        img_golqm_kresliv_orel.setImageResource(R.drawable.golqm_kresliv_orel_icon);
                        ImageView img_golqm_maslinov_prismehulnik = (ImageView) findViewById(R.id.imageView5);
                        img_golqm_maslinov_prismehulnik.setImageResource(R.drawable.golqm_maslinov_prismehulnik_icon);

                        img_krotushka.setVisibility(View.VISIBLE);
                        img_ribarka.setVisibility(View.VISIBLE);
                        tekst.setVisibility(View.VISIBLE);
                        tekst2.setVisibility(View.VISIBLE);

                        DocumentReference docRef = db.collection("Regions").document("Golqm_kresliv_orel");
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

                        DocumentReference docRef2 = db.collection("Regions").document("Golqm_maslinov_prismehulnik");
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
                    if(parent.getItemAtPosition(position).equals("Рило - родопска зона")){
                        ImageView img = (ImageView) findViewById(R.id.imageView3);
                        img.setImageResource(R.drawable.map_dunavska);

                        ImageView img_ivichest_smok = (ImageView) findViewById(R.id.imageView4);
                        img_ivichest_smok.setImageResource(R.drawable.ivichest_smok_icon);
                        ImageView img_koteshka_zmiq = (ImageView) findViewById(R.id.imageView5);
                        img_koteshka_zmiq.setImageResource(R.drawable.koteshka_zmiq_icon);

                        img_krotushka.setVisibility(View.VISIBLE);
                        img_ribarka.setVisibility(View.VISIBLE);
                        tekst.setVisibility(View.VISIBLE);
                        tekst2.setVisibility(View.VISIBLE);

                        DocumentReference docRef = db.collection("Regions").document("Ivichest_smok");
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

                        DocumentReference docRef2 = db.collection("Regions").document("Koteshka_zmiq");
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
                    if(parent.getItemAtPosition(position).equals("Черноморска зона")){
                        ImageView img = (ImageView) findViewById(R.id.imageView3);
                        img.setImageResource(R.drawable.map_dunavska);

                        ImageView img_afala = (ImageView) findViewById(R.id.imageView4);
                        img_afala.setImageResource(R.drawable.afala_icon);
                        ImageView img_trevno_popche = (ImageView) findViewById(R.id.imageView5);
                        img_trevno_popche.setImageResource(R.drawable.trevno_popche_icon);

                        img_krotushka.setVisibility(View.VISIBLE);
                        img_ribarka.setVisibility(View.VISIBLE);
                        tekst.setVisibility(View.VISIBLE);
                        tekst2.setVisibility(View.VISIBLE);

                        DocumentReference docRef = db.collection("Regions").document("Afala");
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

                        DocumentReference docRef2 = db.collection("Regions").document("Trevno_popche");
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

    public void returnToMain(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}