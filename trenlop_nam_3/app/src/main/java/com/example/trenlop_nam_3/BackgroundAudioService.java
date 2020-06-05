package com.example.trenlop_nam_3;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BackgroundAudioService  extends Service implements MediaPlayer.OnCompletionListener
{
    MediaPlayer mediaPlayer;
    public class BackgroundAudioServiceBinder extends Binder {
        BackgroundAudioService getService() {
            return BackgroundAudioService.this;
        }
    }

    private final IBinder basBinder = new BackgroundAudioServiceBinder();
    //And override the implementation of onBindto return that.
    @Override
    public IBinder onBind(Intent intent) {
// Return the BackgroundAudioServiceBinder object
        return basBinder;
    }

    @Override
    public void onCreate() {
        Log.v("PLAYERSERVICE","onCreate");
        mediaPlayer = MediaPlayer.create(this, R.raw.quocva);
        mediaPlayer.setOnCompletionListener(this);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.v("PLAYERSERVICE","onStartCommand");
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
        return START_STICKY;
    }
    public void onDestroy() {
        if (mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
        }
        mediaPlayer.release();
        Log.v("SIMPLESERVICE","onDestroy");
    }
    public void onCompletion(MediaPlayer _mediaPlayer) {
        stopSelf();
    }
}

