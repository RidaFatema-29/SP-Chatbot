package com.example.collegeappandchatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Chatbot extends AppCompatActivity {


    WebView web;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        web = findViewById(R.id.web);

        // loading https://www.geeksforgeeks.org url in the WebView.
        web.loadUrl("https://projects.ayaminteractive.com/collage_app_chat_bot/chatbot/");

        // this will enable the javascript.
        web.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        web.setWebViewClient(new WebViewClient());



    }

    @Override
    public void onBackPressed() {
        if( web.canGoBack())
            web.goBack();// if there is previous page open it
        else
            super.onBackPressed();//if there is no previous page, close app
    }

}