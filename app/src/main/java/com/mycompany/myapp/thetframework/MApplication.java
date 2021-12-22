package com.mycompany.myapp.thetframework;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Paul on 1/31/2018.
 */public class  MApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}