package com.mycompany.myapp.thetframework;

import android.content.SharedPreferences;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Paul on 3/3/2018.
 */
public class Mathmatical {
    DataSnapshot dataSnapshot;

    public Mathmatical(){

    }
    public Mathmatical(DataSnapshot dataSnapshot){
        this.dataSnapshot = dataSnapshot;
    }

    public List<question> Showallquestions( SharedPreferences mysharedpreference, SharedPreferences.Editor myeditor, String name){
        GenericTypeIndicator<HashMap<String, question>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, question>>() {
        };
        Map<String, question> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
//                List<question> dear;
        if(dataSnapshot.getValue()!=null) {
            List<question> questions = new ArrayList<question>(objectHashMap.values());
            List<question> bean = new ArrayList<question>();
            List<question> brean = new ArrayList<question>();
//        List<String> anstring = new ArrayList<String>(objectHashMap.keySet());
            if (!questions.isEmpty()) {

                for (int i = 0; i < questions.size(); i++) {
                    if (questions.get(i).getMclass().equals(name)) {
                        questions.get(i).setRead(Spreferences.ReadState(mysharedpreference, questions.get(i).getQueid(), myeditor, questions.get(i).getNoanswer(), questions.get(i).getNocomment()));
                        bean.add(questions.get(i));
                        Collections.sort(bean, new Comparator<question>() {
                            @Override
                            public int compare(question t0, question t1) {
                                return (int) (t1.getTimestamp() - t0.getTimestamp());


                            }

                        });
                    }
                }
            }

            return bean;
        }
        return null;
    }

    public List<question> showAnsweredquestions(SharedPreferences mysharedpreference, SharedPreferences.Editor myeditor, String name){
        GenericTypeIndicator<HashMap<String, question>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, question>>() {
        };
        Map<String, question> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
//                List<question> dear;
        if(dataSnapshot.getValue()!=null) {
            List<question> questions = new ArrayList<question>(objectHashMap.values());
//        anstring = new ArrayList<String>(objectHashMap.keySet());
            List<question> anquestions = new ArrayList<question>();
//                List<String> anstring = new ArrayList<String>();
            if (!questions.isEmpty()) {
                anquestions.clear();
                for (int i = 0; i < questions.size(); i++) {
                    if (questions.get(i).getMclass().equals(name)) {
                        if (questions.get(i).isAnswered()) {
                            questions.get(i).setRead(Spreferences.ReadState(mysharedpreference, questions.get(i).getQueid(), myeditor, questions.get(i).getNoanswer(), questions.get(i).getNocomment()));
                            anquestions.add(questions.get(i));
                            Collections.sort(anquestions, new Comparator<question>() {
                                @Override
                                public int compare(question t0, question t1) {
                                    return (int)(t1.getTimestamp()-t0.getTimestamp());
                                }
                            });

                        }
                    }
                }
            }
            return anquestions;
        }
        return null;
    }
    public List<question> showUnasweredQuestions(SharedPreferences mysharedpreference, SharedPreferences.Editor myeditor, String name){
        GenericTypeIndicator<HashMap<String, question>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, question>>() {
        };
        Map<String, question> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
//
        if(dataSnapshot.getValue()!=null) {
            List<question> questions = new ArrayList<question>(objectHashMap.values());
//        anstring = new ArrayList<String>(objectHashMap.keySet());
            List<question> anquestions = new ArrayList<question>();
//                List<String> anstring = new ArrayList<String>();
            if (!questions.isEmpty()) {
                anquestions.clear();
                for (int i = 0; i < questions.size(); i++) {
                    if (questions.get(i).getMclass().equals(name)) {
                        if (!questions.get(i).isAnswered()) {
//                questions.get(i).setQueid(anstring.get(i));
                            questions.get(i).setRead(Spreferences.ReadState(mysharedpreference, questions.get(i).getQueid(), myeditor, questions.get(i).getNoanswer(), questions.get(i).getNocomment()));
                            anquestions.add(questions.get(i));
                            Collections.sort(anquestions, new Comparator<question>() {
                                @Override
                                public int compare(question t0, question t1) {
                                    return (int)(t1.getTimestamp()-t0.getTimestamp());
                                }
                            });
                        }
                    }
                }
            }
            return anquestions;
        }
        return null;
    }
    List<Answer> showAnswers(){
        GenericTypeIndicator<HashMap<String, Answer>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Answer>>() {
        };

        Map<String, Answer> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
       List<Answer> answers = new ArrayList<Answer>(objectHashMap.values());
        List<Answer> ananswers = new ArrayList<Answer>();
//                   if
//
//                                List<String> unspinnedanswer = new ArrayList<String>(objectHashMap.keySet());
        if(dataSnapshot.getValue()!=null) {
            List<String> anstring = new ArrayList<String>();

            if (!answers.isEmpty()) {
                ananswers.clear();
                for (int i = 0; i < answers.size(); i++) {

                    if (answers.get(i).getQueid().equals(processall.getInstance().getQueid())) {
//
                        ananswers.add(answers.get(i));
                        Collections.sort(ananswers, new Comparator<Answer>() {
                            @Override
                            public int compare(Answer t0, Answer t1) {
                                return (int)(t0.getTimestamp()-t1.getTimestamp());
                            }
                        });
                    }

                }
            }
            return ananswers;

        }
        return null;
    }

    public boolean checkifclassexists(String name) {
        boolean result = false;
        GenericTypeIndicator<HashMap<String, Classor>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, Classor>>() {
        };
        Map<String, Classor> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
//                List<question> dear;
        if(dataSnapshot.getValue()!=null) {
            List<Classor> classors = new ArrayList<Classor>(objectHashMap.values());
//        anstring = new ArrayList<String>(objectHashMap.keySet());
            List<Classor> allclassor = new ArrayList<Classor>();
//                List<String> anstring = new ArrayList<String>();
            allclassor.clear();
            if (!classors.isEmpty()) {
                for (int i = 0; i < classors.size(); i++) {
                    if (classors.get(i).getName().equals(name)) {
//                questions.get(i).setQueid(anstring.get(i));

                        result = true;
                        break;
                    }
                }
            }
            return result;
        }
    return false;
    }

    }



