package com.mycompany.myapp.thetframework;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ViewImageActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView title;
    ImageView gobackviewe;
    String downloadid, mmuid;
    ProgressBar imagelayoutprogressbar;
    boolean pending, isanswer;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    RelativeLayout textviewhoder;
    private String my_title, imgPath;
    ImageView glidereloader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_view_layout);
        imageView = (ImageView) findViewById(R.id.imageview);
        title = (TextView) findViewById(R.id.titlee);
        ActionBar actionBar = getSupportActionBar();
        try {
            actionBar.hide();
        } catch (Exception e) {

        }
        textviewhoder = (RelativeLayout) findViewById(R.id.textviewhoder);
        gobackviewe = (ImageView) findViewById(R.id.gobackviewe);
        glidereloader = (ImageView)findViewById(R.id.glidereloader);
        imagelayoutprogressbar = (ProgressBar)findViewById(R.id.imagelayoutprogreaabar);
        glidereloader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processit();
            }
        });
        imgPath = getIntent().getExtras().getString("image");
        my_title = getIntent().getExtras().getString("title");
        mmuid = getIntent().getExtras().getString("storageid");
        downloadid = getIntent().getExtras().getString("image");
//        Toast.makeText(getApplicationContext(),mmuid,Toast.LENGTH_LONG).show();
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference("answerimages");
        pending = getIntent().getExtras().getBoolean("pending");
        isanswer = getIntent().getExtras().getBoolean("isanswer");
        gobackviewe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        if(isanswer) {
            processit();
        }
        else {
         processQuestion();
        }
    }

    public void processit() {
        glidereloader.setVisibility(View.GONE);
        imagelayoutprogressbar.setVisibility(View.VISIBLE);
        if (!TextUtils.isEmpty(my_title)) {
            title.setText(my_title);
        }
        SlideAnimationUtil.slideInFromLeft(this, gobackviewe);
        SlideAnimationUtil.slideInFromRight(this, textviewhoder);
        ViewCompat.setTransitionName(imageView, imgPath);
        if (pending) {
            Toast.makeText(getApplicationContext(), "now processing", Toast.LENGTH_LONG).show();
            GlideApp.with(this).load(imgPath)
                    .fitCenter()
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            // log exception
                            Log.e("TAG", "Error loading image", e);
                            imagelayoutprogressbar.setVisibility(View.GONE);
                            glidereloader.setVisibility(View.VISIBLE);
                            return false; // important to return false so the error placeholder can be placed
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            imagelayoutprogressbar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(imageView);
        } else {
            boolean virtue;
            if (downloadid != null) {
                storageReference = firebaseStorage.getReference("answerimages").child("real" + mmuid);
                ViewCompat.setTransitionName(imageView, "google loading");
                try {
                    GlideApp.with(this).load(storageReference)
                            .fitCenter()
                            .listener(new RequestListener<Drawable>() {
                                @Override
                                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                    // log exception
//                                    Log.e("TAG", "Error loading image", e);
                                    imagelayoutprogressbar.setVisibility(View.GONE);
                                    glidereloader.setVisibility(View.VISIBLE);
                                    return false; // important to return false so the error placeholder can be placed
                                }

                                @Override
                                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                    imagelayoutprogressbar.setVisibility(View.GONE);
                                    return false;
                                }
                            })
                            .into(imageView);


                } catch (Exception e) {
                    storageReference = firebaseStorage.getReference("answerimages").child(mmuid);
                    GlideApp.with(getApplicationContext()).load(storageReference)
                            .fitCenter()
                            .listener(new RequestListener<Drawable>() {
                                @Override
                                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                    // log exception
                                    Log.e("TAG", "Error loading image", e);
                                    imagelayoutprogressbar.setVisibility(View.GONE);
                                    glidereloader.setVisibility(View.VISIBLE);
                                    return false; // important to return false so the error placeholder can be placed
                                }

                                @Override
                                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                    imagelayoutprogressbar.setVisibility(View.GONE);
                                    return false;
                                }
                            })
                            .into(imageView);
                    // important to return false so the error placeholder can be placed
                }
            }
            else {
                storageReference = firebaseStorage.getReference("answerimages").child(mmuid);
                GlideApp.with(getApplicationContext()).load(storageReference)
                        .fitCenter()
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                // log exception
                                Log.e("TAG", "Error loading image", e);
                                imagelayoutprogressbar.setVisibility(View.GONE);
                                glidereloader.setVisibility(View.VISIBLE);
                                return false; // important to return false so the error placeholder can be placed
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                imagelayoutprogressbar.setVisibility(View.GONE);
                                return false;
                            }
                        })
                        .into(imageView);
            }

        }
    }
    public void processQuestion() {
        glidereloader.setVisibility(View.GONE);
        imagelayoutprogressbar.setVisibility(View.VISIBLE);
        if (!TextUtils.isEmpty(my_title)) {
            title.setText(my_title);
        }
        SlideAnimationUtil.slideInFromLeft(this, gobackviewe);
        SlideAnimationUtil.slideInFromRight(this, textviewhoder);
        ViewCompat.setTransitionName(imageView, imgPath);
        if (pending) {
//            Toast.makeText(getApplicationContext(), "now processing", Toast.LENGTH_LONG).show();
            GlideApp.with(this).load(imgPath)
                    .fitCenter()
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            // log exception
                            Log.e("TAG", "Error loading image", e);
                            imagelayoutprogressbar.setVisibility(View.GONE);
                            glidereloader.setVisibility(View.VISIBLE);
                            return false; // important to return false so the error placeholder can be placed
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            imagelayoutprogressbar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .into(imageView);
        } else {
            boolean virtue;
            if (downloadid != null) {
                storageReference = firebaseStorage.getReference("questionimages").child("real" + mmuid);
                ViewCompat.setTransitionName(imageView, "google loading");
                try {
                    GlideApp.with(this).load(storageReference)
                            .fitCenter()
                            .listener(new RequestListener<Drawable>() {
                                @Override
                                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                    // log exception
//                                    Log.e("TAG", "Error loading image", e);
                                    imagelayoutprogressbar.setVisibility(View.GONE);
                                    glidereloader.setVisibility(View.VISIBLE);
                                    return false; // important to return false so the error placeholder can be placed
                                }

                                @Override
                                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                    imagelayoutprogressbar.setVisibility(View.GONE);
                                    return false;
                                }
                            })
                            .into(imageView);


                } catch (Exception e) {
                    storageReference = firebaseStorage.getReference("questionimages").child(mmuid);
                    GlideApp.with(getApplicationContext()).load(storageReference)
                            .fitCenter()
                            .listener(new RequestListener<Drawable>() {
                                @Override
                                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                    // log exception
                                    Log.e("TAG", "Error loading image", e);
                                    imagelayoutprogressbar.setVisibility(View.GONE);
                                    glidereloader.setVisibility(View.VISIBLE);
                                    return false; // important to return false so the error placeholder can be placed
                                }

                                @Override
                                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                    imagelayoutprogressbar.setVisibility(View.GONE);
                                    return false;
                                }
                            })
                            .into(imageView);
                    // important to return false so the error placeholder can be placed
                }
            } else {
                storageReference = firebaseStorage.getReference("questionimages").child(mmuid);
                GlideApp.with(getApplicationContext()).load(storageReference)
                        .fitCenter()
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                // log exception
                                Log.e("TAG", "Error loading image", e);
                                imagelayoutprogressbar.setVisibility(View.GONE);
                                glidereloader.setVisibility(View.VISIBLE);
                                return false; // important to return false so the error placeholder can be placed
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                imagelayoutprogressbar.setVisibility(View.GONE);
                                return false;
                            }
                        })
                        .into(imageView);
            }

        }
    }
    @Override
    public void onBackPressed() {
        SlideAnimationUtil.slideOutToLeft(this,gobackviewe);
       SlideAnimationUtil.slideOutToRight(this,textviewhoder);
        super.onBackPressed();
    }
}

