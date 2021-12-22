package com.mycompany.myapp.thetframework;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class DocAdapter extends ArrayAdapter<Documents> {
    int resource;
    TextView docname;
    ImageView docimage;
    int posi;
    static List<Documents> documents;
    DocAdapter.OnGridClickedListener Listener;
    public DocAdapter(Context context, int resourece, List<Documents> documents){
        super(context,resourece,documents);
        this.resource =resourece;
        this.documents = documents;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        RelativeLayout gridViewe;
        CardView persontotal;
        Documents documento = documents.get(position);
        String docnamee = documento.getDocname();
        String docpath = documento.getDocpath();
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
        docname.setSelected(true);
//        personauthority = (TextView)gridViewe.findViewById(R.id.personauthority);
//        personname.setText(persons.getName());
        persontotal = (CardView) gridViewe.findViewById(R.id.innerdocard);
        docname.setText(docnamee);
//        p.setImageResource(R.mipmap.clienter);
//        if(documents.isGeneral()){
//            personauthority.setVisibility(View.VISIBLE);
//        }
        persontotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.OnGridClicked(position);
            }
        });
        return gridViewe;
    }

    public void setDocuments(List<Documents> documents) {
        this.documents = documents;
        this.notifyDataSetChanged();
    }

    public List<Documents> getDocuments() {
        return documents;
    }

    public interface OnGridClickedListener{
        public void OnGridClicked(int position);
    }
    public void setOnItemClickedListener (DocAdapter.OnGridClickedListener listener){
        this.Listener = listener;
    }
}

