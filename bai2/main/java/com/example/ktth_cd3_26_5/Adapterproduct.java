package com.example.ktth_cd3_26_5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapterproduct extends BaseAdapter {


    Activity context;
    ArrayList<dtproduct> list;

    public Adapterproduct(Activity context, ArrayList<dtproduct> list) {
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
        final View row=inflater.inflate(R.layout.itemprd, null);

        TextView tvname=row.findViewById(R.id.tvname);
        TextView tvprice=row.findViewById(R.id.tvprice);
        TextView tvsize=row.findViewById(R.id.tvsize);



        final dtproduct dtproduct=list.get(position);
        if (dtproduct != null) {
            tvname.setText(dtproduct.getName()+"");
            tvprice.setText(dtproduct.getPrice()+"");
            String chuoi = "";
            for(int i = 0 ; i <dtproduct.getSizes().size();i++){
                chuoi+= dtproduct.getSizes().get(i).toString() + "\n";
            }
            tvsize.setText(chuoi+"");

//
        }
        return row;
    }

}
