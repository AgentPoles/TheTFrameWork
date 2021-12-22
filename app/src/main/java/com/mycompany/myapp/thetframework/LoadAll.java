package com.mycompany.myapp.thetframework;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Paul on 2/12/2018.
 */
public class LoadAll extends android.support.v4.content.AsyncTaskLoader<List<question>> {
    private DataSnapshot dataSnapshot;
    private DatabaseReference dreaference;
    FirebaseDatabase fdel;
    List<question> der = new ArrayList<question>();
    List<question> questions = new ArrayList<question>();
    List<String>  unspinned = new ArrayList<String>();
    DatabaseReference drereference;

    public LoadAll(Context context) {
        super(context);


    }

    @Override
    public List<question> loadInBackground() {
        fdel = FirebaseDatabase.getInstance();
        dreaference = fdel.getReference("question");
        dreaference.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, question>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, question>>() {
                };
                Map<String, question> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
                 questions = new ArrayList<question>(objectHashMap.values());
                 unspinned = new ArrayList<String>(objectHashMap.keySet());
//        List<question> anquestions = new ArrayList<question>();
//        List<String> anstring = new ArrayList<String>();
                for (int i = 0; i < questions.size(); i++) {
                    questions.get(i).setQueid(unspinned.get(i));
                }
                der = questions;

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                der = null;

            }
        });
return der;
    }
}

