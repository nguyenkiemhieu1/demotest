package com.example.bai9_cd3;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Web_view extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
        wv = (WebView)findViewById(R.id.wv);
        Intent intent = getIntent();
         String link = intent.getStringExtra("link");
         wv.loadUrl(link);
         wv.setWebViewClient(new WebViewClient());
    }
}
