package com.mycompany.myapp.thetframework;
import android.app.Dialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



/**
 * A simple {@ffffffrrrrgyy Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Information.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Information#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Information extends Fragment implements InfoAdapter.OnRecycleViewItemClicker {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView newsdateb, timeeb, writerb, veryimporb, fulnewsb, fullnews, timea, newsdate, writera;
    static List<Info> InfoListsand = new ArrayList<>();
    TextView headines, load, loadb, loadc;
    LinearLayout linla, lindot;
    static int previosstate;
    private AppDatabase mDataBase;
   static Processors processors;
    static InfoAdapter infoAdapterand;
    EditText edinformation;
    String strDate, time;
    TranslateAnimation translatea, translateb, translatec;
    RotateAnimation spina, spin;
    ScaleAnimation Rollout, Rollin;
    CheckBox checkyurgent;
    boolean veryimportant;
    ImageView cancel_action, intoinfo, summitinfo, showstar;
    RecyclerView infocycler;
    static RelativeLayout relwriteinfo;
    FloatingActionButton adde, refresh;
    Dialog fullinfo, previewinfo;
    private OnFragmentInteractionListener mListener;

    public Information() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Information.
     */
    // TODO: Rename and change types and number of parameters
    public static Information newInstance(String param1, String param2) {
        Information fragment = new Information();
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
        // In
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        infocycler = (RecyclerView)view.findViewById(R.id.inforecycler);
        adde = (FloatingActionButton)view.findViewById(R.id.adde);
        refresh = (FloatingActionButton)view.findViewById(R.id.refresh);
        relwriteinfo = (RelativeLayout)view.findViewById(R.id.relwriteinfo);
        checkyurgent = (CheckBox)view.findViewById(R.id.checkyurgent);
        edinformation = (EditText)view.findViewById(R.id.edinformation);
        summitinfo = (ImageView)view.findViewById(R.id.summitinfo);
        cancel_action = (ImageView)view.findViewById(R.id.cancel_ininfo);
        fullinfo = new Dialog(getActivity());
        previosstate = 0;

        processors = Processors.getInstance();
        fullinfo.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        fullinfo.setContentView(R.layout.innerheadline);
        fullnews =(TextView)fullinfo.findViewById(R.id.fullnews);
        mDataBase = AppDatabase.getsInstance(getContext());
        writera = (TextView)fullinfo.findViewById(R.id.writera);
        load = (TextView)view.findViewById(R.id.load);
        loadb = (TextView)view.findViewById(R.id.loadb);
        loadc = (TextView)view.findViewById(R.id.loadc);
        newsdate  = (TextView)fullinfo.findViewById(R.id.newsdate);
        headines = (TextView)view.findViewById(R.id.headlines);
        timea =  (TextView)fullinfo.findViewById(R.id.timea);
        linla = (LinearLayout)fullinfo.findViewById(R.id.linla);
        lindot = (LinearLayout)view.findViewById(R.id.lindot);
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);

//        Info indo = new Info("peter","please everyone should be informed that school resumes on monday may 27 2018, thank you!","23/05/18","12:04pm",true,true,true);
//        Info ind  = new Info("peter","please everyone should be informed that school resumes on monday may 27 2018, thank you!","23/05/18","12:04pm",true,false,true);
//        Info indi = new Info("peter","please everyone should be informed that school resumes on monday may 27 2018, thank you!","23/05/18","12:04pm",true,false,false);
//        Info inde = new Info("peter","please everyone should be informed that school resumes on monday may 27 2018, thank you!","23/05/18","12:04pm",false,false,true);
//        Info indu = new Info("peter","please everyone should be informed that school resumes on monday may 27 2018, thank you!","23/05/18","12:04pm",false,false,false);
//        InfoListsand.add(ind); InfoListsand.add(inde); InfoListsand.add(indi); InfoListsand.add(indo); InfoListsand.add(indu);
//
//        InfoListsand.add(ind); InfoListsand.add(inde); InfoListsand.add(indi); InfoListsand.add(indo); InfoListsand.add(indu);
//
//        InfoListsand.add(ind); InfoListsand.add(inde); InfoListsand.add(indi); InfoListsand.add(indo); InfoListsand.add(indu);
        infoAdapterand = new InfoAdapter(InfoListsand,Information.this);
    infoAdapterand.setOnItemclickedListener(this);
     refresh.setOnClickListener(refreshListener);
    RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getContext());
        setUpInfo();
//        displayo(String.valueOf(InfoListsand.size()));

    summitinfo.setOnClickListener(summitinfoListener);
    cancel_action.setOnClickListener(cancel_actionListener);

        previewinfo= new Dialog(getActivity());
        previewinfo.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        previewinfo.setContentView(R.layout.preview);
        showstar = (ImageView)previewinfo.findViewById(R.id.showstarb);
        intoinfo = (ImageView)previewinfo.findViewById(R.id.intoinfob);
        intoinfo.setOnClickListener(infoInfoListener);
        veryimporb = (TextView)previewinfo.findViewById(R.id.veryimporb);
        newsdateb = (TextView)previewinfo.findViewById(R.id.newsdateb);
        writerb = (TextView)previewinfo.findViewById(R.id.writerb);
        spin = new RotateAnimation(0,360,50,50);
        spina = new RotateAnimation(0,360,42,42);
        translatea = new TranslateAnimation(0,0,0,10);
        translateb = new TranslateAnimation(0,0,0,-11);
        translatec = new TranslateAnimation(0,0,0,8);
        Rollout = new ScaleAnimation(1,1,0,1);
        Rollin = new ScaleAnimation(1,1,1,0);
        spin.setDuration(2000);
        Rollout.setDuration(700);
        translatea.setDuration(500);
        translatea.setRepeatCount(10);
        translateb.setDuration(500);
        translateb.setRepeatCount(10);
        translatec.setDuration(500);
        translatec.setRepeatCount(10);
        timeeb = (TextView)previewinfo.findViewById(R.id.timeebe);
        fulnewsb = (TextView)previewinfo.findViewById(R.id.fullnewsb);
