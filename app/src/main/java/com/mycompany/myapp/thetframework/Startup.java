package com.mycompany.myapp.thetframework;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Startup extends AppCompatActivity {

    TextView weee, wename;

    Dialog chirob;
    TextView hi;
    TextView descriptivelor;
    //    String userid;
    EditText ednameb, ednumberb, edemailb, confpassyb, passyb;
    LinearLayout namel, emaill, addressl, numberl;
    ImageView finisgnb;
    TextView classcode;
    public static String mnameb, mclassy, memailb, mnumberb, mpasswordb, madvertnob, mbusnumb, mtransnumb;
    TranslateAnimation gr, grm;
    public static  int mquestion, manswer;
    ScaleAnimation vff;
    ImageView passyclickb;
    String poemailb, popasswordb;
    Dialog vorifyb, wtt;
    Dialog me;
    MyDataService myDataService;
    Intent myDataServiceIntent;
    FirebaseAuthException g;
    String userid;
    Mathmatical matinmatical;
//    Mathmatical mathmatical;
    int generaltimer;
    Intent ui;
    private Map<String, question> stillprocessingquestions;
    AppDatabase mdb;
    List<question> allQuestionsinsert, allquestionsupdate, allquestionsremove;
    TextView logrin;
    Toast toast;
    public static String smname, smaddress, smemail, smnumber, smpassword;
    public static int smadvertno, smbusnum, smtransnum;
    //    TextView loed, loedb, loedc;
    TextView wespee;
    ImageView ve, visibility;
    FirebaseAuth mAuthb;
    Intent lmi;
    Intent broadcastIntent;
    FirebaseDatabase mrdatabase;
    DatabaseReference mer, mret;
    boolean isoconnected;
    Mathmatical mathmatical;
    LinearLayout classo;
    TranslateAnimation moveforever;
    int mk;
    TextView goin;
    RelativeLayout reliall;
    RotateAnimation rety;
    int backer = 0;
    EditText edclassi;
    EditText vemailb;
    SharedPreferences mysharedpreferences;
    SharedPreferences.Editor myeditor;
    EditText unnamec, unpassec;
    ImageView unlockc;
    AlphaAnimation alphait, ronin;
    Context context;
    LinearLayout linlrogin;
    FirebaseDatabase ree;
    DatabaseReference lee;
    DatabaseReference classor;
    ImageView loading;
    DatabaseReference Usery;
    RelativeLayout relinowauthenting;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser mFirebaseUser;
    static User usernd;
    TranslateAnimation gre, gri, gru;
    ScaleAnimation Rollout, Rollin;
    TranslateAnimation translatea, translateb, translatec;
    int j = 0;
    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
//    private static final int UI_ANIMATION_DELAY = 300;
//    private final Handler mHideHandler = new Handler();
//    private View mContentView;
//    private final Runnable mHidePart2Runnable = new Runnable() {
//        @SuppressLint("InlinedApi")
//        @Override
//        public void run() {
//            // Delayed removal of status and navigation bar
//
//            // Note that some of these constants are new as of API 16 (Jelly Bean)
//            // and API 19 (KitKat). It is safe to use them, as they are inlined
//            // at compile-time and do nothing on earlier devices.
////            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
////                    | View.SYSTEM_UI_FLAG_FULLSCREEN
////                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
////                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
////                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
////                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
////        }
////
//        }
//    };
        //    private View mControlsView;

//        private boolean mVisible;
//        private final Runnable mHideRunnable = new Runnable() {
//            @Override
//            public void run() {
////            hide();
//            }
//        };
//        /**
//         * Touch listener to use for in-layout UI controls to delay hiding the
//         * system UI. This is to prevent the jarring behavior of controls going away
//         * while interacting with activity UI.
//         */
//        private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
////            if (AUTO_HIDE) {
////                delayedHide(AUTO_HIDE_DELAY_MILLIS);
////            }
//                return false;
//            }
//        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//     ActionBar uy = getSupportActionBar();
//        uy.show();

        setContentView(R.layout.startup);
//        setContentView(R.layout.startup);
        mrdatabase = FirebaseDatabase.getInstance();
        mysharedpreferences = getSharedPreferences("readstate",MODE_PRIVATE);
        myeditor = mysharedpreferences.edit();
        lee = mrdatabase.getReference("question");
        lee.limitToFirst(50);
        Usery = mrdatabase.getReference("Users");
        classor = mrdatabase.getReference("classor");
        Processors.setAppDatabaseVersion(1);
        allQuestionsinsert = new ArrayList<>();
        allquestionsremove = new ArrayList<>();
        allquestionsupdate = new ArrayList<>();
        stillprocessingquestions = new HashMap<>();
        mdb = AppDatabase.getsInstance(getApplicationContext());
        lmi= new Intent(Startup.this, MainActivity.class);
//        Beginna.aloadInBackground(ree, lee);
//        Beginna.eloadInBackground(ree,lee);
//        Beginna.loadInBackground(ree,lee);
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mFirebaseAuth = FirebaseAuth.getInstance();
        try {
            mFirebaseUser = mFirebaseAuth.getCurrentUser();
        }
        catch (Exception e){

        }

//        if (mFirebaseUser == null) {
//            // Not signed in, launch the Sign In activity
////            Timber.tag("MainActivity").i("onCreate(): User not signed in, launching SignInActivity");
////            startActivity(new Intent(this, SignInActivity.class));
////            finish();
//
//        } else {
//            Intent hj = new Intent(Startup.this, MainActivity.class);
//           processall.getInstance().setViewpage(0);
//            Thread thread = new Thread(null, doBackgroundThreadProcessinge, "Background");
//            thread.start();
//            Thread threade = new Thread(null, doBackgroundThreadProcessinga, "Background");
//            threade.start();
//            Thread threado = new Thread(null, doBackgroundThreadProcessingu, "Background");
//            threado.start();
//            startActivity(hj);
//            finish();
//
////            mUsername = mFirebaseUser.getDisplayName();
////            Timber.tag("MainActivity").i("onCreate(): User \"%s\" signed in.", mUsername);
////            if (mFirebaseUser.getPhotoUrl() != null) {
////                mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
//        }

//        ambar = getSupportActionBar();
//        ambar.hide();
//        mVisible = true;

        linlrogin = (LinearLayout)findViewById(R.id.linlrogin);
        linlrogin.setOnClickListener(descriptiveloListener);
        context = this;
        generaltimer = 0;
//        mControlsView = findViewById(R.id.fullscreen_content_controls);
//        mContentView = findViewById(R.id.fullscreen_content);
//        frat = (FrameLayout)findViewById(R.id.frat);
        ui = new Intent(Startup.this, MainActivity.class);
        reliall = (RelativeLayout) findViewById(R.id.reliall);
        ronin = new AlphaAnimation(0,1);
        ronin.setDuration(1000);
//        dff = new Intent(Polee.this,Introc.class);
//        brote = (LinearLayout)findViewById(R.id.brote);
        namel = (LinearLayout) findViewById(R.id.namey);
        emaill = (LinearLayout) findViewById(R.id.emailo);
        numberl = (LinearLayout) findViewById(R.id.numberlo);
        ednameb = (EditText) findViewById(R.id.ednamey);
        ednumberb = (EditText) findViewById(R.id.ednumber);
        edemailb = (EditText) findViewById(R.id.edemailo);
        edclassi = (EditText) findViewById(R.id.edclassi);
        classo = (LinearLayout) findViewById(R.id.classo);
        logrin = (TextView)findViewById(R.id.logrin);
        classcode = (TextView)findViewById(R.id.classcode);

//        mySharedPreference = getSharedPreferences(HomeFragment.DATA,MODE_PRIVATE);
//        myEditor = mySharedPreference.edit();
//        wespee = (TextView)findViewById(R.id.wespee);
        moveforever = new TranslateAnimation(0,800,0,0);
        moveforever.setDuration(7000);
        moveforever.setRepeatCount(999999999);
        chirob = new Dialog(this);
        chirob.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        chirob.setContentView(R.layout.passwording);
        confpassyb = (EditText) chirob.findViewById(R.id.confpassy);
        passyb = (EditText) chirob.findViewById(R.id.passy);
        mk = passyb.getInputType();
        visibility = (ImageView) chirob.findViewById(R.id.visibilityb);
        passyclickb = (ImageView) chirob.findViewById(R.id.passibclicker);
        passyclickb.setOnClickListener(passyclickbListener);
        mAuthb = FirebaseAuth.getInstance();
        hi = (TextView) findViewById(R.id.wespee);
//        edemailb = (EditText)findViewById(R.id.edemailb);
        finisgnb = (ImageView) findViewById(R.id.goin);
        visibility.setOnClickListener(visibilityClicker);

//        loed = (TextView)findViewById(R.id.loed);
//        loedb = (TextView)findViewById(R.id.loedb);
//        loedc = (TextView)findViewById(R.id.loedc);
        me = new Dialog(this);
        me.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        me.setContentView(R.layout.logins);
        unlockc = (ImageView) me.findViewById(R.id.unlockc);
        unnamec = (EditText) me.findViewById(R.id.unnamec);
        unpassec = (EditText) me.findViewById(R.id.unpassec);
        unlockc.setOnClickListener(unlockListener);
        relinowauthenting = (RelativeLayout)findViewById(R.id.relinowauthenti);
        loading =(ImageView)findViewById(R.id.loading);
//        descriptivelo = (TextView)findViewById(R.id.descriptivelo);
        descriptivelor = (TextView) me.findViewById(R.id.descriptivelor);
//        descriptivelo.setOnClickListener(descriptiveloListener);
        vorifyb = new Dialog(this);
        vorifyb.setCancelable(true);
        vorifyb.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        vorifyb.setContentView(R.layout.verifyb);
        ve = (ImageView) vorifyb.findViewById(R.id.ve);
        ve.setOnClickListener(vListener);
        vemailb = (EditText) vorifyb.findViewById(R.id.vemailb);
        gr = new TranslateAnimation(400, 0, 0, 0);
        gr.setDuration(1000);
        gre = new TranslateAnimation(400, 0, 0, 0);
        gre.setDuration(1000);
        gri = new TranslateAnimation(400, 0, 0, 0);
        gri.setDuration(1000);
        gru = new TranslateAnimation(400, 0, 0, 0);
        gru.setDuration(1000);
        grm = new TranslateAnimation(0, 0, 800, 0);
        grm.setDuration(1500);
        rety = new RotateAnimation(0, 360, 50, 50);
        rety.setDuration(1000);
        vff = new ScaleAnimation(0, 1, 0, 1);
        vff.setDuration(300);
//        logrin = (TextView)findViewById(R.id.logrin);

        mer = mrdatabase.getReference("Users");
        mret = mrdatabase.getReference("EconValue");

        translateb = new TranslateAnimation(0, 0, 0, -20);
        translatec = new TranslateAnimation(0, 0, 0, 20);
        translatea = new TranslateAnimation(0, 0, 0, 20);
        Rollout = new ScaleAnimation(0, 1, 0, 1);
        Rollin = new ScaleAnimation(1, 1, 1, 0);
        Rollin.setDuration(400);
        Rollout.setDuration(1600);
        Rollout.setRepeatCount(999999999);
        alphait = new AlphaAnimation(1,0);
        alphait.setDuration(2700);
        alphait.setRepeatCount(999999999);
        translatea.setDuration(100);
        translateb.setDuration(100);
        translatea.setStartOffset(200);
        translateb.setRepeatCount(500);
        translatea.setRepeatCount(500);
        translatec.setDuration(100);
        translateb.setStartOffset(300);
        translatec.setRepeatCount(500);
        translatec.setStartOffset(400);

//        logrin.startAnimation(alphait);
        CountDownTimer timer = new CountDownTimer(10, 300) {
            @Override
            public void onTick(long l) {

            }


            @Override
            public void onFinish() {

//                frat.setVisibility(View.GONE);
                hi.setVisibility(View.VISIBLE);
                namel.setVisibility(View.VISIBLE);
                namel.startAnimation(gr);
                emaill.setVisibility(View.VISIBLE);
                gre.setStartOffset(400);
                emaill.startAnimation(gre);
                numberl.setVisibility(View.VISIBLE);
                gru.setStartOffset(700);
                numberl.startAnimation(gru);
                classo.setVisibility(View.VISIBLE);
                gri.setStartOffset(1200);
                classo.startAnimation(gri);
                CountDownTimer timers = new CountDownTimer(1500, 200) {
                    @Override
                    public void onTick(long l) {

                    }


                    @Override
                    public void onFinish() {
                        finisgnb.setVisibility(View.VISIBLE);

                        finisgnb.startAnimation(vff);
                        finisgnb.startAnimation(rety);
                        loading.startAnimation(grm);
//                        brote.setVisibility(View.VISIBLE);
//                        brote.startAnimation(grm);
                        linlrogin.setVisibility(View.VISIBLE);
                        logrin.startAnimation(alphait);
                    }

                }.start();

//                startActivityForResult(dff,0);
//              displaye("swipe left");
            }

        }.start();
        finisgnb.setOnClickListener(finisgnbListener);
        // Set up the user interaction to manually show or hide the system UI.
//        mContentView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                toggle();
//            }
//        });


        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
//        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
    }

    View.OnClickListener unlockListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String ooi = unnamec.getText().toString();
            String ooim = unpassec.getText().toString();
            if (ooi.equals("") || unnamec.getText() == null) {
                displayo("please enter email");
                unnamec.setTextColor(Color.RED);
            } else {
                if (ooim.equals("") || unpassec.getText() == null) {
                    displayo("please enter password");
                    unpassec.setTextColor(Color.RED);
                } else {

                    unlock(unnamec.getText().toString(), unpassec.getText().toString());
                }
            }
        }
    };
