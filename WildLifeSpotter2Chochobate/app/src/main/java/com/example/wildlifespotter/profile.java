package com.example.wildlifespotter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity {

    FirebaseAuth fAuth;
    FirebaseUser User;
    Button DisplayData;
    DatabaseReference reference;
     TextView Utext;
     TextView Ptext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fAuth = FirebaseAuth.getInstance();
        User = fAuth.getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference().child(User.getUid());
        Utext = findViewById(R.id.textView2);
        Ptext = findViewById(R.id.textView3);
        DisplayData = findViewById(R.id.button4);
    }

    public void buttonclick(View v){

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String username = dataSnapshot.child("username").getValue(String.class);
                Utext.setText(username);
                String password = dataSnapshot.child("password").getValue(String.class);
                Ptext.setText(password);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void returnToMain(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void launchEmailActivity(View v){
        Intent i = new Intent(this, emailActivity.class);
        startActivity(i);
    }
}