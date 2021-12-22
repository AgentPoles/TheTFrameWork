package com.mycompany.myapp.thetframework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    LinearLayout beginners, poles;
    TranslateAnimation startu, poleupe, poledowne, transcont;
    AlphaAnimation goin, comeout;
    static int deletea = 0;
    ScaleAnimation maryscaleup, maryscaledown;
    Onanimend reyr;
    Intent mfra;

    TextView maary;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
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

        View v = inflater.inflate(R.layout.intro, container, false);

//          setContentView(R.layout.intro);
        try {
            mfra = new Intent(getActivity(), Startup.class);
            maary = (TextView) v.findViewById(R.id.maary);
            beginners = (LinearLayout) v.findViewById(R.id.begginers);
            poles = (LinearLayout) v.findViewById(R.id.poles);

            poles.setVisibility(View.GONE);
            maary.setVisibility(View.GONE);


            startu = new TranslateAnimation(-250, 0, 0, 0);
            poleupe = new TranslateAnimation(0, 0, 50, 0);
            poledowne = new TranslateAnimation(0, 0, 0, 50);
            transcont = new TranslateAnimation(0, 300, 0, 0);

            startu.setDuration(1000);
            poleupe.setDuration(1200);
            poledowne.setDuration(1200);
            transcont.setDuration(1200);

            goin = new AlphaAnimation(1, 0);
            comeout = new AlphaAnimation(0, 1);

            goin.setDuration(1200);
            comeout.setDuration(1200);

            maryscaledown = new ScaleAnimation(1, 1, 0, 0);
            maryscaleup = new ScaleAnimation(0, 0, 1, 1);

            maryscaledown.setDuration(1200);
            maryscaleup.setDuration(1200);

            beginners.startAnimation(startu);
            CountDownTimer timre = new CountDownTimer(1000, 500) {
                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    beginners.startAnimation(goin);
                    CountDownTimer gh = new CountDownTimer(1100, 500) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {

                            poles.setVisibility(View.VISIBLE);
                            beginners.setVisibility(View.GONE);
                            poles.startAnimation(poleupe);
                        }

                        CountDownTimer nm = new CountDownTimer(1100, 500) {
                            @Override
                            public void onTick(long l) {

                            }

                            @Override
                            public void onFinish() {
                                maary.setVisibility(View.VISIBLE);
                                maary.startAnimation(maryscaleup);
                                CountDownTimer yu = new CountDownTimer(2550, 500) {
                                    @Override
                                    public void onTick(long l) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        maary.startAnimation(goin);
                                        CountDownTimer bng = new CountDownTimer(1100, 500) {
                                            @Override
                                            public void onTick(long l) {

                                            }

                                            @Override
                                            public void onFinish() {
//                                                 beginners.setVisibility(View.INVISIBLE);
                                                maary.setVisibility(View.GONE);
                                                poles.startAnimation(poledowne);
                                                CountDownTimer fh = new CountDownTimer(1100, 500) {
                                                    @Override
                                                    public void onTick(long l) {

                                                    }

                                                    @Override
                                                    public void onFinish() {
                                                        poles.startAnimation(goin);

                                                        CountDownTimer hjt = new CountDownTimer(1100, 500) {
                                                            @Override
                                                            public void onTick(long l) {

                                                            }

                                                            @Override
                                                            public void onFinish() {
                                                                beginners.setVisibility(View.VISIBLE);
                                                                beginners.startAnimation(comeout);
                                                                beginners.startAnimation(transcont);
                                                                poles.setVisibility(View.GONE);
                                                                CountDownTimer hfd = new CountDownTimer(1000, 500) {
                                                                    @Override
                                                                    public void onTick(long l) {

                                                                    }

                                                                    @Override
                                                                    public void onFinish() {
                                                                        beginners.setVisibility(View.GONE);
                                                                        reyr.animeend();
                                                                        deletea = 1;
//                                                                         startActivity(mfra);
                                                                    }
                                                                }.start();
                                                            }
                                                        }.start();
                                                    }
                                                }.start();
                                            }
                                        }.start();
                                    }
                                }.start();
                            }
                        }.start();

                    }.start();
                }
            }.start();
        }
        catch (Exception e ){

        }
        return v;
    }
    public interface Onanimend{
        public void animeend();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        reyr = (Onanimend)activity;
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
