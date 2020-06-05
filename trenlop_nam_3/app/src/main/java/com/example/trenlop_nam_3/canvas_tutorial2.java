package com.example.trenlop_nam_3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class canvas_tutorial2 extends AppCompatActivity {
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_tutorial2);
        Paint mPaint = new Paint();

        linearLayout = findViewById(R.id.linearlayout);
        MyView myView = new MyView(this);
        linearLayout.addView(myView);
    }
//    public void VeTamGiac(){
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dieuanh);
//        final Rect rect = new Rect(0, 0, bitmap.getWidth(),
//                bitmap.getHeight());
//
//        Point point1_draw = new Point(450, 0);
//        Point point2_draw = new Point(0, 900);
//        Point point3_draw = new Point(900, 900);
//
//        Path path = new Path();
//        path.moveTo(point1_draw.x, point1_draw.y);
//        path.lineTo(point2_draw.x, point2_draw.y);
//        path.lineTo(point3_draw.x, point3_draw.y);
//        path.lineTo(point1_draw.x, point1_draw.y);
//        path.close();
//        //Thiết lập màu nền trắng
//        canvas.drawARGB(0, 0, 0, 0);
//        p.setColor(Color.parseColor("#BAB399"));
//        //Vẽ Path
//        canvas.drawPath(path, p);
//        // Thiết lập lấy giao bên trong Path và ảnh
//        p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        canvas.drawText("Hình tam giác",300,1000,p);
//        // Vẽ ảnh lên Bitmap
//        canvas.drawBitmap(bitmap, rect, rect, p);
//        img.setImageBitmap(bmp);
//    }
//
//    String[]tenMau =new String[]{"Xanh", "Đỏ", "Tím", "Vàng", "Hồng", "Cam", "Đen"};
//    int[]Mau =new int[]{R.color.xanh, R.color.Do,R.color.tim, R.color.vang,R.color.hong, R.color.Cam, R.color.den};
//    public void MauSac(int i){
//        canvas.drawColor(Color.WHITE);
//        img.startAnimation(animation);
//        p.setColor(getResources().getColor(Mau[i]));
//        canvas.drawRect(400,600,500,800,p);
//        canvas.drawRoundRect(new RectF(100,100,800,600),70,100,p);
//        //canvas.drawOval(100,100,800,700,p);
//        p.setColor(Color.BLACK);
//        if(tenMau[i]=="Đen")
//            p.setColor(Color.WHITE);
//        canvas.drawText(" Màu "+tenMau[i],300,400,p);
//        img.setImageBitmap(bmp);
//
//    }
//    public void veHinhTronNhieuMau()
//    { tt++;
//        p.setColor(Color.RED);
//        canvas.drawArc(100,100, 700,700, 0,51, true, p);
//        p.setColor(getResources().getColor(R.color.Cam));
//        canvas.drawArc(100,100, 700,700, 51,103, true, p);
//        p.setColor(Color.GREEN);
//        canvas.drawArc(100,100, 700,700, 103,154, true, p);
//        p.setColor(Color.YELLOW);
//        canvas.drawArc(100,100, 700,700, 154,205, true, p);
//        p.setColor(Color.BLUE);
//        canvas.drawArc(100,100, 700,700, 205,55, true, p);
//        p.setColor(getResources().getColor(R.color.hong));
//        canvas.drawArc(100,100, 700,700, 260,50, true, p);
//        p.setColor(getResources().getColor(R.color.tim));
//        canvas.drawArc(100,100, 700,700, 310,59, true, p);
//        img.setImageBitmap(bmp);
//        img.startAnimation(animation2);
//
//    }
//
//    public void veBieuDoCot(String[] tenCot, int[]soLieu)
//    {
//        tt++;
//        int top, left=100, right;
//        canvas.drawLine(100,100,100,800, p);
//        canvas.drawLine(100,100,85,115, p);
//        canvas.drawLine(100,100,115,115, p);
//        canvas.drawLine(100,800,800,800, p);
//        canvas.drawLine(785,815,800,800, p);
//        canvas.drawLine(785,785,800,800, p);
//        canvas.drawText("Năm",810,800,p);
//        canvas.drawText("Sản lượng",40,70,p);
//        // Vẽ các khối hình chữ nhật biểu đồ
//        for(int i=0; i<tenCot.length;i++)
//        {
//            left=left+100;
//            right=left+100;
//            top=800-soLieu[i]*100;
//            canvas.drawRect(left,top,right,800,p);
//            canvas.drawText(tenCot[i],left,880,p);
//            canvas.drawText(soLieu[i]*100+"",left,top-40,p);
//            left=left+60;
//        }
//        img.setImageBitmap(bmp);
//
//    }
//    //Câu lệnh này đặt trong hàm oncreate()
//    veBieuDoCot(new String[]{"2015","2016","2017", "2018"},new int[]{3,2,5,7})
}
