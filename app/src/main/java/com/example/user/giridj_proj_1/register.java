package com.example.user.giridj_proj_1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.FileOutputStream;

public class register extends AppCompatActivity {

    // Creating instances of the EditText views from the XML
    EditText eTFirst;
    EditText eTLast;
    EditText eTDay;
    EditText eTYear;
    EditText eTEmail;
    EditText eTPass;
    // Creation of Spinner instance for the months
    Spinner sMonth;
    // Creation of ArrayAdapter to sequence string-array of months in strings.xml
    ArrayAdapter<CharSequence> adapterM;
    // Creation of Button instance for the submission button
    Button BTN_Submit;
    // Creation of LinearLayout instance
    LinearLayout rLL;
    // Regular Expression Strings
    // Must accept an Uppercase letter followed by mixture of upper or lower A-z
    String regex_name = "[A-Z][a-zA-Z]*";
    // Must accept anything@anything.com
    String regex_email = "^(.+)@(.+)$";
    // Must accept only numbers
    String regex_number =  "^[0-9]*$";

    // onCreate called
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Getting window of application and changing color to blue
        getWindow().getDecorView().setBackgroundResource(android.R.color.holo_blue_bright);

        // Assigning various instances to their corresponding EditText XML id
        eTFirst = findViewById(R.id.ETFName);
        eTLast = findViewById(R.id.ETLName);
        eTDay = findViewById(R.id.ETDay);
        eTYear = findViewById(R.id.ETYear);
        eTEmail = findViewById(R.id.ETLEmail);
        eTPass = findViewById(R.id.ETLPass);

        // Assigning Registration Linear Layout to corresponding LinearLayout XML id
        rLL = findViewById(R.id.LLRegMain);
        // Setting background color of Registration Layout to white
        rLL.setBackgroundColor(getResources().getColor(android.R.color.white));

        // Assigning spinner instance to corresponding spinner XML id
        sMonth = findViewById(R.id.spinM);

        // Assigning ArrayAdapter using the string array and spinner layout
       adapterM = ArrayAdapter.createFromResource(this,
                R.array.spinner_month, android.R.layout.simple_spinner_item);
       // Specify the layout to use when the list of choices appears
        adapterM.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply adpater to the spinner
        sMonth.setAdapter(adapterM);

