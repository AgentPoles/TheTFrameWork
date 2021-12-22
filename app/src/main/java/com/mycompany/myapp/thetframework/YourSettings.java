package com.mycompany.myapp.thetframework;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class YourSettings extends AppCompatActivity {
    EditText usernumber, useremail, userstatus, userdob, userskill, username, userclass;
    FloatingActionButton chooseuserimage, edituserdetails;
    ImageView userimage;
    Uri filePath;
    File fii;
    AppDatabase mdatabase;
    Bitmap imagebitmap;
    int hopeimage;
    String userid;
    int mquestione, manswere;
    String password;
    String uriString;
    MyDataService myDataService;
    Intent myDataServiceIntent;
    boolean newImage;
    String downloaduri, thumblineuri;
    Intent myUploadUserDetailsIntent;
    UploadUserDetails uploadUserDetails;
    String name, email, number, skill, dateofbirth, classd;
    boolean hasimage;
    static SharedPreferences mysharedpreference;
    SharedPreferences.Editor myeditor;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    ImageView srollingthrough;
    static String mCurrentPhotoPathy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference("userimages");
        mysharedpreference = getSharedPreferences("readstate",MODE_PRIVATE);
        myeditor = mysharedpreference.edit();
        hasimage = mysharedpreference.getBoolean("hasimage",false);
        userid = mysharedpreference.getString("userid","");
       password = mysharedpreference.getString("password","");
       newImage = false;
       mdatabase = AppDatabase.getsInstance(this);
//        chooseuserimage = (FloatingActionButton) findViewById(R.id.chooseuserphoto);
        edituserdetails = (FloatingActionButton) findViewById(R.id.edituserdetails);
        userimage = (ImageView) findViewById(R.id.userimageee);
        useremail = (EditText) findViewById(R.id.useremaile);
        usernumber = (EditText) findViewById(R.id.usernumber);
        userskill = (EditText) findViewById(R.id.userskill);
        userdob = (EditText) findViewById(R.id.userdob);
        username = (EditText) findViewById(R.id.username);
        userstatus = (EditText)findViewById(R.id.userstatus);
        userclass = (EditText)findViewById(R.id.userclass);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
//        srollingthrough = (ImageView)findViewById(R.id.srollingthrough);
        useremail.setText(mysharedpreference.getString("useremail",""));
        userdob.setText(mysharedpreference.getString("dateOfBirth",""));
        userskill.setText(mysharedpreference.getString("skill",""));
        usernumber.setText(mysharedpreference.getString("usernumber",""));
        username.setText(mysharedpreference.getString("username",""));
        userclass.setText(mysharedpreference.getString("userclass",""));
        manswere = mysharedpreference.getInt("answering",0);
        manswere = mysharedpreference.getInt("questioning",0);
        downloaduri = mysharedpreference.getString("downloaduri","");
        thumblineuri = mysharedpreference.getString("thumblineuri","");
        if(hasimage){
            storageReference = firebaseStorage.getReference("userimages").child(userid);
            newshowit(this,storageReference,userimage);
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "POLES, serving you right", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                chooseImage();
            }
        });
        fab.requestFocus();
        edituserdetails.setOnClickListener(edituserdetailsListener);
        databaseReference.child(userid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                name = dataSnapshot.child("username").getValue().toString();
                email = dataSnapshot.child("email").getValue().toString();
                number = dataSnapshot.child("mobile").getValue().toString();
                classd = dataSnapshot.child("classe").getValue().toString();
                password = dataSnapshot.child("password").getValue().toString();
                dateofbirth = dataSnapshot.child("dateOfBirth").getValue().toString();
                skill = dataSnapshot.child("skill").getValue().toString();
                userid = dataSnapshot.child("userid").getValue().toString();
                hasimage = Boolean.parseBoolean(dataSnapshot.child("hasimage").getValue().toString());
                manswere = Integer.parseInt(dataSnapshot.child("answer").getValue().toString());
                mquestione = Integer.parseInt(dataSnapshot.child("question").getValue().toString());
                downloaduri = dataSnapshot.child("downloaduri").getValue().toString();
               new namepro(dataSnapshot);
               userclass.setText(classd);
               userdob.setText(dateofbirth);
               useremail.setText(email);
               username.setText(name);
               usernumber.setText(number);
               userskill.setText(skill);
               if(hasimage){
                  if(downloaduri!=null){
                      storageReference = firebaseStorage.getReference("userimages").child("real"+userid);
                      newshowit(getApplicationContext(),storageReference,userimage);
                  }
                  else {
                      storageReference = firebaseStorage.getReference("userimages").child(userid);
                      newshowit(getApplicationContext(),storageReference,userimage);
                  }
               }
//                 = Integer.parseInt(dataSnapshot.child("business").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//        chooseuserimage.setOnClickListener(chooseuserimageListener);
    }

    View.OnClickListener edituserdetailsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(confirmconnection()) {
                Snackbar.make(v, "i am uploading your details to our POLES online storage", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                name = username.getText().toString();
                number = usernumber.getText().toString();
                classd = userclass.getText().toString();
                email = useremail.getText().toString();
                dateofbirth = userdob.getText().toString();
                skill = userskill.getText().toString();
                User user = new User(userid,name,password,email,number,classd,mquestione,manswere,0,false,dateofbirth,false,"",skill,hasimage,uriString,thumblineuri,downloaduri);
                if(newImage){
                    processall.getInstance().setUser(user);
                    uploadUserDetails = new UploadUserDetails();
                    myUploadUserDetailsIntent = new Intent(getApplicationContext(),UploadUserDetails.class);

                    try{
                        if (!isMyServiceRunning(uploadUserDetails.getClass())) {
                            startService(myUploadUserDetailsIntent);
                        }
                    }
                    catch (Exception e){

                    }
                }
                else {
//                    databaseReference = firebaseDatabase.getReference("Users");
                    databaseReference.child(userid).setValue(user).addOnCompleteListener(
                            new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    displayo("your details have been updated");
                                    if(task.isSuccessful()) {
                                        try {

                                            myDataService = new MyDataService();
                                            myDataServiceIntent = new Intent(getApplicationContext(), MyDataService.class);
                                            if (isMyServiceRunning(myDataService.getClass())) {
                                                stopService(myDataServiceIntent);
                                            }

                                            startService(myDataServiceIntent);

                                        }
                                        catch (Exception e){

                                        }
                                        insertclass(email,classd);
                                        myeditor.putBoolean("finishstate",true);
                                        myeditor.apply();
                                    }
                                    else {
                                        displayo("error updating your details");
                                    }
                                }
                            }
                    );


                }
