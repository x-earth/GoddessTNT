package com.thirdgoddess.goddesstnt;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.thirdgoddess.tnt.webview.Web;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("AddJavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //初始化（支持加载框）
        Web web = new Web(this, webView);

        //不支持加载框
        //Web web = new Web(webView);

        //支持Js
        web.setJs();

        //开启屏幕自适应
        //web.setAdapt();

        //开启并支持缩放
        //web.setZoom();

        //允许访问文件
        //web.setAccessFiles();

        //支持Js打开新窗口
        //web.setJsOpenWindows();

        //设置位UTF-8编码格式
        //web.setUTF8();

        //设置支持自动加载图片
        //web.setAutoLoadImage();

        //可以取消当前WebView长按选择文字
        //web.setNoSelectionText();

        //开启加载框
        //web.setLoadDialog();

        //加载模式（是否缓存、优先使用缓存、使用网络等可以在这里设置）
        web.setLoadModle(Web.LOAD_CACHE_ELSE_NETWORK);

        //是否保持本页跳转
        //web.setKeepView(true);

        //开始加载、加载完成、跳转监听
        web.setOnLoadListener(new Web.OnLoadListener() {
            @Override
            public void onStart(WebView view, String url, Bitmap favicon) {
                Log.d("mylog-start", "start");
            }

            @Override
            public void onFinish(WebView view, String url) {
                Log.d("mylog-finish", "finish");
            }

            @Override
            public void urlLoading(WebView view, String url) {
                Log.d("mylog-loading", "loading");
            }
        });

        //进度监听
        web.setProgressListener(new Web.OnProgressListener() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Log.d("mylog-Changed", newProgress + "");
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                Log.d("mylog-ReceivedTitle", title);
            }
        });

        //加载地址
        web.loadUrl("https://myhub.blog.csdn.net/");

        //加载assets文件夹下的文件(只需要文件名+.后缀就可以,内部已经封装好)
        //web.loadAssetsFile("index.html");


        //关于互调可以参考https://blog.csdn.net/qq_40881680/article/details/82755369

        //安卓调用JS
        //web.post("functionName()");

        //JS调用Android
        //webView.addJavascriptInterface(new MyObject(), "jsto");

        //最后提醒，记得加网络权限哦！<uses-permission android:name="android.permission.INTERNET" />

    }


    private void initView() {
        webView = (WebView) findViewById(R.id.webView);
    }
}
