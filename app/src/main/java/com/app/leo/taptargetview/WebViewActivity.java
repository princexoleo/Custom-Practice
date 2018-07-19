package com.app.leo.taptargetview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    WebSettings webSettings;
    String Url="https://www.google.com";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView=findViewById(R.id.web_view_id);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(Url);

        webSettings=webView.getSettings();
        if(!webSettings.getJavaScriptEnabled()){
            webSettings.setJavaScriptEnabled(true);
        }



    }
    @Override
    public void onBackPressed() {

        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else {
            super.onBackPressed();
        }

    }
}
