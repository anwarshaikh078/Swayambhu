package com.jnec.techfest.swayambhu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
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

public class CSE_EVENTS_MAIN extends AppCompatActivity {

    private FeatureCoverFlow coverFlow;

    private CSE_EVENT_ADAPTER CSEEVENTADAPTER;

    private List<CSE_Event_1> CSEEvent1List = new ArrayList<>();
    private TextSwitcher mTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initData();



        mTitle = (TextSwitcher)findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(CSE_EVENTS_MAIN.this);
                TextView txt = (TextView) inflater.inflate((R.layout.layout_title),null);
                txt.setTextColor(Color.BLACK);
                txt.setTextSize(30);

                return txt;

            }
        });

        Animation in = AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_bottom);

        mTitle.setAnimation(in);
        mTitle.setAnimation(out);


        //

        CSEEVENTADAPTER = new CSE_EVENT_ADAPTER(CSEEvent1List,this);
        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        coverFlow.setAdapter(CSEEVENTADAPTER);

        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(CSEEvent1List.get(position).getName());


            }

            @Override
            public void onScrolling() {

            }
        });


        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Intent in = new Intent(getApplicationContext(),CodeRelay_CSE.class);
                    startActivity(in);

                }
                if(position == 1)
                {
                    Intent in = new Intent(getApplicationContext(),C_Ladder_CSE.class);
                    startActivity(in);
                }

                if(position == 2)
                {
                    Intent in = new Intent(getApplicationContext(),CodeHolix_CSE.class);
                    startActivity(in);
                }

                if(position == 3)
                {
                    Intent in = new Intent(getApplicationContext(),Abhivyakti_IT.class);
                    startActivity(in);
                }
                if(position == 4)
                {
                    Intent in = new Intent(getApplicationContext(),Web_War_IT.class);
                    startActivity(in);
                }
            }
        });


        Animation a = AnimationUtils.loadAnimation(this, R.anim.textanim);
        a.reset();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


            TextView tv = (TextView) findViewById(R.id.txtanim);
            tv.setTextColor(Color.BLACK);
            tv.clearAnimation();
            tv.startAnimation(a);

        }

    }

    private void initData()
    {


        CSEEvent1List.add(new CSE_Event_1("Codingo","https://image.freepik.com/free-vector/web-design-background_1300-72.jpg"));
        CSEEvent1List.add(new CSE_Event_1("C-Ladder","https://res.cloudinary.com/teepublic/image/private/s--91AeMXfq--/t_Preview/b_rgb:262c3a,c_limit,f_auto,h_313,q_90,w_313/v1496756374/production/designs/1649485_1"));
        CSEEvent1List.add(new CSE_Event_1("Code-O-Holix","http://www.viewranger.com/temp/imagecache/4693-120.png"));
        CSEEvent1List.add(new CSE_Event_1("Abhivyakti","https://image.freepik.com/free-photo/people_1122-1876.jpg"));
        CSEEvent1List.add(new CSE_Event_1("Web War","https://image.freepik.com/free-vector/web-programming-background_1300-188.jpg"));

    }





}
