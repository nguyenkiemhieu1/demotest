package com.example.baitap;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class bai1 extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private Button btDo, btXanh, btTim, btVang,btCam;
    private Canvas mCanvas;
    private Paint mPaint;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setup();
    }

    private void init() {
        btDo = (Button) findViewById(R.id.bt_mauDo);
        btTim = (Button) findViewById(R.id.bt_mauTim);
        btVang = (Button) findViewById(R.id.bt_mauVang);
        btCam = (Button) findViewById(R.id.bt_mauCam);
        btXanh = (Button) findViewById(R.id.bt_mauXanh);
        imageView = findViewById(R.id.myImageView);
        bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(bitmap);
        mPaint = new Paint();
    }

    private void setup(){
        // Thi?t l?p d? r?ng c?a bút v? là 50px
        mPaint.setStrokeWidth(10);
        //Thi?t l?p nét v? du?c tron m?n
        mPaint.setAntiAlias(true);
        //màu n?n
        mCanvas.drawColor(Color.WHITE);
        btDo.setOnClickListener(this);
        btCam.setOnClickListener(this);
        btTim.setOnClickListener(this);
        btVang.setOnClickListener(this);
        btXanh.setOnClickListener(this);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_mauVang:
                btVang.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.coloryellow));
                btDo.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btCam.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btTim.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btXanh.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                tamGiacCan();
                break;
            case R.id.bt_mauDo:
                btDo.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorRed));
                btCam.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btTim.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btVang.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btXanh.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                hinhTron();
                break;
            case R.id.bt_mauCam:
                btCam.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorOrange));
                btDo.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btTim.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btVang.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btXanh.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                tamGiacDeu();
                break;
            case R.id.bt_mauTim:
                btTim.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorviolet));
                btVang.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btXanh.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btCam.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btDo.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                hinhElip();
                break;
            case R.id.bt_mauXanh:
                btXanh.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorgreen));
                btCam.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btDo.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btTim.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                btVang.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(),R.color.colorPrimary));
                hinhVuong();
                break;
        }
    }

    private void hinhTron(){
        mCanvas.drawColor(Color.WHITE);
        mPaint.setColor(getResources().getColor(R.color.colorRed));
        mCanvas.drawCircle(600, 600, 250,mPaint);
        imageView.setImageBitmap(bitmap);
    }

    private void hinhVuong(){
        mCanvas.drawColor(Color.WHITE);
        mPaint.setColor(getResources().getColor(R.color.colorgreen));
        mCanvas.drawRect(300,300,700,700,mPaint);
        imageView.setImageBitmap(bitmap);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void hinhElip(){
        mCanvas.drawColor(Color.WHITE);
        mPaint.setColor(getResources().getColor(R.color.colorviolet));
        mCanvas.drawOval(200,200,800,600,mPaint);
        imageView.setImageBitmap(bitmap);
    }

    private void tamGiacCan(){
        mCanvas.drawColor(Color.WHITE);
        mPaint.setColor(Color.YELLOW);
        Point point1_draw = new Point(500, 100);
        Point point2_draw = new Point(100, 500);
        Point point3_draw = new Point(950, 500);

        Path path = new Path();
        path.moveTo(point1_draw.x, point1_draw.y);
        path.lineTo(point1_draw.x, point1_draw.y);
        path.lineTo(point2_draw.x, point2_draw.y);
        path.lineTo(point3_draw.x, point3_draw.y);
        path.close();
        mCanvas.drawPath(path, mPaint);
        imageView.setImageBitmap(bitmap);
    }

    private void tamGiacDeu(){
        mCanvas.drawColor(Color.WHITE);
        mPaint.setColor(getResources().getColor(R.color.colorOrange));
        Point point1 = new Point(300, 100);
        Point point2 = new Point(300, 500);
        Point point3 = new Point(700, 500);

        Path path1 = new Path();
        path1.moveTo(point1.x, point1.y);
        path1.lineTo(point1.x, point1.y);
        path1.lineTo(point2.x, point2.y);
        path1.lineTo(point3.x, point3.y);
        path1.close();
        mCanvas.drawPath(path1, mPaint);
        imageView.setImageBitmap(bitmap);
    }
}