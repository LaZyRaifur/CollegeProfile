package com.lazycoder.dashboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lsjwzh.widget.materialloadingprogressbar.CircleProgressBar;

public class GalleryActivity extends AppCompatActivity {

    CircleProgressBar circleProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        circleProgressBar = (CircleProgressBar) findViewById(R.id.progressBar);
        WebView webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        circleProgressBar.setVisibility(View.VISIBLE);
        CountDownTimer countDownTimer = new CountDownTimer(1100, 1000) {
            int progressValue = 0;

            @Override
            public void onTick(long l) {


                progressValue += 99;
                circleProgressBar.setProgress(progressValue);

                if (progressValue >= 100) {
                    circleProgressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFinish() {
                circleProgressBar.setVisibility(View.INVISIBLE);
            }
        }.start();

        webView.loadUrl("https://www.sbpgc.edu.bd/index.php?option=com_content&view=article&id=97&Itemid=234");
    }
}
