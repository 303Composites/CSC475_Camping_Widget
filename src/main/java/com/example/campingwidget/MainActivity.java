package com.example.campingwidget;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    //Creating a webview to access the internet site see AndroidManifest.xml for permissions
    private WebView myWebView;

    @Override
    //Main user interface in the user app, connects to the internet and goes direct to a testing forum
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://form.jotform.com/53551151852957");
        myWebView.setWebViewClient(new WebViewClient());
    }
    //Used in the main app without the widget to get back to the main window
    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}