// public void loadall(){
//     Thread thread = new Thread(null, doBackgroundThreadProcessinge, "Background");
//            thread.start();
//            Thread threade = new Thread(null, doBackgroundThreadProcessinga, "Background");
//            threade.start();
//            Thread threado = new Thread(null, doBackgroundThreadProcessingu, "Background");
//            threado.start();
// }
    public void unlock(final String a, final String b) {
        if (confirmconnection()) {
            unlockc.startAnimation(Rollout);
            descriptivelor.setText("Preparing to log you in...");
            try {
                mAuthb.signInWithEmailAndPassword(a, b).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            MainActivity.beginwatch=0;
//                            startService(myDataServiceIntent);;
                            alphait.cancel();
                            descriptivelor.setText("log in");
                            Rollout.cancel();
                            me.cancel();
                            unlockc.setVisibility(View.VISIBLE);
                            unlockc.setScaleX(1);
                            unlockc.setScaleY(1);
                            displayo("Welcome Dear");
                              startActivity(lmi);
                            overridePendingTransition(R.transition.slide_from_right, R.transition.slide_to_left);
                              finish();
//                            AppExecutor.getsInstance().diskIO().execute(
//                                    new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            loadmany();
//                                  runOnUiThread(
//                                          new Runnable() {
//                                              @Override
//                                              public void run() {
//                                                  broadcastIntent = new Intent("com.mycompany.myapp.thetframework.MyDataService");
//                                                  startActivity(lmi);
//                                                  sendBroadcast(broadcastIntent);
//                                                  finish();
//                                              }
//                                          }
//                                  );
//                                        }
//                                    }
//                            );

                        } else {
                            Rollout.cancel();
                            descriptivelor.setText("log in");
                            displayo("couldn,t sign in details could be faulty");
                            me.cancel();
                            me.show();
//                    unlockc.setScaleX(1);
//                    unlockc.setScaleY(1);
                        }
                    }
                });
            }
            catch (Exception e){

            }
        }
        else {
            displayo("please ensure that your mobile data is on");
        }
    }
