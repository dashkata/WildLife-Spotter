package com.example.wildlifespotter;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.api.Distribution;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.lang.invoke.ConstantCallSite;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public void load_animals(){
        LinearLayout l_layout = (LinearLayout) findViewById(R.id.layoutid);
        l_layout.setOrientation(LinearLayout.VERTICAL);
        for (int i = 1; i <= 20; i++) {


        }





        CollectionReference col_animal_ref = db.collection("Regions").document("Region_Vitosha").collection("Animals Vitosha");
        col_animal_ref.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot document : task.getResult()){


                        String animal_name = document.getString("Animal_Name");





                    }
                }else{
                    Log.d(TAG, "Error getting documents: ", task.getException());

                }

            }
        });

    }








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load_animals();






    }
    public void launchPinLocation(View v){
        Intent i = new Intent(this, PinLocationMenu.class);
        startActivity(i);
    }
    public void launchMapMenu(View v){
        Intent i = new Intent(this, BrowseMapMenu.class);
        startActivity(i);
    }
    public void printData(View v){
        load_animals();








    }








}




