 package com.mycompany.myapp.thetframework;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDataService extends Service {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference frefa, frefb, frefc, frefd;
    FirebaseAuth firebaseAuth;
    AppDatabase mdb;
    static String coolthumbline;
    static String coolreal;
    int arraywatcher;
    File vfile;
    Notification.Builder builder;
    Notification notification;
    static List<Answer> answers = new ArrayList<>();
    static List<Intent> arrayintents = new ArrayList<>();
    static List<Classors> classorgroup = new ArrayList<>();
    static List<Intent> realarrayIntents = new ArrayList<>();
    int j =1;
    List<String> tobeshownquestionstrings, questionssendernames, answerstrings, answersendernames, questioncoolids;
    Uri firstpath;
    Uri secondpath;
    byte[] bitmapdata;
    private static int NOTIFICATION_ID = 1;
    private static int ANSWER_NOTIFICATION_ID = 590;
    private static int ANSWER_NOTIFICATION_IDA = 597;
    private static int ANSWER_NOTIFICATION_IDB = 600;
    int id;
    private static String APP_CHANNEL_ID  = "com.mycompany.myapp.thetframework";
    int currentviewpage;
    double timestamp;
    MediaPlayer mediumplayer, mediaPlayer;
    Bitmap imagebitmap;
    String uidl;
    Answer ans;
    question quer;
    static List<String> classornames = new ArrayList<>();
    Handler handler,hand;
    List<question> questions;
    File fii, fid;
    List<question> questionsq;
    long timeStamp;
    int errormessage;
    StorageReference storageReference;
    FirebaseStorage storage;
    static int actualHeight = 0;
    static int actualWidth = 0;
    static String timestampy;
    SharedPreferences mysharedpreferences;
    SharedPreferences.Editor myEditor;
    List<question> allQuestionsinsert, allquestionsupdate, allquestionsremove;

    public MyDataService() {
    }

    @Override
    public int onStartCommand(Intent intent, final int flags, int startId) {
//        Toast.makeText(getApplicationContext(),"servicing",Toast.LENGTH_LONG).show();


                        if (confirmconnection()) {
                            frefa.child("avvv").setValue(new question()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        AppExecutor.getsInstance().networkIO().execute(
                                                new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        classorgroup = mdb.classorsDao().LoadAllOrdunaryClassors();
                                                        for (int d = 0; d < classorgroup.size(); d++) {
                                                          if(!classorgroup.get(d).isBlocked()) {
                                                              classornames.add(classorgroup.get(d).getClassname());
                                                          }
//                                                jobFinished(job, needsReschedule);

                                                            }
                                                            processall.getInstance().setClassnames(classornames);
                                                        loadquestions();
                                                        loadanswers();
                                                        uploadpendingimagelessquestions();
                                                        uploadpendingimagelessanswers();
                                                        uploadanswerpendingquestions();
                                                        completeloadanswerwithimage();
                                                        completeloadquestionwithimage();
//                                                isWorking = false;
                                                        boolean needsReschedule = false;

                                                        }

                                                }
                                        );

                                    }
                                }
                            });

                        }

        return Service.START_STICKY;

                    }




    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onDestroy() {
//        Intent broadcastIntent = new Intent("com.mycompany.myapp.thetframework.ServiceRestartReceiver");
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mdb = AppDatabase.getsInstance(getApplicationContext());
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        frefa = firebaseDatabase.getReference("question");
        frefb = firebaseDatabase.getReference("Answers");
        frefc = firebaseDatabase.getReference("Answers");
        frefd = firebaseDatabase.getReference("question");
        answersendernames = new ArrayList<>();
        questionssendernames = new ArrayList<>();
        answerstrings = new ArrayList<>();
        tobeshownquestionstrings = new ArrayList<>();
        questioncoolids = new ArrayList<>();
        questions = new ArrayList<>();
        processall.getInstance().setNamesofupdatedclasses(new ArrayList<String>());
        processall.getInstance().answersendernames.clear();
        processall.getInstance().questionssendernames.clear();
        processall.getInstance().answerstrings.clear();
        processall.getInstance().questioncoolids.clear();
        processall.getInstance().tobeshownquestionstrings.clear();
        hand = new Handler();
        questions.clear();
        allQuestionsinsert = new ArrayList<>();
        handler = new Handler();
        allquestionsupdate = new ArrayList<>();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.stuffedanddropped);
        mediumplayer = MediaPlayer.create(getApplicationContext(), R.raw.glitchylanguage);
        allquestionsremove = new ArrayList<>();
        mysharedpreferences = getSharedPreferences("readstate", Context.MODE_PRIVATE);
        myEditor = mysharedpreferences.edit();
    }

    public boolean confirmconnection() {
        ConnectivityManager cm =
                (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    public void loadquestions()

    {

//        frefa.orderByChild("timestamp").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(final DataSnapshot dataSnapshot) {
//                Toast.makeText(getApplicationContext(),"i am woring!",Toast.LENGTH_LONG).show();
//                allQuestionsinsert = Showallquestions(dataSnapshot);
//                        for(int i=0; i<allQuestions.size();i++){
////                            Toast.makeText(getApplicationContext(),allQuestions.get(i).toString(),Toast.LENGTH_LONG).show();
//                            if(allQuestions.get(i).getQueid()!=null){
//                                mdb.questionDao().updateQuestion(allQuestions.get(i));
////                                Toast.makeText(getApplicationContext(),String.valueOf(mdb.questionDao().loadQuestion(allQuestions.get(i).getId())),Toast.LENGTH_LONG).show();
//                            }
//                            else {
//                                mdb.questionDao().deleteQuestion(allQuestions.get(i));
//
//                            }
//                        }
//
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


        frefa.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull final DataSnapshot dataSnapshot, @Nullable String s) {
                AppExecutor.getsInstance().diskIO().execute(new Runnable() {
                    @Override
                    public void run() {

//                timeStamp = mysharedpreferences.getLong("stampy",0);
//               allQuestionsinsert.clear();
//               allQuestionsinsert = Showallquestions(dataSnapshot);
//               for(int i =0; i<allQuestionsinsert.size();i++){
//                   if(allQuestionsinsert.get(i)!=null){
////                       if(allQuestionsinsert.get(i).getTimestamp()>=timeStamp){
//                           if(namepro.getNemail()!=null){
//                               if(allQuestionsinsert.get(i).getYemail().equals(namepro.getNemail())){
//                                   allQuestionsinsert.get(i).setRead(true);
//                               }
//                           }
//                           mdb.questionDao().updateQuestion(allQuestionsinsert.get(i));
//
//                           timeStamp = allQuestionsinsert.get(i).getTimestamp();
////                           myEditor.putLong("stampy",timeStamp);
//                       }
//                   }

                        final question quer = dataSnapshot.getValue(question.class);
                        questions.add(quer);
                        processall.getInstance().setQuestionse(questions);
                        String classnameing = quer.getMclass();

                        if (quer.getMclass() != null) {
                            if (processall.getInstance().getClassnames().contains(quer.getMclass())) {
//                            if (quer.getMclass().equals(mysharedpreferences.getString("userclass", ""))) {
//                                if (quer.getCoolid() == null) {
//                                    String coolid = quer.getYemail() + quer.getTimestamp();
//                                    quer.setCoolid(coolid);
//                                }

                                if (!mysharedpreferences.getString("useremail", "").equals(""))
                                    if (quer.getYemail() != null) {
                                        if (quer.getYemail().equals(mysharedpreferences.getString("useremail", ""))) {
                                            quer.setRead(true);
                                        }
                                    }


                                try {
                                    mdb.questionDao().insertQuestion(quer);
                                    tobeshownquestionstrings.add(quer.getBody());
                                    questionssendernames.add(quer.getWho());
//                                            questions.add(quer);
                                    if (mysharedpreferences.getBoolean("soundstate", true) && mysharedpreferences.getBoolean("inmain", true)) {
                                        mediaPlayer.start();
                                    }
                                    if (tobeshownquestionstrings.size() > 0) {
                                        showForegroundNotification(tobeshownquestionstrings, questionssendernames, 0, classnameing);
                                    }

                                    if (!processall.getInstance().getQuestionse().isEmpty()) {
                                        AppExecutor.getsInstance().diskIO().execute(new Runnable() {
                                            @Override
                                            public void run() {

                                                allclassQuestionnotification(processall.getInstance().getQuestionse(), classorgroup,quer.getMclass());
                                            }

                                        });
                                        if(!processall.getInstance().getNamesofupdatedclasses().isEmpty()) {
                                            if(!processall.getInstance().getNamesofupdatedclasses().contains(quer.getMclass())) {
                                                processall.getInstance().addtoclassnames(quer.getMclass());
                                            }
                                        }
                                        else {
                                            processall.getInstance().addtoclassnames(quer.getMclass());
                                        }
                                    }
                                } catch (Exception e) {
                                    try {
                                        final question quere = mdb.questionDao().LoadOrdinaryBycoolId(quer.getCoolid());
                                        if (quer.getTimestamp() == quere.getTimestamp()) {
                                            quer.setRead(quere.isRead());
                                            questions.add(quer);

                                        } else {

                                            quer.setRead(false);


                                        }
                                        String classname = quer.getMclass();
                                        mdb.questionDao().updateQuestion(quer);
//                                        if(!processall.getInstance().getNamesofupdatedclasses().isEmpty()) {
//                                            if(!processall.getInstance().getNamesofupdatedclasses().contains(quer.getMclass())) {
//                                                processall.getInstance().addtoclassnames(quer.getMclass());
//                                            }
//                                        }
//                                        else {
//                                            processall.getInstance().addtoclassnames(quer.getMclass());
//                                        }
//                                        tobeshownquestionstrings.add(quer.getBody());
//                                        questionssendernames.add(quer.getWho());
////                                                questions.add(quer);
//                                        if (tobeshownquestionstrings.size() > 0) {
//                                            showForegroundNotification(tobeshownquestionstrings, questionssendernames, 0, classname);
//                                        }
//                                                if (mysharedpreferences.getBoolean("soundstate", true) && mysharedpreferences.getBoolean("inmain", true)) {
//                                                    mediaPlayer.start();
//                                                }


                                    } catch (Exception m) {

                                    }
                                }

                            }


                        }
                        AppExecutor.getsInstance().diskIO().execute(new Runnable() {
                            @Override
                            public void run() {
                                if(!processall.getInstance().getNamesofupdatedclasses().isEmpty()) {
                                    notivcations(processall.getInstance().getClassnames(), "Contributions", 2);
                                }
                            }
                        });
                    }

                });


            }


//               myEditor.apply();


            @Override
            public void onChildChanged(@NonNull final DataSnapshot dataSnapshot, @Nullable String s) {
//                timeStamp= mysharedpreferences.getLong("stampy",0);
//               allquestionsupdate.clear();
//               allquestionsupdate = Showallquestions(dataSnapshot);
//               for(int i =0; i<allquestionsupdate.size();i++){
//                   if(allquestionsupdate.get(i)!=null){
////                       if(allquestionsupdate.get(i).getTimestamp()>=timeStamp){
//                           if(namepro.getNemail()!=null){
//                               if(allquestionsupdate.get(i).getYemail().equals(namepro.getNemail())){
//                                   allquestionsupdate.get(i).setRead(true);
//                               }
//                           }
//                           mdb.questionDao().updateQuestion(allquestionsupdate.get(i));
//
//                       timeStamp = allquestionsupdate.get(i).getTimestamp();
////                       myEditor.putLong("stampy",timeStamp);
//
//                       }
//                   }

                AppExecutor.getsInstance().diskIO().execute(
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    question quer = dataSnapshot.getValue(question.class);
                                    if (quer.getMclass() != null) {
//                                        if (quer.getMclass().equals(mysharedpreferences.getString("userclass", ""))) {
//
//                                            if (quer.getCoolid() == null) {
//                                                String coolid = quer.getYemail() + quer.getTimestamp();
//                                                quer.setCoolid(coolid);
//
//                                            }
                                        question quere = mdb.questionDao().LoadOrdinaryBycoolId(quer.getCoolid());
                                        if (quer.getTimestamp() == quere.getTimestamp()) {
                                            quer.setRead(quere.isRead());
                                        } else {
                                            quer.setRead(false);
                                        }
                                        mdb.questionDao().updateQuestion(quer);
//                                            if (mysharedpreferences.getBoolean("soundstate", false) && mysharedpreferences.getBoolean("inmain", false)) {
//                                                mediaPlayer.start();
//                                            }
                                    }

                                } catch (Exception e) {

                                }
                            }


                        }
                );


            }
