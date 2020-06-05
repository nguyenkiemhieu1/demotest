package com.example.trenlop_nam_3;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Main_nhac extends AppCompatActivity implements View.OnClickListener {
    Button startPlaybackButton, stopPlaybackButton, bthavefun;
    Intent playbackServiceIntent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc);
        startPlaybackButton = (Button) this.findViewById(R.id.StartPlaybackButton);
        stopPlaybackButton = (Button) this.findViewById(R.id.StopPlaybackButton);
        bthavefun = (Button)this.findViewById(R.id.btHttp);
        bthavefun.setOnClickListener(this);
        startPlaybackButton.setOnClickListener(this);
        stopPlaybackButton.setOnClickListener(this);
        playbackServiceIntent = new Intent(this,BackgroundAudioService.class);
    }

    public void onClick(View v) {
        if (v == startPlaybackButton) {
            startService(playbackServiceIntent);
            // bindService(playbackServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
        } else if (v == stopPlaybackButton) {
            // unbindService(serviceConnection);
            stopService(playbackServiceIntent);
        } else if (v == bthavefun) {
            try {
                stopService(playbackServiceIntent);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource("http://www.mobvcasting.com/android/audio/goodmorningandroid.mp3");
                //mediaPlayer.setDataSource("https://drive.google.com/file/d/0B45-kAX0Cb24MXFhZWFKdlZiclU/preview");
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                Log.v("AUDIOHTTPPLAYER", e.getMessage());
            }
        }
    }
}
