package com.example.theth.examplep3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Admin on 10/25/2017.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Animal> arrayList;

    public GridViewAdapter(Context context, ArrayList<Animal> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        ImageView picturesView;
        if (convertView == null) {
            picturesView = new ImageView(context);
            //Trọng tâm của ảnh ở giữa
            picturesView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            //thiết lập widthvaf heigh cho ảnh
            picturesView.setLayoutParams(new GridView.LayoutParams(270, 270));
        } else {
            picturesView = (ImageView) convertView;
        }
        Animal animal = arrayList.get(position);
        try {
            // get input stream
            InputStream ims = context.getAssets().open(animal.getUrl());
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            picturesView.setImageDrawable(d);
        } catch (IOException ex) {
        }
        return picturesView;
    }

//    public class ViewHoler {
//        public ImageView imageView;
//    }
}
