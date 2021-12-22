package com.mycompany.myapp.thetframework;

import android.Manifest;
import android.app.ActivityManager;
import android.app.Dialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ToxicBakery.viewpager.transforms.RotateDownTransformer;
import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static android.os.Environment.getExternalStoragePublicDirectory;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, TextToSpeech.OnInitListener, All.OnFragmentInteractionListener, Tips.OnFragmentInteractionListener, ClassorAdapter.OnRecycleViewItemClicker, All.ClassFollowerListener{
TabLayout tabss;
    MyFragmentAdapter madapter;
    TranslateAnimation downanimation, upanimation, downianimation;
    int classeswatcher, addclasseswatcher;
    AlphaAnimation alphyanimation;
    FirebaseAuth mAuth;
    Intent mytent;
    Processors processors;
    static int centrewatcher;
    Dialog permissionse;
    EditText leaveclass,blockclass;
   static String standinguserclass;
    FloatingActionButton button_classes;
    EditText classhintmain, settingsunblock;
    ImageView add_classes, sendclasses;
    RelativeLayout mainrelclasses;
    FirebaseJobDispatcher dispatcher;
    static  int proccedings =0;
    public static int TTS_DATA_CHECK = 149;
    public static  HashMap<String, String> map;
    public static boolean ttsIsInit = false;
    ClassorAdapter classorAdapter;
    List<Classors> classorsList = new ArrayList<>();
    static int beginwatch;
    public static TextToSpeech tts;
    AlphaAnimation alphait;
    TextView polescontact;
    TextView textviewname,errormessage;
    TextView textviewemail;
    CheckBox checkbox;
    MyService myService;
    ImageView goahead;
    Dialog settings;
    ViewPager mViewPager;
    ScaleAnimation Rollout, Rollin;
    ImageView newlogin;
    static SharedPreferences mysharedpreference;
    SharedPreferences.Editor myeditor;
    ImageView mImageView;
    TextView pooo;
    namepro naem;
    int permissionCamera;
    static final int REQUEST_TAKE_PHOTO = 1;
    DatabaseReference dfree;
    DatabaseReference questionreference;
    ImageView userface;
    int currentviewpage;
    AppDatabase mdb;
    RecyclerView classRecyclerview;
    Mathmatical mathmatical;
    DatabaseReference msee;
    DatabaseReference hree;
    DatabaseReference bree;
    Dialog me;
//    BottomNavigationView bottomNavigationView;
List<question> allQuestionsinsert, allquestionsupdate, allquestionsremove, testing;
    Dialog re, playservice, updateProfile, about;
    EditText unnamec, unpassec;
    TextView descriptivelor;
    ImageView unlockc;
    String mCurrentPhotoPath;
    private Map<String, question> stillprocessingquestions;
    Intent broadcastIntent;
    static List<question> der = new ArrayList<question>();
    static List<Answer> dre = new ArrayList<Answer>();
    static List<question> questions = new ArrayList<question>();
    static List<question> drw = new ArrayList<question>();
    static List<question> dee = new ArrayList<question>();
    static List<String> anstring = new ArrayList<>();
//    static List<question> questions = new ArrayList<question>();
//    static List<Answer> answers = new ArrayList<Answer>();
    FirebaseDatabase nsbase;
    DatabaseReference anref;
    android.support.v7.app.ActionBar actionBar;
    DatabaseReference allref;
    DatabaseReference classorn;
private Intent myDateServiceIntent, myServiceIntent;
private MyDataService myDataService;
//    static List<String> idquestion = new ArrayList<String>();
//    static List<String> idanswer = new ArrayList<String>();
//    static List<String> unspinnedquestion = new ArrayList<String>();
//    static List<String> unspinnedanswer = new ArrayList<String>();
//    static int nquestion, nanswer, nbusiness;


//    static String iid\
// ;
    private int[] tabIcons = {
            R.drawable.allye,
            R.drawable.soccer,
            R.drawable.unan,
        R.drawable.ic_jump
//            R.drawable.maile,
//            R.drawable.documents
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPlayService();
        mysharedpreference = getSharedPreferences("readstate",MODE_PRIVATE);
        myeditor = mysharedpreference.edit();
        if(!mysharedpreference.getBoolean("timestamped",false)){
            myeditor.putString("stamped","0");
            myeditor.putLong("stampy",0);
            myeditor.putBoolean("timestamped",true);
            myeditor.apply();
        }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        myDataService = new MyDataService();
        myDateServiceIntent = new Intent(getApplicationContext(),MyDataService.class);
        myService = new MyService();
        myServiceIntent = new Intent(getApplicationContext(),MyService.class);
        processors = Processors.getInstance();
        if(this.getIntent().getStringExtra("newclassname")!=null&&!this.getIntent().getStringExtra("newclassname").equals("")){
            try {
                reinstate(this.getIntent().getStringExtra("newclassname"));
            }
            catch (Exception e){

            }
        }
        try{
            if (!isMyServiceRunning(myDataService.getClass())) {
                    startService(myDateServiceIntent);
                }
        }
        catch (Exception e){

        }

        permissionCamera   = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        Intent yu = this.getIntent();
        Bundle m  = yu.getExtras();
        try {
            int viewpage = m.getInt("currentviewpage", 0);

        if(processall.getInstance().getViewpage()==0){
            processall.getInstance().setViewpage(viewpage);
        }
        }
        catch (Exception e){

        }
        processall.getInstance().setYu(yu);
        mAuth = FirebaseAuth.getInstance();
        nsbase = FirebaseDatabase.getInstance();
        dfree = nsbase.getReference("Users");
        mAuth.addAuthStateListener(authStateListener);
        questionreference = nsbase.getReference("question");
        questionreference.limitToFirst(50);
        anref = nsbase.getReference("Answers");
        classorn = nsbase.getReference("classor");
//        questionreference.keepSynced(true);
//        anref.keepSynced(true);

        currentviewpage = processall.getInstance().getViewpage();
        madapter = new MyFragmentAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(madapter);
        centrewatcher = 0;
        map = new HashMap<String, String>();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        tabss = (TabLayout) findViewById(R.id.tabss);
        tabss.setupWithViewPager(mViewPager);
//        tabss.setVisibility(View.GONE);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        allQuestionsinsert = new ArrayList<>();
        allquestionsremove = new ArrayList<>();
        allquestionsupdate = new ArrayList<>();
        testing = new ArrayList<>();
        mdb = AppDatabase.getsInstance(getApplicationContext());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        classRecyclerview  = (RecyclerView)findViewById(R.id.classes_recyclerview);
        textviewname = (TextView)header.findViewById(R.id.textviewname);
        textviewemail = (TextView)header.findViewById(R.id.textViewmail);
        userface = (ImageView) header.findViewById(R.id.userface);
        newlogin = (ImageView)header.findViewById(R.id.newlogin);

        classorAdapter = new ClassorAdapter(classorsList,this);
        mainrelclasses = (RelativeLayout)findViewById(R.id.mainrelclasses);
        button_classes = (FloatingActionButton)findViewById(R.id.button_classes);
        add_classes = (ImageView)findViewById(R.id.addclasses);
        classhintmain = (EditText)findViewById(R.id.classhintmain);
        sendclasses = (ImageView)findViewById(R.id.sendclassese);
        button_classes.setOnClickListener(buttonclassesListener);
        add_classes.setOnClickListener(addclassesListner);
        RecyclerView.LayoutManager mlayoutManager = new GridLayoutManager(this,1,LinearLayoutManager.HORIZONTAL,false);
//        InfoLists = ResolveList.getInstance().getAllquestions();
        classorAdapter.setOnItemclickedListener(this);
        classRecyclerview.setLayoutManager(mlayoutManager);
        classRecyclerview.setItemAnimator(new DefaultItemAnimator());
        classRecyclerview.setAdapter(classorAdapter);
        if(processall.getInstance().getUseremail()!=null) {
            textviewemail.setText(processall.getInstance().getUseremail());
        }

        if(processall.getInstance().getUsername()!=null) {
            textviewname.setText(processall.getInstance().getUsername());
        }
       else {

            if (namepro.getNusername() != null) {
                textviewname.setText(namepro.getNusername());
//            myeditor = mysharedpreference.edit();
//            myeditor.putString("username",namepro.getNusername());
//            myeditor.apply();
            }
            if (namepro.getNemail() != null) {
//            myeditor = mysharedpreference.edit();
                textviewemail.setText(namepro.getNemail());
//            myeditor.putString("useremail",namepro.getNemail());
//            myeditor.apply();
            }
            if (namepro.getDateOfBirth() == null) {
//            Processors.setAppDatabaseVersion(1);
//          loadmany();
            }
            if (namepro.getNclassy() != null) {
//            myeditor = mysharedpreference.edit();
//            myeditor.putString("userclass",namepro.getNclassy());
//            myeditor.apply();
            }
            else {
                textviewemail.setText(mysharedpreference.getString("useremail",""));
                textviewname.setText(mysharedpreference.getString("username",""));

            }

        }
//        displayo(mysharedpreference.getString("userclass",""));
//        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_nav);
        sendclasses.setOnClickListener(sendclassesListener);
        newlogin.setOnClickListener(OnNewloginClicked);
        tabss.setSelectedTabIndicatorColor(Color.parseColor("#eee6a4"));
        tabss.setTabGravity(TabLayout.GRAVITY_CENTER);
        myeditor.putBoolean("inmain",true);
        me = new Dialog(this);
        me.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        me.setContentView(R.layout.logins);
        playservice = new Dialog(this);
        playservice.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        playservice.setContentView(R.layout.playservice);
        playservice.setOnDismissListener(ondialogclosed);
        errormessage = (TextView)playservice.findViewById(R.id.errormessage);
        re = new Dialog(this);
        re.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        re.setContentView(R.layout.realexplore);
        polescontact = (TextView)re.findViewById(R.id.polescontact);
        Linkify.addLinks(polescontact,Linkify.PHONE_NUMBERS);
        polescontact.setLinkTextColor(Color.parseColor("#ff1100"));
        about = new Dialog(this);
        about.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        about.setContentView(R.layout.aboutit);
        settings = new Dialog(this);
        settings.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        settings.setContentView(R.layout.settings);
        permissionse = new Dialog(this);
        permissionse.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        permissionse.setContentView(R.layout.granting_permission);
        checkbox = (CheckBox)settings.findViewById(R.id.checkysound);
        checkbox.setChecked(mysharedpreference.getBoolean("soundstate",true));
        goahead = (ImageView)settings.findViewById(R.id.soundgoahead);
        blockclass = (EditText)settings.findViewById(R.id.settingsblock);
        leaveclass = (EditText)settings.findViewById(R.id.settingsremove);
        settingsunblock = (EditText)settings.findViewById(R.id.settingsunblock);
                checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    myeditor.putBoolean("soundstate",true);
                    myeditor.apply();
                }
                else {
                    myeditor.putBoolean("soundstate",false);
                    myeditor.apply();
                }
            }
        });
        myeditor.putBoolean("dead",false);
        myeditor.apply();
        goahead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(blockclass.getText()!=null&&blockclass.getText().toString().length()>1){
                    AppExecutor.getsInstance().networkIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Classors classors = mdb.classorsDao().LoadOrdinaryBycoolId(blockclass.getText().toString());
                                classors.setBlocked(true);
                                mdb.classorsDao().updateClassor(classors);
                            }
                            catch (Exception e){
                                final Classors classors = new Classors(blockclass.getText().toString(),mysharedpreference.getString("useremail",""), false, true, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()),true);
                                        try{
                                            mdb.classorsDao().insertClassor(classors);
                                        }
                                        catch (Exception en){
                                            mdb.classorsDao().updateClassor(classors);
                                        }
                            }
                        }
                    });
                }

                if(leaveclass.getText()!=null&&leaveclass.getText().toString().length()>1){
                    if(leaveclass.getText().toString() == mysharedpreference.getString("userclass","")){
                        myeditor.putString("userclass","ski_peoplen26");
                        myeditor.apply();
                        try {
                            reinstate("ski_peoplen26");
                        }
                        catch (Exception e){

                        }
                    }
                    AppExecutor.getsInstance().networkIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                mdb.classorsDao().deleteClassorByClassname(leaveclass.getText().toString());
                            }
                            catch (Exception e){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        displayo("i encountered an error while trying to exclude you from a class");
                                    }
                                });
                            }
                        }
                    });
                }
                if(settingsunblock.getText()!=null&&settingsunblock.getText().toString().length()>1){
                    AppExecutor.getsInstance().networkIO().execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Classors classors = mdb.classorsDao().LoadOrdinaryBycoolId(settingsunblock.getText().toString());
                                classors.setBlocked(false);
                                mdb.classorsDao().updateClassor(classors);
                            }
                            catch (Exception e){
                                final Classors classors = new Classors(settingsunblock.getText().toString(),mysharedpreference.getString("useremail",""), false, false, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()),true);
                                try{
                                    mdb.classorsDao().insertClassor(classors);
                                }
                                catch (Exception en){
                                    mdb.classorsDao().updateClassor(classors);
                                }
                            }
                        }
                    });
                }
                settings.cancel();

            }
        });
        pooo = (TextView)re.findViewById(R.id.pooo);
        pooo.setSelected(true);
        unlockc = (ImageView) me.findViewById(R.id.unlockc);
        unnamec = (EditText) me.findViewById(R.id.unnamec);
        unpassec = (EditText) me.findViewById(R.id.unpassec);
        descriptivelor = (TextView) me.findViewById(R.id.descriptivelor);
        unlockc.setOnClickListener(unlockListener);
        myeditor.putBoolean("ininner",false);
        Rollout = new ScaleAnimation(0, 1, 0, 1);
        Rollin = new ScaleAnimation(1, 1, 1, 0);
        Rollin.setDuration(400);
        Rollout.setDuration(1600);
        Rollout.setRepeatCount(999999999);
        Rollin.setRepeatCount(999999999);
        alphait = new AlphaAnimation(1,0);
        alphait.setDuration(2700);
        alphait.setRepeatCount(999999999);
        classorAdapter.notifyDataSetChanged();
