package com.example.trenlop_nam_3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class bai1_BT_trenlop extends AppCompatActivity {
    Bitmap bitmap;
    Canvas canvas;
    ImageView img;
    Paint paint;
    Button btntron, btnvuong, btntamgiac, btnhcn, btnelip;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_trenlop);
        bitmap = Bitmap.createBitmap(500,500, Bitmap.Config.ARGB_8888);
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        canvas = new Canvas(bitmap);
        btntron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvas.drawColor(Color.WHITE); // Xóa các hình vẽ trước đó
                canvas.drawCircle(200, 250, 150, paint);// vẽ hình tròn có tâm (200,250) bán kính =150
                img.setImageBitmap(bitmap); //Reset lại imageview
                img.invalidate();
            }
        });
        btnhcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvas.drawColor(Color.WHITE); // Xóa các hình đã vẽ trước đó
                canvas.drawRect(20,100,200, 250, paint); // Vẽ hình chữ nhật
                img.setImageBitmap(bitmap);
                img.invalidate();
            }
        });
        btnelip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvas.drawColor(Color.WHITE);
                canvas.drawCircle(100,50,50, paint);
                img.setImageBitmap(bitmap);
                img.invalidate();
            }
        });
        btnvuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvas.drawColor(Color.WHITE);
                canvas.drawRect(50,50,100,50,paint);
                img.setImageBitmap(bitmap);
                img.invalidate();
            }
        });
        btntamgiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Point point1_draw= new Point(0,50);
                Point point2_draw= new Point(60,150);
                Point point3_draw= new Point(150,70);

                Path path= new Path();
                path.moveTo(point1_draw.x, point1_draw.y);
                path.lineTo(point2_draw.x, point2_draw.y);
                path.lineTo(point3_draw.x, point3_draw.y);
                path.lineTo(point1_draw.x, point1_draw.y);
                path.close();
            }
        });


        ax();
    }

    private void ax() {
        img=(ImageView)findViewById(R.id.imghinh) ;
        btnvuong=(Button)findViewById(R.id.btnvuong);
        btnelip=(Button)findViewById(R.id.btnelip);
        btnhcn=(Button)findViewById(R.id.btnhcn);
        btntron=(Button)findViewById(R.id.btntron);
        btntamgiac=(Button)findViewById(R.id.btntamgiac);
    }

}
