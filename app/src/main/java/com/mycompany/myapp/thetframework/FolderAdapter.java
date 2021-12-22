package com.mycompany.myapp.thetframework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class FolderAdapter extends ArrayAdapter<Folders> {
    int resource;
    TextView docname;
    ImageView docimage;
    ImageView pendinginnergrid, readstateinnergrid;
    int posi;
    private List<Folders> folders;
    OnGridClickedListener Listener;

    public FolderAdapter(Context context, int resourece,List<Folders> documents){
        super(context,resourece,documents);
        this.resource =resourece;
        this.folders = documents;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RelativeLayout gridViewe;
        CardView persontotal;
        Folders documents = folders.get(position);
        String docnamee = documents.getFoldername();
        String docpath = documents.getFolderpath();
        posi = position;
        if(convertView == null){
            gridViewe = new RelativeLayout(getContext());
            String Inflator = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li;
            li = (LayoutInflater)getContext().getSystemService(Inflator);
            li.inflate(resource,gridViewe,true);
        }
        else{
            gridViewe = (RelativeLayout) convertView;
        }
        docimage = (ImageView)gridViewe.findViewById(R.id.docimage);
        docname = (TextView)gridViewe.findViewById(R.id.docname);
        pendinginnergrid = (ImageView)gridViewe.findViewById(R.id.pendinginnergrid);
        readstateinnergrid = (ImageView)gridViewe.findViewById(R.id.readstateinnergrid);
        docname.setSelected(true);
        if(docnamee.equals("general")){
            docimage.setImageResource(R.drawable.generalfolder);

        }
        else {
            if (docnamee.equals("personal")) {
                docimage.setImageResource(R.drawable.personalfolder);
            } else {
                docimage.setImageResource(R.drawable.otherfolder);
            }
        }

            docname.setText(docnamee);

//        personauthority = (TextView)gridViewe.findViewById(R.id.personauthority);
//        personname.setText(persons.getName());

        persontotal = (CardView) gridViewe.findViewById(R.id.innerdocard);
//        p.setImageResource(R.mipmap.clienter);
//        if(documents.isGeneral()){
//            personauthority.setVisibility(View.VISIBLE);
//        }
        if(documents.isPending()){
            pendinginnergrid.setVisibility(View.VISIBLE);
        }
        else {
            pendinginnergrid.setVisibility(View.GONE);
        }
        if(documents.isRead()){
            readstateinnergrid.setVisibility(View.GONE);
        }
        else {
            readstateinnergrid.setVisibility(View.VISIBLE);
        }
        persontotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.OnGridClicked(position);
            }
        });
        return gridViewe;
    }

    public interface OnGridClickedListener{
        public void OnGridClicked(int position);
    }
    public void setOnItemClickedListener (OnGridClickedListener listener){
        this.Listener = listener;
    }

    public void setFolders(List<Folders> folders) {
        this.folders = folders;
        this.notifyDataSetChanged();
    }

    public List<Folders> getFolders() {
        return folders;
    }
}

