package com.example.demo_a;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    private GameView gameView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Getting display object
        Display display = getWindowManager().getDefaultDisplay();

        //Getting the screen resolution into point object
        Point size = new Point();
        display.getSize(size);
        gameView = new GameView(this, size.x, size.y);

        //adding it to contentview
        setContentView(gameView);
    }
    //tạm dùng trò chơi khi ấn nút dừng
    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    //tiếp tục
    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
}