//               myEditor.apply();

            @Override
            public void onChildRemoved(@NonNull final DataSnapshot dataSnapshot) {
//                timeStamp = mysharedpreferences.getLong("stampy",0);
//               allquestionsremove.clear();
//               allquestionsremove = Showallquestions(dataSnapshot);
//               for(int i =0; i<allquestionsremove.size();i++){
//                   if(allquestionsremove.get(i)!=null){
////                       if(allquestionsremove.get(i).getTimestamp()>=timeStamp){
////                           mdb.questionDao().updateQuestion(allquestionsremove.get(i));
//                           myEditor.putString("stamped",String.valueOf(allquestionsremove.get(i).getTimestamp()));
//                           timeStamp= allquestionsremove.get(i).getTimestamp();
////                           myEditor.putLong("stampy",timeStamp);
//                       }
//                   }

                AppExecutor.getsInstance().diskIO().execute(
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    question quer = dataSnapshot.getValue(question.class);
                                    if (quer.getMclass() != null) {

                                        try {
                                            mdb.questionDao().deleteQuestion(quer);
                                        } catch (Exception e) {

                                        }
                                    }
                                } catch (Exception e) {

                                }
                            }
                        }

                );
            }
//               myEditor.apply();


            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        showForegroundNotification(tobeshownquestionstrings,questionssendernames,0);
    }

    public void loadanswers()

    {
        frefb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull final DataSnapshot dataSnapshot, @Nullable String s) {

                AppExecutor.getsInstance().diskIO().execute(new Runnable() {
                                                                   @Override
                                                                   public void run() {
                                                                       final Answer ans = dataSnapshot.getValue(Answer.class);
                                                                       answers.add(ans);
                                                                       processall.getInstance().setAnsweres(answers);


                                                                       if (ans.getMclassi() != null) {
                                                                           if(processall.getInstance().getClassnames().contains(ans.getMclassi())){
                                                                               try {
                                                                                   mdb.answerdao().insertAnswer(ans);
                                                                                   answerstrings.add(ans.getAnswerbody());
                                                                                   answersendernames.add(ans.getName());
                                                                                   questioncoolids.add(ans.getQuestioncoolid());
                                                                                   if (answerstrings.size() > 0) {
                                                                                       showAnswerForegroundNotification(answerstrings, answersendernames, questioncoolids,ans.getMclassi());
                                                                                   }

                                                                                   AppExecutor.getsInstance().diskIO().execute(new Runnable() {
                                                                                       @Override
                                                                                       public void run() {
                                                                                           if (!answers.isEmpty()) {
                                                                                               allclassAnswernotifications(processall.getInstance().getAnsweres(), classorgroup, ans.getMclassi());
                                                                                           }
                                                                                       }
                                                                                   });
                                                                                   if(!processall.getInstance().getNamesofupdatedclasses().isEmpty()) {
                                                                                       if(!processall.getInstance().getNamesofupdatedclasses().contains(quer.getMclass())) {
                                                                                           processall.getInstance().addtoclassnames(ans.getMclassi());
                                                                                       }
                                                                                   }
                                                                                   else {
                                                                                       processall.getInstance().addtoclassnames(ans.getMclassi());
                                                                                   }
//                                            showAnswerForegroundNotification(ans.getAnswerbody(),ans.getQuestioncoolid());
//                                                                                   if (mysharedpreferences.getBoolean("soundstate", false) && mysharedpreferences.getBoolean("ininner", false)) {
//                                                                                       mediaPlayer.start();
//                                                                                   }
                                                                               } catch (Exception e) {
                                                                                   mdb.answerdao().updateAnswer(ans);
//                                                                                   if(!processall.getInstance().getNamesofupdatedclasses().isEmpty()) {
//                                                                                       if(!processall.getInstance().getNamesofupdatedclasses().contains(quer.getMclass())) {
//                                                                                           processall.getInstance().addtoclassnames(ans.getMclassi());
//                                                                                       }
//                                                                                   }
//                                                                                   else {
//                                                                                       processall.getInstance().addtoclassnames(ans.getMclassi());
//                                                                                   }
////                                                                                   answerstrings.add(ans.getAnswerbody());
//                                                                                   answersendernames.add(ans.getName());
//                                                                                   questioncoolids.add(ans.getQuestioncoolid());
//                                                                                   if (answerstrings.size() > 0) {
//                                                                                       showAnswerForegroundNotification(answerstrings, answersendernames, questioncoolids);
//                                                                                   }

//                                            showAnswerForegroundNotification(ans.getAnswerbody(),ans.getQuestioncoolid());
//                                                                                if (mysharedpreferences.getBoolean("soundstate", false) && mysharedpreferences.getBoolean("innner", false)) {
//                                                                                    mediaPlayer.start();
//                                                                                }
                                                                               }

                                                                           }
                                                                       }
                                                                       AppExecutor.getsInstance().diskIO().execute(new Runnable() {
                                                                           @Override
                                                                           public void run() {
                                                                               if(!processall.getInstance().getNamesofupdatedclasses().isEmpty()) {
                                                                                   notivcations(processall.getInstance().getNamesofupdatedclasses(), "Contributions", 2);
                                                                               }
                                                                           }
                                                                       });

                                                                   }
                                                               }
                );


            }

            @Override
            public void onChildChanged(@NonNull final DataSnapshot dataSnapshot, @Nullable String s) {

                AppExecutor.getsInstance().diskIO().execute(
                        new Runnable() {
                            @Override
                            public void run() {

                                Answer ans = dataSnapshot.getValue(Answer.class);
                                if (ans.getMclassi() != null) {
//                                    if (ans.getMclassi().equals(mysharedpreferences.getString("userclass", ""))) {
//
//                                        if (ans.getCoolid() == null) {
//                                            String coolid = ans.getEmail() + ans.getTimestamp();
//                                            ans.setCoolid(coolid);
//                                        }
                                    try {
                                        mdb.answerdao().updateAnswer(ans);
//                                            if (mysharedpreferences.getBoolean("soundstate", false) && mysharedpreferences.getBoolean("innner", false)) {
//                                                mediaPlayer.start();
//                                            }
                                    } catch (Exception e) {

                                    }
                                }
                            }

                        }
                );

            }