//        Thread threado = new Thread(null, doBackgroundThreadProcessingey, "Background");
//        threado.start();
   downanimation = new TranslateAnimation(0,0,0,600);
        downanimation.setDuration(1500);
        downianimation = new TranslateAnimation(0,0,0,600);
        downianimation.setDuration(1000);
        upanimation = new TranslateAnimation(0,0,500,0);
        upanimation.setDuration(1000);
//        alphyanimation = new AlphaAnimation(1,0);
//        alphyanimation.setDuration(1200);
        tabss.setTabTextColors(Color.parseColor("#566f7b"), Color.parseColor("#eee6a4"));
        setupTabIcons();

//        Thread threadi = new Thread(null, doBackgroundThreadProcessingey, "Background");
//        threadi.start();
//
//        if(mysharedpreference.getBoolean("firsttime",true)){
//            displayoe("swipe up to start asking questions");
//        }
         dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));
        if(beginwatch !=0) {
//            anref.orderByChild("timestamp").addValueEventListener(answerstateListener);
//            questionreference.orderByChild("timestamp").addValueEventListener(questionStateChecker);
        }
        else{
            beginwatch =1;
        }
//        Thread thread = new Thread(null, doBackgroundThreadProcessinge, "Background");
//            thread.start();
//            Thread threade = new Thread(null, doBackgroundThreadProcessinga, "Background");
//            threade.start();
//            Thread threado = new Thread(null, doBackgroundThreadProcessingu, "Background");
//            threado.start();
//        textviewemail.setText(namepro.getNemail());
//        textviewname.setText(namepro.getNusername());
        setUpInfo();
            scheduleJob();


        try {
            mViewPager.setPageTransformer(true, new RotateDownTransformer());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mViewPager.setCurrentItem(currentviewpage);
        myeditor.apply();
//        displayo(String.valueOf(Processors.getInstance().getFolders().size()));
    }


