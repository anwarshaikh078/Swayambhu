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

public class IT_EVENTS_MAIN extends AppCompatActivity {

    private FeatureCoverFlow coverFlow_IT;

    private IT_EVENT_ADAPTER ITEVENTADAPTER;

    private List<IT_EVENT_1> ITEvent1List = new ArrayList<>();
    private TextSwitcher mTitle_IT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it__events__main);


        initData();



        mTitle_IT = (TextSwitcher)findViewById(R.id.title_IT);
        mTitle_IT.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(IT_EVENTS_MAIN.this);
                TextView txt = (TextView) inflater.inflate((R.layout.layout_title),null);
                txt.setTextColor(Color.BLACK);
                txt.setTextSize(40);

                return txt;

            }
        });

        Animation in = AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_bottom);

        mTitle_IT.setAnimation(in);
        mTitle_IT.setAnimation(out);


        //

        ITEVENTADAPTER = new IT_EVENT_ADAPTER(ITEvent1List,this);
        coverFlow_IT = (FeatureCoverFlow) findViewById(R.id.coverflow_IT);
        coverFlow_IT.setAdapter(ITEVENTADAPTER);

        coverFlow_IT.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle_IT.setText(ITEvent1List.get(position).getName());


            }

            @Override
            public void onScrolling() {

            }
        });


        coverFlow_IT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Intent in = new Intent(getApplicationContext(),Web_War_IT.class);
                    startActivity(in);

                }
                if(position == 1)
                {
                    Intent in = new Intent(getApplicationContext(),Abhivyakti_IT.class);
                    startActivity(in);
                }
                if(position == 2)
                {
                    Intent in = new Intent(getApplicationContext(),LanGaming_IT.class);
                    startActivity(in);
                }
                if(position == 3)
                {
                    Intent in = new Intent(getApplicationContext(),Codinggo_IT.class);
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


        ITEvent1List.add(new IT_EVENT_1("Web-War","http://xln.co.nz/images/xln/servicesContentWeb.png"));
        ITEvent1List.add(new IT_EVENT_1("Abhivyakti","https://cdn.pixabay.com/photo/2016/02/13/16/13/camera-1198125_960_720.jpg"));
        ITEvent1List.add(new IT_EVENT_1("Lan Gaming","http://assets-cf.gbeye.com/thumbnails/small_product_thumb_193206_1497014015.jpg"));
        ITEvent1List.add(new IT_EVENT_1("Codingo","http://www.viewranger.com/temp/imagecache/4693-120.png"));

    }

    void Circlemenu(View v)
    {
        Intent in = new Intent(getApplicationContext(),Floatingmenu.class);
        startActivity(in);
    }
}
