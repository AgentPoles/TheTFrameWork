
package com.mycompany.myapp.thetframework;
import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
//import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;
import uk.co.senab.photoview.PhotoView;
public class InnerAnswer extends AppCompatActivity implements Answeradapter.OnRecycleViewItemClicker, LoaderManager.LoaderCallbacks<List<Answer>>,Answeradapter.OnhasimageListener{

    TextView commentno, questiono,datree, ausernameee, useranumber, useraemail, question, timre;
    RecyclerView answerit;
    ActionBar vbar;
    FloatingActionButton allsolveh;
    LinearLayout linsoft;
    MediaPlayer mediaPlayer;
    RelativeLayout reluserdetails;
    public static String SERVICE_TIMESTAMP;
    static  int animwatcher;
    Intent jintent;

    int fullQuestionHidenState =0;

    float zomx, zomy;
    ProgressBar progressquestioninner;
    TextView fullQuestion;
    ImageView showfullquestion, showlessquestion;
    ScaleAnimation scaleout, scalein;
    FloatingActionButton sroveh, sendcommians;
    ImageView gretimage;
    public static final String PROGRESS_ACTION = BuildConfig.APPLICATION_ID + ".PROGRESS";
    public static final String REAL_ACTION = BuildConfig.APPLICATION_ID + ".PROGRESS_REAL";
    public static final String ANSWER_ACTION = BuildConfig.APPLICATION_ID + ".ANSWER_ACTION";
    public static final String ANSWER_REAL = BuildConfig.APPLICATION_ID + ".ANSWER_REAL";
    int permissionreadexternal, permissionmanagedocs;
    TextView sayhide;
    long timeStamp;
    private ProgressReciever progressReciever;
     ImageView innerquepending;
             String prendingimagepath;
     boolean prending;
    TranslateAnimation scaleinn;
    Drawable drawable;
    UploadAnswer uploadAnswer;
    TranslateAnimation scaleoout;
    Uri questionthumblineurid;
    question querty;
    File vfile;
    String storageguy;
    static int theimagehelper = 0;
    static int actualHeight = 0;
    static int actualWidth = 0;
    int hidenstateWatcher;
    int answerorquestion;
    AppDatabase mDatabase;
    boolean iseanswer;
    ScaleAnimation scale, unscale;
Uri thumblineuri, SupportUri;
    int thumbrealquestionstater;
    EditText quennysa;
    Context context;
    CircleImageView qquemage;
    boolean isanswer = false;
    EditText introaskis;
    int solvehwatcher;
    Uri pothy;
    boolean hasimage;
    int commentwatcher;
    Uri downloadurid, answerworkinguri, answerworkingthumbline;
//    SharedPreferences mysharedpreference;
//    SharedPreferences.Editor myeditor;
    int sender;
    boolean sendingImage;
    File localFile ;
   private static String questioncoolid;
    static String cid;
    Activity activity;
    ImageView theimagegallery, theimagegoahead;
    EditText theimagecaption;
//    ImageView movy;
    static String mmuild;
    String s,d;
    TextView srending, sayreload;
    static List<Answer> sronfolists = new ArrayList<>();
    TranslateAnimation runny;
    RotateAnimation rotateAnimation, rotec, rotek;
    AlphaAnimation alphaAnimation , alphyanimation, malphyanimation;
    static RelativeLayout relecomans;
    static LinearLayout relentera;
    TranslateAnimation soanimation, downanimation;
    RelativeLayout relenteraa;
    int yy, zz;
    int introaskisaid;
    boolean hasimagei;
    Dialog rec;
   TextView dummytextview;
    Uri downloaduri;
    ImageView rollit;
    ImageView theimagespinner;
    FirebaseStorage storage;
    RelativeLayout tobehidden;
    static  String queid, mclassi, name, strDate, time, number, email, answerbody;
    StorageReference storageReferenced, storageReferencer, storageReferencereal;
    FirebaseDatabase Fidb;
    int seeit = 0;
    TranslateAnimation slideright, slideleft;
    ImageView getGretimage;
    Intent mjh;
    CircleImageView answerimage;
    Handler hand;
    Activity ractivity;
    Bitmap imagebitmap;
    private  Uri filePath, secondpath, thirdpath, prendingimagepathe;
    int hopeimage;
    int position ;
    File fii;
    DataSnapshot dtr;
    String directuri;
    ProgressBar progressBar;
    LinearLayout hido;
    ScaleAnimation goin, goout;
    int pendingwatcher;
    RotateAnimation rote;
    SharedPreferences mysharedpreference;
    FirebaseAuth mAuth;
    static Answer answera;
    ImageView rolling;
    FirebaseStorage Allstores;
    RelativeLayout showimage;
    ImageView previous;
    PhotoView theimage;
    Mathmatical mathmatical;
    StorageReference storageReference;
    SharedPreferences.Editor myeditor;
    DatabaseReference questionreference;
    ScaleAnimation zoomin, zoomout;
    DatabaseReference answerreference, innerurireference;
    static List<Answer> senfoLists = new ArrayList<>();
    static Answeradapter senfoAdapter;
    question crans;
    LinearLayout quennys;
    class ProgressReciever extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                progressBar.setVisibility(View.VISIBLE);
             Bundle m = intent.getExtras();
             progressBar.setProgress((int)m.get("progress"));
             if((int)m.get("progress")>=98){
                 progressBar.setVisibility(View.GONE);
             }
            }
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(progressReciever);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inner);
        mDatabase = AppDatabase.getsInstance(getApplicationContext());
        mysharedpreference = getSharedPreferences("readstate", MODE_PRIVATE);
        myeditor = mysharedpreference.edit();
        Bundle m = getIntent().getExtras();

        try {
            final String quescoolid = m.getString("questioncooolid", "");
            if (quescoolid != null && quescoolid.length() > 1 && !quescoolid.equals("")) {
                try {
                    AppExecutor.getsInstance().networkIO().execute(
                            new Runnable() {
                                @Override
                                public void run() {
                                    question tyu = mDatabase.questionDao().LoadOrdinaryBycoolId(quescoolid);
                                    tyu.setRead(true);
                                    processall.getInstance().setWho(tyu.getWho());
                                    processall.getInstance().setBody(tyu.getBody());
                                    processall.getInstance().setDate(tyu.getDate());
                                    processall.getInstance().setPending(tyu.isPending());
                                    processall.getInstance().setTime(tyu.getTime());
                                    processall.getInstance().setQueid(tyu.getQueid());
                                    processall.getInstance().setHasImage(tyu.isHasImage());
                                    processall.getInstance().setPathy(tyu.getUristring());
                                    processall.getInstance().setPosition(String.valueOf(position));
                                    processall.getInstance().setSender(1);
                                    processall.getInstance().setCoolid(tyu.getCoolid());
                                    processall.getInstance().setNoanswer(String.valueOf(tyu.getNoanswer()));
                                    processall.getInstance().setNocomment(String.valueOf(tyu.getNocomment()));
                                    processall.getInstance().setAskernumber(tyu.getYnumber());
                                    processall.getInstance().setAskemail(tyu.getYemail());
                                    processall.getInstance().setViewpage(0);
                                    processall.getInstance().setDownloadurid(tyu.getDownloadurid());
                                    processall.getInstance().setThumblineurid(tyu.getThumblineuri());
                                    processall.getInstance().setUserclass(tyu.getMclass());

                                }
                            }
                    );
                } catch (Exception e) {

                }
            } else {

            }
        }
        catch (Exception e){

        }

        cid = processall.getInstance().getQueid();
        questioncoolid = processall.getInstance().getCoolid();
//        Thred thread = new Thread(null, doBackgroundThreadProcessinge, "Background");
//        thread.start();
        hand = new Handler();
        progressReciever = new ProgressReciever();
        LocalBroadcastManager.getInstance(this).registerReceiver(progressReciever, new IntentFilter(PROGRESS_ACTION));
        commentno = (TextView) findViewById(R.id.commentno);
        questiono = (TextView) findViewById(R.id.questionno);
        datree = (TextView) findViewById(R.id.datree);

        context = getApplicationContext();
        SERVICE_TIMESTAMP = "timestamp";
        drawable = getResources().getDrawable(R.drawable.add);
        myeditor.putBoolean("inmain",false);
        myeditor.putBoolean("ininner",true);

        ausernameee = (TextView) findViewById(R.id.ausernameee);
        useraemail = (TextView) findViewById(R.id.useraemail);
        tobehidden = (RelativeLayout) findViewById(R.id.tobehidden);
        answerimage = (CircleImageView) findViewById(R.id.answerimage);
        useranumber = (TextView) findViewById(R.id.useranumber);
        question = (TextView) findViewById(R.id.question);
        mjh = new Intent(this, InnerAnswer.class);
        timre = (TextView) findViewById(R.id.timre);
        progressquestioninner = (ProgressBar)findViewById(R.id.progresquestioninner);
        hido = (LinearLayout) findViewById(R.id.hido);
        showimage = (RelativeLayout) findViewById(R.id.showimage);
        theimage = (PhotoView) findViewById(R.id.theimage);
        theimagecaption = (EditText) findViewById(R.id.theimagecaption);
        theimagegallery = (ImageView) findViewById(R.id.theimagegallety);
        fullQuestion = (TextView) findViewById(R.id.fullquestion);
        showfullquestion = (ImageView)findViewById(R.id.showfullquestion);
        theimagegoahead = (ImageView) findViewById(R.id.theimagegoahead);
        theimagespinner = (ImageView) findViewById(R.id.theimagespinner);
        reluserdetails = (RelativeLayout)findViewById(R.id.reluserdetails);
        showlessquestion = (ImageView)findViewById(R.id.showlessquestion);
        previous = (ImageView) findViewById(R.id.previous);
        rolling = (ImageView) findViewById(R.id.rolling);
        sayreload = (TextView) findViewById(R.id.sayreload);
        sayhide = (TextView) findViewById(R.id.sayhide);
        activity = this;

        jintent = new Intent(this, UploadAnswer.class);
        quennys = (LinearLayout) findViewById(R.id.quennys);
        relenteraa = (RelativeLayout) findViewById(R.id.relenteraa);
        progressBar = (ProgressBar)findViewById(R.id.progresquestioninner);
        relenteraa.setVisibility(View.GONE);
        vbar = getSupportActionBar();
        vbar.hide();
        hasimagei = false;
        answerorquestion = 0;
