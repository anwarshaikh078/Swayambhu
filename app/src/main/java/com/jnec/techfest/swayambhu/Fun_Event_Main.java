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

public class Fun_Event_Main extends AppCompatActivity {


    private FeatureCoverFlow coverFlow_Fun;

    private Fun_Event_Adapter FUNEVENTADAPTER;

    private List<Fun_Event_1> FunEvent1List = new ArrayList<>();
    private TextSwitcher mTitle_Fun;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun__event__main);


        initData();



        mTitle_Fun = (TextSwitcher)findViewById(R.id.title_Fun);
        mTitle_Fun.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(Fun_Event_Main.this);
                TextView txt = (TextView) inflater.inflate((R.layout.layout_title),null);
                txt.setTextColor(Color.BLACK);
                txt.setTextSize(40);

                return txt;

            }
        });

        Animation in = AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_bottom);

        mTitle_Fun.setAnimation(in);
        mTitle_Fun.setAnimation(out);




        FUNEVENTADAPTER= new Fun_Event_Adapter(FunEvent1List,this);
        coverFlow_Fun = (FeatureCoverFlow) findViewById(R.id.coverflow_FUN);
        coverFlow_Fun.setAdapter(FUNEVENTADAPTER);

        coverFlow_Fun.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle_Fun.setText(FunEvent1List.get(position).getName());


            }

            @Override
            public void onScrolling() {

            }
        });


        coverFlow_Fun.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Intent in = new Intent(getApplicationContext(),Beg_Borrow_Steal.class);
                    startActivity(in);

                }
                if(position == 1)
                {
                    Intent in = new Intent(getApplicationContext(),Trivia.class);
                    startActivity(in);
                }

                if(position == 2)
                {
                    Intent in = new Intent(getApplicationContext(),Murder_Mystery.class);
                    startActivity(in);
                }
                if(position == 3)
                {
                    Intent in = new Intent(getApplicationContext(),LanGaming_IT.class);
                    startActivity(in);
                }
                if(position == 4)
                {
                    Intent in = new Intent(getApplicationContext(),Element_Sorting.class);
                    startActivity(in);
                }
                if(position == 5)
                {
                    Intent in = new Intent(getApplicationContext(),Image_Makeover.class);
                    startActivity(in);
                }


            }
        });


        Animation a = AnimationUtils.loadAnimation(this, R.anim.textanim);
        a.reset();
        TextView tv = (TextView) findViewById(R.id.txtanim);
        tv.clearAnimation();
        tv.startAnimation(a);

    }

    private void initData()
    {


        FunEvent1List.add(new Fun_Event_1("Beg Borrow Steal","https://cdn.movember.com/uploads/network-profile/2805f986dc753d9998254e9bfc076ea7-57f76863acea2-hero.png"));
        FunEvent1List.add(new Fun_Event_1("Trivia","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAONquF2M8dQhKky4kL49-1w3WrbEgdBJfYaP1h6YR-Tox-jFj"));
        FunEvent1List.add(new Fun_Event_1("Murder Mystery","https://t2.rbxcdn.com/f9394f26c573740776260e19051ef7ee"));
        FunEvent1List.add(new Fun_Event_1("LAN Gaming","https://steemit-production-imageproxy-thumbnail.s3.amazonaws.com/U5dtqWmtAa9ULiANacbyj9nNCj1Da3k_1680x8400"));
        FunEvent1List.add(new Fun_Event_1("Element Sorting","https://ak9.picdn.net/shutterstock/videos/10728479/thumb/1.jpg?i10c=img.resize(height:160)"));
        FunEvent1List.add(new Fun_Event_1("Image Makeover","https://bookboon.com/thumbnail/720/47f230d1-2d56-4cb9-9d04-a0f600b34b87/495eed07-fa5c-40b4-9667-a5d400e1a9ca/c-1-introduction-to-programming-and-the-c-language.jpg"));


    }


}
