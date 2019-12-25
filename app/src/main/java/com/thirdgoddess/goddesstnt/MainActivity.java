package com.thirdgoddess.goddesstnt;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

import com.thirdgoddess.tnt.webview.Web;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Web web = new Web(webView);
        web.setJs();
        web.loadUrl("https://xxxxxxvvvvvv.com");
        web.setOnLoadListener(new Web.OnLoadListener() {
            @Override
            public void onStart(WebView view, String url, Bitmap favicon) {
                Log.d("mylog-web", "onStart");
            }

            @Override
            public void onFinish(WebView view, String url) {
                Log.d("mylog-web", "onFinish");
            }

            @Override
            public void urlLoading(WebView view, String url) {
                Log.d("mylog-web", "urlLoading");
            }

            @Override
            public void urlLoadError(WebView view, WebResourceRequest request, WebResourceError error) {
                Log.d("mylog-web", "error");
            }
        });

    }


    private void initView() {
        webView = (WebView) findViewById(R.id.webView);
    }


}
