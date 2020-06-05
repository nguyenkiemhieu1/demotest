package com.example.theth.examplep3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

public class TypeAdapter extends ArrayAdapter<Type> {
    Context context;
    int layout;
    ArrayList<Type> list;

    public TypeAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Type> objects) {
        super(context, resource, objects);
        this.context = context;
        layout = resource;
        list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = ((Activity) context).getLayoutInflater().inflate(layout, null);
        ImageView imgAnimal = (ImageView) view.findViewById(R.id.imgAnimal);
        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        Type type = list.get(position);
        txtName.setText(type.getName());

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        imgAnimal.setMaxWidth(width / 2);
        imgAnimal.setMaxHeight(width / 2);
        String url = "";
        switch (type.getId()) {
            case "1":
                url = "african/antelope.jpg";
                break;
            case "2":
                url = "domestic/buffalo.jpg";
                break;
            case "3":
                url = "pets/bat.jpg";
                break;
            case "4":
                url = "birds/crane.jpg";
                break;
            case "5":
                url = "insects/ant.jpg";
                break;
            case "6":
                url = "amphibian/alligator.jpg";
                break;
            case "7":
                url = "underwater/clam.JPG";
                break;
        }
        try {
            // get input stream
            InputStream ims = context.getAssets().open(url);
            // load image as Drawable
//            Drawable d = Drawable.createFromStream(ims, null);
            Bitmap bitmap = BitmapFactory.decodeStream(ims);
            // set image to ImageView
//            imgAnimal.setImageDrawable(d);
            imgAnimal.setImageBitmap(Bitmap.createScaledBitmap(bitmap, width / 2, width / 2, false));
            ims.reset();
            ims.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return view;
    }
}
