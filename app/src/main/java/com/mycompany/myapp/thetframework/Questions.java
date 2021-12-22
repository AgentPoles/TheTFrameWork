package com.mycompany.myapp.thetframework;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Questions.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Questions#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Questions extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TabLayout trabss;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentManager fragmentManager;
    ViewPager questionsViewpager;
    QuestionFragmentAdapter qAdapter;
    private OnFragmentInteractionListener mListener;
    private int[] tabicons = {
            R.drawable.allye,
            R.drawable.soccer,
            R.drawable.unan
    };
    public Questions() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Questions.
     */
    // TODO: Rename and change types and number of parameters
    public static Questions newInstance(String param1, String param2) {
        Questions fragment = new Questions();
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
       View voer = inflater.inflate(R.layout.fragment_questions, container, false);
        trabss =(TabLayout)voer.findViewById(R.id.trabssb);
        trabss.setSelectedTabIndicatorColor(Color.parseColor("#eee6a4"));
//        trabss.addTab(trabss.newTab().setText("Buy Something"));
//        trabss.addTab(trabss.newTab().setText("Manage"),true);
        fragmentManager = getFragmentManager();
        qAdapter = new QuestionFragmentAdapter(getActivity().getSupportFragmentManager());
         questionsViewpager = (ViewPager)voer.findViewById(R.id.containerb);
         questionsViewpager.setAdapter(qAdapter);
//        trabss.setOnTabSelectedListener(trabssListener);
        trabss.setTabTextColors(Color.parseColor("#ffffff"),Color.parseColor("#ffffff"));

        trabss.setupWithViewPager(questionsViewpager);
        setupTabIcons();
        return  voer;
    }
    private void setupTabIcons() {
        trabss.getTabAt(0).setIcon(tabicons[0]);
        trabss.getTabAt(1).setIcon(tabicons[1]);
        trabss.getTabAt(2).setIcon(tabicons[2]);
    }
//    TabLayout.OnTabSelectedListener trabssListener = new TabLayout.OnTabSelectedListener() {
//        @Override
//        public void onTabSelected(TabLayout.Tab tab) {
//            if (tab.getPosition()==0){
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.ineer_busi_fragment,
//                        new Answered());
//                fragmentTransaction.commit();
//            }
//            if(tab.getPosition()==1){
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.ineer_busi_fragment,
//                        new Unanswered());
//                fragmentTransaction.commit();
//            }
//        }
//        @Override
//        public void onTabUnselected(TabLayout.Tab tab) {
//        }
//        @Override
//        public void onTabReselected(TabLayout.Tab tab) {
//        }
//    };


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
}