//    private Runnable doBackgroundThreadProcessinge = new Runnable() {
//        public void run() {
//            Answered.InfoListsa = Beginna.loadInBackground(mysharedpreferences,myeditor,mrdatabase,lee);
//        }
//    };
//    private Runnable doBackgroundThreadProcessinga = new Runnable() {
//        public void run() {
//           All.InfoLists = Beginna.eloadInBackground(mrdatabase,lee);
//        }
//    };
//    private Runnable doBackgroundThreadProcessingu = new Runnable() {
//        public void run() {
//            Unanswered.InfoListsb = Beginna.aloadInBackground(mysharedpreferences,myeditor,mrdatabase,lee);
//        }
//    };
    View.OnClickListener descriptiveloListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            me.show();
        }
    };
    public boolean lookupclass(final String name){
        boolean result = false;
        classor.orderByValue().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                matinmatical = new Mathmatical(dataSnapshot);
//                result = matinmatical.checkifclassexists(name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return false;
    }

//    public void loadmany(){
//        lee.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                allQuestionsinsert = Showallquestions(dataSnapshot);
//                for(int i =0; i<allQuestionsinsert.size();i++){
//                    mdb.questionDao().insertQuestion(allQuestionsinsert.get(i));
//                }
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                allquestionsupdate = Showallquestions(dataSnapshot);
//                for (int i = 0; i < allquestionsupdate.size(); i++) {
//                    mdb.questionDao().updateQuestion(allquestionsupdate.get(i));
//                }
//            }
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//                allquestionsremove = Showallquestions(dataSnapshot);
//                for (int i = 0; i < allquestionsremove.size(); i++) {
//                    mdb.questionDao().deleteQuestion((allquestionsremove.get(i)));
//                }
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }
//
public List<question> Showallquestions(DataSnapshot dataSnapshot){
    List<question> stillworkingonquestions = new ArrayList<question>();
//        List<question> bean= new ArrayList<question>();
    stillprocessingquestions = (Map<String, question>) dataSnapshot.getValue();
//        key = dataSnapshot.getKey();
    for (Map.Entry<String, question> entery: stillprocessingquestions.entrySet()) {
//            users.add(upperCase(entery.getValue().getFistName()) + " " + upperCase(entery.getValue().getLastName()));
        stillworkingonquestions.add(entery.getValue());
    }
    if (!stillworkingonquestions.isEmpty()) {
        for (int i = 0; i < stillworkingonquestions.size(); i++) {
            Collections.sort(stillworkingonquestions, new Comparator<question>() {
                @Override
                public int compare(question t0, question t1) {
                    return (int) (t1.getTimestamp() - t0.getTimestamp());
                }

            });
        }
        return stillworkingonquestions;
    }

    return null;

}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

            hi.setVisibility(View.VISIBLE);
