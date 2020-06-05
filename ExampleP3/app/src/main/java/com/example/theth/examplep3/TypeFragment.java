package com.example.theth.examplep3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class TypeFragment extends Fragment {
    private GridView gridView;
    private SQLiteDatabase db;
    private final String DATABAE_NAME = "TheWorldOfAnimals.sqlite";
    private ArrayList<Type> arrayList;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_type, container, false);
        gridView = (GridView) view.findViewById(R.id.grid_view);
        arrayList = new ArrayList<>();
        db = DataBase.initDatabase(getActivity(), DATABAE_NAME);
        Cursor cursor = db.rawQuery("Select * From type_of_animals", null);
        if (cursor.moveToFirst()) {
            do {
                arrayList.add(new Type(cursor.getString(0), cursor.getString(1)));
            } while (cursor.moveToNext());
        }

        TypeAdapter adapter = new TypeAdapter(getActivity(), R.layout.item_animal, arrayList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), AnimalsActivity.class);
                intent.putExtra("ID", arrayList.get(position).getId());
                intent.putExtra("Name", arrayList.get(position).getName());
                getActivity().startActivity(intent);
            }
        });
        return view;
    }
}
