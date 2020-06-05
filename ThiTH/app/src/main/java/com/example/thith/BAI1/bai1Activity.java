package com.example.thith.BAI1;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thith.R;

public class bai1Activity extends AppCompatActivity {
    private Button btnGo;
    private WebView vw;
    private EditText edtURL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bai1);
        btnGo = (Button)findViewById(R.id.btnGo);
        edtURL = (EditText)findViewById(R.id.edtURL);
        vw = (WebView) findViewById(R.id.vw);

        vw.setWebViewClient(new MyWebViewClient(edtURL));
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadData();
            }


        });


    }
    private  void LoadData(){
        if(!edtURL.getText().toString().contains("https")||!edtURL.getText().toString().contains("http")){
            Toast.makeText(bai1Activity.this, "Chưa có http", Toast.LENGTH_SHORT).show();
            edtURL.setText("https://www." + edtURL.getText());
            vw.getSettings().setJavaScriptEnabled(true);
            vw.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        }

        vw.loadUrl(edtURL.getText().toString());
    }



    public class MyWebViewClient extends WebViewClient {
        private  EditText editText;

        public MyWebViewClient(EditText editText) {
            this.editText = editText;
        }
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            editText.setText(url);
            return super.shouldOverrideUrlLoading(view, url);
        }



    }

}