//        fullnews = (TextView)previewinfo.findViewById(R.id.fullnews);

//    infoAdapterand.notifyDataSetChanged();
    infocycler.addItemDecoration(decoration);
    infocycler.setLayoutManager(mlayoutManager);
    infocycler.setItemAnimator(new DefaultItemAnimator());
    veryimportant = false;
    adde.setOnClickListener(addeListener);
    infocycler.setAdapter(infoAdapterand);
    new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return 0;
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        }
    }).attachToRecyclerView(infocycler);

         return view;
    }
    @Override
    public void OnRecycleViewItemclicked(int position) {

   final Info infod = infoAdapterand.getInfoLists().get(position);
   fullnews.setText(infod.getBody());
   writera.setText(infod.getWriter());
   timea.setText(infod.getTime());
   newsdate.setText(infod.getDate());
   if(infod.isimportant()){
       linla.setVisibility(View.VISIBLE);
   }
   else {
       linla.setVisibility(View.GONE);
   }
        fullinfo.show();
   infod.setIsread(true);
        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        mDataBase.infoDao().updateInfo(infod);
                    }
                }
        );
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    View.OnClickListener addeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            previosstate = MainActivity.centrewatcher;
            MainActivity.centrewatcher = 1;
         relwriteinfo.setVisibility(View.VISIBLE);
        }
    };

    public static  void retreiveInfo(){
        if(Processors.getInstance().getInfod() !=null){
        infoAdapterand.setInfoLists(Processors.getInstance().getInfod());

        }
    }
    public void setUpInfo(){
        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
//        LiveData<List<Info>> infos = mDataBase.infoDao().LoadAllInfo();
        viewModel.getInfo().observe(this, new Observer<List<Info>>() {
            @Override
            public void onChanged(@Nullable List<Info> infos) {
                Processors.getInstance().setInfod(infos);
                if(infoAdapterand!=null){
                    infoAdapterand.setInfoLists(infos);
//                    Information.InfoListsand = Processors.getInstance().getInfod();
//                    Information.infoAdapterand.notifyDataSetChanged();
                }
            }
        });
    }
    View.OnClickListener summitinfoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(checkyurgent.isChecked()){
                veryimportant = true;
                showstar.setVisibility(View.VISIBLE);
                veryimporb.setVisibility(View.VISIBLE);
            }
            else {
                veryimportant = false;
                showstar.setVisibility(View.GONE);
                veryimporb.setVisibility(View.GONE);
            }
            if(edinformation.getText()!=null){
                fulnewsb.setText(edinformation.getText());
            }
            else {

            }
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
            SimpleDateFormat sdfa = new SimpleDateFormat("h:mm a");
            strDate = sdf.format(c.getTime());
            time = sdfa.format(c.getTime());
            timeeb.setText(time);
            newsdateb.setText(strDate);
            previewinfo.show();
//            writerb.setText(namepro.getNusername());
        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        retreiveInfo();
    }

    View.OnClickListener cancel_actionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity.centrewatcher = previosstate;
      relwriteinfo.setVisibility(View.GONE);
        }
    };

    View.OnClickListener infoInfoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
      relwriteinfo.setVisibility(View.GONE);
      final Info  info = new Info(writerb.getText().toString(),edinformation.getText().toString(), strDate,time, false, false, veryimportant, false, true);
      InfoListsand.add(info);
      AppExecutor.getsInstance().diskIO().execute(
              new Runnable() {
                  @Override
                  public void run() {
                      mDataBase.infoDao().insertInfo(info);
                  }
              }
      );

//      infoAdapterand.notifyDataSetChanged();
      MainActivity.centrewatcher = previosstate;

      previewinfo.dismiss();
        }
    };

    @Override
    public void onResume() {
        super.onResume();

    }

    //    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    View.OnClickListener refreshListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            loadc.setVisibility(view.VISIBLE);
            loadb.setVisibility(view.VISIBLE);
            load.setVisibility(view.VISIBLE);
            loadc.startAnimation(Rollout);
            loadb.startAnimation(Rollout);
            load.startAnimation(Rollout);
            refresh.startAnimation(spin);
            CountDownTimer timer = new CountDownTimer(500,1500) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    lindot.setVisibility(View.VISIBLE);
                    headines.setText("Refreshing...");
//                    texty.setText("refreshing...");
                    load.startAnimation(translatea);
                    loadb.startAnimation(translateb);
                    loadc.startAnimation(translatec);


                    CountDownTimer timerb = new CountDownTimer(5000,1000) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {

                            {
                                Rollin.setDuration(700);
                                loadc.startAnimation(Rollin);
                                loadb.startAnimation(Rollin);
                                load.startAnimation(Rollin);
                                CountDownTimer timerb = new CountDownTimer(600,300) {
                                    @Override
                                    public void onTick(long l) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        loadc.setVisibility(View.GONE);
                                        loadb.setVisibility(View.GONE);
                                        load.setVisibility(View.GONE);
                                        headines.setText("The Headlines");
//                                        texty.setText("No rececent\n News or Information");

                                    }
                                }.start();
                            }
                        }
                    }.start();
                }
            }.start();
        }
    };
    @Override
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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
}
