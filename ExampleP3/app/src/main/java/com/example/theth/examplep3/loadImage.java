package com.example.theth.examplep3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by theth on 10/26/2017.
 */

public class loadImage extends AppCompatActivity {
    private GridView gridView;
    private SQLiteDatabase db;
    private final String DATABAE_NAME = "TheWorldOfAnimals.sqlite";
    private ArrayList<Animal> arrayList;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.grid_view);
        arrayList = new ArrayList<>();
        db = DataBase.initDatabase(this, DATABAE_NAME);
        Cursor cursor = db.rawQuery("Select * From animals", null);
        if (cursor.moveToFirst()) {
            do {
                arrayList.add(new Animal(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        GridViewAdapter adapter = new GridViewAdapter(this, arrayList);
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status != TextToSpeech.ERROR) {
                            t1.setLanguage(Locale.ENGLISH);
                            t1.speak(arrayList.get(position).getName(), TextToSpeech.QUEUE_FLUSH, null);
                            Toast.makeText(loadImage.this, "" + arrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}