//
// myEditor.apply();

            @Override
            public void onChildRemoved(@NonNull final DataSnapshot dataSnapshot) {

                AppExecutor.getsInstance().diskIO().execute(
                        new Runnable() {
                            @Override
                            public void run() {
                                Answer ans = dataSnapshot.getValue(Answer.class);
                                if (quer.getMclass() != null) {
//                                    if (quer.getMclass().equals(mysharedpreferences.getString("userclass", ""))) {
//
//                                        if (ans.getCoolid() == null) {
//                                            String coolid = ans.getEmail() + ans.getTimestamp();
//                                            ans.setCoolid(coolid);
//                                        }
                                    try {
                                        mdb.answerdao().deleteAnswer(ans);
                                    } catch (Exception e) {

                                    }
                                }
                            }

                        }
                );
            }
//               myEditor.apply();


            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        showAnswerForegroundNotification(answerstrings,answersendernames,questioncoolids);
    }

    //    public List<question> showAnsweredquestions(String name, DataSnapshot dataSnapshot){
//        GenericTypeIndicator<HashMap<String, question>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, question>>() {
//        };
//        Map<String, question> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
////                List<question> dear;
//        if(dataSnapshot.getValue()!=null) {
//            List<question> questions = new ArrayList<question>(objectHashMap.values());
////        anstring = new ArrayList<String>(objectHashMap.keySet());
//            List<question> anquestions = new ArrayList<question>();
////                List<String> anstring = new ArrayList<String>();
//            if (!questions.isEmpty()) {
//                anquestions.clear();
//                for (int i = 0; i < questions.size(); i++) {
//                    if (questions.get(i).getMclass().equals(name)) {
//                        if (questions.get(i).isAnswered()) {
////                            questions.get(i).setRead(Spreferences.ReadState(mysharedpreference, questions.get(i).getQueid(), myeditor, questions.get(i).getNoanswer(), questions.get(i).getNocomment()));
//                            anquestions.add(questions.get(i));
//                            Collections.sort(anquestions, new Comparator<question>() {
//                                @Override
//                                public int compare(question t0, question t1) {
//                                    return (int)(t1.getTimestamp()-t0.getTimestamp());
//                                }
//                            });
//
//                        }
//                    }
//                }
//            }
//            return anquestions;
//        }
//        return null;
//    }
//
    public void completeloadquestionwithimage() {
        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            List<question> questions = new ArrayList<>();
                            questions = mdb.questionDao().LoadAllOrdunaryQuestions();
                            for (int i = 0; i < questions.size(); i++) {
                                if (questions.get(i).isPending()) {
                                    if (questions.get(i).isHasImage()) {
                                        questions.get(i).setRead(false);
                                        questions.get(i).setPending(false);
//                                    loadpendingimageanswers(); ll
                                        showpendingquestionwithimage(questions.get(i));
                                    } else {

                                    }
                                }
                            }
                        } catch (Exception e) {

                        }
                    }

                }
        );
    }

    public void completeloadanswerwithimage() {
        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            List<Answer> answers = new ArrayList<>();
                            answers = mdb.answerdao().LoadAllOrdinaryAnswer();
                            for (int i = 0; i < answers.size(); i++) {
                                if (answers.get(i).isPending()) {
                                    if (answers.get(i).isHasimage()) {
                                        answers.get(i).setPending(false);
                                        uploadpendinganswerwithimage(answers.get(i), answers.get(i).getQuestioncoolid());
                                    }
                                } else {
                                }
                            }
                        } catch (Exception e) {

                        }
                    }
                }
        );
    }

    public List<question> Showallquestions(DataSnapshot dataSnapshot) {
        GenericTypeIndicator<HashMap<String, question>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, question>>() {
        };
        Map<String, question> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
//                List<question> dear;
        if (dataSnapshot.getValue() != null) {
            List<question> questions = new ArrayList<question>(objectHashMap.values());
            List<question> bean = new ArrayList<question>();
            if (!questions.isEmpty()) {

                for (int i = 0; i < questions.size(); i++) {
                    if (questions.get(i).getCoolid() == null) {
                        String coolid = questions.get(i).getYemail() + questions.get(i).getTimestamp();
                        questions.get(i).setCoolid(coolid);
                    }
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

    public void uploadpendingimagelessquestions() {

        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            List<question> questions = new ArrayList<>();
                            questions = mdb.questionDao().LoadAllOrdunaryQuestions();
                            for (int i = 0; i < questions.size(); i++) {
                                if (questions.get(i).isPending()) {
                                    if (!questions.get(i).isHasImage()) {
                                        questions.get(i).setRead(false);
                                        questions.get(i).setPending(false);
                                        if (questions.get(i).getQueid() != null && !questions.get(i).getQueid().equals("")) {
                                            frefd.child(questions.get(i).getQueid()).setValue(questions.get(i));
                                        } else {
                                            String keystring = frefd.push().getKey();
                                            questions.get(i).setQueid(keystring);
                                            frefd.child(keystring).setValue(questions.get(i));
                                        }
                                    } else {

                                    }
                                }
                            }
                        } catch (Exception e) {

                        }
                    }
                }
        );
    }

    public void loadpendingimagequestions() {
        List<question> questions = new ArrayList<>();
        questions = mdb.questionDao().LoadAllOrdunaryQuestions();
        for (int i = questions.size() - 1; i >= 0; i--) {
            if (questions.get(i).isPending()) {
                if (questions.get(i).isHasImage()) {
                    questions.get(i).setRead(false);
                    questions.get(i).setPending(false);
                    if (questions.get(i).getCoolid() != null && !questions.get(i).getCoolid().equals("")) {
                        Intent jintent = new Intent(getApplicationContext(), UploadOne.class);
                        jintent.putExtra("coolid", questions.get(i).getCoolid());
                        if (!isMyServiceRunning(UploadOne.class)) {
                            startService(jintent);
                        }
                    } else {

                    }
                } else {

                }
            }
        }
    }

    public void loadpendingimageanswers() {
        List<Answer> answers = new ArrayList<>();
        answers = mdb.answerdao().LoadAllOrdinaryAnswer();
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).isPending()) {
                if (answers.get(i).isHasimage()) {
                    answers.get(i).setPending(false);
                    Intent jintent = new Intent(getApplicationContext(), UploadAnswer.class);
                    jintent.putExtra("coolid", answers.get(i).getCoolid());
                    jintent.putExtra("questioncoolid", answers.get(i).getQuestioncoolid());
                    if (!isMyServiceRunning(UploadAnswer.class)) {
                        startService(jintent);
                    }
                }
            } else {

            }
        }

    }


    private void showForegroundNotification(final List<String> a, List<String> b, int currentviewpagei, String classname) {
        // Create intent that will bring our app to the front, as if it was tapped in the app
        // launcher
        String m = "0";
        notification = null;
        Intent showTaskIntent = new Intent(getApplicationContext(), MainActivity.class);
        showTaskIntent.setAction(Intent.ACTION_MAIN);
        showTaskIntent.putExtra("currentviewpage", currentviewpagei);
        showTaskIntent.putExtra("newclassname", classname);
        showTaskIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        showTaskIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent contentIntent = PendingIntent.getActivity(
                getApplicationContext(),
                NOTIFICATION_ID,
                showTaskIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        if (a.size() >= 4) {
            m = String.valueOf(a.size() - 4);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                builder = new Notification.Builder(getApplicationContext())
                        .setContentTitle(getString(R.string.app_name))
                        .setSmallIcon(R.drawable.skipeoplef)
                        .setPriority(Notification.PRIORITY_HIGH)
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentText("Hi " + mysharedpreferences.getString("username", "") + " new questions have been asked in class, can you help?")
                        .setStyle(new Notification.InboxStyle()
                                .addLine(b.get(b.size() - 4) + " " + a.get(a.size() - 4))
                                .addLine(b.get(b.size() - 3) + " " + a.get(a.size() - 3))
                                .addLine(b.get(b.size() - 2) + " " + a.get(a.size() - 2))
                                .addLine(b.get(b.size() - 1) + " " + a.get(a.size() - 1))
                                .setSummaryText("+" + m + " more")
                                .setBigContentTitle("New Questions From " + classname))
                        .setContentIntent(contentIntent);

            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder.setColor(Color.parseColor("#659900"));

            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                builder.setChannelId("ide");
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                notification = builder.build();
            }
        } else {
            if (a.size() > 2) {
                m = String.valueOf(a.size() - 2);

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    builder = new Notification.Builder(getApplicationContext())
                            .setContentTitle(getString(R.string.app_name))
                            .setSmallIcon(R.drawable.skipeoplef)
                            .setPriority(Notification.PRIORITY_HIGH)
                            .setWhen(System.currentTimeMillis())
                            .setAutoCancel(true)
                            .setContentText("Hi " + mysharedpreferences.getString("username", "") + " new questions have been asked in class, can you help?")
                            .setStyle(new Notification.InboxStyle()
                                    .addLine(b.get(0) + " " + a.get(0))
                                    .addLine(b.get(1) + " " + a.get(1))
                                    .addLine(b.get(2) + " " + a.get(2))
                                    .setSummaryText("+" + m + " more")
                                    .setBigContentTitle("New Questions From " + classname))
                            .setContentIntent(contentIntent);

                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder.setColor(Color.parseColor("#659900"));
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    builder.setChannelId("ide");
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    notification = builder.build();
                }
            } else {
                if (a.size() > 1) {
                    m = String.valueOf(a.size() - 1);

                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                        builder = new Notification.Builder(getApplicationContext())
                                .setContentTitle(getString(R.string.app_name))
                                .setSmallIcon(R.drawable.skipeoplef)
                                .setWhen(System.currentTimeMillis())
                                .setAutoCancel(true)
                                .setPriority(Notification.PRIORITY_HIGH)
                                .setContentText("Hi " + mysharedpreferences.getString("username", "") + " new questions have been asked in class, can you help?")
                                .setStyle(new Notification.InboxStyle()
                                        .addLine(b.get(0) + " " + a.get(0))
                                        .addLine(b.get(1) + " " + a.get(1))
                                        .setSummaryText("+" + m + " more")
                                        .setBigContentTitle("New Questions From " + classname))
                                .setContentIntent(contentIntent);

                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        builder.setColor(Color.parseColor("#659900"));
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        builder.setChannelId("ide");
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        notification = builder.build();
                    }
                } else {
                    if (a.size() == 1) {
                        m = String.valueOf(a.size() - 1);

                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                            builder = new Notification.Builder(getApplicationContext())
                                    .setContentTitle(getString(R.string.app_name))
                                    .setSmallIcon(R.drawable.skipeoplef)
                                    .setWhen(System.currentTimeMillis())
                                    .setAutoCancel(true)
                                    .setPriority(Notification.PRIORITY_HIGH)
                                    .setContentText("Hi " + mysharedpreferences.getString("username", "") + "someone asked a new question, can you help?")
                                    .setStyle(new Notification.InboxStyle()
                                            .addLine(b.get(0) + " " + a.get(0))
                                            .setSummaryText("+" + m + " more")
                                            .setBigContentTitle("New Questions From " + classname))
                                    .setContentIntent(contentIntent);

                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            builder.setColor(Color.parseColor("#659900"));
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            builder.setChannelId("ide");
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            notification = builder.build();
                        }
                    }
                }
            }
        }
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//           Toast.makeText(getApplicationContext(),String.valueOf(a.size()),Toast.LENGTH_LONG).show();
//            }
//        });
//        startForeground(NOTIFICATION_ID,notification);
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            if (notificationManager != null) {
                notificationManager.notify(NOTIFICATION_ID, notification);
            }
        } catch (Exception e) {

        }
    }

    private void showAnswerForegroundNotification(List<String> a, List<String> b, final List<String> c, String classname) {
        // Create intent that will bring our app to the front, as if it was tapped in the app
        // launcher
        Notification notification = null;
        String m = "0";
        int ab = a.size();

        arraywatcher = 0;
//        if(a.size()>=3) {
//            Intent [] intent;
//            m = String.valueOf(a.size()-3);
//            Intent showTaskIntent = new Intent(getApplicationContext(), InnerAnswer.class);
//            showTaskIntent.setAction(Intent.ACTION_MAIN);
//            showTaskIntent.putExtra("questioncooolid", c.get(c.size()-3));
//            showTaskIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//            showTaskIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            arrayintents.add(showTaskIntent);
//                    realarraystrings.add( c.get(c.size()-3));
//
//                Intent showTaskIntente = new Intent(getApplicationContext(), InnerAnswer.class);
//                showTaskIntente.setAction(Intent.ACTION_MAIN);
//                showTaskIntente.putExtra("questioncooolid", c.get(c.size() - 2));
//                showTaskIntente.addCategory(Intent.CATEGORY_LAUNCHER);
//                showTaskIntente.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                arrayintents.add(showTaskIntente);
//            realarraystrings.add( c.get(c.size()-2));
//
//            Intent showTaskIntenta = new Intent(getApplicationContext(), InnerAnswer.class);
//            showTaskIntenta.setAction(Intent.ACTION_MAIN);
//            showTaskIntenta.putExtra("questioncooolid", c.get(c.size()-1));
//            showTaskIntenta.addCategory(Intent.CATEGORY_LAUNCHER);
//            showTaskIntenta.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            arrayintents.add(showTaskIntenta);
//            realarraystrings.add( c.get(c.size()-1));
//
//            Intent showTaskIntentc = new Intent(getApplicationContext(), MainActivity.class);
//            showTaskIntentc.setAction(Intent.ACTION_MAIN);
//            showTaskIntentc.addCategory(Intent.CATEGORY_LAUNCHER);
//            showTaskIntentc.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//
//            for (int i = 0;i<realarraystrings.size();i++){
//                for (int j=i+1;j<realarraystrings.size();j++) {
//                    if (i != j) {
//                        if (realarraystrings.get(i).equals(realarraystrings.get(j))){
//                            arraywatcher = 1;
//                               break;
//                        }
//                        }
//
//                    }
//                    if (arraywatcher == 0){
//
//                    arrayintents.get(i).putExtra("questioncooolid", realarraystrings.get(i));
//                        realarrayIntents.add(arrayintents.get(i));
//                    }
//                    arraywatcher = 0;
//                }
////
//            Intent [] intents = new Intent[realarrayIntents.size()+1];
//            intents[0]= showTaskIntentc;
//                for (int i =0; i<realarrayIntents.size();i++){
//                    intents[i+1] = realarrayIntents.get(i);
//                }
//            PendingIntent contentIntent = PendingIntent.getActivities(getApplicationContext(), NOTIFICATION_ID,intents, PendingIntent.FLAG_UPDATE_CURRENT);
//
//
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
//                notification = new Notification.Builder(getApplicationContext())
//                        .setContentTitle(getString(R.string.app_name))
//                        .setSmallIcon(R.drawable.skipeoplef)
//                        .setPriority(Notification.PRIORITY_HIGH)
//                        .setWhen(System.currentTimeMillis())
//                        .setAutoCancel(true)
//                        .setContentText("Hi " + mysharedpreferences.getString("username","")+" a new class talk is on")
//                        .setStyle(new Notification.InboxStyle()
//                                .addLine(b.get(b.size()-3) +" "+ a.get(a.size()-3))
//                                .addLine(b.get(b.size()-2) +" "+ a.get(b.size()-2))
//                                .addLine(b.get(b.size()-1) +" "+ a.get(b.size()-1))
//                                .setSummaryText("+" + m + " more")
//                                .setBigContentTitle("New Answers and comments"))
//                        .setContentIntent(contentIntent)
//                        .build();
//            }
//        }
//        else {
//            if(a.size()>1) {
//                m = String.valueOf(a.size()-1);
//                Intent showTaskIntent = new Intent(getApplicationContext(), InnerAnswer.class);
//                showTaskIntent.setAction(Intent.ACTION_MAIN);
//                showTaskIntent.putExtra("questioncooolid", c.get(c.size()-2));
//                showTaskIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//                showTaskIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                arrayintents.add(showTaskIntent);
//
//                Intent showTaskIntente = new Intent(getApplicationContext(), InnerAnswer.class);
//                showTaskIntente.setAction(Intent.ACTION_MAIN);
//                showTaskIntente.putExtra("questioncooolid", c.get(c.size()-1));
//                showTaskIntente.addCategory(Intent.CATEGORY_LAUNCHER);
//                showTaskIntente.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                arrayintents.add(showTaskIntente);
//
//                Intent showTaskIntentc = new Intent(getApplicationContext(), MainActivity.class);
//                showTaskIntentc.setAction(Intent.ACTION_MAIN);
//                showTaskIntentc.addCategory(Intent.CATEGORY_LAUNCHER);
//                showTaskIntentc.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                 if(c.get(c.size()-1).equals(c.get(c.size()-2))){
//                   realarrayIntents.clear();
//                   realarrayIntents.add(showTaskIntentc);
//                   realarrayIntents.add(showTaskIntent);
//                 }
//                 else {
//                     realarrayIntents.clear();
//                     realarrayIntents.add(showTaskIntentc);
//                     realarrayIntents.add(showTaskIntente);
//                     realarrayIntents.add(showTaskIntent);
//                 }
//                 Intent[] intents = new Intent[realarrayIntents.size()];
//                 for (int i = 0; i<realarrayIntents.size(); i++){
//                     intents[i] = realarrayIntents.get(i);
//                 }
//                PendingIntent contentIntent = PendingIntent.getActivities(getApplicationContext(), NOTIFICATION_ID, intents, PendingIntent.FLAG_UPDATE_CURRENT);
//
//
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
//                    notification = new Notification.Builder(getApplicationContext())
//                            .setContentTitle(getString(R.string.app_name))
//                            .setSmallIcon(R.drawable.skipeoplef)
//                            .setPriority(Notification.PRIORITY_HIGH)
//                            .setWhen(System.currentTimeMillis())
//                            .setAutoCancel(true)
//                            .setContentText("Hi " + mysharedpreferences.getString("username","")+" a new class talk is on")
//                            .setStyle(new Notification.InboxStyle()
//                                    .addLine(b.get(b.size()-2) +" "+ a.get(a.size()-2))
//                                    .addLine(b.get(b.size()-1) +" "+ a.get(a.size()-1))
//                                    .setSummaryText("+" + m + " more")
//                                    .setBigContentTitle("New Answer and comments"))
//                            .setContentIntent(contentIntent)
//                            .build();
//                }
//            }
//
//            else {
        if (a.size() >= 1) {
            m = String.valueOf(a.size() - 1);
            Intent showTaskIntent = new Intent(getApplicationContext(), InnerAnswer.class);
            showTaskIntent.setAction(Intent.ACTION_MAIN);
            showTaskIntent.putExtra("questioncooolid", c.get(b.size() - 1));
            showTaskIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            showTaskIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            arrayintents.add(showTaskIntent);

            Intent showTaskIntentc = new Intent(getApplicationContext(), MainActivity.class);
            showTaskIntentc.setAction(Intent.ACTION_MAIN);
            showTaskIntentc.addCategory(Intent.CATEGORY_LAUNCHER);
            showTaskIntentc.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            arrayintents.add(showTaskIntentc);

            Intent[] intents = {showTaskIntentc, showTaskIntent};
            PendingIntent contentIntent = PendingIntent.getActivities(getApplicationContext(), NOTIFICATION_ID, intents, PendingIntent.FLAG_UPDATE_CURRENT);


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                builder = new Notification.Builder(getApplicationContext())
                        .setContentTitle(getString(R.string.app_name))
                        .setSmallIcon(R.drawable.skipeoplef)
                        .setAutoCancel(true)
                        .setPriority(Notification.PRIORITY_HIGH)
                        .setWhen(System.currentTimeMillis())
                        .setContentText("Hi " + mysharedpreferences.getString("username", "") + ", someone has said something on a question")
                        .setStyle(new Notification.InboxStyle()
                                .addLine(b.get(0) + " " + a.get(0))
                                .setSummaryText("+" + m + " more")
                                .setBigContentTitle("New Contributions From " + classname))
                        .setContentIntent(contentIntent);
//                    }
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder.setColor(Color.parseColor("#ffbb22"));
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                builder.setChannelId("ide");
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                notification = builder.build();
            }
        }
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            if (notificationManager != null) {
                notificationManager.notify(ANSWER_NOTIFICATION_ID, notification);
            }
        } catch (Exception e) {

        }

