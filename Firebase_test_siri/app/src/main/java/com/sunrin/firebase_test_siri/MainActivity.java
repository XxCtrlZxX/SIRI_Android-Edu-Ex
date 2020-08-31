package com.sunrin.firebase_test_siri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private String ID = new String();
    private String PW = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText textID = findViewById(R.id.textID);
        TextInputEditText textPW = findViewById(R.id.textPW);
        Button btnSignIn = findViewById(R.id.signInBtn);
        Button btnSignUp = findViewById(R.id.signUpBtn);

        // SignUp Button
        btnSignUp.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));

        // SignIn Button
        btnSignIn.setOnClickListener(view -> {
            if (ID.equals(textID.getText().toString()) && PW.equals(textPW.getText().toString())) {
                Toast.makeText(this, "로그인 되었습니다. : " + ID, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "아이디 / 비밀번호가 올바르지 않습니다.", Toast.LENGTH_SHORT).show();
            }
        });


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myID = database.getReference("id");
        DatabaseReference myPW = database.getReference("pw");

        // Read from the database
        myID.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                ID = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        myPW.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                PW = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}