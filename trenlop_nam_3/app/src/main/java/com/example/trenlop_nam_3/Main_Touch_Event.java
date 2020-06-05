package com.example.trenlop_nam_3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Main_Touch_Event extends AppCompatActivity {
    Button btnxanh, btndo, btntrang, btnden;
    ImageView imgaaa;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    Matrix matrix;
    LinearLayout linea1;
    float downx=0;
    float upx=0;
    float downy=0;
    float upy=0;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
        ax();
        bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
        paint=new Paint();
        canvas=new Canvas(bitmap);
        imgaaa.setImageBitmap(bitmap);
        paint= new Paint();
        paint.setStrokeWidth(10);
        canvas.drawColor(Color.WHITE);
        imgaaa.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action=event.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        downx=event.getX();
                        downy=event.getY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        upx=event.getX();
                        upy=event.getY();
                        canvas.drawLine(downx, downy, upx, upy, paint);
                        imgaaa.invalidate();
                        downy=upy;
                        downx=upx;
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    private void ax() {
        imgaaa=(ImageView)findViewById(R.id.imghinhaaa);
        linea1=(LinearLayout)findViewById(R.id.linea1);
        btnxanh=(Button)findViewById(R.id.btnxanh);
        btnden=(Button)findViewById(R.id.btnden);
        btndo=(Button)findViewById(R.id.btndo);
        btntrang=(Button)findViewById(R.id.btntrang);
    }
}
