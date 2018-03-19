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

public class ECT_EVENTS_MAIN extends AppCompatActivity {

    private FeatureCoverFlow coverFlow_ECT;

    private ECT_EVENT_ADAPTER ECTEVENTADAPTER;

    private List<ECT_EVENT_1> ECTEvent1List = new ArrayList<>();
    private TextSwitcher mTitle_ECT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ect__events__main);


        initData();



        mTitle_ECT = (TextSwitcher)findViewById(R.id.title_ECT);
        mTitle_ECT.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(ECT_EVENTS_MAIN.this);
                TextView txt = (TextView) inflater.inflate((R.layout.layout_title),null);
                txt.setTextColor(Color.BLACK);
                txt.setTextSize(40);

                return txt;

            }
        });

        Animation in = AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_bottom);

        mTitle_ECT.setAnimation(in);
        mTitle_ECT.setAnimation(out);




        ECTEVENTADAPTER = new ECT_EVENT_ADAPTER(ECTEvent1List,this);
        coverFlow_ECT = (FeatureCoverFlow) findViewById(R.id.coverflow_ECT);
        coverFlow_ECT.setAdapter(ECTEVENTADAPTER);

        coverFlow_ECT.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle_ECT.setText(ECTEvent1List.get(position).getName());


            }

            @Override
            public void onScrolling() {

            }
        });


        coverFlow_ECT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Intent in = new Intent(getApplicationContext(),Circuit_Making_ECT.class);
                    startActivity(in);

                }
                if(position == 1)
                {
                    Intent in = new Intent(getApplicationContext(),Tech_Hunt.class);
                    startActivity(in);
                }

                if(position == 2)
                {
                    Intent in = new Intent(getApplicationContext(),Mat_Mania.class);
                    startActivity(in);
                }

                if(position == 3)
                {
                    Intent in = new Intent(getApplicationContext(),AquaBoat.class);
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


        ECTEvent1List.add(new ECT_EVENT_1("Circuit Making","https://image.freepik.com/free-vector/technological-logo_1035-6545.jpg"));
        ECTEvent1List.add(new ECT_EVENT_1("Tech Hunt","https://image.freepik.com/free-photo/light-bulb-with-monuments-drawn-around_1232-886.jpg"));
        ECTEvent1List.add(new ECT_EVENT_1("Mat-Mania","https://www.zyxware.com/files/styles/article/public/software_testing.jpg?itok=0j0cFmYc"));
        ECTEvent1List.add(new ECT_EVENT_1("AquaBoat","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQ-aILSlL1_VBPHLXXaEsKSsmInolPqo4las8Q_XZmgZZ71Yf2"));

    }

    void Circlemenu(View v)
    {
        Intent in = new Intent(getApplicationContext(),Floatingmenu.class);
        startActivity(in);
    }


}