        // Assigning Submit button to corresponding button XML id
        BTN_Submit = findViewById(R.id.register_submit);
        // Changing button background color to black
        BTN_Submit.setBackgroundColor(getResources().getColor(android.R.color.black));
        // Changing button text color to white
        BTN_Submit.setTextColor(getResources().getColor(android.R.color.white));
        // Button onClick listener will call all the methods to verify each EditText field.
        //   When methods return false, there is a Toast for each method.
        //   If all the methods return true the activity will finish and will be moved back
        //      to the login activity
        BTN_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidFirstName()) {
                    if (ValidLastName()) {
                        if(ValidEmail()) {
                            if(ValidDOB()) {
                                if(ValidPass()) {
                                    // Method commented out because unsure where the file is saved
                                    //  to exactly within the internal storage.
                                    //writeToFile();
                                    // Toast message to user to assure registration has been
                                    //  successful.
                                    Toast.makeText(getApplicationContext(),
                                            "Registration Successful!",
                                            Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }
                        }
                    }
                }
            }
        });
    }
    // Validates First Name
    // Checks to make sure the length of a name is longer than 3 characters, but less than 30
    // Regular Expression is also used to verify the user only gave letters in the names
    private boolean ValidFirstName()
    {
        if(eTFirst.getText().toString().trim().length() > 2
                && eTFirst.getText().toString().trim().length() < 31) {
            if(eTFirst.getText().toString().trim().matches(regex_name)) {
                return true;
            }

        }
        // If the user has any sort of invalid input a Toast will be sent to the user
        else{
            Toast.makeText(getApplicationContext(),"First Name is Invalid!",
                    Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    // Validates Last Name
    // Checks to make sure the length of a name is longer than 3 characters, but less than 30
    // Regular Expression is also used to verify the user only gave letters in the names
    private boolean ValidLastName()
    {
        if(eTLast.getText().toString().trim().length() > 2
                && eTLast.getText().toString().trim().length() < 31) {
            if(eTLast.getText().toString().trim().matches(regex_name)){
                return true;
            }

        }
        // If the user has any sort of invalid input a Toast will be sent to the user
        else{
            Toast.makeText(getApplicationContext(),"Last Name is Invalid!",
                    Toast.LENGTH_SHORT).show();
        }
        return false;
    }
    // Validates the Email
    // Regular expression is used to verify the text given by the user is in an email format
    private boolean ValidEmail()
    {
        if(eTEmail.getText().toString().trim().matches(regex_email)){
            return true;
        }
        // If the user has any sort of invalid input a Toast will be sent to the user
        Toast.makeText(getApplicationContext(),"Email is invalid!",
                Toast.LENGTH_SHORT).show();
        return false;
    }
    // Validates the Day
    // Checks to make sure the length of what is being checked is at least 1 character
    // Then checks to ensure the characters are numbers
    // After that it will check to see the days are within limits of a month
    private boolean ValidDay()
    {
        if(eTDay.getText().toString().trim().length() > 0) {
            if (eTDay.getText().toString().trim().matches(regex_number)) {
                if (Integer.parseInt(eTDay.getText().toString().trim()) > 0
                        && Integer.parseInt(eTDay.getText().toString().trim()) < 32)
                    return true;
            }
        }
        // If the user has any sort of invalid input a Toast will be sent to the user
        Toast.makeText(getApplicationContext(),"Day is Invalid!", Toast.LENGTH_SHORT).show();
        return false;
    }
    // Validates the Year
    // Checks to make sure the length of what is being checked is at least 1 character
    // Then checks to ensure the characters are numbers
    // After than it will check to make sure the year being entered is feasible given parameters
    private boolean ValidYear()
    {
        if(eTYear.getText().toString().trim().length() > 0) {
            if (eTYear.getText().toString().trim().matches(regex_number)) {
                if (Integer.parseInt(eTYear.getText().toString().trim()) > 1900
                        && Integer.parseInt(eTYear.getText().toString().trim()) < 2050)
                    return true;
            }
        }
        // If the user has any sort of invalid input a Toast will be sent to the user
        Toast.makeText(getApplicationContext(),"Year is Invalid!", Toast.LENGTH_SHORT).show();
        return false;
    }
    // Validates the DOB of the user
    // Calls methods ValidDay() and ValidYear() to ensure user has entered correct information
    private boolean ValidDOB()
    {
        if(ValidDay()) {
            if (ValidYear()) {
                return true;
            }
        }
        return false;
    }
    // Validates the password of the user
    // Ensures all passwords are at least 1 character long
    // May not be the most secure but, allowed here for prototype
    private boolean ValidPass()
    {
        if(eTPass.getText().toString().trim().length() > 0){
            return true;
        }
        // If there is any sort of invalid input, the user will be notified via Toast
        Toast.makeText(getApplicationContext(),"Password is Invalid!",
                Toast.LENGTH_SHORT).show();
        return false;
    }
    // Attempt to write to a file called accounts.txt
    // Concatenates all of the information entered by the user to comma separated variables
    //  that way on read, the login activity will be able to access the newly registered users
    private void writeToFile()
    {
        String filename = "accounts.txt";
        String fileContents = ("\n" + eTFirst.getText().toString().trim() + ","
                + eTLast.getText().toString().trim() + ","
                + eTEmail.getText().toString().trim() + ","
                + sMonth.getSelectedItem().toString() + ","
                + eTDay.getText().toString().trim() + ","
                + eTYear.getText().toString().trim() + ","
                + eTPass.getText().toString().trim());
        // Creating instance of FileOutputStream
        FileOutputStream outputStream;
        // Attempting to access the internal storage of the device and writing to that area
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        }
        // If in case there is an exception it will print out the error
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
