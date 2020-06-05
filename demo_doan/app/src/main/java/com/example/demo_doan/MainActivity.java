package com.example.demo_doan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TimePicker simpleTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimePicker simpleTimePicker = (TimePicker)findViewById(R.id.simpleTimePicker);
        simpleTimePicker.setIs24HourView(false);
    }
}
