package com.jnec.techfest.swayambhu;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MECH_EVENTS_MAIN extends AppCompatActivity {

    private FeatureCoverFlow MechcoverFlow;

    private MECH_EVENT_ADAPTER MECHEVENTADAPTER;

    private List<MECH_EVENT_1> MechEvent1List = new ArrayList<>();
    private TextSwitcher mTitle_mech;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech_events_main);


        initData();



        mTitle_mech = (TextSwitcher)findViewById(R.id.title_mech);
        mTitle_mech.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MECH_EVENTS_MAIN.this);
                TextView txt = (TextView) inflater.inflate((R.layout.layout_title),null);
                txt.setTextColor(Color.BLACK);
                txt.setTextSize(30);

                return txt;

            }
        });

        Animation in = AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_bottom);

        mTitle_mech.setAnimation(in);
        mTitle_mech.setAnimation(out);


        //

        MECHEVENTADAPTER = new MECH_EVENT_ADAPTER(MechEvent1List,this);
        MechcoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow_mech);
        MechcoverFlow.setAdapter(MECHEVENTADAPTER);

        MechcoverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle_mech.setText(MechEvent1List.get(position).getName());


            }

            @Override
            public void onScrolling() {

            }
        });


        MechcoverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 1)
                {
                    Intent in = new Intent(getApplicationContext(),Lathe_War_Mech.class);
                    startActivity(in);
                }
                if(position == 2)
                {
                    Intent in = new Intent(getApplicationContext(),Auto_CAD_Desgin.class);
                    startActivity(in);
                }
            }
        });


       /* Animation a = AnimationUtils.loadAnimation(this, R.anim.textanim);
        a.reset();
        TextView tv = (TextView) findViewById(R.id.txtanim);
        tv.clearAnimation();
        tv.startAnimation(a);*/

    }

    private void initData()
    {


        MechEvent1List.add(new MECH_EVENT_1("AutoCAD Design","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCxkKNPeMq4NV4ZygsoYDDXYeh9gvYp5E9MR8avThHKMybDovhyQ"));
        MechEvent1List.add(new MECH_EVENT_1("Lathe War","https://i.ytimg.com/vi/0zwVKxM7YGs/hqdefault.jpg"));


    }


}
