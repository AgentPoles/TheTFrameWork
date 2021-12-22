package com.mycompany.myapp.thetframework;

import android.app.Dialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragmenthome.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragmenthome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmenthome extends Fragment implements PersonAdapter.OnGridClickedListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Intent i;
    AppDatabase mDb;
    Toolbar toolbarng;
    public  Uri filePath;
    File fii;
    static String othernumber;
    static String otheremail;
    ImageView groupImageback, rollingthrough;
    CircleImageView groupImage;
    Bitmap imagebitmap;
    String mCurrentPhotoPathe;
    ImageView searchuser, editgroupname, edituserdetails, more, less;
    FloatingActionButton editgroupimage;
    EditText numberofmembers;
    TextView wordparticipant , groupname;
    PersonAdapter personAdapter;
    int resourceId, hopeimage;
    EditText editgroupnamee;
    TextView statusbare, othername;
    ImageView othersproceed, otherimage, smartphone, sms, gmail;
    float defaulttextsize, groupnamedefault;
    Dialog user, others;
    ImageView yoursettings, othersgobackhome;
    RelativeLayout allpeople, youandothers, othersprofile;
    int searchuserwatcher, editgroupnamewatcher;
    List<User> persons = new ArrayList<>();
    GridView personsgrid, personsgridb;
    private OnFragmentInteractionListener mListener;

    public Fragmenthome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmenthome.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmenthome newInstance(String param1, String param2) {
        Fragmenthome fragment = new Fragmenthome();
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
        View v = inflater.inflate(R.layout.fragment_fragmenthome, container, false);
        resourceId = R.layout.individual;
        personsgrid = (GridView)v.findViewById(R.id.personsgrid);
        personsgridb = (GridView)v.findViewById(R.id.personsgridb);
        more = (ImageView)v.findViewById(R.id.more);
        less = (ImageView)v.findViewById(R.id.less);
        othersgobackhome = (ImageView)v.findViewById(R.id.otherprofileback);
        less.requestFocus();
        yoursettings = (ImageView)v.findViewById(R.id.yoursettings);
        groupImageback = (ImageView)v.findViewById(R.id.groupimageback);
        groupImage = (CircleImageView)v.findViewById(R.id.groupimage);
        yoursettings.setOnClickListener(yoursettingsListener);
        othersgobackhome.setOnClickListener(othersgobackhomeListener);
        youandothers = (RelativeLayout)v.findViewById(R.id.youandothers);
        mDb = AppDatabase.getsInstance(getContext());
        othersprofile = (RelativeLayout)v.findViewById(R.id.otherprofilerel);
        searchuserwatcher = 0;
        editgroupnamewatcher = 0;
        otherimage = (ImageView)v.findViewById(R.id.otherimage);
        othername = (TextView)v.findViewById(R.id.othername);
        rollingthrough = (ImageView)v.findViewById(R.id.rollingthrough);
        sms = (ImageView)v.findViewById(R.id.sms);
        smartphone = (ImageView)v.findViewById(R.id.smartphone);
        gmail = (ImageView)v.findViewById(R.id.gmail);
        statusbare = (TextView)v.findViewById(R.id.otherstatus);
        allpeople = (RelativeLayout)v.findViewById(R.id.allpeoplerel);
//        Individual individual = new Individual("Akhamiogu","09094938567","cool@fm",2,true);
//        Individual rindividual = new Individual("charle", "08045363637","cool@ffm",3,true);
//        persons.add(individual);   persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
//        persons.add(rindividual);  persons.add(individual);
wordparticipant = (TextView)v.findViewById(R.id.wordparticipant);
groupname = (TextView)v.findViewById(R.id.groupname);
numberofmembers = (EditText)v.findViewById(R.id.numberofmembers);
searchuser = (ImageView)v.findViewById(R.id.usersearch);
editgroupname = (ImageView)v.findViewById(R.id.editgroupname);
editgroupimage = (FloatingActionButton) v.findViewById(R.id.editgroupimage);
        edituserdetails = (ImageView)v.findViewById(R.id.yoursettings);
        groupname.setBackgroundColor(Color.TRANSPARENT);
        editgroupname.setOnClickListener(editgroupnameListener);
        searchuser.setOnClickListener(searchUserListener);
        less.setOnClickListener(lessListener);
       i  = new Intent(getActivity(),YourSettings.class);
        more.setOnClickListener(moreListener);
        user = new Dialog(getContext());
        user.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        user.setContentView(R.layout.userprofile);
        others = new Dialog(getContext());
        defaulttextsize = numberofmembers.getTextSize();
        groupnamedefault = groupname.getTextSize();
        others.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        others.setContentView(R.layout.othersprofile);
        othersproceed = (ImageView)others.findViewById(R.id.othersproceed);
        editgroupnamee = (EditText)others.findViewById(R.id.editgroupnamee);
        othersproceed.setOnClickListener(othersproceedListener);
        editgroupimage.setOnClickListener(editgroupImageListener);
                personAdapter= new PersonAdapter(getContext(),resourceId,persons);
        personAdapter.notifyDataSetChanged();
        personAdapter.setOnItemClickedListener(this);
//        toolbarng = (Toolbar)v.findViewById(R.id.toolbarng);
//        toolbarng.setLogoDescription("the engineers");
//        toolbarng.setTitle("eee engineers");
        personsgrid.setAdapter(personAdapter);
        smartphone.setOnClickListener(smartphoneListener);
        gmail.setOnClickListener(gmailListener);
        sms.setOnClickListener(smsListener);
        personsgridb.setAdapter(personAdapter);
        setUpInfo();
        return v;
    }
