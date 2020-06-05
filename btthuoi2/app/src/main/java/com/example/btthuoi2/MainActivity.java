package com.example.btthuoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.btthuoi2.Bai1.bai1;
import com.example.btthuoi2.Bai2.bai2;

public class MainActivity extends AppCompatActivity {
    Button btnbai1, btnbai2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnbai1 = (Button) findViewById(R.id.btn_bai1);
        btnbai2 = (Button) findViewById(R.id.btn_bai2);
        btnbai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, bai1.class);
                startActivity(intent);
            }
        });
        btnbai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, bai2.class);
                startActivity(intent);
            }
        });
    }

}
