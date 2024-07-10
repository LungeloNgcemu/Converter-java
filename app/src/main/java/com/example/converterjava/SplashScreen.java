package com.example.converterjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SplashScreen extends AppCompatActivity {


    void next() {
        //Login
        Intent myIntent = new Intent(SplashScreen.this, MainActivity.class);
        SplashScreen.this.startActivity(myIntent);
        finish();
    }


    public void startDelayedActivity() {

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                next();

            }
        }, 3000); // 3000 milliseconds = 3 seconds
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        startDelayedActivity();
    }
}