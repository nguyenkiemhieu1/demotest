package com.example.trenlop_nam_3;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.io.IOException;

public class animation extends AppCompatActivity {
    ImageView img;
    Animation animation;
    int[] imgsID;
    int [] animsID;
    int tt; // Thu tu anh

    private MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        img=(ImageView)findViewById(R.id.img1);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abc);
            img.startAnimation(animation);
        mp.reset();

    }
}
