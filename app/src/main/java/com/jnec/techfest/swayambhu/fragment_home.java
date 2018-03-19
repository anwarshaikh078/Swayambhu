package com.jnec.techfest.swayambhu;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;


public class fragment_home extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Animation anima;

    public fragment_home() {
    }

    ViewPager imagesliderhome;

    RelativeLayout r_cse,r_mech,r_it,r_ect;

    CardView c_cse,c_mech,c_cvivl,c_IT,c_ECT,c_chem,c_General,c_Fun,c_FAQ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View viewStart_cse,viewStart_mech,viewStart_It,viewStart_civil;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);




        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_home, container, false);





        c_cse= (CardView)v.findViewById(R.id.cardView_cse);
        c_mech= (CardView) v.findViewById(R.id.cardView_mech);
        c_cvivl= (CardView) v.findViewById(R.id.cardView_civil);

        c_ECT= (CardView) v.findViewById(R.id.cardView_ECT);
        c_General= (CardView) v.findViewById(R.id.cardView_GENERAL);
        c_Fun= (CardView) v.findViewById(R.id.cardView_FUN);
        c_chem= (CardView) v.findViewById(R.id.cardView_Chemical);
        c_FAQ= (CardView) v.findViewById(R.id.cardView_FAQ);





        c_cse.setOnClickListener(this);
        c_mech.setOnClickListener(this);
        c_FAQ.setOnClickListener(this);
        c_cvivl.setOnClickListener(this);
        c_ECT.setOnClickListener(this);
        c_chem.setOnClickListener(this);
        c_Fun.setOnClickListener(this);
        c_General.setOnClickListener(this);


        //final LottieAnimationView animationView = (LottieAnimationView)v.findViewById(R.id.animation_view);


// CSE Animation
// Custom animation speed or duration.
       /* ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f)
                .setDuration(60000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animationView.setProgress((Float) animation.getAnimatedValue());
            }
        });
        animator.start();*/

        //  animationView.cancelAnimation();

//custom color
       /* PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.LIGHTEN);
        animationView.addColorFilter(colorFilter);
        animationView.addColorFilterToLayer("hello_layer", colorFilter);
        animationView.addColorFilterToContent("hello_layer", "hello", colorFilter);
        // animationView.clearColorFilters();*/

        return  v;
       // return inflater.inflate(R.layout.fragment_fragment_home, container, false);




    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {

            case R.id.cardView_cse:

               startActivity(new Intent(getActivity(),CSE_EVENTS_MAIN.class));
                break;

            case R.id.cardView_mech:

               startActivity(new Intent(getActivity(),MECH_EVENTS_MAIN.class));
                break;


            case R.id.cardView_ECT:
                startActivity(new Intent(getActivity(),ECT_EVENTS_MAIN.class));
                break;

            case R.id.cardView_GENERAL:
                startActivity(new Intent(getActivity(),General_Event_Main.class));
                break;

            case R.id.cardView_Chemical:
                startActivity(new Intent(getActivity(),CHEMICAL_EVENTS_MAIN.class));
                break;

            case R.id.cardView_FUN:
                startActivity(new Intent(getActivity(),Fun_Event_Main.class));
                break;

            case R.id.cardView_civil:
                startActivity(new Intent(getActivity(),CIVIL_EVENTS_MAIN.class));
                break;

            case R.id.cardView_FAQ:
                startActivity(new Intent(getActivity(),FAQ_ACTIVITY.class));
                break;




            default:
                break;
        }

    }









}
