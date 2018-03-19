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

public class CHEMICAL_EVENTS_MAIN extends AppCompatActivity {

    private FeatureCoverFlow coverFlow_CHEMICAL;

    private CHEMICAL_EVENT_ADAPTER CHEMICALEVENTADAPTER;

    private List<Chemical_Event_1> ChemicalEvent1List = new ArrayList<>();
    private TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical__events__main);



        initData();



        mTitle = (TextSwitcher)findViewById(R.id.title_CHEMICAL);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(CHEMICAL_EVENTS_MAIN.this);
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

        CHEMICALEVENTADAPTER = new CHEMICAL_EVENT_ADAPTER(ChemicalEvent1List,this);
        coverFlow_CHEMICAL = (FeatureCoverFlow) findViewById(R.id.coverflow_CHEMICAL);
        coverFlow_CHEMICAL.setAdapter(CHEMICALEVENTADAPTER);

        coverFlow_CHEMICAL.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(ChemicalEvent1List.get(position).getName());


            }

            @Override
            public void onScrolling() {

            }
        });


        coverFlow_CHEMICAL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    Intent in = new Intent(getApplicationContext(),Dshriti_Chem.class);
                    startActivity(in);

                }
                if(position == 1)
                {
                    Intent in = new Intent(getApplicationContext(),Tech_Talk.class);
                    startActivity(in);
                }

                if(position == 2)
                {
                    Intent in = new Intent(getApplicationContext(),Water_rocket.class);
                    startActivity(in);
                }


            }
        });



    }

    private void initData()
    {


        ChemicalEvent1List.add(new Chemical_Event_1("Drishti Chem","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQf3wEFkl5fTuuEmjHG3mZDLOUKgP_pc1gkReMkobt7nGYq_fQM6A"));
        ChemicalEvent1List.add(new Chemical_Event_1("Tech Talk","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTl2xGfUMaKAm4mjC9whIabBvAXeriHzyRSjKvV82W-iyecmPNp"));
        ChemicalEvent1List.add(new Chemical_Event_1("Water Rocket","http://www.bioedonline.org/BioEd/cache/file/2250AD61-9A05-41D7-B0D3D2B0803CD68E.jpg"));

    }

}
