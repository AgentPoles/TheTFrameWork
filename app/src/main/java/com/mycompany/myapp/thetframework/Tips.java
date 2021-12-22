package com.mycompany.myapp.thetframework;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
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
import android.media.ExifInterface;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tips.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tips#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tips extends Fragment implements TipsAdapter.OnRecycleViewItemClicker{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView informs;
    static FloatingActionButton allsolve;
    Intent gintent;
    public static String TIMESTAMP_FOR_QUESTION_SERVICE;
    FirebaseDatabase fdatabase;
    static Bitmap imagebitmap;
    DatabaseReference queeren;
    long timeStampi;
    MediaPlayer mediaPlayer;
    FirebaseAuth mAuth;
    boolean prending;
    private All.onchooseImaige delta;
    public static Uri proty;
    UploadOne uploadOne;
    int permissionreadexternal, permissionmanagedocs;
    public static String directuri;
    int scrollwatcher;
    ImageView downian;
    public static boolean hasimagei;
    AppDatabase mDb;
    public static CircleImageView imageview;
    static ImageView spinnerview;
    public static File fii;

    String urithumbString;
    String realuriString;
    int stablestate;
    int yrtt = 0;
    int dabble = 0;
    TranslateAnimation grout, groin;
    CountDownTimer tt, c;
    Activity activity;
    AlphaAnimation alphyanimation;
    CountDownTimer t;
    String mclass,body,coursetitle,strDate,who,time;
    Handler hand;
    static Uri downloaduri;
    static String coolid = "";
    static String mCurrentPhotoPath;
    static List<String> isread = new ArrayList<String>();
    DatabaseReference quereference, classoreference;
    static  List<TipItem> InfoLists = new ArrayList<>();
    static TipsAdapter infoAdapter;
    String sinfoautho;
    static int actualHeight = 0;
    static int actualWidth = 0;
    static EditText pintroaski, pequenny;
    ImageView getimage;
    LoadandSave tew;
    Uri questionthumbline;
    Uri realquestionuri;
    TextView motif;
    static int seeit = 0;
    String iid;
    Classor cert;
    public static int hopeimage;
    static float TARGET_HEIGHT = 816.0f;
    static float TARGET_WIDTH = 612.0f;
    String initialmotif;
    ImageView wingy;
    String sinfobody;
    Mathmatical mathmatical;
    String ynumber, yemail;
    Context context;
    TextView trestee;
    String mmuid;
    TranslateAnimation siding;
    AlphaAnimation alphainanimation, aphaoutamination;
    DataSnapshot dfer;
    Bundle savedinstant;
    TranslateAnimation downanimation;
    String sinfotitle;
    static int watcher;
    int slidewatcher;
    View r;
    static List<String> readlist = new ArrayList<>();
    TextView ninfoauthority, ninfotitle, ninfobody, ninfodate, ninfotime;
    EditText mycommente;
    public static Uri filePath, secondpath, thirdpath;
    String att[];
    FragmentManager fm;
    FragmentTransaction ft;
    Dialog neb, ben;
    String id;
    String genid;
    Double totralno;
    TipItem quer;
    RotateAnimation rote;
    File vfile;
    SharedPreferences mysharedpreferences;
    SharedPreferences.Editor myEditor;
    FirebaseStorage storage;
    StorageReference storageReference;
    DatabaseReference urireference;
    ArrayList<String> ereadList = new ArrayList<>();
    FloatingActionButton commentredone, sendquestion;
    static RelativeLayout relenter;
    LinearLayout pequennyi;
    LoadandSave dew;
    TranslateAnimation soanimation;

    private OnFragmentInteractionListener mListener;

    public Tips() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tips.
     */
    // TODO: Rename and change types and number of parameters
    public static Tips newInstance(String param1, String param2) {
        Tips fragment = new Tips();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vo = inflater.inflate(R.layout.fragment_tips, container, false);

        context = getContext();
        hand = new Handler();
        informs = (RecyclerView)vo.findViewById(R.id.tipsview);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getContext());
//        InfoLists = ResolveList.getInstance().getAllquestions();
        infoAdapter = new TipsAdapter(InfoLists,this);
        infoAdapter.setOnItemclickedListener(this);
        scrollwatcher = 0;
        informs.setLayoutManager(mlayoutManager);
        informs.setItemAnimator(new DefaultItemAnimator());
        informs.setAdapter(infoAdapter);
        mediaPlayer = MediaPlayer.create(getActivity(),R.raw.bruteforce);
        infoAdapter.notifyDataSetChanged();
        mDb = AppDatabase.getsInstance(getContext());
        motif = (TextView)vo.findViewById(R.id.tipmotif);
        activity = getActivity();
        TIMESTAMP_FOR_QUESTION_SERVICE = "trimestamp";
        informs.setOnScrollListener(onScrollReci);
        gintent = new Intent(getActivity(),UploadOne.class);
        allsolve = (FloatingActionButton) vo.findViewById(R.id.tipsolve);
        trestee = (TextView)vo.findViewById(R.id.tiptrestee);
        trestee.setVisibility(View.GONE);
        hasimagei = false;
        slidewatcher = 0;
        permissionreadexternal   = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.READ_EXTERNAL_STORAGE);
        wingy = (ImageView)vo.findViewById(R.id.tipwingy);
        imageview = (CircleImageView)vo.findViewById(R.id.tipimagerview);
        spinnerview = (ImageView)vo.findViewById(R.id.tipimagespinner);
        relenter = (RelativeLayout)vo.findViewById(R.id.tiprelenter);
        pequennyi =(LinearLayout)vo.findViewById(R.id.tippequenny);
        downian = (ImageView)vo.findViewById(R.id.tipdownian);
        sendquestion = (FloatingActionButton)vo.findViewById(R.id.tipsendquestion);
        spinnerview.setOnClickListener(spinnerListener);
        allsolve.setOnClickListener(allsolveListener);
        stablestate = 0;
        permissionmanagedocs   = ContextCompat.checkSelfPermission(getActivity(), android.Manifest.permission.MANAGE_DOCUMENTS);
        alphyanimation = new AlphaAnimation(1,0);
        alphyanimation.setDuration(1200);
        mysharedpreferences = getActivity().getSharedPreferences("readstate",Context.MODE_PRIVATE);
        myEditor = mysharedpreferences.edit();
        soanimation = new TranslateAnimation(0,0,600,0);
        soanimation.setDuration(800);
        rote = new RotateAnimation(0,360,30,30);
        rote.setDuration(800);
        rote.setRepeatCount(999999999);
        siding = new TranslateAnimation(0,400,0,0);
        siding.setDuration(4000);
        siding.setRepeatCount(999999);
        downanimation = new TranslateAnimation(0,0,0,400);
        downanimation.setDuration(700);