View.OnClickListener smsListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(othernumber!=null) {
            Uri uris = Uri.parse(othernumber);
            Intent rintent = new Intent(Intent.ACTION_SEND, uris);
            rintent.addCategory(Intent.CATEGORY_APP_MESSAGING);
            startActivity(rintent);
        }
        else {
            displayo("could not find your number");
        }
    }
};
    View.OnClickListener gmailListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(otheremail!=null) {
                Uri uris = Uri.parse(otheremail);
                Intent rintent = new Intent(Intent.ACTION_SEND, uris);
                rintent.addCategory(Intent.CATEGORY_APP_EMAIL);
                startActivity(rintent);
            }
            else {
                displayo("could not find your email");
            }
        }
    };
    View.OnClickListener smartphoneListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(othernumber!=null) {
                Uri uris = Uri.parse(othernumber);
                Intent rintent = new Intent(Intent.ACTION_CALL, uris);
                startActivity(rintent);
            }
            else {
                displayo("could not find your number");
            }
        }
    };
    @Override
    public void OnGridClicked(final int position) {
//        allpeople.setVisibility(View.VISIBLE);
   more.setVisibility(View.GONE);
   less.setVisibility(View.GONE);
   edituserdetails.setVisibility(View.GONE);
   othername.setText(persons.get(position).getUsername());
   if(persons.get(position).getStatus()!=null) {
       statusbare.setText(persons.get(position).getStatus());
   }
   othernumber = persons.get(position).getMobile();
   otheremail = persons.get(position).getEmail();
   persons.get(position).setReadstatus(true);
        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        mDb.userDao().updateUser(persons.get(position));
                    }
                }
        );

   othersprofile.setVisibility(View.VISIBLE);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    View.OnClickListener othersgobackhomeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            more.setVisibility(View.VISIBLE);
            less.setVisibility(View.VISIBLE);
            if(!personsgridb.isShown()){
                allpeople.setVisibility(View.GONE);
            }
            edituserdetails.setVisibility(View.VISIBLE);
            othersprofile.setVisibility(View.GONE);
        }
    };
    View.OnClickListener searchUserListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (searchuserwatcher == 0) {
                numberofmembers.setTextSize(20);
                numberofmembers.setCursorVisible(true);
                numberofmembers.setText(null);
                numberofmembers.setHint("search member");
                numberofmembers.requestFocus();
                numberofmembers.setHintTextColor(Color.WHITE);
                searchuser.setImageResource(R.drawable.enter);
                wordparticipant.setVisibility(View.GONE);
                searchuserwatcher = 1;
            } else {
                if (searchuserwatcher == 1) {
                    numberofmembers.setHint("22");
                    numberofmembers.setTextSize(defaulttextsize);
                    numberofmembers.setText("22");
                    wordparticipant.setVisibility(View.VISIBLE);
                    numberofmembers.setBackgroundColor(Color.TRANSPARENT);
                    searchuser.setImageResource(R.drawable.search);
                    searchuserwatcher = 0;
                    numberofmembers.setCursorVisible(false);
                }
            }
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2
                && data != null && data.getData() != null) {
//          secondpath = Uri.parse(compressImage(data.getData().getPath()));
            filePath = data.getData();
            fii = new File(filePath.getPath());

            try {

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), filePath);
                imagebitmap = bitmap;
                mCurrentPhotoPathe = filePath.getPath();
                displayo(mCurrentPhotoPathe);

                groupImage.setImageBitmap(bitmap);
                groupImageback.setImageBitmap(bitmap);
//                imageViewe.setVisibility(View.VISIBLE);
                hopeimage = 1;

//                displayo(mCurrentPhotoPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    View.OnClickListener lessListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            allpeople.setVisibility(View.GONE);
            more.setVisibility(View.VISIBLE);
            youandothers.setVisibility(View.VISIBLE);
//            new User();
        }
    };
//    public User(String username, String password, String email,String mobile, String classe, int questions, int answer, long timemonitor, boolean admin){
    View.OnClickListener yoursettingsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           startActivity(i);
//            final User user = new User("Happy G the boy","2344","tty","098080809","sfs",1,1,(long)12000000,true,"3463636",false,"tetetett");
//            AppExecutor.getsInstance().diskIO().execute(
//                    new Runnable() {
//                        @Override
//                        public void run() {
//                            mDb.userDao().insertUser(user);
//                        }
//                    }
//            );
        }
    };
    View.OnClickListener moreListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            allpeople.setVisibility(View.VISIBLE);
            more.setVisibility(View.GONE);
            personsgridb.setVisibility(View.VISIBLE);
            youandothers.setVisibility(View.GONE);
        }
    };
     View.OnClickListener othersproceedListener = new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if(editgroupnamee.getText()!=null)
             groupname.setText(editgroupnamee.getText());
       others.cancel();
         }
     };
        View.OnClickListener editgroupnameListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                others.show();
            }
        };
    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select image file"),2);
    }

    View.OnClickListener editgroupImageListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chooseImage();
                }
            };
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
public void setUpInfo(){
    MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
//        LiveData<List<Info>> infos = mDataBase.infoDao().LoadAllInfo();
    viewModel.getUser().observe(this, new Observer<List<User>>() {
                @Override
                public void onChanged(@Nullable List<User> users) {
//                  docAdapter.setFolders(folders);
//                displayo(String.valueOf(folders.size()));
//                documents = folders;
                    persons.clear();
                    persons.addAll(users);

//                displayo(String.valueOf(documents.size()));
//               documents = Collections.addAll(folders);
//                Collections.addAll(documents,folders);
//                docAdapter.setFolders(folders);
                    personAdapter.notifyDataSetChanged();
                }
            }
    );
}
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
