package com.mycompany.myapp.thetframework;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
 * Created by Paul on 5/23/2018.
 */
public class ImageAdapter  extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {
    private List<Individual> IndividuaLists;
    int i;
    static int je;
    OnRecycleViewItemClicker Listener;
    public class  MyViewHolder extends RecyclerView.ViewHolder {
        TextView personname;
        ImageView personImage;

        View view;

        public MyViewHolder(View view) {

            super(view);
            this.view = view;
            personImage = (ImageView)view.findViewById(R.id.personimagee);
            personname = (TextView)view.findViewById(R.id.personnamee);
//            newsdate = (TextView) view.findViewById(R.id.newsdate);
        }
    }
    public ImageAdapter(List<Individual>sanfoLists, OnRecycleViewItemClicker recycler){
        this.IndividuaLists = sanfoLists;
        this.Listener = recycler;

        i= this.getItemCount();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.newindividual, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.setIsRecyclable(false);
        Individual individual = IndividuaLists.get(position);
        je = position;
        holder.personname.setText(individual.getName());
//        holder.newsdate.setText(info.getDate());
//        holder.timeego.setText(info.getTime());
//        holder.writer.setText(info.getWriter());
//        if(info.isHasattachment()){
//            holder.attachment.setVisibility(View.VISIBLE);
//        }
//        if(info.isimportant()){
//            holder.star.setVisibility(View.VISIBLE);
//        }


    }
    @Override
    public int getItemCount() {
        try {
            return IndividuaLists.size();
        } catch (Exception e) {
        }
        return 0;
    }
    public interface OnRecycleViewItemClicker{
        public void OnRecycleViewItemclicked(int position);
    }
    public void setOnItemclickedListener(OnRecycleViewItemClicker listener){
        this.Listener =  listener;
    }
}