//        setUpInfo();
        alphainanimation = new AlphaAnimation(1,0);
        alphainanimation.setDuration(1500);
        aphaoutamination = new AlphaAnimation(0,1);
        aphaoutamination.setDuration(1500);
        mAuth = FirebaseAuth.getInstance();
        fdatabase = FirebaseDatabase.getInstance();
        quereference = fdatabase.getReference("question");
        classoreference = fdatabase.getReference("classor");
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        queeren = fdatabase.getReference("Answers");
        urireference = fdatabase.getReference("Uris");
        quereference.keepSynced(true);
        uploadOne = new UploadOne();
        queeren.keepSynced(true);
        hopeimage = 0;
        downian.setOnClickListener(downianListener);
        this.savedinstant = savedInstanceState;
        tt = new CountDownTimer(800,200) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                scrollwatcher = 0;
                allsolve.setVisibility(View.VISIBLE);
                allsolve.startAnimation(aphaoutamination);
                InfoLists = infoAdapter.getInfoLists();
            }
        };
        sendquestion.setOnClickListener(onquestionasked);
        imageview.setVisibility(View.GONE);
        spinnerview.setVisibility(View.GONE);

        motif.setSelected(true);

//    Beginna.resolve(fdatabase,classoreference);








//    fm = getFragmentManager();
//    ft = fm.beginTransaction();
//    question tyr = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//    question tywr = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//    question tyq = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//    question tyt = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//    question tyte = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//    question tyty = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//    question tys = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//    question tyd = new question(0,0,"eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false, "08066342324", "ert@as.com");
//    question tyf = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//    question tyg = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//    question tyh = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//    question tyj = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//    question tyk = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//    InfoLists.add(tyd); InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);
//    InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);
//    InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);
//    InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);
//    InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);InfoLists.add(tyd);
//

//        InfoLists = Beginna.dee;

//    Thread thread = new Thread(null, doBackgroundThreadProcessing, "Background");
//    thread.start();


//    try {
//        att = MainActivity.loadArray("cool",getContext());
//        MainActivity.isreadlist.addAll(Arrays.asList(att));
////            displayu(String.valueOf(att.length));
////            displayo(String.valueOf(readlist.size()));
//        infoAdapter.notifyDataSetChanged();
//    }
//        catch (Exception e){
//        displayu("failed to workooo");
//        }

//          for (int i = 0; i < readlist.size(); i++) {
//              displayo(readlist.get(i));
//          }

//        displayo(String.valueOf(readlist.size()));

//    getActivity().getSupportLoaderManager().initLoader(1, null, All.this).forceLoad();
        relenter.setVisibility(View.GONE);
//    displayo(String.valueOf(Beginna.clissor.size()));
//    displayo(String.valueOf(Beginna.clissor.size()));
//    displayo(String.valueOf(Beginna.clissor.size()));

//        neb = new Dialog(getActivity());
//        neb.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        neb.setContentView(R.layout.comments);
//        Info j = new Info("use the framee","Ann");
//        InfoLists.add(j);
//        MainActivity.myBar.hide();

//        commentredone = (FloatingActionButton)neb.findViewById(R.id.commentdone);
//        commentredone.setOnClickListener(commentredoneListener);
//        mycommente = (EditText)neb.findViewById(R.id.mycomment);

//    displayo(Beginna.clissoreid);
//    displayo(Beginna.clissoreid);
//    displayo(Beginna.clissoreid);
//    displayo(Beginna.clissoreid);
//    displayo(Beginna.clissoreid);
//    displayo(Beginna.clissoreid);
        pequenny = (EditText)vo.findViewById(R.id.tipedicoursetitle);
        pintroaski = (EditText)vo.findViewById(R.id.tippintroaski);
        getimage = (ImageView)vo.findViewById(R.id.tipgetimage);
        pintroaski.addTextChangedListener(pintroaskiTextWatcher);
//    getimage.setOnClickListener(getimagenow);

        initialmotif = motif.getText().toString();
        genid = Beginna.clissoreid;
        getimage.setOnClickListener(clinkListener);
        totralno = Beginna.totalquestionno;
        mAuth.addAuthStateListener(authStateListener);
//    displayo(String.valueOf(infoAdapter.getInfoLists().size()));
        return vo;
    }
    View.OnClickListener downianListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getActivity().onBackPressed();
        }
    };


    TextWatcher pintroaskiTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (pintroaski.getText() != null && !pintroaski.getText().toString().equals("") && slidewatcher == 0) {
                sendquestion.setVisibility(View.VISIBLE);
                downian.setVisibility(View.VISIBLE);
                SlideAnimationUtil.sslideOutToRight(getActivity(), allsolve);
                SlideAnimationUtil.sslideInFromRight(getActivity(), sendquestion);
                SlideAnimationUtil.sslideInFromLeft(getActivity(), downian);
                slidewatcher = 1;
                CountDownTimer ty = new CountDownTimer(300, 300) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        sendquestion.setVisibility(View.VISIBLE);
                        downian.setVisibility(View.VISIBLE);
                        allsolve.setVisibility(View.GONE);
                    }
                }.start();
            } else {
                if (pintroaski.getText() == null || pintroaski.getText().toString().equals("") && slidewatcher == 1) {
                    allsolve.setVisibility(View.VISIBLE);
                    SlideAnimationUtil.sslideInFromRight(getActivity(), allsolve);
                    SlideAnimationUtil.sslideOutToRight(getActivity(), sendquestion);
                    SlideAnimationUtil.sslideOutToLeft(getActivity(), downian);
                    slidewatcher = 0;
                    CountDownTimer ty = new CountDownTimer(300, 300) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            sendquestion.setVisibility(View.GONE);
                            downian.setVisibility(View.GONE);
                            allsolve.setVisibility(View.VISIBLE);
                        }
                    }.start();
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    View.OnClickListener clinkListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (permissionreadexternal != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
//                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.READ_EXTERNAL_STORAGE },
                        13);

//                Toast.makeText(getActivity(), "I needs to Read external storage to process image", Toast.LENGTH_SHORT)
//                        .show();
//                }
                displayo("I need to Read external storage to process image");
            }
            else {

                mListener.onFragmentInteractione();

            }
        }
    };


    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select image file"),2);
    }


    View.OnClickListener spinnerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            imageview.setVisibility(View.GONE);
            imageview.setImageBitmap(null);
            directuri = null;
            spinnerview.setVisibility(View.GONE);
        }
    };
    FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//            FirebaseUser userm = firebaseAuth.getCurrentUser();
//            if (!userm.toString().equals(null)) {
//                final String tyid = mAuth.getUid();
//                iid = tyid;
//            }
        }
    };
//                quereference.orderByChild("timestamp").addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        mathmatical = new Mathmatical(dataSnapshot);
//                        Thread thread = new Thread(null, doBackgroundThreadProcessingallupdate, "Background");
//                        thread.start();
//                        infoAdapter.notifyDataSetChanged();
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
//            }
//        }
//    };


    private Runnable doBackgroundThreadProcessingallupdate = new Runnable() {
        public void run() {
            All.InfoLists = mathmatical.Showallquestions(mysharedpreferences,myEditor,namepro.getNclassy());
//            infoAdapter.notifyDataSetChanged();
        }
    };
