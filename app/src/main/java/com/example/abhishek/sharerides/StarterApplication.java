package com.example.abhishek.sharerides;

import android.app.Application;

import com.example.abhishek.sharerides.helpers.Configs;
import com.parse.Parse;

/**
 * Created by abhishekdesai on 6/6/16.
 */
public class StarterApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        //Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId(Configs.APPLICATION_ID)
                .clientKey(null)
                .server(Configs.APPLICATION_URL)
                .build()
        );

        /**** Not Required in PRODUCTION ****/
        //ParseUser.enableAutomaticUser();
        //ParseACL defaultACL = new ParseACL();

        /* Optinally enable public read access. */
        //defaultACL.setPublicReadAccess(true);

        //ParseACL.setDefaultACL(defaultACL, true);
        /**** Not Required in PRODUCTION ****/

    }

}
