package com.example.matusintl.Activitys;

import android.app.Application;

import com.example.matusintl.R;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

import model.Cars;


public class matusintlApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Cars.class);
        // Add your initialization code here

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build());

        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put("GCMSenderId", "192515480472");
        installation.saveInBackground();


    }
}