//    public void setUpInfo(){
//        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
////        LiveData<List<Info>> infos = mDataBase.infoDao().LoadAllInfo();
//        viewModel.getQuestions().observe(this, new Observer<List<question>>() {
//                    @Override
//                    public void onChanged(@Nullable List<question> questions) {
////                Processors.getInstance().setInfod(infos);
//                        List<question> anquestions = new ArrayList<question>();
//                        anquestions.clear();
//                        for (int i = 0; i < questions.size(); i++) {
////                            if (questions.get(i).getMclass().equals(name)) {
////                    if (questions.get(i).isAnswered()) {
////                                    questions.get(i).setRead(Spreferences.ReadState(mysharedpreference, questions.get(i).getQueid(), myeditor, questions.get(i).getNoanswer(), questions.get(i).getNocomment()));
//                            if(questions.get(i).getMclass().equals(mysharedpreferences.getString("userclass",""))) {
//                                anquestions.add(questions.get(i));
//                            }
//                            Collections.sort(anquestions, new Comparator<question>() {
//                                @Override
//                                public int compare(question t0, question t1) {
//                                    return (int)(t1.getTimestamp()-t0.getTimestamp());
//                                }
//                            });
//
//
//                        }                                   infoAdapter.setInfoLists(anquestions);
//                        InfoLists = infoAdapter.getInfoLists();
////                    Information.InfoListsand = Processors.getInstance().getInfod();
////                    Information.infoAdapterand.notifyDataSetChanged();
//                    }
//                }
//        );
//    }
    RecyclerView.OnScrollListener onScrollReci = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (slidewatcher == 1 && watcher == 1) {

            } else {
                if (scrollwatcher == 0) {
                    allsolve.startAnimation(alphainanimation);
                    scrollwatcher = 1;
                }
                tt.cancel();
                CountDownTimer c = new CountDownTimer(680, 200) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        allsolve.setVisibility(View.GONE);
                    }
                }.start();
                tt.start();
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    };

    private Runnable doBackgroundThreadProcessing = new Runnable() {
        public void run() {
            dew.loadInBackground("cool",isread,getContext());
            StaticHolder.setIsreadList(isread);
        }
    };


    private Runnable doBackgroundThreadProcessingii = new Runnable() {
        public void run() {
//            readeeyo(quer, mmuid);
        }
    };
    public Loader<List<question>> onCreateLoader(int id, Bundle args) {
        return new  LoadAll(context);
    }
    public void onLoadFinished

            (Loader<List<question>> loader, List<TipItem> data) {
        if(data != null) {
//            displayo(String.valueOf(data.size()));
            InfoLists = data;
            infoAdapter.notifyDataSetChanged();
        }
    }


    public void onLoaderReset(Loader<List<question>> loader) {
//        infoAdapter= new QuestionAdapter(new ArrayList<question>());
        infoAdapter.notifyDataSetChanged();
    }


    //    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case 12: {
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    //If user presses allow
//                    displayo("permission granted");
//                    chooseImage();
////                    startActivity(new Intent(getActivity(),MainActivity.class));
////                    getActivity().finish();
////                    dispatchTakePictureIntent();
////                    Toast.makeText(MainActivity.this, "Permission granted!", Toast.LENGTH_SHORT).show();
////                    Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num.getText().toString()));
////                    startActivity(in);
//                } else {
//                    //If user presses deny
//                    displayo("permission denied");
////                    Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            }
//            case 14544664: {
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    //If user presses allow
//                    displayo("permission granted");
////                    dispatchTakePictureIntent();
////                    Toast.makeText(MainActivity.this, "Permission granted!", Toast.LENGTH_SHORT).show();
////                    Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + num.getText().toString()));
////                    startActivity(in);
//                } else {
//                    //If user presses deny
//                    displayo("permission denied");
////                    Toast.makeText(MainActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            }
//        }
//    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstan
//// ceState);
//        Thread thread = new Thread(null, doBackgroundThreadProcessingallupdate, "Background");
//        thread.start();
//        infoAdapter.notifyDataSetChanged();
    }



    public boolean confirmconnection(){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }


    public void readeeo() {
        Beginna.clissor.set(Beginna.classposition,cert);
        Map<String, Object> hh = new HashMap<String, Object>();
        for(int i =0; i<Beginna.clissor.size();i++) {
            hh.put(Beginna.clissorid.get(i), Beginna.clissor.get(i));
        }
        classoreference.updateChildren(hh);
    }




    View.OnClickListener onquestionasked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(pequenny.getText()==null||pequenny.getText().toString().equals("")){
                displayo("please enter course code");
            }
            else {
                if(pequenny.getText().toString().length()>6){
                    displayo("your course code should not be more than six letters");
                }
                else {
                    if (pintroaski.getText() == null || pintroaski.getText().toString().equals("")) {
                        displayo("you have not asked any question");
                    } else {

//              displayoe("your question is on its way");
                        timeStampi = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
//                  stablestate = 1;
//      trestee.setText("sending question");

//      trestee.setText(View.VISIBLE);
//      motif.setText("sending question");
                        mclass = namepro.nclassy;
                        body = pintroaski.getText().toString();
                        coursetitle = pequenny.getText().toString();
                        Calendar c = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
                        SimpleDateFormat sdfa = new SimpleDateFormat("h:mm a");
                        strDate = sdf.format(c.getTime());
                        time = sdfa.format(c.getTime());
                        who = mysharedpreferences.getString("username","");
                        ynumber = mysharedpreferences.getString("usernumber","");
                        yemail = mysharedpreferences.getString("useremail","");
                        prending = true;
                        String mmmid = quereference.push().getKey();
//      long timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());

                        coolid = yemail + String.valueOf(timeStampi)+mmmid;



                        quer = new TipItem(timeStampi, "", "", totralno, hasimagei, 0, 0, mclass, body, coursetitle, strDate, who, time, true, false, ynumber, yemail, false, prending, directuri, false, "",coolid, mmmid,false);

                        AppExecutor.getsInstance().diskIO().execute(

                                new Runnable() {
                                    @Override
                                    public void run() {
                                        quer.setPending(true);
//                                        mDb.questionDao().insertQuestion(quer);
                                    }
                                }

                        );
                        InfoLists.add(quer);
                        infoAdapter.notifyDataSetChanged();
                        if(mysharedpreferences.getBoolean("soundstate",true)) {
                            mediaPlayer.start();
                        }
                        relenter.startAnimation(alphyanimation);
                        CountDownTimer gf = new CountDownTimer(1200, 200) {
                            @Override
                            public void onTick(long l) {

                            }

                            @Override
                            public void onFinish() {
//                          InnerAnswer.rselentera.setVisibility(View.GONE);
//                          InnerAnswer.animwatcher = 0;
                                watcher =0;
                                allsolve.setVisibility(View.VISIBLE);
                                allsolve.setImageResource(R.drawable.edit);
                                relenter.setVisibility(View.GONE);
                            }
                        }.start();


                        if (confirmconnection()) {

                            if(hasimagei) {
                                mmuid = quereference.push().getKey();
                                if (filePath != null) {
                                    try {
                                        Intent jintent = new Intent(getActivity().getApplicationContext(), UploadOne.class);
                                        jintent.putExtra("coolid", coolid);
                                        if (!isMyServiceRunning(UploadOne.class)) {
//                                          displayo("started service");
                                            getActivity().startService(jintent);
                                        }

//                                  uploadImage(mmuid, thirdpath,quer);
                                    } catch (Exception e) {
                                        displayo("i encountered an error uploading your image using the service");
                                    }
                                } else {
                                    try {
//                                        askit(quer);
                                    } catch (Exception e) {

                                    }
                                }
                            }
                            else {
//                                askit(quer);
                            }


                        } else {
                            displayoe("mobile data seems off");
                            displayo("please turn it on");


                        }
                        pintroaski.setText(null);
                        pequenny.setText(null);
                        imageview.setImageBitmap(null);
                        imageview.setVisibility(View.GONE);
                        directuri = null;
                        spinnerview.setVisibility(View.GONE);
                    }
                }
            }
        }
    };
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i ("isMyServiceRunning?", true+"");
                return true;
            }
        }
        Log.i ("isMyServiceRunning?", false+"");
        return false;
    }
    public void readeeyo(question ans,String cid) {
//        quereference.child(cid).setValue(ans);
    }
    //        View.OnClickListener commentredoneListener = new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        if(mycommente.getText()==null||mycommente.getText().toString().equals("")){
