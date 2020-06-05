package com.example.thith.BAI2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thith.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class bai2Activity extends AppCompatActivity {
    String dulieu = "";
    String DataJson;
    ArrayAdapter<student> arrayAdapter;
    TextView tvClass;
    ListView lvClass;
    ArrayList<student> studentList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bai2);
        tvClass = (TextView) findViewById(R.id.tvClass);
        lvClass = (ListView) findViewById(R.id.lvClass);

        studentList = new ArrayList<>();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    DataJson = new MyAsyncTask().execute("http://demo8067763.mockable.io/student1").get();
                    JSONArray jsonArray = new JSONArray(DataJson);
                    for(int i = 0; i < jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String id  = jsonObject.getString("Id");
                        String lop = jsonObject.getString("Lop");
                        int  diem  = jsonObject.getInt("Diem");
                        String ten = jsonObject.getString("Ten");


                        dulieu += "\nId:" + id + "    Lớp:" + lop +"    điểm:" + diem + "      Tên:" + ten;
                        student student1 = new student();
                        student1.setId(id);
                        student1.setLop(lop);
                        student1.setDiem(diem);
                        student1.setTen(ten);
                        studentList.add(student1);
                        arrayAdapter = new ArrayAdapter<student>(bai2Activity.this, android.R.layout.simple_list_item_1, studentList);
                        lvClass.setAdapter(arrayAdapter);

                    }
                    tvClass.setText(dulieu);

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    private  static  String loadJSON(String url){
        StringBuilder content =  new StringBuilder();
        try {
            URL urll = new URL(url);
            URLConnection urlConnection = urll.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");

            }
            bufferedReader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();

    }
    protected  class MyAsyncTask extends  AsyncTask<String , Void, String >{


        @Override
        protected String doInBackground(String... strings) {
            return loadJSON(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
//            tvClass.setText(s);
            super.onPostExecute(s);
        }
    }
}
