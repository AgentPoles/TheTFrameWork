package com.mycompany.myapp.thetframework;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Paul on 5/19/2018.
 */
public class PersonAdapter extends ArrayAdapter<User> {
    int resource;
    TextView personname, personauthority;
    ImageView personimage, individualviewed;
    int posi;
    OnGridClickedListener Listener;
    public PersonAdapter(Context context, int resourece, List<User> persons){
        super(context,resourece,persons);
        this.resource =resourece;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RelativeLayout gridViewe;
        LinearLayout persontotal;
        User persons = getItem(position);
        String personnamee = persons.getUsername();
        String personemaill = persons.getEmail();
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
        personimage = (ImageView)gridViewe.findViewById(R.id.personimage);
        personname = (TextView)gridViewe.findViewById(R.id.personname);
        individualviewed = (ImageView)gridViewe.findViewById(R.id.individualviewed);
        personauthority = (TextView)gridViewe.findViewById(R.id.personauthority);
        personname.setText(persons.getUsername());
        personname.setSelected(true);
        persontotal = (LinearLayout) gridViewe.findViewById(R.id.persontotal);
//        p.setImageResource(R.mipmap.clienter);
        if(persons.isAdmin()){
            personauthority.setVisibility(View.VISIBLE);
        }
        else {

        }
        persontotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.OnGridClicked(position);
            }
        });
        if(persons.isReadstatus()){
            individualviewed.setVisibility(View.GONE);
        }
        if(!persons.isReadstatus()){
            individualviewed.setVisibility(View.VISIBLE);
        }
        return gridViewe;
    }

    public interface OnGridClickedListener{
        public void OnGridClicked(int position);
    }
    public void setOnItemClickedListener (OnGridClickedListener listener){
        this.Listener = listener;
    }
}