//        displayo("you have not entered any comment");
//        mycommente.setHintTextColor(Color.RED);
//        mycommente.setHint("please enter your comment");
//        }
//        else{
//        displayoe("comment sent");
//        neb.cancel();
//        mycommente.setText(null);
//        }
//        }
//        };
    private void setPic() {
        // Get the dimensions of the View
        int targetW = imageview.getWidth();
        int targetH = imageview.getHeight();

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


    }



//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
////        super.onActivityResult(requestCode, resultCode, data);
//        try {
//            if (requestCode == MainActivity.TTS_DATA_CHECK) {
//                if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
//                    tts = new TextToSpeech(getActivity(), this);
//                } else {
//                    Intent installVoice = new Intent(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
//                    startActivity(installVoice);
//                }
//
//            }
//        }
//        catch (Exception e){
//
//        }
//        if (requestCode == 2
//                && data != null && data.getData() != null ) {
////          secondpath = Uri.parse(compressImage(data.getData().getPath()));
//            filePath = data.getData();
//            proty = data.getData();
//            fii = new File(filePath.getPath());
//            directuri = data.getData().toString();
//            processall.getInstance().setPothy(proty);
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePath);
//                imagebitmap = bitmap;
//                mCurrentPhotoPath = filePath.getPath();
//                displayo(mCurrentPhotoPath);
////                processall.getInstance().setPathy(data.getData().toString());
//                imageview.setImageBitmap(bitmap);
//                imageview.setVisibility(View.VISIBLE);
//                hopeimage =1;
//                hasimagei = true;
//
////                displayo(mCurrentPhotoPath);
//            }
//            catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//
//
// Thread threadis = new Thread(null, doBackgroundThreadProcessingnconvertfile,"Background");
//            threadis .start();
////            Thread threadis = new Thread(null, doBackgroundThreadProcessingnconvertfile,"Background");
////            threadis .start();
//        } else {
////            startActivity(processall.getInstance().getYu());
////            getActivity().finish();
//        }
//
//
//    }


    public void askit(question quer){
        if(quer.isHasImage()) {
            if (urithumbString != null && realuriString != null && realuriString.length() > 1) {

                quer.setThumblineuri(urithumbString);
                quer.setDownloadurid(realuriString);
                quer.setPending(false);
                quer.setRead(false);
            } else {
                quer.setPending(false);
                quer.setRead(false);
            }
        }
        else {
            quer.setPending(false);
            quer.setRead(false);
        }
        quereference.child(quer.getQueid()).setValue(quer).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    try {
                        seeit = 0;
                        sendquestion.setClickable(true);
                        displayoe("question asked");
//
                        hopeimage = 0;

                    }
                    catch (Exception e){

                    }

//                  infoAdapter.notifyDataSetChanged();


//                                  }
//                              });

//                          }
//                      }.start();
//                  }
//                  else {
//                      pintroaski.post(
//                              new Runnable() {
//                                  @Override
//                                  public void run() {
//                  displayo("your question has been asked");
//                                  }
//                              }
//                      );
//                        informs.setClickable(true);

//                      CountDownTimer gf = new CountDownTimer(800, 500) {
//                          @Override
//                          public void onTick(long l) {
//
//                          }
//
//                          @Override
//                          public void onFinish() {
//                              pintroaski.post(new Runnable() {
//                                  @Override
//                                  public void run() {
//                                      infoAdapter.notifyDataSetChanged();
                    All.relenter.setVisibility(View.GONE);

//                                        trestee.setText("loading image");
                    All.watcher = 0;
//                                      startActivity(processall.getInstance().getYu());
//                                      All.this.getActivity().finish();
//                                  }
//                              });

//                          }
//                      }.start();
                    stablestate = 0;
                } else {
                    seeit = 0;
                    stablestate =0;
//                  informs.setClickable(true);
//                  pintroaski.post(
//                          new Runnable() {
//                              @Override
                    sendquestion.setClickable(true);
//                              public void run() {
//                                  trestee.setVisibility(View.GONE);
//                                  siding.cancel();
                    displayo("something went wrong, I couldn't ask your question");
                    displayo("please check your NETWORK CONNECTION");
//                              }
//                          }
//                  );


                }
            }

        });
        if (seeit == 1) {
//          CountDownTimer rewq = new CountDownTimer(20000, 321) {
//              @Override
//              public void onTick(long l) {
//
//              }
//
            stablestate = 0;
            sendquestion.setClickable(true);
//              @Override
//              public void onFinish() {
//                  if (seeit == 1) {
//                                  siding.cancel();
//                                  trestee.setVisibility(View.GONE);
            pintroaski.post(
                    new Runnable() {
                        @Override
                        public void run() {
                            displayo("bad network, please check your data connection I\'m re still trying to ask your question");
                            displayoe("thanks for understanding");
                        }
                    }
            );
        }

    }
    public void askitwithimage(){
//      long timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
//      stablestate = 1;
////      trestee.setText("sending question");
//      String coolid = "";
////      trestee.setText(View.VISIBLE);
////      motif.setText("sending question");
//      mclass = namepro.nclassy;
//      body = pintroaski.getText().toString();
//      coursetitle = pequenny.getText().toString();
//      Calendar c = Calendar.getInstance();
//      SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
//      SimpleDateFormat sdfa = new SimpleDateFormat("h:mm a");
//      strDate = sdf.format(c.getTime());
//      time = sdfa.format(c.getTime());
//      who = processall.getInstance().getUsername();
//      ynumber = processall.getInstance().getUsernumber();
//      yemail = processall.getInstance().getUseremail();
//      prending = true;
//
////      //      long timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());  if(processall.getInstance().getUseremail()!=null){
////          coolid = processall.getInstance().getUseremail() + String.valueOf(timeStampi);
////      }
////      else {
////          coolid = mysharedpreferences.getString("useremail","")+String.valueOf(timeStampi);
////      }
//
////      quer = new question(timeStampi, "", "", totralno, hasimagei, 0, 0, mclass, body, coursetitle, strDate, who, time, true, false, ynumber, yemail, false, prending, directuri, false, "",coolid);
//
////                  quer = new question(13242,"dfrettet","rtrtrtr",35355.00,true,0,0,"dggg","ettetete","twwttwtw","wwrrwrw","uruurur","wrwrwr",false,false,"ette","dggd",false, true);
//
////      motif.setVisibility(View.GONE);
////      realquestionuri = questionthumbline;
//      if(questionthumbline!=null&&realquestionuri!=null) {
//          urithumbString = questionthumbline.toString();
//          realuriString = realquestionuri.toString();
//      }
//      totralno = Beginna.totalquestionno;
//      totralno = totralno+1;
//      if(processall.getInstance().getUseremail()!=null){
//          coolid = processall.getInstance().getUseremail() + String.valueOf(timeStampi);
//      }
//      else {
//          coolid = mysharedpreferences.getString("useremail","")+String.valueOf(timeStampi);
//      }


        if(urithumbString!=null&&realuriString!=null&&realuriString.length()>1){
//          double timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            quer.setThumblineuri(urithumbString);
            quer.setDownloadurid(realuriString);
            quer.setPending(false);
//          quer = new question(timeStampi,realuriString,urithumbString, totralno, hasimagei, 0, 0, mclass, body, coursetitle, strDate, who, time, false, false, ynumber, yemail, false, false, directuri, false, "",coolid);
//          quer = new question(timeStamp,realuriString,urithumbString,totralno,true,0,0,mclass,body,coursetitle,strDate,who,time,false,false,ynumber,yemail,false,true);
        }
        else {
            quer.setPending(false);
//          double timeStamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
//          quer = new question(timeStampi, "", "", totralno, hasimagei, 0, 0, mclass, body, coursetitle, strDate, who, time, false, false, ynumber, yemail, false,false, directuri, false, "",coolid);
//          quer = new question(timeStamp,"","",totralno, false, 0, 0, mclass, body, coursetitle, strDate, who, time, false, false, ynumber, yemail,false, true);
        }


        seeit = 1;

//      cert = Beginna.clissor.get(Beginna.classposition);
//      cert.setValue(totralno);

        quer.setQueid(mmuid);
        quereference.child(mmuid).setValue(quer).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    seeit = 0;
                    sendquestion.setClickable(true);
                    displayoe("question asked");
//                  Thread threadw = new Thread(null, doBackgroundThreadProcessingallupdate, "Background");
//                  threadw.start();
//                              trestee.setVisibility(View.GONE);
//                  motif.setVisibility(View.VISIBLE);
//                 pintroaski.post(new Runnable() {
//                     @Override
//                     public void run() {
//                  pintroaski.setText(null);

//                  pequenny.setText(null);
//                      siding.cancel();
//                  All.relenter.startAnimation(downanimation);
//                  motif.setText(initialmotif);
//                  motif.setSelected(true);

//                 }) ;
//                  cert = Beginna.clissor.get(Beginna.classposition);
//                  cert.setValue(totralno);
//                  Thread thread = new Thread(null, doBackgroundThreadProcessingncm, "Background");
//                  thread.start();


//                              FragmentManager fn = getFragmentManager();
//                  if(hopeimage ==1) {
//                      pintroaski.post(new Runnable() {
//                          @Override
//                          public void run() {
//                  displayoe("your question has been asked now processing image");
//                          }
//                      });

                    hopeimage = 0;

//                                quer.setHasImage(true);
//                                File compressedfile = PhotoCompressor(fii);
//                                filePath = compressedfile.get

//                                Thread threadmn= new Thread(null, doBackgroundThreadProcessingii, "Background");
//                                threadmn.start();
//                      CountDownTimer gf = new CountDownTimer(800, 500) {
//                          @Override
//                          public void onTick(long l) {
//
//                          }
//
//                          @Override
//                          public void onFinish() {

//                                      All.relenter.setVisibility(View.GONE);
//                              pintroaski.post(new Runnable() {
//                                  @Override
//                                  public void run() {

                    infoAdapter.notifyDataSetChanged();


//                                  }
//                              });

//                          }
//                      }.start();
//                  }
//                  else {
//                      pintroaski.post(
//                              new Runnable() {
//                                  @Override
//                                  public void run() {
//                  displayo("your question has been asked");
//                                  }
//                              }
//                      );
//                        informs.setClickable(true);

//                      CountDownTimer gf = new CountDownTimer(800, 500) {
//                          @Override
//                          public void onTick(long l) {
//
//                          }
//
//                          @Override
//                          public void onFinish() {
//                              pintroaski.post(new Runnable() {
//                                  @Override
//                                  public void run() {
//                                      infoAdapter.notifyDataSetChanged();
                    All.relenter.setVisibility(View.GONE);

//                                        trestee.setText("loading image");
                    All.watcher = 0;
//                                      startActivity(processall.getInstance().getYu());
//                                      All.this.getActivity().finish();
//                                  }
//                              });

//                          }
//                      }.start();
                    stablestate = 0;
                } else {
                    seeit = 0;
                    stablestate =0;
//                  informs.setClickable(true);
//                  pintroaski.post(
//                          new Runnable() {
//                              @Override
                    sendquestion.setClickable(true);
//                              public void run() {
//                                  trestee.setVisibility(View.GONE);
//                                  siding.cancel();
                    displayo("something went wrong, I couldn't ask your question");
                    displayo("please check your NETWORK CONNECTION");
//                              }
//                          }
//                  );


                }
            }

        });
        if (seeit == 1) {
//          CountDownTimer rewq = new CountDownTimer(20000, 321) {
//              @Override
//              public void onTick(long l) {
//
//              }
//
            stablestate = 0;
            sendquestion.setClickable(true);
//              @Override
//              public void onFinish() {
//                  if (seeit == 1) {
//                                  siding.cancel();
//                                  trestee.setVisibility(View.GONE);
            pintroaski.post(
                    new Runnable() {
                        @Override
                        public void run() {
                            displayo("bad network, please check your data connection I\'m re still trying to ask your question");
                            displayoe("thanks for understanding");
                        }
                    }
            );
        }

    }


