package com.example.theth.examplep3;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import static android.app.Activity.RESULT_OK;

public class TestFragment extends Fragment {

    private TextView txtSpeechInput, txtName;
    private ImageButton btnSpeak;
    ImageView imgAnimal;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    MediaPlayer player;
    private SQLiteDatabase db;
    private final String DATABAE_NAME = "TheWorldOfAnimals.sqlite";
    private ArrayList<Animal> arrayList;
    int id;

    public static TestFragment instance(String type) {
        TestFragment f = new TestFragment();
        Bundle args = new Bundle();
        args.putInt("ID", Integer.parseInt(type));
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        id = getArguments().getInt("ID", -1);

        Log.d("pppppppp", "onCreateView:id " + id);
        txtSpeechInput = (TextView) view.findViewById(R.id.txtSpeechInput);
        txtName = (TextView) view.findViewById(R.id.txtName);
        btnSpeak = (ImageButton) view.findViewById(R.id.btnSpeak);
        imgAnimal = (ImageView) view.findViewById(R.id.imgAnimal);

        arrayList = new ArrayList<>();
        db = DataBase.initDatabase(getActivity(), DATABAE_NAME);
        Cursor cursor;
        if (id != -1) {
            cursor = db.rawQuery("Select * From animals Where id_type='" + id + "'", null);
        } else cursor = db.rawQuery("Select * From animals", null);
//        Log.d("pppppp", "onCreateView: " + cursor.getCount());
        if (cursor.moveToFirst()) {
            do {
                arrayList.add(new Animal(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            } while (cursor.moveToNext());
        }


        loadAnimal();
        // sự kiện cho start speech
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });
        return view;
    }

    private void loadAnimal() {
        if (arrayList.size() > 0) {
            txtSpeechInput.setText("");
            int ran = new Random().nextInt(arrayList.size());
            Animal animal = arrayList.get(ran);
            txtName.setText(animal.getName());

            try {
                InputStream ims = getActivity().getAssets().open(animal.getUrl());
                Bitmap bitmap = BitmapFactory.decodeStream(ims);
                imgAnimal.setImageBitmap(bitmap);
                ims.reset();
                ims.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void check(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_test, null);
        builder.setView(view);
        ImageView imgSmile = (ImageView) view.findViewById(R.id.imgSmile);

        if (player != null) {
            player.stop();
            player.release();
        }
        if (txtName.getText().equals(text)) {
            player = MediaPlayer.create(getActivity(), R.raw.correct);
            player.start();
            imgSmile.setBackgroundResource(R.drawable.sm1);
            //do something...
        } else {
            player = MediaPlayer.create(getActivity(), R.raw.incorrect);
            player.start();
            imgSmile.setBackgroundResource(R.drawable.sm2);
            //do something...
        }
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                loadAnimal();
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    /**
     * Gọi dialog của google speech thông qua Intent
     * Một số action quan trọng trong Intent như
     * ACTION_RECOGNIZE_SPEECH, LANGUAGE_MODEL_FREE_FORM, EXTRA_PROMPT
     */
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getActivity(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Trả lại dữ liệu sau khi nhập giọng nói vào
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtSpeechInput.setText(result.get(0));
                    check(result.get(0));
                }
                break;
            }

        }
    }
}
