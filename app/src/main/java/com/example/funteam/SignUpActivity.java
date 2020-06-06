package com.example.funteam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.funteam.Models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    TextInputEditText textEmail, textPassword, textName;
    ProgressBar progressBar;
    DatabaseReference reference;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        textEmail = (TextInputEditText) findViewById(R.id.emailSignUp);
        textPassword = (TextInputEditText) findViewById(R.id.passwordSignUp);
        textName = (TextInputEditText) findViewById(R.id.name);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar_sign_up);
        auth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference().child("Users");




    }

    public void registerUser(View v) {
        progressBar.setVisibility(View.VISIBLE);
        final String email = textEmail.getText().toString();
        final String password = textPassword.getText().toString();
        final String name = textName.getText().toString();


        if(!email.equals("")&& !password.equals("")&& password.length()>6){
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                         // insert values tov the database
                        FirebaseUser firebaseUser = auth.getCurrentUser();
                        User user = new User();

                        user.setName(name);
                        user.setEmail(email);

                        reference.child(firebaseUser.getUid()).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(), "User registered successfully", Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);
                                    Intent intent = new Intent(SignUpActivity.this, GroupChatActivity.class);
                                    startActivity(intent);

                                }
                                else{
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(getApplicationContext(), "User couldn't be created",Toast.LENGTH_SHORT).show();



                                }
                            }
                        });
                    }
                }
            });
        }








    }

    public void gotoSignIn(View view){
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);

    }}
