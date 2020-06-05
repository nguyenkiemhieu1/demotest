package com.example.bt_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private  Button btnload;
    private  WebView webView;
    private  EditText edturl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnload = (Button)findViewById(R.id.btnload);
        edturl = (EditText)findViewById(R.id.edturl);
        webView = (WebView) findViewById(R.id.ebview);

        webView.setWebViewClient(new MyWebViewClient(edturl));
        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hienthi();
            }


        });


    }
    private  void hienthi(){

        String url = "https://" + edturl.getText().toString().trim();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
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
