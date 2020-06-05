package com.example.btthuoi2.Bai2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.btthuoi2.R;

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
import java.util.concurrent.ExecutionException;

public class bai2 extends AppCompatActivity {
    TextView hienthion;

    String result = "";
//    private Product product;
//    ArrayList<Product> arrayList = new ArrayList();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        hienthion = findViewById(R.id.tv_hienthion);
//        docString();



//         new docJsonobject().execute("http://demo8067763.mockable.io/employee");
      new docJsonobject().execute("http://demo5696361.mockable.io/dd");
    }

        private class docJsonobject extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... strings) {
                StringBuilder builder = new StringBuilder();
                try {
                    URL url = new URL(strings[0]);
                    InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        builder.append(line);
                    }
                    bufferedReader.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return builder.toString();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

////
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray array = object.getJSONArray("danhsach");
//                    Toast.makeText(bai2.this, ""+array.length(), Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject objectname = array.getJSONObject(i);
                        String name = objectname.getString("Name");
                        String career = objectname.getString("Career");
                        String phone = objectname.getString("Phone");
                        result += "hoten:" + name + "\nnghe nghiep:" + career + "\ndien thoai:" + phone;

                    }
                    hienthion.setText(result);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                 //  Toast.makeText(bai2.this,s, Toast.LENGTH_SHORT).show();

            }
        }

    }