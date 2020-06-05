package com.example.demo_ch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main_bang extends AppCompatActivity {
    TextView txtv_ten;
    ImageView img;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang);
        ax();
    }


    private void ax() {
        txtv_ten=(TextView)findViewById(R.id.txtvten);
        img=(ImageView)findViewById(R.id.img_bang);
        switch (MainActivity.x){
            case 1:
                img.setImageResource(R.drawable.aa);
                break;
            case 2:
                new loadimg().execute("https://vignette.wikia.nocookie.net/mon-hoc/images/4/49/Bang-tuan-hoan-cac-nguyen-to-hoa-hoc.jpg/revision/latest/scale-to-width-down/600?cb=20171007153010&path-prefix=vi");
                break;
            case 3:
               new loadimg().execute("https://dinhnghia.vn/wp-content/uploads/2019/06/day-hoat-dong-hoa-hoc-1.jpg.");

                break;
        }
    }
    private  class loadimg extends AsyncTask<String, Void , Bitmap>{
        Bitmap bitmaphinh = null;

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                URL uri=new URL(strings[0]);
                InputStream inputStream=uri.openConnection().getInputStream();

                 bitmaphinh= BitmapFactory.decodeStream(inputStream);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmaphinh;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            img.setImageBitmap(bitmap);
        }
    }
}
