package com.example.btth.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.btth.R;

public class Main_baitap1 extends AppCompatActivity {
    private WebView webView;
    private Button btnLesson1a,btnLesson1b;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baitap1);
        init();
        setupWebView();

        btnLesson1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lesson1a();
            }
        });
        btnLesson1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lesson1b();
            }
        });
    }

    private void init(){
        webView = findViewById(R.id.mWebView);
        btnLesson1a = findViewById(R.id.btnLesson1a);
        btnLesson1b = findViewById(R.id.btnLesson1b);
    }

    private void setupWebView(){
        //hiện thanh cuộn trong webView
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        //bật tắt tốc độ phần cứng
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        //vô hiệu hóa bộ nhớ cache (nếu bạn có vấn đề với nội dung của bạn):
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setLoadsImagesAutomatically(true);
        webView.loadUrl("https://www.google.com/");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    private void lesson1a(){
        webView.loadUrl("file:///android_asset/demo.html");
    }

    private void lesson1b(){
        webView.loadUrl("file:///android_asset/link.html");
    }
}
