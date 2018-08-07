package com.example.bohdan.gurdianapp;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClientImpl extends WebViewClient {

    private Activity activity = null;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }

    /* @Override
     public boolean shouldOverrideUrlLoading(WebView webView, String url) {
         //if(url.indexOf(url) > -1 ) return false;
         if (url.startsWith("http:") || url.startsWith("https:"))
             return false;

             Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
             activity.startActivity(intent);
             return true;
         }*/
    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        view.loadUrl(request.getUrl().toString());
        return true;
    }
}

