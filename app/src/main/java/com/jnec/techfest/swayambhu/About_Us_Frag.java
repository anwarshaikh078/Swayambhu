package com.jnec.techfest.swayambhu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class About_Us_Frag extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    CardView c1,c2;


    public About_Us_Frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment About_Us_Frag.
     */
    // TODO: Rename and change types and number of parameters
    public static About_Us_Frag newInstance(String param1, String param2) {
        About_Us_Frag fragment = new About_Us_Frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about__us_, container, false);


          c1 = (CardView) v.findViewById(R.id.Our_team_card);
         c2 = (CardView) v.findViewById(R.id.develeper_card);




        c1.setOnClickListener(this);
        c2.setOnClickListener(this);








        //Toast.makeText(getActivity(),"Email:"+StudentInfo.getEmail(),Toast.LENGTH_SHORT).show();
        //Toast.makeText(getActivity(),"Name:"+StudentInfo.getname(),Toast.LENGTH_SHORT).show();
        //Toast.makeText(getActivity(),"Contact:"+StudentInfo.getContact(),Toast.LENGTH_SHORT).show();
        //return inflater.inflate(R.layout.fragment_profile, container, false);
        return v;

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {


            case R.id.Our_team_card:
                startActivity(new Intent(getActivity(),Our_Team.class));
                break;

            case R.id.develeper_card:
                startActivity(new Intent(getActivity(),Developers_activity.class));
                break;

            default:
                break;
        }

    }

}
