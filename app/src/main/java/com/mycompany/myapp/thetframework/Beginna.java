package com.mycompany.myapp.thetframework;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

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

/**
 * Created by Paul on 2/14/2018.
 */
public class Beginna {
    private DataSnapshot dataSnapshot;
    private DatabaseReference dreaference;
    FirebaseDatabase fdel;
    static Uri beginnadownloaduri;
   static List<question> der = new ArrayList<question>();
    static List<Answer> dre = new ArrayList<Answer>();
    static List<question> drw = new ArrayList<question>();
    static List<question> questions = new ArrayList<>();
    static List<String> anstring = new ArrayList<>();
    static List<question> dee = new ArrayList<question>();
    static List<Answer> answers = new ArrayList<Answer>();
    static List<Answer> ananswers = new ArrayList<Answer>();
    static List<Classor> clissor = new ArrayList<Classor>();
    static List<String> clissorid = new ArrayList<String>();
    static int classposition = 0;
    static double totalquestionno = 0;
    static String clissoreid = "";
    DatabaseReference drereference;
private String queid;
    public Beginna(Context context){

    }
//    public static List<question> loadInBackgrouned(final SharedPreferences mysharedpreference, final SharedPreferences.Editor myeditor, FirebaseDatabase fdel, DatabaseReference dreaference) {
////
////        fdel = FirebaseDatabase.getInstance();
////        dreaference = fdel.getReference("question");
//        dreaference.orderByValue().addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                GenericTypeIndicator<HashMap<String, question>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, question>>() {
//                };
//                Map<String, question> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
////                List<question> dear;
//                 questions = new ArrayList<question>(objectHashMap.values());
//                anstring = new ArrayList<String>(objectHashMap.keySet());
//                List<question> anquestions = new ArrayList<question>();
////                List<String> anstring = new ArrayList<String>();
//                anquestions.clear();
//                for (int i = 0; i < questions.size(); i++) {
//                    if (questions.get(i).isAnswered()) {
//                        questions.get(i).setQueid(anstring.get(i));
//                        Spreferences lp = new Spreferences();
//                       questions.get(i).setRead( lp.ReadState(mysharedpreference,questions.get(i).getQueid(),myeditor,questions.get(i).getNoanswer(),questions.get(i).getNocomment()));
//                        anquestions.add(questions.get(i));
//
//                    }
//                }
//                der = anquestions;
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
////                der = null;
//            }
//        });
//
//
//        return der;
//    }
//    public static List<question> aloadInBackgrouned(final SharedPreferences mysharedpreference, final SharedPreferences.Editor myeditor,FirebaseDatabase fdel, DatabaseReference dreaference) {
//
////        fdel = FirebaseDatabase.getInstance();
////        dreaference = fdel.getReference("question");
//        dreaference.orderByValue().addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                GenericTypeIndicator<HashMap<String, question>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, question>>() {
//                };
//                Map<String, question> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
////                List<question> dear;
//                questions = new ArrayList<question>(objectHashMap.values());
//                anstring = new ArrayList<String>(objectHashMap.keySet());
//                List<question> anquestions = new ArrayList<question>();
////                List<String> anstring = new ArrayList<String>();
//                anquestions.clear();
//                for (int i = 0; i < questions.size(); i++) {
//                    if (!questions.get(i).isAnswered()) {
//                        questions.get(i).setQueid(anstring.get(i));
//                        Spreferences lp = new Spreferences();
//
//                        questions.get(i).setRead( lp.ReadState(mysharedpreference,questions.get(i).getQueid(),myeditor,questions.get(i).getNoanswer(),questions.get(i).getNocomment()));
//                        anquestions.add(questions.get(i));
//
//                    }
//                }
//                drw = anquestions;
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
////                drw = null;
//            }
//        });
//
//
//        return drw;
//    }
//    public static List<question> eloadInBackgrouned(FirebaseDatabase fdel, DatabaseReference dreaference) {
////        fdel = FirebaseDatabase.getInstance();
////        dreaference = fdel.getReference("question");
//        dreaference.orderByValue().addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                GenericTypeIndicator<HashMap<String, question>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, question>>() {
//                };
//                Map<String, question> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
//
//                 questions = new ArrayList<question>(objectHashMap.values());
//                anstring = new ArrayList<String>(objectHashMap.keySet());
////        List<question> anquestions = new ArrayList<question>();
////        List<String> anstring = new ArrayList<String>();
//                for (int i = 0; i < questions.size(); i++) {
//                    questions.get(i).setQueid(anstring.get(i));
//                }
//                dee = questions;
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
////                der = null;
//
//            }
//        });
//        return dee;
//    }
//    public static List<Answer> enloadInBackground(FirebaseDatabase fdel, DatabaseReference dreaference) {
//        fdel = FirebaseDatabase.getInstance();
//        dreaference = fdel.getReference("Answers");
//        dreaference.orderByChild("timeStamp").addValueEventListener(new ValueEventListener() {
//                                                                        @Override
//                                                                        public void onDataChange(DataSnapshot dataSnapshot) {
//                                                                            GenericTypeIndicator<HashMap<String, Answer>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Answer>>() {
//                                                                            };
//                                                                            if (dataSnapshot.getValue() != null) {
//                                                                                Map<String, Answer> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
//                                                                                answers = new ArrayList<Answer>(objectHashMap.values());
////                                                  List<String> unspinnedanswer = new ArrayList<String>(objectHashMap.keySet());
////                                                  List<String> anstring = new ArrayList<String>();
//                                                                                ananswers.clear();
//                                                                                for (int i = 0; i < answers.size(); i++) {
//
//                                                                                    if (answers.get(i).getQueid().equals(processall.getInstance().getQueid())) {
////
//                                                                                        ananswers.add(answers.get(i));
//                                                                                        Collections.sort(ananswers, new Comparator<Answer>() {
//                                                                                            @Override
//                                                                                            public int compare(Answer to, Answer t1) {
//                                                                                                return (int)(to.getTimestamp()-t1.getTimestamp());
//                                                                                            }
//                                                                                        });
//                                                                                    }
//
//                                                                                    dre = ananswers;
//                                                                                }
//                                                                            }
//                                                                        }
//
//
//                                                                            @Override
//                                                                            public void onCancelled (DatabaseError databaseError){
//                                                                                dre = null;
//                                                                            }
//                                                                        }
//
//        );
//
//        return dre;
//    }
//    public static void resolve(FirebaseDatabase fdb, DatabaseReference fb) {
////        fb.addValueEventListener(new ValueEventListener() {
////            @Override
////            public void onDataChange(DataSnapshot db) {
////                GenericTypeIndicator<HashMap<String, Classor>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Classor>>() {
////                };
////                Map<String, Classor> objectHashMap = db.getValue(objectsGTypeInd);
////                clissor = new ArrayList<Classor>(objectHashMap.values());
////                clissorid = new ArrayList<String>(objectHashMap.keySet());
////                for (int i = 0; i < clissor.size(); i++) {
////                    if (clissor.get(i).getName().equals(namepro.getNclassy())) {
////                        clissoreid = clissorid.get(i);
////                        totalquestionno = clissor.get(i).getValue();
////                        classposition = i;
////                    }
////                }
////            }
//
////            @Override
////            public void onCancelled(DatabaseError databaseError) {
////
////            }
////        });
//    }
//    public static void resolvetracking(FirebaseDatabase fdel, DatabaseReference databaseReference, final String id){
//       fdel = FirebaseDatabase.getInstance();
//        databaseReference = fdel.getReference("Uris").child(id);
//        databaseReference.orderByValue().addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot != null) {
//                    beginnadownloaduri = Uri.parse(dataSnapshot.child("uri").getValue().toString());
//                }
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }

    }


