package com.mycompany.myapp.thetframework;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.google.firebase.storage.StorageReference;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Paul on 5/24/2018.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private List<Chatmessage> enfoLists;
    int i;
    Activity activity;
    String  strDate;
    String time;
    static int je;
    RotateAnimation rotateAnimation;
    OnRecycleViewItemClicker Listener;
    OnhasimageListener Listenerer;

    long timestamp;
    public class  MyViewHolder extends RecyclerView.ViewHolder {
        TextView othertext, yourtext, daterb, daterc;
        RelativeLayout relothertext, relyourcomment;
       View view;
        //       final Activity activity;

        public MyViewHolder( View view) {

            super(view);
            this.view =view;
//            this.activity = activity;
           othertext = (TextView)view.findViewById(R.id.othertext);
            yourtext = (TextView)view.findViewById(R.id.youcomment);
            daterb = (TextView)view.findViewById(R.id.daterb);
            daterc = (TextView)view.findViewById(R.id.daterc);
            relothertext = (RelativeLayout) view.findViewById(R.id.relothertext);
            relyourcomment = (RelativeLayout)view.findViewById(R.id.relyourcomment);
        }
    }
    public ChatAdapter(List<Chatmessage>sanfoLists, OnRecycleViewItemClicker recycle, OnhasimageListener onhasimageListener){
        this.enfoLists = sanfoLists;
        i= this.getItemCount();
        this.Listener = recycle;
        this.Listenerer = onhasimageListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        rotateAnimation = new RotateAnimation(0, 360,30,30);
        rotateAnimation.setDuration(1200);
        rotateAnimation.setRepeatCount(999999999);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chatinner, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position ) {
        holder.setIsRecyclable(false);
        final Chatmessage ans = enfoLists.get(position);
        holder.othertext.setText(ans.getUsermessage());
        holder.yourtext.setText(ans.getUsermessage());
        timestamp = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
       long m = timestamp/86400;
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy");
        SimpleDateFormat sdfa = new SimpleDateFormat("h:mm a");
        strDate = sdf.format(c.getTime());
        time = sdfa.format(c.getTime());
        try{

         if(m==namepro.ntimemonitor){

         }
            else {
             holder.daterb.setVisibility(View.VISIBLE);
             holder.daterb.setText(strDate);
             holder.daterc.setVisibility(View.VISIBLE);
             holder.daterc.setText(strDate);
             namepro.setNtimemonitor(m);
         }
        }
        catch (Exception e){

        }

//        if((ans.getDownloaduri()!=null)&&ans.getThumblineuri()!=null) {
//
//            if (ans.getDownloaduri().toString().length()>1&&ans.getThumblineuri().toString().length()>1) {
//                if(ans.getThumblineuri()!=null&&ans.getThumblineuri().toString().length()>1)
//
//                    if(holder.aorb==0) {
//                        holder.answerimaged.setVisibility(View.VISIBLE);
//                        holder.answersprint.setVisibility(View.GONE);
//                        loadthrough(Uri.parse(ans.getThumblineuri()),holder.answerimaged,holder.answersprint);
//                    }
//                if(holder.aorb==1) {
//                    holder.answerimageda.setVisibility(View.VISIBLE);
//                    holder.answersprinta.setVisibility(View.GONE);
//                    loadthrough(Uri.parse(ans.getThumblineuri()),holder.answerimageda,holder.answersprinta);
//                }
//               holder.answersprint.startAnimation(rotateAnimation);
//                holder.answersprint.setVisibility(View.INVISIBLE);
////                Listenerer.hasimage(position);
//            }
//        }
//
//        else {
//
//        }
//        if (holder.aorb==0) {
//            holder.answersprint.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    loadthrough(Uri.parse(ans.getThumblineuri()), holder.answerimaged, holder.answersprint);
//                }
//            });
//            holder.answerimaged.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (holder.answerimaged.getDrawable() != null)
//                        InnerAnswer.theimagehelper = 1;
//                    Listener.OnRecycleViewItemclicked(view, position, ans.getDownloaduri(), holder.answerimaged.getDrawable());
//                }
//            });
//            Character jt = ans.getName().charAt(0);
//            String mhh = jt.toString();
//            holder.nameinitial.setText(mhh);
//        }
//        else {
//            if(holder.aorb==1){
//                holder.answersprinta.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        loadthrough(Uri.parse(ans.getThumblineuri()), holder.answerimageda, holder.answersprinta);
//                    }
//                });
//                holder.answerimageda.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (holder.answerimageda.getDrawable() != null)
//                            InnerAnswer.theimagehelper = 1;
//                        Listener.OnRecycleViewItemclicked(view, position, ans.getDownloaduri(), holder.answerimageda.getDrawable());
//                    }
//                });
//                Character jt = ans.getName().charAt(0);
//                String mhh = jt.toString();
//                holder.nameinitiala.setText(mhh);
//            }
//        }
//
////        holder.answerbody.setText(ans.getBody());
////        holder.bodyr.setText(ques.getBody());
////        holder.bodyg.setText(ques.getBody());
////        holder.authob.setText(ques.getWho());
////        holder.author.setText(ques.getWho());
////        holder.authog.setText(ques.getWho());
////        holder.dateeb.setText(ques.getDate());
////        holder.timeeb.setText(ques.getTime());
////        holder.dateer.setText(ques.getDate());
////        holder.timeer.setText(ques.getTime());
////        holder.dateeg.setText(ques.getDate());
////        holder.timeeg.setText(ques.getTime());
////        if(InformationFragment.readlist.contains(String.valueOf(position))){
////            info.setRead(true);
////        }
////        holder.lblue.setVisibility(holder.view.VISIBLE);
////        holder.lred.setVisibility(holder.view.GONE);
////        holder.lgreen.setVisibility(holder.view.GONE);
////        if ((position % 2) == 0) {
////            holder.lgreen.setVisibility(holder.view.VISIBLE);
////            holder.lred.setVisibility(holder.view.GONE);
////            holder.lblue.setVisibility(holder.view.GONE);
////        }
////        if ((position % 3) == 0) {
////            holder.lred.setVisibility(holder.view.VISIBLE);
////            holder.lgreen.setVisibility(holder.view.GONE);
////            holder.lblue.setVisibility(holder.view.GONE);
//    }
////        if(ques.isRead()){
////            holder.unreadb.setVisibility(holder.view.GONE);
////            holder.unreadg.setVisibility(holder.view.GONE);
////            holder.unreadr.setVisibility(holder.view.GONE);
////        }
////        holder.lblue.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Listener.OnRecycleViewItemclicked(position);
////            }
////        });
////        holder.lgreen.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Listener.OnRecycleViewItemclicked(position);
////            }
////        });
////        holder.lred.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Listener.OnRecycleViewItemclicked(position);
////            }
////        });
        try {
            if (ans.getUseremail().equals(namepro.getNemail())) {
                holder.relyourcomment.setVisibility(View.VISIBLE);
            } else {
                holder.relothertext.setVisibility(View.VISIBLE);
            }
        }
        catch (Exception e){

        }
    }

    @Override
    public int getItemCount() {
        try {
            return enfoLists.size();
        } catch (Exception e) {
        }
        return 0;
    }
    public interface OnRecycleViewItemClicker{
        public void OnRecycleViewItemclicked(View view, int position, String stringm, Drawable drawable);
    }
    public void setOnItemclickedListener(OnRecycleViewItemClicker listener){
        this.Listener =  listener;
    }
    public interface OnhasimageListener{
        public void hasimage(int position);
    }
    public void newshowit(Context context, StorageReference storageReference, ImageView imageView) {
//        rolli.setVisibility(View.VISIBLE);
//        theimagespinner.setVisibility(View.VISIBLE);
//        rollit.startAnimation(rote);
//        theimagespinner.startAnimation(rotec);
        GlideApp.with(context /* context */)
                .load(storageReference)
                .into(imageView)
                .onResourceReady(imageView.getDrawable(), new Transition<Drawable>() {
                    @Override
                    public boolean transition(Drawable current, ViewAdapter adapter) {
//                        rote.cancel();
//                        rotec.cancel();
//                        theimagespinner.setVisibility(View.GONE);
//                        rollit.setVisibility(View.GONE);
                        return false;
                    }
                });

    }

//    private void loadthrough(Uri uri, CircleImageView answerimagee, final ImageView sprinte){
//        sprinte.startAnimation(rotateAnimation);
//        sprinte.setVisibility(View.GONE);
//        Glide.with(activity)
////                .using(new FirebaseImageLoader())
//                .load(uri)
//                .listener(new RequestListener<Uri, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, Uri model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        rotateAnimation.cancel();
//                        sprinte.setVisibility(View.VISIBLE);
//                        sprinte.setImageResource(R.drawable.timer);
////                        Toast.makeText(activity,"failed to load answer image",Toast.LENGTH_LONG).show();
////                        rollit.setImageResource(R.drawable.timere);
////                        sayreload.setVisibility(View.VISIBLE);
//                        return false;
//
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, Uri model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        rotateAnimation.cancel();
//
//                        sprinte.setVisibility(View.INVISIBLE);
//
////                        rollit.setVisibility(View.GONE);
////                        Toast.makeText(activity,"answer image is ready",Toast.LENGTH_LONG).show();
//                        return false;
//                    }
//                })
//                .into(answerimagee);
//    }

}
