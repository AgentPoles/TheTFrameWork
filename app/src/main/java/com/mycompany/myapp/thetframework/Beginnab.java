package com.mycompany.myapp.thetframework;

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
 * Created by Paul on 2/14/2018.
 */
public class Beginnab  {
    private DataSnapshot dataSnapshot;
    private DatabaseReference dreaference;
    FirebaseDatabase fdel;
    static List<question> der = new ArrayList<question>();
    DatabaseReference drereference;

    public Beginnab(Context context){

    }
    public static List<question> loadInBackground(FirebaseDatabase fdel, DatabaseReference dreaference) {

        fdel = FirebaseDatabase.getInstance();
        dreaference = fdel.getReference("question");
        dreaference.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<HashMap<String, question>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, question>>() {
                };
                Map<String, question> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
//                List<question> dear;
                List<question> questions = new ArrayList<question>(objectHashMap.values());
                List<String> unspinnedquestion = new ArrayList<String>(objectHashMap.keySet());
                List<question> anquestions = new ArrayList<question>();
                List<String> anstring = new ArrayList<String>();
                for (int i = 0; i < questions.size(); i++) {
                    if (!questions.get(i).isAnswered()) {
                        questions.get(i).setQueid(anstring.get(i));
                        anquestions.add(questions.get(i));

                    }
                }
                der = anquestions;
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                der = null;
            }
        });


        return der;
    }
}
