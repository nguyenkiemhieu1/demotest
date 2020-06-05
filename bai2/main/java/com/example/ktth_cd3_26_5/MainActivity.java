package com.example.ktth_cd3_26_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
EditText editText;
Button loaddata,loadclass,loadproduct;
static int kt = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a();
        eventclick();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new readtextfile().execute("http://demo8067763.mockable.io/Student");
            }
        });
//        loadclass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                kt = 1;
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        new readtextfile().execute("http://demo8067763.mockable.io/student1");
//                    }
//                });
//            }
//        });
//        loadproduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                kt = 2;
//
//            }
//        });


//        loaddata();
    }

    private void eventclick() {


    }

    Adapterclass adapterclass;
    Adapterproduct adapterproduct;
    ArrayList<dtclass> arrayList;
    ArrayList<dtproduct> arrayList1;
    private void a() {
        loaddata = findViewById(R.id.btload);
        loadclass = findViewById(R.id.btclass);
        loadproduct = findViewById(R.id.btproduct);
        arrayList = new ArrayList<>();
        arrayList1 = new ArrayList<>();
        listView = findViewById(R.id.lvclass);
        editText = findViewById(R.id.tvclass);

//        adapterclass=new Adapterclass(this,arrayList);
        adapterproduct=new Adapterproduct(this,arrayList1);
        listView.setAdapter(adapterproduct);
//        switch (kt){
//            case 1: listView.setAdapter(adapterclass);break;
//            case 2: listView.setAdapter(adapterproduct);break;
//            default:break;
//        }


    }
    private void loaddata(){
        String chuoi2="";
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject ;
//        int id= 0,lop = 0,diem = 0;
//        String ten = "";
//        switch (kt){
//            case 1:for (int i = 0; i < jsonArray.length(); i++) {
//                try {
//                    jsonObject = jsonArray.getJSONObject(i);
//                    id = jsonObject.getInt("Id");
//                    lop = jsonObject.getInt("Lop");
//                    diem = jsonObject.getInt("Diem");
//                    ten = jsonObject.getString("Ten");
//                    arrayList.add(new dtclass(id,lop,diem,ten));
//                    adapterclass.notifyDataSetChanged();
//                    chuoi2 += "Mã lớp" + "\t" + "\t" + "\t" + "\t" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t" + id + "\t" + "\t" + "\t" + "\t" + "\t"  + "\n"
//                            +"Tên lớp" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t"+ "\t"+ "\t" + "\t" + "\t" + "\t" + "\t" + lop + "\t" + "\t" + "\t" + "\t" + "\t"  + "\n"+ "\n" ;
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }break;
//            case 2:
                String Name = "";
                int Price = 0;
                ArrayList<String> Sizes = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    jsonObject = jsonArray.getJSONObject(i);
                    Name = jsonObject.getString("Name");
                    Price = jsonObject.getInt("Price");
                    JSONArray jsonArraysize = jsonObject.getJSONArray("Sizes");
//                    for (int j = 0; j < jsonArraysize.length(); j++) {
                        Sizes.add(jsonArraysize.get(i).toString());
//                    }
                    arrayList1.add(new dtproduct(Name,Price,Sizes));
                    adapterproduct.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
//            case 3:for (int i = 0; i < jsonArray.length(); i++) {
//                try {
//                    jsonObject = jsonArray.getJSONObject(i);
//                    id = jsonObject.getInt("Id");
//                    lop = jsonObject.getInt("Lop");
//                    diem = jsonObject.getInt("Diem");
//                    ten = jsonObject.getString("Ten");
//                    arrayList.add(new dtclass(id,lop,diem,ten));
//                    adapterclass.notifyDataSetChanged();
//                    chuoi2 += "Mã lớp" + "\t" + "\t" + "\t" + "\t" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t" + id + "\t" + "\t" + "\t" + "\t" + "\t"  + "\n"
//                            +"Tên lớp" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t"+ "\t"+ "\t" + "\t" + "\t" + "\t" + "\t" + lop + "\t" + "\t" + "\t" + "\t" + "\t"  + "\n"+ "\n" ;
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }break;
//            default:break;
//        }

//        textView.setText(chuoi2);
    }

    String json;
    JSONArray jsonArray;
    public class readtextfile extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            String result = "";
            try {
                URL url = new URL(params[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line = null;
                while ((line = in.readLine()) != null) {
                    //get lines
                    result += line;
                }
                in.close();


            } catch (MalformedURLException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
            json = result;
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            json = s;
            loaddata();
//            String chuoi2="";
//            json = s;
//            try {
//                jsonArray = new JSONArray(json);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            JSONObject jsonObject ;
//            int id= 0,lop = 0,diem = 0;
//            String ten = "";
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                    try {
//                        jsonObject = jsonArray.getJSONObject(i);
//                        id = jsonObject.getInt("Id");
//                        lop = jsonObject.getInt("Lop");
//                        diem = jsonObject.getInt("Diem");
//                        ten = jsonObject.getString("Ten");
//                        arrayList.add(new dtclass(id,lop,diem,ten));
//                        adapterclass.notifyDataSetChanged();
//                        chuoi2 += "Mã lớp" + "\t" + "\t" + "\t" + "\t" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t" + id + "\t" + "\t" + "\t" + "\t" + "\t"  + "\n"
//                                +"Tên lớp" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t"+ "\t"+ "\t" + "\t" + "\t" + "\t" + "\t" + lop + "\t" + "\t" + "\t" + "\t" + "\t"  + "\n"+ "\n" ;
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            textView.setText(chuoi2);


//            int malop = -1;
//            String tenlop = "";
//            int Id = -1;
//            String Name="";
//            double Mark = -1;
//            switch (kt){
//                case 1:for (int i = 0; i < jsonArray2.length(); i++) {
//                    try {
//                        jsonObject2 = jsonArray2.getJSONObject(i);
//                        malop = jsonObject2.getInt("malop");
//                        tenlop = jsonObject2.getString("tenlop");
//                        arrayListclass.add(new dtclass(malop,tenlop));
//                        chuoi2 += "Mã lớp" + "\t" + "\t" + "\t" + "\t" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t" + malop + "\t" + "\t" + "\t" + "\t" + "\t"  + "\n"
//                                +"Tên lớp" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t"+ "\t"+ "\t" + "\t" + "\t" + "\t" + "\t" + tenlop + "\t" + "\t" + "\t" + "\t" + "\t"  + "\n"+ "\n" ;
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }break;
//
//                case 2:for (int i = 0; i < jsonArray2.length(); i++) {
//                    try {
//                        jsonObject2 = jsonArray2.getJSONObject(i);
//                        Id = jsonObject2.getInt("Id");
//                        Name = jsonObject2.getString("Name");
//                        Mark = jsonObject2.getDouble("Mark");
//                        arrayListclass.add(new dtclass(malop,tenlop));
//                        chuoi2 += "Id" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t" + Id + "\t" + "\t" + "\t" + "\t" + "\t"  + "\n"
//                                +"Name" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t"+ "\t"+ "\t" + "\t" + "\t" + "\t" + "\t" + Name + "\t" + "\t" + "\t" + "\t" + "\t"  + "\n"+
//                                "Mark" + "\t"+ "\t" + "\t" + "\t" + "\t" + "\t"+ "\t"+ "\t" + "\t" + "\t" + "\t" + "\t" + Mark + "\t" + "\t" + "\t" + "\t" + "\t"  + "\n"+ "\n" ;
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }break;
//                default: break;
//            }
//
//
//            textView.setText(chuoi2);
            super.onPostExecute(s);
        }
    }
}
