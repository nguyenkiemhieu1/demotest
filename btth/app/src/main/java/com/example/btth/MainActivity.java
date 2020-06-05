package com.example.btth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.btth.activity.Main_baitap1;
import com.example.btth.activity.Main_baitap3;
import com.example.btth.activity.Main_baitap2;

public class MainActivity extends AppCompatActivity {

    private Button btLeeson1, btLeeson2, btLeeson3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        handle();
    }

    private void init() {
        btLeeson1 = findViewById(R.id.btnLesson1);
        btLeeson2 = findViewById(R.id.btnLesson2);
        btLeeson3 = findViewById(R.id.btnLesson3);
    }

    private void handle() {
        btLeeson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main_baitap1.class);
                startActivity(intent);
            }
        });
        btLeeson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main_baitap2.class);
                startActivity(intent);
            }
        });
        btLeeson3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main_baitap3.class);
                startActivity(intent);
            }
        });
    }
}
