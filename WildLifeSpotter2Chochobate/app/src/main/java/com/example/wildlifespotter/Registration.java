package com.example.wildlifespotter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.stats.LoggingConstants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.auth.User;

public class Registration extends AppCompatActivity {
    private static final String TAG = "";
    EditText mFullname,mEmail,mPassword,mPhone;
    Button mRegisterbtn;
    TextView mLoginbtn;
    FirebaseAuth fAuth;
    FirebaseUser User;
    DatabaseReference rootReference;

    ProgressDialog dialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mFullname  = findViewById(R.id.fullname);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegisterbtn = findViewById(R.id.registerbtn);
        mLoginbtn = findViewById(R.id.lgnbtn);

        fAuth = FirebaseAuth.getInstance();
        rootReference = FirebaseDatabase.getInstance().getReference();

        dialog = new ProgressDialog(this);



        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }


        mRegisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = mEmail.getText().toString().trim();
                String Password = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(Email)){
                    mEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(Password)) {
                    mPassword.setError("Password is required");
                    return;
                }
                if (Password.length() < 8) {
                    mPassword.setError("Password must be 8 or more characters");
                    return;
                }
                //register the user in firebase

                fAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        dialog.setMessage("Registering, please wait");
                        dialog.show();

                        if (task.isSuccessful()){
                            dialog.dismiss();
                            //send verification link
                            FirebaseUser user = fAuth.getCurrentUser();
                            user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Registration.this, "Verification Email has been sent.", Toast.LENGTH_SHORT).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure: Verification Email has not been sent" + e.getMessage());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                            User = fAuth.getCurrentUser();
                            user myUserInsertObj = new user(Email,Password);

                            rootReference.child(User.getUid()).setValue(myUserInsertObj)

                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            dialog.dismiss();
                                            Toast.makeText(getApplicationContext(), "Values have been stored in DB", Toast.LENGTH_SHORT).show();
                                            finish();
                                            Intent myIntent = new Intent(getApplicationContext(),profile.class);
                                            startActivity(myIntent);
                                        }

                                    }
                                });
                        } else {
                            dialog.dismiss();
                            Toast.makeText(Registration.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });

            }
        });
        mLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
}