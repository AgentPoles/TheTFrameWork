package com.mycompany.myapp.thetframework;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class ClassorAdapter  extends RecyclerView.Adapter<ClassorAdapter.MyViewHolder> {
    private List<Classors> infoLists;
    int i;
    static int je;
    ClassorAdapter.OnRecycleViewItemClicker Listener;
    public class  MyViewHolder extends RecyclerView.ViewHolder {
        public TextView classbody, bigclassbody;
        public RelativeLayout classorfull, classorsmall, classorbig;
        public  ImageView read, bigread, blocked, bigblocked;
        View view;
        public MyViewHolder(View view) {
            super(view);
            this.view =view;
            classbody = (TextView) view.findViewById(R.id.classbody);
            bigclassbody = (TextView) view.findViewById(R.id.bigclassbody);
            read = (ImageView)view.findViewById(R.id.read);
            bigread = (ImageView)view.findViewById(R.id.bigread);
            classorbig = (RelativeLayout)view.findViewById(R.id.bigger);
            classorfull = (RelativeLayout)view.findViewById(R.id.classorfull);
            classorsmall = (RelativeLayout)view.findViewById(R.id.smaller);
            blocked = (ImageView)view.findViewById(R.id.blocked);
            bigblocked = (ImageView)view.findViewById(R.id.bigblocked);
            classbody.setSelected(true);
            bigclassbody.setSelected(true);
        }
    }

    public ClassorAdapter(List<Classors>sanfoLists, ClassorAdapter.OnRecycleViewItemClicker recycler){
        this.infoLists = sanfoLists;
        this.Listener = recycler;
        i= this.getItemCount();
    }

    @Override
    public ClassorAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridclasses, parent, false);
        return new ClassorAdapter.MyViewHolder(itemView);
    }

    public void setInfoLists(List<Classors> infoLists) {
        this.infoLists = infoLists;
        this.notifyDataSetChanged();
    }

    public List<Classors> getInfoLists() {
        return infoLists;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Classors classors = infoLists.get(position);
            if (classors.isRecent()) {
//                holder.classorfull.setBackgroundColor(Color.parseColor("#ffffff"));
                holder.classorbig.setVisibility(View.VISIBLE);
                holder.classorsmall.setVisibility(View.GONE);
                holder.bigclassbody.setBackgroundResource(R.drawable.tipog);
                holder.bigread.setVisibility(View.GONE);
                holder.bigclassbody.setText(classors.getClassname());
                if(classors.isBlocked()){
                    holder.bigblocked.setVisibility(View.VISIBLE);
                }
                else {
                    holder.bigblocked.setVisibility(View.GONE);
                }
                if (position % 2 == 0) {
                    holder.bigclassbody.setTextColor(Color.parseColor("#0099cc"));
                }
                if (position % 3 == 0) {
                    holder.bigclassbody.setTextColor(Color.parseColor("#99cc00"));
//            holder.classbody.setBackgroundResource(R.drawable.tipor);
                }
                if (position % 5 == 0) {
                    holder.bigclassbody.setTextColor(Color.parseColor("#ff8800"));
//            holder.classbody.setBackgroundResource(R.drawable.tipog);
                }
            } else {
                holder.classorsmall.setVisibility(View.VISIBLE);
                holder.classorbig.setVisibility(View.GONE);
                if (classors.isUnread()) {
                    holder.read.setVisibility(View.VISIBLE);
                } else {
                    holder.read.setVisibility(View.GONE);
                }
                if(classors.isBlocked()){
                    holder.blocked.setVisibility(View.VISIBLE);
                }
                else {
                    holder.blocked.setVisibility(View.GONE);
                }
                holder.classbody.setText(classors.getClassname());
                if (position % 2 == 0) {
                    holder.classbody.setTextColor(Color.parseColor("#0099cc"));
                }
                if (position % 3 == 0) {
                    holder.classbody.setTextColor(Color.parseColor("#99cc00"));
//            holder.classbody.setBackgroundResource(R.drawable.tipor);
                }
                if (position % 5 == 0) {
                    holder.classbody.setTextColor(Color.parseColor("#ff8800"));
//            holder.classbody.setBackgroundResource(R.drawable.tipog);
                }
            }
            holder.classorfull.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Listener.OnRecycleViewItemclicked(position);
                }
            });

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
    public void setOnItemclickedListener(ClassorAdapter.OnRecycleViewItemClicker listener){
        this.Listener =  listener;
    }
}

