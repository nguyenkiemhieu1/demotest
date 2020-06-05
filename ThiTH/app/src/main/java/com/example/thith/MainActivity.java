package com.example.thith;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.thith.BAI1.bai1Activity;
import com.example.thith.BAI2.bai2Activity;

public class MainActivity extends AppCompatActivity {
    Button btn_bai1, btn_bai2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_bai1 = (Button) findViewById(R.id.btn_bai1);
        btn_bai2 = (Button) findViewById(R.id.btn_bai2);
        btn_bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ibai1 = new Intent(MainActivity.this, bai1Activity.class);
                startActivity(ibai1);
            }
        });
        btn_bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ibai2 = new Intent(MainActivity.this, bai2Activity.class);
                startActivity(ibai2);

            }
        });

    }
}
