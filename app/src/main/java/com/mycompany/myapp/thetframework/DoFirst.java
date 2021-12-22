package com.mycompany.myapp.thetframework;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DoFirst extends AppCompatActivity {
    LinearLayout beginners, poles;
    TranslateAnimation startu, poleupe, poledowne, transcont;
    AlphaAnimation goin, comeout, skigoin;
    static int deletea = 0;
    RelativeLayout poleee;
    ImageView ski;
    ScaleAnimation maryscaleup, maryscaledown;
//    Onanimend reyr;
    Intent mfra;
    TextView maary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        try {
            mfra = new Intent(this, Realstartup.class);
            maary = (TextView) findViewById(R.id.maary);
            beginners = (LinearLayout) findViewById(R.id.begginers);
            poles = (LinearLayout) findViewById(R.id.poles);
            poleee = (RelativeLayout) findViewById(R.id.poleee);
            ski = (ImageView) findViewById(R.id.ski);
            poles.setVisibility(View.GONE);
            startu = new TranslateAnimation(-250, 0, 0, 0);
            poleupe = new TranslateAnimation(0, 0, 50, 0);
            poledowne = new TranslateAnimation(0, 0, 0, 50);
            transcont = new TranslateAnimation(0, 300, 0, 0);
            maryscaledown = new ScaleAnimation(1, 1, 0, 0);
            maryscaleup = new ScaleAnimation(0, 0, 1, 1);

            goin = new AlphaAnimation(1, 0);
            comeout = new AlphaAnimation(0, 1);
            skigoin  = new AlphaAnimation(1,0);
            skigoin.setDuration(3000);
            startu.setDuration(1000);
            poleupe.setDuration(1200);
            poledowne.setDuration(1200);
            transcont.setDuration(1200);

            goin.setDuration(1100);
            comeout.setDuration(1200);

            maryscaledown.setDuration(1200);
            maryscaleup.setDuration(1200);

            maary.setVisibility(View.GONE);
            poleee.setVisibility(View.GONE);
            ski.startAnimation(skigoin);
            CountDownTimer timerd = new CountDownTimer(2000,2000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {

                   ski.setVisibility(View.GONE);
                poleee.setVisibility(View.VISIBLE);
                    beginners.startAnimation(startu);
                    CountDownTimer timre = new CountDownTimer(1000, 500) {
                        @Override
                        public void onTick(long l) {

                        }

                        @Override
                        public void onFinish() {
                            beginners.startAnimation(goin);
                            CountDownTimer gh = new CountDownTimer(1100, 500) {
                                @Override
                                public void onTick(long l) {

                                }

                                @Override
                                public void onFinish() {

                                    poles.setVisibility(View.VISIBLE);
                                    beginners.setVisibility(View.GONE);
                                    poles.startAnimation(poleupe);
                                }

                                CountDownTimer nm = new CountDownTimer(1100, 500) {
                                    @Override
                                    public void onTick(long l) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        maary.setVisibility(View.VISIBLE);
                                        maary.startAnimation(maryscaleup);
                                        CountDownTimer yu = new CountDownTimer(2550, 500) {
                                            @Override
                                            public void onTick(long l) {

                                            }

                                            @Override
                                            public void onFinish() {
                                                maary.startAnimation(goin);
                                                CountDownTimer bng = new CountDownTimer(1100, 500) {
                                                    @Override
                                                    public void onTick(long l) {

                                                    }

                                                    @Override
                                                    public void onFinish() {
//                                                 beginners.setVisibility(View.INVISIBLE);
                                                        maary.setVisibility(View.GONE);
                                                        poles.startAnimation(poledowne);
                                                        CountDownTimer fh = new CountDownTimer(1100, 500) {
                                                            @Override
                                                            public void onTick(long l) {

                                                            }

                                                            @Override
                                                            public void onFinish() {
                                                                poles.startAnimation(goin);

                                                                CountDownTimer hjt = new CountDownTimer(1100, 500) {
                                                                    @Override
                                                                    public void onTick(long l) {

                                                                    }

                                                                    @Override
                                                                    public void onFinish() {
                                                                        beginners.setVisibility(View.VISIBLE);
                                                                        beginners.startAnimation(comeout);
                                                                        beginners.startAnimation(transcont);
                                                                        poles.setVisibility(View.GONE);
                                                                        CountDownTimer hfd = new CountDownTimer(1000, 500) {
                                                                            @Override
                                                                            public void onTick(long l) {

                                                                            }

                                                                            @Override
                                                                            public void onFinish() {
                                                                                beginners.setVisibility(View.GONE);
//                                                                        reyr.animeend();
//                                                                        deletea = 1;
                                                                                startActivity(mfra);
                                                                                overridePendingTransition(R.transition.slide_from_right, R.transition.slide_to_left);
                                                                                finish();
// startActivity(mfra);
                                                                            }
                                                                        }.start();
                                                                    }
                                                                }.start();
                                                            }
                                                        }.start();
                                                    }
                                                }.start();
                                            }
                                        }.start();
                                    }
                                }.start();

                            }.start();
                        }
                    }.start();
                }

            }.start();
        }
        catch (Exception e ){

        }

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