//            ally.setVisibility(View.VISIBLE);
//            ally.startAnimation(gr);
            CountDownTimer timers = new CountDownTimer(1500, 200) {
                @Override
                public void onTick(long l) {

                }
                @Override
                public void onFinish() {
                    finisgnb.setVisibility(View.VISIBLE);

                    finisgnb.startAnimation(vff);
                    finisgnb.startAnimation(rety);
//                    brote.setVisibility(View.VISIBLE);
//                    brote.startAnimation(grm);
//                    descriptivelo.setVisibility(View.VISIBLE);
//                    descriptivelo.startAnimation(alphait);
                }

            }.start();
        }
    }


    View.OnClickListener vListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            classcode.setVisibility(View.GONE);
            vorifyb.cancel();
            poemailb = vemailb.getText().toString();
            popasswordb = mpasswordb;
            verification(poemailb, popasswordb);
        }
    };
    View.OnClickListener visibilityClicker = new View.OnClickListener() {
        @Override

        public void onClick(View view) {
            if (j == 0) {
                passyb.setInputType(InputType.TYPE_CLASS_NUMBER);
                confpassyb.setInputType(InputType.TYPE_CLASS_NUMBER);
                j = 1;
            } else {
                if (j == 1) {
                    passyb.setInputType(mk);
                    confpassyb.setInputType(mk);
                    j = 0;
                }
            }
        }
    };

    public void verification(String a, String b) {

        poemailb = a;
        popasswordb = b;
        smname = ednameb.getText().toString();
        smemail = edemailb.getText().toString();
        mclassy = edclassi.getText().toString();
        smnumber = ednumberb.getText().toString();

        mquestion = 0;
        manswer = 0;
        int brosi = 0;
        loading.startAnimation(moveforever);
//        loed.startAnimation(translatea);
//        loedb.startAnimation(translateb);
//        loedc.startAnimation(translatec);
        if (confirmconnection()) {
            mAuthb.createUserWithEmailAndPassword(poemailb, popasswordb)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull final Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                MainActivity.beginwatch = 0;
                                displayoe("your account has been succesfully created");
                                moveforever.cancel();
//                                translatea.cancel();
//                                translateb.cancel();
//                                translatec.cancel();
                                generaltimer = 1;
                                if (TextUtils.isEmpty(userid)) {
                                    userid = mAuthb.getUid();
//                                displaye(userid);
                                 AppExecutor.getsInstance().networkIO().execute(new Runnable() {
                                     @Override
                                     public void run() {
                                         Classors classes = new Classors(mclassy,poemailb,false,false, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()),true);
                                         Classors classas = new Classors("ski_peoplen26",poemailb,true,false, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()),false);
                                         mdb.classorsDao().insertClassor(classes);
                                         mdb.classorsDao().insertClassor(classas);
                                     }
                                 });
                                     usernd = new User(userid,smname, popasswordb, poemailb, smnumber, mclassy, mquestion, manswer, 0, false, "", false, "","",false,"","","");

//                                    Transaction jt = new Transaction(0, 0, 0);
                                    mer.child(userid).setValue(usernd).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                myeditor =  mysharedpreferences.edit();
                                                myeditor.putBoolean("doneuploadinguserdetails",true);
                                                myeditor.putString("userclass",mclassy);
                                                myeditor.putString("useremail",poemailb);
                                                myeditor.apply();
                                                myDataServiceIntent = new Intent(Startup.this,MyDataService.class);
                                                startService(myDataServiceIntent);;
                                            }
                                            else {

                                            }
                                        }
                                    });