//    public void loadmany(){
//        questionreference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull final DataSnapshot dataSnapshot, @Nullable String s) {
//                AppExecutor.getsInstance().diskIO().execute(
//                        new Runnable() {
//                            @Override
//                            public void run() {
//                                mdb.questionDao().insertQuestion(Showallquestions(dataSnapshot));
//
//                            }
//                        }
//                );
//
//            }
//
//            @Override
//            public void onChildChanged(@NonNull final DataSnapshot dataSnapshot, @Nullable String s) {
//
//                AppExecutor.getsInstance().diskIO().execute(
//                        new Runnable() {
//                            @Override
//                            public void run() {
//                                mdb.questionDao().updateQuestion(Showallquestions(dataSnapshot));
//
//                            }
//                        }
//                );
//            }
//            @Override
//            public void onChildRemoved(@NonNull final DataSnapshot dataSnapshot) {
//                AppExecutor.getsInstance().diskIO().execute(
//                        new Runnable() {
//                            @Override
//                            public void run() {
//                                mdb.questionDao().deleteQuestion(Showallquestions(dataSnapshot));
//
//                            }
//                        }
//                );
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
private void chooseImage() {
    Intent intent = new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(Intent.createChooser(intent, "Select image file"),2);
}

    private void chooseImagee() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select image file"),3);
    }
    public question Showallquestions(DataSnapshot dataSnapshot){
        question squestions = dataSnapshot.getValue(question.class);
        return squestions;

    }

    @Override
    public void followClass() {
        if (classeswatcher == 1) {
            mainrelclasses.startAnimation(downianimation);
            CountDownTimer ty = new CountDownTimer(500, 500) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    mainrelclasses.setVisibility(View.GONE);
                    button_classes.setImageResource(R.drawable.studeny);
                    classeswatcher = 0;
                }
            }.start();
        }
    }

    View.OnClickListener buttonclassesListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (classeswatcher == 0) {
                if (All.watcher == 1 || Tips.watcher == 1) {
                    onBackPressed();
                }
                mainrelclasses.setVisibility(View.VISIBLE);
                mainrelclasses.startAnimation(upanimation);
                button_classes.setImageResource(R.drawable.ic_downian);
                classeswatcher = 1;
            } else {
                if (classeswatcher == 1) {
                    mainrelclasses.startAnimation(downianimation);
                    CountDownTimer ty = new CountDownTimer(500, 500) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            mainrelclasses.setVisibility(View.GONE);
                            button_classes.setImageResource(R.drawable.studeny);
                            classeswatcher = 0;
                        }
                    }.start();
                }
            }
        }
    };
