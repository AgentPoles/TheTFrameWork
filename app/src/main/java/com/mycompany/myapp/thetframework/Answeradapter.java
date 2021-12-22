package com.mycompany.myapp.thetframework;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Paul on 2/8/2018.
 */
public class Answeradapter extends RecyclerView.Adapter<Answeradapter.MyViewHolder> {
    private List<Answer> enfoLists;
    int i;
      Activity activity;
    SharedPreferences  mysharedpreference;
    SharedPreferences.Editor myeditor;
    static int je;
  private FirebaseStorage storage;
    private  StorageReference storageReference;
    RotateAnimation rotateAnimation;
    OnRecycleViewItemClicker Listener;
    OnhasimageListener Listenerer;


    public class  MyViewHolder extends RecyclerView.ViewHolder {
      TextView nameinitial, usernameee, comans, answerbody, dater, timer, usernumber, useremail;
        TextView unreadr, unreadb, unreadg;
        CardView cardView;
        int aorb =0;
        TextView comansa, answerbodya, datera, timera,textimagea, textimageb;
        CardView cardViewa;
        TextView  daterab, timerab, daterac, timerac;
        ImageView answersprinte;
        Context context;
        ProgressBar otherprogressbar, yourprogressbar;
        RelativeLayout relimagea, relimageb, relother, relyou;
        ImageView answerpending, youranswerpending, imageholdera, imageholderb, imageanspending, anspending, answersprinta;
//       final Activity activity;
        TextView courseb, courser, courseg;
        View view;
        public MyViewHolder( View view) {

            super(view);
            this.view =view;
//            this.activity = activity;
            nameinitial= (TextView) view.findViewById(R.id.nameinitial);
            usernameee = (TextView) view.findViewById(R.id.usernameee);
//            useremail = (TextView) view.findViewById(R.id.useremail);
            usernumber = (TextView) view.findViewById(R.id.usernumber);
            comans = (TextView) view.findViewById(R.id.comans);
            answerbody = (TextView) view.findViewById(R.id.answerbody);
            dater = (TextView) view.findViewById(R.id.dater);
            timer = (TextView) view.findViewById(R.id.timer);
            cardView = (CardView)view.findViewById(R.id.card_view);
            daterab = (TextView)view.findViewById(R.id.daterab);
            daterac = (TextView)view.findViewById(R.id.daterac);
            timerac = (TextView)view.findViewById(R.id.timerac);
            timerab = (TextView)view.findViewById(R.id.timerab);
            answersprinte = (ImageView)view.findViewById(R.id.answersprinte);
            answersprinta  = (ImageView)view.findViewById(R.id.answersprinta);
            anspending = (ImageView)view.findViewById(R.id.anspending);
//            nameinitiala= (TextView) view.findViewById(R.id.nameinitiala);
//            usernameeea = (TextView) view.findViewById(R.id.usernameeea);
//            useremaila = (TextView) view.findViewById(R.id.useremaila);
//            usernumbera = (TextView) view.findViewById(R.id.usernumbera);
            comansa = (TextView) view.findViewById(R.id.comansa);
            answerbodya = (TextView) view.findViewById(R.id.answerbodya);
            datera = (TextView) view.findViewById(R.id.datera);
            timera = (TextView) view.findViewById(R.id.timera);
            cardViewa = (CardView)view.findViewById(R.id.card_viewa);
            textimagea = (TextView)view.findViewById(R.id.textimagea);
            textimageb = (TextView)view.findViewById(R.id.textimageb);
            relimagea = (RelativeLayout)view.findViewById(R.id.relimagea);
            relimageb = (RelativeLayout)view.findViewById(R.id.relimageb);
            relyou = (RelativeLayout)view.findViewById(R.id.relyou);
            relother = (RelativeLayout)view.findViewById(R.id.relother);
            imageholdera = (ImageView) view.findViewById(R.id.recyclerimageanswwera);
            imageholderb = (ImageView)view.findViewById(R.id.recyclerimageanswwerb);
//            answerimageda = (CircleImageView)view.findViewById(R.id.answerimageda);
//            answersprinta = (ImageView)view.findViewById(R.id.answersprinta);
            answerpending = (ImageView)view.findViewById(R.id.answerpending);
            youranswerpending = (ImageView)view.findViewById(R.id.youranswerpending);
            imageanspending = (ImageView)view.findViewById(R.id.imageanspending);
            otherprogressbar = (ProgressBar)view.findViewById(R.id.answersprintabarothers);
            yourprogressbar  = (ProgressBar)view.findViewById(R.id.answersprintebaryou);

//            lgreen = (RelativeLayout) view.findViewById(R.id.lgreen);
//            unreadg = (TextView)view.findViewById(R.id.unreadg);
//            unreadr = (TextView)view.findViewById(R.id.unreadr);
//            unreadb = (TextView)view.findViewById(R.id.unreadb);
//            timeeb =(TextView)view.findViewById(R.id.timeeb);
//            dateeb = (TextView)view.findViewById(R.id.dateeb);
//            timeer =(TextView)view.findViewById(R.id.timeer);
//            dateer = (TextView)view.findViewById(R.id.dateer);
//            timeeg =(TextView)view.findViewById(R.id.timeeg);
//            dateeg = (TextView)view.findViewById(R.id.dateeg);
//            courseb = (TextView)view.findViewById(R.id.courseb);
//            courseg = (TextView)view.findViewById(R.id.courseg);
//            courser = (TextView)view.findViewById(R.id.courser);
        }
    }
    public Answeradapter(List<Answer>sanfoLists, OnRecycleViewItemClicker recycle, OnhasimageListener onhasimageListener, Activity aci){
        this.enfoLists = sanfoLists;
        i= this.getItemCount();
        this.Listener = recycle;
        this.Listenerer = onhasimageListener;
        this.activity = aci;
        storage = FirebaseStorage.getInstance();

        mysharedpreference = aci.getSharedPreferences("readstate", MODE_PRIVATE);
        myeditor = mysharedpreference.edit();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        rotateAnimation = new RotateAnimation(0, 360,30,30);
        rotateAnimation.setDuration(1200);
        rotateAnimation.setRepeatCount(999999999);
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.answerview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position ) {
        holder.setIsRecyclable(false);
        final Answer ans = enfoLists.get(position);
//        holder.cardViewa.setVisibility(View.GONE);

        je = position;
        holder.imageholderb.setMaxHeight(300);
        holder.imageholdera.setMaxHeight(300);
        holder.answerbody.setText(ans.getAnswerbody());
        holder.dater.setText(ans.getDate());
        holder.timer.setText(ans.getTime());

        holder.answersprinte.setVisibility(View.GONE);
        holder.usernumber.setText(ans.getNumber());
        holder.usernameee.setText(ans.getName());
//        holder.useremail.setText(ans.getEmail());
        holder.answerbodya.setText(ans.getAnswerbody());
        holder.datera.setText(ans.getDate());
        holder.timera.setText(ans.getTime());
//        holder.answerimageda.setVisibility(View.GONE);
//        holder.answersprinta.setVisibility(View.GONE);
//        holder.usernumbera.setText(ans.getNumber());
//        holder.usernameeea.setText(ans.getName());
//        holder.useremaila.setText(ans.getEmail());
//        holder.relother.setVisibility(View.GONE);
        if (ans.isPending()) {
            holder.youranswerpending.setVisibility(View.VISIBLE);
            holder.answerpending.setVisibility(View.VISIBLE);
            holder.imageanspending.setVisibility(View.VISIBLE);
        }
        else {
            holder.imageanspending.setVisibility(View.GONE);
        }
        if (ans.isIsanswer()) {
            holder.comans.setText("Answer");
            holder.comansa.setText("Answer");
        }
        if (ans.getName() != null && ans.getEmail() != null) {
            if (ans.getName().equals(mysharedpreference.getString("username", "")) && ans.getEmail().equals(mysharedpreference.getString("useremail", ""))) {
                holder.relother.setVisibility(View.GONE);
                holder.relyou.setVisibility(View.VISIBLE);
                holder.aorb = 1;
//                holder.usernameeea.setText("you");
//                holder.nameinitiala.setVisibility(View.VISIBLE);
            } else {
                holder.aorb = 0;
                holder.relyou.setVisibility(View.GONE);
                holder.relother.setVisibility(View.VISIBLE);
//                holder.cardViewa.setVisibility(View.VISIBLE);
            }
        }
        if(holder.aorb==1) {
            if (ans.isIsanswer() == false) {
//            holder.comans.setText("Comment");
                holder.comansa.setText("Comment");
            }
            holder.timerac.setText(ans.getTime());
            holder.daterac.setText(ans.getDate());
            if (ans.isPending()) {
                if (!ans.isHasimage()) {
                    holder.relimageb.setVisibility(View.GONE);
                }

                if (ans.isHasimage()) {
                    if (ans.getUristring() != null) {
                        holder.cardViewa.setVisibility(View.GONE);
                        if (ans.isPending()) {
                            holder.imageanspending.setVisibility(View.VISIBLE);
                        } else {
                            holder.imageanspending.setVisibility(View.GONE);
                        }
               newshowite(activity,Uri.parse(ans.getUristring()),holder.imageholderb);
//                        loadImage(ans.getUristring(), holder.imageholderb);

                        holder.textimageb.setText(ans.getAnswerbody());
                    }
                    holder.imageholderb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Listener.OnRecycleViewItemclicked(v, position, "", null);
                        }
                    });
                }

            } else {
                if (!ans.isHasimage()) {
                    holder.relimageb.setVisibility(View.GONE);
                } else {
                    if (ans.isHasimage()) {
                        holder.imageanspending.setVisibility(View.GONE);
                        holder.imageholderb.setImageDrawable(null);
                        holder.textimageb.setText(ans.getAnswerbody());
//                            if ((ans.getDownloaduri() != null && !ans.getDownloaduri().equals(""))) {
//                                holder.cardViewa.setVisibility(View.GONE);
//                                storageReference = storage.getReference("answerimages").child("real" + ans.answerid);
//                                newshowit(activity, storageReference, holder.imageholderb);
//                            }
//                            else {
                                if(ans.getThumblineuri() != null & !ans.getThumblineuri().equals("")){
                                    holder.cardViewa.setVisibility(View.GONE);
                                    storageReference = storage.getReference("answerimages").child(ans.getAnswerid());
                                    newshowit(activity, storageReference, holder.imageholderb,holder.yourprogressbar,holder.answersprinte);

//                      holder.answerimaged.setVisibility(View.VISIBLE);
//                      holder.answersprint.setVisibility(View.GONE);
//                                loadthrough(Uri.parse(ans.getThumblineuri()), holder.imageholderb, holder.answersprinte);
//               holder.answersprint.startAnimation(rotateAnimation);
//                            holder.answersprint.setVisibility(View.INVISIBLE);
//                Listenerer.hasimage(position);


                        }
                    }
                }
            }

