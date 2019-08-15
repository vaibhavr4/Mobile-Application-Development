package com.vaibhav.assignment4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText userNameText, passwordText;
    private Button loginButton, registerButton;
    String username;
    String password;

    // create variable to hold firebase auth

    private FirebaseAuth autenticationRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userNameText = findViewById(R.id.userNameEditText);
        passwordText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.login);
        registerButton = findViewById(R.id.register);

        //get reference of firebase auth
        autenticationRef = FirebaseAuth.getInstance();

        //set listener on register button to launch auth service
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get values from editText
                username = userNameText.getText().toString();
                password = passwordText.getText().toString();

                // handle user registration
                autenticationRef.createUserWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //if registration is successful let me in
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

        //onclick listener on login button to check for auth
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // authenticate user
                //get values from editText
                username = userNameText.getText().toString();
                password = passwordText.getText().toString();

                autenticationRef.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //let me into home activity
                            Intent intent = new Intent(MainActivity.this, ChatScreenActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


    }
}
