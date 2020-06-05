package com.example.demo_a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Boom {
    //bitmap object
    private Bitmap bitmap;

    //coordinate variables
    private int x;
    private int y;
    public Boom(Context context) {
        //getting boom image from drawable resource
        bitmap = BitmapFactory.decodeResource
                (context.getResources(), R.drawable.boom);

// thiết lập giới hạn của màn hình , đòng thời k hiển thị lên màn hình, sẽ hiển thị lên khi có sự va chạm

        x = -250;
        y = -250;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
