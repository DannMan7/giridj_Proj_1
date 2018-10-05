package com.example.user.giridj_proj_1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // Splash screen time 3 seconds
    private static int SPLASH_TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Getting window and changing its background color to black
        getWindow().getDecorView().setBackgroundResource(android.R.color.black);
        // Assigning a new Handler to run the entirety of the Splash Screen, to then fade out
        //  to then take an Override to the next activity.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(MainActivity.this, login.class);
                startActivity(login);
                finish();
            }
        }, SPLASH_TIME);
    }
}
