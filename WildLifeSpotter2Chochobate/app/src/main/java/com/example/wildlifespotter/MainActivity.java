package com.example.wildlifespotter;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    Button resendCode, profile;
    TextView VerifyMsg;
    FirebaseAuth fAuth;
    FirebaseUser user;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resendCode = findViewById(R.id.resendLink);
        VerifyMsg = findViewById(R.id.VerifyMsg);
        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();
        profile = findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),profile.class));
            }
        });

        if (!user.isEmailVerified()){
            VerifyMsg.setVisibility(View.VISIBLE);
            resendCode.setVisibility(View.VISIBLE);

            resendCode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(v.getContext(), "Verification Email has been sent.", Toast.LENGTH_SHORT).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("tag", "onFailure: Verification Email has not been sent" + e.getMessage());
                        }
                    });

                }
            });
        }

    }
    public void launchPinLocationMenu(View v){
        Intent i = new Intent(this, PinLocationMenu.class);
        startActivity(i);
    }
    public void launchBrowseMapMenu(View v){
        Intent i = new Intent(this, BrowseMapMenu.class);
        startActivity(i);
    }
    public void LOGOUT(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}