package com.mycompany.myapp.thetframework;

import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Answered.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Answered#newInstance} factory method to
 * create an instance of this fragment.
 */



public class Answered extends Fragment implements QuestionAdaptero.OnRecycleViewItemClicker, android.support.v4.app.LoaderManager.LoaderCallbacks<List<question>> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView informs;
    FloatingActionButton comment;
    static List<question> InfoListsa = new ArrayList<>();
    static QuestionAdaptero infoAdaptera;
    String sinfoautho;
    Context context;
    DatabaseReference queeren;
    FirebaseDatabase fdatabase;
    FirebaseAuth mAuth;
    SharedPreferences mysharedpreference;
    SharedPreferences.Editor myeditor;
    DatabaseReference ansquereference;
    String sinfobody;
    LoadandSave tew;
    String sinfotitle;
    View r;
    static List<question> unrectifird = new ArrayList<>();
    static List<String> isread = new ArrayList<>();
    LoadandSave dew;
    static List<String> stringunrecti = new ArrayList<>();
    TextView ninfoauthority, ninfotitle, ninfobody, ninfodate, ninfotime;
    EditText mycommente;
    String att[];
    String id;
    Mathmatical mathmatical;
    Dialog neb, ben;
    DataSnapshot dr;
      private AppDatabase mDb;
    ArrayList<String> ereadList = new ArrayList<>();
    FloatingActionButton commentredone;
    public infocool trinfocool;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
String iid;
    private OnFragmentInteractionListener mListener;

    public Answered() {
        // Required empty public constructor
    }

    /*
     *
     *
     *
     *
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InformationFragment.
     */
// TODO: Rename and change types and number of parameters
    public static Answered newInstance(String param1, String param2) {
        Answered fragment = new Answered();
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
        // Inflate the layout for this fragment
        View vo = inflater.inflate(R.layout.fragment_answered, container, false);
        r = vo;
        informs = (RecyclerView)vo.findViewById(R.id.answeredquestionsview);
        fdatabase = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        ansquereference = fdatabase.getReference("question");
        context = getContext();
//        ansquereference.keepSynced(true);

//        InfoListsa = ResolveList.getInstance().Answeredquestions;
        infoAdaptera = new QuestionAdaptero(InfoListsa,Answered.this);
        mysharedpreference = getActivity().getSharedPreferences("readstate",Context.MODE_PRIVATE);
        myeditor = mysharedpreference.edit();
        mDb = AppDatabase.getsInstance(getContext());
//        comment = (FloatingActionButton) vo.findViewById(R.id.comment);
//        comment.setOnClickListener(commentListener);
//        question tyr = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tywr = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tyq = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tyt = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tyte = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tyty = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tys = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tyd = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tyf = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tyg = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tyh = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tyj = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tyk = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        InfoListsa.add(tyd); InfoListsa.add(tyd);  InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd);
//        InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd);
//        InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd);
//        InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd);
//        InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd);
//        InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd); InfoListsa.add(tyd);
//displayo(String.valueOf(InfoListsa.size()));
//        dew = new LoadandSave("pool",isread,getContext());
//
//
//
//
//
//
//
//
//
//
//
//
// Thread thread = new Thread(null, doBackgroundThreadProcessing, "Background");
//        thread.start();
//        dew = new LoadandSave("pool",isread,getContext());



//          for (int i = 0; i < readlist.size(); i++) {
//              displayo(readlist.get(i));
//          }
//        displayo(String.valueOf(readlist.size()));
        infoAdaptera.setOnItemclickedListener(this);


//        getActivity().getSupportLoaderManager().initLoader(1, null, Answered.this).forceLoad();
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getContext());
//        neb = new Dialog(getActivity());
//        neb.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        neb.setContentView(R.layout.comments);
//        Info j = new Info("use the framee","Ann");
//        InfoLists.add(j);
//        MainActivity.myBar.hide();
//        AppExecutor.getsInstance().diskIO().execute(new Runnable() {
//            @Override
//            public void run() {
//                InfoListsa = mDb.questionDao().LoadAllQuestions();
//                informs.post(
//                        new Runnable() {
//                            @Override
//                            public void run() {
//                                infoAdaptera.notifyDataSetChanged();
//                            }
//                        }
//                );
//
//            }
//
//        });
        infoAdaptera.notifyDataSetChanged();
//        commentredone = (FloatingActionButton)neb.findViewById(R.id.commentdone);
//        commentredone.setOnClickListener(commentredoneListener);
//        mycommente = (EditText)neb.findViewById(R.id.mycomment);
        informs.setLayoutManager(mlayoutManager);
        informs.setItemAnimator(new DefaultItemAnimator());
        informs.setAdapter(infoAdaptera);
        setUpInfo();

