package com.mycompany.myapp.thetframework;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Paul on 2/16/2018.
 */
public class QuestionAdaptero extends RecyclerView.Adapter<QuestionAdaptero.MyViewHolder> {
    private List<question> infoLists;
    int i;
    static int je;
    OnRecycleViewItemClicker Listener;
    public class  MyViewHolder extends RecyclerView.ViewHolder {
        public TextView bodyr, bodyb, bodyg;
        TextView dateeg, dateer, dateeb, timeeg, timeer, timeeb;
        RelativeLayout lred, lblue, lgreen;
        ImageView unreadr, unreadb, unreadg, pendingquestiong,pendingquestionb, pendingquestionr;
        TextView courseb, courser, courseg;
        View view;
        public MyViewHolder(View view) {

            super(view);
            this.view =view;
            bodyb = (TextView) view.findViewById(R.id.bodyb);
            bodyr = (TextView) view.findViewById(R.id.bodyr);
            bodyg = (TextView) view.findViewById(R.id.bodyg);
//            authob = (TextView) view.findViewById(R.id.authob);
//            author = (TextView) view.findViewById(R.id.author);
//            authog = (TextView) view.findViewById(R.id.authog);
            lred = (RelativeLayout) view.findViewById(R.id.lred);
            lblue = (RelativeLayout) view.findViewById(R.id.lblue);
            lgreen = (RelativeLayout) view.findViewById(R.id.lgreen);
            unreadg = (ImageView) view.findViewById(R.id.unreadg);
            unreadr = (ImageView) view.findViewById(R.id.unreadr);
            unreadb = (ImageView) view.findViewById(R.id.unreadb);
            timeeb =(TextView)view.findViewById(R.id.timeeb);
            dateeb = (TextView)view.findViewById(R.id.dateeb);
            timeer =(TextView)view.findViewById(R.id.timeer);
            dateer = (TextView)view.findViewById(R.id.dateer);
            timeeg =(TextView)view.findViewById(R.id.timeeg);
            dateeg = (TextView)view.findViewById(R.id.dateeg);
            courseb = (TextView)view.findViewById(R.id.courseb);
            courseg = (TextView)view.findViewById(R.id.courseg);
            courser = (TextView)view.findViewById(R.id.courser);
            pendingquestionb = (ImageView)view.findViewById(R.id.pendingquestionb);
            pendingquestionr = (ImageView)view.findViewById(R.id.pendingquestionr);
            pendingquestiong = (ImageView)view.findViewById(R.id.pendingquestiong);
        }
    }
    public QuestionAdaptero(List<question>sanfoLists, OnRecycleViewItemClicker recycler){
        this.infoLists = sanfoLists;
        this.Listener = recycler;

        i= this.getItemCount();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.innerrecycler, parent, false);
        return new MyViewHolder(itemView);
    }

    public void setInfoLists(List<question> infoLists) {
        this.infoLists = infoLists;
        this.notifyDataSetChanged();
    }

    public List<question> getInfoLists() {
        return infoLists;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.setIsRecyclable(false);
        question ques = infoLists.get(position);
        je = position;
        holder.bodyb.setText(ques.getBody());
        holder.bodyr.setText(ques.getBody());
        holder.bodyg.setText(ques.getBody());
//        holder.authob.setText(ques.getWho());
//        holder.author.setText(ques.getWho());
//        holder.authog.setText(ques.getWho());
        holder.dateeb.setText(ques.getDate());
        holder.timeeb.setText(ques.getTime());
        holder.dateer.setText(ques.getDate());
        holder.timeer.setText(ques.getTime());
        holder.dateeg.setText(ques.getDate());
        holder.timeeg.setText(ques.getTime());
        holder.courseb.setText(ques.getCoursetitle());
        holder.courseg.setText(ques.getCoursetitle());
        holder.courser.setText(ques.getCoursetitle());
//        if(InformationFragment.readlist.contains(String.valueOf(position))){
//            info.setRead(true);
//        }
        holder.lblue.setVisibility(holder.view.VISIBLE);
        holder.lred.setVisibility(holder.view.GONE);
        holder.lgreen.setVisibility(holder.view.GONE);
        if ((position % 2) == 0) {
            holder.lgreen.setVisibility(holder.view.VISIBLE);
            holder.lred.setVisibility(holder.view.GONE);
            holder.lblue.setVisibility(holder.view.GONE);
        }
        if ((position % 3) == 0) {
            holder.lred.setVisibility(holder.view.VISIBLE);
            holder.lgreen.setVisibility(holder.view.GONE);
            holder.lblue.setVisibility(holder.view.GONE);
        }
        holder.unreadb.setVisibility(View.GONE);
        holder.unreadg.setVisibility(View.GONE);
        holder.unreadr.setVisibility(View.GONE);
        holder.lblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.OnRecycleViewItemclicked(position);
            }
        });
        holder.lgreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.OnRecycleViewItemclicked(position);
            }
        });
        holder.lred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Listener.OnRecycleViewItemclicked(position);
            }
        });
        if(ques.isAnswered()){

        }
        if(!ques.isRead()){
            holder.unreadb.setVisibility(View.VISIBLE);
            holder.unreadg.setVisibility(View.VISIBLE);
            holder.unreadr.setVisibility(View.VISIBLE);
        }
        if(ques.isRead()){
            holder.unreadb.setVisibility(holder.view.GONE);
            holder.unreadg.setVisibility(holder.view.GONE);
            holder.unreadr.setVisibility(holder.view.GONE);
        }
        if(!ques.isPending()){
            holder.pendingquestionb.setVisibility(View.GONE);
            holder.pendingquestiong.setVisibility(View.GONE);
            holder.pendingquestionr.setVisibility(View.GONE);
        }
        if(ques.isPending()){
            holder.pendingquestionb.setVisibility(View.VISIBLE);
            holder.pendingquestiong.setVisibility(View.VISIBLE);
            holder.pendingquestionr.setVisibility(View.VISIBLE);
        }

        else {
            if (!ques.isAnspending()) {
                holder.pendingquestionb.setVisibility(View.GONE);
                holder.pendingquestiong.setVisibility(View.GONE);
                holder.pendingquestionr.setVisibility(View.GONE);
            }
            if (ques.isAnspending()) {
                holder.pendingquestionb.setVisibility(View.VISIBLE);
                holder.pendingquestiong.setVisibility(View.VISIBLE);
                holder.pendingquestionr.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public int getItemCount() {
        try {
            return infoLists.size();
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