//        startForeground(ANSWER_NOTIFICATION_ID, notification);
    }

    public void allclassQuestionnotification(List<question> questions, final List<Classors> classors, String classname) {
        List<String> classnames = new ArrayList<>();
        Classors classor;
//        for (int i = 0; i < questions.size(); i++) {
            for (int j = 0; j < classors.size(); j++) {

                if (classors.get(j).getClassname().equals(classname)&&!classors.get(j).isBlocked()) {
                    if (classnames.isEmpty()) {
                        classnames.add(classors.get(j).getClassname() + " ");
                        final Classors classore = classors.get(j);
                        classore.setUnread(true);
                        AppExecutor.getsInstance().diskIO().execute(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    mdb.classorsDao().insertClassor(classore);
                                } catch (Exception e) {
                                    mdb.classorsDao().updateClassor(classore);
                                }
                            }
                        });

                    } else {
                        if (!classnames.contains(classors.get(j).getClassname() + " ")) {
                            classnames.add(classors.get(j).getClassname() + " ");
                            final Classors classore = classors.get(j);
                            classore.setUnread(true);
                            AppExecutor.getsInstance().diskIO().execute(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        mdb.classorsDao().insertClassor(classore);
                                    } catch (Exception e) {
                                        mdb.classorsDao().updateClassor(classore);
                                    }
                                }
                            });


                        }

                    }
                }

            }