View.OnClickListener sendclassesListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        completeclassupdate(classhintmain.getText().toString(),mysharedpreference.getString("useremail",""),false);
    }
};

    View.OnClickListener addclassesListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (addclasseswatcher == 0) {
                classhintmain.setVisibility(View.VISIBLE);
                sendclasses.setVisibility(View.VISIBLE);
                SlideAnimationUtil.slideInFromRight(getApplicationContext(), classhintmain);
                add_classes.setImageResource(R.drawable.ic_downian);
                addclasseswatcher = 1;
            }
            else {
                if(addclasseswatcher ==1){
                    SlideAnimationUtil.sslideOutToLeft(getApplicationContext(),classhintmain);
                    CountDownTimer ty = new CountDownTimer(500, 500) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            classhintmain.setVisibility(View.GONE);
                            sendclasses.setVisibility(View.GONE);
                            add_classes.setImageResource(R.drawable.adde);
                            addclasseswatcher = 0;
                        }
                    }.start();
                }
            }
        }

    };

     @Override
    public void OnRecycleViewItemclicked( final  int position) {
         Classors classors = classorAdapter.getInfoLists().get(position);
         String useremail = classors.getUseremail();
         String classname = classors.getClassname();
//         String previousname = mysharedpreference.getString("userclass","");
         boolean blocked = classors.isBlocked();
         completeclassupdate(classname, useremail,blocked);
     }
    public void switchclasses(String classname, String useremail, boolean blocked) {
         myeditor.putString("userclass",classname);
         myeditor.apply();
        final Classors classors = new Classors(classname, useremail, false, blocked, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), true);
        AppExecutor.getsInstance().networkIO().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    mdb.classorsDao().insertClassor(classors);
                } catch (Exception e) {
                    mdb.classorsDao().updateClassor(classors);
                }
            }

        });
    }
    public void completeclassupdate(final String classname, final String useremail, boolean blocked){
        if(confirmconnection()){
            try{
                switchclasses(classname,useremail, blocked);
                MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
                mViewPager.setAdapter(myFragmentAdapter);
                setupTabIcons();
                dataservicework();

//                    boolean hasimage = mysharedpreference.getBoolean("hasimage",false);
                    String userid = mysharedpreference.getString("userid","");
//                    String password = mysharedpreference.getString("password","");
//                    String email = mysharedpreference.getString("useremail","");
//                    String dob =mysharedpreference.getString("dateOfBirth","");
//                    String skill = mysharedpreference.getString("skill","");
//                    String number = mysharedpreference.getString("usernumber","");
//                    String name = mysharedpreference.getString("username","");
//                    int manswere = mysharedpreference.getInt("answering",0);
//                    int mquestione = mysharedpreference.getInt("questioning",0);
//                    String downloaduri = mysharedpreference.getString("downloaduri","");
//                    String thumblineuri = mysharedpreference.getString("thumblineuri","");
//                    User user = new User(userid,name,password,email,number,classname,mquestione,manswere,0,false,dob,false,"",skill,hasimage,"",thumblineuri,downloaduri);
                        dfree.child(userid).child("classe").setValue(classname).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
//                                switchclasses(classname, useremail);
//                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                                startActivity(intent);
//                                finish();
                                }
                                else {
                                    displayo("sorry i encountered an error try to refresh your details on our server");
                                    displayoe("please try again");
                                }
                            }
                        });


            }
            catch (final Exception e){
                myeditor.putString("userclass",standinguserclass);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayoe("error switching class");
                        displayo(e.toString());
                    }
                });

            }




        }
        else {
            try{
                switchclasses(classname,useremail,blocked);
                MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
                mViewPager.setAdapter(myFragmentAdapter);
                setupTabIcons();
                displayoe("please ensure you are connected to the internet, your stay in this class in only temporary");
            }
            catch (final Exception e){
                myeditor.putString("userclass",standinguserclass);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        displayo(e.toString());
                        displayoe("error switching class");
                    }
                });

            }

        }
    }


        public void dataservicework(){
         AppExecutor.getsInstance().networkIO().execute(new Runnable() {
             @Override
             public void run() {
                 if(isMyServiceRunning(myDataService.getClass())){
                     stopService(myDateServiceIntent);
                 }
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         CountDownTimer r = new CountDownTimer(500,500) {
                             @Override
                             public void onTick(long millisUntilFinished) {

                             }

                             @Override
                             public void onFinish() {
                                 startService(myDateServiceIntent);
                             }
                         }.start();
                     }
                 });
                     }
                 });


    }
    public void reinstate(final String classname){
         AppExecutor.getsInstance().networkIO().execute(new Runnable() {
             @Override
             public void run() {
                 Classors classor = mdb.classorsDao().LoadOrdinaryBycoolId(classname);
                 if (classor != null) {
                     final String useremail = classor.getUseremail();
                     final String classname = classor.getClassname();
                     final boolean blocked = classor.isBlocked();
                     runOnUiThread(new Runnable() {
                         @Override
                         public void run() {
                             completeclassupdate(classname, useremail, blocked);
                         }
                     });

                 }
             }
         });
    }

    public void setUpInfo(){
        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
//        LiveData<List<Info>> infos = mDataBase.infoDao().LoadAllInfo();
        viewModel.getClassors().observe(this, new Observer<List<Classors>>() {
                    @Override
                    public void onChanged(@Nullable List<Classors> classors) {
//                Processors.getInstance().setInfod(infos);
                        List<Classors> anclassses = new ArrayList<Classors>();
                        anclassses.clear();
                        for (int i = 0; i < classors.size(); i++) {
//                            if (questions.get(i).getMclass().equals(name)) {
//                    if (questions.get(i).isAnswered()) {
//                                    questions.get(i).setRead(Spreferences.ReadState(mysharedpreference, questions.get(i).getQueid(), myeditor, questions.get(i).getNoanswer(), questions.get(i).getNocomment()));
                            if(classors.get(i).isRecent()){
                                classors.get(i).setRecent(false);
                            }
                            if(classors.get(i).getClassname().equals(mysharedpreference.getString("userclass",""))) {
                                classors.get(i).setTimestamp(  TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
                                classors.get(i).setRecent(true);
                                classors.get(i).setUnread(false);
                            }
                            anclassses.add(classors.get(i));
                            Collections.sort(anclassses, new Comparator<Classors>() {
                                @Override
                                public int compare(Classors t0, Classors t1) {
                                    return (int)(t1.getTimestamp()-t0.getTimestamp());
                                }
                            });


                        }                                   classorAdapter.setInfoLists(anclassses);
                        classorsList = classorAdapter.getInfoLists();
//                    Information.InfoListsand = Processors.getInstance().getInfod();
//                    Information.infoAdapterand.notifyDataSetChanged();
                    }
                }
        );
    }
    private void setupTabIcons() {
        tabss.getTabAt(0).setIcon(tabIcons[0]);
        tabss.getTabAt(1).setIcon(tabIcons[1]);
        tabss.getTabAt(2).setIcon(tabIcons[2]);
//        tabss.getTabAt(3).setIcon(tabIcons[3]);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    DialogInterface.OnDismissListener ondialogclosed = new DialogInterface.OnDismissListener() {
        @Override
        public void onDismiss(DialogInterface dialogInterface) {
    checkPlayService();
        }
    };
    View.OnClickListener OnNewloginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            me.show();
        }
    };
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
                    unlockc.startAnimation(Rollout);
                    descriptivelor.setText("Preparing to log you in...");
                    unlock(unnamec.getText().toString(), unpassec.getText().toString());
                }
            }
        }
    };
    private void checkPlayService() {
        int isGPSAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
//        Toast.makeText(this, "isGPSAvailable " + isGPSAvailable, Toast.LENGTH_SHORT).show();
        switch (isGPSAvailable) {
            case ConnectionResult.API_UNAVAILABLE:
                //API is not available
                errormessage.setText("sorry friend , API is not available, try to fix this issue ");
                playservice.show();
                break;
            case ConnectionResult.NETWORK_ERROR:
                //Network error while connection
                errormessage.setText(" a network error just occurred, please try again");
                playservice.show();
                break;
            case ConnectionResult.RESTRICTED_PROFILE:
                //Profile is restricted by google so can not be used for play services
//                errormessage.setText("something went wrong");
                errormessage.setText("Profile is restricted by google so can not be used for play services");
                playservice.show();
                break;
            case ConnectionResult.SERVICE_MISSING:
                //service is missing
               errormessage.setText("play service is missing, please try to fix this");
                playservice.show();
                break;
            case ConnectionResult.SIGN_IN_REQUIRED:
                //service available but user not signed in
                errormessage.setText("sorry, play service is available but you are not signed in..try to fix this");
                playservice.show();
                break;
            case ConnectionResult.SERVICE_INVALID:

                errormessage.setText("The version of the Google Play services installed on this device is not authentic");
                playservice.show();
                break;
            case ConnectionResult.SUCCESS:
                break;
        }
    }
    public void unlock(String a, String b) {
        if (confirmconnection()) {
            mAuth.signInWithEmailAndPassword(a, b).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        alphait.cancel();
                        descriptivelor.setText("log in");
                        Rollout.cancel();
                        me.cancel();
                        unlockc.setVisibility(View.VISIBLE);
                        unlockc.setScaleX(1);
                        unlockc.setScaleY(1);
                        displayo("Welcome Dear");
                        Intent lmi = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(lmi);
                        finish();

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
        } else {
            displayo("please ensure that your mobile data is on");
        }
    }
    public boolean confirmconnection() {
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

            FirebaseUser gt = mAuth.getCurrentUser();
            final String tyid = gt.getUid();
            dfree.child(tyid).orderByValue().addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    naem = new namepro(dataSnapshot);
                    myeditor = mysharedpreference.edit();
                    myeditor.putString("username",namepro.getNusername());
                    myeditor.putString("useremail",namepro.getNemail());
                    myeditor.putString("userclass",namepro.getNclassy());
                    myeditor.putString("usernumber",namepro.getNmobile());
                    myeditor.putString("userid",namepro.getUserid());
                    myeditor.putString("skill",namepro.getSkill());
                    myeditor.putString("dateOfBirth",namepro.getDateOfBirth());
                    myeditor.putString("usernumber",namepro.getNmobile());
                    myeditor.putBoolean("hasimage",namepro.isHasimage());
                    myeditor.putString("password",namepro.getNpassword());
                    myeditor.putInt("questioning",namepro.getNquestion());
                    myeditor.putInt("answering",namepro.getNanswer());
                    myeditor.putString("downloaduri",namepro.getDownloaduri());
                    myeditor.putString("thumblineuri",namepro.getThumblineuri());
                    myeditor.apply();
                    try{
//                        reinstate(namepro.getNclassy());
                    }
                    catch (Exception e){
                        displayo("error switvhing class");
                    }
                    processall.getInstance().setUsername(namepro.getNusername());
                    processall.getInstance().setUseremail(namepro.getNemail());
                    processall.getInstance().setUserclass(namepro.getNclassy());
                    processall.getInstance().setUsernumber(namepro.getNmobile());
                    standinguserclass = namepro.getNclassy();

                    if(processall.getInstance().getUseremail()!=null) {
                        textviewemail.setText(processall.getInstance().getUseremail());
                    }
                    if(namepro.getUserid()==null){
                        myeditor.putString("userid",tyid);
                    }

                    if(processall.getInstance().getUsername()!=null) {
                        textviewname.setText(processall.getInstance().getUsername());
                    }
                    if(mysharedpreference.getBoolean("firsttime",true)&&mysharedpreference.getBoolean("soundstate",true)) {
                    AppExecutor.getsInstance().diskIO().execute(new Runnable() {
                        @Override
                        public void run() {

                                initTextToSpeech();


                        }
                    });

                }
                try {
                    if(mysharedpreference.getBoolean("firsttime",false)&&!confirmconnection()) {
                        reinstate(namepro.getNclassy());
                    }
                }
                catch (Exception e){

                }
                    myeditor.putBoolean("firsttime",false);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    displayo("Something is wrong, I couldn\'t read Your detaails");
                }
            });
        }
    };
            ValueEventListener questionStateChecker = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                  mathmatical = new Mathmatical(dataSnapshot);

