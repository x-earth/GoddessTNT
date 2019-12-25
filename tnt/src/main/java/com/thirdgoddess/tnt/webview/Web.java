package com.thirdgoddess.tnt.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.thirdgoddess.tnt.dialog.LoadDialog;

/**
 * @author ThirdGoddess
 * @email ofmyhub@gmail.com
 * @Github https://github.com/ThirdGoddess
 * @date :2019-12-16 19:44
 */
public class Web {

    //(默认)根据cache-control决定是否从网络上取数据
    public static final int LOAD_DEFAULT = -1;

    //只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;

    //不使用缓存，只从网络获取数据
    public static final int LOAD_NO_CACHE = 2;

    //不使用网络，只读取本地缓存数据
    public static final int LOAD_CACHE_ONLY = 3;

    //上下文
    private Context context;

    //WebView setting
    private WebSettings settings;

    //WebView
    private WebView webView;

    //Dialog
    private LoadDialog loadDialog;

    //是否开启加载框，默认false
    private boolean loadDialogStatus = true;

    private boolean keepView = false;

    private static final String mimeType = "text/html";
    private static final String enCoding = "utf-8";

    /**
     * 构造
     *
     * @param webView WebView控件
     */
    public Web(WebView webView) {
        this.webView = webView;
        this.settings = webView.getSettings();

    }

    /**
     * 构造
     *
     * @param context 上下文
     * @param webView WebView控件
     */
    public Web(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
        this.settings = webView.getSettings();
    }


    /**
     * 设置加载方式
     * 通过这一个方法可以设置是否加载缓存、是否直接加载网络
     * LOAD_DEFAULT (默认)根据cache-control决定是否从网络上取数据
     * LOAD_CACHE_ELSE_NETWORK 只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据
     * LOAD_NO_CACHE 不使用缓存，只从网络获取数据
     * LOAD_CACHE_ONLY 不使用网络，只读取本地缓存数据
     *
     * @param modle
     */
    public void setLoadModle(int modle) {
        if (settings != null) {
            settings.setCacheMode(modle);
        }
    }

    /**
     * 开启与JS交互(默认是关闭)
     */
    @SuppressLint("SetJavaScriptEnabled")
    public void setJs() {
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
    }

    /**
     * 设置自适应屏幕，两者合用
     * setUseWideViewPort：将图片调整到适合webview的大小
     * setLoadWithOverviewMode：缩放至屏幕的大小
     */
    public void setAdapt() {
        if (settings != null) {
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
        }

    }

    /**
     * setSupportZoom 支持缩放，默认为true。是下面那个的前提。
     * setBuiltInZoomControls 设置内置的缩放控件。若为false，则该WebView不可缩放
     * setDisplayZoomControls 隐藏原生的缩放控件
     */
    public void setZoom() {
        if (settings != null) {
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
        }
    }

    /**
     * 设置可以访问文件
     */
    public void setAccessFiles() {
        if (settings != null) {
            settings.setAllowFileAccess(true);
        }
    }

    /**
     * 支持通过JS打开新窗口
     */
    public void setJsOpenWindows() {
        if (settings != null) {
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
        }
    }


    /**
     * 设置编码格式
     */
    public void setUTF8() {
        if (settings != null) {
            settings.setDefaultTextEncodingName("utf-8");
        }
    }

    /**
     * 支持自动加载图片
     */
    public void setAutoLoadImage() {
        if (settings != null) {
            settings.setLoadsImagesAutomatically(true);
        }
    }

    /**
     * 开启加载框
     */
    public void setLoadDialog() {
        loadDialogStatus = true;
    }

    /**
     * 设置当前WebView是否支持跳转,默认不支持
     * true 支持
     * false 不支持
     *
     * @param keepView 当前WebView是否支持跳转,默认false
     */
    public void setKeepView(boolean keepView) {
        this.keepView = keepView;
    }

    /**
     * 加载网页
     *
     * @param url url地址
     */
    public void loadUrl(String url) {
        if (webView != null) {
            webView.loadUrl(url);
        }
    }

    /**
     * 加载 assets 下的文件
     *
     * @param fileName 文件名(加上后缀)
     */
    public void loadAssetsFile(String fileName) {
        if (webView != null && fileName != null) {
            webView.loadUrl("file:///android_asset/" + fileName);
        }
    }

    /**
     * WebView加载监听
     */
    public void setOnLoadListener() {
        if (webView != null) {
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    //开始加载
                    if (context != null && loadDialogStatus) {
                        loadDialog = new LoadDialog(context);
                        loadDialog.setTextGone(true);
                        loadDialog.show();
                    }

                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    //加载结束
                    if (context != null && loadDialogStatus && loadDialog != null) {
                        loadDialog.dismiss();
                    }
                }

                // 链接跳转都会走这个方法
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return true;
                }
            });
        }
    }

    /**
     * 取消当前WebView长按操作
     */
    public void setNoSelectionText() {
        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
    }

    /**
     * WebView加载监听
     */
    public void setOnLoadListener(final OnLoadListener onLoadListener) {
        if (webView != null) {
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    //开始加载
                    if (context != null && loadDialogStatus) {
                        loadDialog = new LoadDialog(context);
                        loadDialog.setTextGone(true);
                        loadDialog.show();
                    }
                    onLoadListener.onStart(view, url, favicon);

                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    //加载结束
                    if (context != null && loadDialogStatus) {
                        loadDialog.dismiss();
                    }
                    onLoadListener.onFinish(view, url);
                }

                // 链接跳转都会走这个方法
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    onLoadListener.urlLoading(view, url);
                    return keepView;
                }
            });
        }
    }

    /**
     * 监听WebView加载进度
     */
    public void setProgressListener(final OnProgressListener onProgressListener) {
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                onProgressListener.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                onProgressListener.onReceivedTitle(view, title);
            }
        });
    }

    /**
     * 调用Js某个方法
     *
     * @param function
     */
    public void post(final String function) {
        if (webView != null) {
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl("javascript:" + function);
                }
            });
        }
    }

    /**
     * 加载字符串
     *
     * @param url
     */
    public void loadString(String url) {
        if (webView != null) {
            webView.loadDataWithBaseURL(null, url, mimeType, enCoding, null);
        }
    }

    /**
     * 加载字符串
     *
     * @param url
     * @param mimeType
     * @param enCoding
     */
    public void loadString(String url, String mimeType, String enCoding) {
        if (webView != null) {
            webView.loadDataWithBaseURL(null, url, mimeType, enCoding, null);
        }
    }

    /**
     * 加载开始、完毕、跳转监听
     */
    public interface OnLoadListener {
        void onStart(WebView view, String url, Bitmap favicon);

        void onFinish(WebView view, String url);

        void urlLoading(WebView view, String url);
    }

    /**
     * 监听加载进度
     */
    public interface OnProgressListener {
        void onProgressChanged(WebView view, int newProgress);

        void onReceivedTitle(WebView view, String title);
    }


}