//        displayo(String.valueOf(InfoListsa.size()));
//        ben = new Dialog(getActivity());
//        ben.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        ben.setContentView(R.layout.fullinfo);
//        ninfoauthority = (TextView)ben.findViewById(R.id.ninfoauthority);
//        ninfobody =(TextView)ben.findViewById(R.id.ninfobody);
//        ninfotime =(TextView)ben.findViewById(R.id.ninfotime);
//        ninfodate =(TextView)ben.findViewById(R.id.ninfodate);
//        ninfotitle =(TextView)ben.findViewById(R.id.ninfotitle);
        queeren = fdatabase.getReference("Answers");
//        mAuth.addAuthStateListener(authStateListener);
        queeren.keepSynced(true);
        return vo;
    }
    private Runnable doBackgroundThreadProcessing = new Runnable() {
        public void run() {
//            InfoListsa = mathmatical.showAnsweredquestions(mysharedpreference,myeditor,namepro.getNclassy());
//            dew = new LoadandSave("pool",isread,getContext());
//            dew.loadInBackground("pool",isread,getContext());
//            StaticHolder.setIsreadList(isread);
        }
    };
    public void setUpInfo(){
        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
//        LiveData<List<Info>> infos = mDataBase.infoDao().LoadAllInfo();
        viewModel.getQuestions().observe(this, new Observer<List<question>>() {
                    @Override
                    public void onChanged(@Nullable List<question> questions) {
//                Processors.getInstance().setInfod(infos);

                   List<question> anquestions = new ArrayList<question>();
                   anquestions.clear();
                        for (int i = 0; i < questions.size(); i++) {
//                            if (questions.get(i).getMclass().equals(name)) {
                                if (questions.get(i).isAnswered()) {
                                    if(questions.get(i).getMclass().equals(mysharedpreference.getString("userclass",""))) {
//                                    questions.get(i).setRead(Spreferences.ReadState(mysharedpreference, questions.get(i).getQueid(), myeditor, questions.get(i).getNoanswer(), questions.get(i).getNocomment()));
                                        anquestions.add(questions.get(i));
                                    }
                                    Collections.sort(anquestions, new Comparator<question>() {
                                        @Override
                                        public int compare(question t0, question t1) {
                                            return (int)(t1.getTimestamp()-t0.getTimestamp());
                                        }
                                    });

                                }
                            }
                            infoAdaptera.setInfoLists(anquestions);
                        }

//                    Information.InfoListsand = Processors.getInstance().getInfod();
//                    Information.infoAdapterand.notifyDataSetChanged();
                    }

        );
    }
    @Override
    public void onResume() {
//        InfoListsa = mDb.questionDao().LoadAllQuestions();
        infoAdaptera.notifyDataSetChanged();
        super.onResume();
    }

//    private Runnable doBackgroundoThreadProcessing = new Runnable() {
//        public void run() {
//            tew.saveInBackground();
//        }
//    };
//    FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
//        @Override
//        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//            FirebaseUser userm = firebaseAuth.getCurrentUser();
//            if (!userm.toString().equals(null)) {
//// User is signed
//
////               displayo(userm.getDisplayName());
//                final String tyid = mAuth.getUid();
//                iid = tyid;
//            }
//        }
//    };
//                ansquereference.orderByChild("timestamp").addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        mathmatical = new Mathmatical(dataSnapshot);
//                        Thread thread = new Thread(null, doBackgroundThreadProcessing, "Background");
//                        thread.start();
//                        infoAdaptera.notifyDataSetChanged();
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
////    public static void matchem(List<question> a, List<question> b, List<String> c, List<String> d) {
////        b.clear();
////        d.clear();
////        if(!a.isEmpty()) {
////            for (int i = 0; i < a.size(); i++) {
////
////                if (a.get(i).isAnswered()==true) {
//////                    displayo(a.get(i).getQueid());
//////
//////                 displayo(id);
////                    b.add(a.get(i));
////                    d.add(c.get(i));
////                } else {
////
////                }
////            }
////        }
////        infoAdaptera = new QuestionAdapter(InfoListsa);
////        infoAdaptera.notifyDataSetChanged();
////    }
private Runnable doBackgroundThreadProcessingj = new Runnable() {
    public void run() {
//        Answered.InfoListsa = Beginna.loadInBackground(mysharedpreference,myeditor,fdatabase,ansquereference);
//        infoAdaptera.notifyDataSetChanged();
    }
};
    @Override
    public android.support.v4.content.Loader<List<question>> onCreateLoader(int id, Bundle args) {
        return new LoadAnswer(context);
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<List<question>> loader) {
//        infoAdaptera= new QuestionAdapter(new ArrayList<question>());
//        infoAdaptera.notifyDataSetChanged();
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<List<question>> loader, List<question> data) {
//        infoAdaptera = new QuestionAdaptero(data, this);
//        if(data!=null) {
////            InfoListsa = data;
////            infoAdaptera.notifyDataSetChanged();
//        }notifyDataSetChanged
    }