//        mysharedpreference = getSharedPreferences("readstate",MODE_PRIVATE);
//        myeditor = mysharedpreference.edit();
        qquemage = (CircleImageView) findViewById(R.id.qquemage);
        gretimage = (ImageView) findViewById(R.id.gretimage);
//        movy = (ImageView)findViewById(R.id.movy);
        innerquepending = (ImageView) findViewById(R.id.innerquepending);
        runny = new TranslateAnimation(0, 400, 0, 0);
        slideleft = new TranslateAnimation(400, 0, 0, 0);
        scale = new ScaleAnimation(0, 1, 0, 1);
        unscale = new ScaleAnimation(1, 0, 1, 0);
        scale.setDuration(600);
         jintent = new Intent(getApplication(),UploadAnswer.class);
        unscale.setDuration(600);
        goout = new ScaleAnimation(0, 1, 0, 1);
        goin = new ScaleAnimation(1, 0, 1, 0);
        goout.setDuration(200);
        goin.setDuration(200);
        sendingImage = false;
        runny.setDuration(600);
        srending = (TextView) findViewById(R.id.srending);
        srending.setVisibility(View.GONE);
        Fidb = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        Allstores = FirebaseStorage.getInstance();
//        senfoAdapter.setOnhasImageListener(this);
        answerreference = Fidb.getReference("Answers");
        questionreference = Fidb.getReference("question");
//        innerurireference = Fidb.getReference("Uris").child(cid);
        storageReferenced = Allstores.getReference("AnswserImages");
        localFile = new File(cid, "jpg");
        try {
            localFile = File.createTempFile(cid, "jpg");
        } catch (Exception e) {

        }

        mediaPlayer = MediaPlayer.create(this,R.raw.bruteforce);
        uploadAnswer = new UploadAnswer();
        permissionreadexternal = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        permissionmanagedocs = ContextCompat.checkSelfPermission(this, Manifest.permission.MANAGE_DOCUMENTS);
        gretimage.setOnClickListener(gretimageListener);
        rote = new RotateAnimation(0, 360, 30, 30);
        rote.setDuration(900);
        rote.setRepeatCount(999999999);
        rotec = new RotateAnimation(0, 360, 60, 60);
        rotec.setDuration(900);
        rotec.setRepeatCount(999999999);
        rotek = new RotateAnimation(0, 360, 30, 30);
        rotek.setDuration(900);
        rotek.setRepeatCount(999999999);
        previous.setOnClickListener(previousListener);
        rollit = (ImageView) findViewById(R.id.rollit);
        introaskis = (EditText) findViewById(R.id.introaskis);
        sroveh = (FloatingActionButton) findViewById(R.id.sroveh);
        relentera = (LinearLayout)findViewById(R.id.relentera);
        relecomans = (RelativeLayout) findViewById(R.id.relecomans);
//        gretimage = (ImageView)findViewById(R.id.gretimage);
        sendcommians = (FloatingActionButton) findViewById(R.id.sendcommians);
//        gretimage.setOnClickListener(imageclick);
        hidenstateWatcher = 0;
        sendcommians.setOnClickListener(sendcommiansLiatener);
        relentera.setVisibility(View.GONE);
        rolling.setVisibility(View.GONE);
        rotateAnimation = new RotateAnimation(0, 360, 27, 27);
        rotateAnimation.setDuration(1200);
        alphaAnimation = new AlphaAnimation(0, 1);
        alphyanimation = new AlphaAnimation(1, 0);
        scaleinn = new TranslateAnimation(0, 0, 0, -800);
        scaleinn.setDuration(500);
        scaleoout = new TranslateAnimation(0, 0, -500, 0);
        scaleoout.setDuration(300);
//        displayo(String.valueOf(MainActivity.answers.size()));
        malphyanimation = new AlphaAnimation(1, 0);
        malphyanimation.setDuration(500);
        alphaAnimation.setDuration(1200);
        animwatcher = 0;
        solvehwatcher = 0;
        alphyanimation.setDuration(1200);
        Resources fg = getResources();
        Intent rui = getIntent();
        Bundle gh = rui.getExtras();
        hido.setOnClickListener(hidoListener);
        commentno.setText(processall.getInstance().getNocomment());
        datree.setText(processall.getInstance().getDate());
        timre.setText(processall.getInstance().getTime());
        ausernameee.setText(processall.getInstance().getWho());
        sender = processall.getInstance().getSender();
        position = Integer.parseInt(processall.getInstance().getPosition());
        questiono.setText(processall.getInstance().getNoanswer());
        useraemail.setText(processall.getInstance().getAskemail());
        useraemail.setSelected(true);
        pothy = processall.getInstance().getPothy();
        useranumber.setText(processall.getInstance().getAskernumber());
        question.setText(processall.getInstance().getBody());
        fullQuestion.setText(processall.getInstance().getBody());
        prending = (processall.getInstance().isPending());
        rec = new Dialog(this);
        rec.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        rec.setContentView(R.layout.dummydialogx);
        dummytextview = (TextView)rec.findViewById(R.id.dummytextview);
        dummytextview.setText(processall.getInstance().getBody());
        if (prending && processall.getInstance().getPathy() != null) {
            prendingimagepath = (processall.getInstance().getPathy());
        }

 showfullquestion.setOnClickListener(showFullQuestionListener);

//        displayo(prendingimagepath);
        thumbrealquestionstater = 0;
        hasimage = processall.getInstance().hasImage;
//        Beginna.enloadInBackground(Fidb,answerreference);
//        innerurireference = Fidb.getReference("Uris").child(cid);
        senfoLists = Beginna.dre;
//        displayo(gh.getString("queid"));position = Integer.parseInt(processall.getInstance().getPosition());
//        matchem(sronfolists,senfoLists);
        answerit = (RecyclerView) findViewById(R.id.answerrecyclerview);
        allsolveh = (FloatingActionButton) findViewById(R.id.allsoveh);
        senfoAdapter = new Answeradapter(senfoLists, this, this, this);
        senfoAdapter.setOnItemclickedListener(this);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(this);
        allsolveh.setOnClickListener(allsolvehListener);
        setUpInfo();
//        quennys = (EditText)findViewById(R.id.quennys);
        storage = FirebaseStorage.getInstance();
//        storageReference = storage.getReference().child(cid);
        soanimation = new TranslateAnimation(0, 0, 700, 0);
        soanimation.setDuration(1200);
        isanswer = false;
        jintent = new Intent(getApplication(),UploadAnswer.class);
//        tysharedpreferences = getSharedPreferences("loadstate",MODE_PRIVATE);
//        mEditor = tysharedpreferences.edit();
        yy = Integer.parseInt(processall.getInstance().getNoanswer());
        zz = Integer.parseInt(processall.getInstance().getNocomment());
        storageguy = processall.getInstance().getQueid();
        downanimation = new TranslateAnimation(0, 0, 0, 700);
        downanimation.setDuration(1900);
        scalein = new ScaleAnimation(0, 0, 1, 0);
        scaleout = new ScaleAnimation(0, 0, 0, 1);
        scalein.setDuration(2000);
        scaleout.setDuration(1800);
        introaskis.addTextChangedListener(textWatcher);
        linsoft = (LinearLayout) findViewById(R.id.linsoft);

//        senfoAdapter.notifyDataSetChanged();
//        displayo(cid);
        answerit.setLayoutManager(mlayoutManager);
        answerit.setItemAnimator(new DefaultItemAnimator());
        answerit.setAdapter(senfoAdapter);
        answerit.setScrollY(View.FOCUS_DOWN);
        sroveh.setOnClickListener(srovehListener);
        rollit.setOnClickListener(ReloadListener);
        qquemage.setOnClickListener(ImageListener);
        answerimage.setOnClickListener(ImageListenera);
        theimagespinner.setVisibility(View.GONE);
        showlessquestion.setOnClickListener(showFullQuestionListener);
 //        .setVisibility(View.GONE);
        showimage.setVisibility(View.INVISIBLE);
        rollit.setVisibility(View.GONE);
        introaskisaid = 0;



