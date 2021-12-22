package com.mycompany.myapp.thetframework;



import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

public class Intro extends AppCompatActivity {

    LinearLayout beginners, poles;
    TranslateAnimation startu, poleupe, poledowne, transcont;
    AlphaAnimation goin, comeout;
    ScaleAnimation maryscaleup, maryscaledown;
    Processors processors;
    static List<Folders> folderss = new ArrayList<Folders>();
    Intent mfra,hjn;
 namepro naem;

    FirebaseAuth mAuthb;
    FirebaseDatabase mrdatabase;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser mFirebaseUser;
    FirebaseDatabase ree;
    namepro userdetails;
    DatabaseReference lee;
    String classname;
    Intent hj;
    DatabaseReference Usery;
     List<question> firstSetOfQuestions;
    DatabaseReference classor;
    AppDatabase mDb;
    Mathmatical mathmatical;
    SharedPreferences mysharedpreferences;
    SharedPreferences.Editor myeditor;
  Handler handler;
    TextView maary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mrdatabase = FirebaseDatabase.getInstance();
        hjn = new Intent(Intro.this, DoFirst.class);
        mysharedpreferences = getSharedPreferences("readstate",MODE_PRIVATE);
        myeditor = mysharedpreferences.edit();
        lee = mrdatabase.getReference("question");

        classor = mrdatabase.getReference("classor");
        Usery = mrdatabase.getReference("Users");
        mDb = AppDatabase.getsInstance(getApplicationContext());
        handler = new Handler();
        firstSetOfQuestions = new ArrayList<>();
        processors = Processors.getInstance();
        myeditor.putBoolean("firsttime",true);
        myeditor.apply();
        classname = mysharedpreferences.getString("classre",null);
        processall.getInstance().setNemail(mysharedpreferences.getString("useremail",null));
        processall.getInstance().setNname(mysharedpreferences.getString("username",null));
       final Folders fold = new Folders("general","abo",false,true);
        final Folders folc = new Folders("personal","abo",false,true);

//        new Folders(edinewfolder.getText().toString(), "abo")
//        Beginna.aloadInBackground(ree, lee);
//        Beginna.eloadInBackground(ree,lee);
//        Beginna.loadInBackground(ree,lee);
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseUser = mFirebaseAuth.getCurrentUser();
      handler = new Handler();

        if (mFirebaseUser == null) {
 startActivity(hjn);
            overridePendingTransition(R.transition.slide_from_right, R.transition.slide_to_left);
 finish();
//            Processors.getInstance().setInfod();

            // Not signed in, launch the Sign In activity
//            Timber.tag("MainActivity").i("onCreate(): User not signed in, launching SignInActivity");
//            startActivity(new Intent(this, SignInActivity.class));
//            finish();

//            setUpInfo();
//
//                        else{
//                         displayo("an error just occur, please try to re install this app");
//                         displayoe("sorr for the inconveniences");
//                        }

                            }
//                            setUpInfo();

                        else {
            hj = new Intent(Intro.this, MainActivity.class);
            processall.getInstance().setViewpage(0);
            startActivity(hj);
            overridePendingTransition(R.transition.slide_from_right, R.transition.slide_to_left);
            finish();
//            loadmany();
//            MainActivity.beginwatch = 0;
//            Thread thread = new Thread(null, doBackgroundThreadProcessinge, "Background");
//            thread.start();
//            Thread threade = new Thread(null, doBackgroundThreadProcessinga, "Background");
//            threade.start();
//            Thread threado = new Thread(null, doBackgroundThreadProcessingu, "Background");
//            threado.start();


//            mUsername = mFirebaseUser.getDisplayName();
//            Timber.tag("MainActivity").i("onCreate(): User \"%s\" signed in.", mUsername);
//            if (mFi
// rebaseUser.getPhotoUrl() != null) {
//                mPhotoUrl = mFirebaseUser.getPhotoUrl().toString();
        }

//        setContentView(R.layout.intro);
//        mfra = new Intent(Intro.this, Startup.class);
//        maary = (TextView) findViewById(R.id.maary);
//        beginners = (LinearLayout)findViewById(R.id.begginers);
//        poles = (LinearLayout)findViewById(R.id.poles);
//
//          poles.setVisibility(View.GONE);
//          maary.setVisibility(View.GONE);
//
//
//        startu = new TranslateAnimation(-250,0,0,0);
//        poleupe = new TranslateAnimation(0,0,50,0);
//        poledowne = new TranslateAnimation(0,0,0,50);
//        transcont = new TranslateAnimation(0,300,0,0);
//
//        startu.setDuration(1000);
//        poleupe.setDuration(1200);
//        poledowne.setDuration(1200);
//        transcont.setDuration(1200);
//
//        goin = new AlphaAnimation(1,0);
//        comeout = new AlphaAnimation(0,1);
//
//        goin.setDuration(1200);
//        comeout.setDuration(1200);
//
//        maryscaledown = new ScaleAnimation(1,1,0,0);
//        maryscaleup = new ScaleAnimation(0,0,1,1);
//
//        maryscaledown.setDuration(1200);
//        maryscaleup.setDuration(1200);
//
//        beginners.startAnimation(startu);
//        CountDownTimer timre = new CountDownTimer(1000,500) {
//            @Override
//            public void onTick(long l) {
//
//            }
//
//            @Override
//            public void onFinish() {
//              beginners.startAnimation(goin);
//                CountDownTimer gh = new CountDownTimer(1100,500) {
//                    @Override
//                    public void onTick(long l) {
//
//                    }
//
//                    @Override
//                    public void onFinish() {
//
//                        poles.setVisibility(View.VISIBLE);
//                        beginners.setVisibility(View.GONE);
//                        poles.startAnimation(poleupe);
//                    }
//
//                    CountDownTimer nm = new CountDownTimer(1100,500) {
//                            @Override
//                            public void onTick(long l) {
//
//                            }
//
//                            @Override
//                            public void onFinish() {
//                                maary.setVisibility(View.VISIBLE);
//                              maary.startAnimation(maryscaleup);
//                                CountDownTimer yu = new CountDownTimer(2550,500) {
//                                    @Override
//                                    public void onTick(long l) {
//
//                                    }
//
//                                    @Override
//                                    public void onFinish() {
//                                      maary.startAnimation(goin);
//                                         CountDownTimer bng = new CountDownTimer(1100, 500) {
//                                             @Override
//                                             public void onTick(long l) {
//
//                                             }
//
//                                             @Override
//                                             public void onFinish() {
////                                                 beginners.setVisibility(View.INVISIBLE);
//                                                maary.setVisibility(View.GONE);
//                                                 poles.startAnimation(poledowne);
//                                                 CountDownTimer fh = new CountDownTimer(1100,500) {
//                                                     @Override
//                                                     public void onTick(long l) {
//
//                                                     }
//
//                                                     @Override
//                                                     public void onFinish() {
//                                                         poles.startAnimation(goin);
//
//                                                         CountDownTimer hjt = new CountDownTimer(1100,500) {
//                                                             @Override
//                                                             public void onTick(long l) {
//
//                                                             }
//
//                                                             @Override
//                                                             public void onFinish() {
//                                                                 beginners.setVisibility(View.VISIBLE);
//                                                                 beginners.startAnimation(comeout);
//                                                                 beginners.startAnimation(transcont);
//                                                                  poles.setVisibility(View.GONE);
//                                                                 CountDownTimer hfd = new CountDownTimer(1000,500) {
//                                                                     @Override
//                                                                     public void onTick(long l) {
//
//                                                                     }
//
//                                                                     @Override
//                                                                     public void onFinish() {
//                                                                         beginners.setVisibility(View.GONE);
//                                                                         startActivity(mfra);
//                                                                     }
//                                                                 }.start();
//                                                              }
//                                                         }.start();
//                                                     }
//                                                 }.start();
//                                             }
//                                         }.start();
//                                    }
//                                }.start();
//                            }
//                        }.start();
//
//                }.start();
//            }
//        }.start();

    }
