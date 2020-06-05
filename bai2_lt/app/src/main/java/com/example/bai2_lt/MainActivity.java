package com.example.bai2_lt;

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
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.democlassroom.R;
import com.github.chrisbanes.photoview.PhotoView;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private Button btnOpenImg, btnRotate, btnDraw,btnDisableDraw,btnSave;
    private PhotoView imageView;
    private static int RESULT_LOAD_IMG = 1;
    float downx = 0;
    float upx = 0;
    float downy = 0;
    float upy = 0;
    Bitmap bitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        onClick();
    }

    private void onClick(){
        btnOpenImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setRotation(imageView.getRotation() + 90);
            }
        });

        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        int action = motionEvent.getAction();
                        switch (action) {
                            case MotionEvent.ACTION_DOWN:
                                downx = motionEvent.getX();
                                downy = motionEvent.getY();
                                break;
                            case MotionEvent.ACTION_MOVE:
                                upx = motionEvent.getX();
                                upy = motionEvent.getY();
                                bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
                                Canvas canvas = new Canvas(bitmap);
                                imageView.draw(canvas);
                                Paint paint = new Paint();
                                paint.setColor(Color.RED);
                                canvas.drawLine(downx, downy, upx, upy, paint);
                                imageView.invalidate();
                                downx = upx;
                                downy = upy;
                                imageView.setImageBitmap(bitmap);
                                break;
                            case MotionEvent.ACTION_UP:
                                break;
                            case MotionEvent.ACTION_CANCEL:
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
            }
        });

        btnDisableDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        int action = motionEvent.getAction();
                        return true;
                    }
                });
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri imageFileUri = getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
                try {
                    OutputStream imageFileOS = getContentResolver().openOutputStream(imageFileUri);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, imageFileOS);
                    Toast.makeText(ThaoTacAnh.this, "Luu thành công", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void init() {
        btnOpenImg = (Button) findViewById(R.id.bt_moAnh);
        btnRotate = (Button) findViewById(R.id.xoay);
        imageView = (PhotoView) findViewById(R.id.photo_view);
        btnDraw = (Button) findViewById(R.id.draw);
        btnDisableDraw = (Button) findViewById(R.id.tatVe);
        btnSave = (Button) findViewById(R.id.save);
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final Matrix matrix = new Matrix();
                matrix.setRotate(90);
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                //Bitmap bitmap = Bitmap.createBitmap(1000, 1000, Bitmap.Config.ARGB_8888);
                final Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
                //Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(),matrix,true);
                imageView.setImageBitmap(bitmap);
                imageView.invalidate();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Ðã x?y ra l?i", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "B?n chua ch?n hình ?nh", Toast.LENGTH_LONG).show();
        }
    }

}
