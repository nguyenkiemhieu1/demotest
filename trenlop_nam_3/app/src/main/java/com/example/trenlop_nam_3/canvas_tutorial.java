package com.example.trenlop_nam_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class canvas_tutorial extends AppCompatActivity {
    private example_canvas customCanvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas_tutorial);
        customCanvas = (example_canvas) findViewById(R.id.signature_canvas);
    }
    public void clearCanvas(View v) {
        customCanvas.clearCanvas();
    }
}
