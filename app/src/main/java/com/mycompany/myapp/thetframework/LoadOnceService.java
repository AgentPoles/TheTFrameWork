package com.mycompany.myapp.thetframework;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadOnceService extends Service {
    FirebaseAuth mAuthb;
    FirebaseDatabase mrdatabase;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser mFirebaseUser;
    FirebaseDatabase ree;
    namepro userdetails;
    SharedPreferences mysharedpreferences;
    SharedPreferences.Editor myEditor;
    int i = 50;
    DatabaseReference lee;
    AppDatabase mDb;
    public LoadOnceService() {

    }

    @Override
    public void onCreate() {
        mrdatabase = FirebaseDatabase.getInstance();

        lee = mrdatabase.getReference("question");
        lee.startAt(i);
        mDb = AppDatabase.getsInstance(getApplicationContext());
        mysharedpreferences = getSharedPreferences("readstate", Context.MODE_PRIVATE);
        myEditor = mysharedpreferences.edit();

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        Toast.makeText(getApplicationContext(),"i'm on the last set", Toast.LENGTH_LONG).show();
        AppExecutor.getsInstance().diskIO().execute(

                new Runnable() {
                    @Override
                    public void run() {
                        loadmany();
                        myEditor.putBoolean("allow",true);
                        myEditor.apply();
                        stopSelf(startId);
                    }
                }
        );
//        return super.onStartCommand(intent, flags, startId);
        return Service.START_NOT_STICKY;
    }

    public void loadmany(){

        lee.orderByChild("timestamp").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final Intent broadcastIntent = new Intent("com.mycompany.myapp.thetframework.LoadOnceReceiver");
                final List<question> firstSetOfQuestions = Showallquestions(dataSnapshot);
                AppExecutor.getsInstance().diskIO().execute(
                        new Runnable() {
                            @Override
                            public void run() {
                                mDb.questionDao().deleteAll();
                                for (int i=0; i<firstSetOfQuestions.size();i++){
                                    if(firstSetOfQuestions.get(i)!=null) {
                                        mDb.questionDao().insertQuestion(firstSetOfQuestions.get(i));
                                    }
                                    else {
                                        break;
                                    }

                                }

                            }
                        }
                );


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public List<question> Showallquestions(DataSnapshot dataSnapshot){
        GenericTypeIndicator<HashMap<String, question>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, question>>() {
        };
        Map<String, question> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
//                List<question> dear;
        if(dataSnapshot.getValue()!=null) {
            List<question> questions = new ArrayList<question>(objectHashMap.values());
            List<question> bean = new ArrayList<question>();
            if (!questions.isEmpty()) {

                for (int i = 0; i < questions.size(); i++) {
                    bean.add(questions.get(i));
                    Collections.sort(bean, new Comparator<question>() {
                        @Override
                        public int compare(question t0, question t1) {
                            return (int) (t1.getTimestamp() - t0.getTimestamp());


                        }

                    });
                }
            }


            return bean;
        }
        return null;
    }
}
