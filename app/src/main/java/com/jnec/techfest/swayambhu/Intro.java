package com.jnec.techfest.swayambhu;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
 // java.util.concurrent.TimeUnit;

public class Intro extends AppCompatActivity {
    LinearLayout l1, l2;
    Animation uptodown, downtoup;
    boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

       l1 = (LinearLayout) findViewById(R.id.l1);


       uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
       l1.setAnimation(uptodown);

        flag = false;
        final LottieAnimationView animationView = (LottieAnimationView)findViewById(R.id.animation_view3);

        


// CSE Animation
// Custom animation speed or duration.
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f)
                .setDuration(0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animationView.setProgress((Float)animation.getAnimatedValue());
            }
        });
        animator.start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                    Toast.makeText(getApplicationContext(),"Make sure you are connected to INTERNET !!!",Toast.LENGTH_SHORT).show();

                    while (isOnline() == false)
                    {
                        //Toast.makeText(getApplicationContext(),"Make sure you are connected to INTERNET !!!",Toast.LENGTH_SHORT).show();
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Intent i = new Intent(Intro.this, WelcomeActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Intent i = new Intent(Intro.this, Login.class);
                        startActivity(i);
                        finish();
                    }
            }
        }, 2900);

    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
}