package com.example.trenlop_nam_3;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class thiet_ke extends AppCompatActivity {
TextView diem,cauhoi;
EditText sodiem,thongtin;
Button cau1,cau2,cau3,cau4,ketqua;
Integer soa,sob ,dapan,diemm= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thiet_ke);
        ui();
        anhxa();
    }

    private void anhxa() {
        Random r=new Random();
        soa=r.nextInt(100);
        sob=r.nextInt(100);
        final Integer []Array=new Integer[]{soa+sob,soa-sob,soa*sob,soa/sob};
        dapan=r.nextInt(3);
        if(dapan==0)cauhoi.setText(""+soa+"+"+sob+"");
        if(dapan==1)cauhoi.setText(""+soa+"-"+sob+"");
        if(dapan==2)cauhoi.setText(""+soa+"*"+sob+"");
        if(dapan==3)cauhoi.setText(""+soa+"/"+sob+"");
        final Integer vitri=r.nextInt(3);
        if(vitri==0)cau1.setText(Array[dapan]+"");
        else cau1.setText(Array[dapan]+r.nextInt(100)+"");
        if(vitri==1)cau2.setText(Array[dapan]+"");
        else cau2.setText(Array[dapan]+r.nextInt(100)+"");
        if(vitri==2)cau3.setText(Array[dapan]+"");
        else cau3.setText(Array[dapan]+r.nextInt(100)+"");
        if(vitri==3)cau4.setText(Array[dapan]+"");
        else cau4.setText(Array[dapan]+r.nextInt(100)+"");
        cau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Resources res= getResources();
//                Drawable drawable=res.getDrawable(R.drawable.mau_nhan);
//
//                cau1.setBackground(drawable);

                if(Array[dapan]==Integer.parseInt(cau1.getText().toString())){
                    anhxa();
                    diemm=diemm+10;
                    diem.setText(diem+"");
                    Toast.makeText(thiet_ke.this, "ban tra loi dung", Toast.LENGTH_SHORT).show();

                }
                else
                    {
                    Toast.makeText(thiet_ke.this, "ban ta io sai", Toast.LENGTH_SHORT).show();
                    diemm=diemm-5;
                    diem.setText(diemm+"");
                }
            }
        });
        cau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Array[dapan]==Integer.parseInt(cau2.getText().toString())){
                    anhxa();
                    diemm=diemm+10;
                    diem.setText(diem+"");
                    Toast.makeText(thiet_ke.this, "ban tra loi dung", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(thiet_ke.this, "ban ta io sai", Toast.LENGTH_SHORT).show();
                    diemm=diemm-5;
                    diem.setText(diemm+"");
                }
            }
        });
        cau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Array[dapan]==Integer.parseInt(cau3.getText().toString())){
anhxa();                    diemm=diemm+10;
                    diem.setText(diem+"");
                    Toast.makeText(thiet_ke.this, "ban tra loi dung", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(thiet_ke.this, "ban ta io sai", Toast.LENGTH_SHORT).show();
                    diemm=diemm-5;
                    diem.setText(diemm+"");
                }
            }
        });
        cau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Array[dapan]==Integer.parseInt(cau4.getText().toString())){
                    anhxa();
                    diemm=diemm+10;
                    diem.setText(diem+"");
                    Toast.makeText(thiet_ke.this, "ban tra loi dung", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(thiet_ke.this, "ban ta io sai", Toast.LENGTH_SHORT).show();
                    diemm=diemm-5;
                    diem.setText(diemm+"");
                }
            }
        });
        ketqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anhxa();
            }
        });

    }

    private void ui() {
        diem=(TextView)findViewById(R.id.tv_diem);
        cauhoi=(TextView)findViewById(R.id.tv_cauhoi);
        sodiem=(EditText)findViewById(R.id.edt_diem);
        thongtin=(EditText)findViewById(R.id.edt_cauhoi);
        cau1=(Button)findViewById(R.id.btn_dan1);
        cau2=(Button)findViewById(R.id.btn_dan2);
        cau3=(Button)findViewById(R.id.btn_dan3);
        cau4=(Button)findViewById(R.id.btn_dan4);
        ketqua=(Button)findViewById(R.id.btn_tieptuc);

    }


}
