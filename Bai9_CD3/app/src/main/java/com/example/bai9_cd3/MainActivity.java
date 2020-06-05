package com.example.bai9_cd3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    String duongdan="https://vnexpress.net/rss/phap-luat.rss";
    ListView listView;
    CustomAdapter customadapter;
    ArrayList<Model> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        modelArrayList = new ArrayList<Model>();
        listView = (ListView)findViewById(R.id.list);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadData().execute(duongdan);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Web_view.class);
                intent.putExtra("link",modelArrayList.get(i).link);
                startActivity(intent);
            }
        });
    }
    class ReadData extends AsyncTask<String , Void, String > {

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            NodeList nodeListdescription = document.getElementsByTagName("description");
            String hinhanh = "";
            String title = "";
            String link = "";
            for (int i = 0; i < nodeList.getLength(); i++) {
                String cdata = nodeListdescription.item(i + 1).getTextContent();
                Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matCher = p.matcher(cdata);
                if (matCher.find()) {
                    hinhanh = matCher.group(1);
                }
                Element element = (Element) nodeList.item(i);
                title = parser.getValue(element, "title");
                link = parser.getValue(element, "link");
                modelArrayList.add(new Model());

            }
            customadapter = new CustomAdapter(MainActivity.this, android.R.layout.simple_list_item_1, modelArrayList);
            listView.setAdapter(customadapter);
            super.onPostExecute(s);
        }
    }
    private  static  String HienthiND(String URL){
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(URL);
            URLConnection urlConnection = url.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
