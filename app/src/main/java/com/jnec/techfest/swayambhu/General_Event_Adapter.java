package com.jnec.techfest.swayambhu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class General_Event_Adapter extends BaseAdapter {

    private List<General_Event_1> GeneralEvent1List;
    private Context mcontext;

    public General_Event_Adapter(List<General_Event_1> GeneralEvent1List, Context mcontext) {
        this.GeneralEvent1List = GeneralEvent1List;
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return GeneralEvent1List.size();

    }

    @Override
    public Object getItem(int position)
    {
        return GeneralEvent1List.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView = view;

        if(rowView == null)
        {
            rowView = LayoutInflater.from(mcontext).inflate(R.layout.layout_item,null);

            TextView name = (TextView) rowView.findViewById(R.id.label);

            ImageView image = (ImageView) rowView.findViewById(R.id.image);


            Picasso.with(mcontext).load(GeneralEvent1List.get(position).getPathofimage()).into(image);
            name.setText(GeneralEvent1List.get(position).getName());
        }
        return  rowView;
    }
}