//                    Thread thread = new Thread(null,
//                            mathmatical, "Background");
//                    thread.start();
                    Thread threade = new Thread(null, doBackgroundThreadProcessingupdatethrough, "Background");
                    threade.start();
//                    Thread threado = new Thread(null, doBackgroundThreadProcessingu, "Background");
//                    threado.start();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
           ValueEventListener answerstateListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
//                    Thread threado = new Thread(null, doBackgroundThreadProcessingeng, "Background");
//                    threado.start();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            };
//            classorn.orderByKey().addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//
////                 questions = new ArrayList<question>(objectHashMap.values());
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });
//            nfree.orderByKey().addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    GenericTypeIndicator<HashMap<String, question>> objectsGTypeInd = new GenericTypeIndicator<HashMap<String, question>>() {
//                    };
//                    Map<String, question> objectHashMap = dataSnapshot.getValue(objectsGTypeInd);
////                List<question> dear;
//                    questions = new ArrayList<question>(objectHashMap.values());
//                    anstring = new ArrayList<String>(objectHashMap.keySet());
//                    List<question> anquestions = new ArrayList<question>();
//                    List<question> andquestions = new ArrayList<question>();
//                    List<question> ancquestions = new ArrayList<question>();
//                    displayo(String.valueOf(questions.size()));
//                    displayo(String.valueOf(questions.size()));
//                    displayo(String.valueOf(questions.size()));
//                    if (!questions.isEmpty()) {
//                        for (int i = 0; i < questions.size(); i++) {
//                            if (!questions.get(i).isAnswered()) {
//                                questions.get(i).setQueid(anstring.get(i));
//                                anquestions.add(questions.get(i));
//
//                            }
//                            if (questions.get(i).isAnswered()) {
//                                questions.get(i).setQueid(anstring.get(i));
//                                andquestions.add(questions.get(i));
//                            }
//                            questions.get(i).setQueid(anstring.get(i));
//                            ancquestions.add(questions.get(i));
//                        }
//                        drw = anquestions;
//                        dee = andquestions;
//                        der = ancquestions;
//                    }
//                }
//
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });
//        }



