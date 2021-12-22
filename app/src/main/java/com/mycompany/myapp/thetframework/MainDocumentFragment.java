package com.mycompany.myapp.thetframework;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainDocumentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainDocumentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainDocumentFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TabLayout trabss;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentManager fragmentManager;
    ViewPager docViewpager;
    DocFragmentAdapter dAdapter;
    private MainDocumentFragment.OnFragmentInteractionListener mListener;
    private String[] tabnames = {
            "Answered",
            "UnAnswered"
    };
    public MainDocumentFragment() {
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
    public static MainDocumentFragment newInstance(String param1, String param2) {
        MainDocumentFragment fragment = new MainDocumentFragment();
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
        View voer = inflater.inflate(R.layout.documentfragment, container, false);
        trabss =(TabLayout)voer.findViewById(R.id.trabssc);
        trabss.setSelectedTabIndicatorColor(Color.parseColor("#eee6a4"));
//        trabss.addTab(trabss.newTab().setText("Buy Something"));
//        trabss.addTab(trabss.newTab().setText("Manage"),true);
        fragmentManager = getFragmentManager();
        dAdapter = new DocFragmentAdapter(getActivity().getSupportFragmentManager());
        docViewpager = (ViewPager)voer.findViewById(R.id.containerc);
        docViewpager.setAdapter(dAdapter);
//        trabss.setOnTabSelectedListener(trabssListener);
        trabss.setTabTextColors(Color.parseColor("#ffffff"),Color.parseColor("#ffffff"));
//        setupTabnames();
        trabss.setupWithViewPager(docViewpager);
        return  voer;
    }
    private void setupTabnames() {
        trabss.getTabAt(0).setText(tabnames[0]);
        trabss.getTabAt(1).setText(tabnames[1]);
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
