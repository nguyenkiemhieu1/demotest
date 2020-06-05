package com.example.th_json;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

public class Main_Account  extends AppCompatActivity {
    TextView txt_account;
    String result=""; String json;
    String dataJson = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        txt_account = (TextView) findViewById(R.id.txt_account);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    json = new ReadJSONData().execute("http://demo8067763.mockable.io/Account").get();
                    JSONArray array =  new JSONArray(json);
                    for(int i = 0;i < array.length(); i++){
                        JSONObject object = array.getJSONObject(i);
                        String Id = object.getString("Id");
                        String Pass = object.getString("Pass");
                        result = Id + "-" + Pass + "\n";
                        dataJson = dataJson + result;
                    }
                    txt_account.setText(dataJson);

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
    private class ReadJSONData extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            return docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
//            txt_account.setText(s);
//            Toast.makeText(Main_Account.this,s,Toast.LENGTH_LONG).show();
            super.onPostExecute(s);

        }
    }
}
