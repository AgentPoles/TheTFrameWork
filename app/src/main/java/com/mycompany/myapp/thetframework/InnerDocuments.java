package com.mycompany.myapp.thetframework;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.MimeTypeMap;
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

public class InnerDocuments extends AppCompatActivity implements DocAdapter.OnGridClickedListener {

    DocAdapter docAdapter;
    int resourceId;
    AppDatabase mDataBase;
    TextView totalname;
    boolean isGeneral;
    static String activityName;
    RelativeLayout reladdnewdocument;
    EditText ediaddnewdocument;
   static String filename;
    static String filepath;
    Uri pathy;
    boolean ispending;
    private static int REQUEST_CODE_DOC = 54;
    ImageView addnewdocument, canceldocument;
    FloatingActionButton adddocument;
    ActionBar j;
    Uri uri;
    List<Documents> drocuments = new ArrayList<>();
    GridView personsgrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_documents);
        resourceId = R.layout.innergrid;
        Intent gui = getIntent();
        j = getSupportActionBar();
        j.hide();
        isGeneral = false;
        mDataBase = AppDatabase.getsInstance(getApplicationContext());
        Bundle pauldk = gui.getExtras();
        personsgrid = (GridView)findViewById(R.id.docgride);
        totalname = (TextView)findViewById(R.id.totalname);
        adddocument = (FloatingActionButton)findViewById(R.id.adddocument);
        addnewdocument = (ImageView)findViewById(R.id.addnewdocument);
        canceldocument = (ImageView)findViewById(R.id.canceldocument);
        setUpInfo();
        ediaddnewdocument = (EditText)findViewById(R.id.edidocumentname);
        reladdnewdocument = (RelativeLayout)findViewById(R.id.relinnerdocument);
//        Documents docai = new Documents("java book", "djdd", false);
//        Documents docain = new Documents("python book", "dldk", true);
//        documents.add(docai);
//        documents.add(docain);
//        documents.add(docai);
//        documents.add(docain);
//        documents.add(docai);
//        documents.add(docain);
//        documents.add(docai);
//        documents.add(docain);
//        documents.add(docai);
//        documents.add(docain);
        ispending = false;
        activityName = pauldk.getString("foldername");
        totalname.setText(activityName);
        docAdapter = new DocAdapter(this, resourceId, drocuments);
//        docAdapter.notifyDataSetChanged();
        adddocument.setOnClickListener(adddocumentListener);
        canceldocument.setOnClickListener(canceldocumentListener);
        addnewdocument.setOnClickListener(addnewdocumentListener);
        docAdapter.setOnItemClickedListener(this);
//        toolbarng = (Toolbar)v.findViewById(R.id.toolbarng);
//        toolbarng.setLogoDescription("the engineers");
//        toolbarng.setTitle("eee engineers");
        personsgrid.setAdapter(docAdapter);
    }

    @Override
    public void OnGridClicked(final int position) {
        drocuments.get(position).setRead(true);

        try {
            displayo(drocuments.get(position).getDocpath());
            File myFile = new File(drocuments.get(position).getDocpath());
            displayo(myFile.toString());
            FileOpen.openFile(this, myFile);
//            openfile(drocuments.get(position).getDocpath());
        }
        catch (Exception e){

        }
        AppExecutor.getsInstance().diskIO().execute(
                new Runnable() {
                    @Override
                    public void run() {
                        mDataBase.docDao().updateDoc(drocuments.get(position));
                    }
                }
        );
    }
    private void choosefile() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select file"),2);

    }
    View.OnClickListener adddocumentListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            choosefile();
            adddocument.setVisibility(View.GONE);
            reladdnewdocument.setVisibility(View.VISIBLE);

        }
    };
    View.OnClickListener addnewdocumentListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(ediaddnewdocument.getText()==null||ediaddnewdocument.getText().toString().equals((""))){
                 displayo("please enter docment name");
            }
            else {
                if(activityName.equals("general")){
                    isGeneral = true;
                    ispending = true;
                }
                else {
                    isGeneral = false;
                    ispending = false;
                }
                final Documents doc = new Documents(ediaddnewdocument.getText().toString(),filepath,isGeneral,activityName,  true, ispending);
                AppExecutor.getsInstance().diskIO().execute(
                        new Runnable() {
                            @Override
                            public void run() {
                                mDataBase.docDao().insertDoc(doc);
                            }
                        }
                );
//                docAdapter.notifyDataSetChanged();
                reladdnewdocument.setVisibility(View.GONE);
                adddocument.setVisibility(View.VISIBLE);
            }
        }
    };
    View.OnClickListener canceldocumentListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
      reladdnewdocument.setVisibility(View.GONE);
      adddocument.setVisibility(View.VISIBLE);

        }
    };
    public void setUpInfo(){
        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
//        LiveData<List<Info>> infos = mDataBase.infoDao().LoadAllInfo();
        viewModel.getDoc().observe(this, new Observer<List<Documents>>() {
                    @Override
                    public void onChanged(@Nullable List<Documents> documents) {
                        drocuments.clear();
                        for(int i = 0;i<documents.size();i++){
                            if(documents.get(i).getFoldername().equals(activityName)){
                                drocuments.add(documents.get(i));
                            }

                        }
//                        documents.addAll(documents);
//                        docAdapter.setDocuments(documents);

//                Processors.getInstance().setInfod(folders);
docAdapter.notifyDataSetChanged();
                    }
                }
        );
    }
    private void browseDocuments(){

        String[] mimeTypes =
                {"application/msword","application/vnd.openxmlformats-officedocument.wordprocessingml.document", // .doc & .docx
                        "application/vnd.ms-powerpoint","application/vnd.openxmlformats-officedocument.presentationml.presentation", // .ppt & .pptx
                        "application/vnd.ms-excel","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", // .xls & .xlsx
                        "text/plain",
                        "application/pdf",
                        "application/zip"};

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            intent.setType(mimeTypes.length == 1 ? mimeTypes[0] : "*/*");
            if (mimeTypes.length > 0) {
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
            }
        } else {
            String mimeTypesStr = "";
            for (String mimeType : mimeTypes) {
                mimeTypesStr += mimeType + "|";
            }
            intent.setType(mimeTypesStr.substring(0,mimeTypesStr.length() - 1));
        }
        startActivityForResult(Intent.createChooser(intent,"ChooseFile"), REQUEST_CODE_DOC);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_DOC&&resultCode==RESULT_OK){
            displayo("result_ok");
           filename = data.getType();
//            uri.getScheme();
//            filename = uri.getAuthority();
            displayo(uri.getScheme());
            filepath = data.getDataString();
            ediaddnewdocument.setText(filename);
            displayo(filepath);
            displayo(filename);
        }
    }
public void openfile(String filepath)

    {
//        String url = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Saves/contacts.vcf";
        String url = Environment.getExternalStorageDirectory().getAbsolutePath() + filepath;
        File file = new File(url);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(url));
        intent.setDataAndType(Uri.fromFile(file), mimeType);
        Intent intent1 = Intent.createChooser(intent, "Open With");
        startActivity(intent1);
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
    public void displayoe(String ji) {
        Context context = this;
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
}