//    private Runnable doBackgroundThreadProcessingnask = new Runnable() {
//    public void run() {
//
//        askit();
//    }
//};

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
//       displayo(e.toString());

            displayo("something just went wrong please try again");
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
//            displayo(e.toString());

            displayo("something just went wrong please try again");
            uri = null;
        }
        return uri;

    }

    private Runnable doBackgroundThreadProcessingnm = new Runnable() {
        public void run() {

            readeeo();
        }
    };

    private  Runnable doBackgroundThreadProcessingnconvertfile = new Runnable() {
        public void run() {
            if (mCurrentPhotoPath != null) {

                thirdpath = convertoofile(fii,imagebitmap);
                secondpath = convertofile(fii,imagebitmap);
//             secondpath =   Uri.parse(compressImage(mCurrentPhotoPath));
            }
        }
    };

    private Runnable doBackgroundThreadProcessingncm = new Runnable() {
        public void run() {


            changeit();
        }
    };
    private Runnable doBackgroundThreadProcessingupdatequestion = new Runnable() {
        public void run() {


            quereference.child(mmuid).setValue(quer).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
//                    Toast.makeText(getContext(),"image is now synchronized",Toast.LENGTH_LONG).show();
                }
            });

        }
    };



    public void changeit() {

//        if (Beginna.clissoreid != (null)) {
//            classoreference.child(Beginna.clissoreid).setValue(cert);
//        }
    }

    private void uploadImage(String push, Uri uri, final question querec) {

        if(uri != null)
        {
//      trestee.setVisibility(View.VISIBLE);

            stablestate = 1;
//
//   final ProgressDialog progressDialog = new ProgressDialog(getActivity());
//            progressDialog.setTitle("Uploading...");
//
//           progressDialog.show();

//            pintroaski.setVisibility(View.GONE);
//            pequenny.setVisibility(View.GONE);
//            sendquestion.setVisibility(View.GONE);
//            wingy.setVisibility(View.GONE);
//
//           motif.setVisibility(View.GONE);

//            pequennyi.setVisibility(View.GONE);
//            spinnerview.setVisibility(View.VISIBLE);
//            spinnerview.startAnimation(rote);
//            motif.setText("procesing image");
//            trestee.setVisibility(View.GONE);

            StorageReference ref = storageReference.child(push);
            ref.putFile(uri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            progressDialog.dismiss();
                            questionthumbline =  taskSnapshot.getUploadSessionUri();
                            displayoe("successfully loaded thumbline");
                            if(secondpath!=null) {

                                uploadrealImage(mmuid, secondpath,querec);
//                                askit();
                            }
                            else {
                                sendquestion.setClickable(true);
                                displayo(" sorry dear, something just went wrong with image processing");
                                displayoe("i will ssk your question anyways");
                            }
//                            trestee.setVisibility(View.GONE);
//                            All.relenter.setVisibility(View.GONE);
//                            pintroaski.setVisibility(View.VISIBLE);
//                            pequenny.setVisibility(View.VISIBLE);
//                            sendquestion.setVisibility(View.VISIBLE);
//                            wingy.setVisibility(View.VISIBLE);
//                            rote.cancel();
//                            spinnerview.setVisibility(View.GONE);
//                            motif.setVisibility(View.VISIBLE);
//                            pequennyi.setVisibility(View.VISIBLE);
//                            trestee.setVisibility(View.GONE);
//                            trestee.setText("sending..");
//                            Toast.makeText(getContext(),"image uploaded",Toast.LENGTH_LONG).show();
////                            displayoe("image uploaded");
//                            String downloaduridthumb =downloaduri.toString();
//                            quer = new question("",downloaduridthumb,totralno,true,0,0,mclass,body,coursetitle,strDate,who,time,false,false,ynumber,yemail);
//                            Thread threadise = new Thread(null, doBackgroundThreadProcessingupdatequestion,"Background");
//                            threadise .start();
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
//                            pintroaski.post(
//                                    new Runnable() {
//                                        @Override
//                                        public void run() {
//
////
////                                            Toast.makeText(getActivity(),"image uploaded", Toast.LENGTH_LONG).show();
//                                        }
//                                    }
//                            );

//                            All.watcher = 0;

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
//                            progressDialog.dismiss();
//                            informs.setClickable(true);
                            stablestate = 0;
//                              trestee.setVisibility(View.GONE);
//                            rote.cancel();
//                            sendquestion.setClickable(true);
//                            trestee.setVisibility(View.GONE);
//                            spinnerview.setVisibility(View.GONE);
                            Toast.makeText(getActivity(),e.toString(), Toast.LENGTH_LONG).show();
                            Toast.makeText(getActivity(),"something went wrong , Ann failed to load thumbline", Toast.LENGTH_LONG).show();
                            Toast.makeText(getActivity(),"please try to ask your question again", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            if(dabble!=(int)progress) {
                                dabble = (int) progress;

//                                trestee.setText(String.valueOf(dabble) + "%");
                            }
                            else {

                            }
//                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });

        }
        else {
            stablestate = 0;

//            trestee.setVisibility(View.GONE);
//            sendquestion.setClickable(true);

//            informs.setClickable(true);
            displayo("something just went wrong please try again");
            displayo("uri path for thumbline is null");
        }
    }
    private void uploadrealImage(String push, Uri uri, final question querec) {
        if(uri != null)
        {
//            final ProgressDialog progressDialog = new ProgressDialog(getActivity());
//            progressDialog.setTitle("Uploading...");
//            progressDialog.show();
//            trestee.setVisibility(View.VISIBLE);

            stablestate = 1;

            StorageReference ref = storageReference.child("real"+push);
            ref.putFile(uri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            progressDialog.dismiss();
                            displayoe("successfully loaded real");
                            realquestionuri =  taskSnapshot.getUploadSessionUri();
                            askit(querec);
//                            rote.cancel();
//                            trestee.setVisibility(View.GONE);
//                            spinnerview.setVisibility(View.GONE);
//
//    spinnerview.startAnimation(rote);
//                            trestee.setText("sending question");
//                            trestee.setVisibility(View.VISIBLE);

//                            All.relenter.setVisibility(View.GONE);
//                            pintroaski.setVisibility(View.VISIBLE);
//                            pequenny.setVisibility(View.VISIBLE);
//                            sendquestion.setVisibility(View.VISIBLE);
//                            wingy.setVisibility(View.VISIBLE);
//                            rote.cancel();
//                            spinnerview.setVisibility(View.GONE);
//                            motif.setVisibility(View.VISIBLE);
//                            pequennyi.setVisibility(View.VISIBLE);
//                            trestee.setVisibility(View.GONE);
//                            trestee.setText("sending..");
//
//   Toast.makeText(getContext(),"image uploaded",Toast.LENGTH_LONG).show();

//                            displayoe("image uploaded");

//                            askit();
//                            String downloaduridthumb =downloaduri.toString();
//                            quer = new question("",downloaduridthumb,totralno,true,0,0,mclass,body,coursetitle,strDate,who,time,false,false,ynumber,yemail);
//                            Thread threadise = new Thread(null, doBackgroundThreadProcessingupdatequestion,"Background");
//                            threadise .start();
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
//                            pintroaski.post(
//                                    new Runnable() {
//                                        @Override
//                                        public void run() {
//
////
////                                            Toast.makeText(getActivity(),"image uploaded", Toast.LENGTH_LONG).show();
//                                        }
//                                    }
//                            );

//                            All.watcher = 0;

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
//                            trestee.setVisibility(View.GONE);
//
                            displayo(" i encoutered a problem uploading image");
                            displayoe("i will ask your question anyway");
//  progressDialog.dismiss();
//                            informs.setClickable(true);

//                            rote.cancel();
//                            sendquestion.setClickable(true);
//                            trestee.setVisibility(View.GONE);
//                            spinnerview.setVisibility(View.GONE);

                            stablestate = 0;

                            Toast.makeText(getActivity(),e.toString(), Toast.LENGTH_LONG).show();
                            Toast.makeText(getActivity(),"something just went wrong, Ann failed to load realimagebline", Toast.LENGTH_LONG).show();
                            Toast.makeText(getActivity(),"please try to ask your question again again", Toast.LENGTH_LONG).show();
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

        }
        else {
            stablestate = 0;

//            trestee.setVisibility(View.GONE);
//
// informs.setClickable(true);

//
//           sendquestion.setClickable(true);
            displayo("something just went wrong please try again");
        }
    }

    public interface onchooseImaige{
        public void chooseImage();
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof All.OnFragmentInteractionListener) {
//            mListener = (All.OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    View.OnClickListener allsolveListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(watcher==0) {
                relenter.setVisibility(View.VISIBLE);
                relenter.startAnimation(soanimation);

                if (imageview.getDrawable() == null) {
                    directuri = null;
                    hasimagei = false;
                }
                watcher = 1;
                allsolve.setImageResource(R.drawable.ic_downian);
                if (pintroaski.getText() != null && !pintroaski.getText().toString().equals("")) {
                    SlideAnimationUtil.slideOutToRight(getActivity(),allsolve);
                    CountDownTimer ty = new CountDownTimer(300, 300) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            allsolve.setVisibility(View.GONE);
                        }
                    }.start();
                }
            }
            else {
                if(watcher ==1){
                    getActivity().onBackPressed();
//                allsolve.setImageResource(R.drawable.edit);
                }
            }
        }
    };
    //public String[] loadArray(String arrayName, Context mContext) {