//    private Runnable doBackgroundThreadProcessingey = new Runnable() {
//        public void run() {
//            Beginna.resolve(nsbase,classorn);
//        }
//    };
//    private Runnable doBackgroundThreadProcessingeng = new Runnable() {
//        public void run() {
//            Beginna.enloadInBackground(nsbase,anref);
//
//        }
//    };

    private void dispatchTakePictureIntento() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
   displayo("couldnt find file");
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        }
    }
    private Runnable doBackgroundThreadProcessingupdatethrough = new Runnable() {
        public void run() {
            ResolveList.getInstance().setAllquestions(mathmatical.Showallquestions(mysharedpreference,myeditor,namepro.getNclassy()));
         ResolveList.getInstance().setAnsweredquestions(mathmatical.showAnsweredquestions(mysharedpreference,myeditor,namepro.getNclassy()));
            ResolveList.getInstance().setUnansweredquestions(mathmatical.showUnasweredQuestions(mysharedpreference,myeditor,namepro.getNclassy()));
//            Answered.InfoListsa =ResolveList.getInstance().getAnsweredquestions();
            Unanswered.InfoListsb = ResolveList.getInstance().getUnansweredquestions();
//            All.InfoLists = ResolveList.getInstance().getAllquestions();
                    mViewPager.post(new Runnable() {
                @Override
                public void run() {
//                    Answered.infoAdaptera.notifyDataSetChanged();
//                    Unanswered.infoAdapterb.notifyDataSetChanged();
//                    All.infoAdapter.notifyDataSetChanged();
//                    startActivity(new Intent(MainActivity.this,MainActivity.class));
//                    finish();
                }
            });
        }
    };
//    private Runnable doBackgroundThreadProcessingu = new Runnable() {
//        public void run() {
//            Unanswered.InfoListsb = Beginna.aloadInBackground(nsbase,nfree);
//        }
//    };
//    @Override
//    public void reaidee() {
//
//    }
//
//    @Override
//    public void reaudee() {
//
//    }
//
//    @Override
//    public void reapdee() {
//
//    }
    //    @Override
//    public void reaidee() {
////        mytent = getIntent();
//      startActivityForResult(Unanswered.urix, 3);
//    }
//
//    @Override
//    public void reaudee() {
//        startActivityForResult(Unanswered.urix, 2);
//    }
//
//    @Override
//    public void reapdee() {
//        startActivityForResult(All.urix,1);
//    }

    private Runnable doBackgroundThreadProcessinge = new Runnable() {
        public void run() {
//            Answered.InfoListsa = Beginna.loadInBackground(mysharedpreference,myeditor,nsbase,nfree);

        }
    };
