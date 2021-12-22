package com.mycompany.myapp.thetframework;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragmen
 * t must implement the
 * {@link Polesdisplay.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Polesdisplay#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Polesdisplay extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FloatingActionButton proceed;
    private OnFragmentInteractionListener mListener;

    public Polesdisplay() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Polesdisplay.
     */
    // TODO: Rename and change types and number of parameters
    public static Polesdisplay newInstance(String param1, String param2) {
        Polesdisplay fragment = new Polesdisplay();
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
        View nb =  inflater.inflate(R.layout.fragment_polesdisplay, container, false);
        proceed =  (FloatingActionButton)nb.findViewById(R.id.proceed);
        proceed.setOnClickListener(pleaseProceed);
        return nb;
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
    private void checkPlayService() {
        int isGPSAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(getActivity());

        Toast.makeText(getActivity(), "isGPSAvailable " + isGPSAvailable, Toast.LENGTH_SHORT).show();
        switch (isGPSAvailable) {
            case ConnectionResult.API_UNAVAILABLE: {
                //API is not available
                displayo("sorry friend , API is not available");
                break;
            }
            case ConnectionResult.NETWORK_ERROR: {
                //Network error while connection
                displayo(" a network error just occurred, please try again");
                break;
            }
            case ConnectionResult.RESTRICTED_PROFILE: {
                //Profile is restricted by google so can not be used for play services
                displayo("something went wrong");
                displayo("Profile is restricted by google so can not be used for play services");
                break;
            }
            case ConnectionResult.SERVICE_MISSING: {
                //service is missing
                Toast.makeText(getActivity(), "play service is missing", Toast.LENGTH_LONG);
                break;
            }
            case ConnectionResult.SIGN_IN_REQUIRED: {
                //service available but user not signed in
                displayo("sorry, play service is available but you are not signed in..try to fix this");
                break;
            }
            case ConnectionResult.SERVICE_INVALID: {

                displayo("The version of the Google Play services installed on this device is not authentic");
                break;
            }
            case ConnectionResult.SUCCESS: {
                Intent f = new Intent(getActivity(), Startup.class);
                startActivity(f);
                getActivity().overridePendingTransition(R.transition.slide_from_right, R.transition.slide_to_left);
                getActivity().finish();
                break;
            }
            case ConnectionResult.API_VERSION_UPDATE_REQUIRED : {
                displayo("API_VERSION update required");
                break;
            }
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED : {
              displayo("GOOGLE_PLAY_SERVICE_VERSION update required");
                break;
            }
        }
    }
    View.OnClickListener pleaseProceed = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          checkPlayService();
        }
    };
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