//        SharedPreferences prefs = mContext.getSharedPreferences(arrayName, 0);
//        int size = prefs.getInt(arrayName + "_size", 0);
////            displayoe(String.valueOf(size));
//        String array[] = new String[size];
//        for(int i=0;i<size;i++) {
//        array[i] = prefs.getString(array
// Name + "_" + i, null);
////                displayu(array[i]);
//
//        }
////            displayu(String.valueOf(size));
//        return array;
//        }
//public boolean saveArray(String[] array, String arrayName, Context mContext) {
//        SharedPreferences prefs = mContext.getSharedPreferences(arrayName, 0);
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putInt(arrayName +"_size", array.length);
//        for(int i=0;i<array.length;i++) {
//        editor.putString(arrayName + "_" + i, array[i]);
////            displayu(array[i]);
//        }
//        return editor.commit();
//        }
//        View.OnClickListener commentListener = new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        /*    r = view;
//            sinfoautho = "The Founding Father Abboyz..";
//            sinfobody = "Abboyz is making the Price of their PureWater #170 per bag Due to Logistics in Home DElivery";
//            sinfotitle = "Abboyz is making the Price of their PureWater #170";
//            Info info = new Info(sinfotitle,sinfoautho);
//            InfoLists.add(info);
//            infoAdapter.notifyDataSetChanged();*/
//        neb.show();
//
//        }
//        };
//public static void update(){
//        InfoLists = MainActivity.enfo;
//        infoAdapter.notifyDataSetChanged();
//
//        }
//// TODO: Rename method, update argument and hook method into UI event
//public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//        mListener.onFragmentInteraction(uri);
//        }
//        }
    public File PhotoCompressor(File photoFile) {
        Bitmap b = BitmapFactory.decodeFile(photoFile.getAbsolutePath());


        int originalWidth = b.getWidth();
        int originalHeight = b.getHeight();
        int boundWidth = 1280;
        int boundHeight = 700;
        int newWidth = originalWidth;
        int newHeight = originalHeight;

        //check if the image needs to be scale width
        if (originalWidth > boundWidth) {
            //scale width to fit
            newWidth = boundWidth;
            //scale height to maintain aspect ratio
            newHeight = (newWidth * originalHeight) / originalWidth;
        }

        //now check if we need to scale even the new height
        if (newHeight > boundHeight) {
            //scale height to fit instead
            newHeight = boundHeight;
            //scale width to maintain aspect ratio
            newWidth = (newHeight * originalWidth) / originalHeight;
        }
//    Log.i(TAG, "Original Image:" + originalHeight + " x" + originalWidth);
//    Log.i(TAG, "New Image:" + newHeight + " x" + newWidth);
        try {
            Bitmap out = Bitmap.createScaledBitmap(b, newWidth, newHeight, true);
            FileOutputStream fOut;
            fOut = new FileOutputStream(photoFile);
            out.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            b.recycle();
            out.recycle();
        } catch (OutOfMemoryError exception) {
//        Log.e(TAG, "OutofMemory excpetion" + exception);
            exception.printStackTrace();
        } catch (FileNotFoundException e) {
//        Log.e(TAG, "File not found excpetion" + e);
            e.printStackTrace();
        } catch (IOException e) {
//        Log.e(TAG, "IO exception excpetion" + e);
            e.printStackTrace();
        }
        return photoFile;
    }
    public void imagekeepWorking(String url){
        try {
            FileOutputStream output = getActivity().openFileOutput("unscaled", context.MODE_PRIVATE);

            URLConnection openConnection = new URL(url).openConnection();
            openConnection.connect();
            InputStream inputStream = openConnection.getInputStream();

            byte[] buffer = new byte[1024];
            for (int n = inputStream.read(buffer); n >= 0; n = inputStream.read(buffer))
                output.write(buffer, 0, n);
            output.flush();
            output.close();
            inputStream.close();
        }
        catch (Exception e){

        }
    }
    public void displayo(String ji) {
        Context context = getContext();
        String msg = ji;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(getContext(), msg, duration);
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
        Context context = getContext();
        String msg = ji;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(getContext(), msg, duration);
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

    @Override
    public void OnRecycleViewItemclicked(int position) {
//    displayo(String.valueOf(position));
//    displayo(String.valueOf(position));

//    displayo(id);
//    displayo(id);
//    if(!isread.contains(String.valueOf(position))) {
//        isread.add(String.valueOf(position));
////        info.setRead(true);
//        tew = new LoadandSave("cool",isread,getContext());
//        Thread thread = new Thread(null, doBackgroundoThreadProcessing, "Background");
//        thread.start();
//        infoAdapter.notifyDataSetChanged();

//        boolean rt = MainActivity.saveArray(asd, "cool", getContext());
//    }
//            displayoe(String.valueOf(rt));
        if(stablestate==0) {
            final TipItem tyu = infoAdapter.getInfoLists().get(position);
            id = tyu.getQueid();
            tyu.setRead(true);
            tyu.setPending(tyu.isPending());
            AppExecutor.getsInstance().diskIO().execute(
                    new Runnable() {
                        @Override
                        public void run() {
//                            mDb.questionDao().updateQuestion(tyu);
                        }
                    }
            );
            Intent urix = new Intent(getActivity(), InnerAnswer.class);
//        if(mCurrentPhotoPath!=null) {
//            processall.getInstance().setPathy(mCurrentPhotoPath);
//        }

            processall.getInstance().setWho(tyu.getWho());
            processall.getInstance().setBody(tyu.getBody());
            processall.getInstance().setDate(tyu.getDate());
            processall.getInstance().setPending(tyu.isPending());
            processall.getInstance().setTime(tyu.getTime());
            processall.getInstance().setQueid(id);
            processall.getInstance().setHasImage(tyu.isHasImage());
//        Thread thread = new Thread(null, doBackgroundThreadProcessinge, "Background");
//        thread.start();
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
//    urix.putExtra("sender",1);

            startActivityForResult(urix, 1);
            getActivity().overridePendingTransition(R.transition.slide_from_right, R.transition.slide_to_left);
        }
        else {

        }
//        Info info = InfoLists.get(position);
//        ninfobody.setText(info.getBody());
//        ninfotitle.setText(info.getTitle());
//        ninfoauthority.setText(info.getAuthority());
//        ninfodate.setText(info.getDate());
//        ninfotime.setText(info.getTime());
//        if(readlist.contains(String.valueOf(position))){
//
//        }
//        else {
//        readlist.add(String.valueOf(position));
////        info.setRead(true);
//        infoAdapter.notifyDataSetChanged();
//
//    String[] asd = readlist.toArray(new String[0]);
//
//        boolean rt = saveArray(asd, "cool", getContext());
////            displayoe(String.valueOf(rt));
//        }
//        ben.show();
    }
//    private Runnable doBackgroundThreadProcessinge = new Runnable() {
//        public void run() {
//            InnerAnswer.senfoLists = Beginna.enloadInBackground(fdatabase,queeren);
//        }
//    };



    //    private void startPosting(Bitmap bmp) {
//        byte[] data = bmp.toByteArray();
////        mProgress.setMessage("Uploading Image...");
//
//        final String title_val = mPostTitle.getText().toString().trim();
//        final String desc_val = mPostDesc.getText().toString().trim();
//        if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val) && filePath != null) {
//            mProgress.show();
//            StorageReference filepath = storageReference.child("questionimages").child(uri_image_final.getLastPathSegment());
//
//
//            UploadTask uploadTask = filepath.putBytes(data);
//            uploadTask.addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception exception) {
//                    // Handle unsuccessful uploads
//                }
//            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//                    Uri downloadUri = taskSnapshot.getDownloadUrl();
////                    DatabaseReference newPost = mDatabase.push();
////                    DatabaseReference c = mDatabase.push();
////                    newPost.child("EventTitle").setValue(title_val);
////                    newPost.child("EventDescription").setValue(desc_val);
////                    newPost.child("EventImage").setValue(downloadUri.toString());
////                    newPost.child("PostId").setValue(c);
//
//
//
////                    mProgress.dismiss();
////                    startActivity(new Intent(PostActivity.this, MainActivity.class));
//
//
//                }
//            });
//
//
//        } else if (TextUtils.isEmpty(title_val) && TextUtils.isEmpty(desc_val) && imageUri != null) {
//            mProgress.show();
//            StorageReference filepath = storageReference.child("questionimages").child(uri_image_final.getLastPathSegment());
//            UploadTask uploadTask = filepath.putBytes(data);
//            uploadTask.addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception exception) {
//                    // Handle unsuccessful uploads
//                }
//            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//                    Uri downloadUri = taskSnapshot.getDownloadUrl();
////                    DatabaseReference newPost = mDatabase.push();
////                    newPost.child("EventTitle").setValue("");
////                    newPost.child("EventDescription").setValue("");
////                    newPost.child("EventImage").setValue(downloadUri.toString());
//
//
////                    mProgress.dismiss();
////                    // startActivity(new Intent(PostActivity.this, MainActivity.class));
////                    Intent load=  new Intent(PostActivity.this,MainActivity.class);
////                    load.putExtra(eventname,eventname);
////                    startActivity(load);
//
//
//                }
//            });
//
//        }
//
//        else if (!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desc_val) && imageUri== null){
//
//            Toast.makeText(getApplicationContext(),"Please insert an Image and Upload ! ",Toast.LENGTH_LONG).show();
//
//        }
//    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


//    @Override
//    public void doinputstream(){
//try {
//
//    Bitmap img = BitmapFactory.decodeStream(is, null, options);
////        DOESN'T WORK
//
//    InputStream is = connection.getInputStream();
//    Bitmap img = BitmapFactory.decodeStream(is, null, options);
//
//    InputStream is = connection.getInputStream();
//
//    BitmapFactory.Options options = new BitmapFactory.Options();
//    options.inJustDecodeBounds = true;
//
//    BitmapFactory.decodeStream(is, null, options);
//
//    Boolean scaleByHeight = Math.abs(options.outHeight - TARGET_HEIGHT) >= Math.abs(options.outWidth - TARGET_WIDTH);
//
//    if (options.outHeight * options.outWidth * 2 >= 200 * 100 * 2) {
//        // Load, scaling to smallest power of 2 that'll get it <= desired dimensions
//        double sampleSize = scaleByHeight
//                ? options.outHeight / TARGET_HEIGHT
//                : options.outWidth / TARGET_WIDTH;
//        options.inSampleSize =
//                (int) Math.pow(2d, Math.floor(
//                        Math.log(sampleSize) / Math.log(2d)));
//    }
//
//// Do the actual decoding
//    options.inJustDecodeBounds = false;
//}
//catch (Exception e){
//
//}
////        Bitmap img = BitmapFactory.decodeStream(is, null, options);
//    }
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public String workonbitmap(String path){
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            InputStream is = connection.getInputStream();

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;

            BitmapFactory.decodeStream(is, null, options);

            Boolean scaleByHeight = Math.abs(options.outHeight - TARGET_HEIGHT) >= Math.abs(options.outWidth - TARGET_WIDTH);

            if (options.outHeight * options.outWidth * 2 >= 200 * 200 * 2) {
                // Load, scaling to smallest power of 2 that'll get it <= desired dimensions
                double sampleSize = scaleByHeight
                        ? options.outHeight / TARGET_HEIGHT
                        : options.outWidth / TARGET_WIDTH;
                options.inSampleSize =
                        (int) Math.pow(2d, Math.floor(
                                Math.log(sampleSize) / Math.log(2d)));
            }

            // Do the actual decoding
            options.inJustDecodeBounds = false;

            is.close();
//            Bitmap img = BitmapFactory.decodeStream(is, null, options);
//            is.close();
        }
        catch (Exception e){

        }
        return  null;
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
            displayo("something just went wrong please try again");
//            displayo("failed already");
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
        Cursor cursor = getActivity().getContentResolver().query(contentUri, null, null, null, null);
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
//        View.OnScrollChangeListener scrollChangeListener = new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
//           if(yrtt==2){
//               sendquestion.startAnimation(alphainanimation);
//               yrtt = 0;
//           }
//                if(t!=null){t.cancel();}
//                t = new CountDownTimer(2000,1000) {
//                    @Override
//                    public void onTick(long l) {
//
//                    }
//
//                    @Override
//                    public void onFinish() {
//   yrtt = 2;
//                        sendquestion.startAnimation(aphaoutamination);
//                    }
//                }.start();
//            }
//        };

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
            displayo("something just went wrong please try again");
//            displayo("failed already");
            uri = null;
        }
        return uri.toString();
//        return filename;

    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public void displayu(String ki){
        Toast.makeText(getContext(),ki,Toast.LENGTH_LONG).show();
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteractione();
    }
}
