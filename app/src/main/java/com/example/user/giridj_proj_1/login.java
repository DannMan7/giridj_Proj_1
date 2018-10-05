package com.example.user.giridj_proj_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    // Creation of instance of TextView from the XML
    TextView TV1;
    // Creation of instances of EditTexts from the XML
    EditText ET1;
    EditText ET2;
    // Creation of instance of Linear Layout from the XML
    LinearLayout mLL;
    // Creation of instances of Buttons from the XML
    Button BTN_Sign_In;
    Button BTN_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Getting window background color and setting it to blue
        getWindow().getDecorView().setBackgroundResource(android.R.color.holo_blue_bright);
        // Assigning instance of TextView to the corresponding TextView id
        TV1 = findViewById(R.id.TV1);
        // Assigning instances of EditText to corresponding EditText id
        ET1 = findViewById(R.id.ET1);
        ET2 = findViewById(R.id.ET2);
        // Assigning instances of Button to corresponding Button id
        BTN_Sign_In = findViewById(R.id.BTN1);
        BTN_Register = findViewById(R.id.BTN2);
        // Assigning instance of Linear Layout to corresponding Linear Layout id
        mLL = findViewById(R.id.LLMain);

        // Setting the background color property of the Linear Layout to white
        mLL.setBackgroundColor(getResources().getColor(android.R.color.white));

        // Setting the background color property of Button to black
        BTN_Sign_In.setBackgroundColor(getResources().getColor(android.R.color.black));
        // Setting the text color property of button to white
        BTN_Sign_In.setTextColor(getResources().getColor(android.R.color.white));

        // Setting the background color property of Button to black
        BTN_Register.setBackgroundColor(getResources().getColor(android.R.color.black));
        // Setting the text color property of button to white
        BTN_Register.setTextColor(getResources().getColor(android.R.color.white));

        // Button onClick listener will go to next activity as long as the username and password
        //  is valid.
        BTN_Sign_In.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidText()) {
                    startActivity(new Intent(login.this, home.class));
                }
            }
        });
        // Button onClick listener will go to next activity upon button press to transition to
        //  register activity.
        BTN_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, register.class));
            }
        });

    }
    // Method to validate the text in both fields
    // Can be used at a later point in time to check with database if values exist in account
    //  information
    private boolean isValidText()
    {
        // Checking to make sure the username EditText IS NOT EMPTY
        if(ET1.getText().toString().trim().length() > 0)
        {
            // Checking to make sure the password EditText IS NOT EMPTY
            if(ET2.getText().toString().trim().length() > 0)
            {
                return true;
            }
        }
        // Will send message to user if Login or Password was invalid
        Toast.makeText(getApplicationContext(), "Login or Password is invalid",
                Toast.LENGTH_SHORT).show();
        return false;
    }
}
