package com.example.demo_a;


//Bây giờ là lúc để xây dựng Chế độ xem trò chơi của chúng tôi. Chúng tôi sẽ sử dụng SurfaceView  để xây dựng chế độ xem trò chơi của chúng tôi. Surfaceview cung cấp một bề mặt vẽ chuyên dụng.


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.nio.file.SimpleFileVisitor;
import java.util.ArrayList;

public class GameView extends SurfaceView implements Runnable {

    //    biến boolean để theo dõi nếu trò chơi đang chơi hay không
    volatile boolean playing;

    //chủ đề của game
    private Thread gameThread = null;

    //theem người chơi
    private Player player;

    //khai báo
    private Boom boom;

    //
    //Những đối tượng này sẽ được sử dụng để vẽ
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;

    private ArrayList<Star> stars = new
            ArrayList<Star>();

    private Enemy[] enemies;

    private int enemyCount = 3;

    public GameView(Context context, int screenX, int screenY) {
        super(context);

        //initializing player object
        //this time also passing screen size to player constructor
        player = new Player(context, screenX, screenY);

        //initializing drawing objects
        surfaceHolder = getHolder();
        paint = new Paint();

        //số lượng ngôi sao
        int starNums = 100;
        for (int i = 0; i < starNums; i++) {
            Star s  = new Star(screenX, screenY);
            stars.add(s);
        }

        enemies = new Enemy[enemyCount];
        for(int i=0; i<enemyCount; i++){
            enemies[i] = new Enemy(context, screenX, screenY);
        }
        boom = new Boom(context);
    }

    @Override
    public void run() {
        while (playing) {
            //cập nhật khung
            update();

            //vẽ khung
            draw();

            //điều khiển
            control();
        }

    }


    private void update() {

        //cập nhật vị trí người chơi
        player.update();

        //cài đạt hiệu ứng nổ trên màn hình
        boom.setX(-250);
        boom.setY(-250);
        for (Star s : stars) {
            s.update(player.getSpeed());
        }

        for(int i=0; i<enemyCount; i++){
            enemies[i].update(player.getSpeed());

            //if collision occurrs with player
            if (Rect.intersects(player.getDetectCollision(), enemies[i].getDetectCollision())) {
//                hiển thị nỏ tại vị trí va chạm
                boom.setX(enemies[i].getX());
                boom.setY(enemies[i].getY());

                //moving enemy outside the left edge
                enemies[i].setX(-200);
            }
        }
    }

    private void draw() {
        //kiểm tra vị trí có hợp lệ không
        if (surfaceHolder.getSurface().isValid()) {
            //khóa the canvas
            canvas = surfaceHolder.lockCanvas();
            //vẽ màu cho canvas
            canvas.drawColor(Color.BLACK);
//thêm mầu sắc của ngôi sao
            paint.setColor(Color.WHITE);

            //drawing all stars
            for (Star s : stars) {
                paint.setStrokeWidth(s.getStarWidth());
                canvas.drawPoint(s.getX(), s.getY(), paint);
            }
            //Drawing the player
            canvas.drawBitmap(
                    player.getBitmap(),
                    player.getX(),
                    player.getY(),
                    paint);

            //drawing the enemies
            for (int i = 0; i < enemyCount; i++) {
                canvas.drawBitmap(
                        enemies[i].getBitmap(),
                        enemies[i].getX(),
                        enemies[i].getY(),
                        paint
                );
            }
            //drawing boom image
            canvas.drawBitmap(
                    boom.getBitmap(),
                    boom.getX(),
                    boom.getY(),
                    paint
            );
            //mở the canvas
            surfaceHolder.unlockCanvasAndPost(canvas);

        }
    }

    private void control() {
        try {
            gameThread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        public void pause() {
            //when the game is paused
            //setting the variable to false
            playing = false;
            try {
                //stopping the thread
                gameThread.join();
            } catch (InterruptedException e) {
            }
        }

        public void resume() {
            //when the game is resumed
            //starting the thread again
            playing = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                //khi người dùng chạm vào màn hình
                //we will do something here

                player.setBoosting();
                break;
            case MotionEvent.ACTION_DOWN:
                //khi người dùng dừng chạm vào màn hình
                //do something here
                player.setBoosting();
                break;
        }
        return true;
    }
    }

