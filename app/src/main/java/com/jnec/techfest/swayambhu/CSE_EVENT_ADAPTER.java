package com.jnec.techfest.swayambhu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Imroz Quazi on 26-01-2018.
 */

public class CSE_EVENT_ADAPTER extends BaseAdapter {

    private List<CSE_Event_1> CSEEvent1List;
    private Context mcontext;

    public CSE_EVENT_ADAPTER(List<CSE_Event_1> CSEEvent1List, Context mcontext) {
        this.CSEEvent1List = CSEEvent1List;
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return CSEEvent1List.size();

    }

    @Override
    public Object getItem(int position)
    {
        return CSEEvent1List.get(position);
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


            Picasso.with(mcontext).load(CSEEvent1List.get(position).getPathofimage()).into(image);
            name.setText(CSEEvent1List.get(position).getName());
        }
            return  rowView;
    }
}
