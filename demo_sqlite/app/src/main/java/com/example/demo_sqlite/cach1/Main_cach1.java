package com.example.demo_sqlite.cach1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo_sqlite.R;

import java.util.ArrayList;
import java.util.List;

public class Main_cach1 extends AppCompatActivity {
    Button btna, btnb, btnc, btnd;
    List<listcauhoi> ds_cauhoi;
    listcauhoi cauhoiht;
    TextView txtv;
    int i = 0;
    int socau = 2;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cach1);
        ax();
        DatabaseHandler db= new DatabaseHandler(this);
        try {
            db.createdatabase();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "lỗi tạo cơ sở dữ liệu", Toast.LENGTH_SHORT).show();
        }
        ds_cauhoi = new ArrayList<listcauhoi>();
        ds_cauhoi = db.layngaunhien(socau);
        hienthi(i);
    }

    public void ax() {
        btna=(Button)findViewById(R.id.btna);
        btnb=(Button)findViewById(R.id.btnb);
        btnc=(Button)findViewById(R.id.btnc);
        btnd=(Button)findViewById(R.id.btnd);
        txtv=(TextView)findViewById(R.id.txtv);
    }
    public  void hienthi(int vitri){
        cauhoiht = ds_cauhoi.get(vitri);
        txtv.setText(cauhoiht.cauhoi);
        btna.setText(cauhoiht.cauA);
        btnb.setText(cauhoiht.cauB);
        btnc.setText(cauhoiht.cauC);
        btnd.setText(cauhoiht.cauD);

    }
}
