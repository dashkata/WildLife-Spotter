package com.example.wildlifespotter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.audiofx.PresetReverb;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText mEmail,mPassword;
    Button mLoginbtn;
    TextView mCreatebtn,forgotTextLink;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        fAuth = FirebaseAuth.getInstance();
        mLoginbtn = findViewById(R.id.registerbtn);
        mCreatebtn = findViewById(R.id.createText);
        forgotTextLink = findViewById(R.id.forgot_password);


        mLoginbtn.setOnClickListener(new View.OnClickListener() {
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

                //Authenticate the user

                fAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Login.this, "Logged in", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        } else {
                            Toast.makeText(Login.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

        mCreatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Registration.class));
            }
        });

        forgotTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText ResetMail = new EditText(v.getContext());
                AlertDialog.Builder PasswordResetDialog = new AlertDialog.Builder(v.getContext());
                PasswordResetDialog.setTitle("Reset Password");
                PasswordResetDialog.setMessage("Enter your Email to receive a reset link.");
                PasswordResetDialog.setView(ResetMail);

                PasswordResetDialog.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String mail = ResetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Login.this, "Reset link has been sent to your Email.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "Reset link has not been sent." + e.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });

                    }
                });

                PasswordResetDialog.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                PasswordResetDialog.create().show();

            }
        });

    }
}