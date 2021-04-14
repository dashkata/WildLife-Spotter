package com.example.wildlifespotter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Member;

public class emailActivity extends AppCompatActivity {

EditText mBox,mName;
Button mSend;
Responses responses;
DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        mBox = findViewById(R.id.Field);
        mName = findViewById(R.id.txtName);
        mSend = findViewById(R.id.sendbtn);
        responses = new Responses();
        reference = FirebaseDatabase.getInstance().getReference().child("User Messages");

        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String field = (mBox.getText().toString().trim());

                responses.setName(mName.getText().toString().trim());
                responses.setField(field);

                reference.push().setValue(responses);

                Toast.makeText(emailActivity.this, "Respond has been send successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void returnToProfile(View v){
        Intent i = new Intent(this, profile.class);
        startActivity(i);
    }

    public void showtext(View v){
        Intent i = new Intent(this, Info.class);
        startActivity(i);
    }

}