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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
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
import com.google.firebase.auth.FirebaseUser;
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
public class Unanswered extends Fragment implements QuestionAdaptero.OnRecycleViewItemClicker, LoaderManager.LoaderCallbacks<List<question>> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView informsb;
    FloatingActionButton comment;
    static List<question> InfoListsb = new ArrayList<>();
    static QuestionAdaptero infoAdapterb;
    String sinfoautho;
    String sinfobody;
    String sinfotitle;
    DataSnapshot dfr;
    View r;
    FirebaseAuth mAuth;
    String iid;
    FirebaseDatabase dw;
    DatabaseReference answereference;
    SharedPreferences mysharedpreference;
    Mathmatical mathmatical;
    SharedPreferences.Editor myeditor;
    AppDatabase mdatabase;
    DatabaseReference queeren;
    static List<String> reodlist = new ArrayList<>();
    static List<String> unrectiunans = new ArrayList<>();
    static List<question> unrectianssd = new ArrayList<>();
    TextView ninfoauthority, ninfotitle, ninfobody, ninfodate, ninfotime;
    EditText mycommente;
    String att[];
    String id;
    LoadandSave rool, mool;
    List<String> isread = new ArrayList<String>();
    Dialog neb, ben;
    ArrayList<String> ereadList = new ArrayList<>();
    FloatingActionButton commentredone;
    public infocool trinfocool;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Unanswered() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InformationFragment.
     */
// TODO: Rename and change types and number of parameters
    public static Unanswered newInstance(String param1, String param2) {
        Unanswered fragment = new Unanswered();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public
    void onCreate(Bundle savedInstanceState) {
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
        View vo = inflater.inflate(R.layout.fragment_unanswered, container, false);
        informsb = (RecyclerView)vo.findViewById(R.id.unansweredquestionsview);
        rool = new LoadandSave("rool",isread,getContext());
        mysharedpreference = getActivity().getSharedPreferences("readstate",Context.MODE_PRIVATE);
        myeditor = mysharedpreference.edit();
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
//        question tysj = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        question tyk = new question("eee","hi i want to find flux density in a loop","EEE223","23 45 25","donald","2 50AM", false, false);
//        InfoListsb.add(tyd); InfoListsb.add(tyd); InfoListsb.add(tyd); InfoListsb.add(tyd);
//        InfoListsb.add(tyd); InfoListsb.add(tyd); InfoListsb.add(tyd); InfoListsb.add(tyd);
//        InfoListsb.add(tyd); InfoListsb.add(tyd);
//        matchem(unrectianssd,InfoListsb,unrectiunans,reodlist);
//        infoAdapterb = new QuestionAdapter(InfoListsb);

//          for (int i = 0; i < readlist.size(); i++) {
//              displayo(readlist.get(i));
//          }
        InfoListsb = ResolveList.getInstance().getUnansweredquestions();
        infoAdapterb = new QuestionAdaptero(InfoListsb,this);
//        Thread thread = new Thread(null, doBackgroundThreadProcessing, "Background");
//        thread.start();
//        displayo(String.valueOf(readlist.size()));
        infoAdapterb.setOnItemclickedListener(this);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getContext());
//        neb = new Dialog(getActivity());
//        neb.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        neb.setContentView(R.layout.comments);
//        Info j = new Info("use the framee","Ann");
//        InfoLists.add(j);
//        MainActivity.myBar.hide();
//        getActivity().getSupportLoaderManager().initLoader(1, null, Unanswered.this).forceLoad();
        mdatabase = AppDatabase.getsInstance(getContext());
        dw = FirebaseDatabase.getInstance();
        answereference = dw.getReference("question");
        queeren = dw.getReference("Answers");
        infoAdapterb.notifyDataSetChanged();
        answereference.keepSynced(true);
        queeren.keepSynced(true);
//        commentredone = (FloatingActionButton)neb.findViewById(R.id.commentdone);
//        commentredone.setOnClickListener(commentredoneListener);
//        mycommente = (EditText)neb.findViewById(R.id.mycomment);
        informsb.setLayoutManager(mlayoutManager);
        informsb.setItemAnimator(new DefaultItemAnimator());
        informsb.setAdapter(infoAdapterb);
//        ben = new Dialog(getActivity());
//        ben.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
//        ben.setContentView(R.layout.fullinfo);
//        ninfoauthority = (TextView)ben.findViewById(R.id.
// ninfoauthority);
//        ninfobody =(TextView)ben.findViewById(R.id.ninfobody);
//        ninfotime =(TextView)ben.findViewById(R.id.ninfotime);
//        ninfodate =(TextView)ben.findViewById(R.id.ninfodate);
//        ninfotitle =(TextView)ben.findViewById(R.id.ninfotitle);
        setUpInfo();
        return vo;
    }

    @Override
    public Loader<List<question>> onCreateLoader(int id, Bundle args) {
        return new LoadAnswerun(getContext());
    }

    @Override
    public void onLoadFinished(Loader<List<question>> loader, List<question> data) {
        if (data != null) {
            InfoListsb = data;
            infoAdapterb.notifyDataSetChanged();
        }
    }
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
                            if (!questions.get(i).isAnswered()) {
//                                    questions.get(i).setRead(Spreferences.ReadState(mysharedpreference, questions.get(i).getQueid(), myeditor, questions.get(i).getNoanswer(), questions.get(i).getNocomment()));
                                if(questions.get(i).getMclass().equals(mysharedpreference.getString("userclass",""))) {
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
                        infoAdapterb.setInfoLists(anquestions);
                    }

//                    Information.InfoListsand = Processors.getInstance().getInfod();
//                    Information.infoAdapterand.notifyDataSetChanged();
                }

        );
    }
    @Override
    public void onLoaderReset(Loader<List<question>> loader) {
//        infoAdapterb= new QuestionAdapter(new ArrayList<question>());
        infoAdapterb.notifyDataSetChanged();
    }
    private Runnable doBackgroundThreadProcessing = new Runnable() {
        public void run() {
            InfoListsb = mathmatical.showUnasweredQuestions(mysharedpreference,myeditor,namepro.getNclassy());
        }
    };
    private Runnable doBackgroundoThreadProcessing = new Runnable() {
        public void run() {
            mool.saveInBackground();
        }
    };
    FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser userm = firebaseAuth.getCurrentUser();
            if (!userm.toString().equals(null)) {// User is signed

//               displayo(userm.getDisplayName());
                final String tyid = mAuth.getUid();
                iid = tyid;
            }
        }
    };