//                usernd = new User(userid,smname, popasswordb, poemailb, smnumber, mclassy, mquestion, manswer, 0, false, "", false, "","");
//                          public User(String userid,String username long timemonitor, boolean admin,String dateOfBirth, boolean readstatus, String status, String skill, boolean hasimage){
//                number = usernumber.getText().toString();

            }
            else {
                Snackbar.make(v, "please ensure your are connected to the internet", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
            username.requestFocus();
//            edituserdetails.setImageResource(R.drawable.editee);
        }
    };
    View.OnClickListener chooseuserimageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chooseImage();
        }
    };

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select image file"), 2);
    }
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {

                Log.i ("isMyServiceRunning?", true+"");
                return true;
            }
        }
        Log.i ("isMyServiceRunning?", false+"");
        return false;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2
                && data != null && data.getData() != null) {
//          secondpath = Uri.parse(compressImage(data.getData().getPath()));
            filePath = data.getData();
            String f = data.getData().toString();
            uriString = f;
            fii = new File(filePath.getPath());

               newImage = true;

                          newshowite(this,Uri.parse(f),userimage);
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), filePath);
//
//                String path = MediaStore.Images.Media.getContentUri(f).toString();
//                imagebitmap = bitmap;
//                mCurrentPhotoPathy = filePath.getPath();
//                displayo(path);
//
//                userimage.setImageBitmap(bitmap);
////                groupImageback.setImageBitmap(bitmap);
////                imageViewe.setVisibility(View.VISIBLE);
//                hopeimage = 1;

//
        }
    }
    public void displayo(String ji) {
        Context context = this;
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
    public void newshowit(Context context, StorageReference storageReference, ImageView imageView) {

//        progressquestioninner.setVisibility(View.VISIBLE);
        GlideApp.with(context /* context */)
                .load(storageReference)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        // log exception
                        Log.e("TAG", "Error loading image", e);
//                        progressquestioninner.setVisibility(View.GONE);

                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
//                        progressquestioninner.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageView);


    }
    public void newshowite(Context context, Uri uri, ImageView imageView) {

//        progressquestioninner.setVisibility(View.VISIBLE);

        GlideApp.with(context /* context */)
                .load(uri)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        // log exception
                        Log.e("TAG", "Error loading image", e);
//                        progressquestioninner.setVisibility(View.GONE);
//                        sayreload.setVisibility(View.VISIBLE);
//                        rollit.setVisibility(View.VISIBLE);
                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, com.bumptech.glide.load.DataSource dataSource, boolean isFirstResource) {
//                        progressquestioninner.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageView);

    }
    public boolean confirmconnection() {
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
public void insertclass(String useremail, String classname){
        final Classors classors = new Classors(classname, useremail, false, false, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()),true);
        AppExecutor.getsInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                try{
                    mdatabase.classorsDao().insertClassor(classors);
                }
                catch (Exception e){
                    mdatabase.classorsDao().updateClassor(classors);
                }
            }
        });

    }
}