//        }
//        notivcations(classnames, "questions", 1);
    }

    public void allclassAnswernotifications(List<Answer> answers, List<Classors> classors, String classname) {
        List<String> classnames = new ArrayList<>();
//        for (int i = 0; i < answers.size(); i++) {
            for (int j = 0; j < classors.size(); j++) {

                if (classors.get(j).getClassname().equals(classname)&&!classors.get(j).isBlocked()) {
                    if (classnames.isEmpty()) {
                        classnames.add(classors.get(j).getClassname() + " ");
                    } else {
                        if (!classnames.isEmpty() && !classnames.contains(classname)) {
                            classnames.add(classors.get(j).getClassname() + " ");
                        }
                    }
                }

            }


//        notivcations(classnames, "answers", 2);
    }

    public void notivcations(List<String> classnames, String a, int b) {


        Intent showTaskIntentc = new Intent(getApplicationContext(), MainActivity.class);
        showTaskIntentc.setAction(Intent.ACTION_MAIN);
        showTaskIntentc.addCategory(Intent.CATEGORY_LAUNCHER);
        showTaskIntentc.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), NOTIFICATION_ID, showTaskIntentc, PendingIntent.FLAG_UPDATE_CURRENT);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            builder = new Notification.Builder(getApplicationContext())
                    .setContentTitle(getString(R.string.app_name))
                    .setSmallIcon(R.drawable.skipeoplef)
                    .setAutoCancel(true)
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setWhen(System.currentTimeMillis())
                    .setContentText("Hi " + mysharedpreferences.getString("username", "") + " there are new " + a + " from these classes")
                    .setStyle(new Notification.InboxStyle()
                            .addLine(classnames.toString())
                            .setSummaryText("+" + "0" + " more")
                            .setBigContentTitle("New " + a + " From: "))
                    .setContentIntent(contentIntent);
