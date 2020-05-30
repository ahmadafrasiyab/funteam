
package com.example.funteam;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.funteam.R;





public class MainActivity extends AppCompatActivity {
    ////////////////////////////////////////////////////////
    Button signupButton;
    String finalcustFName;
    String finalcustLName;
    String finalcustUserName;
    String finalcustEmail;
    ////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////
    EditText editFirstName;
    EditText editLastName;
    EditText editUserName;
    EditText editEmail;
    ////////////////////////////////////////////////////////



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signupButton = findViewById(R.id.signUpButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                /////////////////////////////////////////////////////////
                editFirstName = findViewById(R.id.firstName);
                editLastName = findViewById(R.id.lastName);
                editEmail = findViewById(R.id.email);
                editUserName = findViewById(R.id.username);
                /////////////////////////////////////////////////////////

                ////////////////////////////////////////////////////////
                finalcustFName = editFirstName.getText().toString();
                finalcustLName = editLastName.getText().toString();
                finalcustEmail = editEmail.getText().toString();
                finalcustUserName = editUserName.getText().toString();

                ////////////////////////////////////////////////////////





                ////////////////////////////////////////////////////////
                intent.putExtra("value1", finalcustFName);
                intent.putExtra("value2", finalcustLName);
                intent.putExtra("value3", finalcustEmail);
                intent.putExtra("value4", finalcustUserName);
                ////////////////////////////////////////////////////////


                startActivity(intent);
            }
        });
    }
}