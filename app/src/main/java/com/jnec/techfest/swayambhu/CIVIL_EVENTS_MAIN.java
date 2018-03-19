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
import java.util.logging.Level;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class CIVIL_EVENTS_MAIN extends AppCompatActivity {


    private FeatureCoverFlow coverFlow_CIVIL;

    private CIVIL_EVENT_ADAPTER CIVILEVENTADAPTER;

    private List<Civil_Event_1> CivilEvent1List = new ArrayList<>();
    private TextSwitcher mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil__events__main);






            initData();



            mTitle = (TextSwitcher)findViewById(R.id.title_CIVIL);
            mTitle.setFactory(new ViewSwitcher.ViewFactory() {
                @Override
                public View makeView() {
                    LayoutInflater inflater = LayoutInflater.from(CIVIL_EVENTS_MAIN.this);
                    TextView txt = (TextView) inflater.inflate((R.layout.layout_title),null);
                    txt.setTextColor(Color.BLACK);
                    txt.setTextSize(40);

                    return txt;

                }
            });

            Animation in = AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
            Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_bottom);

            mTitle.setAnimation(in);
            mTitle.setAnimation(out);


            //

            CIVILEVENTADAPTER = new CIVIL_EVENT_ADAPTER(CivilEvent1List,this);
            coverFlow_CIVIL = (FeatureCoverFlow) findViewById(R.id.coverflow_CIVIL);
            coverFlow_CIVIL.setAdapter(CIVILEVENTADAPTER);

            coverFlow_CIVIL.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
                @Override
                public void onScrolledToPosition(int position) {
                    mTitle.setText(CivilEvent1List.get(position).getName());


                }

                @Override
                public void onScrolling() {

                }
            });


            coverFlow_CIVIL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0)
                    {
                        Intent in = new Intent(getApplicationContext(),Smarmony.class);
                        startActivity(in);

                    }
                    if(position == 1)
                    {
                        Intent in = new Intent(getApplicationContext(),CartoFest.class);
                        startActivity(in);
                    }

                    if(position == 2)
                    {
                        Intent in = new Intent(getApplicationContext(),Levelling_Master.class);
                        startActivity(in);
                    }

                    if(position == 3)
                    {
                        Intent in = new Intent(getApplicationContext(),The_Sustaining_Boat.class);
                        startActivity(in);
                    }
                }
            });


            Animation a = AnimationUtils.loadAnimation(this, R.anim.textanim);
            a.reset();
            TextView tv = (TextView) findViewById(R.id.txtanim);
            tv.setTextColor(Color.BLACK);
            tv.clearAnimation();
            tv.startAnimation(a);

        }

    private void initData()
    {


        CivilEvent1List.add(new Civil_Event_1("Smarmony","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHI42tAtDsr0x6jlyj5E7pEUh6EVpb3uYzShqUP1x6FfKyAKVj"));
        CivilEvent1List.add(new Civil_Event_1("CartoFest","https://image.freepik.com/free-vector/land-survey-and-civil-engineer-working_3446-431.jpg"));
        CivilEvent1List.add(new Civil_Event_1("Levelling Master","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYPwI5-J5Gw2JEVnnHCyJIy9L6bvsQ7Bs2qFrZQZVz-em2TldY"));
        CivilEvent1List.add(new Civil_Event_1("The Sustaining Boat","https://bookboon.com/thumbnail/720/47f230d1-2d56-4cb9-9d04-a0f600b34b87/495eed07-fa5c-40b4-9667-a5d400e1a9ca/c-1-introduction-to-programming-and-the-c-language.jpg"));

    }

}