//                    }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (b == 1) {
                builder.setColor(Color.parseColor("#ff6662"));
            } else {
                builder.setColor(Color.parseColor("#11bbff"));
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId("ide");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            notification = builder.build();
        }

        if (b == 1) {
            try {
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (notificationManager != null) {
                    notificationManager.notify(ANSWER_NOTIFICATION_IDA, notification);
                }

            } catch (Exception e) {

            }
        } else {
            try {
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (notificationManager != null) {
                    notificationManager.notify(ANSWER_NOTIFICATION_IDB, notification);
                }

            } catch (Exception e) {

            }
        }
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i("isMyServiceRunning?", true + "");
                return true;
            }
        }
        Log.i("isMyServiceRunning?", false + "");
        return false;
    }

    public void uploadpendingimagelessanswers() {

        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        List<Answer> answers = new ArrayList<>();
                        answers = mdb.answerdao().LoadAllOrdinaryAnswer();
                        for (int i = 0; i < answers.size(); i++) {
                            if (answers.get(i).isPending()) {
                                if (!answers.get(i).isHasimage()) {
                                    answers.get(i).setPending(false);

                                    String keystring = frefc.push().getKey();
                                    frefc.child(keystring).setValue(answers.get(i));
                                }
                            } else {

                            }
                        }
                    }
                }

        );
    }

    private void showpendingquestionwithimage(final question quered) {
        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        quer = quered;
                        if (quer != null) {
//                            Toast.makeText(getApplicationContext(),"gotten question",Toast.LENGTH_LONG).show();
                            quer.setRead(false);
                            quer.setPending(false);
                            if (quer.isHasImage() && quer.getUristring() != null) {
//          f                      Toast.makeText(getApplicationContext(),"raiding image",Toast.LENGTH_LONG).show();
                                imagebitmap = getbitmap(Uri.parse(quer.getUristring()));
                                secondpath = convertofile(fii, imagebitmap);
                                firstpath = convertoofile(fid, imagebitmap);
                                processthrough(frefa, quer, firstpath, secondpath);
                            }

                        } else {
//                            Toast.makeText(getApplicationContext(),"question is null",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );


    }

    private void uploadanswerpendingquestions() {
        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        List<question> questions = new ArrayList<>();
                        questions = mdb.questionDao().LoadAllOrdunaryQuestions();
                        for (int i = 0; i < questions.size(); i++) {
                            if (questions.get(i).isAnspending()) {
                                questions.get(i).setRead(false);
                                questions.get(i).setAnspending(false);
                                if (questions.get(i).getQueid() != null && !questions.get(i).getQueid().equals("")) {
                                    frefd.child(questions.get(i).getQueid()).setValue(questions.get(i));
                                } else {
                                    String keystring = frefd.push().getKey();
                                    questions.get(i).setQueid(keystring);
                                    frefd.child(keystring).setValue(questions.get(i));
                                }
                            }
                        }
                    }
                }
        );
    }

    private void uploadpendinganswerwithimage(final Answer ansred, final String questioncoolid) {
        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        ans = ansred;
                        quer = mdb.questionDao().LoadOrdinaryBycoolId(questioncoolid);
                        if (ans != null) {
                            ans.setPending(false);
                            if (ans.isHasimage()) {
                                imagebitmap = getbitmap(Uri.parse(ans.getUristring()));
                                secondpath = convertofile(fii, imagebitmap);
                                firstpath = convertoofile(fid, imagebitmap);
                                processthrough(frefc, ans, firstpath, secondpath, quer);
                            }

                        }
                    }
                }
        );

    }

    private Bitmap getbitmap(Uri filePath) {
        Bitmap bitmap;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getApplication().getContentResolver(), filePath);
            return bitmap;
        } catch (Exception e) {

        }
        return null;
    }

    private question runquesions(List<question> questions, int p, double timestamp) {
        for (int i = (questions.size() - p); i < questions.size(); i++) {
            if (questions.get(i).getTimestamp() == timestamp) {
                return questions.get(i);
            }

        }
        return null;
    }

    private void processthrough(DatabaseReference databaseReference, question quer, final Uri firstpath, Uri secondpath) {
        hand.post(new Runnable() {
            @Override
            public void run() {
//                Toast.makeText(getApplicationContext(),"processing through",Toast.LENGTH_LONG).show();
            }
        });

        String mmuid = databaseReference.push().getKey();

        hand.post(new Runnable() {
            @Override
            public void run() {
//                Toast.makeText(getApplicationContext(),firstpath.toString(),Toast.LENGTH_LONG).show();
            }
        });

        uploadImage(quer.getQueid(), firstpath, secondpath, quer);
    }

    private void uploadImage(final String mmuid, Uri uri, final Uri secondpath, final question quer) {

        if (uri != null) {
            FirebaseStorage.getInstance().getReference("questionimages").child(mmuid).putFile(uri)
                    .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful()) {

                                hand.post(new Runnable() {
                                    @Override
                                    public void run() {
//                                        Toast.makeText(getApplicationContext(), "loaded thumbline", Toast.LENGTH_LONG).show();
                                    }
                                });

                                Uri questionthumbline;


                                coolthumbline = task.getResult().getUploadSessionUri().toString();

                                quer.setThumblineuri(coolthumbline);
                                hand.post(new Runnable() {
                                    @Override
                                    public void run() {
//                                        Toast.makeText(getApplicationContext(), coolthumbline, Toast.LENGTH_LONG).show();
                                    }
                                });
                                askit(quer, mmuid, secondpath);
                            } else {
                                hand.post(new Runnable() {
                                    @Override
                                    public void run() {
//                                        Toast.makeText(getApplicationContext(),"failed to load thumbline",Toast.LENGTH_LONG).show();
                                    }
                                });


                                takenotethumbfailed();
                                coolthumbline = null;
                            }
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            int progress = (int) (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            Intent intent = new Intent(InnerAnswer.PROGRESS_ACTION);
                            intent.putExtra("progress", progress);
//                            LocalBroadcastManager.getInstance(UploadOne.this).sendBroadcast(intent);
//                                trestee.setText(String.valueOf(dabble) + "%");
                        }

//

                    });

        } else {
            hand.post(new Runnable() {
                @Override
                public void run() {
//                    Toast.makeText(getApplicationContext(),"I couldnt find uri for thumbline image",Toast.LENGTH_LONG).show();
                }
            });


            coolthumbline = null;
        }
    }

    private void uploadrealImage(String push, Uri uri, final question querf, final String mmuid) {
        if (uri != null) {

            FirebaseStorage.getInstance().getReference("questionimages").child("real" + push).putFile(uri).addOnCompleteListener(
                    new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful() && task.isComplete()) {

                                coolreal = task.getResult().getUploadSessionUri().getPath();

                                querf.setDownloadurid(coolreal);
                                frefa.child(mmuid).setValue(querf);
                                hand.post(new Runnable() {
                                    @Override
                                    public void run() {
//                                        Toast.makeText(getApplicationContext(),"done loading images",Toast.LENGTH_LONG).show();
                                    }
                                });


                            } else {
                                hand.post(new Runnable() {
                                    @Override
                                    public void run() {
//                                        Toast.makeText(getApplicationContext(),"failed to upload real",Toast.LENGTH_LONG).show();
                                    }
                                });

                            }
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();

//                            trestee.setText(String.valueOf(progress)+"%");
//                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });

        } else {
            hand.post(new Runnable() {
                @Override
                public void run() {
//                    Toast.makeText(getApplicationContext(),"i couldnt find uri for real image upload",Toast.LENGTH_LONG).show();
                }
            });

        }
    }

    public void askit(final question querf, final String mmuid, final Uri secondpath) {
        querf.setThumblineuri(coolthumbline);
        querf.setQueid(mmuid);
        frefa.child(mmuid).setValue(querf).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {

//                    Toast.makeText(getApplicationContext(),"successfully asked your question",Toast.LENGTH_LONG).show();
                    uploadrealImage(mmuid, secondpath, querf, mmuid);

                } else {

//                takenoteputquestionfailed();
//                    Toast.makeText(getApplicationContext(),"failed to ask your question",Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    public Uri convertofile(File file, Bitmap bit) {
        Uri uri;
        file = new File(getApplicationContext().getCacheDir(), "images");
        try {
            file.createNewFile();
        } catch (Exception e) {

        }
//Convert bitmap to byte array
        try {
            Bitmap bitmap = bit;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100 /*ignored for PNG*/, bos);
            bitmapdata = bos.toByteArray();
        } catch (Exception e) {
            handler.post(new Runnable() {
                @Override
                public void run() {
//                    Toast.makeText(getApplicationContext(),"i just enciunterd an error processing image",Toast.LENGTH_LONG).show();
                }
            });

        }
//write the bytes in file
        try {
            FileOutputStream fos = new FileOutputStream(file);

            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            uri = Uri.fromFile(file);
//            uri = Uri.parse(compressImage(uri.toString()));
        } catch (Exception e) {
//       displayo(e.toString());


            convertofilefailed();
            uri = null;
        }
        return uri;

    }

    public Uri convertoofile(File file, Bitmap bit) {
        Uri uri;
        file = new File(getApplicationContext().getCacheDir(), "images");
        try {
            file.createNewFile();
        } catch (Exception e) {

        }
//Convert bitmap to byte array
        try {
            Bitmap bitmap = bit;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 10 /*ignored for PNG*/, bos);
            bitmapdata = bos.toByteArray();
        } catch (Exception e) {
            handler.post(new Runnable() {
                @Override
                public void run() {
//               Toast.makeText(getApplicationContext(),"error processing some images",Toast.LENGTH_LONG).show();
                }
            });
        }