//        if(sender==1){
////            All.InfoLists.get(position).setRead(true);
//            for(int ios = 0; ios<All.InfoLists.size();ios++){
//                if(All.InfoLists.get(ios).getQueid().equals(cid)){
//                    All.InfoLists.get(ios).setRead(true);
//                }
//            }
//            Spreferences.setReadState(mysharedpreference,cid,myeditor,Integer.parseInt(processall.getInstance().getNoanswer()),Integer.parseInt(processall.getInstance().getNocomment()));
//        }
//        else{
//        if(sender==2){
//            for(int ios = 0; ios<Answered.InfoListsa.size();ios++){
//                if(Answered.InfoListsa.get(ios).getQueid().equals(cid)){
//                    Answered.InfoListsa.get(ios).setRead(true);
//                }
//            }
//            Spreferences.setReadState(mysharedpreference,cid,myeditor,Integer.parseInt(processall.getInstance().getNoanswer()),Integer.parseInt(processall.getInstance().getNocomment()));
//        }
//            else {
//            if(sender==3){
//                for(int ios = 0; ios<Unanswered.InfoListsb.size();ios++){
//                    if(Unanswered.InfoListsb.get(ios).getQueid().equals(cid)){
//                        Unanswered.InfoListsb.get(ios).setRead(true);
//                    }
//                }
//                Spreferences.setReadState(mysharedpreference,cid,myeditor,Integer.parseInt(processall.getInstance().getNoanswer()),Integer.parseInt(processall.getInstance().getNocomment()));
//            }
//        }
//        }
        theimagespinner.setVisibility(View.GONE);
        theimagespinner.setOnClickListener(theimageclicker);
//        Answeradapter.answerimaged.setOnClickListener(ImageListenerb);

        if (prending) {
            pendingwatcher = 1;
            innerquepending.setVisibility(View.VISIBLE);
            if (hasimage && prendingimagepath != null) {

                    try{
                        newshowite(this,Uri.parse(processall.getInstance().getPathy()),qquemage);
                    }
                    catch (Exception e){
                        displayo("sorry i could not load quesion image, something went wrong");
                    }

//                    answerimage.setVisibility(View.VISIBLE);
//                    hopeimage = 1;
//
//                qquemage.setImageDrawable();
            }
        } else {
            if (processall.getInstance().getThumblineurid() != null) {
//                questionthumblineurid = Uri.parse(processall.getInstance().getThumblineurid());
            if (hasimage) {
                qquemage.setVisibility(View.VISIBLE);
                sayreload.setVisibility(View.GONE);

                    storageReferencer = storage.getReference("questionimages").child(storageguy);

//                        rollit.setVisibility(View.VISIBLE);
                        answerorquestion = 1;
//                        rollit.startAnimation(rote);
//                        theimagespinner.startAnimation(rotec);

//                        displayo(downloaduri.toString());
                        answerorquestion = 0;
                        newshowit(this,storageReferencer,qquemage);
                        if (processall.getInstance().getDownloadurid() != null) {
                            storageReferencereal = storage.getReference("questionimages").child("real"+storageguy);
                          newshowit(this,storageReferencereal,theimage);

                    } else {
                        displayo("i could not access real image path");
                    }
                }
            } else {
                qquemage.setVisibility(View.GONE);
            }
        }

//            if(!loc
// alFile.exists()) {
//                if (confirmconnection()) {
//
//         displayo("getting your file");

//                    rollit.startAnimation(rote);
//
//         Thread threadit = new Thread(null, doBackgroundThreadProcessingnm, "Background");
//                    threadit.start();
//                } else {
//                    displayo("there is an image file associated with this question, please turn on data to access it");
//                }
        theimagegoahead.setOnClickListener(theimagegoaheadListener);
        theimagegallery.setOnClickListener(gretimageListener);
        answerit.scrollToPosition(senfoAdapter.getItemCount()-1);
        myeditor.apply();
        }
//        displayo(String.valueOf(hasimage));

//        if(tysharedpreferences.getBoolean(cid,false)==false) {
//            mEditor.putBoolean(cid, false);
//        answerreference.orderByChild("timestamp").addValueEventListener(answeristener);

//        }
//        else{
//
//        }
//        relentero = (RelativeLayout)findViewById(R.id.relenter);

//    public static void suont(List<Answer> a){
//        a.clear();
//        for (int i=MainActivity.answers.size()-1; i>=0;i--){
//            a.add(MainActivity.answers.get(i));
////            displayo(String.valueOf(MainActivity.answers.get(i).isananwer()));
//        }
//
//        }
//    public void matchem(List<Answer> a, List<Answer> b) {
//        b.clear();
//        if(!a.isEmpty()) {
//


//            for (int i = 0; i < a.size(); i++) {
//
//                if (a.get(i).
//
//
// getQueid().equals(id)) {
////                    displayo(a.get(i).getQueid());
////                    displayo(id);
//                    b.add(a.get(i));
//                } else {
//
//                }
//            }
//        }
//
    View.OnClickListener showFullQuestionListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(fullQuestionHidenState == 0){
            fullQuestion.setVisibility(View.VISIBLE);
            reluserdetails.setVisibility(View.VISIBLE);
            question.setVisibility(View.GONE);
            fullQuestion.startAnimation(scaleoout);
            reluserdetails.startAnimation(scaleoout);
            fullQuestionHidenState = 1;
            showfullquestion.setVisibility(View.GONE);
            showlessquestion.setVisibility(View.VISIBLE);
        }
        else {
            if(fullQuestionHidenState==1){
//                fullQuestion.setVisibility(View.GONE);
                fullQuestion.startAnimation(scaleinn);
                reluserdetails.startAnimation(scaleinn);
                fullQuestionHidenState = 0;
                CountDownTimer timer = new CountDownTimer(400,300) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        fullQuestion.setVisibility(View.GONE);
                        reluserdetails.setVisibility(View.GONE);
                        question.setVisibility(View.VISIBLE);
                        showlessquestion.setVisibility(View.GONE);
                        showfullquestion.setVisibility(View.VISIBLE);
                    }
                }.start();
            }
        }
    }

};

public static void showExpandableImage(Context context, String imageUri, String title, View view) {
    try {

        Intent intent = new Intent(context, ViewImageActivity.class);
        intent.putExtra("image", imageUri);
        intent.putExtra("title", title);

        if (TextUtils.isEmpty(imageUri)) {
            imageUri = getURLForResource(R.drawable.personel); // default image in drawable
        }

        Pair<View, String> bodyPair = Pair.create(view, imageUri);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(((Activity)context), bodyPair);


        ActivityCompat.startActivity(context, intent, options.toBundle());

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void showExpandableImage(Context context, String imageUri, String title, View view,String storageid, boolean pending, boolean isanswer) {
        try {

            Intent intent = new Intent(context, ViewImageActivity.class);
            intent.putExtra("image", imageUri);
            intent.putExtra("title", title);
            intent.putExtra("storageid", storageid);
            intent.putExtra("pending",pending);
            intent.putExtra("isanswer",isanswer);
            if (TextUtils.isEmpty(imageUri)) {
                imageUri = getURLForResource(R.drawable.schoolbeta); // default image in drawable
            }

            Pair<View, String> bodyPair = Pair.create(view, imageUri);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(((Activity)context), bodyPair);


            ActivityCompat.startActivity(context, intent, options.toBundle());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://com.yourpackage.name/" + resourceId).toString();
    }
    public void animateout(TranslateAnimation animation, final ScaleAnimation scaleAnimation, final ImageView imageView, final FloatingActionButton button){
        imageView.startAnimation(animation);
        CountDownTimer timer = new CountDownTimer(100,200) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
         imageView.setVisibility(View.GONE);
         button.setVisibility(View.VISIBLE);
         button.startAnimation(scaleAnimation);
            }
        }.start();
    }
    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
       if(introaskis.length()>0&&introaskis.getText().toString()!=""&&introaskisaid==0){
           animateout(runny,goout,gretimage,sendcommians);
           introaskisaid = 1;
       }
            if(introaskis.length()==0||introaskis.getText().toString()==""&&introaskisaid==1){
                animatein(slideleft,goin,gretimage,sendcommians);
                introaskisaid = 0;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public void newshowit(Context context, StorageReference storageReference, ImageView imageView) {
        rollit.setVisibility(View.GONE);
        sayreload.setVisibility(View.GONE);
   progressquestioninner.setVisibility(View.VISIBLE);
        GlideApp.with(context /* context */)
                .load(storageReference)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        // log exception
                        Log.e("TAG", "Error loading image", e);
                        progressquestioninner.setVisibility(View.GONE);
                        sayreload.setVisibility(View.VISIBLE);
                        rollit.setVisibility(View.VISIBLE);
                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
                        progressquestioninner.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageView);


    }
    public void newshowite(Context context, Uri uri, ImageView imageView) {

        progressquestioninner.setVisibility(View.VISIBLE);
        sayreload.setVisibility(View.GONE);
        rollit.setVisibility(View.GONE);
        GlideApp.with(context /* context */)
                .load(uri)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        // log exception
                        Log.e("TAG", "Error loading image", e);
                        progressquestioninner.setVisibility(View.GONE);
                        sayreload.setVisibility(View.VISIBLE);
                        rollit.setVisibility(View.VISIBLE);
                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
                        progressquestioninner.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageView);

    }
    public void animatein(final TranslateAnimation animation, final ScaleAnimation scaleAnimation, final ImageView imageView, final FloatingActionButton button){
        button.startAnimation(scaleAnimation);
        CountDownTimer timer = new CountDownTimer(100,200) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                button.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                imageView.startAnimation(animation);
            }
        }.start();
    }
    public void loadImage (String practice, ImageView imageViewr){
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),Uri.parse(practice));
//                    imagebitmap = bitmap;
            imageViewr.setImageBitmap(bitmap);
