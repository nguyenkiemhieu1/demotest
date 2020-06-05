package com.example.ktth_cd3_26_5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapterclass extends BaseAdapter {


    Activity context;
    ArrayList<dtclass> list;

    public Adapterclass(Activity context, ArrayList<dtclass> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View row=inflater.inflate(R.layout.itemlv, null);

        TextView tvid=row.findViewById(R.id.tvid);
        TextView tvlop=row.findViewById(R.id.tvlop);
        TextView tvdiem=row.findViewById(R.id.tvdiem);
        TextView tvten=row.findViewById(R.id.tvten);


        final dtclass dtclass=list.get(position);
        if (dtclass != null) {
            tvid.setText(dtclass.getId()+"");
            tvlop.setText(dtclass.getLop()+"");
            tvdiem.setText(dtclass.getDiem()+"");
            tvten.setText(dtclass.getTen());
//
        }
        return row;
    }

}
