package com.example.abhishek.sharerides.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseQuery;
import com.parse.ParseUser;

/**
 * Created by abhishekdesai on 6/9/16.
 */
public class SplashActivity extends AppCompatActivity {


    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ParseUser currentUser = ParseUser.getCurrentUser();

        if (currentUser != null) {

            // Create Dashboard and take user to that dashboard activity
            Intent dashboard = new Intent(this, DashboardActivity.class);
            startActivity(dashboard);
            finish();

        } else {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}