//                    answerimage.setVisibility(View.VISIBLE);
//                    hopeimage = 1;
//                    sendingImage = true;
        } catch (IOException e) {
            e.printStackTrace();
            displayo("sorry could not set bitmap");
        }
    }
public void setUpInfo(){
    MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
//        LiveData<List<Info>> infos = mDataBase.infoDao().LoadAllInfo();
    viewModel.getAnswers().observe(this,
            new Observer<List<Answer>>() {
                @Override
                public void onChanged(@Nullable List<Answer> answerse) {
//                Processors.getInstance().setInfod(infos);
                    List<Answer> answers = new ArrayList<Answer>();
                    answers.clear();
                    for (int i = 0; i < answerse.size(); i++) {
                        if(answerse.get(i).getQuestioncoolid()!=null) {
                            if (answerse.get(i).getQuestioncoolid().equals(processall.getInstance().getCoolid())) {


//                            if (questions.get(i).getMclass().equals(name)) {
//                    if (questions.get(i).isAnswered()) {
//                                    questions.get(i).setRead(Spreferences.ReadState(mysharedpreference, questions.get(i).getQueid(), myeditor, questions.get(i).getNoanswer(), questions.get(i).getNocomment()));
                                if(answerse.get(i).getMclassi().equals(processall.getInstance().getUserclass())) {
                                    answers.add(answerse.get(i));
                                }
                                Collections.sort(answers, new Comparator<Answer>() {
                                    @Override
                                    public int compare(Answer t0, Answer t1) {
                                        return (int) (t0.getTimestamp() - t1.getTimestamp());
                                    }
                                });
                            }
                        }

                    }                                   senfoAdapter.setEnfoLists(answers);

                    answerit.scrollToPosition(senfoAdapter.getItemCount()-1);
//                    Information.InfoListsand = Processors.getInstance().getInfod();
//                    Information.infoAdapterand.notifyDataSetChanged();
                }
            }
    );
}
public void myscaleoutanimation(float a, float b){
        zoomout = new ScaleAnimation(0,1,0,1, Animation.RELATIVE_TO_PARENT,a,Animation.RELATIVE_TO_PARENT,b);
        zoomout.setDuration(600);
}
    public void myscaleinanimation(float a, float b){
        zoomout = new ScaleAnimation(1,0,1,0, Animation.RELATIVE_TO_PARENT,a,Animation.RELATIVE_TO_PARENT,b);
        zoomin.setDuration(600);
    }
View.OnClickListener theimagegoaheadListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(theimage.getDrawable()!=null){

//            answera = new Answer(timeStamp,"","",hasimagei, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer,true, directuri, false, "",coolid);
//            AppExecutor.getsInstance().diskIO().execute(
//                    new Runnable() {
//                        @Override
//                        public void run() {
//                            mDatabase.
            answerbody = theimagecaption.getText().toString();
            queid = processall.getInstance().getQueid();
            iseanswer = isanswer;
            if (hasimagei) {
                answerbody = theimagecaption.getText().toString();
            }
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
            SimpleDateFormat sdfa = new SimpleDateFormat("h:mm a");
            strDate = sdf.format(c.getTime());
            time = sdfa.format(c.getTime());
            name = mysharedpreference.getString("username","");
            email = mysharedpreference.getString("useremail","");
            number = mysharedpreference.getString("usernumber","");
            mclassi = processall.getInstance().getUserclass();
            timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            String mmlid = answerreference.push().getKey();
            String coolid = email + String.valueOf(timeStamp)+answerreference;

//                if (answerworkingthumbline != null && answerworkinguri != null && answerworkinguri.toString().length() > 1) {
//                    s = answerworkingthumbline.toString();
//                    d = answerworkinguri.toString();
//                    answera = new Answer(timeStamp, s, d, hasimagei, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer, false, directuri, false, "", coolid);
//                } else {
//                    answera = new Answer(timeStamp, s, d, false, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer, false, directuri, false, "", coolid);
////            answera = new Answer(timeStamp,s,d,false, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer);
//                }
//            }
//            else {
                answera = new Answer(timeStamp, s, d, hasimagei, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer, false, directuri, false, "", coolid,processall.getInstance().getCoolid(),mmlid);
//            answera = new Answer(timeStamp,s,d,false, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer);
            jintent.putExtra("coolid",answera.getCoolid());
            AppExecutor.getsInstance().networkIO().execute(
                    new Runnable() {
                        @Override
                        public void run() {
                            answera.setPending(true);
                            mDatabase.answerdao().insertAnswer(answera);
                            crans = mDatabase.questionDao().LoadOrdinaryBycoolId(processall.getInstance().getCoolid());
                            crans.setTimestamp(timeStamp);
                            crans.setAnspending(true);
                            jintent.putExtra("questioncoolid",crans.getCoolid());
                            mDatabase.questionDao().updateQuestion(crans);
                            if(confirmconnection()) {
                                if(answera.isHasimage()){
                                    try{
//                       String pushpath = answerreference.push().getKey();
//                       uploadImage(pushpath,Uri.parse(directuri),answera);


                                        if (!isMyServiceRunning(UploadAnswer.class)) {
                                            hand.post(new Runnable() {
                                                @Override
                                                public void run() {
//                                            displayo("stated answer service");
                                        }
                                    });
                                            startService(jintent);
                                        }

//                       sendanswer(answera);
                                    }
                                    catch (Exception e){
                                        displayo(e.toString());
                                        hand.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                displayo("sorry dear, failed to give your answer by background service");
                                            }
                                        });

                                    }

                                }
                                else {

                                }
                            }
                            else {
                                hand.post(new Runnable() {
                                    @Override
                                    public void run() {
                                displayoe("please ensure mobile data is on");
                                    }
                                });
                            }
                        }
                    }
            );
            if(mysharedpreference.getBoolean("soundstate",true)){
                mediaPlayer.start();
            }
            theimagecaption.setText(null);
            answerit.scrollToPosition(senfoAdapter.getItemCount() - 1);
            linsoft.setVisibility(View.GONE);


        }
        else {
            displayo("failed to load bitmap");
        }

        taketheimageback();
    }
};
    View.OnClickListener hidoListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(hidenstateWatcher == 0){
                tobehidden.startAnimation(scaleinn);
                CountDownTimer timer = new CountDownTimer(400,300) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                     tobehidden.setVisibility(View.GONE);
                    }
                }.start();
                hidenstateWatcher = 1;
                sayhide.setText("show");
            }
            else {
                if(hidenstateWatcher==1){
                    tobehidden.setVisibility(View.VISIBLE);
                    tobehidden.startAnimation(scaleoout);
                    hidenstateWatcher = 0;
                    sayhide.setText("hide");
                }
            }
        }
    };
    @Override
    public void hasimage(int position) {

    }

    @Override
    public void OnRecycleViewItemclicked(View view, int position,String string, Drawable drawable) {
//        if(view.getDrawingCache()!=null){
//            theimage.setImageBitmap(view.getDrawingCache());
//        }
        Answer ans = senfoAdapter.getEnfoLists().get(position);
        theimagehelper = 1;
        float x =  view.getX();
        float y  = view.getY();
        zomx = x;
        zomy = y;
        String a  = ans.getName();
        String b = ans.getAnswerbody();
        String c = a+":  "+b;
//        displayo(ans.getAnswerid());
        if (ans.isPending()) {
            newshowite(activity,Uri.parse(ans.getUristring()),theimage);
            showExpandableImage(InnerAnswer.this,ans.getUristring(),c,view,ans.getAnswerid(),ans.isPending(),false);
//            loadImage(ans.getUristring(), theimage);
//            showimage.setVisibility(View.VISIBLE);
//            showimage.startAnimation(zoomout);
        } else {

//            showimage.setVisibility(View.VISIBLE);
//            showimage.startAnimation(zoomout);
if(ans.getDownloaduri()!=null) {
    storageReference = storage.getReference("answerimages").child("real"+ans.getAnswerid());
//    newshowit(activity, storageReference, theimage);
    showExpandableImage(InnerAnswer.this, ans.getDownloaduri(), c, view,ans.getAnswerid(),ans.isPending(),true);
}
else {
    storageReference = storage.getReference("answerimages").child(ans.getAnswerid());
    newshowit(activity, storageReference, theimage);
    showExpandableImage(InnerAnswer.this, ans.getDownloaduri(), c, view,ans.getAnswerid(),ans.isPending(),true);
}
//            theimagespinner.setVisibility(View.VISIBLE);
//            theimagespinner.startAnimation(rotec);
//            showrealit(Uri.parse(string));
        }
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i ("isMyServiceRunning?", true+"");
                return true;
            }
        }
        Log.i ("isMyServiceRunning?", false+"");
        return false;
    }

    View.OnClickListener gretimageListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (permissionreadexternal != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
//                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    10);

//            Toast.makeText(getApplicationContext(), "Ann needs to Read external storage to process image", Toast.LENGTH_SHORT)
//                    .show();
            displayo("I need to Read external storage to process image");
//                }
        }
        else {
            animwatcher = 1;
            solvehwatcher = 1;
            chooseImage();
        }

    }
};
    View.OnClickListener theimageclicker = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            if(theimagehelper ==0) {
                theimagespinner.startAnimation(rotec);
//                showrealit(downloaduri);
                storageReferencereal = storage.getReference("questionimages").child("real"+storageguy);
                newshowit(activity,storageReferencereal,theimage);
            }


        }
    } ;
    View.OnClickListener ImageListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            storageReferencereal = storage.getReference("questionimages").child("real"+storageguy);
            if (processall.getInstance().isPending()) {
//                newshowite(activity,Uri.parse(.getUristring()),theimage);
                showExpandableImage(InnerAnswer.this,processall.getInstance().getPathy(),processall.getInstance().getWho(),view,processall.getInstance().getQueid(),processall.getInstance().isPending(),false);
//            loadImage(ans.getUristring(), theimage);
//            showimage.setVisibility(View.VISIBLE);
//            showimage.startAnimation(zoomout);
            } else {

//            showimage.setVisibility(View.VISIBLE);
//            showimage.startAnimation(zoomout);
                if (processall.getInstance().getDownloadurid() != null) {
                    storageReferencereal = storage.getReference("questionimages").child("real" + storageguy);
//    newshowit(activity, storageReference, theimage);
                    showExpandableImage(InnerAnswer.this, processall.getInstance().getDownloadurid(), processall.getInstance().getWho(), view, processall.getInstance().getQueid(), processall.getInstance().isPending(),false);
                } else {
                    storageReferencereal = storage.getReference("questionimages").child(storageguy);
//    newshowit(activity, storageReference, theimage);
                    showExpandableImage(InnerAnswer.this, processall.getInstance().getDownloadurid(), processall.getInstance().getWho(), view, processall.getInstance().getQueid(), processall.getInstance().isPending(),false);
                }
            }
