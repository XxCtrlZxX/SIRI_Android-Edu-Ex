package com.sunrin.firebase_test_siri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextInputEditText textID = findViewById(R.id.signin_textID);
        TextInputEditText textPW = findViewById(R.id.signin_textPW);
        Button btnSignUp = findViewById(R.id.btnSignup);

        btnSignUp.setOnClickListener(view -> {
            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myID = database.getReference("id");
            DatabaseReference myPW = database.getReference("pw");
            myID.setValue(textID.getText().toString());
            myPW.setValue(textPW.getText().toString());

            //Toast.makeText(this, "등록되었습니다.", Toast.LENGTH_SHORT).show();

            finish();
        });
    }
}
