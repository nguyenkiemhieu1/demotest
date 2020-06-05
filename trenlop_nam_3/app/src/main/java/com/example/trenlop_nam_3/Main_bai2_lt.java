package com.example.trenlop_nam_3;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.OutputStream;

public class Main_bai2_lt  extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener{
    ImageView img;
    Button btLoad, btSave, btColor;
    Paint p;
    Bitmap bm;
    Canvas cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2_lt);

        img = findViewById(R.id.img_Test);
        btLoad = findViewById(R.id.bt_Load);
        btColor = findViewById(R.id.bt_Paint);
        btSave = findViewById(R.id.bt_Save);

        p = new Paint();
        p.setColor(Color.BLACK);
        p.setAntiAlias(true);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(10);

        btLoad.setOnClickListener(this);
        btSave.setOnClickListener(this);
        btColor.setOnClickListener(this);
        img.setOnTouchListener(this);

    }
    final int REQUEST_CHOOSE_PHOTO = 321;

    private void choosePhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CHOOSE_PHOTO);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CHOOSE_PHOTO) {
                try {
                    Uri imageUri = data.getData();
                    InputStream is = getContentResolver().openInputStream(imageUri);

                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inMutable = true;
                    options.inDensity = 1;
                    options.inScaled = true;
                    Bitmap bitmap = BitmapFactory.decodeStream(is, null, options);
                    bm = Fit_screen(bitmap);
                    cv = new Canvas(bm);
                    img.setImageBitmap(bm);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void Save_img(Bitmap bm) {
        Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        try {
            OutputStream out = getContentResolver().openOutputStream(uri);
            bm.compress(Bitmap.CompressFormat.PNG, 100, out);
            Toast.makeText(this, "Saved!!!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int i = 0;

    public void SwitchColor() {
        i++;
        int id = i % 3;
        switch (id) {
            case 1:
                btColor.setText("Red");
                p.setColor(Color.RED);
                break;
            case 2:
                btColor.setText("Blue");
                p.setColor(Color.BLUE);
                break;
            case 3:
                btColor.setText("Green");
                p.setColor(Color.GREEN);
                break;
            case 0:
                btColor.setText("Black");
                p.setColor(Color.BLACK);
                break;
        }
    }

    private Bitmap Fit_screen(Bitmap bm) {
        int maxH = 2000;
        int maxW = 1240;
        float scale = Math.min((float) maxH / bm.getHeight(), (float) maxW / bm.getWidth());
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        return Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);
    }

    private Bitmap Scale(Bitmap bm, float scale) {
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        Toast.makeText(this, "Có th?y to lên " + scale + " l?n k?", Toast.LENGTH_SHORT).show();
        return Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);
    }

    private Bitmap rolling(Bitmap bm, float angle) {
        Matrix matrix = new Matrix();
        matrix.setRotate(angle);
        return Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.bt_Load:
                choosePhoto();
                break;
            case R.id.bt_Save:
                Save_img(bm);
                break;
            case R.id.bt_Paint:
                SwitchColor();
                break;
        }
    }

    float x1, x2, y1, y2;
    float x3, x4, y3, y4;
    // V? v?n d? xoay b?ng multi-touch...(Theo tôi nghi)
    // Theo lý lu?n thì khi ta xoay, 2 ngón tay 1 ngón làm tr?c và ngón còn l?i v? ra 1 cung tròn(tru?ng h?p lý tu?ng)
    // Khi dó qua 3 di?m: A(l?y ngay t?i tr?c quay), B(di?m b?t d?u c?a cung tròn), C(k?t thúc cung tròn) ta có th? v? dc 1 hình tam giác cân
    // Qua tam giác cân v?a xác d?nh, ta ph?i tính dc góc BAC d? áp d?ng vào phuong th?c rolling(Bitmap bmp, float angle)
    // Ð?u tiên ta xác d?nh trung di?m c?a BC t?m g?i là M((xB+xC)/2, (yB+yC)/2)
    // Sau dó ta có th? tính du?c chi?u dài c?a do?n AB và BM b?ng công th?c. VD: AB = Math.sqrt(Math.pow(xB-xA,2) + Math.pow(-yB+yA,2))(d?o ngu?c d?u ? tính y vì y tang d?n theo chi?u di xu?ng)
    // Ti?p d?n ta tính arcSin(BAM) = BM/AB --> Hình nhu s? ra kq trong kho?ng -pi/2 d?n pi/2
    // N?u ra kq nhu trên thì có l? ta ph?i d?i ra d? --> kq = kq/3.14*180;
    // Sau dó th? áp d?ng vào code xem tn....
    // Vì ch? là gi? thi?t nên c?n ae code ch?ng minh th?, tôi lu?i r?i.

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int act = event.getAction();
        int c = event.getPointerCount();
        switch (act) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX(0);
                y1 = event.getY(0);
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                x3 = event.getX(1);
                y3 = event.getY(1);
                break;
            case MotionEvent.ACTION_POINTER_UP:
                x2 = event.getX(0);
                y2 = event.getY(0);
                x4 = event.getX(1);
                y4 = event.getY(1);
                double scale = Math.sqrt(Math.pow(x4 - x2, 2) + Math.pow(-y4 + y2, 2)) / Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(-y3 + y1, 2));
                bm = Scale(bm, (float) scale);
                img.setImageBitmap(bm);
                img.invalidate();
                break;
        }
        return true;
    }
}