//            newshot(activity,storageReferencereal,theimage);

//            theimagehelper = 0;
//            Drawable dr = (qquemage).getDrawable();
////            Bitmap bmp =  ((GlideBitmapDrawable)dr.getCurrent()).getBitmap();
//      showimage.setVisibility(View.VIS
            if(theimage.getDrawable()==null) {
//

            }
            else {

            }
//            theimage.setImageBitmap(dr);
        }
    };

    public static Bitmap scaledBitmap(Bitmap bitmap, int newWidth, int newHeight) {
        Bitmap scaledBitmap = Bitmap.createBitmap(newWidth, newHeight, Bitmap.Config.ARGB_8888);

        float scaleX = newWidth / (float) bitmap.getWidth();
        float scaleY = newHeight / (float) bitmap.getHeight();
        float pivotX = 0;
        float pivotY = 0;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(scaleX, scaleY, pivotX, pivotY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bitmap, 0, 0, new Paint(Paint.FILTER_BITMAP_FLAG));

        return scaledBitmap;
    }

    View.OnClickListener ImageListenera = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showimage.setVisibility(View.VISIBLE);
            showimage.startAnimation(scale);
            theimage.setImageDrawable(answerimage.getDrawable());
        }
    };
//    View.OnClickListener ImageListenerb = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            showimage.setVisibility(View.VISIBLE);
//            showimage.startAnimation(scale);
//            theimage.setImageDrawable(Answeradapter.answerimaged.getDrawable());
//        }
//    };
    View.OnClickListener previousListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            linsoft.setVisibility(View.GONE);
            taketheimageback();
        }
    };
    public void taketheimageback(){
        showimage.startAnimation(scalein);
        CountDownTimer ctimer = new CountDownTimer(600,500) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                showimage.setVisibility(View.INVISIBLE);
            }
        } .start();
    }
    private void chooseImage() {
        animwatcher = 1;
        solvehwatcher = 1;
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select image file"),2);
    }



    private void uploadImage( String pushpath, Uri imagepath , final Answer answerad) {
    if(imagepath != null)
    {
        mmuild = pushpath;
//        hand.post(new Runnable() {
//            @Override
//            public void run() {
//                rolling.setVisibility(View.VISIBLE);
//           rolling.startAnimation(rotek);
//                srending.setText("processing Image");
//            }
//        });

        StorageReference ref = storageReferenced.child(pushpath);
        ref.putFile(imagepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                          @Override
                                          public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                              answerworkingthumbline = taskSnapshot.getUploadSessionUri();
                                              if (filePath != null) {
                                                  uploadrealImage(mmuild,secondpath,answerad);
                                              }
                                              else {
                                                  sendcommians.setClickable(true);
                                              }
                                          }

//
//                        Toast.makeText(getApplicationContext(),"image uploaded",Toast.LENGTH_LONG).show();
//                        relentera.startAnimation(alphyanimation);
//
//                        InnerAnswer.relentera.setVisibility(View.GONE);
//                        introaskis.setVisibility(View.VISIBLE);
//                        sendcommians.setVisibility(View.VISIBLE);
//                        srending.setText("sending...");
//                        srending.setVisibility(View.GONE);
//                        answerimage.setVisibility(View.GONE);
//                        quennys.setVisibility(View.VISIBLE);
//                        rote.cancel();
//                        rolling.setVisibility(View.GONE);
//                        InnerAnswer.animwatcher = 0;
//                        solvehwatcher = 0;
//                        answera = new Answer(downloadurid.toString(),true, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer);
//                        Thread threadise = new Thread(null, doBackgroundThreadProcessingreupdateanswer,"Background");
//                        threadise .start();

                            }
//                        }.start();

//                        String downloadurid =downloaduri.toString();
//                        quer = new question(downloadurid,totralno,true,0,0,mclass,body,coursetitle,strDate,who,time,false,false,ynumber,yemail);
//                        Thread threadise = new Thread(null, doBackgroundThreadProcessingupdatequestion,"Background");
//                        threadise .start();
//                            Track track = new Track(mmuid,downloaduri);
//                            urireference.child(mmuid).setValue(track).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    Toast.makeText(getContext(),"image is now synchronized",Toast.LENGTH_LONG).show();
//                                }
//                            });
//
//                            startActivity(processall.getInstance().getYu());
//                                            getActivity().finish();
//                        pintroaski.post(
//                                new Runnable() {
//                                    @Override
//                                    public void run() {
//
////
////                                            Toast.makeText(getActivity(),"image uploaded", Toast.LENGTH_LONG).show();
//                                    }
//                                }
//                        );

//                            All.watcher = 0;

                )
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        sendcommians.setClickable(true);
//                            progressDialog.dismiss();
//                         rotek.cancel();
//                        srending.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),"Ann failed to load", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),"please try again", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                        double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                .getTotalByteCount());
//                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                    }
                });

    }
    else {
        sendcommians.setClickable(true);
        displayo("an error just occured!");
    }
}
    public void reupdatec(){
//        answerreference.child(mmuild).setValue(answera).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()) {
//                    qquemage.post(
//                            new Runnable() {
//                                @Override
//                                public void run() {
//                                    displayo("answer image is now synchronized");
//                                }
//                            }
//                    );
//                }
//                else {
//                    qquemage.post(
//                            new Runnable() {
//                                @Override
//                                public void run() {
//                                    displayo("answer image synchronization failed");
//                                }
//                            }
//                    );
//                }
//            }
//        });

    }
    private void uploadrealImage(String pushpath, Uri imagepath, final Answer answerad) {
        if(imagepath != null)
        {
//        hand.post(new Runnable() {
//            @Override
////            public void run() {
//            rolling.setVisibility(View.VISIBLE);
//
//            rolling.startAnimation(rote);
//            srending.setText("processing Image");
//            displayo("processing might take a while");
//            }
//        });

            StorageReference ref = storageReferenced.child("realanswer"+pushpath);
            ref.putFile(imagepath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            answerworkinguri =  taskSnapshot.getUploadSessionUri();
//
                            if(answerworkinguri!=null&&answerworkingthumbline!=null){
//                                sendanswer(answerad);
                                displayo("image has been uploaded");
                            }
                            else {
                                sendcommians.setClickable(true);
                                displayo("i couldn't get upload path");
                            }
//                            Toast.makeText(getApplicationContext(),"image uploaded",Toast.LENGTH_LONG).show();
//                            relentera.startAnimation(alphyanimation);
//
//                            InnerAnswer.relentera.setVisibility(View.GONE);
//                            introaskis.setVisibility(View.VISIBLE);
//                            sendcommians.setVisibility(View.VISIBLE);
//                            srending.setText("sending...");
//                            srending.setVisibility(View.GONE);
//                            answerimage.setVisibility(View.GONE);
//                            quennys.setVisibility(View.VISIBLE);
//                            rote.cancel();
//                            rolling.setVisibility(View.GONE);
//                            InnerAnswer.animwatcher = 0;
//                            solvehwatcher = 0;
//                        answera = new Answer(downloadurid.toString(),true, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer);
//                        Thread threadise = new Thread(null, doBackgroundThreadProcessingreupdateanswer,"Background");
//                        threadise .start();

                        }
//                        }.start();

//                        String downloadurid =downloaduri.toString();
//                        quer = new question(downloadurid,totralno,true,0,0,mclass,body,coursetitle,strDate,who,time,false,false,ynumber,yemail);
//                        Thread threadise = new Thread(null, doBackgroundThreadProcessingupdatequestion,"Background");
//                        threadise .start();
//                            Track track = new Track(mmuid,downloaduri);
//                            urireference.child(mmuid).setValue(track).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    Toast.makeText(getContext(),"image is now synchronized",Toast.LENGTH_LONG).show();
//                                }
//                            });
//
//                            startActivity(processall.getInstance().getYu());
//                                            getActivity().finish();
//                        pintroaski.post(
//                                new Runnable() {
//                                    @Override
//                                    public void run() {
//
////
////                                            Toast.makeText(getActivity(),"image uploaded", Toast.LENGTH_LONG).show();
//                                    }
//                                }
//                        );

//                            All.watcher = 0;


                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
//                            progressDialog.dismiss();
//                            rotek.cancel();
                            sendcommians.setClickable(true);
//                            srending.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(),"Ann failed to load", Toast.LENGTH_LONG).show();
                            Toast.makeText(getApplicationContext(),"please try again", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
//                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });

        }
        else {
            sendcommians.setClickable(true);
            displayo("an error just occured");
        }
    }
    public void reupdate() {
        answerreference.child(mmuild).setValue(answera).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    qquemage.post(
                            new Runnable() {
                                @Override
                                public void run() {
//                                    displayo("answer image is now synchronized");
                                }
                            }
                    );
                } else {
                    qquemage.post(
                            new Runnable() {
                                @Override
                                public void run() {
//                                    displayo("answer image synchronization failed");
                                }
                            }
                    );
                }
            }
        });
    }
