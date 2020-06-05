package com.example.trenlop_nam_3;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.io.IOException;

public class Main_baiTH2_bai1 extends AppCompatActivity {
    ImageView imgbai2;
    Animation animation;
    int[] imgsID;
    int[] animsID;
    int tt;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baith2_bai2);
        try {
            mediaPlayer.reset();
            mediaPlayer.setDataSource("R.raw.abc.mp3");
            mediaPlayer.prepare();
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        imgbai2 = (ImageView) findViewById(R.id.imgbai2);
        imgsID = new int[]{R.drawable.abc, R.drawable.abcc, R.drawable.abcd, R.drawable.abcde, R.drawable.abcba};
        animsID = new int[]{R.anim.blink, R.anim.fadein, R.anim.fadeout, R.anim.move, R.anim.rotate, R.anim.sequential_animation};
        tt = 0;
        imgbai2.setRotation(-6);
        LoadAnh_Animation();


    }

    private void LoadAnh_Animation() {
        // if (tt>= imgsID.length) tt=0;
        animation = AnimationUtils.loadAnimation(getApplicationContext(), animsID[tt % animsID.length]);
        System.out.println(tt);
        imgbai2.setImageResource(imgsID[tt % imgsID.length]);
        imgbai2.startAnimation(animation);

        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                System.out.println("start" + tt);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                System.out.println("loop");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                System.out.println("end" + tt);
                LoadAnh_Animation();
            }
        });
        tt++;


    }
}
