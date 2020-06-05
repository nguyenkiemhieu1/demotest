package com.example.trenlop_nam_3;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.trenlop_nam_3.vd_baothuc.Main_a;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3,b32,dohoa, btnanim, btnbai1, btnbai2, touch, btntl, btndt, btn_MP3, btnalarm, btn_video
        , btntl2;
TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, intent.class);
                startActivity(intent);
            }
        });

        // tạo button đổi màu
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Resources res=getResources();
//                Drawable shape=res.getDrawable(R.drawable.mau_nhan);
//                b2.setBackground(shape);
                Intent intent=new Intent(MainActivity.this,thiet_ke.class);
                startActivity(intent);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,canvas_tutorial.class);
                startActivity(intent);
            }
        });

        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,canvas_tutorial2.class);
                startActivity(intent);
            }
        });
        dohoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, animation.class);
                startActivity( intent);
            }
        });

        btnanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this, animation.class);
                startActivity( intent1);
            }
        });
        btnbai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this, bai1_BT_trenlop.class);
                startActivity( intent1);
            }
        });
        btnbai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this, Main_baiTH2_bai1.class);
                startActivity( intent1);
            }
        });
        touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this, Main_Touch_Event.class);
                startActivity( intent1);
            }
        });
        btntl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, bai1_lt.class);
                startActivity(intent);
            }
        });
        btnbai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Main_bai2_lt.class);
                startActivity(intent);
            }
        });
        btndt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Main_da_tuyen.class);
                startActivity(intent);
            }
        });
        btn_MP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Main_nhac.class);
                startActivity(intent);
            }
        });
        btnalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Main_a.class);
                startActivity(intent);
            }
        });
        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, video_view.class);
                startActivity(intent);
            }
        });
    }
    private void anhxa() {
        btn_video=(Button)findViewById(R.id.video_view) ;
        btnalarm=(Button)findViewById(R.id.btn_alarm);
        b1=(Button)findViewById(R.id.intent);
        b2=(Button)findViewById(R.id.btn_thietke);
        b3=(Button)findViewById(R.id.btn_canvas);
        b32=(Button)findViewById(R.id.btn_canvas2);
        dohoa=(Button)findViewById(R.id.btn_dohoa2d);
        btnanim=(Button)findViewById(R.id.btnanim);
        btnbai1=(Button)findViewById(R.id.btnbai1);
        btnbai2=(Button)findViewById(R.id.btnbai2);
        touch=(Button)findViewById(R.id.touch);
        btntl=(Button)findViewById(R.id.btntl);
        btnbai2=(Button)findViewById(R.id.btnbai2lt);
        btndt=(Button)findViewById(R.id.btndt);
        btn_MP3=(Button)findViewById(R.id.btn_mp3);
    }
}