private Runnable doBackgroundThreadProcessingnm = new Runnable() {
    public void run() {
        loadit();
        hand.post(
          new Runnable() {
            public void run() {
                setit();
            }
            }
        );

    }
};
    private Runnable doBackgroundThreadProcessingtrack = new Runnable() {
        public void run() {

//            Beginna.resolvetracking(Fidb,innerurireference,cid);

        }
    };
    private Runnable doBackgroundThreadProcessingreupdateanswer = new Runnable() {
        public void run() {

            reupdate();

        }
    };
    public void setit(){
        if(localFile.exists()){

            Bitmap myBitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());

            qquemage.setImageBitmap(myBitmap);

        }
    }

    FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser userm = mAuth.getCurrentUser();
            if (!userm.toString().equals(null)) {
// User is signed

//               displayo(userm.getDisplayName());
                final String tyid = mAuth.getUid();
            }
        }
    };
             ValueEventListener answeristener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

//                     Thread thread = new Thread(null, doBackgroundThreadProcessinge, "Background");
//                        thread.start();
//                        senfoAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2
                && data != null && data.getData() != null ) {
//            mCurrentPhotoPath = data.getData().toString();
            filePath = data.getData();
            directuri = data.getData().toString();
            GlideApp.with(this/* context */)
                    .load(data.getData().toString())
                    .into(theimage);
            hasimagei = true;
            linsoft.setVisibility(View.VISIBLE);
            showimage.setVisibility(View.VISIBLE);
            onBackPressed();

////            fii = new File(filePath.getPath());
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filePath);
//                imagebitmap = bitmap;
//                answerimage.setImageBitmap(bitmap);
//                answerimage.setVisibility(View.VISIBLE);
//                hopeimage =1;
//                hasimagei = true;
//                sendingImage = true;
//            }

//            Thread threadis = new Thread(null, doBackgroundThreadProcessingnconvertfile,"Background");
//            threadis .start();
        } else {
//            startActivity(processall.getInstance().getYu());
//            .finish();
        }

    }

    public void sendanswer(final Answer answera, final question quere) {


//        srending.setText("sending...");
        if (confirmconnection()) {


            if(answera.isHasimage()) {

//                    answera = new Answer(timeStamp, s, d, false, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer, false, directuri, false, "", coolid);
//            answera = new Answer(timeStamp,s,d,false, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer);

            }
            else {
//                answera = new Answer(timeStamp, s, d, false, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer, false, directuri, false, "", coolid);
//            answera = new Answer(timeStamp,s,d,false, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer);
            }
            answera.setPending(false);
            answerreference.child(answera.getAnswerid()).setValue(answera).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        if(quere!=null) {
                            quere.setAnspending(false);
                            quere.setRead(false);
                            questionreference.child(quere.getQueid()).setValue(quere);
                        }
                        seeit = 0;

//                    introaskis.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            displayo(String.valueOf(iseanswer));
//                        introaskis.setText(null);
//                        displayoe("done");

                        if(answera.isHasimage()){

                        }
//                            runny.cancel();
//                        }
//                    });
//                    if (hopeimage == 1) {
//                        qquemage.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                quennys.setVisibility(View.GONE);
//                                introaskis.setVisibility(View.GONE);
//                                sendcommians.setVisibility(View.GONE);
//                            }
//                        });
//
//                        uploadImage(mmuild,secondpath);
//                    }
//                    else {
//                        relentera.startAnimation(alphyanimation);

//                        CountDownTimer gf = new CountDownTimer(1200, 200) {
//
//                            @Override
////                            public void onTick(long l) {
////
////                            }
//
//                            @Override
//                            public void onFinish() {
                        displayoe("sent");
                        sendcommians.setClickable(true);
//                        InnerAnswer.relentera.setVisibility(View.GONE);
                        introaskis.setVisibility(View.VISIBLE);
                        sendcommians.setVisibility(View.VISIBLE);
//                        srending.setText("sending...");
//                        srending.setVisibility(View.GONE);
//                        answerimage.setVisibility(View.GONE);
                        quennys.setVisibility(View.VISIBLE);
//                        rotek.cancel();


//                        rolling.setVisibility(View.GONE);
                        InnerAnswer.animwatcher = 0;
                        solvehwatcher = 0;


//                    }
//               senfoLists.add(answera);
//                    senfoAdapter.notifyDataSetChanged();
//                    updateall();
//                    startActivity(mjh);
//                    finish();


                    } else {
                        sendcommians.setClickable(true);
                        seeit = 0;
                        qquemage.post(new Runnable() {
                            @Override
                            public void run() {
                                displayo("something went wrong, I couldn\'t send your message");
                                displayo("please check your NETWORK CONNECTION");
//                                runny.cancel();
//                            srending.setVisibility(View.GONE);
                            }
                        });

                    }
                }

            });

            if (seeit == 1) {
//            CountDownTimer rewq = new CountDownTimer(20000, 321) {
//                @Override
//                public void onTick(long l) {
//
//                }
//
//                @Override
//                public void onFinish() {
                if (seeit == 1) {
//                              runny.cancel();
//                              srending.setVisibility(View.GONE);
                    qquemage.post(new Runnable() {
                        @Override
                        public void run() {
                            displayo("bad network, please check your data connection I\'m re still trying to place your request");
                            displayoe("thanks for understanding");
                        }
                    });
//
//                    }
//                }
//            }.start();

                }
            }
        }
        else {
            displayo("please ensure mobile data is on");
        }
    }





public void readeeo( final int x, final int y, final String coolid, question quere) {
//                        question quere = mDatabase.questionDao().LoadOrdinaryBycoolId(coolid);
                        if(quere!=null){
                            long timestampe =  TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                            if(x==0) {
                                quere.setNoanswer(y);
                                quere.setTimestamp(timestampe);
                                quere.setAnswered(true);
                            }
                            else{
                                if(x==1){
                                   quere.setNocomment(y);
                                  quere.setTimestamp(timestampe);
                                }
                            }
                            quere.setAnspending(true);
                            mDatabase.questionDao().updateQuestion(quere);

                        }
                    }

    private Runnable doBackgroundThreadProcessingnconvertfile = new Runnable() {
        public void run() {
            if (imagebitmap != null) {
                thirdpath = convertoofile(fii,imagebitmap);
                secondpath=   convertofile(fii, imagebitmap);
            }
        }
    };
