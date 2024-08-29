package com.ajssoftwares.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class RegistrationActivity extends AppCompatActivity {

    EditText edtName, edtEmail, edtPassword;
    Button btnRegister;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        preferences = getSharedPreferences("registration",Context.MODE_PRIVATE);
        String isUserLogin = preferences.getString("isUserLogin","NotLoggedIn");
        if(isUserLogin.equals("loggedIn")){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnRegister = findViewById(R.id.btnRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateUser()) {

                    preferences = getSharedPreferences("registration",Context.MODE_PRIVATE);
                    editor = preferences.edit();
                    editor.putString("isUserLogin","loggedIn");
                    editor.apply();


                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateUser() {
        if(edtName.getText().toString().isEmpty() || edtName.getText().toString().isBlank()){
            edtName.setError("Please enter your name");
            return false;
        }
        if(edtEmail.getText().toString().isEmpty() || edtEmail.getText().toString().isBlank()){
            edtEmail.setError("Please enter your email");
            return false;
        }
        if (edtPassword.getText().toString().isEmpty() || edtPassword.getText().toString().isBlank()){
            edtPassword.setError("Please enter your password");
            return false;
        }
        else{
            return true;
        }
    }
}