//    private Runnable doBackgroundThreadProcessinga = new Runnable() {
//        public void run() {
//            All.InfoLists = Beginna.eloadInBackground(nsbase,nfree);
//        }
//    };
//    private Runnable doBackgroundThreadProcessingu = new Runnable() {
//        public void run() {
//            Unanswered.InfoListsb = Beginna.aloadInBackground(mysharedpreference,myeditor,nsbase,que);
//        }
//    };

    @Override
    public void onFragmentInteraction() {
        chooseImage();
    }
    @Override
    public void onFragmentInteractione() {
        chooseImagee();
    }
    public void displayo(String ji) {
        Context context = this;
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
        Context context = this;
        String msg = ji;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, msg, duration);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        LinearLayout ll = new LinearLayout(context);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        TextView myTextView = new TextView(context);
        ImageView cv = new ImageView(context);
        Resources g = getResources();
        cv.setImageResource(R.drawable.pretty);
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

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(requestCode==3||requestCode == 2||requestCode==1){
//            mytent = getIntent();
//            startActivity(mytent);
//            finish();
//
//        }
//
//        super.onActivityResult(requestCode, resultCode, data);
//
//    }
private void initTextToSpeech() {
    try {
        Intent intent = new Intent(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(intent, TTS_DATA_CHECK);
    }
    catch (Exception e){

    }
}



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == TTS_DATA_CHECK) {
                if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                    tts = new TextToSpeech(getApplicationContext(), this);
                } else {
                    Intent installVoice = new Intent(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                    startActivity(installVoice);
                }

            }
        }
        catch (Exception e){

        }
        if (requestCode == 2
                && data != null && data.getData() != null ) {
//          secondpath = Uri.parse(compressImage(data.getData().getPath()));
            All.filePath = data.getData();
            All.proty = data.getData();
            All.fii = new File( All.filePath.getPath());
            All.directuri = data.getData().toString();
//            displayo("in all");
            processall.getInstance().setPothy( All.proty);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),  All.filePath);
                All.imagebitmap = bitmap;
                mCurrentPhotoPath =  All.filePath.getPath();
//                displayo(mCurrentPhotoPath);
//                processall.getInstance().setPathy(data.getData().toString());
                GlideApp.with(this/* context */)
                        .load(All.filePath.toString())
                        .into(All.imageview);
                All.imageview.setVisibility(View.VISIBLE);
                All.spinnerview.setVisibility(View.VISIBLE);
                All.hopeimage =1;
                All.hasimagei = true;

//                displayo(mCurrentPhotoPath);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }


//            Thread threadis = new Thread(null,  All.doBackgroundThreadProcessingnconvertfile,"Background");
//            threadis .start();
//            Thread threadis = new Thread(null, doBackgroundThreadProcessingnconvertfile,"Background");
//            threadis .start();
        } else {
//            startActivity(processall.getInstance().getYu());
//            getActivity().finish();
            if(requestCode == 48){
                if(mysharedpreference.getBoolean("finishstate",false)){
                    myeditor.putBoolean("finishstate",false);
                    myeditor.apply();
                    try {
                        Intent mnb = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(mnb);
                        finish();
                    }
                    catch (Exception e){

                    }
                }
            }
            else {
                if (requestCode == 3
                        && data != null && data.getData() != null ) {
//          secondpath = Uri.parse(compressImage(data.getData().getPath()));
                    Tips.filePath = data.getData();
                    Tips.proty = data.getData();
                    Tips.fii = new File( Tips.filePath.getPath());
                    Tips.directuri = data.getData().toString();
//            displayo("in all");
                    processall.getInstance().setPothy( Tips.proty);
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), Tips.filePath);
                        Tips.imagebitmap = bitmap;
                        mCurrentPhotoPath =  Tips.filePath.getPath();
//                displayo(mCurrentPhotoPath);
//                processall.getInstance().setPathy(data.getData().toString());
                        GlideApp.with(this/* context */)
                                .load(Tips.filePath.toString())
                                .into(Tips.imageview);
                        Tips.imageview.setVisibility(View.VISIBLE);
                        Tips.spinnerview.setVisibility(View.VISIBLE);
                        Tips.hopeimage =1;
                        Tips.hasimagei = true;

//                displayo(mCurrentPhotoPath);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }


//            Thread threadis = new Thread(null,  All.doBackgroundThreadProcessingnconvertfile,"Background");
//            threadis .start();
//            Thread threadis = new Thread(null, doBackgroundThreadProcessingnconvertfile,"Background");
//            threadis .start();
                }
            }
        }
    }


    public static void speak(String m) {
        try {
            if (tts != null && ttsIsInit) {
                proccedings++;
                tts.speak(m, TextToSpeech.QUEUE_ADD, map);

            }
        }
        catch (Exception e){

        }
    }
    public void onInit(int status) {
        try {
            if (status == TextToSpeech.SUCCESS) {

                ttsIsInit = true;
                if (tts.isLanguageAvailable(Locale.UK) >= 0)
                    tts.setLanguage(Locale.UK);
                tts.setPitch(1.09f);
                tts.setSpeechRate(0.87f);
                map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "UniqueID");
                speak("hi, "+mysharedpreference.getString("username","")+", welcome to class!");
                tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                    @Override
                    public void onStart(String s) {
                        Toast.makeText(getApplicationContext(), "start", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onDone(String s) {

//                                    new Thread()
//                                    {
//                                        public void run()
//                                        {
//                                            MainActivity.this.runOnUiThread(new Runnable()
//                                            {
//                                                public void run()
//                                                {
//
//                                                    Toast.makeText(getBaseContext(), "TTS Completed", Toast.LENGTH_SHORT).show();
//
//                                                }
//                                            });
//                                        }
//                                    }.start();

//                    startActivityForResult(intrent, VOICE_RECOGNITION);
                    }

                    @Override
                    public void onError(String s) {

                    }
                });

            }
        }
        catch (Exception e){

        }
    }