//    private Runnale doBackgroundThreadProcessingsendanswer = new Runnable() {
//        public void run() {
//         sendanswer();
//        }
//    };

    public Uri convertofile(File file, Bitmap bit){
        Uri uri;
        file = new File(context.getCacheDir(), "images");
        try {
            file.createNewFile();
        }
        catch (Exception e){

        }
//Convert bitmap to byte array
        Bitmap bitmap = bit;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
        try {
            FileOutputStream fos = new FileOutputStream(file);

            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            uri= Uri.fromFile(file);
            uri = Uri.parse(compressImage(uri.toString()));
        }
        catch (Exception e){
//            displayo(e.toString());
            displayo("something unusual just happened, please try again");
            uri = null;
        }
        return uri;

    }
    public Uri convertoofile(File file, Bitmap bit){
        Uri uri;
        file = new File(context.getCacheDir(), "images");
        try {
            file.createNewFile();
        }
        catch (Exception e){

        }
//Convert bitmap to byte array
        Bitmap bitmap = bit;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 20 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
        try {
            FileOutputStream fos = new FileOutputStream(file);

            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            uri= Uri.fromFile(file);
            uri = Uri.parse(compressoImage(uri.toString()));
        }
        catch (Exception e){
//            displayo(e.toS);
            displayo("something just went wrong, please try again");
            uri = null;
        }
        return uri;

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
//        URL urdl = new URL(mCurrentPhotoPath);
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
        vfile = new File(context.getCacheDir(), "scaledimages");
        try {
            vfile.createNewFile();
        }
        catch (Exception e){

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
            uri= Uri.fromFile(vfile);
//            uri = Uri.parse(compressImage(uri.toString()));
        }
        catch (Exception e){
//            displayo(e.toString());
            displayo("something just went wrong, please try again");
            uri = null;
        }
        return uri.toString();
//        return filename;

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
        vfile = new File(context.getCacheDir(), "scaledimages");
        try {
            vfile.createNewFile();
        }
        catch (Exception e){

        }
//Convert bitmap to byte array
//        Bitmap bitmap = bit;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 20 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
        try {
            FileOutputStream fos = new FileOutputStream(vfile);

            fos.write(bitmapdata);
            fos.flush();
            fos.close();
            uri= Uri.fromFile(vfile);
//            uri = Uri.parse(compressImage(uri.toString()));
        }
        catch (Exception e){
//            displayo(e.toString());
            displayo("something just went wrong, please try again");
            uri = null;
        }
        return uri.toString();
//        return filename;

    }
    public static Bitmap scaleBitmap(Bitmap bitmap, int newWidth, int newHeight) {
        Bitmap scaledBitmap = Bitmap.createBitmap(newWidth, newHeight, Bitmap.Config.ARGB_8888);

        float scaleX = newWidth / (float) bitmap.getWidth();
        float scaleY = newHeight / (float) bitmap.getHeight();
        float pivotX = 0;
        float pivotY = 0;

        Matrix scaleMatrix = new Matrix();
        scaleMatrix.setScale(scaleX, scaleY, pivotX, pivotY);

        Canvas canvas = new Canvas(scaledBitmap);
        canvas.setMatrix(scaleMatrix);
        canvas.drawBitmap(bitmap, 0, 0, new Paint(Paint.FILTER_BITMAP_FLAG));

        return scaledBitmap;
    }
    public String getFilename() {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "MyFolder/Images");
        if (!file.exists()) {
            file.mkdirs();
        }
        String uriSting = (file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg");
        return uriSting;

    }


    private String getRealPathFromURI(String contentURI) {
        Uri contentUri = Uri.parse(contentURI);
        Cursor cursor = this.getContentResolver().query(contentUri, null, null, null, null);
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
    public void loadit(){
        hand.post(
                new Runnable() {
                    @Override
                    public void run() {
                       displayoe("getting image");
                    }
                }
        )     ;
        hand.post(
                new Runnable() {
                    @Override
                    public void run() {
                        rote.cancel();
                        displayoe("image download succesful");
                    }
                }
        )     ;

        storageReference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {

            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                hand.post(
                        new Runnable() {
                            @Override
                            public void run() {
                                rote.cancel();
                                displayoe("image download succesful");
                            }
                        }
                )     ;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
                hand.post(
                        new Runnable() {
                            @Override
                            public void run() {
                                rote.cancel();
                                displayo("image download failed");
                            }
                        }
                )     ;

            }
        }
        ).addOnProgressListener(new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onProgress(FileDownloadTask.TaskSnapshot taskSnapshot) {
           hand.post(
                   new Runnable() {
                       @Override
                       public void run() {

                           displayo("downloading question image");
                       }
                   }
           )     ;
            }
        });
    }
    View.OnClickListener ReloadListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (hasimage) {
                answerorquestion = 1;
                      thumblineuri =  Uri.parse(processall.getInstance().getThumblineurid());
                    downloaduri = Uri.parse(processall.getInstance().getDownloadurid());
                        if (thumbrealquestionstater == 0) {
                            if(thumblineuri!=null) {
                                storageReferencer = storage.getReference("questionimages").child(storageguy);
                                newshowit(activity,storageReferencer,qquemage);
                            }
                            if(downloaduri!=null){
                                storageReferencer = storage.getReference("questionimages").child("real"+storageguy);
                                newshowit(activity,storageReferencereal,theimage);
                            }
                        }




            }
        }
    };
    private Runnable doBackgroundThreadProcessinge = new Runnable() {
        public void run() {
//            senfoLists = Beginna.enloadInBackground(Fidb,answerreference);
//            hand.post(new Runnable() {
//                @Override
//                public void run() {
//                    senfoAdapter.notifyDataSetChanged();
//                }
//            });
        }
    };
//    private Runnable doBackgroundThreadProcessingeshowit = new Runnable() {
//        public void run() {
//            showit(downloaduri);
////            Beginna.enloadInBackground(Fidb,answerreference);
////            senfoLi
//// sts = Beginna.ananswers;
//        }
//    };
//    private Runnable doBackgroundThreadProcessinget = new Runnable() {
//        public void run() {
//          showit(downloaduri);
//        }
//    };
    @Override
    public Loader<List<Answer>> onCreateLoader(int id, Bundle args) {
        return new RealLoadAnswer(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Answer>> loader, List<Answer> data) {
//        senfoAdapter= new Answeradapter(new ArrayList<Answer>());
//        senfoAdapter.notifyDataSetChanged();
    }









//    public void showit(Uri uri){
//        if(answerorquestion == 1){
//            rollit.setVisibility(View.VISIBLE);
//            rollit.startAnimation(rote);
//        }
////        Glide.with(this /* context */)
////                .using(new FirebaseImageLoader())
////                .load(storageReference)
////                .into(qquemage);
//
//        displayo(uri.toString());
//        Glide.with(this)
////                .using(new FirebaseImageLoader())
//                .load(uri)
//                .listener(new RequestListener<Uri, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, Uri model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        rote.cancel();
//                        displayo(e.toString());
//                        displayo("failed to load");
//                        rollit.setImageResource(R.drawable.timere);
//                        sayreload.setVisibility(View.VISIBLE);
//                        rollit.setVisibility(View.GONE);
//                        answerorquestion = 0;
//                        return false;
//
//                    }
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, Uri model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
////                        rote.cancel();
//                        rote.cancel();
//                        answerorquestion = 0;
////                        displayoe("done");
//                          rollit.setVisibility(View.GONE);
////                        rollit.setVisibility(View.GONE);
////                        showrealit(downloadurid);
//                        thumbrealquestionstater = 1;
//                        return false;
//                    }
//                })
//                .into(qquemage);
//    }
//
//    public void showrealit(Uri uri){
//        if(answerorquestion == 1){
//            rollit.setVisibility(View.VISIBLE);
//            rollit.startAnimation(rote);
//        }
//        displayo(uri.toString());
////        Glide.with(this /* context */)
////                .using(new FirebaseImageLoader())
////                .load(storageReference)
////                .into(qquemage);
////        theimage.setImageDrawable(c.getDrawable());
//        Glide.with(this)
////                .using(new FirebaseImageLoader())
//                .load(uri)
//                .listener(new RequestListener<Uri, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, Uri model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        rotec.cancel();
//                        displayo(e.toString());
//                        displayo("failed to load real");
////                        theimage.setImageDrawable(c.getDrawable());
////                        .setImageResource(R.drawable.timere);
////                        theimagespinner.setVisibility(View.VISIBLE);
//                        return false;
//
//                    }
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, Uri model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        rotec.cancel();
////                        displayoe("done");
//                        theimagespinner.setVisibility(View.GONE);
//                        return false;
//                    }
//                })
//                .into(theimage);
//    }











//    public void answershowit(Uri uri, ImageView imageView){
//        Answeradapter.answersprint.setImageResource(R.drawable.spind);
//        Answeradapter.answersprint.setVisibility(View.VISIBLE);
//        Answeradapter.answersprint.startAnimation(rote);
////        Glide.with(this /* context */)
////                .using(new FirebaseImageLoader())
////                .load(storageReference)
////                .into(qquemage);
//        Glide.with(this)
////                .using(new FirebaseImageLoader())
//                .load(uri)
//                .listener(new RequestListener<Uri, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, Uri model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        rote.cancel();
//                        Answeradapter.answersprint.setImageResource(R.drawable.timer);
//                        displayo("failed to load answer image");
////                        rollit.setImageResource(R.drawable.timere);
////                        sayreload.setVisibility(View.VISIBLE);
//                        return false;
//
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, Uri model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        rote.cancel();
//
//                        Answeradapter.answersprint.setVisibility(View.GONE);
////                        rollit.setVisibility(View.GONE);
//                        displayoe("answer image is ready");
//                        return false;
//                    }
//                })
//                .into(imageView);
//    }

    @Override
    public void onLoaderReset(Loader<List<Answer>> loader) {
//        senfoAdapter = new Answeradapter( new ArrayList<Answer>());
//        senfoAdapter.notifyDataSetChanged();

    }

    View.OnClickListener allsolvehListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (solvehwatcher == 0) {
                isanswer = false;
                allsolveh.setImageResource(R.drawable.solve);
                sroveh.setVisibility(View.VISIBLE);
                sroveh.startAnimation(rotateAnimation);
                allsolveh.startAnimation(rotateAnimation);
                relecomans.setVisibility(View.VISIBLE);
                solvehwatcher = 1;
            } else {
                if (solvehwatcher == 1) {
                    introaskis.setHint("please enter your answer");
                    relentera.setVisibility(View.VISIBLE);
                    relenteraa.setVisibility(View.VISIBLE);
                    isanswer = true;
                    relentera.startAnimation(alphaAnimation);
                    answerit.scrollToPosition(senfoAdapter.getItemCount()-1);
                    relenteraa.startAnimation(alphaAnimation);
                    sroveh.setVisibility(View.GONE);
                    relecomans.setVisibility(View.GONE);
                    animwatcher = 1;
                    allsolveh.setImageResource(R.drawable.add);
                    commentwatcher = 0;
                    solvehwatcher = 0;
                    hasimagei = false;
                    directuri = null;

                }
            }
        }
    };
    View.OnClickListener imageclick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };
    public boolean confirmconnection(){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
    private Runnable doBackgroundThreadProcessingj = new Runnable() {
        public void run() {
//             Answered.InfoListsa =
//        infoAdaptera.notifyDataSetChanged();
        }
    };
    private Runnable doBackgroundThreadPrcessingu = new Runnable() {
        public void run() {
//            Unanswered.InfoListsb = Beginna.aloadInBackground(mysharedpreference,mEditor,Fidb,questionreference);
        }
    };

    View.OnClickListener sendcommiansLiatener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            double timeStamper = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
//            displayo(String.valueOf(timeStamper));
//            question crans = new question();
            if (introaskis.getText() == null || introaskis.getText().toString().equals("")) {
                displayo(" you have not provided any answer");
//          displayo(id);
            } else {
                answerbody = introaskis.getText().toString();
                queid = processall.getInstance().getQueid();

                iseanswer = isanswer;
                if (hasimagei) {
                    answerbody = theimagecaption.getText().toString();
                }
                Calendar c = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
                SimpleDateFormat sdfa = new SimpleDateFormat("h:mm a");
                strDate = sdf.format(c.getTime());
                time = sdfa.format(c.getTime());
                name = mysharedpreference.getString("username","");
                email = mysharedpreference.getString("useremail","");
                number = mysharedpreference.getString("usernumber","");
                mclassi = processall.getInstance().getUserclass();
                timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                String mmlid = answerreference.push().getKey();
                String coolid = email + String.valueOf(timeStamp)+mmlid;

                    answera = new Answer(timeStamp, s, d, false, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer, false, directuri, false, "", coolid,processall.getInstance().getCoolid(), mmlid);
//            answera = new Answer(timeStamp,s,d,false, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer);

                AppExecutor.getsInstance().networkIO().execute(
                        new Runnable() {
                            @Override
                            public void run() {
                                answera.setPending(true);
                                mDatabase.answerdao().insertAnswer(answera);
                                crans = mDatabase.questionDao().LoadOrdinaryBycoolId(processall.getInstance().getCoolid());
                                if(crans!=null) {
                                    if (isanswer) {
                                        yy = yy + 1;
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                questiono.setText(String.valueOf(yy));
                                            }
                                        });

                                        processall.getInstance().setNoanswer(String.valueOf(yy));

                                        readeeo(0, yy, crans.getCoolid(), crans);
                                    } else {
                                        zz = zz + 1;
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                commentno.setText(String.valueOf(zz));
                                            }
                                        });

                                        processall.getInstance().setNocomment(String.valueOf(zz));

                                        readeeo(1, zz, crans.getCoolid(), crans);
                                    }
                                }
                                if(confirmconnection()) {

                                    try{
                                        sendanswer(answera, crans);
                                    }
                                    catch (Exception e){
                                        displayo("encoutered an error while trying to place answer");
                                    }

                                }
                            }
                        }
                );
                if(mysharedpreference.getBoolean("soundstate",true)){
                    mediaPlayer.start();
                }
                introaskis.setText(null);
                answerit.scrollToPosition(senfoAdapter.getItemCount() - 1);