//    private Runnable doBackgroundThreadProcessinge = new Runnable() {
//        public void run() {
//            Answered.InfoListsa = Beginna.loadInBackground(mysharedpreferences,myeditor,mrdatabase,lee);
//        }
//    };
//    private Runnable doBackgroundThreadProcessinga = new Runnable() {
//        public void run() {
//            All.InfoLists = Beginna.eloadInBackground(mrdatabase,lee);
//        }
//    };
//    private Runnable doBackgroundThreadProcessingu = new Runnable() {
//        public void run() {
//            Unanswered.InfoListsb = Beginna.aloadInBackground(mysharedpreferences,myeditor,mrdatabase,lee);
//        }
//    };
//    View.OnClickListener descriptiveloListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            me.show();
//        }
//    };
//public void loadmany(){
//    Usery.orderByValue().addValueEventListener(new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) {
////               naem =  new namepro(dataSnapshot);
//        }
//
//        @Override
//        public void onCancelled(DatabaseError databaseError) {
//
//        }
//    });
//    lee.orderByChild("timestamp").addValueEventListener(new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) {
//
//        final List<question> firstSetOfQuestions = Showallquestions(dataSnapshot);
//           AppExecutor.getsInstance().diskIO().execute(
//                   new Runnable() {
//                       @Override
//                       public void run() {
//                           mDb.questionDao().deleteAll();
//            for (int i=0; i<firstSetOfQuestions.size();i++){
//               mDb.questionDao().insertQuestion(firstSetOfQuestions.get(i));
//
//
//            }
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    startActivity(hj);
//                    finish();
//                }
//            });
//                       }
//                   }
//           );
//
//
//        }
//
//        @Override
//        public void onCancelled(DatabaseError databaseError) {
//
//        }
//    });
//
//
//}
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
    private Runnable doBackgroundThreadProcessingupdatethrough = new Runnable() {
        public void run() {
            ResolveList.getInstance().setAllquestions(mathmatical.Showallquestions(mysharedpreferences,myeditor,classname));
//            ResolveList.getInstance().setAllquestions(mathmatical.Showallquestions(mysharedpreferences,myeditor));
            ResolveList.getInstance().setAnsweredquestions(mathmatical.showAnsweredquestions(mysharedpreferences,myeditor,classname));
            ResolveList.getInstance().setUnansweredquestions(mathmatical.showUnasweredQuestions(mysharedpreferences,myeditor,classname));


        }
    };
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
    public void setUpInfo(){
        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
//        LiveData<List<Info>> infos = mDataBase.infoDao().LoadAllInfo();
        viewModel.getFolder().observe(this,new Observer<List<Folders>>() {
            @Override
            public void onChanged(@Nullable List<Folders> folders) {
//               Processors.getInstance().setFolders(folders);
                if(folders!=null) {
                    folderss.addAll(folders);
//                    displayo(String.valueOf(folders.size()));
                }
//                Toast.makeText(getApplicationContext(),String.valueOf(Processors.getInstance().getInfod().size()),Toast.LENGTH_LONG).show();

//
            }
        });
    }
   public boolean CheckFolders(){
        if(
        folderss.get(0).getFoldername().equals("general")&&folderss.get(1).getFoldername().equals("personal")){
            return true;
        }
        else {
            return false;
        }
   }

    public static void setFolderss(List<Folders> folderss) {
        Intro.folderss = folderss;
    }

    public static List<Folders> getFolderss() {
        return folderss;
    }
}
