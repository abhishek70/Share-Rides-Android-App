package com.example.abhishek.sharerides.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by abhishekdesai on 6/9/16.
 */
public class SplashActivity extends AppCompatActivity {


    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}