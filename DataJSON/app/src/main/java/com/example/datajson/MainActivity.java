package com.example.datajson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String JSONEmployees = "[\n" +
            "{\n"
            + "\"Name\": \"Nguyen Hoang Diep\",\n"
            + "\"Career\": \"Teacher\",\n"
            + "\"Phone\": \"0923848008\"\n"
            + "},\n"
            + " {\n"
            + " \"Name\": \"Nguyen Văn Hậu\",\n"
            + " \"Career\": \"Teacher\",\n"
            + " \"Phone\": \"0944000000\"\n"
            + "},\n"
            + "{\n"
            + "\"Name\": \"Nguyen Thị Hải Năng\",\n"
            + " \"Career\": \"Teacher\",\n"
            + " \"Phone\": \"\"\n"
            + "},\n"
            + "{\n"
            + " \"Name\": \"Chu Bá Thông\",\n"
            + " \"Career\": \"Actor\",\n"
            + " \"Phone\": \"00000000\"\n"
            + "},\n"
            + "{\n"
            + " \"Name\": \"Chu Bá Minh Thông\",\n"
            + " \"Career\": \"pupil\",\n"
            + " \"Phone\": \"\"\n"
            + "}\n"
            + "]";
    String JSONEmployee = "{\"Name\": \"Nguyen Hoang Diep\",\n" +
            " \"Career\": \"Teacher\",\n" +
            " \"Phone\": \"0923848008\"\n}";
    String JsonData = "[\n" +
            " {\n" +
            " \"Name\": \"Nguyen Văn Sáng\",\n" +
            " \"NamSinh\": 1996,\n" +
            " \"Mark\": 6.5\n" +
            " },\n" +
            " {\n" +
            " \"Name\": \"Nguyen Văn Hậu\",\n" +
            " \"NamSinh\": 1996,\n" +
            " \"Mark\": 9.0\n" +
            " },\n" +
            " {\n" +
            " \"Name\": \"Nguyen Thị hải Năng\",\n" +
            " \"NamSinh\": 1984,\n" +
            " \"Mark\": 9.5\n" +
            " }\n" +
            "]";

    String jsonProduct = "{\"Id\":101141,\"Name\":\"Book\",\"Price\":20000}";

    TextView txt,txtv;
    Button btn;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txt);
        txtv = (TextView) findViewById(R.id.txtv);
        btn = (Button) findViewById(R.id.btn);
        onClick();
    }

    private void onClick() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    JSONArray array = new JSONArray(JSONEmployees);
                    for(int i = 0; i<array.length(); i++){
                        JSONObject object = array.getJSONObject(i);
                        String Name = object.getString("Name");
                        String Career = object.getString("Career");
                        String Phone = object.getString("Phone");
//                    demo demo = new demo(Name, Career, Phone);

//                        int Id = object.getInt("Id");
//                        String name = object.getString("Name");
//                        int Price = object.getInt("Price");


//                    Toast.makeText(MainActivity.this, Name + Career +Phone, Toast.LENGTH_LONG).show();
                        a +=Name + Career +Phone;
//                    txtv.setText(a);
//                        txtv.setText(Id + name + Price);
                    }
                    txtv.setText(a);
                    

              
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