//                 name = namepro.nusername;
//                 email = namepro.nemail;
//                number = namepro.nmobile;
////                 mclassi = namepro.nclassy;
//                 queid = cid;
//                name = processall.getInstance().getUsername();
//                email = processall.getInstance().getUseremail();
//                number = processall.getInstance().getUsernumber();
//                mclassi = processall.getInstance().getUserclass();
//                iseanswer = isanswer;
//                Calendar c = Calendar.getInstance();
//                SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
//                SimpleDateFormat sdfa = new SimpleDateFormat("h:mm a");
//                 strDate = sdf.format(c.getTime());
//                 time = sdfa.format(c.getTime());
////                displayo(String.valueOf(iseanswer));
////                displayo(String.valueOf(isanswer));
//                timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
//                String coolid = email + String.valueOf(timeStamp);
//                answera = new Answer(timeStamp,"","",hasimagei, queid, mclassi, name, strDate, time, number, email, answerbody, isanswer,true, directuri, false, "",coolid);
//
//
//                onBackPressed();
//                if(confirmconnection()) {
//                    jintent.putExtra(SERVICE_TIMESTAMP, timeStamp);
//                    startService(jintent);
//                }
//                else {
//                    displayoe("mobile data seems off");
//                }
//
//                if (confirmconnection()) {
//                    sendcommians.setClickable(false);
//                    mmuild = answerreference.push().getKey();
//                    seeit = 1;
////                    movy.startAnimation(runny);
//                    srending.setVisibility(View.VISIBLE);
//
//                    if (thirdpath!=null&&thirdpath.toString().length()>1) {
//                        quennys.setVisibility(View.GONE);
//                        introaskis.setVisibility(View.GONE);
//                        sendcommians.setVisibility(View.GONE);
//                        try {
//                            uploadImage(mmuild, thirdpath);
//                        } catch (Exception e) {
//                            sendcommians.setClickable(true);
//                        }
//                    }
//                    else {
//                        try {
//                            sendanswer();
//                        }
//                        catch (Exception e){
//                            sendcommians.setClickable(true);
//                        }
////                        displayo("i couldn't get filepath");
//                    }
////                    Thread threadisey = new Thread(null, doBackgroundThreadProcessingsendanswer,"Background");
////                    threadisey .start();
//
//                }



            }
        }
};
 View.OnClickListener srovehListener = new View.OnClickListener() {
     @Override
     public void onClick(View view) {
         solvehwatcher =0;
      relentera.setVisibility(View.VISIBLE);
         isanswer = false;
         relentera.startAnimation(alphaAnimation);
         relenteraa.setVisibility(View.INVISIBLE);
         relenteraa.startAnimation(alphaAnimation);
         answerit.scrollToPosition(senfoAdapter.getItemCount()-1);
         sroveh.setVisibility(View.GONE);
         relecomans.setVisibility(View.GONE);
         allsolveh.setImageResource(R.drawable.add);
         introaskis.setHint("please enter your comment");
         animwatcher = 1;
         commentwatcher = 1;
         hasimagei = false;
         directuri = null;
         if(answerimage.getDrawable()==null){

//           directuri = null;
         }
     }
 };
    public void updateall(){
        Thread thread = new Thread(null, doBackgroundThreadProcessingj, "Background");
        thread.start();
//        Thread threade = new Thread(null, doBackgroundThreadProcessinga, "Background");
//        threade.start();
//        Thread threado = new Thread(null, doBackgroundThreadProcessingu, "Background");
//        threado.start();
    }

    @Override
    public void onBackPressed() {
        if(animwatcher ==1|| solvehwatcher==1) {
            if (InnerAnswer.animwatcher == 1) {
                InnerAnswer.relentera.startAnimation(alphyanimation);
                relenteraa.startAnimation(alphyanimation);
                allsolveh.setImageResource(R.drawable.add);
                CountDownTimer gf = new CountDownTimer(1200, 200) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        InnerAnswer.relentera.setVisibility(View.GONE);
                        relenteraa.setVisibility(View.GONE);
                        InnerAnswer.animwatcher = 0;
                        solvehwatcher = 0;

                    }
                }.start();
            }
            if (solvehwatcher == 1) {
                solvehwatcher = 0;
                relecomans.setVisibility(View.GONE);
                sroveh.startAnimation(rotateAnimation);
                sroveh.startAnimation(alphyanimation);
                allsolveh.startAnimation(alphyanimation);
                CountDownTimer gf = new CountDownTimer(1200, 200) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        sroveh.setVisibility(View.GONE);
                        allsolveh.startAnimation(alphaAnimation);
                        allsolveh.setImageResource(R.drawable.add);
                    }
                }.start();
            }
        }
        else {

            super.onBackPressed();
            finish();
            overridePendingTransition(R.transition.slide_from_left, R.transition.slide_to_right);

        }
    }
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 10: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //If user presses allow

                    displayo("permission granted");
                    chooseImage();
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
            case 12345: {
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
    public void displayo(String ji) {
        Context context = getApplicationContext();
        String msg = ji;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(getApplicationContext(), msg, duration);
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

//    @Override
//    public void hasimage(int position) {
//
//   displayo(" i can feel image files here");
//        final Answer ans = senfoLists.get(position);
//        if(ans.getDownloaduri()!=null) {
//            Answeradapter.answersprint.startAnimation(rote);
////        Thread thread = new Thread(null, new Runnable() {
////            public void run() {
//
//
////                  Toast.makeText(getApplicationContext(),"im trying to load image",Toast.LENGTH_LONG).show();
//            Uri realuri = Uri.parse(ans.getDownloaduri());
//            answershowit(realuri, Answeradapter.answerimaged);
////                }
//
//
////        }, "Background");
////
////        thread.start();
////    }
////}
//        }
//        }
//    @Override
//    public void OnRecycleViewItemclicked(int position) {
//          displayo(String.valueOf(senfoLists.get(0).isananwer()));
////          displayo(senfoLists.get(position).getQueid());
////        displayo(id);
////        displayo(String.valueOf(position));
////        displayo(String.valueOf(senfoLists.get(position).isananwer()));
//    }

}
