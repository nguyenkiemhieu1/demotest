package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity   {
    EditText edtMessage, edtPhone;
    Button btnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void sendSMS() {
        try {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("smsto:"));
            i.setType("vnd.android-dir/mms-sms");
            i.putExtra("address", new String(edtPhone.getText().toString()));
            i.putExtra("sms_body",edtMessage.getText().toString());
            startActivity(Intent.createChooser(i, "Send sms via:"));
            startActivity(i);
        }
        catch(Exception e){
            Toast.makeText(MainActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
        }
    }


    private void init() {
        edtMessage=(EditText)findViewById(R.id.edtMessage);
        edtPhone=(EditText)findViewById(R.id.edtPhone);
        btnsend=(Button)findViewById(R.id.btnSend1);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                sendSMS();
//                sendSMSMessage();
                try {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("smsto:"));
                    i.setType("vnd.android-dir/mms-sms");
                    i.putExtra("address", new String(edtPhone.getText().toString()));
                    i.putExtra("sms_body",edtMessage.getText().toString());
                    startActivity(Intent.createChooser(i, "Send sms via:"));
                    startActivity(i);
                }
                catch(Exception e){
                    Toast.makeText(MainActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