//
//        else {
//
//    }
            if (ans.isHasimage()&&!ans.isPending()) {
                holder.answersprinta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

//                        loadthrough(Uri.parse(ans.getThumblineuri()), holder.imageholderb, holder.answersprinte);
                    }
                });
                holder.imageholderb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (holder.imageholderb.getDrawable() != null)
                            InnerAnswer.theimagehelper = 1;
                        Listener.OnRecycleViewItemclicked(view, position, ans.getDownloaduri(), holder.imageholderb.getDrawable());
                    }
                });
                if (ans.getName() != null) {
                    Character jt = ans.getName().charAt(0);
                    String mhh = jt.toString();
//                    holder.nameinitial.setText(mhh);
                } else {
//                    holder.nameinitial.setText("y");
//                holder.nameinitiala.setText("y");

                }
                holder.answersprinte.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        newshowit(activity, storageReference, holder.imageholderb,holder.yourprogressbar,holder.answersprinte);
//                        loadthrough(Uri.parse(ans.getThumblineuri()), holder.imageholderb, holder.answersprinte);
                    }
                });
//                holder.imageholderb.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (holder.imageholderb.getDrawable() != null)
//                            InnerAnswer.theimagehelper = 1;
//                        Listener.OnRecycleViewItemclicked(view, position, ans.getDownloaduri(), holder.imageholderb.getDrawable());
//                    }
//                });
//                if (ans.getName() != null) {
//                    Character jt = ans.getName().charAt(0);
//                    String mhh = jt.toString();
////                        holder.nameinitiala.setText(mhh);
//                } else {
////                        holder.nameinitial.setText("y");
//                }
//
//
          }
          else {

            }
                }

             if(holder.aorb==0) {
            holder.relother.setVisibility(View.VISIBLE);
            holder.relyou.setVisibility(View.GONE);
        if (!ans.isIsanswer()) {
//            holder.comans.setText("Comment");
            holder.comans.setText("Comment");
        }
        else{
            holder.comans.setText("Answer");
        }
                 holder.textimagea.setText(ans.getAnswerbody());
        holder.usernameee.setText(ans.getName());
        holder.usernumber.setText(ans.getNumber());
        holder.dater.setText(ans.getDate());
        holder.timer.setText(ans.getTime());
                 holder.timerab.setText(ans.getTime());
                 holder.daterab.setText(ans.getDate());
                 if (ans.getName() != null) {
                     Character jt = ans.getName().charAt(0);
                     String mhh = jt.toString();
                     holder.nameinitial.setText(mhh);
                 } else {
//                    holder.nameinitial.setText("y");
//                holder.nameinitiala.setText("y");

                 }
        if (ans.isPending()) {
            if (!ans.isHasimage()) {
                holder.relimagea.setVisibility(View.GONE);
                holder.answerbody.setText(ans.getAnswerbody());
                holder.answerpending.setVisibility(View.VISIBLE);
            }
            if (ans.isHasimage()) {
                if (ans.getUristring() != null) {
                    holder.cardView.setVisibility(View.GONE);
                    if (ans.isPending()) {
                        holder.anspending.setVisibility(View.VISIBLE);
                    } else {
                        holder.anspending.setVisibility(View.GONE);
                    }

                    newshowite(activity,Uri.parse(ans.getUristring()),holder.imageholdera);
//                    loadImage(ans.getUristring(), holder.imageholdera);


                }
                holder.imageholdera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Listener.OnRecycleViewItemclicked(v, position, "", null);
                    }
                });
            }

        } else {
            if (!ans.isHasimage()) {
                holder.relimagea.setVisibility(View.GONE);
                holder.answerpending.setVisibility(View.GONE);
            } else {
                if (ans.isHasimage()) {
//                    if ((ans.getDownloaduri() != null && !ans.getDownloaduri().equals(""))) {
//                        holder.cardView.setVisibility(View.GONE);
//                        storageReference = storage.getReference("answerimages").child("real" + ans.answerid);
//                        newshowit(activity, storageReference, holder.imageholdera);
//                    }
//                    else {
                        if(ans.getThumblineuri() != null & !ans.getThumblineuri().equals("")){
                            holder.cardView.setVisibility(View.GONE);
                            storageReference = storage.getReference("answerimages").child(ans.answerid);
                            newshowit(activity, storageReference, holder.imageholdera,holder.otherprogressbar,holder.answersprinta);

//                      holder.answerimaged.setVisibility(View.VISIBLE);
//                      holder.answersprint.setVisibility(View.GONE);
//                        loadthrough(Uri.parse(ans.getThumblineuri()), holder.imageholdera, holder.answersprinta);
//               holder.answersprint.startAnimation(rotateAnimation);
//                        holder.answersprint.setVisibility(View.INVISIBLE);
//                Listenerer.hasimage(positi
                    }
                }
            }
        }
