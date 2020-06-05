package com.example.th_json;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

public class Main_Student extends AppCompatActivity {
    TextView text;
    String result=""; String json;
    String dataJson = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        text = (TextView) findViewById(R.id.txt_student) ;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    json = new ReadJSONdata().execute("http://demo8067763.mockable.io/Student").get();
                    JSONArray array =  new JSONArray(json);
                    for(int i = 0;i < array.length(); i++){
                        JSONObject object = array.getJSONObject(i);

                        String Name = object.getString("Name");
                        int Year = object.getInt("Year");
                        int Mark = object.getInt("Mark");
                        result = Name + "-" + Year + "-" + Mark +"\n";
                        dataJson = dataJson + result;
                    }
                    text.setText(dataJson);

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
    private static String docNoiDung_Tu_URL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(theUrl);

            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) { e.printStackTrace(); }
        return content.toString();
    }
    private class ReadJSONdata extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... strings) {
            return docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
//            textView.setText(s);
            Toast.makeText(Main_Student.this,s,Toast.LENGTH_LONG).show();
            super.onPostExecute(s);

        }
    }
}


