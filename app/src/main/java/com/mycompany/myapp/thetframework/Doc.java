package com.mycompany.myapp.thetframework;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Doc.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Doc#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Doc extends Fragment implements FolderAdapter.OnGridClickedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FolderAdapter docAdapter;
    ImageView canceladdfolder;
    int resourceId;
    static int previousstate;
    static List<Folders> documents = new ArrayList<>();
    GridView personsgrid;
    Intent innerdocs;
   static RelativeLayout reladdnewfolder;
    FloatingActionButton addfolder;
    ImageView addnewfolder;
    AppDatabase mDatabase;
    EditText edinewfolder;
    private OnFragmentInteractionListener mListener;

    public Doc() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Doc.
     */
    // TODO: Rename and change types and number of parameters
    public static Doc newInstance(String param1, String param2) {
        Doc fragment = new Doc();
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
        View v = inflater.inflate(R.layout.fragment_doc, container, false);
        resourceId = R.layout.innergrid;
        previousstate = MainActivity.centrewatcher;
        personsgrid = (GridView)v.findViewById(R.id.docgrid);
        edinewfolder = (EditText)v.findViewById(R.id.edifolername);
        addnewfolder = (ImageView)v.findViewById(R.id.addnewfolder);
        innerdocs = new Intent(getActivity(),InnerDocuments.class);
        reladdnewfolder = (RelativeLayout)v.findViewById(R.id.reladdnewfolder);
        canceladdfolder  = (ImageView)v.findViewById(R.id.canceladdfolder);
//        Folders docai = new Folders("general","abi");

        mDatabase = AppDatabase.getsInstance(getContext());

//        Folders docain = new Folders("personal","abo");
//        documents.add(docain);   documents.add(docain);
        addfolder = (FloatingActionButton)v.findViewById(R.id.addfolder);
        docAdapter= new FolderAdapter(getActivity(),resourceId,documents);
//        docAdapter.notifyDataSetChanged();
        canceladdfolder.setOnClickListener(canceladdfolderListener);
        docAdapter.setOnItemClickedListener(this);
//        toolbarng = (Toolbar)v.findV
// iewById(R.id.toolbarng);
//        toolbarng.setLogoDescription("the engineers");
//        toolbarng.setTitle("eee engineers");
        setUpInfo();

        docAdapter.notifyDataSetChanged();
        addfolder.setOnClickListener(addfolderListener);
        addnewfolder.setOnClickListener(addnewfolderListener);
        personsgrid.setAdapter(docAdapter);
        return v;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void OnGridClicked(final int position) {
//        final int prosition = position;
        documents.get(position).setRead(true);
        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        mDatabase.folderDao().updateFolder(documents.get(position));
                    }
                }
        );
        innerdocs.putExtra("foldername",documents.get(position).getFoldername());
        startActivity(innerdocs);
    }
    //
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
    View.OnClickListener addfolderListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            previousstate = MainActivity.centrewatcher;
     reladdnewfolder.setVisibility(View.VISIBLE);
     MainActivity.centrewatcher = 2;
     addfolder.setVisibility(View.GONE);
        }
    };
    View.OnClickListener canceladdfolderListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
      reladdnewfolder.setVisibility(View.GONE);
      MainActivity.centrewatcher = previousstate;
      addfolder.setVisibility(View.VISIBLE);
        }
    };

    View.OnClickListener addnewfolderListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (edinewfolder.getText() == null || edinewfolder.getText().toString().equals("")) {
               displayo("your have not entered a folder name");
            } else {
                final Folders fold = new Folders(edinewfolder.getText().toString(), "abo",false,true);
//                documents.add();
                AppExecutor.getsInstance().diskIO().execute(
                        new Runnable() {
                            @Override
                            public void run() {
                                mDatabase.folderDao().insertFolder(fold);
                            }
                        }
                );

//                docAdapter.notifyDataSetChanged();
                MainActivity.centrewatcher = previousstate;
                reladdnewfolder.setVisibility(View.GONE);
                addfolder.setVisibility(View.VISIBLE);
            }
        }
    };
    public void setUpInfo(){
        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
//        LiveData<List<Info>> infos = mDataBase.infoDao().LoadAllInfo();
        viewModel.getFolder().observe(this, new Observer<List<Folders>>() {
            @Override
            public void onChanged(@Nullable List<Folders> folders) {
//                  docAdapter.setFolders(folders);
//                displayo(String.valueOf(folders.size()));
//                documents = folders;
                documents.clear();
                documents.addAll(folders);

//                displayo(String.valueOf(documents.size()));
//               documents = Collections.addAll(folders);
//                Collections.addAll(documents,folders);
//                docAdapter.setFolders(folders);
                docAdapter.notifyDataSetChanged();
             }
            }
        );
    }

    public void setDocuments(List<Folders> documents) {
        this.documents = documents;
    }

    public List<Folders> getDocuments() {
        return documents;
    }

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
