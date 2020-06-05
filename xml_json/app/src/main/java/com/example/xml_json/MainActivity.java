package com.example.xml_json;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtv;
    Button btn;

    String datashow = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtv = (TextView) findViewById(R.id.txtv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               domParserXMLtoObject(view);
            }
        });

    }
    private String ReadFile() {
        String text = "";
        try {
            InputStream is = getAssets().open("Employees.xml");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while((line=br.readLine())!=null)
            {
                text+=line;
            }

            Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
            br.close();
        } catch (Exception e) {
            String error = "";
            error = e.getMessage();
        }
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
        return text;
    }
    private ArrayList<model> parseEmployeesXML(){
        ArrayList<model> models = new ArrayList<model>();
        XMLDOMParser parser = new XMLDOMParser();
        try {
            Document document=parser.getDocument(ReadFile());
            NodeList nodeList=document.getElementsByTagName("employee");
            for(int i=0;i<nodeList.getLength();i++){
                Element e=(Element)nodeList.item(i);
                String name=parser.getValue(e,"Name");
                String phone=parser.getValue(e,"Phone");
                String career=parser.getValue(e,"Career");
                model employee=new model(name, phone, career);
                models.add(employee);
                Toast.makeText(MainActivity.this,employee.toString(),Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return models;

    }
    private void domParserXMLtoObject(View v) {
        datashow = "DL doc duoc:\n";
        for (model eob : parseEmployeesXML()) {
            datashow += eob.toString() + ";\n";
        }
        txtv.setText(datashow);

    }
}
