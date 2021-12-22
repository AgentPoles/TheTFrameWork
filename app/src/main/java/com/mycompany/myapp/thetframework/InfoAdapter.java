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
 * Created by Paul on 5/23/2018.
 */
public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.MyViewHolder>  {
    private List<Info> infoLists;
    int i;
    static int je;
    OnRecycleViewItemClicker Listener;
    public class  MyViewHolder extends RecyclerView.ViewHolder {
        public TextView newsheadline;
        TextView newsdate, timeego;
        TextView  attachment, writer;
        ImageView star, headimage, inforeadstate, pendinginfo;
         RelativeLayout singleinforel;
        View view;

        public MyViewHolder(View view) {

            super(view);
            this.view = view;
            timeego = (TextView) view.findViewById(R.id.timeego);
            newsheadline = (TextView) view.findViewById(R.id.newsheadline);
            newsdate = (TextView) view.findViewById(R.id.newsdate);
            writer = (TextView) view.findViewById(R.id.writer);
            attachment = (TextView) view.findViewById(R.id.attachment);
            star = (ImageView) view.findViewById(R.id.star);
            pendinginfo = (ImageView)view.findViewById(R.id.pendinginfo);
            inforeadstate = (ImageView)view.findViewById(R.id.inforeadstate);
            headimage = (ImageView)view.findViewById(R.id.headimage);
            singleinforel = (RelativeLayout)view.findViewById(R.id.singleinnforel);
        }
    }
    public InfoAdapter(List<Info>sanfoLists, OnRecycleViewItemClicker recycler){
        this.infoLists = sanfoLists;
        this.Listener = recycler;
        i= this.getItemCount();
    }

    public void setInfoLists(List<Info> infoLists) {
        this.infoLists = infoLists;
        this.notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.singleinfo, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.setIsRecyclable(false);
        Info info = infoLists.get(position);
        je = position;
        holder.newsheadline.setText(info.getBody());
        holder.newsdate.setText(info.getDate());
        holder.timeego.setText(info.getTime());
        holder.writer.setText(info.getWriter());
        if(info.isHasattachment()){
            holder.attachment.setVisibility(View.VISIBLE);
        }
        if(info.isimportant()){
            holder.star.setVisibility(View.VISIBLE);
            holder.headimage.setImageResource(R.drawable.gbam);
        }
         holder.singleinforel.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Listener.OnRecycleViewItemclicked(position);
             }
         });
        if(info.isPending()){
            holder.pendinginfo.setVisibility(View.VISIBLE);
        }
        else {
            holder.pendinginfo.setVisibility(View.GONE);
        }
        if(info.isIsread()){
            holder.inforeadstate.setVisibility(View.GONE);
        }
        else {
            holder.inforeadstate.setVisibility(View.VISIBLE);
        }

    }

    public List<Info> getInfoLists() {
        return infoLists;
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
         void OnRecycleViewItemclicked(int position);
    }
    public void setOnItemclickedListener(OnRecycleViewItemClicker listener){
        this.Listener =  listener;
    }
}