//
//        else {
//
//    }
        if (ans.isHasimage()) {
            holder.answersprinta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    loadthrough(Uri.parse(ans.getThumblineuri()), holder.imageholdera, holder.answersprinta);
                }
            });
            holder.imageholdera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (holder.imageholdera.getDrawable() != null)
                        InnerAnswer.theimagehelper = 1;
                    Listener.OnRecycleViewItemclicked(view, position, ans.getDownloaduri(), holder.imageholdera.getDrawable());
                }
            });

            holder.answersprinta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    newshowit(activity, storageReference, holder.imageholdera,holder.otherprogressbar,holder.answersprinta);
//                    loadthrough(Uri.parse(ans.getThumblineuri()), holder.imageholdera, holder.answersprinta);
                }
            });
//            holder.imageholdera.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (holder.imageholdera.getDrawable() != null)
//                        InnerAnswer.theimagehelper = 1;
//                    Listener.OnRecycleViewItemclicked(view, position, ans.getDownloaduri(), holder.imageholdera.getDrawable());
//                }
//            });
//            if (ans.getName() != null) {
//                Character jt = ans.getName().charAt(0);
//                String mhh = jt.toString();
////                        holder.nameinitiala.setText(mhh);
//            } else {
////                        holder.nameinitial.setText("y");
//            }

        }
    }
}
    public void newshowit(Context context, StorageReference storageReference, ImageView imageView,final ProgressBar b,final ImageView c) {
//        rollit.setVisibility(View.VISIBLE);
//        theimagespinner.setVisibility(View.VISIBLE);
//        rollit.startAnimation(rote);
//        theimagespinner.startAnimation(rotec);
        c.setVisibility(View.GONE);
        b.setVisibility(View.VISIBLE);
        GlideApp.with(context /* context */)

                .load(storageReference)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        // log exception
                        Log.e("TAG", "Error loading image", e);

                        b.setVisibility(View.GONE);
                        c.setVisibility(View.VISIBLE);
                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        b.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageView);


    }
