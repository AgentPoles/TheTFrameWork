package com.mycompany.myapp.thetframework;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Chat.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Chat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Chat extends Fragment implements ImageAdapter.OnRecycleViewItemClicker, ChatAdapter.OnhasimageListener, ChatAdapter.OnRecycleViewItemClicker{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageAdapter personAdapter;
    ChatAdapter chatAdapter;
    List<Chatmessage> chatmessages = new ArrayList<>();
    int resourceId;
    List<Individual> persons = new ArrayList<>();
    RecyclerView Imagechatgrid, chatreci;
    private OnFragmentInteractionListener mListener;

    public Chat() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Chat.
     */
    // TODO: Rename and change types and number of parameters
    public static Chat newInstance(String param1, String param2) {
        Chat fragment = new Chat();
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
        View v = inflater.inflate(R.layout.fragment_chat, container, false);
        Imagechatgrid = (RecyclerView) v.findViewById(R.id.chatimagegrids);
        chatreci = (RecyclerView)v.findViewById(R.id.chatrecycler);
        Chatmessage chatmessagea = new Chatmessage("eeemmmmm", "hi hope you are good i really wanted to see you","Jane");
        Chatmessage chatmessageb = new Chatmessage("Godpoles10@gmail.com","oops i just left school, but i might come around by evening","paul");
        Individual individual = new Individual("Akhamiogu","09094938567","cool@fm",2,true);
        Individual rindividual = new Individual("charle", "08045363637","cool@ffm",3,true);
        chatmessages.add(chatmessagea); chatmessages.add(chatmessageb);
        chatmessages.add(chatmessagea); chatmessages.add(chatmessageb);
        chatmessages.add(chatmessagea); chatmessages.add(chatmessageb);
        chatmessages.add(chatmessagea); chatmessages.add(chatmessageb);
        persons.add(individual);   persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        chatmessages.add(chatmessagea); chatmessages.add(chatmessageb);
        chatmessages.add(chatmessagea); chatmessages.add(chatmessageb);
        chatmessages.add(chatmessagea); chatmessages.add(chatmessageb);
        chatmessages.add(chatmessagea); chatmessages.add(chatmessageb);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        persons.add(rindividual);  persons.add(individual);
        personAdapter = new ImageAdapter(persons,Chat.this);
        chatAdapter = new ChatAdapter(chatmessages,Chat.this,Chat.this);
        personAdapter.setOnItemclickedListener(this);
        chatAdapter.setOnItemclickedListener(this);
        RecyclerView.LayoutManager mlayoutManagere = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager mlayoutManager = new GridLayoutManager(getContext(),1,LinearLayoutManager.HORIZONTAL,false);
        personAdapter.notifyDataSetChanged();
        chatAdapter.notifyDataSetChanged();
        chatreci.setLayoutManager(mlayoutManagere);
        chatreci.setItemAnimator(new DefaultItemAnimator());
        Imagechatgrid.setLayoutManager(mlayoutManager);
        Imagechatgrid.setItemAnimator(new DefaultItemAnimator());
//        Imagechatgrid.setAdapter(personAdapter);
//        toolbarng = (Toolbar)v.findViewById(R.id.toolbarng);
//        toolbarng.setLogoDescription("the engineers");
//        toolbarng.setTitle("eee engineers");
        Imagechatgrid.setAdapter(personAdapter);
        chatreci.setAdapter(chatAdapter);
        return v;
    }

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
    public void OnRecycleViewItemclicked(int position) {

    }

    @Override
    public void OnRecycleViewItemclicked(View view, int position, String stringm, Drawable drawable) {

    }

    @Override
    public void hasimage(int position) {

    }

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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
