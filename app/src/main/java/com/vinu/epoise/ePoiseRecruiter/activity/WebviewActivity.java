package com.vinu.epoise.ePoiseRecruiter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import com.vinu.epoise.ePoiseRecruiter.R;

/**
 * Created by ePoise on 1/9/2017.
 */

public class WebviewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_webview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        getSupportActionBar().setTitle(R.string.termsAndConditions);

        mWebView=(WebView) findViewById(R.id.webView);

        Intent intent=getIntent();

        final String title =intent.getExtras().getString("pageTitle");
        final String url=intent.getExtras().getString("pageUrl");

        getSupportActionBar().setTitle(title);
        mWebView.loadUrl(url);

    }
}
