package com.example.trenlop_nam_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class amimation extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_dohoa2d);
        img=(ImageView)findViewById(R.id.img1);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abc);
        img.startAnimation(animation);
    }
}