//write the bytes in file
        try {
            FileOutputStream fos = new FileOutputStream(file);

            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            uri = Uri.fromFile(file);
            uri = Uri.parse(compressoImage(uri.toString()));
        } catch (Exception e) {
//            displayo(e.toString());
            compressourinotExists();
            uri = null;
        }
        return uri;

    }

    public String compressoImage(String imageUri) {

        String filePathy = getRealPathFromURI(imageUri);
        Bitmap scaledBitmap = null;
        InputStream is = null;
//        try {
//            URL url = new URL(imageUri);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            is = connection.getInputStream();
//        }
//        catch (Exception e){
//
//        }
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;

//        BitmapFactory.decodeStream(is, null, options);
//        URL url = new URL(mCurrentPhotoPath);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//        InputStream is = connection.getInputStream();
        BitmapFactory.Options options = new BitmapFactory.Options();

//      by setting this field as true, the actual bitmap pixels are not loaded in the memory. Just the bounds are loaded. If
//      you try the use the bitmap here, you will get null.
        options.inJustDecodeBounds = true;
//        Bitmap bmp = BitmapFactory.decodeStream(is, null, options);
        Bitmap bmp = BitmapFactory.decodeFile(filePathy, options);
//        Bitmap bmp = BitmapFactory.decodeFile(new File(filePath.getPath()).getAbsolutePath(), options);
//
//
        actualHeight = options.outHeight;
        actualWidth = options.outWidth;

//        int actualHeight = 504;
//        int actualWidth = 504;

//      max Height and width values of the compressed image is taken as 816x612

        float maxHeight = 816.0f;
        float maxWidth = 612.0f;
        float imgRatio = actualWidth / actualHeight;
        float maxRatio = maxWidth / maxHeight;

//      width and height values are set maintaining the aspect ratio of the image

        if (actualHeight > maxHeight || actualWidth > maxWidth) {
            if (imgRatio < maxRatio) {
                imgRatio = maxHeight / actualHeight;
                actualWidth = (int) (imgRatio * actualWidth);
                actualHeight = (int) maxHeight;
            } else if (imgRatio > maxRatio) {
                imgRatio = maxWidth / actualWidth;
                actualHeight = (int) (imgRatio * actualHeight);
                actualWidth = (int) maxWidth;
            } else {
                actualHeight = (int) maxHeight;
                actualWidth = (int) maxWidth;

            }
        }


        options.inSampleSize = calculateInSampleSize(options, actualWidth, actualHeight);

//      inJustDecodeBounds set to false to load the actual bitmap
        options.inJustDecodeBounds = false;

//      this options allow android to claim the bitmap memory if it runs low on memory
        options.inPurgeable = true;
        options.inInputShareable = true;

        options.inTempStorage = new byte[16 * 1024];

        try {
//          load the bitmap from its path
            bmp = BitmapFactory.decodeFile(filePathy, options);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();

        }
        try {
            scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();
        }

        float ratioX = actualWidth / (float) options.outWidth;
        float ratioY = actualHeight / (float) options.outHeight;
        float middleX = actualWidth / 2.0f;
        float middleY = actualHeight / 2.0f;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bmp, middleX - bmp.getWidth() / 2, middleY - bmp.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));
//      check the rotation of the image and display it properly
        ExifInterface exif;
        try {
            exif = new ExifInterface(filePathy);

            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, 0);
            Log.d("EXIF", "Exif: " + orientation);
            Matrix matrix = new Matrix();
            if (orientation == 6) {
                matrix.postRotate(90);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 3) {
                matrix.postRotate(180);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 8) {
                matrix.postRotate(270);
                Log.d("EXIF", "Exif: " + orientation);
            }
            scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0,
                    scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix,
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        }
        Uri uri;
        vfile = new File(getApplicationContext().getCacheDir(), "scaledimages");
        try {
            vfile.createNewFile();
        } catch (Exception e) {

        }
//Convert bitmap to byte array
//        Bitmap bitmap = bit;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 10 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
        try {
            FileOutputStream fos = new FileOutputStream(vfile);

            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            uri = Uri.fromFile(vfile);
//            uri = Uri.parse(compressImage(uri.toString()));
        } catch (Exception e) {
//            displayo(e.toString());
            failedduringcompresso();
//            displayo("failed already");
            uri = null;
        }
        return uri.toString();