//                                    Classor dte = new Classor(mclassy, 0);
//                                    classor.push().setValue(dte)
//                                    mret.child(userid).setValue(jt);
////                                displaye("Account Creation you're logged in");
                                    ednumberb.setText(null);
                                    edemailb.setText(null);
                                    edclassi.setText(null);
                                    ednameb.setText(null);
//                                    authe.setVisibility(View.INVISIBLE);
                                    lmi.putExtra("theid", userid);
                                    startActivity(lmi);
                                    overridePendingTransition(R.transition.slide_from_right, R.transition.slide_to_left);
                                    finish();
//                                    Processors.setAppDatabaseVersion(1);
//                                    AppExecutor.getsInstance().diskIO().execute(
//                                            new Runnable() {
//                                                @Override
//                                                public void run() {
//                                                    loadmany();
//                                                    runOnUiThread(
//                                                            new Runnable() {
//                                                                @Override
//                                                                public void run() {
//                                                                    myeditor.putBoolean("allow",true);
//                                                                    broadcastIntent = new Intent("com.mycompany.myapp.thetframework.MyDataService");
//                                                                    startActivity(lmi);
//                                                                    sendBroadcast(broadcastIntent);
//                                                                    finish();
//                                                                }
//                                                            }
//                                                    );
//                                                }
//                                            }
//                                    );
                                }
                            } else {
                                generaltimer = 1;
                                try {
                                    if (task.getException() == (FirebaseAuthException) task.getException()) {

                                        g = (FirebaseAuthException) task.getException();
                                        if (g != null) {
                                            displayo(g.toString());
                                            moveforever.cancel();
//                                translatea.cancel();
//                                translateb.cancel();
//                                translatec.cancel();
                                            vemailb.setText(poemailb);
                                            vorifyb.show();
                                        }
                                    }
                                } catch (Exception e) {
                                    Exception ge = task.getException();
                                    if (ge != null) {
                                        displayo(ge.toString());
                                        moveforever.cancel();
//                                translatea.cancel();
//                                translateb.cancel();
//                                translatec.cancel();

                                    }
                                }


                            }
                        }

                    });

            if (generaltimer == 0) {
                CountDownTimer ret = new CountDownTimer(16000, 200) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        displayo("Bad Network, Please Check your Network Connection");
                        displayoe("were still trying our best to process your data");
//                        moveforever.cancel();
//                        loading.setVisibility(View.GONE);
//                        namel.setVisibility(View.VISIBLE);
//                        relinowauthenting.setVisibility(View.GONE);
//                        loading.setVisibility(View.GONE);
//                        classo.setVisibility(View.VISIBLE);
//                        emaill.setVisibility(View.VISIBLE);
//                        numberl.setVisibility(View.VISIBLE);
//                        finisgnb.setVisibility(View.VISIBLE);
//                        hi.setVisibility(View.VISIBLE);
//                        logrin.startAnimation(alphait);
//                        moveforever.cancel();
////            descriptivelo.setVisibility(View.VISIBLE);
//                        backer = 0;
//                        generaltimer = 0;
                    }
                }.start();
            }
        }
         else {
            displayo("please make sure your data is on");
        }
    }


    public boolean confirmconnection() {
        boolean trust = false;
        try {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
            trust = isConnected;
        } catch (Exception e)
        {
            displayo("there a network error, please try again");
        }
        return trust;
    }

    View.OnClickListener passyclickbListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (passyb.getText() == null || passyb.getText().toString().equals("")) {
                displayo("please enter password");
            } else {
                if (passyb.getText().toString().length() < 6) {
                    displayo("please password should be 6 or more Characters");
                    passyb.setTextColor(Color.RED);

                } else {
                    if (!passyb.getText().toString().equals(confpassyb.getText().toString())) {
                        displayo("First and second password do not match");
//                         displaye(String.valueOf(passyb.getText().toString().length()));
                    } else {
                        if(confirmconnection()) {
                            mpasswordb = passyb.getText().toString();
                            passyb.setText(null);
                            confpassyb.setText(null);
                            chirob.cancel();
                            alphait.cancel();
                            namel.setVisibility(View.INVISIBLE);
                            classo.setVisibility(View.INVISIBLE);
                            emaill.setVisibility(View.INVISIBLE);
                            numberl.setVisibility(View.INVISIBLE);
                            finisgnb.setVisibility(View.INVISIBLE);
                            hi.setVisibility(View.INVISIBLE);
                            linlrogin.setVisibility(View.GONE);
                            classcode.setVisibility(View.GONE);
                            relinowauthenting.setVisibility(View.VISIBLE);
                            backer = 1;
                            loading.setVisibility(View.VISIBLE);
//                            logrin.setVisibility(View.GONE);
                            try {
                                verification(memailb, mpasswordb);
                            }
                            catch (Exception e){
                              displayo("there is a veriification error, please try again");
                            }
                        }
                        else {
                            displayo("please ensure your mobile data is on");
                        }
                    }

                }
            }
        }

    };
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i ("isMyServiceRunning?", true+"");
                return true;
            }
        }
        Log.i ("isMyServiceRunning?", false+"");
        return false;
    }
    View.OnClickListener finisgnbListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            if (ednameb.getText() == null || ednameb.getText().toString().equals("")) {
                displayo("no name entered");
                ednameb.setSelected(true);
                ednameb.requestFocus();
                ednameb.setHintTextColor(Color.RED);
            } else {
                if (edemailb.getText() == null || edemailb.getText().toString().equals("")) {
                    displayo("no email address entered");
                    edemailb.setSelected(true);
                    edemailb.requestFocus();
                    ednameb.setHintTextColor(Color.RED);
                } else {
                    if (ednumberb.getText() == null || ednumberb.getText().toString().equals("")) {
                        displayo("no mobile number entered");
                        ednumberb.setSelected(true);
                        ednumberb.requestFocus();

                        ednumberb.setHintTextColor(Color.RED);
                    } else {

                        if (ednumberb.getText().toString().length() != 11) {
                            displayo("please your phonenumber might be faulty");
                            displayo("you put in " + String.valueOf(ednumberb.getText().toString().length() + " digits"));

                            ednumberb.setTextColor(Color.RED);
                        } else {
                            if (edclassi.getText() == null || edclassi.getText().toString().equals("")) {
                                displayo("please enter your class, make sure your class is the same as for other members");
                                displayo("if you enter any other value, you are invariably creating a new class");
                                displayoe("so find out if your class already exists on the framework");
                                edclassi.setSelected(true);
                                edclassi.requestFocus();

                                ednumberb.setHintTextColor(Color.RED);

                            } else {


                                mnameb = ednameb.getText().toString();
                                mclassy = edclassi.getText().toString();
                                mnumberb = ednumberb.getText().toString();
                                memailb = edemailb.getText().toString();
                                chirob.show();

                            }
                        }
                    }
                }
            }
        }

    };

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if (backer == 1) {
             moveforever.cancel();
            namel.setVisibility(View.VISIBLE);
            linlrogin.setVisibility(View.VISIBLE);
            relinowauthenting.setVisibility(View.GONE);
            loading.setVisibility(View.GONE);
            classo.setVisibility(View.VISIBLE);
            emaill.setVisibility(View.VISIBLE);
            numberl.setVisibility(View.VISIBLE);
            finisgnb.setVisibility(View.VISIBLE);
            hi.setVisibility(View.VISIBLE);
            classcode.setVisibility(View.VISIBLE);
            logrin.startAnimation(alphait);
//            descriptivelo.setVisibility(View.VISIBLE);
            backer = 0;
        } else {
//            if(backer==0){
//                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setMessage("sure to leave the framework?")
//                        .setCancelable(false)
//                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Polee.this.finish();
//                            }
//                        })
//                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                dialogInterface.cancel();
//                            }
//                        });
//                AlertDialog alert = builder.create();
//                alert.show();
//            }
        }
    }

    public void displayo(String ji) {
        Context context = getApplicationContext();
        String msg = ji;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, msg, duration);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        TextView myTextView = new TextView(context);
        ImageView cv = new ImageView(context);
        cv.setImageResource(R.drawable.glasy);
        myTextView.setText(msg);
        Resources g = getResources();
        myTextView.setTextColor(Color.parseColor("#0a2149"));
        myTextView.setBackgroundDrawable(g.getDrawable(android.R.drawable.editbox_background));
        int lHeight = LinearLayout.LayoutParams.WRAP_CONTENT;
        int lWidth = LinearLayout.LayoutParams.WRAP_CONTENT;
        ll.addView(cv, new LinearLayout.LayoutParams(lHeight, lWidth));
        ll.addView(myTextView, new LinearLayout.LayoutParams(lHeight, lWidth));
        ll.setPadding(40, 50, 0, 50);

        toast.setView(ll);
        toast.show();
    }

    public void displayoe(String ji) {
        Context context = getApplicationContext();
        String msg = ji;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, msg, duration);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        TextView myTextView = new TextView(context);
        ImageView cv = new ImageView(context);
        cv.setImageResource(R.drawable.pretty);
        Resources g = getResources();
        myTextView.setText(msg);
        myTextView.setTextColor(Color.parseColor("#0a2149"));
        myTextView.setBackgroundDrawable(g.getDrawable(android.R.drawable.editbox_background));
        int lHeight = LinearLayout.LayoutParams.WRAP_CONTENT;
        int lWidth = LinearLayout.LayoutParams.WRAP_CONTENT;
        ll.addView(cv, new LinearLayout.LayoutParams(lHeight, lWidth));
        ll.addView(myTextView, new LinearLayout.LayoutParams(lHeight, lWidth));
        ll.setPadding(40, 50, 0, 50);
        toast.setView(ll);
        toast.show();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
//        delayedHide(100);
    }

//    private void toggle() {
//        if (mVisible) {
//            hide();
//        } else {
//            show();
//        }
//    }
//
//    private void hide() {
//        // Hide UI first
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.show();
//        }
////        mControlsView.setVisibility(View.GONE);
//        mVisible = false;
//
//        // Schedule a runnable to remove the status and navigation bar after a delay
////        mHideHandler.removeCallbacks(mShowPart2Runnable);
//        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
//    }
//
//    @SuppressLint("InlinedApi")
//    private void show() {
//        // Show the system bar
//        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
//        mVisible = true;
//
//        // Schedule a runnable to display UI elements after a delay
//        mHideHandler.removeCallbacks(mHidePart2Runnable);
////        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
//    }
}