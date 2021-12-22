package com.mycompany.myapp.thetframework;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;

import static android.content.Context.MODE_PRIVATE;

public class ServiceRestartReceiver extends BroadcastReceiver {
    SharedPreferences mysharedpreferences;
    SharedPreferences.Editor myEditor;
    FirebaseJobDispatcher dispatcher;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

//                try {

        mysharedpreferences = context.getSharedPreferences("readstate",MODE_PRIVATE);
        dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(context));
                    final ConnectivityManager connMgr = (ConnectivityManager) context
                            .getSystemService(Context.CONNECTIVITY_SERVICE);

                    final android.net.NetworkInfo wifi = connMgr
                            .getNetworkInfo(ConnectivityManager.TYPE_WIFI);

                    final android.net.NetworkInfo mobile = connMgr
                            .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

                    if (wifi.isConnected() || mobile.isConnected()) {
                        // do stuff
                        scheduleJob();
                        if (mysharedpreferences.getBoolean("dead", true)) {

                        } else {

                            context.startService(new Intent(context, MyDataService.class));
                            
//                            context.startService(new Intent(context, MyService.class));
                        }

//        throw new UnsupportedOperationException("Not yet implemented");
                    }
//                }catch (Exception e){
//                Toast.makeText(context,"error reading from servicestarterreceiver", Toast.LENGTH_LONG).show();
//                }
        }
    private void scheduleJob(){
//        SharedPreferences preferences = PreferenceManager.
//                getDefaultSharedPreferences(this);

//        if(!preferences.getBoolean("firstRunComplete", false)){
        //schedule the job only once.
        Bundle myExtrasBundle = new Bundle();
        myExtrasBundle.putString("some_key", "some_value");

        Job myJob = dispatcher.newJobBuilder()
                // the JobService that will be called
                .setService(MyJobService.class)
                // uniquely identifies the job
                .setTag("my-unique-tag")
                // one-off job
                .setRecurring(true)
                // don't persist past a device reboot
                .setLifetime(Lifetime.FOREVER)
                // start between 0 and 60 seconds from now
                .setTrigger(Trigger.executionWindow(0, 60*10))
                // don't overwrite an existing job with the same tag
                .setReplaceCurrent(false)
                // retry with exponential backoff
                .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
                // constraints that need to be satisfied for the job to run
                .setConstraints(
                        // only run on an unmetered network
                        Constraint.ON_ANY_NETWORK
                        // only run when the device is charging
                )
                .build();

        dispatcher.mustSchedule(myJob);

        //update shared preference
//            SharedPreferences.Editor editor = preferences.edit();
//            editor.putBoolean("firstRunComplete", true);
//            editor.apply();
//
//        }

    }

    }