//        return filename;

    }


    private void processthrough(DatabaseReference databaseReference, Answer ans, Uri firstpath, Uri secondpath, question quer) {

        uploadImage(ans.getAnswerid(), firstpath, secondpath, ans, quer);
        handler.post(new Runnable() {
            @Override
            public void run() {
//                Toast.makeText(getApplicationContext(),"processing true",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void uploadImage(final String mmuid, Uri uri, final Uri secondpath, final Answer ans, final question quer) {

        if (uri != null) {

            StorageReference ref = FirebaseStorage.getInstance().getReference("answerimages").child(mmuid);
            ref.putFile(uri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            progressDialog.dismiss();
                            Uri questionthumbline;
                            questionthumbline = taskSnapshot.getUploadSessionUri();

//
//
                            coolthumbline = questionthumbline.toString();
                            ans.setThumblineuri(coolthumbline);
                            askit(ans, mmuid, secondpath, quer);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
//                                    Toast.makeText(getApplicationContext(),"loaded answer thumbline",Toast.LENGTH_LONG).show();
                                }
                            });

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
//
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
//                                    Toast.makeText(getApplicationContext(),"failed to load thumbline",Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());

//                                trestee.setText(String.valueOf(dabble) + "%");
                        }

//

                    });

        } else {
            handler.post(new Runnable() {
                @Override
                public void run() {
//                    Toast.makeText(getApplicationContext(),"could not find thumbline",Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    private void uploadrealImage(String push, Uri uri, final Answer ans, final String mmuid) {
        if (uri != null) {
            StorageReference ref = FirebaseStorage.getInstance().getReference("answerimages").child("real" + push);
            ref.putFile(uri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                            Uri realquestionuri = taskSnapshot.getUploadSessionUri();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
//                                    Toast.makeText(getApplicationContext(),"loaded answer real",Toast.LENGTH_LONG).show();
                                }
                            });
                            coolreal = realquestionuri.toString();
                            ans.setDownloaduri(coolreal);
                            frefc.child(mmuid).setValue(ans).addOnCompleteListener(
                                    new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                handler.post(
                                                        new Runnable() {
                                                            @Override
                                                            public void run() {
//                                                        Toast.makeText(getApplicationContext(),"done with question",Toast.LENGTH_LONG).show();
                                                            }
                                                        });
                                            } else {
                                                handler.post(new Runnable() {
                                                    @Override
                                                    public void run() {
//                                                        Toast.makeText(getApplicationContext(),"there is still a glitch",Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                            }
                                        }
                                    }
                            );
//

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
//                                    Toast.makeText(getApplicationContext(),"failed to load real",Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();

//                            trestee.setText(String.valueOf(progress)+"%");
//                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });

        } else {
            takenoterealpathfailed();
        }
    }

    public void takenoterealpathfailed() {
        errormessage = 4;
    }

    public void failedduringcompresso() {
        errormessage = 9;
    }

    public void takenotethumbfailed() {
        errormessage = 3;
    }

    public void takenotethumblinepathfailed() {
        errormessage = 5;
    }

    public void takenoterealfailed() {
        errormessage = 2;
    }

    public void takenoteputquestionfailed() {
        errormessage = 1;
    }

    public void compressourinotExists() {
        errormessage = 8;
    }

    public void convertofilefailed() {
        errormessage = 7;
    }

    public void compressimagefailed() {
        errormessage = 6;
    }

    public void askit(final Answer anse, final String mmuid, final Uri seconpath, final question quer) {

//        anse.setDownloaduri(coolreal);
        try {
            anse.setThumblineuri(coolthumbline);
            anse.setAnswerid(mmuid);
            anse.setPending(false);
            frefc.child(mmuid).setValue(anse).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
//                            Toast.makeText(getApplicationContext(),"successfully placed your answer",Toast.LENGTH_LONG).show();
                            }
                        });
                        quer.setTimestamp(anse.getTimestamp());
                        frefa.child(quer.getQueid()).setValue(quer);
                        uploadrealImage(mmuid, seconpath, anse, mmuid);

                    } else {

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
//                                Toast.makeText(getApplicationContext(), "failed to load your answer", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }

            });
        } catch (Exception e) {

        }
    }


    private String getRealPathFromURI(String contentURI) {
        Uri contentUri = Uri.parse(contentURI);
        Cursor cursor = getApplication().getContentResolver().query(contentUri, null, null, null, null);
        if (cursor == null) {
            return contentUri.getPath();
        } else {
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(index);
        }

    }

    public int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        final float totalPixels = width * height;
        final float totalReqPixelsCap = reqWidth * reqHeight * 2;
        while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
            inSampleSize++;
        }

        return inSampleSize;
    }

    public String compressImage(String imageUri) {

        String filePathy = getRealPathFromURI(imageUri);
        Bitmap scaledBitmap = null;
        InputStream is = null;
//        try {
//            URL url = new URL(imageUri);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            is = connection.getInputStream();
//        }
//        catch (Exception e){
//
//        }
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;

//        BitmapFactory.decodeStream(is, null, options);
//        URL url = new URL(mCurrentPhotoPath);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//        InputStream is = connection.getInputStream();
        BitmapFactory.Options options = new BitmapFactory.Options();

//      by setting this field as true, the actual bitmap pixels are not loaded in the memory. Just the bounds are loaded. If
//      you try the use the bitmap here, you will get null.
        options.inJustDecodeBounds = true;
//        Bitmap bmp = BitmapFactory.decodeStream(is, null, options);
        Bitmap bmp = BitmapFactory.decodeFile(filePathy, options);
//        Bitmap bmp = BitmapFactory.decodeFile(new File(filePath.getPath()).getAbsolutePath(), options);
//
//
        actualHeight = options.outHeight;
        actualWidth = options.outWidth;

//        int actualHeight = 504;
//        int actualWidth = 504;

//      max Height and width values of the compressed image is taken as 816x612

        float maxHeight = 816.0f;
        float maxWidth = 612.0f;
        float imgRatio = actualWidth / actualHeight;
        float maxRatio = maxWidth / maxHeight;

//      width and height values are set maintaining the aspect ratio of the image

        if (actualHeight > maxHeight || actualWidth > maxWidth) {
            if (imgRatio < maxRatio) {
                imgRatio = maxHeight / actualHeight;
                actualWidth = (int) (imgRatio * actualWidth);
                actualHeight = (int) maxHeight;
            } else if (imgRatio > maxRatio) {
                imgRatio = maxWidth / actualWidth;
                actualHeight = (int) (imgRatio * actualHeight);
                actualWidth = (int) maxWidth;
            } else {
                actualHeight = (int) maxHeight;
                actualWidth = (int) maxWidth;

            }
        }

//      setting inSampleSize value allows to load a scaled down version of the original image

        options.inSampleSize = calculateInSampleSize(options, actualWidth, actualHeight);

//      inJustDecodeBounds set to false to load the actual bitmap
        options.inJustDecodeBounds = false;

//      this options allow android to claim the bitmap memory if it runs low on memory
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16 * 1024];

        try {
//          load the bitmap from its path
            bmp = BitmapFactory.decodeFile(filePathy, options);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();

        }
        try {
            scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError exception) {
            exception.printStackTrace();
        }

        float ratioX = actualWidth / (float) options.outWidth;
        float ratioY = actualHeight / (float) options.outHeight;
        float middleX = actualWidth / 2.0f;
        float middleY = actualHeight / 2.0f;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bmp, middleX - bmp.getWidth() / 2, middleY - bmp.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

//      check the rotation of the image and display it properly
        ExifInterface exif;
        try {
            exif = new ExifInterface(filePathy);

            int orientation = exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION, 0);
            Log.d("EXIF", "Exif: " + orientation);
            Matrix matrix = new Matrix();
            if (orientation == 6) {
                matrix.postRotate(90);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 3) {
                matrix.postRotate(180);
                Log.d("EXIF", "Exif: " + orientation);
            } else if (orientation == 8) {
                matrix.postRotate(270);
                Log.d("EXIF", "Exif: " + orientation);
            }
            scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0,
                    scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix,
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        FileOutputStream out = null;
//        String filename = getFilename();
//        try {
//            out = new FileOutputStream(filename);
//
////          write the compressed bitmap at the destination specified by filename.
//            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 80, out);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Uri uri;
        vfile = new File(getApplicationContext().getCacheDir(), "scaledimages");
        try {
            vfile.createNewFile();
        } catch (Exception e) {

        }
//Convert bitmap to byte array
//        Bitmap bitmap = bit;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 90 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
        try {
            FileOutputStream fos = new FileOutputStream(vfile);

            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            uri = Uri.fromFile(vfile);
//            uri = Uri.parse(compressImage(uri.toString()));
        } catch (Exception e) {
//            displayo(e.toString());
            compressimagefailed();
//            displayo("failed already");
            uri = null;
        }
        return uri.toString();
//        return filename;

    }
}


