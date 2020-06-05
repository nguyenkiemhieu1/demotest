package com.example.bai9_cd3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Model> {
    List<Model> models;
    public CustomAdapter(Context context, int resource, List<Model> items) {
        super(context, resource, items);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Model model = models.get(position);
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.activity_list, null);
        }
        Model docBao = getItem(position);
        if (docBao != null) {
// Anh xa + Gan gia tri
            TextView txttitle = (TextView) view.findViewById(R.id.txt);
            txttitle.setText(docBao.title);

            ImageView imgView = (ImageView) view.findViewById(R.id.img_hinh);
            Picasso.get().load(model.getImage()).resize(50, 50).centerCrop().into(imgView);
        }
        return view;
    }
}