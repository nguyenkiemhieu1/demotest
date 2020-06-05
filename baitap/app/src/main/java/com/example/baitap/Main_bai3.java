package com.example.baitap;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main_bai3 extends AppCompatActivity  implements Animation.AnimationListener{
    Animation animation;

    ImageView imghinh;
    Button btnin , btnout, btnmove, btnsa, btnrotate, btnblink;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        ax();
        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation= (Animation) AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
               imghinh.setAnimation(animation);
               animation.start();
            }
        });
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation= (Animation) AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeout);
                imghinh.setAnimation(animation);
                animation.start();
            }
        });
        btnmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation= (Animation) AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                imghinh.setAnimation(animation);
                animation.start();
            }
        });
        btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation= (Animation) AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                imghinh.setAnimation(animation);
                animation.start();
            }
        });
        btnblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               animation= (Animation) AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
                imghinh.setAnimation(animation);
                animation.start();
            }
        });
        btnsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 animation= (Animation) AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sequential_animation);
                imghinh.setAnimation(animation);
                animation.start();
            }
        });

    }

    private void ax() {
        imghinh=(ImageView)findViewById(R.id.imghinh);
        btnin=(Button)findViewById(R.id.btnin);
        btnout=(Button)findViewById(R.id.btnout);
        btnmove=(Button)findViewById(R.id.btnmove);
        btnsa=(Button)findViewById(R.id.btnsa);
        btnrotate=(Button)findViewById(R.id.btnrotate);
        btnblink=(Button)findViewById(R.id.btnblink);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(getApplicationContext(), "Animation Stopped", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