private File createImageFile() throws IOException {
    // Create an image file name
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    String imageFileName = "JPEG_" + timeStamp + "_";
    File storageDir = getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    File image = File.createTempFile(
            imageFileName,  /* prefix */
            ".jpg",         /* suffix */
            storageDir      /* directory */
    );

    // Save a file: path for use with ACTION_VIEW intents
    mCurrentPhotoPath = image.getAbsolutePath();

    return image;
}
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
    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (All.watcher == 1) {
                All.allsolve.setImageResource(R.drawable.edit);
                All.relenter.startAnimation(downanimation);
                CountDownTimer gf = new CountDownTimer(1200, 500) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        All.relenter.setVisibility(View.GONE);
                        All.allsolve.setVisibility(View.VISIBLE);

                        All.watcher = 0;
                    }
                }.start();
            } else {
                if (centrewatcher == 1) {
                    Information.relwriteinfo.startAnimation(downanimation);
                    CountDownTimer gf = new CountDownTimer(1200, 500) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            Information.relwriteinfo.setVisibility(View.GONE);
                            centrewatcher = Information.previosstate;
                        }
                    }.start();
                } else {
                    if (centrewatcher == 2) {
                        Doc.reladdnewfolder.startAnimation(downanimation);
                        CountDownTimer gf = new CountDownTimer(1200, 500) {
                            @Override
                            public void onTick(long l) {

                            }

                            @Override
                            public void onFinish() {
                                Doc.reladdnewfolder.setVisibility(View.GONE);
                                centrewatcher = Doc.previousstate;
                            }
                        }.start();

                    } else {
                        if(Tips.watcher == 1){
                            Tips.allsolve.setImageResource(R.drawable.edit);
                            Tips.relenter.startAnimation(downanimation);
                            CountDownTimer gf = new CountDownTimer(1200,500) {
                                @Override
                                public void onTick(long l) {

                                }
                                @Override
                                public void onFinish() {
                                    Tips.relenter.setVisibility(View.GONE);
                                    Tips.allsolve.setVisibility(View.VISIBLE);
                                    Tips.watcher =0;
                                }
                            }.start();
                        }
                        else
                        {
                            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setMessage("sure to leave the framework?")
                                    .setCancelable(false)
                                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            MainActivity.this.finish();
                                        }
                                    })
                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                            AlertDialog alert = builder.create();
                            alert.show();
                        }
                    }
                }
//            if(InnerAnswer)
            }
        }
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
    private void scheduleJobFirebaseToRoomDataUpdate(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            JobScheduler jobScheduler = (JobScheduler) getApplicationContext()
                    .getSystemService(JOB_SCHEDULER_SERVICE);

            ComponentName componentName = new ComponentName(this,
                    MyJobService.class);

            JobInfo jobInfo = null;

                jobInfo = new JobInfo.Builder(1, componentName)
                       .setRequiredNetworkType(
                                JobInfo.NETWORK_TYPE_ANY)
                        .setPeriodic(910000)
                          .build();

            jobScheduler.schedule(jobInfo);
        }
    }
    private void setPic() {
        // Get the dimensions of the View
        int targetW = mImageView.getWidth();
        int targetH = mImageView.getHeight();

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        mImageView.setImageBitmap(bitmap);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        stopService(myDateServiceIntent);
        myeditor.putBoolean("inmain",false);
        myeditor.putBoolean("dead",true);
//        myeditor.putBoolean("firsttime",true);
        myeditor.commit();
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            settings.show();
        }
        if (id == R.id.user_settings) {
            Intent m = new Intent(MainActivity.this,YourSettings.class);
            startActivityForResult(m,48);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.answered) {
            // Handle the camera action
            mViewPager.setCurrentItem(1);
        } else if (id == R.id.unanswered) {
             mViewPager.setCurrentItem(2);
        } else if (id == R.id.shot) {
            if (permissionCamera != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
//                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                    ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA },
                            10);

                    Toast.makeText(this, "Camera Permission is required for this app to run", Toast.LENGTH_SHORT)
                            .show();
//                }
            }
            else {
                dispatchTakePictureIntent();
            }
//        } else if (id == R.id.nav_manag) {

        } else if (id == R.id.nav_share) {
            String puto = "Hi! i would like you to run on the Tframework";
            Intent shareit = new Intent(Intent.ACTION_SEND);
            shareit.putExtra(Intent.EXTRA_TEXT, puto);
            shareit.setType("text/plain");
            startActivity(Intent.createChooser(shareit, "share using .."));
        } else if (id == R.id.explore) {
              re.show();
        }
     else if (id == R.id.about) {
        about.show();
    }
        else if (id == R.id.user_settings) {
            Intent m = new Intent(MainActivity.this,YourSettings.class);
            startActivityForResult(m,48);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onRequestPermissionsResult(int requestCode, final String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 10: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //If user presses allow
//                    permissionse.show();
                    dispatchTakePictureIntent();
                    CountDownTimer timer = new CountDownTimer(500,4000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
//                         permissionse.cancel();

                        }
                    }.start();

//                    Toast.makeText(MainActivity.this, "Permission granted!", Toast.LENGTH_SHORT).show();
//                    Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num.getText().toString()));
//                    startActivity(in);
                } else {
                    //If user presses deny
                    displayo("permission denied");
//                    Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case 12: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //If user presses allow
                    displayo("permission granted");
                    chooseImage();
//                    startActivity(new Intent(getActivity(),MainActivity.class));
//                    getActivity().finish();
//                    dispatchTakePictureIntent();
//                    Toast.makeText(MainActivity.this, "Permission granted!", Toast.LENGTH_SHORT).show();
//                    Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num.getText().toString()));
//                    startActivity(in);
                } else {
                    //If user presses deny
                    displayo("permission denied");
//                    Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case 13: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //If user presses allow
                    displayo("permission granted");
                    chooseImagee();
//                    startActivity(new Intent(getActivity(),MainActivity.class));
//                    getActivity().finish();
//                    dispatchTakePictureIntent();
//                    Toast.makeText(MainActivity.this, "Permission granted!", Toast.LENGTH_SHORT).show();
//                    Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num.getText().toString()));
//                    startActivity(in);
                } else {
                    //If user presses deny
                    displayo("permission denied");
//                    Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case 14544664: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //If user presses allow
                    displayo("permission granted");
//                    dispatchTakePictureIntent();
//                    Toast.makeText(MainActivity.this, "Permission granted!", Toast.LENGTH_SHORT).show();
//                    Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num.getText().toString()));
//                    startActivity(in);
                } else {
                    //If user presses deny
                    displayo("permission denied");
//                    Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
