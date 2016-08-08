package com.example.abhishek.sharerides.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.abhishek.sharerides.helpers.Utils;
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

            /* Create Dashboard Intent and take user to that dashboard activity
             depending on the user type */
            String userType = currentUser.getString("userType");

            Intent dashboard;

            if(userType.equals(Utils.DRIVER))
                dashboard = new Intent(this, ViewRideRequestsActivity.class);
            else
                dashboard = new Intent(this, DashboardActivity.class);

            startActivity(dashboard);
            finish();

        } else {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}