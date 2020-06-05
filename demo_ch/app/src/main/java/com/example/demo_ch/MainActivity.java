package com.example.demo_ch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_tuanhoan, btn_tan, btn_tc;
    public static int x = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ax();
    }

    private void ax() {
        btn_tuanhoan = (Button) findViewById(R.id.btn_tuanhoan);
        btn_tc = (Button) findViewById(R.id.btn_tc);
        btn_tan = (Button) findViewById(R.id.btn_tan);
    }

    @Override
    public void onClick(View view) {
        x=1;
        startActivity(new Intent(this, Main_bang.class));
    }
    public void onClick1(View view) {
        x=2;
        startActivity(new Intent(this, Main_bang.class));
    }
    public void onClick2(View view) {
        x=3;
        startActivity(new Intent(this, Main_bang.class));
    }

}