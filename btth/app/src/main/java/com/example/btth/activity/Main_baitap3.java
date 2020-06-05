package com.example.btth.activity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.btth.R;

public class Main_baitap3 extends AppCompatActivity {
    private WebView webView;
    private Button btnDelete, btnStatic, btnGo;
    private EditText edUrl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baitap3);
        init();
        handle();
    }

    private void handle() {
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
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edUrl.getText().toString())) {
                    Toast.makeText(Main_baitap3.this, "Bạn chưa nhập link, mời bạn nhập link!", Toast.LENGTH_SHORT).show();
                } else if (!edUrl.getText().toString().contains("http") || !edUrl.getText().toString().contains("https")) {
                    Toast.makeText(Main_baitap3.this, "Nhập sai link", Toast.LENGTH_SHORT).show();
                } else {
                    webView.loadUrl(edUrl.getText().toString());
                }
            }
        });
        btnStatic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("file:///android_asset/demo_practice3.html");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edUrl.setText("");
            }
        });
    }

    private void init() {
        webView = findViewById(R.id.webview);
        btnDelete = findViewById(R.id.btnDelete);
        btnStatic = findViewById(R.id.btnStatic);
        btnGo = findViewById(R.id.btnGo);
        edUrl = findViewById(R.id.edUrl);
    }
}