//    public static void suont(List<question> a, List<String> b) {
//        a.clear();
//        for (int i = MainActivity.questions.size() - 1; i >= 0; i--) {
//            a.add(MainActivity.questions.get(i));
//        }
//        b.clear();
//        for (int i  = MainActivity.unspinnedquestion.size()-1;i>=0;i--){
//            b.add(MainActivity.unspinnedquestion.get(i));
//        }
//        matchem(unrectifird,InfoListsa, stringunrecti,readlist);

//    }
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
//public String[] loadArray(String arrayName, Context mContext) {
//        SharedPreferences prefs = mContext.getSharedPreferences(arrayName, 0);
//        int size = prefs.getInt(arrayName + "_size", 0);
////            displayoe(String.valueOf(size));
//        String array[] = new String[size];
//        for(int i=0;i<size;i++) {
//        array[i] = prefs.getString(arrayName + "_" + i, null);
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
    public void displayo(String ji) {
        Context context = getContext();
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
        Context context = getContext();
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

    @Override
    public void OnRecycleViewItemclicked(int position) {
       final question tyu = infoAdaptera.getInfoLists().get(position);
        id = tyu.getQueid();
        tyu.setRead(true);
        tyu.setPending(tyu.isPending());
        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        mDb.questionDao().updateQuestion(tyu);
                    }
                }
        );

//        int prusition = All.InfoLists.indexOf(tyu);
//        if(!isread.contains(String.valueOf(position))) {
//            isread.add(String.valueOf(position));
////        info.setRead(true);
//            tew = new LoadandSave("pool",isread,getContext());
//            Thread thread = new Thread(null, doBackgroundoThreadProcessing, "Background");
//            thread.start();
//            infoAdaptera.notifyDataSetChanged();

//        boolean rt = MainActivity.saveArray(asd, "cool", getContext());

//        }
        tyu.setRead(true);
        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        mDb.questionDao().updateQuestion(tyu);
                    }
                }
        );
        processall.getInstance().setQueid(id);
//        Thread thread = new Thread(null, doBackgroundThreadProcessinge, "Background");
//        thread.start();
         Intent urix = new Intent(getActivity(), InnerAnswer.class);
        processall.getInstance().setWho(tyu.getWho());
        processall.getInstance().setBody(tyu.getBody());
        processall.getInstance().setDate(tyu.getDate());
        processall.getInstance().setPending(tyu.isPending());
        processall.getInstance().setTime(tyu.getTime());
        processall.getInstance().setQueid(id);
        processall.getInstance().setHasImage(tyu.isHasImage());
        processall.getInstance().setUserclass(tyu.getMclass());
//        Thread thread = new Thread(null, doBackgroundThreadProcessinge, "Background");
//        thread.start();
        processall.getInstance().setPathy(tyu.getUristring());
        processall.getInstance().setPosition(String.valueOf(position));
        processall.getInstance().setSender(2);
        processall.getInstance().setCoolid(tyu.getCoolid());
        processall.getInstance().setNoanswer(String.valueOf(tyu.getNoanswer()));
        processall.getInstance().setNocomment(String.valueOf(tyu.getNocomment()));
        processall.getInstance().setAskernumber(tyu.getYnumber());
        processall.getInstance().setAskemail(tyu.getYemail());
        processall.getInstance().setViewpage(1);
        processall.getInstance().setDownloadurid(tyu.getDownloadurid());
        processall.getInstance().setThumblineurid(tyu.getThumblineuri());
//        urix.putExtra("position",position);
//        urix.putExtra("sender",2);
//        trinfocool.reaudee();
        startActivityForResult(urix, 2);
        getActivity().overridePendingTransition(R.transition.slide_from_right, R.transition.slide_to_left);
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
//        String[] asd = readlist.toArray(new String[0]);
//
//        boolean rt = saveArray(asd, "cool", getContext());
////            displayoe(String.valueOf(rt));
//        }
//        ben.show();
    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    public interface infocool{
        public void reaudee();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        startActivity(processall.getInstance().getYu());
        getActivity().finish();
    }
//    private Runnable doBackgroundThreadProcessinge = new Runnable() {
//        public void run() {
//            Beginna.enloadInBackground(fdatabase,queeren);
//            InnerAnswer.senfoLists = Beginna.ananswers;
//        }
//    };
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            trinfocool = (infocool) activity;
        }
        catch (Exception e){

        }
    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//    }
//

    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }


//    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
        void onFragmentInteraction(Uri uri);
    }
}
