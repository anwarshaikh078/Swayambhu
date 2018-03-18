package com.jnec.techfest.swayambhu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Profile extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView Email;
    private TextView name;
    private TextView con;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);


        Email = (TextView) v.findViewById(R.id.profile_email);
        name = (TextView) v.findViewById(R.id.profile_Username);

        con = (TextView) v.findViewById(R.id.profile_contact);

        Email.setText(StudentInfo.getEmail());
        name.setText(StudentInfo.getname());
        con.setText(StudentInfo.getContact());

        //Toast.makeText(getActivity(),"Email:"+StudentInfo.getEmail(),Toast.LENGTH_SHORT).show();
        //Toast.makeText(getActivity(),"Name:"+StudentInfo.getname(),Toast.LENGTH_SHORT).show();
        //Toast.makeText(getActivity(),"Contact:"+StudentInfo.getContact(),Toast.LENGTH_SHORT).show();
        //return inflater.inflate(R.layout.fragment_profile, container, false);
        return v;
    }





}
