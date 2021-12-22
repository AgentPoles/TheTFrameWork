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
public class RealLoadAnswer extends android.support.v4.content.AsyncTaskLoader<List<Answer>>

{
    private DataSnapshot dataSnapshot;
    private DatabaseReference dreaference;
    FirebaseDatabase fdel;
    List<Answer> der = new ArrayList<Answer>();
    DatabaseReference drereference;
    private String queid = processall.getInstance().getQueid();

    public RealLoadAnswer(Context context) {
        super(context);
    }

    @Override
    public List<Answer> loadInBackground() {
        fdel = FirebaseDatabase.getInstance();
        dreaference = fdel.getReference("Answers");
        dreaference.addValueEventListener(new ValueEventListener() {

                                              @Override
                                              public void onDataChange(DataSnapshot dataSnapshot) {
                                                  GenericTypeIndicator<HashMap<String, Answer>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Answer>>() {
                                                  };
                                                  Map<String, Answer> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);

                                                  List<Answer> answers = new ArrayList<Answer>(objectHashMap.values());
                                                  List<String> unspinnedanswer = new ArrayList<String>(objectHashMap.keySet());
                                                  List<Answer> ananswers = new ArrayList<Answer>();
                                                  List<String> anstring = new ArrayList<String>();
                                                  for (int i = 0; i < answers.size(); i++) {
                                                      if (answers.get(i).getQueid().equals(queid)) {
//                q.get(i).setQueid(anstring.get(i));
                                                          ananswers.add(answers.get(i));

                                                      }

                                                      der = ananswers;
                                                  }
                                              }

                                              @Override
                                              public void onCancelled(DatabaseError databaseError) {
                                                  der = null;
                                              }
                                          }
        );

return der;
    }
}