//if(ans.isHasimage()){
//            holder.answerimageda.setVisibility(View.VISIBLE);
//            holder.answerimaged.setVisibility(View.VISIBLE);
//}
//   if(ans.isHasimage()&&ans.getDownloaduri()==null&&ans.getThumblineuri()==null&&ans.getUristring()!=null){
//            loadImage(ans.getUristring(),holder.answerimageda);
//   }
//
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
//        }
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
////
///
///
///
/// holder.lgreen.setOnClickListener(new View.OnClickListener() {
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

    public void loadImage (String practice, ImageView imageViewr){
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(),Uri.parse(practice));
//                    imagebitmap = bitmap;
            imageViewr.setImageBitmap(bitmap);
//                    answerimage.setVisibility(View.VISIBLE);
//                    hopeimage = 1;
//                    sendingImage = true;
        } catch (IOException e) {
            e.printStackTrace();
        Toast.makeText(activity,"error loading image",Toast.LENGTH_LONG).show();
        }
    }





//    private void loadthrough(Uri uri, ImageView answerimagee, final ImageView sprinte){
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

    public void setEnfoLists(List<Answer> enfoLists) {
        this.enfoLists = enfoLists;
        this.notifyDataSetChanged();
    }

    public void newshowite(Context context, Uri uri, ImageView imageView) {

        GlideApp.with(context /* context */)
                .load(uri)
                .into(imageView)
                .onResourceReady(imageView.getDrawable(), new Transition<Drawable>() {
                    @Override
                    public boolean transition(Drawable current, ViewAdapter adapter) {

                        return false;
                    }
                });

    }

    public List<Answer> getEnfoLists() {
        return enfoLists;
    }

    public void setOnhasImageListener(OnhasimageListener listener){
        this.Listenerer =  listener;
    }
}