//                answereference.orderByChild("timestamp").addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        mathmatical = new Mathmatical(dataSnapshot);
//                        Thread thread = new Thread(null, doBackgroundThreadProcessing, "Background");
//                        thread.start();
//                        infoAdapterb.notifyDataSetChanged();
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
//    public static void matchem(List<question> a, List<question> b, List<String> c, List<String> d) {
//        b.clear();
//        d.clear();
//        if(!a.isEmpty()) {
//            for (int i = 0; i < a.size(); i++) {
//
//                if (a.get(i).isAnswered()==false) {
////                    displayo(a.get(i).getQueid());
////                    displayo(id);
//                    b.add(a.get(i));
//                    d.add(c.get(i));
//                } else {
//
//                }
//            }
//        }
//        infoAdapterb = new QuestionAdapter(InfoListsb);
//        infoAdapterb.notifyDataSetChanged();
//    }
//    public static void suont(List<question> a, List<String> b) {
//        a.clear();
//        for (int i = MainActivity.questions.size() - 1; i >= 0; i--) {
//            a.add(MainActivity.questions.get(i));
//        }
//        b.clear();
//        for (int i  = MainActivity.unspinnedquestion.size()-1;i>=0;i--){
//            b.add(MainActivity.unspinnedquestion.get(i));
//        }
//        matchem(unrectianssd,InfoListsb,unrectiunans,reodlist);
//
//    }
//    //        View.OnClickListener commentredoneListener = new View.OnClickListener() {
////@Override
////public void onClick(View view) {
////        if(mycommente.getText()==null||mycommente.getText().toString().equals("")){
////        displayo("you have not entered any comment");
////        mycommente.setHintTextColor(Color.RED);
////        mycommente.setHint("please enter your comment");
////        }
////        else{
////        displayoe("comment sent");
////        neb.cancel();
////        mycommente.setText(null);
////        }
////        }
////        };
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

     final question tyu = infoAdapterb.getInfoLists().get(position);

//        int prusition = All.InfoLists.indexOf(tyu);
//        if(!isread.contains(String.valueOf(position))) {
//            isread.add(String.valueOf(position));
////        info.setRead(true);
//            mool = new LoadandSave("rool",isread,getContext());
//            Thread thread = new Thread(null, doBackgroundoThreadProcessing, "Background");
//            thread.start();
//            infoAdapterb.notifyDataSetChanged();
//
////        boolean rt = MainActivity.saveArray(asd, "cool", getContext());
//        }
//        else{
//
//        }
 tyu.setRead(true);
        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                       mdatabase .questionDao().updateQuestion(tyu);
                    }
                }
        );
         Intent urix = new Intent(getActivity(), InnerAnswer.class);
        id = tyu.getQueid();
        tyu.setPending(tyu.isPending());
        processall.getInstance().setQueid(id);
        //urix.putExtra("who",tyu.getWho());
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
        processall.getInstance().setSender(3);
        processall.getInstance().setUserclass(tyu.getMclass());
        processall.getInstance().setCoolid(tyu.getCoolid());
        processall.getInstance().setNoanswer(String.valueOf(tyu.getNoanswer()));
        processall.getInstance().setNocomment(String.valueOf(tyu.getNocomment()));
        processall.getInstance().setAskernumber(tyu.getYnumber());
        processall.getInstance().setAskemail(tyu.getYemail());
        processall.getInstance().setViewpage(2);
        processall.getInstance().setDownloadurid(tyu.getDownloadurid());
        processall.getInstance().setThumblineurid(tyu.getThumblineuri());
//        urix.putExtra("sender",3);
//        trinfocool.reaidee();
        startActivityForResult(urix,3);
        getActivity().overridePendingTransition(R.transition.slide_from_right, R.transition.slide_to_left);
//        Info info = InfoLists.get(position);
//        ninfobody.setText(info.getBody());
//        ninfotitle.setText(info.getTitle());
//        ninfoauthority.setText(info.getAuthority());
//        ninfodate.setText(info.g
// etDate());
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
    private Runnable doBackgroundThreadProcessingu = new Runnable() {
        public void run() {
//            Unanswered.InfoListsb = Beginna.aloadInBackground(mysharedpreference,myeditor,dw, answereference);
//            infoAdapterb.notifyDataSetChanged();
        }
    };
//    private Runnable doBackgroundThreadProcessinge = new Runnable() {
//        public void run() {
//            Beginna.enloadInBackground(dw,queeren);
// InnerAnswer.senfoLists = Beginna.ananswers;
//        }
//    };
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        startActivity(processall.getInstance().getYu());
        getActivity().finish();
    }
    public interface infocool{
        public void reaidee();
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            trinfocool = (infocool) activity;
        }
        catch (Exception e){

        }
    }

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
