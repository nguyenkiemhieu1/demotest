package com.example.btthuoi2.Bai1;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.btthuoi2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bai1 extends AppCompatActivity {

    TextView txtv;
    Button btn;
    String a;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        txtv = (TextView) findViewById(R.id.txtv);
        btn = (Button) findViewById(R.id.btn);


    }
}
