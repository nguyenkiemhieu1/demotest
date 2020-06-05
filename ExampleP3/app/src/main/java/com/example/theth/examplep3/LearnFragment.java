package com.example.theth.examplep3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by theth on 10/26/2017.
 */

public class LearnFragment extends Fragment {
    private GridView gridView;
    private SQLiteDatabase db;
    private final String DATABAE_NAME = "TheWorldOfAnimals.sqlite";
    private ArrayList<Animal> arrayList;
    TextToSpeech t1;
    int id;

    public static LearnFragment instance(String type) {
        LearnFragment f = new LearnFragment();
        Bundle args = new Bundle();
        args.putInt("ID", Integer.parseInt(type));
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn, container, false);
        id = getArguments().getInt("ID", 1);
        gridView = (GridView) view.findViewById(R.id.grid_view);
        arrayList = new ArrayList<>();
        db = DataBase.initDatabase(getActivity(), DATABAE_NAME);
        Cursor cursor = db.rawQuery("Select * From animals where id_type='" + id + "'", null);
        if (cursor.moveToFirst()) {
            do {
                arrayList.add(new Animal(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }
        AnimalAdapter animalAdapter = new AnimalAdapter(getActivity(), R.layout.item_animal, arrayList);
        gridView.setAdapter(animalAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                t1 = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status != TextToSpeech.ERROR) {
                            t1.setLanguage(Locale.ENGLISH);
                            t1.speak(arrayList.get(position).getName(), TextToSpeech.QUEUE_FLUSH, null);
                            Toast.makeText(getActivity(), "" + arrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        return view;
    }

}

