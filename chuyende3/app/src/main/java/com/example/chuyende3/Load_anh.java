package com.example.chuyende3;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.HttpURLConnection;
import java.net.URL;
import android.os.Handler;

public class Load_anh extends AppCompatActivity {
    ImageView img;
    ProgressDialog progressDialog;
    Bitmap bitmap;
    String Link = "https://www.hiepsibaotap.com/wp-content/uploads/2016/08/Untitled-1.png";
    Handler handler;
    URL url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_anh);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Init();
        handler=new Handler(){//C1
            @Override
            public void handleMessage(Message msg) {
//Hien thi
                progressDialog.dismiss();
                img.setImageBitmap(bitmap);
                super.handleMessage(msg);
            }
        };
    }

    private void Init() {
        img = (ImageView) findViewById(R.id.img);
        progressDialog = new ProgressDialog(Load_anh.this);
        progressDialog.setTitle("Thông báo!");
        progressDialog.setMessage("Đang tải hình..please wait...");
    }
    public void DownloadingImage(View v) {
        // Thực thi một đoạn code trong background
        final Thread task=new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //La
                    url = new URL(Link);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bitmap = BitmapFactory.decodeStream(con.getInputStream());
                    //get data tu buoc XL ton time
                    Message msg;
                    msg = handler.obtainMessage(1,bitmap);
                    //truyen ve main thread
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        task.start();
    }
}
